/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadConsumoPorFechaDesglosado {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadConsumoPorFechaDesglosado() {
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
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdConsumoPorFechaDesglosadoTO> prdConsumoPorFechaDesglosadoTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdConsumoPorFechaDesglosadoTOs.size() > 0){
            columnasFaltantes.add(prdConsumoPorFechaDesglosadoTOs.get(0).getConsumoSector());
            for (int i = 1; i < prdConsumoPorFechaDesglosadoTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoSector().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoSector());
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
        

//        }
    }
    private java.util.List<CostoSectorPiscinaNombres> listaProductos = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param prdConsumoPorFechaDesglosadoTOs lista que viene de la consulta
     */
    public void agruparProductos(java.util.List<produccion.TO.PrdConsumoPorFechaDesglosadoTO> prdConsumoPorFechaDesglosadoTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (prdConsumoPorFechaDesglosadoTOs.size() > 0){
            prdConsumoPorFechaDesglosadoTOs.get(0).setConsumoCodigo(prdConsumoPorFechaDesglosadoTOs.
                    get(0).getConsumoCodigo() == null ? "" : prdConsumoPorFechaDesglosadoTOs.get(0).getConsumoCodigo());
            prdConsumoPorFechaDesglosadoTOs.get(0).setConsumoProducto(prdConsumoPorFechaDesglosadoTOs.
                    get(0).getConsumoProducto() == null ? "" : prdConsumoPorFechaDesglosadoTOs.get(0).getConsumoProducto());
            prdConsumoPorFechaDesglosadoTOs.get(0).setConsumoMedida(prdConsumoPorFechaDesglosadoTOs.
                    get(0).getConsumoMedida() == null ? "" : prdConsumoPorFechaDesglosadoTOs.get(0).getConsumoMedida());
            
            listaProductos.add(new CostoSectorPiscinaNombres(prdConsumoPorFechaDesglosadoTOs.get(0).getConsumoCodigo(),
                    prdConsumoPorFechaDesglosadoTOs.get(0).getConsumoProducto(), prdConsumoPorFechaDesglosadoTOs.get(0).getConsumoMedida()));
            for (int i = 1; i < prdConsumoPorFechaDesglosadoTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    prdConsumoPorFechaDesglosadoTOs.get(i).setConsumoCodigo(prdConsumoPorFechaDesglosadoTOs.
                            get(i).getConsumoCodigo() == null ? "" : prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoCodigo());
                    prdConsumoPorFechaDesglosadoTOs.get(i).setConsumoProducto(prdConsumoPorFechaDesglosadoTOs.
                            get(i).getConsumoProducto() == null ? "" : prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoProducto());
                    prdConsumoPorFechaDesglosadoTOs.get(i).setConsumoMedida(prdConsumoPorFechaDesglosadoTOs.
                            get(i).getConsumoMedida() == null ? "" : prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoMedida());
                    if (prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoCodigo().concat(prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoProducto()).equals(
                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProductos.add(new CostoSectorPiscinaNombres(prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoCodigo(),
                    prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoProducto(), prdConsumoPorFechaDesglosadoTOs.get(i).getConsumoMedida()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdConsumoPorFechaDesglosadoTO> prdConsumoPorFechaDesglosadoTOs){
        if (prdConsumoPorFechaDesglosadoTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getProducto();
                datos[i][1] = listaProductos.get(i).getCodigo();
                datos[i][2] = listaProductos.get(i).getMedida();
            }

            for (int h = 0; h < prdConsumoPorFechaDesglosadoTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdConsumoPorFechaDesglosadoTOs.get(h).getConsumoCodigo().concat(prdConsumoPorFechaDesglosadoTOs.get(h).getConsumoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdConsumoPorFechaDesglosadoTOs.get(h).getConsumoSector().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 3] = prdConsumoPorFechaDesglosadoTOs.get(h).getConsumoTotal();
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
