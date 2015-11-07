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
@Table(name = "con_estructura", schema = "contabilidad")
@NamedQueries({
    @NamedQuery(name = "ConEstructura.findAll", query = "SELECT c FROM ConEstructura c"),
    @NamedQuery(name = "ConEstructura.findByEstEmpresa", query = "SELECT c FROM ConEstructura c WHERE c.estEmpresa = :estEmpresa"),
    @NamedQuery(name = "ConEstructura.findByEstGrupo1", query = "SELECT c FROM ConEstructura c WHERE c.estGrupo1 = :estGrupo1"),
    @NamedQuery(name = "ConEstructura.findByEstGrupo2", query = "SELECT c FROM ConEstructura c WHERE c.estGrupo2 = :estGrupo2"),
    @NamedQuery(name = "ConEstructura.findByEstGrupo3", query = "SELECT c FROM ConEstructura c WHERE c.estGrupo3 = :estGrupo3"),
    @NamedQuery(name = "ConEstructura.findByEstGrupo4", query = "SELECT c FROM ConEstructura c WHERE c.estGrupo4 = :estGrupo4"),
    @NamedQuery(name = "ConEstructura.findByEstGrupo5", query = "SELECT c FROM ConEstructura c WHERE c.estGrupo5 = :estGrupo5"),
    @NamedQuery(name = "ConEstructura.findByEstGrupo6", query = "SELECT c FROM ConEstructura c WHERE c.estGrupo6 = :estGrupo6"),
    @NamedQuery(name = "ConEstructura.findByEmpCodigo", query = "SELECT c FROM ConEstructura c WHERE c.empCodigo = :empCodigo")})
public class ConEstructura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_empresa")
    private String estEmpresa;
    @Basic(optional = false)
    @Column(name = "est_grupo1")
    private short estGrupo1;
    @Basic(optional = false)
    @Column(name = "est_grupo2")
    private short estGrupo2;
    @Basic(optional = false)
    @Column(name = "est_grupo3")
    private short estGrupo3;
    @Basic(optional = false)
    @Column(name = "est_grupo4")
    private short estGrupo4;
    @Basic(optional = false)
    @Column(name = "est_grupo5")
    private short estGrupo5;
    @Basic(optional = false)
    @Column(name = "est_grupo6")
    private short estGrupo6;
    @Basic(optional = false)
    @Column(name = "emp_codigo")
    private String empCodigo;

    public ConEstructura() {
    }

    public ConEstructura(String estEmpresa) {
        this.estEmpresa = estEmpresa;
    }

    public ConEstructura(String estEmpresa, short estGrupo1, short estGrupo2, short estGrupo3, short estGrupo4, short estGrupo5, short estGrupo6, String empCodigo) {
        this.estEmpresa = estEmpresa;
        this.estGrupo1 = estGrupo1;
        this.estGrupo2 = estGrupo2;
        this.estGrupo3 = estGrupo3;
        this.estGrupo4 = estGrupo4;
        this.estGrupo5 = estGrupo5;
        this.estGrupo6 = estGrupo6;
        this.empCodigo = empCodigo;
    }

    public String getEstEmpresa() {
        return estEmpresa;
    }

    public void setEstEmpresa(String estEmpresa) {
        this.estEmpresa = estEmpresa;
    }

    public short getEstGrupo1() {
        return estGrupo1;
    }

    public void setEstGrupo1(short estGrupo1) {
        this.estGrupo1 = estGrupo1;
    }

    public short getEstGrupo2() {
        return estGrupo2;
    }

    public void setEstGrupo2(short estGrupo2) {
        this.estGrupo2 = estGrupo2;
    }

    public short getEstGrupo3() {
        return estGrupo3;
    }

    public void setEstGrupo3(short estGrupo3) {
        this.estGrupo3 = estGrupo3;
    }

    public short getEstGrupo4() {
        return estGrupo4;
    }

    public void setEstGrupo4(short estGrupo4) {
        this.estGrupo4 = estGrupo4;
    }

    public short getEstGrupo5() {
        return estGrupo5;
    }

    public void setEstGrupo5(short estGrupo5) {
        this.estGrupo5 = estGrupo5;
    }

    public short getEstGrupo6() {
        return estGrupo6;
    }

    public void setEstGrupo6(short estGrupo6) {
        this.estGrupo6 = estGrupo6;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estEmpresa != null ? estEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConEstructura)) {
            return false;
        }
        ConEstructura other = (ConEstructura) object;
        if ((this.estEmpresa == null && other.estEmpresa != null) || (this.estEmpresa != null && !this.estEmpresa.equals(other.estEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "contabilidad.entity.ConEstructura[ estEmpresa=" + estEmpresa + " ]";
    }
    
}
