/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_vendedor", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVendedor.findAll", query = "SELECT i FROM InvVendedor i"),
    @NamedQuery(name = "InvVendedor.findByVendEmpresa", query = "SELECT i FROM InvVendedor i WHERE i.invVendedorPK.vendEmpresa = :vendEmpresa"),
    @NamedQuery(name = "InvVendedor.findByVendCodigo", query = "SELECT i FROM InvVendedor i WHERE i.invVendedorPK.vendCodigo = :vendCodigo"),
    @NamedQuery(name = "InvVendedor.findByVendNombre", query = "SELECT i FROM InvVendedor i WHERE i.vendNombre = :vendNombre"),
    @NamedQuery(name = "InvVendedor.findByUsrEmpresa", query = "SELECT i FROM InvVendedor i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvVendedor.findByUsrCodigo", query = "SELECT i FROM InvVendedor i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvVendedor.findByUsrFechaInserta", query = "SELECT i FROM InvVendedor i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvVendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvVendedorPK invVendedorPK;
    @Basic(optional = false)
    @Column(name = "vend_nombre")
    private String vendNombre;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(mappedBy = "invVendedor")
    private List<InvCliente> invClienteList;

    public InvVendedor() {
    }

    public InvVendedor(InvVendedorPK invVendedorPK) {
        this.invVendedorPK = invVendedorPK;
    }

    public InvVendedor(InvVendedorPK invVendedorPK, String vendNombre, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invVendedorPK = invVendedorPK;
        this.vendNombre = vendNombre;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvVendedor(String vendEmpresa, String vendCodigo) {
        this.invVendedorPK = new InvVendedorPK(vendEmpresa, vendCodigo);
    }

    public InvVendedorPK getInvVendedorPK() {
        return invVendedorPK;
    }

    public void setInvVendedorPK(InvVendedorPK invVendedorPK) {
        this.invVendedorPK = invVendedorPK;
    }

    public String getVendNombre() {
        return vendNombre;
    }

    public void setVendNombre(String vendNombre) {
        this.vendNombre = vendNombre;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(Date usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    public List<InvCliente> getInvClienteList() {
        return invClienteList;
    }

    public void setInvClienteList(List<InvCliente> invClienteList) {
        this.invClienteList = invClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invVendedorPK != null ? invVendedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVendedor)) {
            return false;
        }
        InvVendedor other = (InvVendedor) object;
        if ((this.invVendedorPK == null && other.invVendedorPK != null) || (this.invVendedorPK != null && !this.invVendedorPK.equals(other.invVendedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVendedor[ invVendedorPK=" + invVendedorPK + " ]";
    }
    
}
