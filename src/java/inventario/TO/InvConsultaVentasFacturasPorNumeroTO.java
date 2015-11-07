/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * 
 */
public class InvConsultaVentasFacturasPorNumeroTO implements java.io.Serializable{
    //String empresa, String perCodigo, String motCodigo, String compNumero
    private String vtaEmpresa;
    private String vtaPeriodo;
    private String vtaMotivo;
    private String vtaNumero;

    public InvConsultaVentasFacturasPorNumeroTO() {
    }

    public InvConsultaVentasFacturasPorNumeroTO(String vtaEmpresa, String vtaPeriodo, String vtaMotivo, String vtaNumero) {
        this.vtaEmpresa = vtaEmpresa;
        this.vtaPeriodo = vtaPeriodo;
        this.vtaMotivo = vtaMotivo;
        this.vtaNumero = vtaNumero;
    }

    public String getVtaEmpresa() {
        return vtaEmpresa;
    }

    public void setVtaEmpresa(String vtaEmpresa) {
        this.vtaEmpresa = vtaEmpresa;
    }

    public String getVtaMotivo() {
        return vtaMotivo;
    }

    public void setVtaMotivo(String vtaMotivo) {
        this.vtaMotivo = vtaMotivo;
    }

    public String getVtaNumero() {
        return vtaNumero;
    }

    public void setVtaNumero(String vtaNumero) {
        this.vtaNumero = vtaNumero;
    }

    public String getVtaPeriodo() {
        return vtaPeriodo;
    }

    public void setVtaPeriodo(String vtaPeriodo) {
        this.vtaPeriodo = vtaPeriodo;
    }

}
