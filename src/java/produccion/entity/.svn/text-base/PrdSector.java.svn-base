/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_sector", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdSector.findAll", query = "SELECT p FROM PrdSector p"),
    @NamedQuery(name = "PrdSector.findBySecEmpresa", query = "SELECT p FROM PrdSector p WHERE p.prdSectorPK.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "PrdSector.findBySecCodigo", query = "SELECT p FROM PrdSector p WHERE p.prdSectorPK.secCodigo = :secCodigo"),
    @NamedQuery(name = "PrdSector.findBySecNombre", query = "SELECT p FROM PrdSector p WHERE p.secNombre = :secNombre"),
    @NamedQuery(name = "PrdSector.findBySecLatitud", query = "SELECT p FROM PrdSector p WHERE p.secLatitud = :secLatitud"),
    @NamedQuery(name = "PrdSector.findBySecLongitud", query = "SELECT p FROM PrdSector p WHERE p.secLongitud = :secLongitud"),
    @NamedQuery(name = "PrdSector.findBySecActivo", query = "SELECT p FROM PrdSector p WHERE p.secActivo = :secActivo"),
    @NamedQuery(name = "PrdSector.findByUsrEmpresa", query = "SELECT p FROM PrdSector p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdSector.findByUsrCodigo", query = "SELECT p FROM PrdSector p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdSector.findByUsrFechaInserta", query = "SELECT p FROM PrdSector p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdSector implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdSectorPK prdSectorPK;
    @Basic(optional = false)
    @Column(name = "sec_nombre")
    private String secNombre;
    @Column(name = "sec_latitud")
    private String secLatitud;
    @Column(name = "sec_longitud")
    private String secLongitud;
    @Column(name = "sec_activo")
    private Boolean secActivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdSector")
    private List<PrdSobrevivencia> prdSobrevivenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdSector")
    private List<PrdPiscina> prdPiscinaList;

    public PrdSector() {
    }

    public PrdSector(PrdSectorPK prdSectorPK) {
        this.prdSectorPK = prdSectorPK;
    }

    public PrdSector(PrdSectorPK prdSectorPK, String secNombre, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdSectorPK = prdSectorPK;
        this.secNombre = secNombre;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdSector(String secEmpresa, String secCodigo) {
        this.prdSectorPK = new PrdSectorPK(secEmpresa, secCodigo);
    }

    public PrdSectorPK getPrdSectorPK() {
        return prdSectorPK;
    }

    public void setPrdSectorPK(PrdSectorPK prdSectorPK) {
        this.prdSectorPK = prdSectorPK;
    }

    public String getSecNombre() {
        return secNombre;
    }

    public void setSecNombre(String secNombre) {
        this.secNombre = secNombre;
    }

    public String getSecLatitud() {
        return secLatitud;
    }

    public void setSecLatitud(String secLatitud) {
        this.secLatitud = secLatitud;
    }

    public String getSecLongitud() {
        return secLongitud;
    }

    public void setSecLongitud(String secLongitud) {
        this.secLongitud = secLongitud;
    }

    public Boolean getSecActivo() {
        return secActivo;
    }

    public void setSecActivo(Boolean secActivo) {
        this.secActivo = secActivo;
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

    public List<PrdSobrevivencia> getPrdSobrevivenciaList() {
        return prdSobrevivenciaList;
    }

    public void setPrdSobrevivenciaList(List<PrdSobrevivencia> prdSobrevivenciaList) {
        this.prdSobrevivenciaList = prdSobrevivenciaList;
    }

    public List<PrdPiscina> getPrdPiscinaList() {
        return prdPiscinaList;
    }

    public void setPrdPiscinaList(List<PrdPiscina> prdPiscinaList) {
        this.prdPiscinaList = prdPiscinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdSectorPK != null ? prdSectorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdSector)) {
            return false;
        }
        PrdSector other = (PrdSector) object;
        if ((this.prdSectorPK == null && other.prdSectorPK != null) || (this.prdSectorPK != null && !this.prdSectorPK.equals(other.prdSectorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdSector[ prdSectorPK=" + prdSectorPK + " ]";
    }
    
}
