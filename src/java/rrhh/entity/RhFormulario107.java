/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "rh_formulario_107", schema = "recursoshumanos")
@NamedQueries({
    @NamedQuery(name = "RhFormulario107.findAll", query = "SELECT r FROM RhFormulario107 r"),
    @NamedQuery(name = "RhFormulario107.findByF107Empresa", query = "SELECT r FROM RhFormulario107 r WHERE r.rhFormulario107PK.f107Empresa = :f107Empresa"),
    @NamedQuery(name = "RhFormulario107.findByF107Anio", query = "SELECT r FROM RhFormulario107 r WHERE r.rhFormulario107PK.f107Anio = :f107Anio"),
    @NamedQuery(name = "RhFormulario107.findByF107Id", query = "SELECT r FROM RhFormulario107 r WHERE r.rhFormulario107PK.f107Id = :f107Id"),
    @NamedQuery(name = "RhFormulario107.findByF107Tipo", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Tipo = :f107Tipo"),
    @NamedQuery(name = "RhFormulario107.findByF107Nombres", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Nombres = :f107Nombres"),
    @NamedQuery(name = "RhFormulario107.findByF107Direccion", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Direccion = :f107Direccion"),
    @NamedQuery(name = "RhFormulario107.findByF107NumeroCasa", query = "SELECT r FROM RhFormulario107 r WHERE r.f107NumeroCasa = :f107NumeroCasa"),
    @NamedQuery(name = "RhFormulario107.findByF107Canton", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Canton = :f107Canton"),
    @NamedQuery(name = "RhFormulario107.findByF107Provincia", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Provincia = :f107Provincia"),
    @NamedQuery(name = "RhFormulario107.findByF107Telefono", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Telefono = :f107Telefono"),
    @NamedQuery(name = "RhFormulario107.findByF107SalarioNeto", query = "SELECT r FROM RhFormulario107 r WHERE r.f107SalarioNeto = :f107SalarioNeto"),
    @NamedQuery(name = "RhFormulario107.findByF107Sueldo", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Sueldo = :f107Sueldo"),
    @NamedQuery(name = "RhFormulario107.findByF107Bonos", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Bonos = :f107Bonos"),
    @NamedQuery(name = "RhFormulario107.findByF107XiiiSueldo", query = "SELECT r FROM RhFormulario107 r WHERE r.f107XiiiSueldo = :f107XiiiSueldo"),
    @NamedQuery(name = "RhFormulario107.findByF107XivSueldo", query = "SELECT r FROM RhFormulario107 r WHERE r.f107XivSueldo = :f107XivSueldo"),
    @NamedQuery(name = "RhFormulario107.findByF107FondoReserva", query = "SELECT r FROM RhFormulario107 r WHERE r.f107FondoReserva = :f107FondoReserva"),
    @NamedQuery(name = "RhFormulario107.findByF107SalarioDigno", query = "SELECT r FROM RhFormulario107 r WHERE r.f107SalarioDigno = :f107SalarioDigno"),
    @NamedQuery(name = "RhFormulario107.findByF107Utilidades", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Utilidades = :f107Utilidades"),
    @NamedQuery(name = "RhFormulario107.findByF107Desahucio", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Desahucio = :f107Desahucio"),
    @NamedQuery(name = "RhFormulario107.findByF107Iess", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Iess = :f107Iess"),
    @NamedQuery(name = "RhFormulario107.findByF107Vivienda", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Vivienda = :f107Vivienda"),
    @NamedQuery(name = "RhFormulario107.findByF107Salud", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Salud = :f107Salud"),
    @NamedQuery(name = "RhFormulario107.findByF107Educacion", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Educacion = :f107Educacion"),
    @NamedQuery(name = "RhFormulario107.findByF107Alimentacion", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Alimentacion = :f107Alimentacion"),
    @NamedQuery(name = "RhFormulario107.findByF107Vestuario", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Vestuario = :f107Vestuario"),
    @NamedQuery(name = "RhFormulario107.findByF107RebajaDiscapacitado", query = "SELECT r FROM RhFormulario107 r WHERE r.f107RebajaDiscapacitado = :f107RebajaDiscapacitado"),
    @NamedQuery(name = "RhFormulario107.findByF107RebajaTerceraEdad", query = "SELECT r FROM RhFormulario107 r WHERE r.f107RebajaTerceraEdad = :f107RebajaTerceraEdad"),
    @NamedQuery(name = "RhFormulario107.findByF107ImpuestoAsumido", query = "SELECT r FROM RhFormulario107 r WHERE r.f107ImpuestoAsumido = :f107ImpuestoAsumido"),
    @NamedQuery(name = "RhFormulario107.findByF107Subtotal", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Subtotal = :f107Subtotal"),
    @NamedQuery(name = "RhFormulario107.findByF107MesesTrabajados", query = "SELECT r FROM RhFormulario107 r WHERE r.f107MesesTrabajados = :f107MesesTrabajados"),
    @NamedQuery(name = "RhFormulario107.findByF107OtrosIngresos", query = "SELECT r FROM RhFormulario107 r WHERE r.f107OtrosIngresos = :f107OtrosIngresos"),
    @NamedQuery(name = "RhFormulario107.findByF107OtrasDeducciones", query = "SELECT r FROM RhFormulario107 r WHERE r.f107OtrasDeducciones = :f107OtrasDeducciones"),
    @NamedQuery(name = "RhFormulario107.findByF107OtrasRebajas", query = "SELECT r FROM RhFormulario107 r WHERE r.f107OtrasRebajas = :f107OtrasRebajas"),
    @NamedQuery(name = "RhFormulario107.findByF107BaseImponible", query = "SELECT r FROM RhFormulario107 r WHERE r.f107BaseImponible = :f107BaseImponible"),
    @NamedQuery(name = "RhFormulario107.findByF107ImpuestoCausado", query = "SELECT r FROM RhFormulario107 r WHERE r.f107ImpuestoCausado = :f107ImpuestoCausado"),
    @NamedQuery(name = "RhFormulario107.findByF107ValorRetenido", query = "SELECT r FROM RhFormulario107 r WHERE r.f107ValorRetenido = :f107ValorRetenido"),
    @NamedQuery(name = "RhFormulario107.findByF107NumeroRetenciones", query = "SELECT r FROM RhFormulario107 r WHERE r.f107NumeroRetenciones = :f107NumeroRetenciones"),
    @NamedQuery(name = "RhFormulario107.findByF107Impuesto", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Impuesto = :f107Impuesto"),
    @NamedQuery(name = "RhFormulario107.findByF107Contador", query = "SELECT r FROM RhFormulario107 r WHERE r.f107Contador = :f107Contador"),
    @NamedQuery(name = "RhFormulario107.findByF107FechaEntrega", query = "SELECT r FROM RhFormulario107 r WHERE r.f107FechaEntrega = :f107FechaEntrega"),
    @NamedQuery(name = "RhFormulario107.findByF107NumeroFormulario", query = "SELECT r FROM RhFormulario107 r WHERE r.f107NumeroFormulario = :f107NumeroFormulario"),
    @NamedQuery(name = "RhFormulario107.findByUsrEmpresa", query = "SELECT r FROM RhFormulario107 r WHERE r.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "RhFormulario107.findByUsrCodigo", query = "SELECT r FROM RhFormulario107 r WHERE r.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "RhFormulario107.findByUsrFechaInserta", query = "SELECT r FROM RhFormulario107 r WHERE r.usrFechaInserta = :usrFechaInserta")})
public class RhFormulario107 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RhFormulario107PK rhFormulario107PK;
    @Column(name = "f107_tipo")
    private Character f107Tipo;
    @Column(name = "f107_nombres")
    private String f107Nombres;
    @Column(name = "f107_direccion")
    private String f107Direccion;
    @Column(name = "f107_numero_casa")
    private String f107NumeroCasa;
    @Column(name = "f107_canton")
    private String f107Canton;
    @Column(name = "f107_provincia")
    private String f107Provincia;
    @Column(name = "f107_telefono")
    private String f107Telefono;
    @Column(name = "f107_salario_neto")
    private Character f107SalarioNeto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "f107_sueldo")
    private BigDecimal f107Sueldo;
    @Column(name = "f107_bonos")
    private BigDecimal f107Bonos;
    @Column(name = "f107_xiii_sueldo")
    private BigDecimal f107XiiiSueldo;
    @Column(name = "f107_xiv_sueldo")
    private BigDecimal f107XivSueldo;
    @Column(name = "f107_fondo_reserva")
    private BigDecimal f107FondoReserva;
    @Column(name = "f107_salario_digno")
    private BigDecimal f107SalarioDigno;
    @Column(name = "f107_utilidades")
    private BigDecimal f107Utilidades;
    @Column(name = "f107_desahucio")
    private BigDecimal f107Desahucio;
    @Column(name = "f107_iess")
    private BigDecimal f107Iess;
    @Column(name = "f107_vivienda")
    private BigDecimal f107Vivienda;
    @Column(name = "f107_salud")
    private BigDecimal f107Salud;
    @Column(name = "f107_educacion")
    private BigDecimal f107Educacion;
    @Column(name = "f107_alimentacion")
    private BigDecimal f107Alimentacion;
    @Column(name = "f107_vestuario")
    private BigDecimal f107Vestuario;
    @Column(name = "f107_rebaja_discapacitado")
    private BigDecimal f107RebajaDiscapacitado;
    @Column(name = "f107_rebaja_tercera_edad")
    private BigDecimal f107RebajaTerceraEdad;
    @Column(name = "f107_impuesto_asumido")
    private BigDecimal f107ImpuestoAsumido;
    @Column(name = "f107_subtotal")
    private BigDecimal f107Subtotal;
    @Column(name = "f107_meses_trabajados")
    private BigDecimal f107MesesTrabajados;
    @Column(name = "f107_otros_ingresos")
    private BigDecimal f107OtrosIngresos;
    @Column(name = "f107_otras_deducciones")
    private BigDecimal f107OtrasDeducciones;
    @Column(name = "f107_otras_rebajas")
    private BigDecimal f107OtrasRebajas;
    @Column(name = "f107_base_imponible")
    private BigDecimal f107BaseImponible;
    @Column(name = "f107_impuesto_causado")
    private BigDecimal f107ImpuestoCausado;
    @Column(name = "f107_valor_retenido")
    private BigDecimal f107ValorRetenido;
    @Column(name = "f107_numero_retenciones")
    private Short f107NumeroRetenciones;
    @Column(name = "f107_impuesto")
    private BigDecimal f107Impuesto;
    @Column(name = "f107_contador")
    private String f107Contador;
    @Column(name = "f107_fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date f107FechaEntrega;
    @Column(name = "f107_numero_formulario")
    private String f107NumeroFormulario;
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;

    public RhFormulario107() {
    }

    public RhFormulario107(RhFormulario107PK rhFormulario107PK) {
        this.rhFormulario107PK = rhFormulario107PK;
    }

    public RhFormulario107(String f107Empresa, String f107Anio, String f107Id) {
        this.rhFormulario107PK = new RhFormulario107PK(f107Empresa, f107Anio, f107Id);
    }

    public RhFormulario107PK getRhFormulario107PK() {
        return rhFormulario107PK;
    }

    public void setRhFormulario107PK(RhFormulario107PK rhFormulario107PK) {
        this.rhFormulario107PK = rhFormulario107PK;
    }

    public Character getF107Tipo() {
        return f107Tipo;
    }

    public void setF107Tipo(Character f107Tipo) {
        this.f107Tipo = f107Tipo;
    }

    public String getF107Nombres() {
        return f107Nombres;
    }

    public void setF107Nombres(String f107Nombres) {
        this.f107Nombres = f107Nombres;
    }

    public String getF107Direccion() {
        return f107Direccion;
    }

    public void setF107Direccion(String f107Direccion) {
        this.f107Direccion = f107Direccion;
    }

    public String getF107NumeroCasa() {
        return f107NumeroCasa;
    }

    public void setF107NumeroCasa(String f107NumeroCasa) {
        this.f107NumeroCasa = f107NumeroCasa;
    }

    public String getF107Canton() {
        return f107Canton;
    }

    public void setF107Canton(String f107Canton) {
        this.f107Canton = f107Canton;
    }

    public String getF107Provincia() {
        return f107Provincia;
    }

    public void setF107Provincia(String f107Provincia) {
        this.f107Provincia = f107Provincia;
    }

    public String getF107Telefono() {
        return f107Telefono;
    }

    public void setF107Telefono(String f107Telefono) {
        this.f107Telefono = f107Telefono;
    }

    public Character getF107SalarioNeto() {
        return f107SalarioNeto;
    }

    public void setF107SalarioNeto(Character f107SalarioNeto) {
        this.f107SalarioNeto = f107SalarioNeto;
    }

    public BigDecimal getF107Sueldo() {
        return f107Sueldo;
    }

    public void setF107Sueldo(BigDecimal f107Sueldo) {
        this.f107Sueldo = f107Sueldo;
    }

    public BigDecimal getF107Bonos() {
        return f107Bonos;
    }

    public void setF107Bonos(BigDecimal f107Bonos) {
        this.f107Bonos = f107Bonos;
    }

    public BigDecimal getF107XiiiSueldo() {
        return f107XiiiSueldo;
    }

    public void setF107XiiiSueldo(BigDecimal f107XiiiSueldo) {
        this.f107XiiiSueldo = f107XiiiSueldo;
    }

    public BigDecimal getF107XivSueldo() {
        return f107XivSueldo;
    }

    public void setF107XivSueldo(BigDecimal f107XivSueldo) {
        this.f107XivSueldo = f107XivSueldo;
    }

    public BigDecimal getF107FondoReserva() {
        return f107FondoReserva;
    }

    public void setF107FondoReserva(BigDecimal f107FondoReserva) {
        this.f107FondoReserva = f107FondoReserva;
    }

    public BigDecimal getF107SalarioDigno() {
        return f107SalarioDigno;
    }

    public void setF107SalarioDigno(BigDecimal f107SalarioDigno) {
        this.f107SalarioDigno = f107SalarioDigno;
    }

    public BigDecimal getF107Utilidades() {
        return f107Utilidades;
    }

    public void setF107Utilidades(BigDecimal f107Utilidades) {
        this.f107Utilidades = f107Utilidades;
    }

    public BigDecimal getF107Desahucio() {
        return f107Desahucio;
    }

    public void setF107Desahucio(BigDecimal f107Desahucio) {
        this.f107Desahucio = f107Desahucio;
    }

    public BigDecimal getF107Iess() {
        return f107Iess;
    }

    public void setF107Iess(BigDecimal f107Iess) {
        this.f107Iess = f107Iess;
    }

    public BigDecimal getF107Vivienda() {
        return f107Vivienda;
    }

    public void setF107Vivienda(BigDecimal f107Vivienda) {
        this.f107Vivienda = f107Vivienda;
    }

    public BigDecimal getF107Salud() {
        return f107Salud;
    }

    public void setF107Salud(BigDecimal f107Salud) {
        this.f107Salud = f107Salud;
    }

    public BigDecimal getF107Educacion() {
        return f107Educacion;
    }

    public void setF107Educacion(BigDecimal f107Educacion) {
        this.f107Educacion = f107Educacion;
    }

    public BigDecimal getF107Alimentacion() {
        return f107Alimentacion;
    }

    public void setF107Alimentacion(BigDecimal f107Alimentacion) {
        this.f107Alimentacion = f107Alimentacion;
    }

    public BigDecimal getF107Vestuario() {
        return f107Vestuario;
    }

    public void setF107Vestuario(BigDecimal f107Vestuario) {
        this.f107Vestuario = f107Vestuario;
    }

    public BigDecimal getF107RebajaDiscapacitado() {
        return f107RebajaDiscapacitado;
    }

    public void setF107RebajaDiscapacitado(BigDecimal f107RebajaDiscapacitado) {
        this.f107RebajaDiscapacitado = f107RebajaDiscapacitado;
    }

    public BigDecimal getF107RebajaTerceraEdad() {
        return f107RebajaTerceraEdad;
    }

    public void setF107RebajaTerceraEdad(BigDecimal f107RebajaTerceraEdad) {
        this.f107RebajaTerceraEdad = f107RebajaTerceraEdad;
    }

    public BigDecimal getF107ImpuestoAsumido() {
        return f107ImpuestoAsumido;
    }

    public void setF107ImpuestoAsumido(BigDecimal f107ImpuestoAsumido) {
        this.f107ImpuestoAsumido = f107ImpuestoAsumido;
    }

    public BigDecimal getF107Subtotal() {
        return f107Subtotal;
    }

    public void setF107Subtotal(BigDecimal f107Subtotal) {
        this.f107Subtotal = f107Subtotal;
    }

    public BigDecimal getF107MesesTrabajados() {
        return f107MesesTrabajados;
    }

    public void setF107MesesTrabajados(BigDecimal f107MesesTrabajados) {
        this.f107MesesTrabajados = f107MesesTrabajados;
    }

    public BigDecimal getF107OtrosIngresos() {
        return f107OtrosIngresos;
    }

    public void setF107OtrosIngresos(BigDecimal f107OtrosIngresos) {
        this.f107OtrosIngresos = f107OtrosIngresos;
    }

    public BigDecimal getF107OtrasDeducciones() {
        return f107OtrasDeducciones;
    }

    public void setF107OtrasDeducciones(BigDecimal f107OtrasDeducciones) {
        this.f107OtrasDeducciones = f107OtrasDeducciones;
    }

    public BigDecimal getF107OtrasRebajas() {
        return f107OtrasRebajas;
    }

    public void setF107OtrasRebajas(BigDecimal f107OtrasRebajas) {
        this.f107OtrasRebajas = f107OtrasRebajas;
    }

    public BigDecimal getF107BaseImponible() {
        return f107BaseImponible;
    }

    public void setF107BaseImponible(BigDecimal f107BaseImponible) {
        this.f107BaseImponible = f107BaseImponible;
    }

    public BigDecimal getF107ImpuestoCausado() {
        return f107ImpuestoCausado;
    }

    public void setF107ImpuestoCausado(BigDecimal f107ImpuestoCausado) {
        this.f107ImpuestoCausado = f107ImpuestoCausado;
    }

    public BigDecimal getF107ValorRetenido() {
        return f107ValorRetenido;
    }

    public void setF107ValorRetenido(BigDecimal f107ValorRetenido) {
        this.f107ValorRetenido = f107ValorRetenido;
    }

    public Short getF107NumeroRetenciones() {
        return f107NumeroRetenciones;
    }

    public void setF107NumeroRetenciones(Short f107NumeroRetenciones) {
        this.f107NumeroRetenciones = f107NumeroRetenciones;
    }

    public BigDecimal getF107Impuesto() {
        return f107Impuesto;
    }

    public void setF107Impuesto(BigDecimal f107Impuesto) {
        this.f107Impuesto = f107Impuesto;
    }

    public String getF107Contador() {
        return f107Contador;
    }

    public void setF107Contador(String f107Contador) {
        this.f107Contador = f107Contador;
    }

    public Date getF107FechaEntrega() {
        return f107FechaEntrega;
    }

    public void setF107FechaEntrega(Date f107FechaEntrega) {
        this.f107FechaEntrega = f107FechaEntrega;
    }

    public String getF107NumeroFormulario() {
        return f107NumeroFormulario;
    }

    public void setF107NumeroFormulario(String f107NumeroFormulario) {
        this.f107NumeroFormulario = f107NumeroFormulario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rhFormulario107PK != null ? rhFormulario107PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhFormulario107)) {
            return false;
        }
        RhFormulario107 other = (RhFormulario107) object;
        if ((this.rhFormulario107PK == null && other.rhFormulario107PK != null) || (this.rhFormulario107PK != null && !this.rhFormulario107PK.equals(other.rhFormulario107PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rrhh.entity.RhFormulario107[ rhFormulario107PK=" + rhFormulario107PK + " ]";
    }
}
