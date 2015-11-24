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
@Table(name = "inv_transferencias", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvTransferencias.findAll", query = "SELECT i FROM InvTransferencias i"),
    @NamedQuery(name = "InvTransferencias.findByTransEmpresa", query = "SELECT i FROM InvTransferencias i WHERE i.invTransferenciasPK.transEmpresa = :transEmpresa"),
    @NamedQuery(name = "InvTransferencias.findByTransPeriodo", query = "SELECT i FROM InvTransferencias i WHERE i.invTransferenciasPK.transPeriodo = :transPeriodo"),
    @NamedQuery(name = "InvTransferencias.findByTransMotivo", query = "SELECT i FROM InvTransferencias i WHERE i.invTransferenciasPK.transMotivo = :transMotivo"),
    @NamedQuery(name = "InvTransferencias.findByTransNumero", query = "SELECT i FROM InvTransferencias i WHERE i.invTransferenciasPK.transNumero = :transNumero"),
    @NamedQuery(name = "InvTransferencias.findByTransFecha", query = "SELECT i FROM InvTransferencias i WHERE i.transFecha = :transFecha"),
    @NamedQuery(name = "InvTransferencias.findByTransObservaciones", query = "SELECT i FROM InvTransferencias i WHERE i.transObservaciones = :transObservaciones"),
    @NamedQuery(name = "InvTransferencias.findByTransPendiente", query = "SELECT i FROM InvTransferencias i WHERE i.transPendiente = :transPendiente"),
    @NamedQuery(name = "InvTransferencias.findByTransRevisado", query = "SELECT i FROM InvTransferencias i WHERE i.transRevisado = :transRevisado"),
    @NamedQuery(name = "InvTransferencias.findByTransAnulado", query = "SELECT i FROM InvTransferencias i WHERE i.transAnulado = :transAnulado"),
    @NamedQuery(name = "InvTransferencias.findByConEmpresa", query = "SELECT i FROM InvTransferencias i WHERE i.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "InvTransferencias.findByConPeriodo", query = "SELECT i FROM InvTransferencias i WHERE i.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "InvTransferencias.findByConTipo", query = "SELECT i FROM InvTransferencias i WHERE i.conTipo = :conTipo"),
    @NamedQuery(name = "InvTransferencias.findByConNumero", query = "SELECT i FROM InvTransferencias i WHERE i.conNumero = :conNumero"),
    @NamedQuery(name = "InvTransferencias.findByUsrEmpresa", query = "SELECT i FROM InvTransferencias i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvTransferencias.findByUsrCodigo", query = "SELECT i FROM InvTransferencias i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvTransferencias.findByUsrFechaInserta", query = "SELECT i FROM InvTransferencias i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvTransferencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvTransferenciasPK invTransferenciasPK;
    @Basic(optional = false)
    @Column(name = "trans_fecha")
    @Temporal(TemporalType.DATE)
    private Date transFecha;
    @Column(name = "trans_observaciones")
    private String transObservaciones;
    @Basic(optional = false)
    @Column(name = "trans_pendiente")
    private boolean transPendiente;
    @Basic(optional = false)
    @Column(name = "trans_revisado")
    private boolean transRevisado;
    @Basic(optional = false)
    @Column(name = "trans_anulado")
    private boolean transAnulado;
    @Column(name = "con_empresa")
    private String conEmpresa;
    @Column(name = "con_periodo")
    private String conPeriodo;
    @Column(name = "con_tipo")
    private String conTipo;
    @Column(name = "con_numero")
    private String conNumero;
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
    @JoinColumns({
        @JoinColumn(name = "bod_origen_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_origen_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega;
    @JoinColumns({
        @JoinColumn(name = "bod_destino_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_destino_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invTransferencias")
    private List<InvTransferenciasDetalle> invTransferenciasDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invTransferencias")
    private List<InvTransferenciasMotivoAnulacion> invTransferenciasMotivoAnulacionList;

    public InvTransferencias() {
    }

    public InvTransferencias(InvTransferenciasPK invTransferenciasPK) {
        this.invTransferenciasPK = invTransferenciasPK;
    }

    public InvTransferencias(InvTransferenciasPK invTransferenciasPK, Date transFecha, boolean transPendiente, boolean transRevisado, boolean transAnulado, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invTransferenciasPK = invTransferenciasPK;
        this.transFecha = transFecha;
        this.transPendiente = transPendiente;
        this.transRevisado = transRevisado;
        this.transAnulado = transAnulado;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvTransferencias(String transEmpresa, String transPeriodo, String transMotivo, String transNumero) {
        this.invTransferenciasPK = new InvTransferenciasPK(transEmpresa, transPeriodo, transMotivo, transNumero);
    }

    public InvTransferenciasPK getInvTransferenciasPK() {
        return invTransferenciasPK;
    }

    public void setInvTransferenciasPK(InvTransferenciasPK invTransferenciasPK) {
        this.invTransferenciasPK = invTransferenciasPK;
    }

    public Date getTransFecha() {
        return transFecha;
    }

    public void setTransFecha(Date transFecha) {
        this.transFecha = transFecha;
    }

    public String getTransObservaciones() {
        return transObservaciones;
    }

    public void setTransObservaciones(String transObservaciones) {
        this.transObservaciones = transObservaciones;
    }

    public boolean getTransPendiente() {
        return transPendiente;
    }

    public void setTransPendiente(boolean transPendiente) {
        this.transPendiente = transPendiente;
    }

    public boolean getTransRevisado() {
        return transRevisado;
    }

    public void setTransRevisado(boolean transRevisado) {
        this.transRevisado = transRevisado;
    }

    public boolean getTransAnulado() {
        return transAnulado;
    }

    public void setTransAnulado(boolean transAnulado) {
        this.transAnulado = transAnulado;
    }

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
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

    public InvBodega getInvBodega() {
        return invBodega;
    }

    public void setInvBodega(InvBodega invBodega) {
        this.invBodega = invBodega;
    }

    public InvBodega getInvBodega1() {
        return invBodega1;
    }

    public void setInvBodega1(InvBodega invBodega1) {
        this.invBodega1 = invBodega1;
    }

    public List<InvTransferenciasDetalle> getInvTransferenciasDetalleList() {
        return invTransferenciasDetalleList;
    }

    public void setInvTransferenciasDetalleList(List<InvTransferenciasDetalle> invTransferenciasDetalleList) {
        this.invTransferenciasDetalleList = invTransferenciasDetalleList;
    }

    public List<InvTransferenciasMotivoAnulacion> getInvTransferenciasMotivoAnulacionList() {
        return invTransferenciasMotivoAnulacionList;
    }

    public void setInvTransferenciasMotivoAnulacionList(List<InvTransferenciasMotivoAnulacion> invTransferenciasMotivoAnulacionList) {
        this.invTransferenciasMotivoAnulacionList = invTransferenciasMotivoAnulacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invTransferenciasPK != null ? invTransferenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTransferencias)) {
            return false;
        }
        InvTransferencias other = (InvTransferencias) object;
        if ((this.invTransferenciasPK == null && other.invTransferenciasPK != null) || (this.invTransferenciasPK != null && !this.invTransferenciasPK.equals(other.invTransferenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvTransferencias[ invTransferenciasPK=" + invTransferenciasPK + " ]";
    }
    
}
