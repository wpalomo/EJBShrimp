/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jack
 */
@Embeddable
public class BanBancoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ban_empresa")
    private String banEmpresa;
    @Basic(optional = false)
    @Column(name = "ban_codigo")
    private String banCodigo;

    public BanBancoPK() {
    }

    public BanBancoPK(String banEmpresa, String banCodigo) {
        this.banEmpresa = banEmpresa;
        this.banCodigo = banCodigo;
    }

    public String getBanEmpresa() {
        return banEmpresa;
    }

    public void setBanEmpresa(String banEmpresa) {
        this.banEmpresa = banEmpresa;
    }

    public String getBanCodigo() {
        return banCodigo;
    }

    public void setBanCodigo(String banCodigo) {
        this.banCodigo = banCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banEmpresa != null ? banEmpresa.hashCode() : 0);
        hash += (banCodigo != null ? banCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanBancoPK)) {
            return false;
        }
        BanBancoPK other = (BanBancoPK) object;
        if ((this.banEmpresa == null && other.banEmpresa != null) || (this.banEmpresa != null && !this.banEmpresa.equals(other.banEmpresa))) {
            return false;
        }
        if ((this.banCodigo == null && other.banCodigo != null) || (this.banCodigo != null && !this.banCodigo.equals(other.banCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanBancoPK[ banEmpresa=" + banEmpresa + ", banCodigo=" + banCodigo + " ]";
    }
    
}
