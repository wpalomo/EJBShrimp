/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadResumenSiembra {
    private String[] columnas;
    private String[] columnasTmp;
    private Object[][] datos;
    private Object[][] datosTmp;

    public NumeroColumnaDesconocidadResumenSiembra() {
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

    public java.util.List<ResumenSiembraNombres> getListaResumenSiembra() {
        return listaResumenSiembra;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdResumenSiembraTO> prdResumenSiembraTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdResumenSiembraTOs.size() > 0){
            columnasFaltantes.add(prdResumenSiembraTOs.get(0).getRcTipo());
            for (int i = 1; i < prdResumenSiembraTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdResumenSiembraTOs.get(i).getRcTipo().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdResumenSiembraTOs.get(i).getRcTipo());
                }
            }
            columnas = new String [15 + columnasFaltantes.size()];
            columnas[0] = "Sector";
            columnas[1] = "Piscina";
            columnas[2] = "Corrida";
            columnas[3] = "Hectareaje";
            columnas[4] = "Siembra";
            columnas[5] = "Días Cultivo";//edad
            columnas[6] = "Días Inactivo";//dias muertos
            columnas[7] = "Densidad";//densidad
            columnas[8] = "Laboratorio";
            columnas[9] = "Nauplio";
            columnas[10] = "Biomasa Proy.";
            columnas[11] = "Conv. Aliment.";
            columnas[12] = "Gramos";//talla promedio
            columnas[13] = "Sobrevivencia";
            
            /***************************************************************************////
            columnasTmp = new String [16 + columnasFaltantes.size()];
            columnasTmp[0] = "Sector";
            columnasTmp[1] = "Piscina";
            columnasTmp[2] = "Corrida";
            columnasTmp[3] = "Hectareaje";
            columnasTmp[4] = "Siembra";
            columnasTmp[5] = "Días Cultivo";//edad
            columnasTmp[6] = "Días Inactivo";//dias muertos
            columnasTmp[7] = "Densidad";//densidad
            columnasTmp[8] = "Laboratorio";
            columnasTmp[9] = "Nauplio";
            columnasTmp[10] = "Biomasa Proy.";
            columnasTmp[11] = "Conv. Aliment.";
            columnasTmp[12] = "Gramos";//talla promedio
            columnasTmp[13] = "Sobrevivencia";
            ////////////PARTE "DINAMICA"
            columnasTmp[14] = "Directo";
            columnasTmp[15] = "Indirecto";
            columnasTmp[16] = "Subtotal";
            columnasTmp[17] = "Adm.";
            columnasTmp[18] = "Fin.";
            columnasTmp[19] = "GND";
            columnasTmp[20] = "Subtotal";
            columnasTmp[21] = "TOTAL";
            
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 14] = columnasFaltantes.get(i).toString();
            }
        }
        

    }
    private java.util.List<ResumenSiembraNombres> listaResumenSiembra = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param prdResumenSiembraTOs lista que viene de la consulta
     */
    public void agruparResumenPesca(java.util.List<produccion.TO.PrdResumenSiembraTO> prdResumenSiembraTOs){
        listaResumenSiembra = new java.util.ArrayList();
        boolean encontro = false;
        if (prdResumenSiembraTOs.size() > 0){
//            prdResumenPescaTOs.get(0).setConsumoCodigo(prdResumenPescaTOs.
//                    get(0).getConsumoCodigo() == null ? "" : prdResumenPescaTOs.get(0).getConsumoCodigo());
//            prdResumenPescaTOs.get(0).setConsumoProducto(prdResumenPescaTOs.
//                    get(0).getConsumoProducto() == null ? "" : prdResumenPescaTOs.get(0).getConsumoProducto());
//            prdResumenPescaTOs.get(0).setConsumoMedida(prdResumenPescaTOs.
//                    get(0).getConsumoMedida() == null ? "" : prdResumenPescaTOs.get(0).getConsumoMedida());
            
            listaResumenSiembra.add(new ResumenSiembraNombres(
                    prdResumenSiembraTOs.get(0).getRcSector(),
                    prdResumenSiembraTOs.get(0).getRcPiscina(), 
                    prdResumenSiembraTOs.get(0).getRcCorrida(), 
                    prdResumenSiembraTOs.get(0).getRcHectareaje(), 
                    prdResumenSiembraTOs.get(0).getRcFechaDesde(), 
                    prdResumenSiembraTOs.get(0).getRcFechaSiembra(), 
                    prdResumenSiembraTOs.get(0).getRcFechaPesca(), 
                    prdResumenSiembraTOs.get(0).getRcFechaHasta(), 
                    prdResumenSiembraTOs.get(0).getRcEdad(), 
                    prdResumenSiembraTOs.get(0).getRcDiasMuertos(), 
                    prdResumenSiembraTOs.get(0).getRcNumeroLarvas(), 
                    prdResumenSiembraTOs.get(0).getRcDensidad(), 
                    prdResumenSiembraTOs.get(0).getRcLaboratorio(), 
                    prdResumenSiembraTOs.get(0).getRcNauplio(), 
                    prdResumenSiembraTOs.get(0).getRcBalanceado(), 
                    prdResumenSiembraTOs.get(0).getRcBiomasa(), 
                    prdResumenSiembraTOs.get(0).getRcBiomasaReal(), 
                    prdResumenSiembraTOs.get(0).getRcConversion(), 
                    prdResumenSiembraTOs.get(0).getRcTallaPromedio(), 
                    prdResumenSiembraTOs.get(0).getRcPesoIdeal(), 
                    prdResumenSiembraTOs.get(0).getRcSobrevivencia()));
            
            for (int i = 1; i < prdResumenSiembraTOs.size(); i++){
                for (int j = 0; j < listaResumenSiembra.size(); j++){
//                    prdResumenPescaTOs.get(i).setConsumoCodigo(prdResumenPescaTOs.
//                            get(i).getConsumoCodigo() == null ? "" : prdResumenPescaTOs.get(i).getConsumoCodigo());
//                    prdResumenPescaTOs.get(i).setConsumoProducto(prdResumenPescaTOs.
//                            get(i).getConsumoProducto() == null ? "" : prdResumenPescaTOs.get(i).getConsumoProducto());
//                    prdResumenPescaTOs.get(i).setConsumoMedida(prdResumenPescaTOs.
//                            get(i).getConsumoMedida() == null ? "" : prdResumenPescaTOs.get(i).getConsumoMedida());
                    if (prdResumenSiembraTOs.get(i).getRcSector().concat(prdResumenSiembraTOs.get(i).getRcPiscina()).concat(prdResumenSiembraTOs.get(i).getRcCorrida()).equals(
                            listaResumenSiembra.get(j).getRcSector().concat(listaResumenSiembra.get(j).getRcPiscina()).concat(listaResumenSiembra.get(j).getRcCorrida()))){
                        encontro = true;
                        j = listaResumenSiembra.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaResumenSiembra.add(new ResumenSiembraNombres(
                            prdResumenSiembraTOs.get(i).getRcSector(),
                            prdResumenSiembraTOs.get(i).getRcPiscina(), 
                            prdResumenSiembraTOs.get(i).getRcCorrida(), 
                            prdResumenSiembraTOs.get(i).getRcHectareaje(), 
                            prdResumenSiembraTOs.get(i).getRcFechaDesde(), 
                            prdResumenSiembraTOs.get(i).getRcFechaSiembra(), 
                            prdResumenSiembraTOs.get(i).getRcFechaPesca(), 
                            prdResumenSiembraTOs.get(i).getRcFechaHasta(), 
                            prdResumenSiembraTOs.get(i).getRcEdad(), 
                            prdResumenSiembraTOs.get(i).getRcDiasMuertos(), 
                            prdResumenSiembraTOs.get(i).getRcNumeroLarvas(), 
                            prdResumenSiembraTOs.get(i).getRcDensidad(), 
                            prdResumenSiembraTOs.get(i).getRcLaboratorio(), 
                            prdResumenSiembraTOs.get(i).getRcNauplio(), 
                            prdResumenSiembraTOs.get(i).getRcBalanceado(), 
                            prdResumenSiembraTOs.get(i).getRcBiomasa(), 
                            prdResumenSiembraTOs.get(i).getRcBiomasaReal(), 
                            prdResumenSiembraTOs.get(i).getRcConversion(), 
                            prdResumenSiembraTOs.get(i).getRcTallaPromedio(), 
                            prdResumenSiembraTOs.get(i).getRcPesoIdeal(), 
                            prdResumenSiembraTOs.get(i).getRcSobrevivencia()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdResumenSiembraTO> prdResumenSiembraTOs){
        if (prdResumenSiembraTOs.size() > 0){
            datos = new Object[listaResumenSiembra.size()][columnas.length];
            
//            columnasTmp[0] = "Sector";
//            columnasTmp[1] = "Piscina";
//            columnasTmp[2] = "Corrida";
//            columnasTmp[3] = "Hectareaje";
//            columnasTmp[4] = "Siembra";
//            columnasTmp[5] = "Días Cultivo";//edad
//            columnasTmp[6] = "Días Inactivo";//dias muertos
//            columnasTmp[7] = "Densidad";//densidad
//            columnasTmp[8] = "Laboratorio";
//            columnasTmp[9] = "Nauplio";
//            columnasTmp[10] = "Biomasa Proy.";
//            columnasTmp[11] = "Conv. Aliment.";
//            columnasTmp[12] = "Gramos";//talla promedio
//            columnasTmp[13] = "Sobrevivencia";
            
            for (int i = 0; i < listaResumenSiembra.size(); i++){
                datos[i][0] = listaResumenSiembra.get(i).getRcSector();
                datos[i][1] = listaResumenSiembra.get(i).getRcPiscina();
                datos[i][2] = listaResumenSiembra.get(i).getRcCorrida();
                datos[i][3] = listaResumenSiembra.get(i).getRcHectareaje();
                datos[i][4] = listaResumenSiembra.get(i).getRcFechaSiembra();
                datos[i][5] = listaResumenSiembra.get(i).getRcEdad();
                datos[i][6] = listaResumenSiembra.get(i).getRcDiasMuertos();
                datos[i][7] = listaResumenSiembra.get(i).getRcDensidad();
                datos[i][8] = listaResumenSiembra.get(i).getRcLaboratorio();
                datos[i][9] = listaResumenSiembra.get(i).getRcNauplio();
                datos[i][10] = listaResumenSiembra.get(i).getRcBiomasa();
                datos[i][11] = listaResumenSiembra.get(i).getRcConversion();
                datos[i][12] = listaResumenSiembra.get(i).getRcTallaPromedio();
                datos[i][13] = listaResumenSiembra.get(i).getRcSobrevivencia();
                
                
                
            }

            for (int h = 0; h < prdResumenSiembraTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdResumenSiembraTOs.get(h).getRcSector().concat(prdResumenSiembraTOs.get(h).getRcPiscina()).concat(prdResumenSiembraTOs.get(h).getRcCorrida()).
                            equals(datos[i][0].toString().concat(datos[i][1].toString()).concat(datos[i][2].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdResumenSiembraTOs.get(h).getRcTipo().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 14] = prdResumenSiembraTOs.get(h).getRcTotal();
                                j = columnasFaltantes.size();
                            }
                        }
                        i = datos.length;
                    }
                }
            }
            
            datosTmp = new Object[listaResumenSiembra.size()][columnasTmp.length];
            for (int i = 0; i < datos.length; i++){
                datosTmp[i][0] = datos[i][0];
                datosTmp[i][1] = datos[i][1];
                datosTmp[i][2] = datos[i][2];
                datosTmp[i][3] = datos[i][3];
                datosTmp[i][4] = datos[i][4];
                datosTmp[i][5] = new java.math.BigDecimal(datos[i][5].toString()).intValue();
                datosTmp[i][6] = new java.math.BigDecimal(datos[i][6].toString()).intValue();
                datosTmp[i][7] = datos[i][7];
                datosTmp[i][8] = datos[i][8];
                datosTmp[i][9] = datos[i][9];
                datosTmp[i][10] = datos[i][10];
                datosTmp[i][11] = datos[i][11];
                datosTmp[i][12] = datos[i][12];
                datosTmp[i][13] = datos[i][13];
                ////////////AQUI EMPIEZA LO "DINAMICO"
                datosTmp[i][14] = datos[i][14];
                datosTmp[i][15] = datos[i][18];
                datosTmp[i][16] = new java.math.BigDecimal(datos[i][14].toString()).add(new java.math.BigDecimal(datos[i][18].toString()));
                datosTmp[i][17] = datos[i][15];
                datosTmp[i][18] = datos[i][16];
                datosTmp[i][19] = datos[i][17];
                datosTmp[i][20] = new java.math.BigDecimal(datos[i][15].toString()).add(new java.math.BigDecimal(datos[i][16].toString())).add(new java.math.BigDecimal(datos[i][17].toString()));
                datosTmp[i][21] = datos[i][19];
            }
            
            datos = new Object[listaResumenSiembra.size()][columnasTmp.length];
            datos = datosTmp;
            
            columnas = new String [16 + columnasFaltantes.size()];
            columnas = columnasTmp;
            
        }
    }
}
