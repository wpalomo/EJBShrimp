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
public class BanConciliacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "conc_empresa")
    private String concEmpresa;
    @Basic(optional = false)
    @Column(name = "conc_cuenta_contable")
    private String concCuentaContable;
    @Basic(optional = false)
    @Column(name = "conc_codigo")
    private String concCodigo;

    public BanConciliacionPK() {
    }

    public BanConciliacionPK(String concEmpresa, String concCuentaContable, String concCodigo) {
        this.concEmpresa = concEmpresa;
        this.concCuentaContable = concCuentaContable;
        this.concCodigo = concCodigo;
    }

    public String getConcEmpresa() {
        return concEmpresa;
    }

    public void setConcEmpresa(String concEmpresa) {
        this.concEmpresa = concEmpresa;
    }

    public String getConcCuentaContable() {
        return concCuentaContable;
    }

    public void setConcCuentaContable(String concCuentaContable) {
        this.concCuentaContable = concCuentaContable;
    }

    public String getConcCodigo() {
        return concCodigo;
    }

    public void setConcCodigo(String concCodigo) {
        this.concCodigo = concCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (concEmpresa != null ? concEmpresa.hashCode() : 0);
        hash += (concCuentaContable != null ? concCuentaContable.hashCode() : 0);
        hash += (concCodigo != null ? concCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanConciliacionPK)) {
            return false;
        }
        BanConciliacionPK other = (BanConciliacionPK) object;
        if ((this.concEmpresa == null && other.concEmpresa != null) || (this.concEmpresa != null && !this.concEmpresa.equals(other.concEmpresa))) {
            return false;
        }
        if ((this.concCuentaContable == null && other.concCuentaContable != null) || (this.concCuentaContable != null && !this.concCuentaContable.equals(other.concCuentaContable))) {
            return false;
        }
        if ((this.concCodigo == null && other.concCodigo != null) || (this.concCodigo != null && !this.concCodigo.equals(other.concCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanConciliacionPK[ concEmpresa=" + concEmpresa + ", concCuentaContable=" + concCuentaContable + ", concCodigo=" + concCodigo + " ]";
    }
    
}
