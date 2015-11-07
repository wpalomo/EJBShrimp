/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadConsumoProductoEnProceso {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadConsumoProductoEnProceso() {
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
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> prdConsumoProductoEnProcesoTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdConsumoProductoEnProcesoTOs.size() > 0){
            columnasFaltantes.add(prdConsumoProductoEnProcesoTOs.get(0).getConsumoSector());
            for (int i = 1; i < prdConsumoProductoEnProcesoTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdConsumoProductoEnProcesoTOs.get(i).getConsumoSector().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdConsumoProductoEnProcesoTOs.get(i).getConsumoSector());
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
     * @param prdConsumoProductoEnProcesoTOs lista que viene de la consulta
     */
    public void agruparProductos(java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> prdConsumoProductoEnProcesoTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (prdConsumoProductoEnProcesoTOs.size() > 0){
            prdConsumoProductoEnProcesoTOs.get(0).setConsumoCodigo(prdConsumoProductoEnProcesoTOs.
                    get(0).getConsumoCodigo() == null ? "" : prdConsumoProductoEnProcesoTOs.get(0).getConsumoCodigo());
            prdConsumoProductoEnProcesoTOs.get(0).setConsumoProducto(prdConsumoProductoEnProcesoTOs.
                    get(0).getConsumoProducto() == null ? "" : prdConsumoProductoEnProcesoTOs.get(0).getConsumoProducto());
            prdConsumoProductoEnProcesoTOs.get(0).setConsumoMedida(prdConsumoProductoEnProcesoTOs.
                    get(0).getConsumoMedida() == null ? "" : prdConsumoProductoEnProcesoTOs.get(0).getConsumoMedida());
            
            listaProductos.add(new CostoSectorPiscinaNombres(prdConsumoProductoEnProcesoTOs.get(0).getConsumoCodigo(),
                    prdConsumoProductoEnProcesoTOs.get(0).getConsumoProducto(), prdConsumoProductoEnProcesoTOs.get(0).getConsumoMedida()));
            for (int i = 1; i < prdConsumoProductoEnProcesoTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    prdConsumoProductoEnProcesoTOs.get(i).setConsumoCodigo(prdConsumoProductoEnProcesoTOs.
                            get(i).getConsumoCodigo() == null ? "" : prdConsumoProductoEnProcesoTOs.get(i).getConsumoCodigo());
                    prdConsumoProductoEnProcesoTOs.get(i).setConsumoProducto(prdConsumoProductoEnProcesoTOs.
                            get(i).getConsumoProducto() == null ? "" : prdConsumoProductoEnProcesoTOs.get(i).getConsumoProducto());
                    prdConsumoProductoEnProcesoTOs.get(i).setConsumoMedida(prdConsumoProductoEnProcesoTOs.
                            get(i).getConsumoMedida() == null ? "" : prdConsumoProductoEnProcesoTOs.get(i).getConsumoMedida());
                    if (prdConsumoProductoEnProcesoTOs.get(i).getConsumoCodigo().concat(prdConsumoProductoEnProcesoTOs.get(i).getConsumoProducto()).equals(
                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProductos.add(new CostoSectorPiscinaNombres(prdConsumoProductoEnProcesoTOs.get(i).getConsumoCodigo(),
                    prdConsumoProductoEnProcesoTOs.get(i).getConsumoProducto(), prdConsumoProductoEnProcesoTOs.get(i).getConsumoMedida()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdConsumoProductoEnProcesoTO> prdConsumoProductoEnProcesoTOs){
        if (prdConsumoProductoEnProcesoTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getProducto();
                datos[i][1] = listaProductos.get(i).getCodigo();
                datos[i][2] = listaProductos.get(i).getMedida();
            }

            for (int h = 0; h < prdConsumoProductoEnProcesoTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdConsumoProductoEnProcesoTOs.get(h).getConsumoCodigo().concat(prdConsumoProductoEnProcesoTOs.get(h).getConsumoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdConsumoProductoEnProcesoTOs.get(h).getConsumoSector().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 3] = prdConsumoProductoEnProcesoTOs.get(h).getConsumoCantidad();
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
