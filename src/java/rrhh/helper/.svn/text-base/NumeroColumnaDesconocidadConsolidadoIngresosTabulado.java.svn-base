/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.helper;



/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadConsolidadoIngresosTabulado {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadConsolidadoIngresosTabulado() {
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

    public java.util.List<ConsolidadoIngresosTabuladoNombre> getListaConsolidadoIngresosTabulado() {
        return listaConsolidadoIngresosTabulado;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<rrhh.TO.RhConsolidadoIngresosTabuladoTO> rhConsolidadoIngresosTabuladoTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (rhConsolidadoIngresosTabuladoTOs.size() > 0){
            columnasFaltantes.add(rhConsolidadoIngresosTabuladoTOs.get(0).getBrPeriodo());           
            for (int i = 1; i < rhConsolidadoIngresosTabuladoTOs.size(); i++){                
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (rhConsolidadoIngresosTabuladoTOs.get(i).getBrPeriodo().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(rhConsolidadoIngresosTabuladoTOs.get(i).getBrPeriodo());
                }
            }
            columnas = new String [4 + columnasFaltantes.size()];
            columnas[0] = "Cédula";
            columnas[1] = "Nombres";
            columnas[2] = "Fecha Ingreso";
            columnas[3] = "Fecha Salida";
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 4] = columnasFaltantes.get(i).toString();
            }
        }
        

    }
    private java.util.List<ConsolidadoIngresosTabuladoNombre> listaConsolidadoIngresosTabulado = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param conBalanceResultadosMensualizadosTOs lista que viene de la consulta
     */
    public void agruparCuentas(java.util.List<rrhh.TO.RhConsolidadoIngresosTabuladoTO> rhConsolidadoIngresosTabuladoTOs){
        listaConsolidadoIngresosTabulado = new java.util.ArrayList();
        boolean encontro = false;
        if (rhConsolidadoIngresosTabuladoTOs.size() > 0){
            
            rhConsolidadoIngresosTabuladoTOs.get(0).setBrCedula(rhConsolidadoIngresosTabuladoTOs.
                    get(0).getBrCedula() == null ? "" : rhConsolidadoIngresosTabuladoTOs.get(0).getBrCedula());
            rhConsolidadoIngresosTabuladoTOs.get(0).setBrNombre(rhConsolidadoIngresosTabuladoTOs.
                    get(0).getBrNombre() == null ? "" : rhConsolidadoIngresosTabuladoTOs.get(0).getBrNombre());
            
            listaConsolidadoIngresosTabulado.add(new ConsolidadoIngresosTabuladoNombre(rhConsolidadoIngresosTabuladoTOs.get(0).getBrCedula(),
                    rhConsolidadoIngresosTabuladoTOs.get(0).getBrNombre(),
                    rhConsolidadoIngresosTabuladoTOs.get(0).getBrFechaIngreso(),
                    rhConsolidadoIngresosTabuladoTOs.get(0).getBrFechaSalida()));
            
            for (int i = 1; i < rhConsolidadoIngresosTabuladoTOs.size(); i++){
                for (int j = 0; j < listaConsolidadoIngresosTabulado.size(); j++){
                    
                    rhConsolidadoIngresosTabuladoTOs.get(i).setBrCedula(rhConsolidadoIngresosTabuladoTOs.
                            get(i).getBrCedula() == null ? "" : rhConsolidadoIngresosTabuladoTOs.get(i).getBrCedula());
                    
                    rhConsolidadoIngresosTabuladoTOs.get(i).setBrNombre(rhConsolidadoIngresosTabuladoTOs.
                            get(i).getBrNombre() == null ? "" : rhConsolidadoIngresosTabuladoTOs.get(i).getBrNombre());
                                            
                          if (rhConsolidadoIngresosTabuladoTOs.get(i).getBrCedula().concat(rhConsolidadoIngresosTabuladoTOs.get(i).getBrNombre()).equals(
                            listaConsolidadoIngresosTabulado.get(j).getCedula().concat(listaConsolidadoIngresosTabulado.get(j).getNombre()))){
                        
                        encontro = true;
                        j = listaConsolidadoIngresosTabulado.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaConsolidadoIngresosTabulado.add(new ConsolidadoIngresosTabuladoNombre(rhConsolidadoIngresosTabuladoTOs.get(i).getBrCedula(),
                    rhConsolidadoIngresosTabuladoTOs.get(i).getBrNombre(),                    
                    rhConsolidadoIngresosTabuladoTOs.get(i).getBrFechaIngreso(),
                    rhConsolidadoIngresosTabuladoTOs.get(i).getBrFechaSalida()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<rrhh.TO.RhConsolidadoIngresosTabuladoTO> rhConsolidadoIngresosTabuladoTOs){
        if (rhConsolidadoIngresosTabuladoTOs.size() > 0){
            datos = new Object[listaConsolidadoIngresosTabulado.size()][columnas.length];
            for (int i = 0; i < listaConsolidadoIngresosTabulado.size(); i++){
                datos[i][0] = listaConsolidadoIngresosTabulado.get(i).getCedula();
                datos[i][1] = listaConsolidadoIngresosTabulado.get(i).getNombre();
                datos[i][2] = listaConsolidadoIngresosTabulado.get(i).getFechaIngreso();
                datos[i][3] = listaConsolidadoIngresosTabulado.get(i).getFechaSalida();
              
            }

            for (int h = 0; h < rhConsolidadoIngresosTabuladoTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){                                    
                  if (rhConsolidadoIngresosTabuladoTOs.get(h).getBrCedula().concat(rhConsolidadoIngresosTabuladoTOs.get(h).getBrNombre()).equals(datos[i][0].toString().concat(datos[i][1].toString()))){       
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (rhConsolidadoIngresosTabuladoTOs.get(h).getBrPeriodo().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 4] = rhConsolidadoIngresosTabuladoTOs.get(h).getBrTotal();
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
