/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.TO;

/**
 *
 * @author jack
 */
public class BanChequeTO implements java.io.Serializable{
    private Long chqSecuencia;
    private String chqBeneficiario;
    private String chqCantidad;
    private String chqCiudad;
    private String chqFecha;
    private boolean chqCruzado;
    private boolean chqImpreso;
    private String  chqImpresoFecha;
    private boolean chqRevisado;
    private String chqRevisadoFecha;
    private String chqRevisadoObservacion;
    private boolean chqEntregado;
    private String chqEntregadoFecha;
    private String chqEntregadoObservacion;
    private boolean chqReversado;
    private String chqReversadoFecha;
    private String chqReversadoObservacion;
    private boolean chqAnulado;
    private String chqAnuladooFecha;
    private String chqAnuladoObservacion; 
    private boolean chqNoCheque;
    private String concEmpresa;
    private String concCuentaContable;
    private String concCodigo;
    private Long detSecuencia;

    

    public BanChequeTO() {
    }

    public BanChequeTO(Long chqSecuencia, String chqBeneficiario, String chqCantidad, String chqCiudad, String chqFecha, boolean chqCruzado, boolean chqImpreso, String chqImpresoFecha, boolean chqRevisado, String chqRevisadoFecha, String chqRevisadoObservacion, boolean chqEntregado, String chqEntregadoFecha, String chqEntregadoObservacion, boolean chqReversado, String chqReversadoFecha, String chqReversadoObservacion, boolean chqAnulado, String chqAnuladooFecha, String chqAnuladoObservacion, boolean chqNoCheque, String concEmpresa, String concCuentaContable, String concCodigo, Long detSecuencia) {
        this.chqSecuencia = chqSecuencia;
        this.chqBeneficiario = chqBeneficiario;
        this.chqCantidad = chqCantidad;
        this.chqCiudad = chqCiudad;
        this.chqFecha = chqFecha;
        this.chqCruzado = chqCruzado;
        this.chqImpreso = chqImpreso;
        this.chqImpresoFecha = chqImpresoFecha;
        this.chqRevisado = chqRevisado;
        this.chqRevisadoFecha = chqRevisadoFecha;
        this.chqRevisadoObservacion = chqRevisadoObservacion;
        this.chqEntregado = chqEntregado;
        this.chqEntregadoFecha = chqEntregadoFecha;
        this.chqEntregadoObservacion = chqEntregadoObservacion;
        this.chqReversado = chqReversado;
        this.chqReversadoFecha = chqReversadoFecha;
        this.chqReversadoObservacion = chqReversadoObservacion;
        this.chqAnulado = chqAnulado;
        this.chqAnuladooFecha = chqAnuladooFecha;
        this.chqAnuladoObservacion = chqAnuladoObservacion;
        this.chqNoCheque = chqNoCheque;
        this.concEmpresa = concEmpresa;
        this.concCuentaContable = concCuentaContable;
        this.concCodigo = concCodigo;
        this.detSecuencia = detSecuencia;
    }
    
    public String getChqImpresoFecha() {
        return chqImpresoFecha;
    }

    public void setChqImpresoFecha(String chqImpresoFecha) {
        this.chqImpresoFecha = chqImpresoFecha;
    }

    public String getChqRevisadoFecha() {
        return chqRevisadoFecha;
    }

    public void setChqRevisadoFecha(String chqRevisadoFecha) {
        this.chqRevisadoFecha = chqRevisadoFecha;
    }

    public String getChqEntregadoFecha() {
        return chqEntregadoFecha;
    }

    public void setChqEntregadoFecha(String chqEntregadoFecha) {
        this.chqEntregadoFecha = chqEntregadoFecha;
    }

    public boolean isChqReversado() {
        return chqReversado;
    }

    public void setChqReversado(boolean chqReversado) {
        this.chqReversado = chqReversado;
    }

    public String getChqReversadoFecha() {
        return chqReversadoFecha;
    }

