/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadConsumoPorPiscinaPeriodo {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadConsumoPorPiscinaPeriodo() {
    }

//    public NumeroColumnaDesconocidadBalanceResultadoMensualizado(String[] columnas, Object[][] datos) {
//        this.columnas = columnas;
//        this.datos = datos;
//    }

    public String[] getColumnas() {
        return columnas;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public java.util.List<String> getColumnasFaltantes() {
        return columnasFaltantes;
    }

    public java.util.List<CostoPiscinaSemanalNombres> getListaProductos() {
        return listaProductos;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdConsumosPorPiscinaPeriodoTO> prdConsumosPorPiscinaPeriodoTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdConsumosPorPiscinaPeriodoTOs.size() > 0){
            columnasFaltantes.add(prdConsumosPorPiscinaPeriodoTOs.get(0).getConsumoFecha());
            for (int i = 1; i < prdConsumosPorPiscinaPeriodoTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoFecha().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoFecha());
                }
            }
            columnas = new String [3 + columnasFaltantes.size()];
            columnas[0] = "Producto";
            columnas[1] = "Código";
            columnas[2] = "Medida";
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 3] = columnasFaltantes.get(i).toString();
            }
        }
        

    }
    private java.util.List<CostoPiscinaSemanalNombres> listaProductos = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param prdConsumosPorPiscinaPeriodoTOs lista que viene de la consulta
     */
    public void agruparProductos(java.util.List<produccion.TO.PrdConsumosPorPiscinaPeriodoTO> prdConsumosPorPiscinaPeriodoTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (prdConsumosPorPiscinaPeriodoTOs.size() > 0){
            prdConsumosPorPiscinaPeriodoTOs.get(0).setConsumoCodigo(prdConsumosPorPiscinaPeriodoTOs.
                    get(0).getConsumoCodigo() == null ? "" : prdConsumosPorPiscinaPeriodoTOs.get(0).getConsumoCodigo());
            prdConsumosPorPiscinaPeriodoTOs.get(0).setConsumoProducto(prdConsumosPorPiscinaPeriodoTOs.
                    get(0).getConsumoProducto() == null ? "" : prdConsumosPorPiscinaPeriodoTOs.get(0).getConsumoProducto());
            prdConsumosPorPiscinaPeriodoTOs.get(0).setConsumoMedida(prdConsumosPorPiscinaPeriodoTOs.
                    get(0).getConsumoMedida() == null ? "" : prdConsumosPorPiscinaPeriodoTOs.get(0).getConsumoMedida());
            
            listaProductos.add(new CostoPiscinaSemanalNombres(prdConsumosPorPiscinaPeriodoTOs.get(0).getConsumoCodigo(),
                    prdConsumosPorPiscinaPeriodoTOs.get(0).getConsumoProducto(), prdConsumosPorPiscinaPeriodoTOs.get(0).getConsumoMedida()));
            for (int i = 1; i < prdConsumosPorPiscinaPeriodoTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    prdConsumosPorPiscinaPeriodoTOs.get(i).setConsumoCodigo(prdConsumosPorPiscinaPeriodoTOs.
                            get(i).getConsumoCodigo() == null ? "" : prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoCodigo());
                    prdConsumosPorPiscinaPeriodoTOs.get(i).setConsumoProducto(prdConsumosPorPiscinaPeriodoTOs.
                            get(i).getConsumoProducto() == null ? "" : prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoProducto());
                    prdConsumosPorPiscinaPeriodoTOs.get(i).setConsumoMedida(prdConsumosPorPiscinaPeriodoTOs.
                            get(i).getConsumoMedida() == null ? "" : prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoMedida());
                    if (prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoCodigo().concat(prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoProducto()).equals(
                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProductos.add(new CostoPiscinaSemanalNombres(prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoCodigo(),
                    prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoProducto(), prdConsumosPorPiscinaPeriodoTOs.get(i).getConsumoMedida()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdConsumosPorPiscinaPeriodoTO> prdConsumosPorPiscinaPeriodoTOs){
        if (prdConsumosPorPiscinaPeriodoTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getProducto();
                datos[i][1] = listaProductos.get(i).getCodigo();
                datos[i][2] = listaProductos.get(i).getMedida();
            }
            for (int h = 0; h < prdConsumosPorPiscinaPeriodoTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdConsumosPorPiscinaPeriodoTOs.get(h).getConsumoCodigo().concat(prdConsumosPorPiscinaPeriodoTOs.get(h).getConsumoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdConsumosPorPiscinaPeriodoTOs.get(h).getConsumoFecha().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 3] = prdConsumosPorPiscinaPeriodoTOs.get(h).getConsumoTotal();
                                j = columnasFaltantes.size();
                            }
                        }
                        i = datos.length;
                    }
                }
            }
            for (int i = 0; i < datos.length; i++){
                datos[i][0] = datos[i][0].toString().substring(datos[i][0].toString().indexOf("|") + 1);
            }
        }
    }
}
