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
@Table(name = "inv_proveedor", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProveedor.findAll", query = "SELECT i FROM InvProveedor i"),
    @NamedQuery(name = "InvProveedor.findByProvEmpresa", query = "SELECT i FROM InvProveedor i WHERE i.invProveedorPK.provEmpresa = :provEmpresa"),
    @NamedQuery(name = "InvProveedor.findByProvCodigo", query = "SELECT i FROM InvProveedor i WHERE i.invProveedorPK.provCodigo = :provCodigo"),
    @NamedQuery(name = "InvProveedor.findByProvIdEmpresa", query = "SELECT i FROM InvProveedor i WHERE i.provIdEmpresa = :provIdEmpresa"),
    @NamedQuery(name = "InvProveedor.findByProvIdTipo", query = "SELECT i FROM InvProveedor i WHERE i.provIdTipo = :provIdTipo"),
    @NamedQuery(name = "InvProveedor.findByProvIdNumero", query = "SELECT i FROM InvProveedor i WHERE i.provIdNumero = :provIdNumero"),
    @NamedQuery(name = "InvProveedor.findByProvNombre", query = "SELECT i FROM InvProveedor i WHERE i.provNombre = :provNombre"),
    @NamedQuery(name = "InvProveedor.findByProvRazonSocial", query = "SELECT i FROM InvProveedor i WHERE i.provRazonSocial = :provRazonSocial"),
    @NamedQuery(name = "InvProveedor.findByProvProvincia", query = "SELECT i FROM InvProveedor i WHERE i.provProvincia = :provProvincia"),
    @NamedQuery(name = "InvProveedor.findByProvCiudad", query = "SELECT i FROM InvProveedor i WHERE i.provCiudad = :provCiudad"),
    @NamedQuery(name = "InvProveedor.findByProvParroquia", query = "SELECT i FROM InvProveedor i WHERE i.provParroquia = :provParroquia"),
    @NamedQuery(name = "InvProveedor.findByProvZona", query = "SELECT i FROM InvProveedor i WHERE i.provZona = :provZona"),
    @NamedQuery(name = "InvProveedor.findByProvDireccion", query = "SELECT i FROM InvProveedor i WHERE i.provDireccion = :provDireccion"),
    @NamedQuery(name = "InvProveedor.findByProvTelefono", query = "SELECT i FROM InvProveedor i WHERE i.provTelefono = :provTelefono"),
    @NamedQuery(name = "InvProveedor.findByProvCelular", query = "SELECT i FROM InvProveedor i WHERE i.provCelular = :provCelular"),
    @NamedQuery(name = "InvProveedor.findByProvEmail", query = "SELECT i FROM InvProveedor i WHERE i.provEmail = :provEmail"),
    @NamedQuery(name = "InvProveedor.findByProvObservaciones", query = "SELECT i FROM InvProveedor i WHERE i.provObservaciones = :provObservaciones"),
    @NamedQuery(name = "InvProveedor.findByProvRelacionado", query = "SELECT i FROM InvProveedor i WHERE i.provRelacionado = :provRelacionado"),
    @NamedQuery(name = "InvProveedor.findByProvInactivo", query = "SELECT i FROM InvProveedor i WHERE i.provInactivo = :provInactivo"),
    @NamedQuery(name = "InvProveedor.findByProvSecuencia", query = "SELECT i FROM InvProveedor i WHERE i.provSecuencia = :provSecuencia"),
    @NamedQuery(name = "InvProveedor.findByUsrEmpresa", query = "SELECT i FROM InvProveedor i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProveedor.findByUsrCodigo", query = "SELECT i FROM InvProveedor i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProveedor.findByUsrFechaInserta", query = "SELECT i FROM InvProveedor i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProveedorPK invProveedorPK;
    @Column(name = "prov_id_empresa")
    private String provIdEmpresa;
    @Column(name = "prov_id_tipo")
    private Character provIdTipo;
    @Column(name = "prov_id_numero")
    private String provIdNumero;
    @Basic(optional = false)
    @Column(name = "prov_nombre")
    private String provNombre;
    @Column(name = "prov_razon_social")
    private String provRazonSocial;
    @Column(name = "prov_provincia")
    private String provProvincia;
    @Column(name = "prov_ciudad")
    private String provCiudad;
    @Column(name = "prov_parroquia")
    private String provParroquia;
    @Column(name = "prov_zona")
    private String provZona;
    @Column(name = "prov_direccion")
    private String provDireccion;
    @Column(name = "prov_telefono")
    private String provTelefono;
    @Column(name = "prov_celular")
    private String provCelular;
    @Column(name = "prov_email")
    private String provEmail;
    @Column(name = "prov_observaciones")
    private String provObservaciones;
    @Column(name = "prov_relacionado")
    private Boolean provRelacionado;
    @Column(name = "prov_inactivo")
    private Boolean provInactivo;
    @Column(name = "prov_secuencia")
    private Integer provSecuencia;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProveedor")
    private List<InvCompras> invComprasList;
    @JoinColumns({
        @JoinColumn(name = "pc_empresa", referencedColumnName = "pc_empresa"),
        @JoinColumn(name = "pc_codigo", referencedColumnName = "pc_codigo")})
    @ManyToOne(optional = false)
    private InvProveedorCategoria invProveedorCategoria;

    public InvProveedor() {
    }

    public InvProveedor(InvProveedorPK invProveedorPK) {
        this.invProveedorPK = invProveedorPK;
    }

    public InvProveedor(InvProveedorPK invProveedorPK, String provNombre, String usrEmpresa, String usrCodigo) {
        this.invProveedorPK = invProveedorPK;
        this.provNombre = provNombre;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
    }

    public InvProveedor(String provEmpresa, String provCodigo) {
        this.invProveedorPK = new InvProveedorPK(provEmpresa, provCodigo);
    }

    public InvProveedorPK getInvProveedorPK() {
        return invProveedorPK;
    }

    public void setInvProveedorPK(InvProveedorPK invProveedorPK) {
        this.invProveedorPK = invProveedorPK;
    }

    public String getProvIdEmpresa() {
        return provIdEmpresa;
    }

    public void setProvIdEmpresa(String provIdEmpresa) {
        this.provIdEmpresa = provIdEmpresa;
    }

    public Character getProvIdTipo() {
        return provIdTipo;
    }

    public void setProvIdTipo(Character provIdTipo) {
        this.provIdTipo = provIdTipo;
    }

    public String getProvIdNumero() {
        return provIdNumero;
    }

    public void setProvIdNumero(String provIdNumero) {
        this.provIdNumero = provIdNumero;
    }

    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    public String getProvRazonSocial() {
        return provRazonSocial;
    }

    public void setProvRazonSocial(String provRazonSocial) {
        this.provRazonSocial = provRazonSocial;
    }

    public String getProvProvincia() {
        return provProvincia;
    }

    public void setProvProvincia(String provProvincia) {
        this.provProvincia = provProvincia;
    }

    public String getProvCiudad() {
        return provCiudad;
    }

    public void setProvCiudad(String provCiudad) {
        this.provCiudad = provCiudad;
    }

    public String getProvParroquia() {
        return provParroquia;
    }

    public void setProvParroquia(String provParroquia) {
        this.provParroquia = provParroquia;
    }

    public String getProvZona() {
        return provZona;
    }

    public void setProvZona(String provZona) {
        this.provZona = provZona;
    }

    public String getProvDireccion() {
        return provDireccion;
    }

    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    public String getProvTelefono() {
        return provTelefono;
    }

    public void setProvTelefono(String provTelefono) {
        this.provTelefono = provTelefono;
    }

    public String getProvCelular() {
        return provCelular;
    }

    public void setProvCelular(String provCelular) {
        this.provCelular = provCelular;
    }

    public String getProvEmail() {
        return provEmail;
    }

    public void setProvEmail(String provEmail) {
        this.provEmail = provEmail;
    }

    public String getProvObservaciones() {
        return provObservaciones;
    }

    public void setProvObservaciones(String provObservaciones) {
        this.provObservaciones = provObservaciones;
    }

    public Boolean getProvRelacionado() {
        return provRelacionado;
    }

    public void setProvRelacionado(Boolean provRelacionado) {
        this.provRelacionado = provRelacionado;
    }

    public Boolean getProvInactivo() {
        return provInactivo;
    }

    public void setProvInactivo(Boolean provInactivo) {
        this.provInactivo = provInactivo;
    }

    public Integer getProvSecuencia() {
        return provSecuencia;
    }

    public void setProvSecuencia(Integer provSecuencia) {
        this.provSecuencia = provSecuencia;
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

    public List<InvCompras> getInvComprasList() {
        return invComprasList;
    }

    public void setInvComprasList(List<InvCompras> invComprasList) {
        this.invComprasList = invComprasList;
    }

    public InvProveedorCategoria getInvProveedorCategoria() {
        return invProveedorCategoria;
    }

    public void setInvProveedorCategoria(InvProveedorCategoria invProveedorCategoria) {
        this.invProveedorCategoria = invProveedorCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProveedorPK != null ? invProveedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProveedor)) {
            return false;
        }
        InvProveedor other = (InvProveedor) object;
        if ((this.invProveedorPK == null && other.invProveedorPK != null) || (this.invProveedorPK != null && !this.invProveedorPK.equals(other.invProveedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProveedor[ invProveedorPK=" + invProveedorPK + " ]";
    }
    
}
