/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "con_cuentas_especiales", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConCuentasEspeciales.findAll", query = "SELECT c FROM ConCuentasEspeciales c"),
    @NamedQuery(name = "ConCuentasEspeciales.findByCtaEmpresa", query = "SELECT c FROM ConCuentasEspeciales c WHERE c.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "ConCuentasEspeciales.findByCtaActivoBiologico", query = "SELECT c FROM ConCuentasEspeciales c WHERE c.ctaActivoBiologico = :ctaActivoBiologico")})
public class ConCuentasEspeciales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Basic(optional = false)
    @Column(name = "cta_activo_biologico")
    private String ctaActivoBiologico;

    public ConCuentasEspeciales() {
    }

    public ConCuentasEspeciales(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public ConCuentasEspeciales(String ctaEmpresa, String ctaActivoBiologico) {
        this.ctaEmpresa = ctaEmpresa;
        this.ctaActivoBiologico = ctaActivoBiologico;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaActivoBiologico() {
        return ctaActivoBiologico;
    }

    public void setCtaActivoBiologico(String ctaActivoBiologico) {
        this.ctaActivoBiologico = ctaActivoBiologico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctaEmpresa != null ? ctaEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConCuentasEspeciales)) {
            return false;
        }
        ConCuentasEspeciales other = (ConCuentasEspeciales) object;
        if ((this.ctaEmpresa == null && other.ctaEmpresa != null) || (this.ctaEmpresa != null && !this.ctaEmpresa.equals(other.ctaEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConCuentasEspeciales[ ctaEmpresa=" + ctaEmpresa + " ]";
    }
    
}
