/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author carlos
 */
public class NumeroColumnaDesconocidadGrameajePromedioPorPiscina {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadGrameajePromedioPorPiscina() {
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

    public java.util.List<PiscinaNombres> getListaPiscinaNombres() {
        return listaPiscinaNombres;
    }
//    public java.util.List<CostoSectorPiscinaNombres> getListaProductos() {
//        return listaProductos;
//    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> prdListaConsultaGrameajePromedioPorPiscinaTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdListaConsultaGrameajePromedioPorPiscinaTOs.size() > 0){
            columnasFaltantes.add(prdListaConsultaGrameajePromedioPorPiscinaTOs.get(0).getGraFecha());
            for (int i = 1; i < prdListaConsultaGrameajePromedioPorPiscinaTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraFecha().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraFecha());
                }
            }
            columnas = new String [3 + columnasFaltantes.size()];
            columnas[0] = "Piscina";
            columnas[1] = "Fecha Siembra";
            columnas[2] = "Edad";
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 3] = columnasFaltantes.get(i).toString();
            }
        }

    }
    //private java.util.List<CostoSectorPiscinaNombres> listaProductos = null;
    private java.util.List<PiscinaNombres> listaPiscinaNombres = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param prdCostoPorFechaProrrateadoTOs lista que viene de la consulta
     */
    public void agruparPisina(java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> prdListaConsultaGrameajePromedioPorPiscinaTOs){
        listaPiscinaNombres = new java.util.ArrayList();
        boolean encontro = false;
        if (prdListaConsultaGrameajePromedioPorPiscinaTOs.size() > 0){
            prdListaConsultaGrameajePromedioPorPiscinaTOs.get(0).setGraPiscina(prdListaConsultaGrameajePromedioPorPiscinaTOs.
                    get(0).getGraPiscina() == null ? "" : prdListaConsultaGrameajePromedioPorPiscinaTOs.get(0).getGraPiscina());
            listaPiscinaNombres.add(new PiscinaNombres(
                    prdListaConsultaGrameajePromedioPorPiscinaTOs.get(0).getGraPiscina(),
                    prdListaConsultaGrameajePromedioPorPiscinaTOs.get(0).getGraEdad(),
                    prdListaConsultaGrameajePromedioPorPiscinaTOs.get(0).getCorFechaSiembra()));
            for (int i = 1; i < prdListaConsultaGrameajePromedioPorPiscinaTOs.size(); i++){
                for (int j = 0; j < listaPiscinaNombres.size(); j++){
                    prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).setGraPiscina(prdListaConsultaGrameajePromedioPorPiscinaTOs.
                            get(i).getGraPiscina() == null ? "" : prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraPiscina());
                    prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).setGraEdad(prdListaConsultaGrameajePromedioPorPiscinaTOs.
                            get(i).getGraEdad() == null ? "" : prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraEdad());
                    prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).setCorFechaSiembra(prdListaConsultaGrameajePromedioPorPiscinaTOs.
                            get(i).getCorFechaSiembra() == null ? "" : prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getCorFechaSiembra());
                    if (prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraPiscina().concat(prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraPiscina()).equals(
                            listaPiscinaNombres.get(j).getGraPiscina().concat(listaPiscinaNombres.get(j).getGraPiscina()))){
                        encontro = true;
                        j = listaPiscinaNombres.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaPiscinaNombres.add(new PiscinaNombres(
                            prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraPiscina(),
                            prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getGraEdad(),
                            prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getCorFechaSiembra()));
                    //prdListaConsultaGrameajePromedioPorPiscinaTOs.get(i).getCostoProducto(), prdCostoPorFechaProrrateadoTOs.get(i).getCostoMedida()));
                }
            }
        }
    }
    
