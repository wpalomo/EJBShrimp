/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadCostoPorPiscinalSemanal {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadCostoPorPiscinalSemanal() {
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
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdCostoPorPiscinaSemanalTO> prdCostoPorPiscinaSemanalTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdCostoPorPiscinaSemanalTOs.size() > 0){
            columnasFaltantes.add(prdCostoPorPiscinaSemanalTOs.get(0).getCostoSemana());
            for (int i = 1; i < prdCostoPorPiscinaSemanalTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdCostoPorPiscinaSemanalTOs.get(i).getCostoSemana().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdCostoPorPiscinaSemanalTOs.get(i).getCostoSemana());
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
     * @param prdCostoPorPiscinaSemanalTOs lista que viene de la consulta
     */
    public void agruparProductos(java.util.List<produccion.TO.PrdCostoPorPiscinaSemanalTO> prdCostoPorPiscinaSemanalTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (prdCostoPorPiscinaSemanalTOs.size() > 0){
            prdCostoPorPiscinaSemanalTOs.get(0).setCostoCodigo(prdCostoPorPiscinaSemanalTOs.
                    get(0).getCostoCodigo() == null ? "" : prdCostoPorPiscinaSemanalTOs.get(0).getCostoCodigo());
            prdCostoPorPiscinaSemanalTOs.get(0).setCostoProducto(prdCostoPorPiscinaSemanalTOs.
                    get(0).getCostoProducto() == null ? "" : prdCostoPorPiscinaSemanalTOs.get(0).getCostoProducto());
            prdCostoPorPiscinaSemanalTOs.get(0).setCostoMedida(prdCostoPorPiscinaSemanalTOs.
                    get(0).getCostoMedida() == null ? "" : prdCostoPorPiscinaSemanalTOs.get(0).getCostoMedida());
            
            listaProductos.add(new CostoPiscinaSemanalNombres(prdCostoPorPiscinaSemanalTOs.get(0).getCostoCodigo(),
                    prdCostoPorPiscinaSemanalTOs.get(0).getCostoProducto(), prdCostoPorPiscinaSemanalTOs.get(0).getCostoMedida()));
            for (int i = 1; i < prdCostoPorPiscinaSemanalTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    prdCostoPorPiscinaSemanalTOs.get(i).setCostoCodigo(prdCostoPorPiscinaSemanalTOs.
                            get(i).getCostoCodigo() == null ? "" : prdCostoPorPiscinaSemanalTOs.get(i).getCostoCodigo());
                    prdCostoPorPiscinaSemanalTOs.get(i).setCostoProducto(prdCostoPorPiscinaSemanalTOs.
                            get(i).getCostoProducto() == null ? "" : prdCostoPorPiscinaSemanalTOs.get(i).getCostoProducto());
                    prdCostoPorPiscinaSemanalTOs.get(i).setCostoMedida(prdCostoPorPiscinaSemanalTOs.
                            get(i).getCostoMedida() == null ? "" : prdCostoPorPiscinaSemanalTOs.get(i).getCostoMedida());
                    if (prdCostoPorPiscinaSemanalTOs.get(i).getCostoCodigo().concat(prdCostoPorPiscinaSemanalTOs.get(i).getCostoProducto()).equals(
                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProductos.add(new CostoPiscinaSemanalNombres(prdCostoPorPiscinaSemanalTOs.get(i).getCostoCodigo(),
                    prdCostoPorPiscinaSemanalTOs.get(i).getCostoProducto(), prdCostoPorPiscinaSemanalTOs.get(i).getCostoMedida()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdCostoPorPiscinaSemanalTO> prdCostoPorPiscinaSemanalTOs){
        if (prdCostoPorPiscinaSemanalTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getProducto();
                datos[i][1] = listaProductos.get(i).getCodigo();
                datos[i][2] = listaProductos.get(i).getMedida();
            }

            for (int h = 0; h < prdCostoPorPiscinaSemanalTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdCostoPorPiscinaSemanalTOs.get(h).getCostoCodigo().concat(prdCostoPorPiscinaSemanalTOs.get(h).getCostoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdCostoPorPiscinaSemanalTOs.get(h).getCostoSemana().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 3] = prdCostoPorPiscinaSemanalTOs.get(h).getCostoTotal();
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
