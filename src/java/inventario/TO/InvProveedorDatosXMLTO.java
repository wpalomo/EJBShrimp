/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author carlos
 */
public class InvProveedorDatosXMLTO implements java.io.Serializable{
    
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String dirMatriz;
    
    private String numeroDocumento;
    private String fechaEmision;
    private String numeroAutorizacion;
    private String fechaAutorizacion;
    private String codDoc;
    private String totalComprobante;

    public InvProveedorDatosXMLTO() {
    }

    public InvProveedorDatosXMLTO(String razonSocial, String nombreComercial, String ruc, String dirMatriz, String numeroDocumento, String fechaEmision, String numeroAutorizacion, String fechaAutorizacion, String codDoc, String totalComprobante) {
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.ruc = ruc;
        this.dirMatriz = dirMatriz;
        this.numeroDocumento = numeroDocumento;
        this.fechaEmision = fechaEmision;
        this.numeroAutorizacion = numeroAutorizacion;
        this.fechaAutorizacion = fechaAutorizacion;
        this.codDoc = codDoc;
        this.totalComprobante = totalComprobante;
    }

    public String getTotalComprobante() {
        return totalComprobante;
    }

    public void setTotalComprobante(String totalComprobante) {
        this.totalComprobante = totalComprobante;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public String getDirMatriz() {
        return dirMatriz;
    }

    public void setDirMatriz(String dirMatriz) {
        this.dirMatriz = dirMatriz;
    }

    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}