    public void setChqReversadoFecha(String chqReversadoFecha) {
        this.chqReversadoFecha = chqReversadoFecha;
    }

    public String getChqReversadoObservacion() {
        return chqReversadoObservacion;
    }

    public void setChqReversadoObservacion(String chqReversadoObservacion) {
        this.chqReversadoObservacion = chqReversadoObservacion;
    }

    public boolean getChqAnulado() {
        return chqAnulado;
    }

    public void setChqAnulado(boolean chqAnulado) {
        this.chqAnulado = chqAnulado;
    }

    public String getChqAnuladooFecha() {
        return chqAnuladooFecha;
    }

    public void setChqAnuladooFecha(String chqAnuladooFecha) {
        this.chqAnuladooFecha = chqAnuladooFecha;
    }

    public String getChqAnuladoObservacion() {
        return chqAnuladoObservacion;
    }

    public void setChqAnuladoObservacion(String chqAnuladoObservacion) {
        this.chqAnuladoObservacion = chqAnuladoObservacion;
    }

   

    public String getChqBeneficiario() {
        return chqBeneficiario;
    }

    public void setChqBeneficiario(String chqBeneficiario) {
        this.chqBeneficiario = chqBeneficiario;
    }

    public String getChqCantidad() {
        return chqCantidad;
    }

    public void setChqCantidad(String chqCantidad) {
        this.chqCantidad = chqCantidad;
    }

    public String getChqCiudad() {
        return chqCiudad;
    }

    public void setChqCiudad(String chqCiudad) {
        this.chqCiudad = chqCiudad;
    }

    public boolean isChqCruzado() {
        return chqCruzado;
    }

    public void setChqCruzado(boolean chqCruzado) {
        this.chqCruzado = chqCruzado;
    }

    public boolean isChqEntregado() {
        return chqEntregado;
    }

    public void setChqEntregado(boolean chqEntregado) {
        this.chqEntregado = chqEntregado;
    }

    public String getChqEntregadoObservacion() {
        return chqEntregadoObservacion;
    }

    public void setChqEntregadoObservacion(String chqEntregadoObservacion) {
        this.chqEntregadoObservacion = chqEntregadoObservacion;
    }

    public String getChqFecha() {
        return chqFecha;
    }

    public void setChqFecha(String chqFecha) {
        this.chqFecha = chqFecha;
    }

    public boolean isChqImpreso() {
        return chqImpreso;
    }

    public void setChqImpreso(boolean chqImpreso) {
        this.chqImpreso = chqImpreso;
    }

    public boolean isChqNoCheque() {
        return chqNoCheque;
    }

    public void setChqNoCheque(boolean chqNoCheque) {
        this.chqNoCheque = chqNoCheque;
    }

    public boolean isChqRevisado() {
        return chqRevisado;
    }

    public void setChqRevisado(boolean chqRevisado) {
        this.chqRevisado = chqRevisado;
    }

    public String getChqRevisadoObservacion() {
        return chqRevisadoObservacion;
    }

    public void setChqRevisadoObservacion(String chqRevisadoObservacion) {
        this.chqRevisadoObservacion = chqRevisadoObservacion;
    }

    public Long getChqSecuencia() {
        return chqSecuencia;
    }

    public void setChqSecuencia(Long chqSecuencia) {
        this.chqSecuencia = chqSecuencia;
    }

    public String getConcCodigo() {
        return concCodigo;
    }

    public void setConcCodigo(String concCodigo) {
        this.concCodigo = concCodigo;
    }

    public String getConcCuentaContable() {
        return concCuentaContable;
    }

    public void setConcCuentaContable(String concCuentaContable) {
        this.concCuentaContable = concCuentaContable;
    }

    public String getConcEmpresa() {
        return concEmpresa;
    }

    public void setConcEmpresa(String concEmpresa) {
        this.concEmpresa = concEmpresa;
    }

    public Long getDetSecuencia() {
        return detSecuencia;
    }

    public void setDetSecuencia(Long detSecuencia) {
        this.detSecuencia = detSecuencia;
    }
    
}
