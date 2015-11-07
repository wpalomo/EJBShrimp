/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fconza
 */
@Embeddable
public class RhEmpleadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "emp_empresa")
    private String empEmpresa;
    @Basic(optional = false)
    @Column(name = "emp_id")
    private String empId;

    public RhEmpleadoPK() {
    }

    public RhEmpleadoPK(String empEmpresa, String empId) {
        this.empEmpresa = empEmpresa;
        this.empId = empId;
    }

    public String getEmpEmpresa() {
        return empEmpresa;
    }

    public void setEmpEmpresa(String empEmpresa) {
        this.empEmpresa = empEmpresa;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empEmpresa != null ? empEmpresa.hashCode() : 0);
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhEmpleadoPK)) {
            return false;
        }
        RhEmpleadoPK other = (RhEmpleadoPK) object;
        if ((this.empEmpresa == null && other.empEmpresa != null) || (this.empEmpresa != null && !this.empEmpresa.equals(other.empEmpresa))) {
            return false;
        }
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhEmpleadoPK[ empEmpresa=" + empEmpresa + ", empId=" + empId + " ]";
    }
}
