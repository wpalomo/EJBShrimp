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
public class InvVentasComplementoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "com_empresa")
    private String comEmpresa;
    @Basic(optional = false)
    @Column(name = "com_periodo")
    private String comPeriodo;
    @Basic(optional = false)
    @Column(name = "com_motivo")
    private String comMotivo;
    @Basic(optional = false)
    @Column(name = "com_numero")
    private String comNumero;

    public InvVentasComplementoPK() {
    }

    public InvVentasComplementoPK(String comEmpresa, String comPeriodo, String comMotivo, String comNumero) {
        this.comEmpresa = comEmpresa;
        this.comPeriodo = comPeriodo;
        this.comMotivo = comMotivo;
        this.comNumero = comNumero;
    }

    public String getComEmpresa() {
        return comEmpresa;
    }

    public void setComEmpresa(String comEmpresa) {
        this.comEmpresa = comEmpresa;
    }

    public String getComPeriodo() {
        return comPeriodo;
    }

    public void setComPeriodo(String comPeriodo) {
        this.comPeriodo = comPeriodo;
    }

    public String getComMotivo() {
        return comMotivo;
    }

    public void setComMotivo(String comMotivo) {
        this.comMotivo = comMotivo;
    }

    public String getComNumero() {
        return comNumero;
    }

    public void setComNumero(String comNumero) {
        this.comNumero = comNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comEmpresa != null ? comEmpresa.hashCode() : 0);
        hash += (comPeriodo != null ? comPeriodo.hashCode() : 0);
        hash += (comMotivo != null ? comMotivo.hashCode() : 0);
        hash += (comNumero != null ? comNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasComplementoPK)) {
            return false;
        }
        InvVentasComplementoPK other = (InvVentasComplementoPK) object;
        if ((this.comEmpresa == null && other.comEmpresa != null) || (this.comEmpresa != null && !this.comEmpresa.equals(other.comEmpresa))) {
            return false;
        }
        if ((this.comPeriodo == null && other.comPeriodo != null) || (this.comPeriodo != null && !this.comPeriodo.equals(other.comPeriodo))) {
            return false;
        }
        if ((this.comMotivo == null && other.comMotivo != null) || (this.comMotivo != null && !this.comMotivo.equals(other.comMotivo))) {
            return false;
        }
        if ((this.comNumero == null && other.comNumero != null) || (this.comNumero != null && !this.comNumero.equals(other.comNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasComplementoPK[ comEmpresa=" + comEmpresa + ", comPeriodo=" + comPeriodo + ", comMotivo=" + comMotivo + ", comNumero=" + comNumero + " ]";
    }
    
}
