/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_liquidacion_motivo", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdLiquidacionMotivo.findAll", query = "SELECT p FROM PrdLiquidacionMotivo p"),
    @NamedQuery(name = "PrdLiquidacionMotivo.findByLmEmpresa", query = "SELECT p FROM PrdLiquidacionMotivo p WHERE p.prdLiquidacionMotivoPK.lmEmpresa = :lmEmpresa"),
    @NamedQuery(name = "PrdLiquidacionMotivo.findByLmCodigo", query = "SELECT p FROM PrdLiquidacionMotivo p WHERE p.prdLiquidacionMotivoPK.lmCodigo = :lmCodigo"),
    @NamedQuery(name = "PrdLiquidacionMotivo.findByLmDetalle", query = "SELECT p FROM PrdLiquidacionMotivo p WHERE p.lmDetalle = :lmDetalle"),
    @NamedQuery(name = "PrdLiquidacionMotivo.findByLmInactivo", query = "SELECT p FROM PrdLiquidacionMotivo p WHERE p.lmInactivo = :lmInactivo"),
    @NamedQuery(name = "PrdLiquidacionMotivo.findByUsrEmpresa", query = "SELECT p FROM PrdLiquidacionMotivo p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdLiquidacionMotivo.findByUsrCodigo", query = "SELECT p FROM PrdLiquidacionMotivo p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdLiquidacionMotivo.findByUsrFechaInserta", query = "SELECT p FROM PrdLiquidacionMotivo p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdLiquidacionMotivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdLiquidacionMotivoPK prdLiquidacionMotivoPK;
    @Basic(optional = false)
    @Column(name = "lm_detalle")
    private String lmDetalle;
    @Basic(optional = false)
    @Column(name = "lm_inactivo")
    private boolean lmInactivo;
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

    public PrdLiquidacionMotivo() {
    }

    public PrdLiquidacionMotivo(PrdLiquidacionMotivoPK prdLiquidacionMotivoPK) {
        this.prdLiquidacionMotivoPK = prdLiquidacionMotivoPK;
    }

    public PrdLiquidacionMotivo(PrdLiquidacionMotivoPK prdLiquidacionMotivoPK, String lmDetalle, boolean lmInactivo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.prdLiquidacionMotivoPK = prdLiquidacionMotivoPK;
        this.lmDetalle = lmDetalle;
        this.lmInactivo = lmInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public PrdLiquidacionMotivo(String lmEmpresa, String lmCodigo) {
        this.prdLiquidacionMotivoPK = new PrdLiquidacionMotivoPK(lmEmpresa, lmCodigo);
    }

    public PrdLiquidacionMotivoPK getPrdLiquidacionMotivoPK() {
        return prdLiquidacionMotivoPK;
    }

    public void setPrdLiquidacionMotivoPK(PrdLiquidacionMotivoPK prdLiquidacionMotivoPK) {
        this.prdLiquidacionMotivoPK = prdLiquidacionMotivoPK;
    }

    public String getLmDetalle() {
        return lmDetalle;
    }

    public void setLmDetalle(String lmDetalle) {
        this.lmDetalle = lmDetalle;
    }

    public boolean getLmInactivo() {
        return lmInactivo;
    }

    public void setLmInactivo(boolean lmInactivo) {
        this.lmInactivo = lmInactivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdLiquidacionMotivoPK != null ? prdLiquidacionMotivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionMotivo)) {
            return false;
        }
        PrdLiquidacionMotivo other = (PrdLiquidacionMotivo) object;
        if ((this.prdLiquidacionMotivoPK == null && other.prdLiquidacionMotivoPK != null) || (this.prdLiquidacionMotivoPK != null && !this.prdLiquidacionMotivoPK.equals(other.prdLiquidacionMotivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionMotivo[ prdLiquidacionMotivoPK=" + prdLiquidacionMotivoPK + " ]";
    }
    
}