//    public void agruparProductos2(java.util.List<produccion.TO.PrdCostoPorFechaProrrateadoTO> prdCostoPorFechaProrrateadoTOs){
//        listaProductos = new java.util.ArrayList();
//        boolean encontro = false;
//        if (prdCostoPorFechaProrrateadoTOs.size() > 0){
//            
//            prdCostoPorFechaProrrateadoTOs.get(0).setCostoCodigo(prdCostoPorFechaProrrateadoTOs.
//                    get(0).getCostoCodigo() == null ? "" : prdCostoPorFechaProrrateadoTOs.get(0).getCostoCodigo());
//            
//            prdCostoPorFechaProrrateadoTOs.get(0).setCostoProducto(prdCostoPorFechaProrrateadoTOs.
//                    get(0).getCostoProducto() == null ? "" : prdCostoPorFechaProrrateadoTOs.get(0).getCostoProducto());
//            
//            prdCostoPorFechaProrrateadoTOs.get(0).setCostoMedida(prdCostoPorFechaProrrateadoTOs.
//                    get(0).getCostoMedida() == null ? "" : prdCostoPorFechaProrrateadoTOs.get(0).getCostoMedida());
//            
//            
//            listaProductos.add(new CostoSectorPiscinaNombres(prdCostoPorFechaProrrateadoTOs.get(0).getCostoCodigo(),
//                    prdCostoPorFechaProrrateadoTOs.get(0).getCostoProducto(), prdCostoPorFechaProrrateadoTOs.get(0).getCostoMedida()));
//            
//            for (int i = 1; i < prdCostoPorFechaProrrateadoTOs.size(); i++){
//                for (int j = 0; j < listaProductos.size(); j++){
//                    prdCostoPorFechaProrrateadoTOs.get(i).setCostoCodigo(prdCostoPorFechaProrrateadoTOs.
//                            get(i).getCostoCodigo() == null ? "" : prdCostoPorFechaProrrateadoTOs.get(i).getCostoCodigo());
//                    
//                    prdCostoPorFechaProrrateadoTOs.get(i).setCostoProducto(prdCostoPorFechaProrrateadoTOs.
//                            get(i).getCostoProducto() == null ? "" : prdCostoPorFechaProrrateadoTOs.get(i).getCostoProducto());
//                    
//                    prdCostoPorFechaProrrateadoTOs.get(i).setCostoMedida(prdCostoPorFechaProrrateadoTOs.
//                            get(i).getCostoMedida() == null ? "" : prdCostoPorFechaProrrateadoTOs.get(i).getCostoMedida());
//                    
//                    if (prdCostoPorFechaProrrateadoTOs.get(i).getCostoCodigo().concat(prdCostoPorFechaProrrateadoTOs.get(i).getCostoProducto()).equals(
//                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
//                        encontro = true;
//                        j = listaProductos.size();
//                    } else {
//                        encontro = false;
//                    }
//                }
//                if (!encontro){
//                    listaProductos.add(new CostoSectorPiscinaNombres(prdCostoPorFechaProrrateadoTOs.get(i).getCostoCodigo(),
//                    prdCostoPorFechaProrrateadoTOs.get(i).getCostoProducto(), prdCostoPorFechaProrrateadoTOs.get(i).getCostoMedida()));
//                }
//            }
//        }
//    }

 public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdListaConsultaGrameajePromedioPorPiscinaTO> prdListaConsultaGrameajePromedioPorPiscinaTOs){
        if (prdListaConsultaGrameajePromedioPorPiscinaTOs.size() > 0){
            datos = new Object[listaPiscinaNombres.size()][columnas.length];
            for (int i = 0; i < listaPiscinaNombres.size(); i++){
                datos[i][0] = listaPiscinaNombres.get(i).getGraPiscina();
                datos[i][1] = listaPiscinaNombres.get(i).getCorFechaSiembra();
                datos[i][2] = listaPiscinaNombres.get(i).getGraEdad();
            }
            for (int h = 0; h < prdListaConsultaGrameajePromedioPorPiscinaTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdListaConsultaGrameajePromedioPorPiscinaTOs.get(h).getGraPiscina().equals(datos[i][0].toString())){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdListaConsultaGrameajePromedioPorPiscinaTOs.get(h).getGraFecha().
                                    equals(columnasFaltantes.get(j).toString())){                    
                                datos[i][j + 3] = prdListaConsultaGrameajePromedioPorPiscinaTOs.get(h).getGraTPromedio();
                                j = columnasFaltantes.size();
                            }
                        }
                        i = datos.length;
                    }
                }
            }
//            for (int i = 0; i < datos.length; i++){
//                    datos[i][0] = datos[i][0].toString().substring(datos[i][0].toString().indexOf("|") + 1);
//            }
        }
    }
//    public void llenarObjetoParaTabla2(java.util.List<produccion.TO.PrdCostoPorFechaProrrateadoTO> prdCostoPorFechaProrrateadoTOs){
//        if (prdCostoPorFechaProrrateadoTOs.size() > 0){
//            datos = new Object[listaProductos.size()][columnas.length];
//            for (int i = 0; i < listaProductos.size(); i++){
//                datos[i][0] = listaProductos.get(i).getProducto();
//                datos[i][1] = listaProductos.get(i).getCodigo();
//                datos[i][2] = listaProductos.get(i).getMedida();
//            }
//
//            for (int h = 0; h < prdCostoPorFechaProrrateadoTOs.size(); h++){
//                for (int i = 0; i < datos.length; i++){
//                    if (prdCostoPorFechaProrrateadoTOs.get(h).getCostoCodigo().concat(prdCostoPorFechaProrrateadoTOs.get(h).getCostoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
//                        for (int j = 0; j < columnasFaltantes.size(); j++){
//                            if (prdCostoPorFechaProrrateadoTOs.get(h).getCostoSectorPiscina().
//                                    equals(columnasFaltantes.get(j).toString())){                                
//                                datos[i][j + 3] = prdCostoPorFechaProrrateadoTOs.get(h).getCostoTotal();
//                                j = columnasFaltantes.size();
//                            }
//                        }
//                        i = datos.length;
//                    }
//                }
//            }
//            for (int i = 0; i < datos.length; i++){
//                datos[i][0] = datos[i][0].toString().substring(datos[i][0].toString().indexOf("|") + 1);
//            }
//        }
//    }
    
    
}
