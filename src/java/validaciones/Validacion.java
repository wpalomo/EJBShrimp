package validaciones;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Validacion {

    private static Locale locale = new Locale("es", "EC");
    //http://www.timezoneconverter.com/cgi-bin/findzone
    private static Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("America/Guayaquil"));

    public static Date fechaString_Date(String fecha) {
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = (Date) formato.parse(fecha);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

    public static Date fechaString_Date(String fecha, String formato) {
        DateFormat format = new SimpleDateFormat(formato);
        Date date = null;
        try {
            date = (Date) format.parse(fecha);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

    public static Date String_Date(String fecha) {
        if (fecha.trim().length() == 10) {
            if (ValidarDatosFecha(fecha)) {
                DateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                Date date = null;
                try {
                    date = (Date) formato.parse(fecha);
                } catch (ParseException ex) {
                    java.util.logging.Logger.getLogger(Validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (Exception e) {
                    date = null;
                }
                return date;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    private static boolean ValidarDatosFecha(String fecha) {
        boolean flag = true;

        try {
            int dia = 0, mes = 0, anio = 0;
            StringTokenizer st = new StringTokenizer(fecha, "-");
            if (st.hasMoreTokens()) {
                dia = Integer.parseInt(st.nextToken());
            }
            if (st.hasMoreTokens()) {
                mes = Integer.parseInt(st.nextToken());
            }
            if (st.hasMoreTokens()) {
                anio = Integer.parseInt(st.nextToken());
            }

            if (mes > 12) {
                return false;
            } else {
                if (dia > 31) {
                    return false;
                } else {
                    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30)) {
                        return false;
                    } else {
                        if (mes == 2 && bisiesto(anio) && dia > 29) {
                            return false;
                        } else if (mes == 2 && !bisiesto(anio) && dia > 28) {
                            return false;
                        } else {
                            flag = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return flag;
    }

    private static boolean bisiesto(int anio) {
        if (anio % 400 == 0) {
            return true;
        } else {
            if (anio % 4 == 0 && anio % 100 != 0) {
                return true;
            } else {
                return false;
            }
        }
    }
//    public static String fechaSistemaAAAAmmdd(){
//        Date fecha = new Date();
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd", locale);
//        return formato.format(fecha);
//    }

    public static String fechaSistema() {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        return formato.format(fecha);
    }
    //
//    public static Date fechaStringFecha_Date(String fecha){
//        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        try {
//            date = (Date) formato.parse(fecha);
//        } catch (Exception e) {
//            date = null;
//        }
//        return date;
//    }
//    public static String fechaDate_String(Date fecha){
//        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return formato.format(fecha);
//    }
//    public static String fechaYyMmDdSinHora(Date fecha){
//        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        return formato.format(fecha);
//    }
//    public static String fechaAmD(Date fecha){
//        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        return formato.format(fecha);
//    }
    //

    public static int obtenerDiasAAMMDD(String fechaMayor, String fechaMenor) {
        fechaMayor = fechaMayor == null ? fecha(getUltimoDiaDelMes(fechaMenor, "yyyy-MM-dd"), "yyyy-MM-dd") : fechaMayor;
        fechaMenor = fechaMenor == null ? fecha(getPrimerDiaDelMes(fechaMayor, "yyyy-MM-dd"), "yyyy-MM-dd") : fechaMenor;
        String ano = "", mes = "", dia = "";
        try {
            ano = fechaMayor.trim().substring(0, 4);
            mes = fechaMayor.trim().substring(5, 7);
            dia = fechaMayor.trim().substring(8);
            org.joda.time.DateMidnight dateMayor = new org.joda.time.DateMidnight(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));

            ano = fechaMenor.trim().substring(0, 4);
            mes = fechaMenor.trim().substring(5, 7);
            dia = fechaMenor.trim().substring(8);
            org.joda.time.DateMidnight dateMenor = new org.joda.time.DateMidnight(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));

            org.joda.time.Period period = new org.joda.time.Period(dateMenor, dateMayor, org.joda.time.PeriodType.days());

            return period.getDays();
        } catch (Exception e) {
            return 0;
        }
    }

    public static int numeroDias(String formato, String fechaInicio, String fechaFin) {
        int retorno = 0;
        org.joda.time.Days d = org.joda.time.Days.daysBetween(new org.joda.time.DateTime(Validacion.fecha(fechaInicio, formato)), new org.joda.time.DateTime(Validacion.fecha(fechaFin, formato)));
        retorno = d.getDays();
        return retorno;
    }

    public static String fechaSumarRestarDias(Date fecha, int numeroDias, int constante) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(fecha);
        if (numeroDias == 1) {
            c1.add(Calendar.DATE, numeroDias);
            c1.add(Calendar.DATE, -constante);
        } else {
            c1.add(Calendar.DATE, -numeroDias);
            c1.add(Calendar.DATE, constante);
        }

        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(c1.getTime());
    }

    public static String fechaSumarDias(Date fecha, int numeroDias) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(fecha);
        c1.add(Calendar.DATE, numeroDias);
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(c1.getTime());
    }
//    public static String fechaSumar1Date_String(Date fecha){
//        Calendar c1 = Calendar.getInstance();
//        c1.setTime(fecha);
//        c1.add(Calendar.DATE,1);
//        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        return formato.format(c1.getTime());
//    }
//    public static Date fechaStringFechaString_Date(String fecha){
//        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = new Date();
//        try {
//            date = (Date) formato.parse(fecha);
//        } catch (Exception e) {
//            date = null;
//        }
//        return date;
//    }

    //<editor-fold defaultstate="collapsed" desc="FECHAS">
    public static String fechaSistema(String mascara) {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat(mascara, locale);
        //System.out.println("fecha del sistema "+formato.format(fecha));
        return formato.format(fecha);
    }

    public static Date fecha(String fecha, String mascara) {
        DateFormat formato = new SimpleDateFormat(mascara);
        Date date = new Date();
        try {
            date = (Date) formato.parse(fecha);
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

    public static String fecha(Date fecha, String mascara) {
        DateFormat formato = new SimpleDateFormat(mascara);
        return formato.format(fecha);
    }

    public static String fechaDiaMesAnio(String fecha, String mascara){
//        String fechaDevolver = "";
        Date fecha2 = new Date();
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(mascara);
        
        return formato.format(fecha2);
//        java.text.SimpleDateFormat formatoFecha2 = new java.text.SimpleDateFormat(mascara2);
//        try {            
//            SimpleDateFormat formato = new SimpleDateFormat(mascara, locale);
//            return formato.format(fecha);
            
//            formatoFecha1.parse(fecha);
            //fechaDevolver = formatoFecha1.parse(fecha);
//            fechaDevolver = formatoFecha2.format(formatoFecha1.getCalendar().getTime());
//        } catch (java.text.ParseException ex) {
//        }
//        return fechaDevolver;
    }
    
    public static String fecha(String fecha, String mascara1, String mascara2) {
        String fechaDevolver = "";
        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat(mascara1);
        java.text.SimpleDateFormat formatoFecha2 = new java.text.SimpleDateFormat(mascara2);
        try {
            formatoFecha1.parse(fecha);
            fechaDevolver = formatoFecha2.format(formatoFecha1.getCalendar().getTime());
        } catch (java.text.ParseException ex) {
        }
        return fechaDevolver;
    }

    public static Boolean isFechaSuperior(String fechaFormulario, String mascara) {
        Boolean boleano = null;
        java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat(mascara);
        try {
            if (formatoFecha.parse(fechaFormulario).getTime() > formatoFecha.parse(fechaSistema(mascara)).getTime()) {
                boleano = true;
            } else {
                boleano = false;
            }
        } catch (java.text.ParseException ex) {
            boleano = null;
        }
        return boleano;
    }

    public static Boolean isFechaSuperior(String fechaFormulario, String fechaComparar, String mascara) {
        Boolean boleano = null;
        java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat(mascara);
        try {
            if (formatoFecha.parse(fechaFormulario).getTime() > formatoFecha.parse(fechaComparar).getTime()) {
                boleano = true;
            } else {
                boleano = false;
            }
        } catch (java.text.ParseException ex) {
            boleano = null;
        }
        return boleano;
    }
    //</editor-fold>

    public static int getNumeroDia(String fecha, String mascara) {
        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat(mascara, locale);
        try {
            formatoFecha1.parse(fecha);
        } catch (java.text.ParseException ex) {
        }
        java.util.Calendar calendarioAux = java.util.Calendar.getInstance();
        calendarioAux.setTime(formatoFecha1.getCalendar().getTime());
        return calendarioAux.get(java.util.Calendar.DAY_OF_WEEK);
    }

    public static int getNumeroMes(String fecha) {
        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat("dd-MM-yyyy");
        try {
            formatoFecha1.parse(fecha);
        } catch (java.text.ParseException ex) {
        }
        java.util.Calendar calendarioAux = java.util.Calendar.getInstance();
        calendarioAux.setTime(formatoFecha1.getCalendar().getTime());
        calendarioAux.set(calendarioAux.get(java.util.Calendar.YEAR),
                calendarioAux.get(java.util.Calendar.MONTH),
                calendarioAux.getActualMinimum(java.util.Calendar.DAY_OF_MONTH));
        return calendarioAux.get(java.util.Calendar.MONTH);
    }

    public static java.util.Date getPrimerDiaDelMes(String fecha, String mascara) {
        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat(mascara);
        try {
            formatoFecha1.parse(fecha);
        } catch (java.text.ParseException ex) {
        }
        java.util.Calendar calendarioAux = java.util.Calendar.getInstance();
        calendarioAux.setTime(formatoFecha1.getCalendar().getTime());
        calendarioAux.set(calendarioAux.get(java.util.Calendar.YEAR),
                calendarioAux.get(java.util.Calendar.MONTH),
                calendarioAux.getActualMinimum(java.util.Calendar.DAY_OF_MONTH));
        return calendarioAux.getTime();
    }

    public static java.util.Date getUltimoDiaDelMes(String fecha, String mascara) {
        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat(mascara);
        try {
            formatoFecha1.parse(fecha);
        } catch (java.text.ParseException ex) {
        }

        java.util.Calendar calendarioAux = java.util.Calendar.getInstance();
        calendarioAux.setTime(formatoFecha1.getCalendar().getTime());
        calendarioAux.set(calendarioAux.get(java.util.Calendar.YEAR),
                calendarioAux.get(java.util.Calendar.MONTH),
                calendarioAux.getActualMaximum(java.util.Calendar.DAY_OF_MONTH));
        return calendarioAux.getTime();
    }

//    //<editor-fold defaultstate="collapsed" desc="BORRAR ESTO">
//    public static java.util.Date getPrimerDiaDelMes(String fecha) {
//        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
//        try {
//            formatoFecha1.parse(fecha);
//        } catch (java.text.ParseException ex) {}
//        java.util.Calendar calendarioAux = java.util.Calendar.getInstance();
//        calendarioAux.setTime(formatoFecha1.getCalendar().getTime());
//        calendarioAux.set(calendarioAux.get(java.util.Calendar.YEAR),
//                calendarioAux.get(java.util.Calendar.MONTH),
//                calendarioAux.getActualMinimum(java.util.Calendar.DAY_OF_MONTH));
//        return calendarioAux.getTime();
//    }
//    
//    public static java.util.Date getUltimoDiaDelMes(String fecha) {
//        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
//        try {
//            formatoFecha1.parse(fecha);
//        } catch (java.text.ParseException ex) {}
//        
//        java.util.Calendar calendarioAux = java.util.Calendar.getInstance();
//        calendarioAux.setTime(formatoFecha1.getCalendar().getTime());
//        calendarioAux.set(calendarioAux.get(java.util.Calendar.YEAR),
//                calendarioAux.get(java.util.Calendar.MONTH),
//                calendarioAux.getActualMaximum(java.util.Calendar.DAY_OF_MONTH));
//        return calendarioAux.getTime();
//    }
//    //</editor-fold>
    public static String convertirDdMmAaaaTOaaaaMmDd(String fecha) {
        String fechaDevolver = "";
        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat("dd-MM-yyyy");
        java.text.SimpleDateFormat formatoFecha2 = new java.text.SimpleDateFormat("yyyy-MM-dd");
        try {
            formatoFecha1.parse(fecha);
            fechaDevolver = formatoFecha2.format(formatoFecha1.getCalendar().getTime());
        } catch (java.text.ParseException ex) {
        }
        return fechaDevolver;
    }

    public static String convertirAaaaMmDdTODdMmAaaa(String fecha) {
        String fechaDevolver = "";
        java.text.SimpleDateFormat formatoFecha1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat formatoFecha2 = new java.text.SimpleDateFormat("dd-MM-yyyy");
        try {
            formatoFecha1.parse(fecha);
            fechaDevolver = formatoFecha2.format(formatoFecha1.getCalendar().getTime());
        } catch (java.text.ParseException ex) {
        }
        return fechaDevolver;
    }

    public static Date fechaCaducaFacturaRetencion(String fecha, String mascara) {
        DateFormat formato = new SimpleDateFormat(mascara);
        Date date = new Date();
        try {
            date = (Date) formato.parse(fecha);
        } catch (Exception e) {
            date = null;
        }
        return date;
    }
//    public static Date fechaCaducaFacturaRetencion(String fecha){
//        DateFormat formato = new SimpleDateFormat("MM/yyyy");
//        Date date = new Date();
//        try {
//            date = (Date) formato.parse(fecha);
//        } catch (Exception e) {
//            date = null;
//        }
//        return date;
//    }+

    //<editor-fold defaultstate="collapsed" desc="COMPROBAR">
    /**
     * Valida si el par�metro es una fecha con el formato "dd-mm-yyyy".
     *
     * @return true si cumple el formato, false en caso contrario.
     */
    public static boolean leerFecha(Date mensaje) {
        //JOptionPane.showMessageDialog(null, mensaje.toString().length());
        if (mensaje == null) {
            return false;
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd", locale); //dia-mes-a�o
        String fecha = formato.format(mensaje);
        if (fecha.length() != formato.toPattern().length()) {
            return false;
        }
        formato.setLenient(false);//deshabilita el modo permisivo para rango de 28,29,30 y 31 dias
        try {
            formato.parse(fecha);
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static boolean leerNumerosInt(String mensaje) {
        boolean retorno = true;
        try {
            Integer.parseInt(mensaje);
            //retorno=true;
        } catch (NumberFormatException x) {
            retorno = false;
        }
        return retorno;
    }

    public static boolean leerNumerosDouble(String mensaje) {
        boolean retorno = true;
        try {
            Double.parseDouble(mensaje);
            //retorno=true;
        } catch (NumberFormatException x) {
            retorno = false;
        }
        return retorno;
    }

    public static boolean leerNumerosFloat(String mensaje) {
        boolean retorno = true;
        try {
            Float.parseFloat(mensaje);
            //retorno=true;
        } catch (NumberFormatException x) {
            retorno = false;
        }
        return retorno;
    }

    public static boolean leerLetras(String mensaje) {
        boolean retorno = true;
        int i = 0;
        while (i < mensaje.length()) {
            if ((Character.isLetter(mensaje.charAt(i)) || (Character.isWhitespace(mensaje.charAt(i))))) {
                retorno = true;
            } else {
                retorno = false;
                break;
            }
            i++;
        }
        return retorno;
    }

    //metodo para validar correo electronio
    /*
     * cpreciado@gye.satnet.net
     */
//    public static boolean isEmail(String correo) {
//        java.util.regex.Pattern pat = null;
//        java.util.regex.Matcher mat = null;
//        pat = java.util.regex.Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
//        mat = pat.matcher(correo);
//        if (mat.find()) {
//            return true;
//        }else{
//            return false;
//        }
//    }
    public static boolean isEmail(String correo) {
        if (correo.indexOf('@') > -1) {
            return true;
        } else {
            return false;
        }
    }
    //</editor-fold>

    public static double ConvertirObjectToDouble(Object Objeto) {
        double numero_double = 0;
        try {
            String Str = Objeto.toString();
            numero_double = Double.valueOf(Str).doubleValue();
        } catch (Exception e) {
        }
        return numero_double;
    }
//    private BigDecimal redondeoDecimalBigDecimal(BigDecimal d) { //RRHH
//    	java.text.DecimalFormat formato = new java.text.DecimalFormat("#.##");
//    	java.text.DecimalFormatSymbols dfs = formato.getDecimalFormatSymbols();
//        dfs.setDecimalSeparator('.');
//        formato.setDecimalFormatSymbols(dfs);
//    	return BigDecimal.valueOf(Double.valueOf(formato.format(d)));
//    }

    public static java.math.BigDecimal redondeoDecimalBigDecimal(java.math.BigDecimal d) {
        java.text.DecimalFormat formato = new java.text.DecimalFormat("#.##");
        java.text.DecimalFormatSymbols dfs = formato.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        formato.setDecimalFormatSymbols(dfs);
        return new java.math.BigDecimal(formato.format(d));
    }

    public static java.math.BigDecimal redondeoDecimalBigDecimal(java.math.BigDecimal d, int precision, java.math.RoundingMode metodoRedondeo) {
        java.math.BigDecimal retorno = d;
        return retorno.setScale(precision, metodoRedondeo);
    }

    public static java.math.BigDecimal redondeoDecimalBigDecimal(java.math.BigDecimal d, String formato) {
        java.text.DecimalFormat format = new java.text.DecimalFormat(formato);
        java.text.DecimalFormatSymbols dfs = format.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        format.setDecimalFormatSymbols(dfs);
        return new java.math.BigDecimal(format.format(d));
    }

    public static Double redondeoDeDoubles(Double d) {
        java.text.DecimalFormat formato = new java.text.DecimalFormat("#.##");
        java.text.DecimalFormatSymbols dfs = formato.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        formato.setDecimalFormatSymbols(dfs);
        return Double.valueOf(formato.format(d));
    }

    public static java.util.List<String> separar(String listaAux, String separador) {
        java.util.List<String> lista = new java.util.ArrayList();
        int indice = 0;
        int token = new java.util.StringTokenizer(listaAux, separador).countTokens();
        for (int i = 0; i < token; i++) {
            if (i == 0) {
                lista.add(listaAux.substring(indice, listaAux.indexOf(separador, indice + 1)).trim());
            } else if (i == token - 1) {
                lista.add(listaAux.substring(indice + 1, listaAux.length()).trim());
            } else {
                lista.add(listaAux.substring(indice + 1, listaAux.indexOf(separador, indice + 1)).trim());
            }
            indice = listaAux.indexOf(separador, indice + 1);
        }
        return lista;
    }

    public static java.util.List<String> separarComprobante(String comprobante) {
//        String comprobante = "2011-05 | C-ANT | 0000001";
        java.util.List<String> comprobantes = new java.util.ArrayList();
        String perCodigo = "";
        String tipCodigo = "";
        String conNumero = "";
        int indice = 0;

        perCodigo = comprobante.substring(0, comprobante.indexOf("|"));
        indice = comprobante.indexOf("|");

        tipCodigo = comprobante.substring(indice + 1, comprobante.indexOf("|", indice + 1));
        indice = comprobante.indexOf("|", indice + 1);

        conNumero = comprobante.substring(indice + 1);



        comprobantes.add(perCodigo.trim());
        comprobantes.add(tipCodigo.trim());
        comprobantes.add(conNumero.trim());

        return comprobantes;
    }

    public static String formatoCapitalizado(String sentence) {
//        sentence = "whY dId tHe Duck Eat sTuFF 111!@#$%^&*()";
        StringBuilder bob = new StringBuilder();
        if (sentence != null) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                for (String string : sentence.split(" ")) {
                    if (string.compareToIgnoreCase("") != 0) {
                        bob.append(string.substring(0, 1).toUpperCase());
                        bob.append(string.substring(1).toLowerCase());
                        bob.append(" ");
                    }
                }
            }
        }
        return bob.toString().trim();
    }

    public static String eliminaCaracteres(String s_cadena, String s_caracteres) {
        String nueva_cadena = "";
        Character caracter = null;
        boolean valido = true;

        /*
         * Va recorriendo la cadena s_cadena y copia a la cadena que va a
         * regresar, sólo los caracteres que no estén en la cadena s_caracteres
         */
        for (int i = 0; i < s_cadena.length(); i++) {
            valido = true;
            for (int j = 0; j < s_caracteres.length(); j++) {
                caracter = s_caracteres.charAt(j);

                if (s_cadena.charAt(i) == caracter) {
                    valido = false;
                    break;
                }
            }
            if (valido) {
                nueva_cadena += s_cadena.charAt(i);
            }
        }

        return nueva_cadena;
    }
    
    

    public static void main(String args[]) {

    }
}
