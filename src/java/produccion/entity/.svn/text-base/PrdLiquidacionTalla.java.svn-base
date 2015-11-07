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
@Table(name = "prd_liquidacion_talla", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdLiquidacionTalla.findAll", query = "SELECT p FROM PrdLiquidacionTalla p"),
    @NamedQuery(name = "PrdLiquidacionTalla.findByTallaEmpresa", query = "SELECT p FROM PrdLiquidacionTalla p WHERE p.prdLiquidacionTallaPK.tallaEmpresa = :tallaEmpresa"),
    @NamedQuery(name = "PrdLiquidacionTalla.findByTallaCodigo", query = "SELECT p FROM PrdLiquidacionTalla p WHERE p.prdLiquidacionTallaPK.tallaCodigo = :tallaCodigo"),
    @NamedQuery(name = "PrdLiquidacionTalla.findByTallaDetalle", query = "SELECT p FROM PrdLiquidacionTalla p WHERE p.tallaDetalle = :tallaDetalle"),
    @NamedQuery(name = "PrdLiquidacionTalla.findByTallaInactivo", query = "SELECT p FROM PrdLiquidacionTalla p WHERE p.tallaInactivo = :tallaInactivo"),
    @NamedQuery(name = "PrdLiquidacionTalla.findByUsrEmpresa", query = "SELECT p FROM PrdLiquidacionTalla p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdLiquidacionTalla.findByUsrCodigo", query = "SELECT p FROM PrdLiquidacionTalla p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdLiquidacionTalla.findByUsrFechaInserta", query = "SELECT p FROM PrdLiquidacionTalla p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdLiquidacionTalla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdLiquidacionTallaPK prdLiquidacionTallaPK;
    @Basic(optional = false)
    @Column(name = "talla_detalle")
    private String tallaDetalle;
    @Basic(optional = false)
    @Column(name = "talla_inactivo")
    private boolean tallaInactivo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdLiquidacionTalla")
    private List<PrdLiquidacionDetalle> prdLiquidacionDetalleList;

    public PrdLiquidacionTalla() {
    }

    public PrdLiquidacionTalla(PrdLiquidacionTallaPK prdLiquidacionTallaPK) {
        this.prdLiquidacionTallaPK = prdLiquidacionTallaPK;
    }

    public PrdLiquidacionTalla(PrdLiquidacionTallaPK prdLiquidacionTallaPK, String tallaDetalle, boolean tallaInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdLiquidacionTallaPK = prdLiquidacionTallaPK;
        this.tallaDetalle = tallaDetalle;
        this.tallaInactivo = tallaInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdLiquidacionTalla(String tallaEmpresa, String tallaCodigo) {
        this.prdLiquidacionTallaPK = new PrdLiquidacionTallaPK(tallaEmpresa, tallaCodigo);
    }

    public PrdLiquidacionTallaPK getPrdLiquidacionTallaPK() {
        return prdLiquidacionTallaPK;
    }

    public void setPrdLiquidacionTallaPK(PrdLiquidacionTallaPK prdLiquidacionTallaPK) {
        this.prdLiquidacionTallaPK = prdLiquidacionTallaPK;
    }

    public String getTallaDetalle() {
        return tallaDetalle;
    }

    public void setTallaDetalle(String tallaDetalle) {
        this.tallaDetalle = tallaDetalle;
    }

    public boolean getTallaInactivo() {
        return tallaInactivo;
    }

    public void setTallaInactivo(boolean tallaInactivo) {
        this.tallaInactivo = tallaInactivo;
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

    public List<PrdLiquidacionDetalle> getPrdLiquidacionDetalleList() {
        return prdLiquidacionDetalleList;
    }

    public void setPrdLiquidacionDetalleList(List<PrdLiquidacionDetalle> prdLiquidacionDetalleList) {
        this.prdLiquidacionDetalleList = prdLiquidacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdLiquidacionTallaPK != null ? prdLiquidacionTallaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionTalla)) {
            return false;
        }
        PrdLiquidacionTalla other = (PrdLiquidacionTalla) object;
        if ((this.prdLiquidacionTallaPK == null && other.prdLiquidacionTallaPK != null) || (this.prdLiquidacionTallaPK != null && !this.prdLiquidacionTallaPK.equals(other.prdLiquidacionTallaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionTalla[ prdLiquidacionTallaPK=" + prdLiquidacionTallaPK + " ]";
    }
    
}
