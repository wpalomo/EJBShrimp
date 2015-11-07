/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadContabilizarTransferencias {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadContabilizarTransferencias() {
    }
    
    public String[] getColumnas() {
        return columnas;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public java.util.List<String> getColumnasFaltantes() {
        return columnasFaltantes;
    }

    public java.util.List<ContabilizarTransferenciasNombres> getListaProductos() {
        return listaProductos;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<contabilidad.TO.ConFunContabilizarTransferenciasTO> conFunContabilizarTransferenciasTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (conFunContabilizarTransferenciasTOs.size() > 0){
            columnasFaltantes.add(conFunContabilizarTransferenciasTOs.get(0).getCostoSectorPiscina());
            for (int i = 1; i < conFunContabilizarTransferenciasTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoSectorPiscina().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(conFunContabilizarTransferenciasTOs.get(i).getCostoSectorPiscina());
                }
            }
            columnas = new String [6 + columnasFaltantes.size()];
            columnas[0] = "Fecha";
            columnas[1] = "Producto";
            columnas[2] = "Código";
            columnas[3] = "Medida";
            columnas[4] = "Debito";
            columnas[5] = "Credito";
            
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 6] = columnasFaltantes.get(i).toString();
            }
        }
        

    }
    private java.util.List<ContabilizarTransferenciasNombres> listaProductos = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param conFunContabilizarTransferenciasTOs lista que viene de la consulta
     */
    public void agruparProductos(java.util.List<contabilidad.TO.ConFunContabilizarTransferenciasTO> conFunContabilizarTransferenciasTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (conFunContabilizarTransferenciasTOs.size() > 0){
            conFunContabilizarTransferenciasTOs.get(0).setCostoCodigo(conFunContabilizarTransferenciasTOs.
                    get(0).getCostoCodigo() == null ? "" : conFunContabilizarTransferenciasTOs.get(0).getCostoCodigo());
            conFunContabilizarTransferenciasTOs.get(0).setCostoProducto(conFunContabilizarTransferenciasTOs.
                    get(0).getCostoProducto() == null ? "" : conFunContabilizarTransferenciasTOs.get(0).getCostoProducto());
            conFunContabilizarTransferenciasTOs.get(0).setCostoMedida(conFunContabilizarTransferenciasTOs.
                    get(0).getCostoMedida() == null ? "" : conFunContabilizarTransferenciasTOs.get(0).getCostoMedida());
            
            conFunContabilizarTransferenciasTOs.get(0).setCostoCuentaD(conFunContabilizarTransferenciasTOs.
                    get(0).getCostoCuentaD() == null ? "" : conFunContabilizarTransferenciasTOs.get(0).getCostoCuentaD());
            
            conFunContabilizarTransferenciasTOs.get(0).setCostoCuentaC(conFunContabilizarTransferenciasTOs.
                    get(0).getCostoCuentaC() == null ? "" : conFunContabilizarTransferenciasTOs.get(0).getCostoCuentaC());
            
            listaProductos.add(new ContabilizarTransferenciasNombres(conFunContabilizarTransferenciasTOs.get(0).getCostoFecha(), 
                    conFunContabilizarTransferenciasTOs.get(0).getCostoCodigo(),
                    conFunContabilizarTransferenciasTOs.get(0).getCostoProducto(), conFunContabilizarTransferenciasTOs.get(0).getCostoMedida(), 
                    conFunContabilizarTransferenciasTOs.get(0).getCostoCuentaD(), conFunContabilizarTransferenciasTOs.get(0).getCostoCuentaC()));
            for (int i = 1; i < conFunContabilizarTransferenciasTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    conFunContabilizarTransferenciasTOs.get(i).setCostoCodigo(conFunContabilizarTransferenciasTOs.
                            get(i).getCostoCodigo() == null ? "" : conFunContabilizarTransferenciasTOs.get(i).getCostoCodigo());
                    conFunContabilizarTransferenciasTOs.get(i).setCostoProducto(conFunContabilizarTransferenciasTOs.
                            get(i).getCostoProducto() == null ? "" : conFunContabilizarTransferenciasTOs.get(i).getCostoProducto());
                    conFunContabilizarTransferenciasTOs.get(i).setCostoMedida(conFunContabilizarTransferenciasTOs.
                            get(i).getCostoMedida() == null ? "" : conFunContabilizarTransferenciasTOs.get(i).getCostoMedida());
                    conFunContabilizarTransferenciasTOs.get(i).setCostoCuentaD(conFunContabilizarTransferenciasTOs.
                            get(i).getCostoCuentaD() == null ? "" : conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD());
                    conFunContabilizarTransferenciasTOs.get(i).setCostoCuentaC(conFunContabilizarTransferenciasTOs.
                            get(i).getCostoCuentaC() == null ? "" : conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC());
                    if (conFunContabilizarTransferenciasTOs.get(i).getCostoFecha().concat(conFunContabilizarTransferenciasTOs.get(i).getCostoCodigo()).
                            concat(conFunContabilizarTransferenciasTOs.get(i).getCostoProducto()).equals(
                            listaProductos.get(j).getFecha().concat(listaProductos.get(j).getCodigo()).concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProductos.add(new ContabilizarTransferenciasNombres(conFunContabilizarTransferenciasTOs.get(i).getCostoFecha(), 
                            conFunContabilizarTransferenciasTOs.get(i).getCostoCodigo(),
                    conFunContabilizarTransferenciasTOs.get(i).getCostoProducto(), conFunContabilizarTransferenciasTOs.get(i).getCostoMedida(),
                            conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaD(), conFunContabilizarTransferenciasTOs.get(i).getCostoCuentaC()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<contabilidad.TO.ConFunContabilizarTransferenciasTO> prdCostoPorFechaProrrateadoTOs){
        if (prdCostoPorFechaProrrateadoTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getFecha();
                datos[i][1] = listaProductos.get(i).getProducto();
                datos[i][2] = listaProductos.get(i).getCodigo();
                datos[i][3] = listaProductos.get(i).getMedida();
                datos[i][4] = listaProductos.get(i).getCuentaDebito();
                datos[i][5] = listaProductos.get(i).getCuentaCredito();
            }

            for (int h = 0; h < prdCostoPorFechaProrrateadoTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){

                    if (prdCostoPorFechaProrrateadoTOs.get(h).getCostoFecha().concat(prdCostoPorFechaProrrateadoTOs.get(h).getCostoCodigo()).concat(prdCostoPorFechaProrrateadoTOs.get(h).getCostoProducto()).
                            equals(datos[i][0].toString().concat(datos[i][2].toString()).concat(datos[i][1].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdCostoPorFechaProrrateadoTOs.get(h).getCostoSectorPiscina().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 6] = prdCostoPorFechaProrrateadoTOs.get(h).getCostoTotal();
                                j = columnasFaltantes.size();
                            }
                        }
                        i = datos.length;
                    }
                }
            }
            for (int i = 0; i < datos.length; i++){
                datos[i][1] = datos[i][1].toString().substring(datos[i][1].toString().indexOf("|") + 1);
            }
        }
    }
}
