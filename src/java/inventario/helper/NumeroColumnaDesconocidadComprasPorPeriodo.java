/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.helper;

import produccion.helper.*;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadComprasPorPeriodo {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadComprasPorPeriodo() {
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
    
    public void agruparCabeceraColumnas(java.util.List<inventario.TO.InvComprasPorPeriodoTO> prdComprasPorPeriodoTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdComprasPorPeriodoTOs.size() > 0){
            columnasFaltantes.add(prdComprasPorPeriodoTOs.get(0).getConsumoFecha());
            for (int i = 1; i < prdComprasPorPeriodoTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdComprasPorPeriodoTOs.get(i).getConsumoFecha().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdComprasPorPeriodoTOs.get(i).getConsumoFecha());
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
     * @param prdComprasPorPeriodoTOs lista que viene de la consulta
     */
        public void agruparProductos(java.util.List<inventario.TO.InvComprasPorPeriodoTO> prdComprasPorPeriodoTOs){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        if (prdComprasPorPeriodoTOs.size() > 0){
            prdComprasPorPeriodoTOs.get(0).setConsumoCodigo(prdComprasPorPeriodoTOs.
                    get(0).getConsumoCodigo() == null ? "" : prdComprasPorPeriodoTOs.get(0).getConsumoCodigo());
            prdComprasPorPeriodoTOs.get(0).setConsumoProducto(prdComprasPorPeriodoTOs.
                    get(0).getConsumoProducto() == null ? "" : prdComprasPorPeriodoTOs.get(0).getConsumoProducto());
            prdComprasPorPeriodoTOs.get(0).setConsumoMedida(prdComprasPorPeriodoTOs.
                    get(0).getConsumoMedida() == null ? "" : prdComprasPorPeriodoTOs.get(0).getConsumoMedida());
            
            listaProductos.add(new CostoPiscinaSemanalNombres(prdComprasPorPeriodoTOs.get(0).getConsumoCodigo(),
                    prdComprasPorPeriodoTOs.get(0).getConsumoProducto(), prdComprasPorPeriodoTOs.get(0).getConsumoMedida()));
            for (int i = 1; i < prdComprasPorPeriodoTOs.size(); i++){
                for (int j = 0; j < listaProductos.size(); j++){
                    prdComprasPorPeriodoTOs.get(i).setConsumoCodigo(prdComprasPorPeriodoTOs.
                            get(i).getConsumoCodigo() == null ? "" : prdComprasPorPeriodoTOs.get(i).getConsumoCodigo());
                    prdComprasPorPeriodoTOs.get(i).setConsumoProducto(prdComprasPorPeriodoTOs.
                            get(i).getConsumoProducto() == null ? "" : prdComprasPorPeriodoTOs.get(i).getConsumoProducto());
                    prdComprasPorPeriodoTOs.get(i).setConsumoMedida(prdComprasPorPeriodoTOs.
                            get(i).getConsumoMedida() == null ? "" : prdComprasPorPeriodoTOs.get(i).getConsumoMedida());
                    if (prdComprasPorPeriodoTOs.get(i).getConsumoCodigo().concat(prdComprasPorPeriodoTOs.get(i).getConsumoProducto()).equals(
                            listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                        encontro = true;
                        j = listaProductos.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProductos.add(new CostoPiscinaSemanalNombres(prdComprasPorPeriodoTOs.get(i).getConsumoCodigo(),
                    prdComprasPorPeriodoTOs.get(i).getConsumoProducto(), prdComprasPorPeriodoTOs.get(i).getConsumoMedida()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<inventario.TO.InvComprasPorPeriodoTO> prdComprasPorPeriodoTOs){
        if (prdComprasPorPeriodoTOs.size() > 0){
            datos = new Object[listaProductos.size()][columnas.length];
            for (int i = 0; i < listaProductos.size(); i++){
                datos[i][0] = listaProductos.get(i).getProducto();
                datos[i][1] = listaProductos.get(i).getCodigo();
                datos[i][2] = listaProductos.get(i).getMedida();
            }
            for (int h = 0; h < prdComprasPorPeriodoTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdComprasPorPeriodoTOs.get(h).getConsumoCodigo().concat(prdComprasPorPeriodoTOs.get(h).getConsumoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdComprasPorPeriodoTOs.get(h).getConsumoFecha().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 3] = prdComprasPorPeriodoTOs.get(h).getConsumoTotal();
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
