/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class NumeroColumnaDesconocidadResumenPesca {
    private String[] columnas;
    private String[] columnasTmp;
    private Object[][] datos;
    private Object[][] datosTmp;

    public NumeroColumnaDesconocidadResumenPesca() {
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

    public java.util.List<ResumenPescaNombres> getListaResumenPesca() {
        return listaResumenPesca;
    }
    

    private java.util.List<String> columnasFaltantes = null;
    
    public void agruparCabeceraColumnas(java.util.List<produccion.TO.PrdResumenPescaTO> prdResumenPescaTOs){
        boolean encontro = false;
        columnasFaltantes = new java.util.ArrayList();
        if (prdResumenPescaTOs.size() > 0){
            columnasFaltantes.add(prdResumenPescaTOs.get(0).getRcTipo());
            for (int i = 1; i < prdResumenPescaTOs.size(); i++){
                for (int j = 0; j < columnasFaltantes.size(); j++){
                    if (prdResumenPescaTOs.get(i).getRcTipo().
                            equals(columnasFaltantes.get(j).toString())){
                        encontro = true;
                        j = columnasFaltantes.size();

                    } else {
    //                                    contador++;
                        encontro = false;

                    }
                }
                if (!encontro){
                    columnasFaltantes.add(prdResumenPescaTOs.get(i).getRcTipo());
                }
            }
            columnas = new String [16 + columnasFaltantes.size()];
            columnas[0] = "Sector";
            columnas[1] = "Piscina";
            columnas[2] = "Corrida";
            columnas[3] = "Hectareaje";
            columnas[4] = "Siembra";
            columnas[5] = "Pesca";
            columnas[6] = "Días Cultivo";//edad
            columnas[7] = "Días Inactivo";//dias muertos
            columnas[8] = "Densidad";
            columnas[9] = "Laboratorio";
            columnas[10] = "Nauplio";
            columnas[11] = "Biomasa Real";
            columnas[12] = "Conv. Aliment.";
            columnas[13] = "Gramos";//talla promedio
            columnas[14] = "Sobrevivencia";
            
            /***************************************************************************////
            columnasTmp = new String [17 + columnasFaltantes.size()];
            columnasTmp[0] = "Sector";
            columnasTmp[1] = "Piscina";
            columnasTmp[2] = "Corrida";
            columnasTmp[3] = "Hectareaje";
            columnasTmp[4] = "Siembra";
            columnasTmp[5] = "Pesca";
            columnasTmp[6] = "Días Cultivo";//edad
            columnasTmp[7] = "Días Inactivo";//dias muertos
            columnasTmp[8] = "Densidad";//dias muertos
            columnasTmp[9] = "Laboratorio";
            columnasTmp[10] = "Nauplio";
            columnasTmp[11] = "Biomasa Real";
            columnasTmp[12] = "Conv. Aliment.";
            columnasTmp[13] = "Gramos";//talla promedio
            columnasTmp[14] = "Sobrevivencia";
            ////////////PARTE "DINAMICA"
            columnasTmp[15] = "Directo";
            columnasTmp[16] = "Indirecto";
            columnasTmp[17] = "Subtotal";
            columnasTmp[18] = "Adm.";
            columnasTmp[19] = "Fin.";
            columnasTmp[20] = "GND";
            columnasTmp[21] = "Subtotal";
            columnasTmp[22] = "TOTAL";
            
            
            
            
            for (int i = 0; i < columnasFaltantes.size(); i++){
                columnas[i + 15] = columnasFaltantes.get(i).toString();
            }
        }
        

    }
    private java.util.List<ResumenPescaNombres> listaResumenPesca = null;
    
    /**
     * Metodo que agrupa las cuentas de acuerdo a su codigo (añadiendo de paso el nombre de la cuenta)
     * @param prdResumenPescaTOs lista que viene de la consulta
     */
    public void agruparResumenPesca(java.util.List<produccion.TO.PrdResumenPescaTO> prdResumenPescaTOs){
        listaResumenPesca = new java.util.ArrayList();
        boolean encontro = false;
        if (prdResumenPescaTOs.size() > 0){
//            prdResumenPescaTOs.get(0).setConsumoCodigo(prdResumenPescaTOs.
//                    get(0).getConsumoCodigo() == null ? "" : prdResumenPescaTOs.get(0).getConsumoCodigo());
//            prdResumenPescaTOs.get(0).setConsumoProducto(prdResumenPescaTOs.
//                    get(0).getConsumoProducto() == null ? "" : prdResumenPescaTOs.get(0).getConsumoProducto());
//            prdResumenPescaTOs.get(0).setConsumoMedida(prdResumenPescaTOs.
//                    get(0).getConsumoMedida() == null ? "" : prdResumenPescaTOs.get(0).getConsumoMedida());
            
            listaResumenPesca.add(new ResumenPescaNombres(
                    prdResumenPescaTOs.get(0).getRcSector(),
                    prdResumenPescaTOs.get(0).getRcPiscina(), 
                    prdResumenPescaTOs.get(0).getRcCorrida(), 
                    prdResumenPescaTOs.get(0).getRcHectareaje(), 
                    prdResumenPescaTOs.get(0).getRcFechaDesde(), 
                    prdResumenPescaTOs.get(0).getRcFechaSiembra(), 
                    prdResumenPescaTOs.get(0).getRcFechaPesca(), 
                    prdResumenPescaTOs.get(0).getRcFechaHasta(), 
                    prdResumenPescaTOs.get(0).getRcEdad(), 
                    prdResumenPescaTOs.get(0).getRcDiasMuertos(), 
                    prdResumenPescaTOs.get(0).getRcNumeroLarvas(), 
                    prdResumenPescaTOs.get(0).getRcDensidad(), 
                    prdResumenPescaTOs.get(0).getRcLaboratorio(), 
                    prdResumenPescaTOs.get(0).getRcNauplio(), 
                    prdResumenPescaTOs.get(0).getRcBalanceado(), 
                    prdResumenPescaTOs.get(0).getRcBiomasa(), 
                    prdResumenPescaTOs.get(0).getRcBiomasaReal(), 
                    prdResumenPescaTOs.get(0).getRcConversion(), 
                    prdResumenPescaTOs.get(0).getRcTallaPromedio(), 
                    prdResumenPescaTOs.get(0).getRcPesoIdeal(), 
                    prdResumenPescaTOs.get(0).getRcSobrevivencia()));
            
            for (int i = 1; i < prdResumenPescaTOs.size(); i++){
                for (int j = 0; j < listaResumenPesca.size(); j++){
//                    prdResumenPescaTOs.get(i).setConsumoCodigo(prdResumenPescaTOs.
//                            get(i).getConsumoCodigo() == null ? "" : prdResumenPescaTOs.get(i).getConsumoCodigo());
//                    prdResumenPescaTOs.get(i).setConsumoProducto(prdResumenPescaTOs.
//                            get(i).getConsumoProducto() == null ? "" : prdResumenPescaTOs.get(i).getConsumoProducto());
//                    prdResumenPescaTOs.get(i).setConsumoMedida(prdResumenPescaTOs.
//                            get(i).getConsumoMedida() == null ? "" : prdResumenPescaTOs.get(i).getConsumoMedida());
                    if (prdResumenPescaTOs.get(i).getRcSector().concat(prdResumenPescaTOs.get(i).getRcPiscina()).concat(prdResumenPescaTOs.get(i).getRcCorrida()).equals(
                            listaResumenPesca.get(j).getRcSector().concat(listaResumenPesca.get(j).getRcPiscina()).concat(listaResumenPesca.get(j).getRcCorrida()))){
                        encontro = true;
                        j = listaResumenPesca.size();
                    } else {
                        encontro = false;
                    }
                }
                if (!encontro){
                    listaResumenPesca.add(new ResumenPescaNombres(
                            prdResumenPescaTOs.get(i).getRcSector(),
                            prdResumenPescaTOs.get(i).getRcPiscina(), 
                            prdResumenPescaTOs.get(i).getRcCorrida(), 
                            prdResumenPescaTOs.get(i).getRcHectareaje(), 
                            prdResumenPescaTOs.get(i).getRcFechaDesde(), 
                            prdResumenPescaTOs.get(i).getRcFechaSiembra(), 
                            prdResumenPescaTOs.get(i).getRcFechaPesca(), 
                            prdResumenPescaTOs.get(i).getRcFechaHasta(), 
                            prdResumenPescaTOs.get(i).getRcEdad(), 
                            prdResumenPescaTOs.get(i).getRcDiasMuertos(), 
                            prdResumenPescaTOs.get(i).getRcNumeroLarvas(), 
                            prdResumenPescaTOs.get(i).getRcDensidad(), 
                            prdResumenPescaTOs.get(i).getRcLaboratorio(), 
                            prdResumenPescaTOs.get(i).getRcNauplio(), 
                            prdResumenPescaTOs.get(i).getRcBalanceado(), 
                            prdResumenPescaTOs.get(i).getRcBiomasa(), 
                            prdResumenPescaTOs.get(i).getRcBiomasaReal(), 
                            prdResumenPescaTOs.get(i).getRcConversion(), 
                            prdResumenPescaTOs.get(i).getRcTallaPromedio(), 
                            prdResumenPescaTOs.get(i).getRcPesoIdeal(), 
                            prdResumenPescaTOs.get(i).getRcSobrevivencia()));
                }
            }
        }
    }


    public void llenarObjetoParaTabla(java.util.List<produccion.TO.PrdResumenPescaTO> prdResumenPescaTOs){
        if (prdResumenPescaTOs.size() > 0){
            datos = new Object[listaResumenPesca.size()][columnas.length];
//                "SSect."+"¬"+
//                "SPisc."+"¬"+
//                "SCor."+"¬"+
//                "SHas."+"¬"+
//                "SSiembra"+"¬"+
//                "SPesca"+"¬"+
//                "SDías Cultivo"+"¬"+
//                "SDías Inactivo"+"¬"+
//                "SDensidad"+"¬"+
//                "SLaboratorio"+"¬"+
//                "SNauplio"+"¬"+
//                "SBiomasa Real"+"¬"+
//                "SConv. Al."+"¬"+
//                "SGramos"+"¬"+
//                "SSobrev."+"¬"+
//                "SDirecto"+"¬"+
//                "SIndirecto"+"¬"+
//                "SSubtotal"+"¬"+
//                "SAdm."+"¬"+
//                "SFin."+"¬"+
//                "SGND."+"¬"+
//                "SSubtotal."+"¬"+
//                "STOTAL."+"¬");
        
//            columnas[0] = "Sector";
//            columnas[1] = "Piscina";
//            columnas[2] = "Corrida";
//            columnas[3] = "Hectareaje";
//            columnas[4] = "Siembra";
//            columnas[5] = "Pesca";
//            columnas[6] = "Días Cultivo";//edad
//            columnas[7] = "Días Inactivo";//dias muertos
//            columnas[8] = "Densidad";
//            columnas[9] = "Laboratorio";
//            columnas[10] = "Nauplio";
//            columnas[11] = "Densidad";//densidad
//            columnas[12] = "Biomasa Real";
//            columnas[13] = "Conv. Aliment.";
//            columnas[14] = "Gramos";//talla promedio
//            columnas[15] = "Sobrevivencia";
            
            for (int i = 0; i < listaResumenPesca.size(); i++){
                datos[i][0] = listaResumenPesca.get(i).getRcSector();
                datos[i][1] = listaResumenPesca.get(i).getRcPiscina();
                datos[i][2] = listaResumenPesca.get(i).getRcCorrida();
                datos[i][3] = listaResumenPesca.get(i).getRcHectareaje();
                datos[i][4] = listaResumenPesca.get(i).getRcFechaSiembra();
                datos[i][5] = listaResumenPesca.get(i).getRcFechaPesca();
                datos[i][6] = listaResumenPesca.get(i).getRcEdad();
                datos[i][7] = listaResumenPesca.get(i).getRcDiasMuertos();
                datos[i][8] = listaResumenPesca.get(i).getRcDensidad();
                datos[i][9] = listaResumenPesca.get(i).getRcLaboratorio();
                datos[i][10] = listaResumenPesca.get(i).getRcNauplio();
                datos[i][11] = listaResumenPesca.get(i).getRcBiomasaReal();
                datos[i][12] = listaResumenPesca.get(i).getRcConversion();
                datos[i][13] = listaResumenPesca.get(i).getRcTallaPromedio();
                datos[i][14] = listaResumenPesca.get(i).getRcSobrevivencia();
                
            }

            for (int h = 0; h < prdResumenPescaTOs.size(); h++){
                for (int i = 0; i < datos.length; i++){
                    if (prdResumenPescaTOs.get(h).getRcSector().concat(prdResumenPescaTOs.get(h).getRcPiscina()).concat(prdResumenPescaTOs.get(h).getRcCorrida()).
                            equals(datos[i][0].toString().concat(datos[i][1].toString()).concat(datos[i][2].toString()))){
                        for (int j = 0; j < columnasFaltantes.size(); j++){
                            if (prdResumenPescaTOs.get(h).getRcTipo().
                                    equals(columnasFaltantes.get(j).toString())){                                
                                datos[i][j + 15] = prdResumenPescaTOs.get(h).getRcTotal();
                                j = columnasFaltantes.size();
                            }
                        }
                        i = datos.length;
                    }
                }
            }
            
            datosTmp = new Object[listaResumenPesca.size()][columnasTmp.length];
            for (int i = 0; i < datos.length; i++){
                datosTmp[i][0] = datos[i][0];
                datosTmp[i][1] = datos[i][1];
                datosTmp[i][2] = datos[i][2];
                datosTmp[i][3] = datos[i][3];
                datosTmp[i][4] = datos[i][4];
                datosTmp[i][5] = datos[i][5];
                datosTmp[i][6] = new java.math.BigDecimal(datos[i][6].toString()).intValue();
                datosTmp[i][7] = new java.math.BigDecimal(datos[i][7].toString()).intValue();
                datosTmp[i][8] = datos[i][8];
                datosTmp[i][9] = datos[i][9];
                datosTmp[i][10] = datos[i][10];
                datosTmp[i][11] = datos[i][11];
                datosTmp[i][12] = datos[i][12];
                datosTmp[i][13] = datos[i][13];
                datosTmp[i][14] = datos[i][14];
                ////////////AQUI EMPIEZA LO "DINAMICO"
                datosTmp[i][15] = datos[i][15];
                datosTmp[i][16] = datos[i][19];
                datosTmp[i][17] = new java.math.BigDecimal(datos[i][15].toString()).add(new java.math.BigDecimal(datos[i][19].toString()));
                datosTmp[i][18] = datos[i][16];
                datosTmp[i][19] = datos[i][17];
                datosTmp[i][20] = datos[i][18];
                datosTmp[i][21] = new java.math.BigDecimal(datos[i][16].toString()).add(new java.math.BigDecimal(datos[i][17].toString())).add(new java.math.BigDecimal(datos[i][18].toString()));
                datosTmp[i][22] = datos[i][20];
            }
            
            datos = new Object[listaResumenPesca.size()][columnasTmp.length];
            datos = datosTmp;
            
            columnas = new String [17 + columnasFaltantes.size()];
            columnas = columnasTmp;
        }
    }
}
