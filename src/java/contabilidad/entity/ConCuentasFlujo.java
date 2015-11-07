/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "con_cuentas_flujo", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConCuentasFlujo.findAll", query = "SELECT c FROM ConCuentasFlujo c"),
    @NamedQuery(name = "ConCuentasFlujo.findByFluEmpresa", query = "SELECT c FROM ConCuentasFlujo c WHERE c.conCuentasFlujoPK.fluEmpresa = :fluEmpresa"),
    @NamedQuery(name = "ConCuentasFlujo.findByFluCodigo", query = "SELECT c FROM ConCuentasFlujo c WHERE c.conCuentasFlujoPK.fluCodigo = :fluCodigo"),
    @NamedQuery(name = "ConCuentasFlujo.findByFluDetalle", query = "SELECT c FROM ConCuentasFlujo c WHERE c.fluDetalle = :fluDetalle"),
    @NamedQuery(name = "ConCuentasFlujo.findByFluActivo", query = "SELECT c FROM ConCuentasFlujo c WHERE c.fluActivo = :fluActivo"),
    @NamedQuery(name = "ConCuentasFlujo.findByUsrEmpresa", query = "SELECT c FROM ConCuentasFlujo c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "ConCuentasFlujo.findByUsrCodigo", query = "SELECT c FROM ConCuentasFlujo c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "ConCuentasFlujo.findByUsrFechaInserta", query = "SELECT c FROM ConCuentasFlujo c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class ConCuentasFlujo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConCuentasFlujoPK conCuentasFlujoPK;
    @Basic(optional = false)
    @Column(name = "flu_detalle")
    private String fluDetalle;
    @Basic(optional = false)
    @Column(name = "flu_activo")
    private boolean fluActivo;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conCuentasFlujo")
    private List<ConCuentasFlujoDetalle> conCuentasFlujoDetalleList;

    public ConCuentasFlujo() {
    }

    public ConCuentasFlujo(ConCuentasFlujoPK conCuentasFlujoPK) {
        this.conCuentasFlujoPK = conCuentasFlujoPK;
    }

    public ConCuentasFlujo(ConCuentasFlujoPK conCuentasFlujoPK, String fluDetalle, boolean fluActivo, String usrEmpresa) {
        this.conCuentasFlujoPK = conCuentasFlujoPK;
        this.fluDetalle = fluDetalle;
        this.fluActivo = fluActivo;
        this.usrEmpresa = usrEmpresa;
    }

    public ConCuentasFlujo(String fluEmpresa, String fluCodigo) {
        this.conCuentasFlujoPK = new ConCuentasFlujoPK(fluEmpresa, fluCodigo);
    }

    public ConCuentasFlujoPK getConCuentasFlujoPK() {
        return conCuentasFlujoPK;
    }

    public void setConCuentasFlujoPK(ConCuentasFlujoPK conCuentasFlujoPK) {
        this.conCuentasFlujoPK = conCuentasFlujoPK;
    }

    public String getFluDetalle() {
        return fluDetalle;
    }

    public void setFluDetalle(String fluDetalle) {
        this.fluDetalle = fluDetalle;
    }

    public boolean getFluActivo() {
        return fluActivo;
    }

    public void setFluActivo(boolean fluActivo) {
        this.fluActivo = fluActivo;
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

    public List<ConCuentasFlujoDetalle> getConCuentasFlujoDetalleList() {
        return conCuentasFlujoDetalleList;
    }

    public void setConCuentasFlujoDetalleList(List<ConCuentasFlujoDetalle> conCuentasFlujoDetalleList) {
        this.conCuentasFlujoDetalleList = conCuentasFlujoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conCuentasFlujoPK != null ? conCuentasFlujoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConCuentasFlujo)) {
            return false;
        }
        ConCuentasFlujo other = (ConCuentasFlujo) object;
        if ((this.conCuentasFlujoPK == null && other.conCuentasFlujoPK != null) || (this.conCuentasFlujoPK != null && !this.conCuentasFlujoPK.equals(other.conCuentasFlujoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConCuentasFlujo[ conCuentasFlujoPK=" + conCuentasFlujoPK + " ]";
    }
    
}
