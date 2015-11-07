/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadBalanceResultadoMensualizado {
    private String[] columnas;
    private Object[][] datos;

    public NumeroColumnaDesconocidadBalanceResultadoMensualizado() {
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

    public java.util.List<CuentasContablesConNombre> getListaCuentas() {
        return listaCuentas;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<contabilidad.TO.ConBalanceResultadosMensualizadosTO> conBalanceResultadosMensualizadosTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (conBalanceResultadosMensualizadosTOs.size() > 0){
            columnasFaltantes.add(conBalanceResultadosMensualizadosTOs.get(0).getBrMes());
            for (int i = 1; i < conBalanceResultadosMensualizadosTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (conBalanceResultadosMensualizadosTOs.get(i).getBrMes().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(conBalanceResultadosMensualizadosTOs.get(i).getBrMes());
                }
            }
            columnas = new String [2 + columnasFaltantes.size()];
            columnas[0] = "Cuenta";
            columnas[1] = "Detalle";
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 2] = columnasFaltantes.get(i).toString();
            }
        }
        

    }
    private java.util.List<CuentasContablesConNombre> listaCuentas = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param conBalanceResultadosMensualizadosTOs lista que viene de la consulta
     */
    public void agruparCuentas(java.util.List<contabilidad.TO.ConBalanceResultadosMensualizadosTO> conBalanceResultadosMensualizadosTOs){
        listaCuentas = new java.util.ArrayList();
        boolean encontro = false;
        if (conBalanceResultadosMensualizadosTOs.size() > 0){
            conBalanceResultadosMensualizadosTOs.get(0).setBrCuenta(conBalanceResultadosMensualizadosTOs.
                    get(0).getBrCuenta() == null ? "" : conBalanceResultadosMensualizadosTOs.get(0).getBrCuenta());
            listaCuentas.add(new CuentasContablesConNombre(conBalanceResultadosMensualizadosTOs.get(0).getBrCuenta(),
                    conBalanceResultadosMensualizadosTOs.get(0).getBrDetalle()));
            for (int i = 1; i < conBalanceResultadosMensualizadosTOs.size(); i++){
                for (int j = 0; j < listaCuentas.size(); j++){
                    conBalanceResultadosMensualizadosTOs.get(i).setBrCuenta(conBalanceResultadosMensualizadosTOs.
                            get(i).getBrCuenta() == null ? "" : conBalanceResultadosMensualizadosTOs.get(i).getBrCuenta());
                    if (conBalanceResultadosMensualizadosTOs.get(i).getBrCuenta().equals(
                            listaCuentas.get(j).getCuenta())){
                        encontro = true;
                        j = listaCuentas.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaCuentas.add(new CuentasContablesConNombre(conBalanceResultadosMensualizadosTOs.get(i).getBrCuenta(),
                    conBalanceResultadosMensualizadosTOs.get(i).getBrDetalle()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<contabilidad.TO.ConBalanceResultadosMensualizadosTO> conBalanceResultadosMensualizadosTOs){
        if (conBalanceResultadosMensualizadosTOs.size() > 0){
            datos = new Object[listaCuentas.size()][columnas.length];
            for (int i = 0; i < listaCuentas.size(); i++){
                datos[i][0] = listaCuentas.get(i).getCuenta();
                datos[i][1] = listaCuentas.get(i).getNombre();
            }

            for (int h = 0; h < conBalanceResultadosMensualizadosTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (conBalanceResultadosMensualizadosTOs.get(h).getBrCuenta().equals(datos[i][0].toString())){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (conBalanceResultadosMensualizadosTOs.get(h).getBrMes().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 2] = conBalanceResultadosMensualizadosTOs.get(h).getBrSaldo();
                                j = columnasFaltantes.size();
                            }
                        }
                        i = datos.length;
                    }
                }
            }
        }
    }
}
