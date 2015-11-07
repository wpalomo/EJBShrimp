/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadConsumoMultiplePiscina {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadConsumoMultiplePiscina() {
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

    public java.util.List<CostoSectorPiscinaNombres> getListaProductos() {
        return listaProductos;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdConsumoMultiplePiscinaTO> prdConsumoMultiplePiscinaTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdConsumoMultiplePiscinaTOs.size() > 0){
            columnasFaltantes.add(prdConsumoMultiplePiscinaTOs.get(0).getConsumoSector());
            for (int i = 1; i < prdConsumoMultiplePiscinaTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdConsumoMultiplePiscinaTOs.get(i).getConsumoSector().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdConsumoMultiplePiscinaTOs.get(i).getConsumoSector());
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
    private java.util.List<CostoSectorPiscinaNombres> listaProductos = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param prdConsumoMultiplePiscinaTOs lista que viene de la consulta
     */
    public void agruparProductos(java.util.List<produccion.TO.PrdConsumoMultiplePiscinaTO> prdConsumoMultiplePiscinaTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (prdConsumoMultiplePiscinaTOs.size() > 0){
            prdConsumoMultiplePiscinaTOs.get(0).setConsumoCodigo(prdConsumoMultiplePiscinaTOs.
                    get(0).getConsumoCodigo() == null ? "" : prdConsumoMultiplePiscinaTOs.get(0).getConsumoCodigo());
            prdConsumoMultiplePiscinaTOs.get(0).setConsumoProducto(prdConsumoMultiplePiscinaTOs.
                    get(0).getConsumoProducto() == null ? "" : prdConsumoMultiplePiscinaTOs.get(0).getConsumoProducto());
            prdConsumoMultiplePiscinaTOs.get(0).setConsumoMedida(prdConsumoMultiplePiscinaTOs.
                    get(0).getConsumoMedida() == null ? "" : prdConsumoMultiplePiscinaTOs.get(0).getConsumoMedida());
            
            listaProductos.add(new CostoSectorPiscinaNombres(prdConsumoMultiplePiscinaTOs.get(0).getConsumoCodigo(),
                    prdConsumoMultiplePiscinaTOs.get(0).getConsumoProducto(), prdConsumoMultiplePiscinaTOs.get(0).getConsumoMedida()));
            for (int i = 1; i < prdConsumoMultiplePiscinaTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    prdConsumoMultiplePiscinaTOs.get(i).setConsumoCodigo(prdConsumoMultiplePiscinaTOs.
                            get(i).getConsumoCodigo() == null ? "" : prdConsumoMultiplePiscinaTOs.get(i).getConsumoCodigo());
                    prdConsumoMultiplePiscinaTOs.get(i).setConsumoProducto(prdConsumoMultiplePiscinaTOs.
                            get(i).getConsumoProducto() == null ? "" : prdConsumoMultiplePiscinaTOs.get(i).getConsumoProducto());
                    prdConsumoMultiplePiscinaTOs.get(i).setConsumoMedida(prdConsumoMultiplePiscinaTOs.
                            get(i).getConsumoMedida() == null ? "" : prdConsumoMultiplePiscinaTOs.get(i).getConsumoMedida());
                    if (prdConsumoMultiplePiscinaTOs.get(i).getConsumoCodigo().concat(prdConsumoMultiplePiscinaTOs.get(i).getConsumoProducto()).equals(
                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProductos.add(new CostoSectorPiscinaNombres(prdConsumoMultiplePiscinaTOs.get(i).getConsumoCodigo(),
                    prdConsumoMultiplePiscinaTOs.get(i).getConsumoProducto(), prdConsumoMultiplePiscinaTOs.get(i).getConsumoMedida()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdConsumoMultiplePiscinaTO> prdConsumoMultiplePiscinaTOs){
        if (prdConsumoMultiplePiscinaTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getProducto();
                datos[i][1] = listaProductos.get(i).getCodigo();
                datos[i][2] = listaProductos.get(i).getMedida();
            }

            for (int h = 0; h < prdConsumoMultiplePiscinaTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdConsumoMultiplePiscinaTOs.get(h).getConsumoCodigo().concat(prdConsumoMultiplePiscinaTOs.get(h).getConsumoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdConsumoMultiplePiscinaTOs.get(h).getConsumoSector().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 3] = prdConsumoMultiplePiscinaTOs.get(h).getConsumoCantidad();
                                j = columnasFaltantes.size();
                            }
                        }
                        i = datos.length;
                    }
                }
            }
//            for (int i = 0; i < datos.length; i++){
//                datos[i][0] = datos[i][0].toString().substring(datos[i][0].toString().indexOf("|") + 1);
//            }
        }
    }
}
