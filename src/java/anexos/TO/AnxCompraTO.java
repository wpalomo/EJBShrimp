/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class AnxCompraTO implements java.io.Serializable{
    private String empCodigo;
    private String perCodigo;
    private String motCodigo;
    private String compNumero;
    private String compSustentotributario;
    private String compAutorizacion;
    private String compEmision;
    private String compCaduca;
    private java.math.BigDecimal compBase0;
    private java.math.BigDecimal compBaseimponible;
    private java.math.BigDecimal compBasenoobjetoiva;
    private java.math.BigDecimal compMontoice;
    private java.math.BigDecimal compMontoiva;
    private java.math.BigDecimal compBaseivabienes;
    private java.math.BigDecimal compBaseivaservicios;
    private java.math.BigDecimal compBaseivaserviciosprofesionales;
    private java.math.BigDecimal compPorcentajebienes;
    private java.math.BigDecimal compPorcentajeservicios;
    private java.math.BigDecimal compPorcentajeserviciosprofesionales;
    private java.math.BigDecimal compValorbienes;
    private java.math.BigDecimal compValorservicios;
    private java.math.BigDecimal compValorserviciosprofesionales;
    private String compRetencionNumero;
    private String compRetencionClaveAcceso;
    private String compRetencionAutorizacion;
    private String compRetencionFechaEmision;
    private String compModificadoDocumentoTipo;
    private String compModificadoDocumentoNumero;
    private String compModificadoAutorizacion;
    /*
             anxCompra.setCompModificadoDocumentoTipo(anxCompraTO.getCompModificadotipodocumento());
        anxCompra.setCompModificadoDocumentoNumero(anxCompraTO.getCompModificadodocumento());
        anxCompra.setCompModificadoAutorizacion(anxCompraTO.getCompModificadoautorizacion());
     */
    private java.math.BigDecimal valorRetencion;
    private Boolean retImpreso;
    private Boolean retEntregado;
    private Boolean retElectronica;
    
    public AnxCompraTO() {
    }

    public AnxCompraTO(String empCodigo, String perCodigo, String motCodigo, String compNumero, String compSustentotributario, String compAutorizacion, String compEmision, String compCaduca, BigDecimal compBase0, BigDecimal compBaseimponible, BigDecimal compBasenoobjetoiva, BigDecimal compMontoice, BigDecimal compMontoiva, BigDecimal compBaseivabienes, BigDecimal compBaseivaservicios, BigDecimal compBaseivaserviciosprofesionales, BigDecimal compPorcentajebienes, BigDecimal compPorcentajeservicios, BigDecimal compPorcentajeserviciosprofesionales, BigDecimal compValorbienes, BigDecimal compValorservicios, BigDecimal compValorserviciosprofesionales, String compRetencionNumero, String compRetencionClaveAcceso, String compRetencionAutorizacion, String compRetencionFechaEmision, String compModificadoDocumentoTipo, String compModificadoDocumentoNumero, String compModificadoAutorizacion, BigDecimal valorRetencion, Boolean retImpreso, Boolean retEntregado, Boolean retElectronica) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.motCodigo = motCodigo;
        this.compNumero = compNumero;
        this.compSustentotributario = compSustentotributario;
        this.compAutorizacion = compAutorizacion;
        this.compEmision = compEmision;
        this.compCaduca = compCaduca;
        this.compBase0 = compBase0;
        this.compBaseimponible = compBaseimponible;
        this.compBasenoobjetoiva = compBasenoobjetoiva;
        this.compMontoice = compMontoice;
        this.compMontoiva = compMontoiva;
        this.compBaseivabienes = compBaseivabienes;
        this.compBaseivaservicios = compBaseivaservicios;
        this.compBaseivaserviciosprofesionales = compBaseivaserviciosprofesionales;
        this.compPorcentajebienes = compPorcentajebienes;
        this.compPorcentajeservicios = compPorcentajeservicios;
        this.compPorcentajeserviciosprofesionales = compPorcentajeserviciosprofesionales;
        this.compValorbienes = compValorbienes;
        this.compValorservicios = compValorservicios;
        this.compValorserviciosprofesionales = compValorserviciosprofesionales;
        this.compRetencionNumero = compRetencionNumero;
        this.compRetencionClaveAcceso = compRetencionClaveAcceso;
        this.compRetencionAutorizacion = compRetencionAutorizacion;
        this.compRetencionFechaEmision = compRetencionFechaEmision;
        this.compModificadoDocumentoTipo = compModificadoDocumentoTipo;
        this.compModificadoDocumentoNumero = compModificadoDocumentoNumero;
        this.compModificadoAutorizacion = compModificadoAutorizacion;
        this.valorRetencion = valorRetencion;
        this.retImpreso = retImpreso;
        this.retEntregado = retEntregado;
        this.retElectronica = retElectronica;
    }

    public String getCompAutorizacion() {
        return compAutorizacion;
    }

    public void setCompAutorizacion(String compAutorizacion) {
        this.compAutorizacion = compAutorizacion;
    }

    public BigDecimal getCompBase0() {
        return compBase0;
    }

    public void setCompBase0(BigDecimal compBase0) {
        this.compBase0 = compBase0;
    }

    public BigDecimal getCompBaseimponible() {
        return compBaseimponible;
    }

    public void setCompBaseimponible(BigDecimal compBaseimponible) {
        this.compBaseimponible = compBaseimponible;
    }

    public BigDecimal getCompBaseivabienes() {
        return compBaseivabienes;
    }

    public void setCompBaseivabienes(BigDecimal compBaseivabienes) {
        this.compBaseivabienes = compBaseivabienes;
    }

    public BigDecimal getCompBaseivaservicios() {
        return compBaseivaservicios;
    }

    public void setCompBaseivaservicios(BigDecimal compBaseivaservicios) {
        this.compBaseivaservicios = compBaseivaservicios;
    }

    public BigDecimal getCompBaseivaserviciosprofesionales() {
        return compBaseivaserviciosprofesionales;
    }

    public void setCompBaseivaserviciosprofesionales(BigDecimal compBaseivaserviciosprofesionales) {
        this.compBaseivaserviciosprofesionales = compBaseivaserviciosprofesionales;
    }

    public BigDecimal getCompBasenoobjetoiva() {
        return compBasenoobjetoiva;
    }

    public void setCompBasenoobjetoiva(BigDecimal compBasenoobjetoiva) {
        this.compBasenoobjetoiva = compBasenoobjetoiva;
    }

    public String getCompCaduca() {
        return compCaduca;
    }

    public void setCompCaduca(String compCaduca) {
        this.compCaduca = compCaduca;
    }

    public String getCompEmision() {
        return compEmision;
    }

    public void setCompEmision(String compEmision) {
        this.compEmision = compEmision;
    }

    public String getCompModificadoAutorizacion() {
        return compModificadoAutorizacion;
    }

    public void setCompModificadoAutorizacion(String compModificadoAutorizacion) {
        this.compModificadoAutorizacion = compModificadoAutorizacion;
    }

    public String getCompModificadoDocumentoNumero() {
        return compModificadoDocumentoNumero;
    }

    public void setCompModificadoDocumentoNumero(String compModificadoDocumentoNumero) {
        this.compModificadoDocumentoNumero = compModificadoDocumentoNumero;
    }

    public String getCompModificadoDocumentoTipo() {
        return compModificadoDocumentoTipo;
    }

    public void setCompModificadoDocumentoTipo(String compModificadoDocumentoTipo) {
        this.compModificadoDocumentoTipo = compModificadoDocumentoTipo;
    }

    public BigDecimal getCompMontoice() {
        return compMontoice;
    }

    public void setCompMontoice(BigDecimal compMontoice) {
        this.compMontoice = compMontoice;
    }

    public BigDecimal getCompMontoiva() {
        return compMontoiva;
    }

    public void setCompMontoiva(BigDecimal compMontoiva) {
        this.compMontoiva = compMontoiva;
    }

    public String getCompNumero() {
        return compNumero;
    }

    public void setCompNumero(String compNumero) {
        this.compNumero = compNumero;
    }

    public BigDecimal getCompPorcentajebienes() {
        return compPorcentajebienes;
    }

    public void setCompPorcentajebienes(BigDecimal compPorcentajebienes) {
        this.compPorcentajebienes = compPorcentajebienes;
    }

    public BigDecimal getCompPorcentajeservicios() {
        return compPorcentajeservicios;
    }

    public void setCompPorcentajeservicios(BigDecimal compPorcentajeservicios) {
        this.compPorcentajeservicios = compPorcentajeservicios;
    }

    public BigDecimal getCompPorcentajeserviciosprofesionales() {
        return compPorcentajeserviciosprofesionales;
    }

    public void setCompPorcentajeserviciosprofesionales(BigDecimal compPorcentajeserviciosprofesionales) {
        this.compPorcentajeserviciosprofesionales = compPorcentajeserviciosprofesionales;
    }

    public String getCompRetencionAutorizacion() {
        return compRetencionAutorizacion;
    }

    public void setCompRetencionAutorizacion(String compRetencionAutorizacion) {
        this.compRetencionAutorizacion = compRetencionAutorizacion;
    }

    public String getCompRetencionClaveAcceso() {
        return compRetencionClaveAcceso;
    }

    public void setCompRetencionClaveAcceso(String compRetencionClaveAcceso) {
        this.compRetencionClaveAcceso = compRetencionClaveAcceso;
    }

    public String getCompRetencionFechaEmision() {
        return compRetencionFechaEmision;
    }

    public void setCompRetencionFechaEmision(String compRetencionFechaEmision) {
        this.compRetencionFechaEmision = compRetencionFechaEmision;
    }

    public String getCompRetencionNumero() {
        return compRetencionNumero;
    }

    public void setCompRetencionNumero(String compRetencionNumero) {
        this.compRetencionNumero = compRetencionNumero;
    }

    public String getCompSustentotributario() {
        return compSustentotributario;
    }

    public void setCompSustentotributario(String compSustentotributario) {
        this.compSustentotributario = compSustentotributario;
    }

    public BigDecimal getCompValorbienes() {
        return compValorbienes;
    }

    public void setCompValorbienes(BigDecimal compValorbienes) {
        this.compValorbienes = compValorbienes;
    }

    public BigDecimal getCompValorservicios() {
        return compValorservicios;
    }

    public void setCompValorservicios(BigDecimal compValorservicios) {
        this.compValorservicios = compValorservicios;
    }

    public BigDecimal getCompValorserviciosprofesionales() {
        return compValorserviciosprofesionales;
    }

    public void setCompValorserviciosprofesionales(BigDecimal compValorserviciosprofesionales) {
        this.compValorserviciosprofesionales = compValorserviciosprofesionales;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getMotCodigo() {
        return motCodigo;
    }

    public void setMotCodigo(String motCodigo) {
        this.motCodigo = motCodigo;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Boolean getRetElectronica() {
        return retElectronica;
    }

    public void setRetElectronica(Boolean retElectronica) {
        this.retElectronica = retElectronica;
    }

    public Boolean getRetEntregado() {
        return retEntregado;
    }

    public void setRetEntregado(Boolean retEntregado) {
        this.retEntregado = retEntregado;
    }

    public Boolean getRetImpreso() {
        return retImpreso;
    }

    public void setRetImpreso(Boolean retImpreso) {
        this.retImpreso = retImpreso;
    }

    public BigDecimal getValorRetencion() {
        return valorRetencion;
    }

    public void setValorRetencion(BigDecimal valorRetencion) {
        this.valorRetencion = valorRetencion;
    }

    @Override
    public String toString(){
        return this.empCodigo + " " + this.perCodigo + " " + this.motCodigo + " " + this.compNumero + " " + 
                this.compSustentotributario + " " + this.compAutorizacion + " " + this.compCaduca + " " +
                this.compBase0 + " " + this.compBaseimponible + " " + this.compBasenoobjetoiva + " " + this.compMontoice +
                " " + this.compMontoiva + " " + this.compBaseivabienes + " " + this.compBaseivaservicios + " " +
                this.compBaseivaserviciosprofesionales + " " + this.compPorcentajebienes + " " +
                this.compPorcentajeservicios + " " + this.compPorcentajeserviciosprofesionales + " " + this.compValorbienes + " " +
                this.compValorservicios + " " + this.compValorserviciosprofesionales + " " + this.compRetencionNumero + " " +
                this.compRetencionAutorizacion + " " + this.compRetencionFechaEmision + " " + this.compModificadoDocumentoTipo + " " +
                this.compModificadoDocumentoNumero + " " + this.compModificadoAutorizacion;
    }
}
