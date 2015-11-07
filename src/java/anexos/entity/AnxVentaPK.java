/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fconza
 */
@Embeddable
public class AnxVentaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ven_empresa")
    private String venEmpresa;
    @Basic(optional = false)
    @Column(name = "ven_periodo")
    private String venPeriodo;
    @Basic(optional = false)
    @Column(name = "ven_motivo")
    private String venMotivo;
    @Basic(optional = false)
    @Column(name = "ven_numero")
    private String venNumero;

    public AnxVentaPK() {
    }

    public AnxVentaPK(String venEmpresa, String venPeriodo, String venMotivo, String venNumero) {
        this.venEmpresa = venEmpresa;
        this.venPeriodo = venPeriodo;
        this.venMotivo = venMotivo;
        this.venNumero = venNumero;
    }

    public String getVenEmpresa() {
        return venEmpresa;
    }

    public void setVenEmpresa(String venEmpresa) {
        this.venEmpresa = venEmpresa;
    }

    public String getVenPeriodo() {
        return venPeriodo;
    }

    public void setVenPeriodo(String venPeriodo) {
        this.venPeriodo = venPeriodo;
    }

    public String getVenMotivo() {
        return venMotivo;
    }

    public void setVenMotivo(String venMotivo) {
        this.venMotivo = venMotivo;
    }

    public String getVenNumero() {
        return venNumero;
    }

    public void setVenNumero(String venNumero) {
        this.venNumero = venNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venEmpresa != null ? venEmpresa.hashCode() : 0);
        hash += (venPeriodo != null ? venPeriodo.hashCode() : 0);
        hash += (venMotivo != null ? venMotivo.hashCode() : 0);
        hash += (venNumero != null ? venNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxVentaPK)) {
            return false;
        }
        AnxVentaPK other = (AnxVentaPK) object;
        if ((this.venEmpresa == null && other.venEmpresa != null) || (this.venEmpresa != null && !this.venEmpresa.equals(other.venEmpresa))) {
            return false;
        }
        if ((this.venPeriodo == null && other.venPeriodo != null) || (this.venPeriodo != null && !this.venPeriodo.equals(other.venPeriodo))) {
            return false;
        }
        if ((this.venMotivo == null && other.venMotivo != null) || (this.venMotivo != null && !this.venMotivo.equals(other.venMotivo))) {
            return false;
        }
        if ((this.venNumero == null && other.venNumero != null) || (this.venNumero != null && !this.venNumero.equals(other.venNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxVentaPK[ venEmpresa=" + venEmpresa + ", venPeriodo=" + venPeriodo + ", venMotivo=" + venMotivo + ", venNumero=" + venNumero + " ]";
    }
    
}
