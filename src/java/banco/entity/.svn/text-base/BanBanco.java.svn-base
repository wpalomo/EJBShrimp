/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "ban_banco", schema = "banco")
@NamedQueries({
    @NamedQuery(name = "BanBanco.findAll", query = "SELECT b FROM BanBanco b"),
    @NamedQuery(name = "BanBanco.findByBanEmpresa", query = "SELECT b FROM BanBanco b WHERE b.banBancoPK.banEmpresa = :banEmpresa"),
    @NamedQuery(name = "BanBanco.findByBanCodigo", query = "SELECT b FROM BanBanco b WHERE b.banBancoPK.banCodigo = :banCodigo"),
    @NamedQuery(name = "BanBanco.findByBanNombre", query = "SELECT b FROM BanBanco b WHERE b.banNombre = :banNombre"),
    @NamedQuery(name = "BanBanco.findByUsrEmpresa", query = "SELECT b FROM BanBanco b WHERE b.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "BanBanco.findByUsrCodigo", query = "SELECT b FROM BanBanco b WHERE b.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "BanBanco.findByUsrFechaInserta", query = "SELECT b FROM BanBanco b WHERE b.usrFechaInserta = :usrFechaInserta")})
public class BanBanco implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BanBancoPK banBancoPK;
    @Basic(optional = false)
    @Column(name = "ban_nombre")
    private String banNombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banBanco")
    private List<BanCuenta> banCuentaList;

    public BanBanco() {
    }

    public BanBanco(BanBancoPK banBancoPK) {
        this.banBancoPK = banBancoPK;
    }

    public BanBanco(BanBancoPK banBancoPK, String banNombre, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.banBancoPK = banBancoPK;
        this.banNombre = banNombre;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public BanBanco(String banEmpresa, String banCodigo) {
        this.banBancoPK = new BanBancoPK(banEmpresa, banCodigo);
    }

    public BanBancoPK getBanBancoPK() {
        return banBancoPK;
    }

    public void setBanBancoPK(BanBancoPK banBancoPK) {
        this.banBancoPK = banBancoPK;
    }

    public String getBanNombre() {
        return banNombre;
    }

    public void setBanNombre(String banNombre) {
        this.banNombre = banNombre;
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

    public List<BanCuenta> getBanCuentaList() {
        return banCuentaList;
    }

    public void setBanCuentaList(List<BanCuenta> banCuentaList) {
        this.banCuentaList = banCuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banBancoPK != null ? banBancoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanBanco)) {
            return false;
        }
        BanBanco other = (BanBanco) object;
        if ((this.banBancoPK == null && other.banBancoPK != null) || (this.banBancoPK != null && !this.banBancoPK.equals(other.banBancoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanBanco[ banBancoPK=" + banBancoPK + " ]";
    }
    
}
