/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class InvComprasMotivoAnulacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "anu_empresa")
    private String anuEmpresa;
    @Basic(optional = false)
    @Column(name = "anu_periodo")
    private String anuPeriodo;
    @Basic(optional = false)
    @Column(name = "anu_motivo")
    private String anuMotivo;
    @Basic(optional = false)
    @Column(name = "anu_numero")
    private String anuNumero;

    public InvComprasMotivoAnulacionPK() {
    }

    public InvComprasMotivoAnulacionPK(String anuEmpresa, String anuPeriodo, String anuMotivo, String anuNumero) {
        this.anuEmpresa = anuEmpresa;
        this.anuPeriodo = anuPeriodo;
        this.anuMotivo = anuMotivo;
        this.anuNumero = anuNumero;
    }

    public String getAnuEmpresa() {
        return anuEmpresa;
    }

    public void setAnuEmpresa(String anuEmpresa) {
        this.anuEmpresa = anuEmpresa;
    }

    public String getAnuPeriodo() {
        return anuPeriodo;
    }

    public void setAnuPeriodo(String anuPeriodo) {
        this.anuPeriodo = anuPeriodo;
    }

    public String getAnuMotivo() {
        return anuMotivo;
    }

    public void setAnuMotivo(String anuMotivo) {
        this.anuMotivo = anuMotivo;
    }

    public String getAnuNumero() {
        return anuNumero;
    }

    public void setAnuNumero(String anuNumero) {
        this.anuNumero = anuNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anuEmpresa != null ? anuEmpresa.hashCode() : 0);
        hash += (anuPeriodo != null ? anuPeriodo.hashCode() : 0);
        hash += (anuMotivo != null ? anuMotivo.hashCode() : 0);
        hash += (anuNumero != null ? anuNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvComprasMotivoAnulacionPK)) {
            return false;
        }
        InvComprasMotivoAnulacionPK other = (InvComprasMotivoAnulacionPK) object;
        if ((this.anuEmpresa == null && other.anuEmpresa != null) || (this.anuEmpresa != null && !this.anuEmpresa.equals(other.anuEmpresa))) {
            return false;
        }
        if ((this.anuPeriodo == null && other.anuPeriodo != null) || (this.anuPeriodo != null && !this.anuPeriodo.equals(other.anuPeriodo))) {
            return false;
        }
        if ((this.anuMotivo == null && other.anuMotivo != null) || (this.anuMotivo != null && !this.anuMotivo.equals(other.anuMotivo))) {
            return false;
        }
        if ((this.anuNumero == null && other.anuNumero != null) || (this.anuNumero != null && !this.anuNumero.equals(other.anuNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvComprasMotivoAnulacionPK[ anuEmpresa=" + anuEmpresa + ", anuPeriodo=" + anuPeriodo + ", anuMotivo=" + anuMotivo + ", anuNumero=" + anuNumero + " ]";
    }
    
}
