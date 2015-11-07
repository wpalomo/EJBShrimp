/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.helper;



/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadProvisionFechas {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadProvisionFechas() {
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

    public java.util.List<ProvisionFechasNombre> getListaProvisionFechas() {
        return listaProvisionFechas;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<rrhh.TO.RhProvisionFechasTO> rhProvisionFechasTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (rhProvisionFechasTOs.size() > 0){
            columnasFaltantes.add(rhProvisionFechasTOs.get(0).getProvMes());           
            for (int i = 1; i < rhProvisionFechasTOs.size(); i++){                
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (rhProvisionFechasTOs.get(i).getProvMes().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(rhProvisionFechasTOs.get(i).getProvMes());
                }
            }
            columnas = new String [2 + columnasFaltantes.size()];
            columnas[0] = "Cédula";
            columnas[1] = "Nombres";          
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 2] = columnasFaltantes.get(i).toString();
            }
        }
        

    }
    private java.util.List<ProvisionFechasNombre> listaProvisionFechas = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param conBalanceResultadosMensualizadosTOs lista que viene de la consulta
     */
    public void agruparCuentas(java.util.List<rrhh.TO.RhProvisionFechasTO> rhProvisionFechasTOs){
        listaProvisionFechas = new java.util.ArrayList();
        boolean encontro = false;
        if (rhProvisionFechasTOs.size() > 0){
            
            rhProvisionFechasTOs.get(0).setProvId(rhProvisionFechasTOs.
                    get(0).getProvId() == null ? "" : rhProvisionFechasTOs.get(0).getProvId());
            rhProvisionFechasTOs.get(0).setProvId(rhProvisionFechasTOs.
                    get(0).getProvNombres() == null ? "" : rhProvisionFechasTOs.get(0).getProvNombres());            
            
            listaProvisionFechas.add(new ProvisionFechasNombre(rhProvisionFechasTOs.get(0).getProvId(),
                    rhProvisionFechasTOs.get(0).getProvNombres()));
            
            for (int i = 1; i < rhProvisionFechasTOs.size(); i++){
                for (int j = 0; j < listaProvisionFechas.size(); j++){
                    
                    rhProvisionFechasTOs.get(i).setProvId(rhProvisionFechasTOs.
                            get(i).getProvId() == null ? "" : rhProvisionFechasTOs.get(i).getProvId());
                    
                    rhProvisionFechasTOs.get(i).setProvNombres(rhProvisionFechasTOs.
                            get(i).getProvNombres() == null ? "" : rhProvisionFechasTOs.get(i).getProvNombres());
                                            
                          if (rhProvisionFechasTOs.get(i).getProvId().concat(rhProvisionFechasTOs.get(i).getProvNombres()).equals(
                            listaProvisionFechas.get(j).getCedula().concat(listaProvisionFechas.get(j).getNombre()))){
                        
                        encontro = true;
                        j = listaProvisionFechas.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaProvisionFechas.add(new ProvisionFechasNombre(rhProvisionFechasTOs.get(i).getProvId(),
                    rhProvisionFechasTOs.get(i).getProvNombres()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<rrhh.TO.RhProvisionFechasTO> rhProvisionFechasTOs){
        if (rhProvisionFechasTOs.size() > 0){
            datos = new Object[listaProvisionFechas.size()][columnas.length];
            for (int i = 0; i < listaProvisionFechas.size(); i++){
                datos[i][0] = listaProvisionFechas.get(i).getCedula();
                datos[i][1] = listaProvisionFechas.get(i).getNombre();               
              
            }

            for (int h = 0; h < rhProvisionFechasTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){                                    
                  if (rhProvisionFechasTOs.get(h).getProvId().concat(rhProvisionFechasTOs.get(h).getProvNombres()).equals(datos[i][0].toString().concat(datos[i][1].toString()))){       
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (rhProvisionFechasTOs.get(h).getProvMes().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 2] = rhProvisionFechasTOs.get(h).getProvValor();
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
