/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;
import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class InvProformaCabeceraTO implements java.io.Serializable{
    
    
    
    private String profFecha;
    
    private java.math.BigDecimal profIvaVigente;
    private String profObservaciones;
    private Boolean profPendiente;
    
    private Boolean profAnulado;
    
    private java.math.BigDecimal profBase0;
    private java.math.BigDecimal profBaseimponible;
    
    private java.math.BigDecimal profDescuentoBase0;
    private java.math.BigDecimal profDescuentoBaseImponible;
    private java.math.BigDecimal profDescuentoGeneralBase0;
    private java.math.BigDecimal profDescuentoGeneralBaseImponible;
    private java.math.BigDecimal profDescuentoIva;
    private java.math.BigDecimal profSubtotalBase0;
    private java.math.BigDecimal profSubtotalBaseImponible;
    
    private java.math.BigDecimal profMontoiva;
    private java.math.BigDecimal profTotal;
    private String cliCodigo;
    private String cliEmpresa;

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        this.cliEmpresa = cliEmpresa;
    }
    
    
    
    
    private String userEmpresa;
    private String usuarioInserto;
    private String fechaUsuarioInserto;
    
    public InvProformaCabeceraTO() {
    }

    public InvProformaCabeceraTO(String profFecha, BigDecimal profIvaVigente, String profObservaciones, Boolean profPendiente, Boolean profAnulado, BigDecimal profBase0, BigDecimal profBaseimponible, BigDecimal profDescuentoBase0, BigDecimal profDescuentoBaseImponible, BigDecimal profDescuentoGeneralBase0, BigDecimal profDescuentoGeneralBaseImponible, BigDecimal profDescuentoIva, BigDecimal profSubtotalBase0, BigDecimal profSubtotalBaseImponible, BigDecimal profMontoiva, BigDecimal profTotal, String cliCodigo,String cliEmpresa, String usuarioInserto, String fechaUsuarioInserto) {
        this.profFecha = profFecha;
        this.profIvaVigente = profIvaVigente;
        this.profObservaciones = profObservaciones;
        this.profPendiente = profPendiente;
        this.profAnulado = profAnulado;
        this.profBase0 = profBase0;
        this.profBaseimponible = profBaseimponible;
        this.profDescuentoBase0 = profDescuentoBase0;
        this.profDescuentoBaseImponible = profDescuentoBaseImponible;
        this.profDescuentoGeneralBase0 = profDescuentoGeneralBase0;
        this.profDescuentoGeneralBaseImponible = profDescuentoGeneralBaseImponible;
        this.profDescuentoIva = profDescuentoIva;
        this.profSubtotalBase0 = profSubtotalBase0;
        this.profSubtotalBaseImponible = profSubtotalBaseImponible;
        this.profMontoiva = profMontoiva;
        this.profTotal = profTotal;
        this.cliCodigo = cliCodigo;
        this.cliEmpresa = cliEmpresa;
        
        this.usuarioInserto = usuarioInserto;
        this.fechaUsuarioInserto = fechaUsuarioInserto;        
    }

    public String getProfFecha() {
        return profFecha;
    }

    public void setProfFecha(String profFecha) {
        this.profFecha = profFecha;
    }

    public BigDecimal getProfIvaVigente() {
        return profIvaVigente;
    }

    public void setProfIvaVigente(BigDecimal profIvaVigente) {
        this.profIvaVigente = profIvaVigente;
    }

    public String getProfObservaciones() {
        return profObservaciones;
    }

    public void setProfObservaciones(String profObservaciones) {
        this.profObservaciones = profObservaciones;
    }

    public Boolean getProfPendiente() {
        return profPendiente;
    }

    public void setProfPendiente(Boolean profPendiente) {
        this.profPendiente = profPendiente;
    }

    public Boolean getProfAnulado() {
        return profAnulado;
    }

    public void setProfAnulado(Boolean profAnulado) {
        this.profAnulado = profAnulado;
    }

    public BigDecimal getProfBase0() {
        return profBase0;
    }

    public void setProfBase0(BigDecimal profBase0) {
        this.profBase0 = profBase0;
    }

    public BigDecimal getProfBaseimponible() {
        return profBaseimponible;
    }

    public void setProfBaseimponible(BigDecimal profBaseimponible) {
        this.profBaseimponible = profBaseimponible;
    }

    public BigDecimal getProfDescuentoBase0() {
        return profDescuentoBase0;
    }

    public void setProfDescuentoBase0(BigDecimal profDescuentoBase0) {
        this.profDescuentoBase0 = profDescuentoBase0;
    }

    public BigDecimal getProfDescuentoBaseImponible() {
        return profDescuentoBaseImponible;
    }

    public void setProfDescuentoBaseImponible(BigDecimal profDescuentoBaseImponible) {
        this.profDescuentoBaseImponible = profDescuentoBaseImponible;
    }

    public BigDecimal getProfDescuentoGeneralBase0() {
        return profDescuentoGeneralBase0;
    }

    public void setProfDescuentoGeneralBase0(BigDecimal profDescuentoGeneralBase0) {
        this.profDescuentoGeneralBase0 = profDescuentoGeneralBase0;
    }

    public BigDecimal getProfDescuentoGeneralBaseImponible() {
        return profDescuentoGeneralBaseImponible;
    }

    public void setProfDescuentoGeneralBaseImponible(BigDecimal profDescuentoGeneralBaseImponible) {
        this.profDescuentoGeneralBaseImponible = profDescuentoGeneralBaseImponible;
    }

    public BigDecimal getProfDescuentoIva() {
        return profDescuentoIva;
    }

    public void setProfDescuentoIva(BigDecimal profDescuentoIva) {
        this.profDescuentoIva = profDescuentoIva;
    }

    public BigDecimal getProfSubtotalBase0() {
        return profSubtotalBase0;
    }

    public void setProfSubtotalBase0(BigDecimal profSubtotalBase0) {
        this.profSubtotalBase0 = profSubtotalBase0;
    }

    public BigDecimal getProfSubtotalBaseImponible() {
        return profSubtotalBaseImponible;
    }

    public void setProfSubtotalBaseImponible(BigDecimal profSubtotalBaseImponible) {
        this.profSubtotalBaseImponible = profSubtotalBaseImponible;
    }

    public BigDecimal getProfMontoiva() {
        return profMontoiva;
    }

    public void setProfMontoiva(BigDecimal profMontoiva) {
        this.profMontoiva = profMontoiva;
    }

    public BigDecimal getProfTotal() {
        return profTotal;
    }

    public void setProfTotal(BigDecimal profTotal) {
        this.profTotal = profTotal;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getUsuarioInserto() {
        return usuarioInserto;
    }

    public void setUsuarioInserto(String usuarioInserto) {
        this.usuarioInserto = usuarioInserto;
    }

    public String getFechaUsuarioInserto() {
        return fechaUsuarioInserto;
    }

    public void setFechaUsuarioInserto(String fechaUsuarioInserto) {
        this.fechaUsuarioInserto = fechaUsuarioInserto;
    }

    public String getUserEmpresa() {
        return userEmpresa;
    }

    public void setUserEmpresa(String userEmpresa) {
        this.userEmpresa = userEmpresa;
    }

    
    
    @Override
    public String toString(){
        return this.profFecha + " " + this.profIvaVigente +
                " " + this.profObservaciones + " " + this.profPendiente +
                " " + this.profAnulado+ " " + this.profBase0 + " " + this.profBaseimponible +
                " " + this.profDescuentoBase0 + " " + this.profMontoiva + " " + this.profTotal + " " + this.cliCodigo;
    }
}
