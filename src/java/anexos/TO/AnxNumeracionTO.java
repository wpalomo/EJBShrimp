/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

/**
 *
 * @author jack
 */
public class AnxNumeracionTO implements java.io.Serializable{
    private Integer numSecuencial;
    private String numEmpresa;
    private String numComprobante;
    private String numDesde;
    private String numHasta;
    private String numAutorizacion;
    private String numCaduca;
    private Short numLineas;
    private boolean numFormatoPos;
    private boolean numDocumentoElectronico;
    private boolean numAmbienteProduccion;
    private boolean numMostrarDialogoImpresion;
    private String secCodigo;
    private String usrCodigo;
    private String usrFechaInserta;

    public AnxNumeracionTO(Integer numSecuencial, String numEmpresa, String numComprobante, String numDesde, String numHasta, String numAutorizacion, String numCaduca, Short numLineas, boolean numFormatoPos, boolean numDocumentoElectronico, boolean numAmbienteProduccion, boolean numMostrarDialogoImpresion, String secCodigo, String usrCodigo, String usrFechaInserta) {
        this.numSecuencial = numSecuencial;
        this.numEmpresa = numEmpresa;
        this.numComprobante = numComprobante;
        this.numDesde = numDesde;
        this.numHasta = numHasta;
        this.numAutorizacion = numAutorizacion;
        this.numCaduca = numCaduca;
        this.numLineas = numLineas;
        this.numFormatoPos = numFormatoPos;
        this.numDocumentoElectronico = numDocumentoElectronico;
        this.numAmbienteProduccion = numAmbienteProduccion;
        this.numMostrarDialogoImpresion = numMostrarDialogoImpresion;
        this.secCodigo = secCodigo;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public AnxNumeracionTO() {
    }

    public boolean isNumAmbienteProduccion() {
        return numAmbienteProduccion;
    }

    public void setNumAmbienteProduccion(boolean numAmbienteProduccion) {
        this.numAmbienteProduccion = numAmbienteProduccion;
    }

    public String getNumAutorizacion() {
        return numAutorizacion;
    }

    public void setNumAutorizacion(String numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }

    public String getNumCaduca() {
        return numCaduca;
    }

    public void setNumCaduca(String numCaduca) {
        this.numCaduca = numCaduca;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public String getNumDesde() {
        return numDesde;
    }

    public void setNumDesde(String numDesde) {
        this.numDesde = numDesde;
    }

    public boolean isNumDocumentoElectronico() {
        return numDocumentoElectronico;
    }

    public void setNumDocumentoElectronico(boolean numDocumentoElectronico) {
        this.numDocumentoElectronico = numDocumentoElectronico;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public boolean isNumFormatoPos() {
        return numFormatoPos;
    }

    public void setNumFormatoPos(boolean numFormatoPos) {
        this.numFormatoPos = numFormatoPos;
    }

    public String getNumHasta() {
        return numHasta;
    }

    public void setNumHasta(String numHasta) {
        this.numHasta = numHasta;
    }

    public Short getNumLineas() {
        return numLineas;
    }

    public void setNumLineas(Short numLineas) {
        this.numLineas = numLineas;
    }

    public boolean isNumMostrarDialogoImpresion() {
        return numMostrarDialogoImpresion;
    }

    public void setNumMostrarDialogoImpresion(boolean numMostrarDialogoImpresion) {
        this.numMostrarDialogoImpresion = numMostrarDialogoImpresion;
    }

    public Integer getNumSecuencial() {
        return numSecuencial;
    }

    public void setNumSecuencial(Integer numSecuencial) {
        this.numSecuencial = numSecuencial;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }
}
