/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class SisGrupoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "gru_empresa")
    private String gruEmpresa;
    @Basic(optional = false)
    @Column(name = "gru_codigo")
    private String gruCodigo;

    public SisGrupoPK() {
    }

    public SisGrupoPK(String gruEmpresa, String gruCodigo) {
        this.gruEmpresa = gruEmpresa;
        this.gruCodigo = gruCodigo;
    }

    public String getGruEmpresa() {
        return gruEmpresa;
    }

    public void setGruEmpresa(String gruEmpresa) {
        this.gruEmpresa = gruEmpresa;
    }

    public String getGruCodigo() {
        return gruCodigo;
    }

    public void setGruCodigo(String gruCodigo) {
        this.gruCodigo = gruCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruEmpresa != null ? gruEmpresa.hashCode() : 0);
        hash += (gruCodigo != null ? gruCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisGrupoPK)) {
            return false;
        }
        SisGrupoPK other = (SisGrupoPK) object;
        if ((this.gruEmpresa == null && other.gruEmpresa != null) || (this.gruEmpresa != null && !this.gruEmpresa.equals(other.gruEmpresa))) {
            return false;
        }
        if ((this.gruCodigo == null && other.gruCodigo != null) || (this.gruCodigo != null && !this.gruCodigo.equals(other.gruCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisGrupoPK[ gruEmpresa=" + gruEmpresa + ", gruCodigo=" + gruCodigo + " ]";
    }
    
}
