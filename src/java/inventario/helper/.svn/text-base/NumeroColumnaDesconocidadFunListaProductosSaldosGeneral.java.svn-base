/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.helper;

import produccion.helper.*;

/**
 *
 * @author charly
 */
public class NumeroColumnaDesconocidadFunListaProductosSaldosGeneral {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadFunListaProductosSaldosGeneral() {
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

    public java.util.List<CostoSaldoBodegasNombres> getListaProductos() {
        return listaProductos;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<inventario.TO.InvFunListaProductosSaldosGeneralTO> funListaProductosSaldosGeneralTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (funListaProductosSaldosGeneralTOs.size() > 0){
            columnasFaltantes.add(funListaProductosSaldosGeneralTOs.get(0).getLpspBodega());
            for (int i = 1; i < funListaProductosSaldosGeneralTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (funListaProductosSaldosGeneralTOs.get(i).getLpspBodega().equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;
                    }
                }
                if (!encontro){
                   columnasFaltantes.add(funListaProductosSaldosGeneralTOs.get(i).getLpspBodega());
                   //columnasFaltantes.add("COLUMNA");
                }
            }
            columnas = new String [2 + columnasFaltantes.size()];
            columnas[0] = "Producto";
            columnas[1] = "Código";
            //columnas[2] = "IVA";
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 2] = columnasFaltantes.get(i).toString();
            }
        }

    }
    private java.util.List<CostoSaldoBodegasNombres> listaProductos = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param prdFunListaProductosSaldosGeneralTOs lista que viene de la consulta
     */
    public void agruparProductos(java.util.List<inventario.TO.InvFunListaProductosSaldosGeneralTO> prdFunListaProductosSaldosGeneralTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (prdFunListaProductosSaldosGeneralTOs.size() > 0){
            prdFunListaProductosSaldosGeneralTOs.get(0).setLpspCodigoPrincipal(prdFunListaProductosSaldosGeneralTOs.
                    get(0).getLpspCodigoPrincipal() == null ? "" : prdFunListaProductosSaldosGeneralTOs.get(0).getLpspCodigoPrincipal());
            
            prdFunListaProductosSaldosGeneralTOs.get(0).setLpspNombre(prdFunListaProductosSaldosGeneralTOs.
                    get(0).getLpspNombre() == null ? "" : prdFunListaProductosSaldosGeneralTOs.get(0).getLpspNombre());
            
            prdFunListaProductosSaldosGeneralTOs.get(0).setLpspIva(prdFunListaProductosSaldosGeneralTOs.get(0).getLpspIva());
            
            listaProductos.add(new CostoSaldoBodegasNombres(prdFunListaProductosSaldosGeneralTOs.get(0).getLpspCodigoPrincipal(),
                    prdFunListaProductosSaldosGeneralTOs.get(0).getLpspNombre()));
            
            /*listaProductos.add(new CostoSaldoBodegasNombres(prdFunListaProductosSaldosGeneralTOs.get(0).getLpspCodigoPrincipal(),
                    prdFunListaProductosSaldosGeneralTOs.get(0).getLpspNombre(), prdFunListaProductosSaldosGeneralTOs.get(0).getLpspIva()));*/
            
            
            for (int i = 1; i < prdFunListaProductosSaldosGeneralTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    prdFunListaProductosSaldosGeneralTOs.get(i).setLpspCodigoPrincipal(prdFunListaProductosSaldosGeneralTOs.
                            get(i).getLpspCodigoPrincipal() == null ? "" : prdFunListaProductosSaldosGeneralTOs.get(i).getLpspCodigoPrincipal());
                    
                    prdFunListaProductosSaldosGeneralTOs.get(i).setLpspNombre(prdFunListaProductosSaldosGeneralTOs.
                            get(i).getLpspNombre() == null ? "" : prdFunListaProductosSaldosGeneralTOs.get(i).getLpspNombre());
                    
                   prdFunListaProductosSaldosGeneralTOs.get(i).setLpspIva(prdFunListaProductosSaldosGeneralTOs.get(i).getLpspIva());
                    if (prdFunListaProductosSaldosGeneralTOs.get(i).getLpspCodigoPrincipal().concat(prdFunListaProductosSaldosGeneralTOs.get(i).getLpspNombre()).equals(
                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                
                if (!encontro){                    
                    listaProductos.add(new CostoSaldoBodegasNombres(prdFunListaProductosSaldosGeneralTOs.get(i).getLpspCodigoPrincipal(),
                    prdFunListaProductosSaldosGeneralTOs.get(i).getLpspNombre()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<inventario.TO.InvFunListaProductosSaldosGeneralTO> prdFunListaProductosSaldosGeneralTOsConsumoPorFechaDesglosadoTOs){
        if (prdFunListaProductosSaldosGeneralTOsConsumoPorFechaDesglosadoTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getProducto();
                datos[i][1] = listaProductos.get(i).getCodigo();
                
            }

            for (int h = 0; h < prdFunListaProductosSaldosGeneralTOsConsumoPorFechaDesglosadoTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdFunListaProductosSaldosGeneralTOsConsumoPorFechaDesglosadoTOs.get(h).getLpspCodigoPrincipal().concat(
                            prdFunListaProductosSaldosGeneralTOsConsumoPorFechaDesglosadoTOs.get(h).getLpspNombre()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdFunListaProductosSaldosGeneralTOsConsumoPorFechaDesglosadoTOs.get(h).getLpspBodega().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 2] = prdFunListaProductosSaldosGeneralTOsConsumoPorFechaDesglosadoTOs.get(h).getLpspSaldo();
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
