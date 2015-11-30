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
@Table(name = "inv_cliente_categoria", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvClienteCategoria.findAll", query = "SELECT i FROM InvClienteCategoria i"),
    @NamedQuery(name = "InvClienteCategoria.findByCcEmpresa", query = "SELECT i FROM InvClienteCategoria i WHERE i.invClienteCategoriaPK.ccEmpresa = :ccEmpresa"),
    @NamedQuery(name = "InvClienteCategoria.findByCcCodigo", query = "SELECT i FROM InvClienteCategoria i WHERE i.invClienteCategoriaPK.ccCodigo = :ccCodigo"),
    @NamedQuery(name = "InvClienteCategoria.findByCcDetalle", query = "SELECT i FROM InvClienteCategoria i WHERE i.ccDetalle = :ccDetalle"),
    @NamedQuery(name = "InvClienteCategoria.findByCcNivel", query = "SELECT i FROM InvClienteCategoria i WHERE i.ccNivel = :ccNivel"),
    @NamedQuery(name = "InvClienteCategoria.findByUsrEmpresa", query = "SELECT i FROM InvClienteCategoria i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvClienteCategoria.findByUsrCodigo", query = "SELECT i FROM InvClienteCategoria i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvClienteCategoria.findByUsrFechaInserta", query = "SELECT i FROM InvClienteCategoria i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvClienteCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvClienteCategoriaPK invClienteCategoriaPK;
    @Basic(optional = false)
    @Column(name = "cc_detalle")
    private String ccDetalle;
    @Column(name = "cc_nivel")
    private Short ccNivel;
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invClienteCategoria")
    private List<InvCliente> invClienteList;

    public InvClienteCategoria() {
    }

    public InvClienteCategoria(InvClienteCategoriaPK invClienteCategoriaPK) {
        this.invClienteCategoriaPK = invClienteCategoriaPK;
    }

    public InvClienteCategoria(InvClienteCategoriaPK invClienteCategoriaPK, String ccDetalle) {
        this.invClienteCategoriaPK = invClienteCategoriaPK;
        this.ccDetalle = ccDetalle;
    }

    public InvClienteCategoria(String ccEmpresa, String ccCodigo) {
        this.invClienteCategoriaPK = new InvClienteCategoriaPK(ccEmpresa, ccCodigo);
    }

    public InvClienteCategoriaPK getInvClienteCategoriaPK() {
        return invClienteCategoriaPK;
    }

    public void setInvClienteCategoriaPK(InvClienteCategoriaPK invClienteCategoriaPK) {
        this.invClienteCategoriaPK = invClienteCategoriaPK;
    }

    public String getCcDetalle() {
        return ccDetalle;
    }

    public void setCcDetalle(String ccDetalle) {
        this.ccDetalle = ccDetalle;
    }

    public Short getCcNivel() {
        return ccNivel;
    }

    public void setCcNivel(Short ccNivel) {
        this.ccNivel = ccNivel;
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
        hash += (invClienteCategoriaPK != null ? invClienteCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvClienteCategoria)) {
            return false;
        }
        InvClienteCategoria other = (InvClienteCategoria) object;
        if ((this.invClienteCategoriaPK == null && other.invClienteCategoriaPK != null) || (this.invClienteCategoriaPK != null && !this.invClienteCategoriaPK.equals(other.invClienteCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvClienteCategoria[ invClienteCategoriaPK=" + invClienteCategoriaPK + " ]";
    }
    
}
