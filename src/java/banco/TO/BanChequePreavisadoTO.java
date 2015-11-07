/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.TO;

/**
 *
 * @author jack
 */
public class BanChequePreavisadoTO implements java.io.Serializable {
    private String chqTipoRegistro;
    private String chqSecuencial;
    private String chqBeneficiarioCodigo;
    private String chqBeneficiarioTipoId;
    private String chqBeneficiarioNumeroId;
    private String chqBeneficiarioNombre;
    private String chqFormaPago;
    private String chqCodigoPais;
    private String chqCodigoBanco;
    private String chqCuentaTipo;
    private String chqCuentaNumero;
    private String chqChequeNumero;
    private String chqChequeMoneda;
    private String chqChequeValor;
    private String chqReferencia;
    private String chqCodigoServicio;
    private String chqChequeTipo;
    private String chqCodigoEmpresa;
    private String chqFechaRevision;

    public BanChequePreavisadoTO() {
    }

    public BanChequePreavisadoTO(String chqTipoRegistro, String chqSecuencial, String chqBeneficiarioCodigo, String chqBeneficiarioTipoId, String chqBeneficiarioNumeroId, String chqBeneficiarioNombre, String chqFormaPago, String chqCodigoPais, String chqCodigoBanco, String chqCuentaTipo, String chqCuentaNumero, String chqChequeNumero, String chqChequeMoneda, String chqChequeValor, String chqReferencia, String chqCodigoServicio, String chqChequeTipo, String chqCodigoEmpresa, String chqFechaRevision) {
        this.chqTipoRegistro = chqTipoRegistro;
        this.chqSecuencial = chqSecuencial;
        this.chqBeneficiarioCodigo = chqBeneficiarioCodigo;
        this.chqBeneficiarioTipoId = chqBeneficiarioTipoId;
        this.chqBeneficiarioNumeroId = chqBeneficiarioNumeroId;
        this.chqBeneficiarioNombre = chqBeneficiarioNombre;
        this.chqFormaPago = chqFormaPago;
        this.chqCodigoPais = chqCodigoPais;
        this.chqCodigoBanco = chqCodigoBanco;
        this.chqCuentaTipo = chqCuentaTipo;
        this.chqCuentaNumero = chqCuentaNumero;
        this.chqChequeNumero = chqChequeNumero;
        this.chqChequeMoneda = chqChequeMoneda;
        this.chqChequeValor = chqChequeValor;
        this.chqReferencia = chqReferencia;
        this.chqCodigoServicio = chqCodigoServicio;
        this.chqChequeTipo = chqChequeTipo;
        this.chqCodigoEmpresa = chqCodigoEmpresa;
        this.chqFechaRevision = chqFechaRevision;
    }

    public String getChqBeneficiarioCodigo() {
        return chqBeneficiarioCodigo;
    }

    public void setChqBeneficiarioCodigo(String chqBeneficiarioCodigo) {
        this.chqBeneficiarioCodigo = chqBeneficiarioCodigo;
    }

    public String getChqBeneficiarioNombre() {
        return chqBeneficiarioNombre;
    }

    public void setChqBeneficiarioNombre(String chqBeneficiarioNombre) {
        this.chqBeneficiarioNombre = chqBeneficiarioNombre;
    }

    public String getChqBeneficiarioNumeroId() {
        return chqBeneficiarioNumeroId;
    }

    public void setChqBeneficiarioNumeroId(String chqBeneficiarioNumeroId) {
        this.chqBeneficiarioNumeroId = chqBeneficiarioNumeroId;
    }

    public String getChqBeneficiarioTipoId() {
        return chqBeneficiarioTipoId;
    }

    public void setChqBeneficiarioTipoId(String chqBeneficiarioTipoId) {
        this.chqBeneficiarioTipoId = chqBeneficiarioTipoId;
    }

    public String getChqChequeMoneda() {
        return chqChequeMoneda;
    }

    public void setChqChequeMoneda(String chqChequeMoneda) {
        this.chqChequeMoneda = chqChequeMoneda;
    }

    public String getChqChequeNumero() {
        return chqChequeNumero;
    }

    public void setChqChequeNumero(String chqChequeNumero) {
        this.chqChequeNumero = chqChequeNumero;
    }

    public String getChqChequeTipo() {
        return chqChequeTipo;
    }

    public void setChqChequeTipo(String chqChequeTipo) {
        this.chqChequeTipo = chqChequeTipo;
    }

    public String getChqChequeValor() {
        return chqChequeValor;
    }

    public void setChqChequeValor(String chqChequeValor) {
        this.chqChequeValor = chqChequeValor;
    }

    public String getChqCodigoBanco() {
        return chqCodigoBanco;
    }

    public void setChqCodigoBanco(String chqCodigoBanco) {
        this.chqCodigoBanco = chqCodigoBanco;
    }

    public String getChqCodigoEmpresa() {
        return chqCodigoEmpresa;
    }

    public void setChqCodigoEmpresa(String chqCodigoEmpresa) {
        this.chqCodigoEmpresa = chqCodigoEmpresa;
    }

    public String getChqCodigoPais() {
        return chqCodigoPais;
    }

    public void setChqCodigoPais(String chqCodigoPais) {
        this.chqCodigoPais = chqCodigoPais;
    }

    public String getChqCodigoServicio() {
        return chqCodigoServicio;
    }

    public void setChqCodigoServicio(String chqCodigoServicio) {
        this.chqCodigoServicio = chqCodigoServicio;
    }

    public String getChqCuentaNumero() {
        return chqCuentaNumero;
    }

    public void setChqCuentaNumero(String chqCuentaNumero) {
        this.chqCuentaNumero = chqCuentaNumero;
    }

    public String getChqCuentaTipo() {
        return chqCuentaTipo;
    }

    public void setChqCuentaTipo(String chqCuentaTipo) {
        this.chqCuentaTipo = chqCuentaTipo;
    }

    public String getChqFechaRevision() {
        return chqFechaRevision;
    }

    public void setChqFechaRevision(String chqFechaRevision) {
        this.chqFechaRevision = chqFechaRevision;
    }

    public String getChqFormaPago() {
        return chqFormaPago;
    }

    public void setChqFormaPago(String chqFormaPago) {
        this.chqFormaPago = chqFormaPago;
    }

    public String getChqReferencia() {
        return chqReferencia;
    }

    public void setChqReferencia(String chqReferencia) {
        this.chqReferencia = chqReferencia;
    }

    public String getChqSecuencial() {
        return chqSecuencial;
    }

    public void setChqSecuencial(String chqSecuencial) {
        this.chqSecuencial = chqSecuencial;
    }

    public String getChqTipoRegistro() {
        return chqTipoRegistro;
    }

    public void setChqTipoRegistro(String chqTipoRegistro) {
        this.chqTipoRegistro = chqTipoRegistro;
    }
}
