/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvTransferenciasDetalleTO implements java.io.Serializable{
    private Integer detSecuencial;
    private Integer detOrden;
    private java.math.BigDecimal detCantidad;
    private String bodOrigenEmpresa;
    private String bodOrigenCodigo;
    private String bodDestinoEmpresa;
    private String bodDestinoCodigo;
    private String secOrigenEmpresa;
    private String secOrigenCodigo;
    private String secDestinoEmpresa;
    private String secDestinoCodigo;
    private String proEmpresa;
    private String proCodigoPrincipal;
    private String transEmpresa;
    private String transPeriodo;
    private String transMotivo;
    private String transNumero;

    public InvTransferenciasDetalleTO() {
    }

    public InvTransferenciasDetalleTO(Integer detSecuencial, Integer detOrden, java.math.BigDecimal detCantidad, String bodOrigenEmpresa, String bodOrigenCodigo, String bodDestinoEmpresa, String bodDestinoCodigo, String secOrigenEmpresa, String secOrigenCodigo, String secDestinoEmpresa, String secDestinoCodigo, String proEmpresa, String proCodigoPrincipal, String transEmpresa, String transPeriodo, String transMotivo, String transNumero) {
        this.detSecuencial = detSecuencial;
        this.detOrden = detOrden;
        this.detCantidad = detCantidad;
        this.bodOrigenEmpresa = bodOrigenEmpresa;
        this.bodOrigenCodigo = bodOrigenCodigo;
        this.bodDestinoEmpresa = bodDestinoEmpresa;
        this.bodDestinoCodigo = bodDestinoCodigo;
        this.secOrigenEmpresa = secOrigenEmpresa;
        this.secOrigenCodigo = secOrigenCodigo;
        this.secDestinoEmpresa = secDestinoEmpresa;
        this.secDestinoCodigo = secDestinoCodigo;
        this.proEmpresa = proEmpresa;
        this.proCodigoPrincipal = proCodigoPrincipal;
        this.transEmpresa = transEmpresa;
        this.transPeriodo = transPeriodo;
        this.transMotivo = transMotivo;
        this.transNumero = transNumero;
    }

    public String getBodDestinoCodigo() {
        return bodDestinoCodigo;
    }

    public void setBodDestinoCodigo(String bodDestinoCodigo) {
        this.bodDestinoCodigo = bodDestinoCodigo;
    }

    public String getBodDestinoEmpresa() {
        return bodDestinoEmpresa;
    }

    public void setBodDestinoEmpresa(String bodDestinoEmpresa) {
        this.bodDestinoEmpresa = bodDestinoEmpresa;
    }

    public String getBodOrigenCodigo() {
        return bodOrigenCodigo;
    }

    public void setBodOrigenCodigo(String bodOrigenCodigo) {
        this.bodOrigenCodigo = bodOrigenCodigo;
    }

    public String getBodOrigenEmpresa() {
        return bodOrigenEmpresa;
    }

    public void setBodOrigenEmpresa(String bodOrigenEmpresa) {
        this.bodOrigenEmpresa = bodOrigenEmpresa;
    }

    public java.math.BigDecimal getDetCantidad() {
        return detCantidad;
    }

    public void setDetCantidad(java.math.BigDecimal detCantidad) {
        this.detCantidad = detCantidad;
    }

    public Integer getDetOrden() {
        return detOrden;
    }

    public void setDetOrden(Integer detOrden) {
        this.detOrden = detOrden;
    }

    public Integer getDetSecuencial() {
        return detSecuencial;
    }

    public void setDetSecuencial(Integer detSecuencial) {
        this.detSecuencial = detSecuencial;
    }

    public String getProCodigoPrincipal() {
        return proCodigoPrincipal;
    }

    public void setProCodigoPrincipal(String proCodigoPrincipal) {
        this.proCodigoPrincipal = proCodigoPrincipal;
    }

    public String getProEmpresa() {
        return proEmpresa;
    }

    public void setProEmpresa(String proEmpresa) {
        this.proEmpresa = proEmpresa;
    }

    public String getSecDestinoCodigo() {
        return secDestinoCodigo;
    }

    public void setSecDestinoCodigo(String secDestinoCodigo) {
        this.secDestinoCodigo = secDestinoCodigo;
    }

    public String getSecDestinoEmpresa() {
        return secDestinoEmpresa;
    }

    public void setSecDestinoEmpresa(String secDestinoEmpresa) {
        this.secDestinoEmpresa = secDestinoEmpresa;
    }

    public String getSecOrigenCodigo() {
        return secOrigenCodigo;
    }

    public void setSecOrigenCodigo(String secOrigenCodigo) {
        this.secOrigenCodigo = secOrigenCodigo;
    }

    public String getSecOrigenEmpresa() {
        return secOrigenEmpresa;
    }

    public void setSecOrigenEmpresa(String secOrigenEmpresa) {
        this.secOrigenEmpresa = secOrigenEmpresa;
    }

    public String getTransEmpresa() {
        return transEmpresa;
    }

    public void setTransEmpresa(String transEmpresa) {
        this.transEmpresa = transEmpresa;
    }

    public String getTransMotivo() {
        return transMotivo;
    }

    public void setTransMotivo(String transMotivo) {
        this.transMotivo = transMotivo;
    }

    public String getTransNumero() {
        return transNumero;
    }

    public void setTransNumero(String transNumero) {
        this.transNumero = transNumero;
    }

    public String getTransPeriodo() {
        return transPeriodo;
    }

    public void setTransPeriodo(String transPeriodo) {
        this.transPeriodo = transPeriodo;
    }
}
