/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_cliente", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvCliente.findAll", query = "SELECT i FROM InvCliente i"),
    @NamedQuery(name = "InvCliente.findByCliEmpresa", query = "SELECT i FROM InvCliente i WHERE i.invClientePK.cliEmpresa = :cliEmpresa"),
    @NamedQuery(name = "InvCliente.findByCliCodigo", query = "SELECT i FROM InvCliente i WHERE i.invClientePK.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "InvCliente.findByCliIdEmpresa", query = "SELECT i FROM InvCliente i WHERE i.cliIdEmpresa = :cliIdEmpresa"),
    @NamedQuery(name = "InvCliente.findByCliIdTipo", query = "SELECT i FROM InvCliente i WHERE i.cliIdTipo = :cliIdTipo"),
    @NamedQuery(name = "InvCliente.findByCliIdNumero", query = "SELECT i FROM InvCliente i WHERE i.cliIdNumero = :cliIdNumero"),
    @NamedQuery(name = "InvCliente.findByCliNombre", query = "SELECT i FROM InvCliente i WHERE i.cliNombre = :cliNombre"),
    @NamedQuery(name = "InvCliente.findByCliRazonSocial", query = "SELECT i FROM InvCliente i WHERE i.cliRazonSocial = :cliRazonSocial"),
    @NamedQuery(name = "InvCliente.findByCliProvincia", query = "SELECT i FROM InvCliente i WHERE i.cliProvincia = :cliProvincia"),
    @NamedQuery(name = "InvCliente.findByCliCiudad", query = "SELECT i FROM InvCliente i WHERE i.cliCiudad = :cliCiudad"),
    @NamedQuery(name = "InvCliente.findByCliParroquia", query = "SELECT i FROM InvCliente i WHERE i.cliParroquia = :cliParroquia"),
    @NamedQuery(name = "InvCliente.findByCliZona", query = "SELECT i FROM InvCliente i WHERE i.cliZona = :cliZona"),
    @NamedQuery(name = "InvCliente.findByCliDireccion", query = "SELECT i FROM InvCliente i WHERE i.cliDireccion = :cliDireccion"),
    @NamedQuery(name = "InvCliente.findByCliTelefono", query = "SELECT i FROM InvCliente i WHERE i.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "InvCliente.findByCliCelular", query = "SELECT i FROM InvCliente i WHERE i.cliCelular = :cliCelular"),
    @NamedQuery(name = "InvCliente.findByCliEmail", query = "SELECT i FROM InvCliente i WHERE i.cliEmail = :cliEmail"),
    @NamedQuery(name = "InvCliente.findByCliPrecio", query = "SELECT i FROM InvCliente i WHERE i.cliPrecio = :cliPrecio"),
    @NamedQuery(name = "InvCliente.findByCliDiasCredito", query = "SELECT i FROM InvCliente i WHERE i.cliDiasCredito = :cliDiasCredito"),
    @NamedQuery(name = "InvCliente.findByCliCupoCredito", query = "SELECT i FROM InvCliente i WHERE i.cliCupoCredito = :cliCupoCredito"),
    @NamedQuery(name = "InvCliente.findByCliObservaciones", query = "SELECT i FROM InvCliente i WHERE i.cliObservaciones = :cliObservaciones"),
    @NamedQuery(name = "InvCliente.findByCliRelacionado", query = "SELECT i FROM InvCliente i WHERE i.cliRelacionado = :cliRelacionado"),
    @NamedQuery(name = "InvCliente.findByCliInactivo", query = "SELECT i FROM InvCliente i WHERE i.cliInactivo = :cliInactivo"),
    @NamedQuery(name = "InvCliente.findByCliSecuencia", query = "SELECT i FROM InvCliente i WHERE i.cliSecuencia = :cliSecuencia"),
    @NamedQuery(name = "InvCliente.findByUsrEmpresa", query = "SELECT i FROM InvCliente i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvCliente.findByUsrCodigo", query = "SELECT i FROM InvCliente i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvCliente.findByUsrFechaInserta", query = "SELECT i FROM InvCliente i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvClientePK invClientePK;
    @Column(name = "cli_id_empresa")
    private String cliIdEmpresa;
    @Column(name = "cli_id_tipo")
    private Character cliIdTipo;
    @Column(name = "cli_id_numero")
    private String cliIdNumero;
    @Basic(optional = false)
    @Column(name = "cli_nombre")
    private String cliNombre;
    @Column(name = "cli_razon_social")
    private String cliRazonSocial;
    @Column(name = "cli_provincia")
    private String cliProvincia;
    @Column(name = "cli_ciudad")
    private String cliCiudad;
    @Column(name = "cli_parroquia")
    private String cliParroquia;
    @Column(name = "cli_zona")
    private String cliZona;
    @Column(name = "cli_direccion")
    private String cliDireccion;
    @Column(name = "cli_telefono")
    private String cliTelefono;
    @Column(name = "cli_celular")
    private String cliCelular;
    @Column(name = "cli_email")
    private String cliEmail;
    @Column(name = "cli_precio")
    private Short cliPrecio;
    @Column(name = "cli_dias_credito")
    private Short cliDiasCredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cli_cupo_credito")
    private BigDecimal cliCupoCredito;
    @Column(name = "cli_observaciones")
    private String cliObservaciones;
    @Column(name = "cli_relacionado")
    private Boolean cliRelacionado;
    @Column(name = "cli_inactivo")
    private Boolean cliInactivo;
    @Column(name = "cli_secuencia")
    private Integer cliSecuencia;
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
        @JoinColumn(name = "vend_empresa", referencedColumnName = "vend_empresa"),
        @JoinColumn(name = "vend_codigo", referencedColumnName = "vend_codigo")})
    @ManyToOne
    private InvVendedor invVendedor;
    @JoinColumns({
        @JoinColumn(name = "cc_empresa", referencedColumnName = "cc_empresa"),
        @JoinColumn(name = "cc_codigo", referencedColumnName = "cc_codigo")})
    @ManyToOne(optional = false)
    private InvClienteCategoria invClienteCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invCliente")
    private List<InvProformas> invProformasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invCliente")
    private List<InvVentas> invVentasList;

    public InvCliente() {
    }

    public InvCliente(InvClientePK invClientePK) {
        this.invClientePK = invClientePK;
    }

    public InvCliente(InvClientePK invClientePK, String cliNombre, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invClientePK = invClientePK;
        this.cliNombre = cliNombre;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvCliente(String cliEmpresa, String cliCodigo) {
        this.invClientePK = new InvClientePK(cliEmpresa, cliCodigo);
    }

    public InvClientePK getInvClientePK() {
        return invClientePK;
    }

    public void setInvClientePK(InvClientePK invClientePK) {
        this.invClientePK = invClientePK;
    }

    public String getCliIdEmpresa() {
        return cliIdEmpresa;
    }

    public void setCliIdEmpresa(String cliIdEmpresa) {
        this.cliIdEmpresa = cliIdEmpresa;
    }

    public Character getCliIdTipo() {
        return cliIdTipo;
    }

    public void setCliIdTipo(Character cliIdTipo) {
        this.cliIdTipo = cliIdTipo;
    }

    public String getCliIdNumero() {
        return cliIdNumero;
    }

    public void setCliIdNumero(String cliIdNumero) {
        this.cliIdNumero = cliIdNumero;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliRazonSocial() {
        return cliRazonSocial;
    }

    public void setCliRazonSocial(String cliRazonSocial) {
        this.cliRazonSocial = cliRazonSocial;
    }

    public String getCliProvincia() {
        return cliProvincia;
    }

    public void setCliProvincia(String cliProvincia) {
        this.cliProvincia = cliProvincia;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    public String getCliParroquia() {
        return cliParroquia;
    }

    public void setCliParroquia(String cliParroquia) {
        this.cliParroquia = cliParroquia;
    }

    public String getCliZona() {
        return cliZona;
    }

    public void setCliZona(String cliZona) {
        this.cliZona = cliZona;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public Short getCliPrecio() {
        return cliPrecio;
    }

    public void setCliPrecio(Short cliPrecio) {
        this.cliPrecio = cliPrecio;
    }

    public Short getCliDiasCredito() {
        return cliDiasCredito;
    }

    public void setCliDiasCredito(Short cliDiasCredito) {
        this.cliDiasCredito = cliDiasCredito;
    }

    public BigDecimal getCliCupoCredito() {
        return cliCupoCredito;
    }

    public void setCliCupoCredito(BigDecimal cliCupoCredito) {
        this.cliCupoCredito = cliCupoCredito;
    }

    public String getCliObservaciones() {
        return cliObservaciones;
    }

    public void setCliObservaciones(String cliObservaciones) {
        this.cliObservaciones = cliObservaciones;
    }

    public Boolean getCliRelacionado() {
        return cliRelacionado;
    }

    public void setCliRelacionado(Boolean cliRelacionado) {
        this.cliRelacionado = cliRelacionado;
    }

    public Boolean getCliInactivo() {
        return cliInactivo;
    }

    public void setCliInactivo(Boolean cliInactivo) {
        this.cliInactivo = cliInactivo;
    }

    public Integer getCliSecuencia() {
        return cliSecuencia;
    }

    public void setCliSecuencia(Integer cliSecuencia) {
        this.cliSecuencia = cliSecuencia;
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

    public InvVendedor getInvVendedor() {
        return invVendedor;
    }

    public void setInvVendedor(InvVendedor invVendedor) {
        this.invVendedor = invVendedor;
    }

    public InvClienteCategoria getInvClienteCategoria() {
        return invClienteCategoria;
    }

    public void setInvClienteCategoria(InvClienteCategoria invClienteCategoria) {
        this.invClienteCategoria = invClienteCategoria;
    }

    public List<InvProformas> getInvProformasList() {
        return invProformasList;
    }

    public void setInvProformasList(List<InvProformas> invProformasList) {
        this.invProformasList = invProformasList;
    }

    public List<InvVentas> getInvVentasList() {
        return invVentasList;
    }

    public void setInvVentasList(List<InvVentas> invVentasList) {
        this.invVentasList = invVentasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invClientePK != null ? invClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvCliente)) {
            return false;
        }
        InvCliente other = (InvCliente) object;
        if ((this.invClientePK == null && other.invClientePK != null) || (this.invClientePK != null && !this.invClientePK.equals(other.invClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvCliente[ invClientePK=" + invClientePK + " ]";
    }
    
}
