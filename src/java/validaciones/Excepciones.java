/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validaciones;

/**
 *
 * @author jack
 */
public class Excepciones {
    @javax.ejb.EJB
    static sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    private static sistema.TO.SisErrorTO sisErrorTO = null;

    public Excepciones() {
    }
    
    private static sistema.TO.SisErrorTO guardarExcepciones (
            Exception e, 
            String nombreClase, 
            String metodoClase, 
            sistema.TO.SisInfoTO sisInfoTO) throws Exception{
        String sentencia = "";
        String clase = "";
        String archivo = "";
        String linea = "";
        String metodo = "";
        sisErrorTO = new sistema.TO.SisErrorTO();
        StackTraceElement[] elementosRastreo = e.getStackTrace();
        for ( int i = 0; i < elementosRastreo.length; i++ ) {
            StackTraceElement elementoActual = elementosRastreo[ i ];
            if (elementosRastreo.length == 0){
                sentencia = "NullPointerException";
                clase = nombreClase;
                archivo = "N/A";
                linea = "N/A";
                metodo = metodoClase == null ? "N/A" : metodoClase;
                i = elementosRastreo.length;
            }
            if (elementoActual.getClassName().equals(nombreClase)){
                sentencia = e.getLocalizedMessage();
                clase = elementoActual.getClassName();
                archivo = elementoActual.getFileName();
                linea = String.valueOf(elementoActual.getLineNumber());
                metodo = elementoActual.getMethodName();
                i = elementosRastreo.length;
            }
        }
        sisErrorTO.setErSecuencia(0);
        sisErrorTO.setErSentencia(sentencia);
        sisErrorTO.setErSentencia(sisErrorTO.getErSentencia().length() > 1000 ? sisErrorTO.getErSentencia().substring(0, 1000) : sisErrorTO.getErSentencia());
        sisErrorTO.setErClase(clase);
        sisErrorTO.setErClase(sisErrorTO.getErClase().length() > 115 ? sisErrorTO.getErClase().substring(0, 115) : sisErrorTO.getErClase());
        sisErrorTO.setErArchivo(archivo);
        sisErrorTO.setErArchivo(sisErrorTO.getErArchivo().length() > 50 ? sisErrorTO.getErArchivo().substring(0, 50) : sisErrorTO.getErArchivo());
        sisErrorTO.setErLinea(linea);
        sisErrorTO.setErLinea(sisErrorTO.getErLinea().length() > 30 ? sisErrorTO.getErLinea().substring(0, 30) : sisErrorTO.getErLinea());
        sisErrorTO.setErMetodo(metodo);
        sisErrorTO.setErMetodo(sisErrorTO.getErMetodo().length() > 50 ? sisErrorTO.getErMetodo().substring(0, 50) : sisErrorTO.getErMetodo());
        sisErrorTO.setInfMac(sisInfoTO.getInfMac());
        sisErrorTO.setInfMac(sisErrorTO.getInfMac().length() > 17 ? sisErrorTO.getInfMac().substring(0, 17) : sisErrorTO.getInfMac());
        sisErrorTO.setEmpCodigo(sisInfoTO.getInfEmpresa());
        sisErrorTO.setUsrCodigo(sisInfoTO.getInfUsuario());
        sisErrorTO.setErFecha(validaciones.Validacion.fechaSistema());
        return sisErrorTO;
    }
    public static void guardarExcepcionesEJB (
            Exception e, 
            String nombreClase, 
            String metodo, 
            sistema.TO.SisInfoTO sisInfoTO, 
            sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal){
        System.out.println("\n\nwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        e.printStackTrace();
        System.out.println("fffffffffffffffffffffffffffffffffffffff");
        sisErrorTO = new sistema.TO.SisErrorTO();
        try {
            sisErrorTO = validaciones.Excepciones.guardarExcepciones(
                    e,
                    nombreClase,
                    metodo,
                    sisInfoTO);
            operacionesSistemaDAOTransaccionLocal.insertarSisErrorTO(
                    sisErrorTO, 
                    sisInfoTO.getInfEmpresa());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}