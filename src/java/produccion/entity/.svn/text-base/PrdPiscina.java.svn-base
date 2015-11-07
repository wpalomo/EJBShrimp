/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_piscina", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdPiscina.findAll", query = "SELECT p FROM PrdPiscina p"),
    @NamedQuery(name = "PrdPiscina.findByPisEmpresa", query = "SELECT p FROM PrdPiscina p WHERE p.prdPiscinaPK.pisEmpresa = :pisEmpresa"),
    @NamedQuery(name = "PrdPiscina.findByPisSector", query = "SELECT p FROM PrdPiscina p WHERE p.prdPiscinaPK.pisSector = :pisSector"),
    @NamedQuery(name = "PrdPiscina.findByPisNumero", query = "SELECT p FROM PrdPiscina p WHERE p.prdPiscinaPK.pisNumero = :pisNumero"),
    @NamedQuery(name = "PrdPiscina.findByPisNombre", query = "SELECT p FROM PrdPiscina p WHERE p.pisNombre = :pisNombre"),
    @NamedQuery(name = "PrdPiscina.findByPisHectareaje", query = "SELECT p FROM PrdPiscina p WHERE p.pisHectareaje = :pisHectareaje"),
    @NamedQuery(name = "PrdPiscina.findByPisActiva", query = "SELECT p FROM PrdPiscina p WHERE p.pisActiva = :pisActiva"),
    @NamedQuery(name = "PrdPiscina.findByUsrEmpresa", query = "SELECT p FROM PrdPiscina p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdPiscina.findByUsrCodigo", query = "SELECT p FROM PrdPiscina p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdPiscina.findByUsrFechaInserta", query = "SELECT p FROM PrdPiscina p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdPiscina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdPiscinaPK prdPiscinaPK;
    @Basic(optional = false)
    @Column(name = "pis_nombre")
    private String pisNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pis_hectareaje")
    private BigDecimal pisHectareaje;
    @Column(name = "pis_activa")
    private Boolean pisActiva;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdPiscina")
    private List<PrdVehiculos> prdVehiculosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdPiscina")
    private List<PrdLiquidacion> prdLiquidacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdPiscina")
    private List<PrdCorrida> prdCorridaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdPiscina")
    private List<PrdGrameaje> prdGrameajeList;
    @JoinColumns({
        @JoinColumn(name = "sec_empresa", referencedColumnName = "sec_empresa"),
        @JoinColumn(name = "sec_codigo", referencedColumnName = "sec_codigo")})
    @ManyToOne(optional = false)
    private PrdSector prdSector;

    public PrdPiscina() {
    }

    public PrdPiscina(PrdPiscinaPK prdPiscinaPK) {
        this.prdPiscinaPK = prdPiscinaPK;
    }

    public PrdPiscina(PrdPiscinaPK prdPiscinaPK, String pisNombre, BigDecimal pisHectareaje, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdPiscinaPK = prdPiscinaPK;
        this.pisNombre = pisNombre;
        this.pisHectareaje = pisHectareaje;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdPiscina(String pisEmpresa, String pisSector, String pisNumero) {
        this.prdPiscinaPK = new PrdPiscinaPK(pisEmpresa, pisSector, pisNumero);
    }

    public PrdPiscinaPK getPrdPiscinaPK() {
        return prdPiscinaPK;
    }

    public void setPrdPiscinaPK(PrdPiscinaPK prdPiscinaPK) {
        this.prdPiscinaPK = prdPiscinaPK;
    }

    public String getPisNombre() {
        return pisNombre;
    }

    public void setPisNombre(String pisNombre) {
        this.pisNombre = pisNombre;
    }

    public BigDecimal getPisHectareaje() {
        return pisHectareaje;
    }

    public void setPisHectareaje(BigDecimal pisHectareaje) {
        this.pisHectareaje = pisHectareaje;
    }

    public Boolean getPisActiva() {
        return pisActiva;
    }

    public void setPisActiva(Boolean pisActiva) {
        this.pisActiva = pisActiva;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(Date usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    public List<PrdVehiculos> getPrdVehiculosList() {
        return prdVehiculosList;
    }

    public void setPrdVehiculosList(List<PrdVehiculos> prdVehiculosList) {
        this.prdVehiculosList = prdVehiculosList;
    }

    public List<PrdLiquidacion> getPrdLiquidacionList() {
        return prdLiquidacionList;
    }

    public void setPrdLiquidacionList(List<PrdLiquidacion> prdLiquidacionList) {
        this.prdLiquidacionList = prdLiquidacionList;
    }

    public List<PrdCorrida> getPrdCorridaList() {
        return prdCorridaList;
    }

    public void setPrdCorridaList(List<PrdCorrida> prdCorridaList) {
        this.prdCorridaList = prdCorridaList;
    }

    public List<PrdGrameaje> getPrdGrameajeList() {
        return prdGrameajeList;
    }

    public void setPrdGrameajeList(List<PrdGrameaje> prdGrameajeList) {
        this.prdGrameajeList = prdGrameajeList;
    }

    public PrdSector getPrdSector() {
        return prdSector;
    }

    public void setPrdSector(PrdSector prdSector) {
        this.prdSector = prdSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdPiscinaPK != null ? prdPiscinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdPiscina)) {
            return false;
        }
        PrdPiscina other = (PrdPiscina) object;
        if ((this.prdPiscinaPK == null && other.prdPiscinaPK != null) || (this.prdPiscinaPK != null && !this.prdPiscinaPK.equals(other.prdPiscinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdPiscina[ prdPiscinaPK=" + prdPiscinaPK + " ]";
    }
    
}
