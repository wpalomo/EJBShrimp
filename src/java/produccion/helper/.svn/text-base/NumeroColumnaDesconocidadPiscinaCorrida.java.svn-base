/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

import inventario.helper.ProductosMultiplePiscinaCorrida;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadPiscinaCorrida {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadPiscinaCorrida() {
    }

//    public NumeroColumnaDesconocidadPiscinaCorrida(String[] columnas, Object[][] datos) {
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

    public java.util.List<ProductosMultiplePiscinaCorrida> getListaProductos() {
        return listaProductos;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.CostoDetalleMultipleCorridaTO> costoDetalleMultipleCorridaTO){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        columnasFaltantes.add(costoDetalleMultipleCorridaTO.get(0).getCostoSector().
                concat(" | ").concat(costoDetalleMultipleCorridaTO.get(0).getCostoPiscina()).
                concat(" | ").concat(costoDetalleMultipleCorridaTO.get(0).getCostoCorrida()));
        for (int i = 1; i < costoDetalleMultipleCorridaTO.size(); i++){
            for (int j = 0; j < columnasFaltantes.size(); j++){
                if (costoDetalleMultipleCorridaTO.get(i).getCostoSector().
                        concat(" | ").concat(costoDetalleMultipleCorridaTO.get(i).getCostoPiscina()).
                        concat(" | ").concat(costoDetalleMultipleCorridaTO.get(i).getCostoCorrida()).
                        equals(columnasFaltantes.get(j).toString())){
                    encontro = true;
                    j = columnasFaltantes.size();

                } else {
//                                    contador++;
                    encontro = false;

                }
            }
            if (!encontro){
                columnasFaltantes.add(costoDetalleMultipleCorridaTO.get(i).getCostoSector().
                        concat(" | ").concat(costoDetalleMultipleCorridaTO.get(i).getCostoPiscina()).
                        concat(" | ").concat(costoDetalleMultipleCorridaTO.get(i).getCostoCorrida()));
            }
        }
//        columnas = null;
        columnas = new String [3+columnasFaltantes.size()];
        columnas[0] = "Producto";
        columnas[1] = "Código";
        columnas[2] = "Medida";
//                        contador = 0;
        for (int i = 0; i < columnasFaltantes.size(); i++){
            columnas[i + 3] = columnasFaltantes.get(i).toString();
        }

    }
    private java.util.List<ProductosMultiplePiscinaCorrida> listaProductos = null;
    public void agruparProductos(java.util.List<produccion.TO.CostoDetalleMultipleCorridaTO> costoDetalleMultipleCorridaTO){
        listaProductos = new java.util.ArrayList();
        boolean encontro = false;
        costoDetalleMultipleCorridaTO.get(0).setCostoCodigo(costoDetalleMultipleCorridaTO.
                        get(0).getCostoCodigo() == null ? "" : costoDetalleMultipleCorridaTO.get(0).getCostoCodigo());
        listaProductos.add(new ProductosMultiplePiscinaCorrida(costoDetalleMultipleCorridaTO.get(0).getCostoProducto(),
                costoDetalleMultipleCorridaTO.get(0).getCostoCodigo(),
                costoDetalleMultipleCorridaTO.get(0).getCostoMedida()));
        for (int i = 1; i < costoDetalleMultipleCorridaTO.size(); i++){
            for (int j = 0; j < listaProductos.size(); j++){
                costoDetalleMultipleCorridaTO.get(i).setCostoCodigo(costoDetalleMultipleCorridaTO.
                        get(i).getCostoCodigo() == null ? "" : costoDetalleMultipleCorridaTO.get(i).getCostoCodigo());
                if (costoDetalleMultipleCorridaTO.get(i).getCostoCodigo().concat(costoDetalleMultipleCorridaTO.get(i).
                        getCostoProducto()).equals(listaProductos.get(j).getCodigo().concat(listaProductos.get(j).getProducto()))){
                    encontro = true;
                    j = listaProductos.size();
                } else {
                    encontro = false;
                }
            }
            if (!encontro){
                listaProductos.add(new ProductosMultiplePiscinaCorrida(costoDetalleMultipleCorridaTO.get(i).getCostoProducto(),
                costoDetalleMultipleCorridaTO.get(i).getCostoCodigo(),
                costoDetalleMultipleCorridaTO.get(i).getCostoMedida()));
            }
        }

    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.CostoDetalleMultipleCorridaTO> costoDetalleMultipleCorridaTO){
        datos = new Object[listaProductos.size()][columnas.length];
        for (int i = 0; i < listaProductos.size(); i++){
            datos[i][0] = listaProductos.get(i).getProducto();
            datos[i][1] = listaProductos.get(i).getCodigo();
            datos[i][2] = listaProductos.get(i).getMedida();
        }

        for (int h = 0; h < costoDetalleMultipleCorridaTO.size(); h++){
            for (int i = 0; i < datos.length; i++){
                if (costoDetalleMultipleCorridaTO.get(h).getCostoCodigo().concat(costoDetalleMultipleCorridaTO.get(h).
                        getCostoProducto()).equals(datos[i][1].toString().concat(datos[i][0].toString()))){
                    for (int j = 0; j < columnasFaltantes.size(); j++){
                        if (costoDetalleMultipleCorridaTO.get(h).getCostoSector().
                                concat(" | ").concat(costoDetalleMultipleCorridaTO.get(h).getCostoPiscina()).
                                concat(" | ").concat(costoDetalleMultipleCorridaTO.get(h).getCostoCorrida()).
                                equals(columnasFaltantes.get(j).toString())){
                            datos[i][j + 3] = costoDetalleMultipleCorridaTO.get(h).getCostoTotal();
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
//        llenarTabla();
    }
}
