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
public class SisUsuarioDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "det_empresa")
    private String detEmpresa;
    @Basic(optional = false)
    @Column(name = "det_usuario")
    private String detUsuario;

    public SisUsuarioDetallePK() {
    }

    public SisUsuarioDetallePK(String detEmpresa, String detUsuario) {
        this.detEmpresa = detEmpresa;
        this.detUsuario = detUsuario;
    }

    public String getDetEmpresa() {
        return detEmpresa;
    }

    public void setDetEmpresa(String detEmpresa) {
        this.detEmpresa = detEmpresa;
    }

    public String getDetUsuario() {
        return detUsuario;
    }

    public void setDetUsuario(String detUsuario) {
        this.detUsuario = detUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detEmpresa != null ? detEmpresa.hashCode() : 0);
        hash += (detUsuario != null ? detUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisUsuarioDetallePK)) {
            return false;
        }
        SisUsuarioDetallePK other = (SisUsuarioDetallePK) object;
        if ((this.detEmpresa == null && other.detEmpresa != null) || (this.detEmpresa != null && !this.detEmpresa.equals(other.detEmpresa))) {
            return false;
        }
        if ((this.detUsuario == null && other.detUsuario != null) || (this.detUsuario != null && !this.detUsuario.equals(other.detUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisUsuarioDetallePK[ detEmpresa=" + detEmpresa + ", detUsuario=" + detUsuario + " ]";
    }
    
}
