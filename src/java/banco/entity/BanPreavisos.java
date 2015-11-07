/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "ban_preavisos", schema = "banco")
@NamedQueries({
    @NamedQuery(name = "BanPreavisos.findAll", query = "SELECT b FROM BanPreavisos b"),
    @NamedQuery(name = "BanPreavisos.findByPreEmpresa", query = "SELECT b FROM BanPreavisos b WHERE b.banPreavisosPK.preEmpresa = :preEmpresa"),
    @NamedQuery(name = "BanPreavisos.findByPreCuentaContable", query = "SELECT b FROM BanPreavisos b WHERE b.banPreavisosPK.preCuentaContable = :preCuentaContable"),
    @NamedQuery(name = "BanPreavisos.findByPreNombreArchivoGenerado", query = "SELECT b FROM BanPreavisos b WHERE b.banPreavisosPK.preNombreArchivoGenerado = :preNombreArchivoGenerado"),
    @NamedQuery(name = "BanPreavisos.findByPreFechaRevisionUltimoCheque", query = "SELECT b FROM BanPreavisos b WHERE b.preFechaRevisionUltimoCheque = :preFechaRevisionUltimoCheque"),
    @NamedQuery(name = "BanPreavisos.findByUsrEmpresa", query = "SELECT b FROM BanPreavisos b WHERE b.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "BanPreavisos.findByUsrCodigo", query = "SELECT b FROM BanPreavisos b WHERE b.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "BanPreavisos.findByUsrFechaInserta", query = "SELECT b FROM BanPreavisos b WHERE b.usrFechaInserta = :usrFechaInserta")})
public class BanPreavisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BanPreavisosPK banPreavisosPK;
    @Column(name = "pre_fecha_revision_ultimo_cheque")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preFechaRevisionUltimoCheque;
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

    public BanPreavisos() {
    }

    public BanPreavisos(BanPreavisosPK banPreavisosPK) {
        this.banPreavisosPK = banPreavisosPK;
    }

    public BanPreavisos(BanPreavisosPK banPreavisosPK, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.banPreavisosPK = banPreavisosPK;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public BanPreavisos(String preEmpresa, String preCuentaContable, String preNombreArchivoGenerado) {
        this.banPreavisosPK = new BanPreavisosPK(preEmpresa, preCuentaContable, preNombreArchivoGenerado);
    }

    public BanPreavisosPK getBanPreavisosPK() {
        return banPreavisosPK;
    }

    public void setBanPreavisosPK(BanPreavisosPK banPreavisosPK) {
        this.banPreavisosPK = banPreavisosPK;
    }

    public Date getPreFechaRevisionUltimoCheque() {
        return preFechaRevisionUltimoCheque;
    }

    public void setPreFechaRevisionUltimoCheque(Date preFechaRevisionUltimoCheque) {
        this.preFechaRevisionUltimoCheque = preFechaRevisionUltimoCheque;
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
        hash += (banPreavisosPK != null ? banPreavisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanPreavisos)) {
            return false;
        }
        BanPreavisos other = (BanPreavisos) object;
        if ((this.banPreavisosPK == null && other.banPreavisosPK != null) || (this.banPreavisosPK != null && !this.banPreavisosPK.equals(other.banPreavisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanPreavisos[ banPreavisosPK=" + banPreavisosPK + " ]";
    }
    
}
