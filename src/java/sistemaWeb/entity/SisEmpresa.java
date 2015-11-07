/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_empresa", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisEmpresa.findAll", query = "SELECT s FROM SisEmpresa s"),
    @NamedQuery(name = "SisEmpresa.findByEmpCodigo", query = "SELECT s FROM SisEmpresa s WHERE s.empCodigo = :empCodigo"),
    @NamedQuery(name = "SisEmpresa.findByEmpRuc", query = "SELECT s FROM SisEmpresa s WHERE s.empRuc = :empRuc"),
    @NamedQuery(name = "SisEmpresa.findByEmpNombre", query = "SELECT s FROM SisEmpresa s WHERE s.empNombre = :empNombre"),
    @NamedQuery(name = "SisEmpresa.findByEmpRazonSocial", query = "SELECT s FROM SisEmpresa s WHERE s.empRazonSocial = :empRazonSocial"),
    @NamedQuery(name = "SisEmpresa.findByEmpDireccion", query = "SELECT s FROM SisEmpresa s WHERE s.empDireccion = :empDireccion"),
    @NamedQuery(name = "SisEmpresa.findByEmpCiudad", query = "SELECT s FROM SisEmpresa s WHERE s.empCiudad = :empCiudad"),
    @NamedQuery(name = "SisEmpresa.findByEmpTelefono", query = "SELECT s FROM SisEmpresa s WHERE s.empTelefono = :empTelefono"),
    @NamedQuery(name = "SisEmpresa.findByEmpFax", query = "SELECT s FROM SisEmpresa s WHERE s.empFax = :empFax"),
    @NamedQuery(name = "SisEmpresa.findByEmpEmail", query = "SELECT s FROM SisEmpresa s WHERE s.empEmail = :empEmail"),
    @NamedQuery(name = "SisEmpresa.findByEmpClave", query = "SELECT s FROM SisEmpresa s WHERE s.empClave = :empClave"),
    @NamedQuery(name = "SisEmpresa.findByEmpActiva", query = "SELECT s FROM SisEmpresa s WHERE s.empActiva = :empActiva"),
    @NamedQuery(name = "SisEmpresa.findByUsrCodigo", query = "SELECT s FROM SisEmpresa s WHERE s.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "SisEmpresa.findByUsrFechaInsertaEmpresa", query = "SELECT s FROM SisEmpresa s WHERE s.usrFechaInsertaEmpresa = :usrFechaInsertaEmpresa")})
public class SisEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emp_codigo")
    private String empCodigo;
    @Column(name = "emp_ruc")
    private String empRuc;
    @Column(name = "emp_nombre")
    private String empNombre;
    @Column(name = "emp_razon_social")
    private String empRazonSocial;
    @Column(name = "emp_direccion")
    private String empDireccion;
    @Column(name = "emp_ciudad")
    private String empCiudad;
    @Column(name = "emp_telefono")
    private String empTelefono;
    @Column(name = "emp_fax")
    private String empFax;
    @Column(name = "emp_email")
    private String empEmail;
    @Column(name = "emp_clave")
    private String empClave;
    @Lob
    @Column(name = "emp_logo")
    private byte[] empLogo;
    @Column(name = "emp_activa")
    private Boolean empActiva;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta_empresa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInsertaEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empCodigo")
    private List<SisGrupo> sisGrupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empCodigo")
    private List<SisEmpresaParametros> sisEmpresaParametrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empCodigo")
    private List<SisPermiso> sisPermisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empCodigo")
    private List<SisPeriodo> sisPeriodoList;

    public SisEmpresa() {
    }

    public SisEmpresa(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public SisEmpresa(String empCodigo, String usrCodigo) {
        this.empCodigo = empCodigo;
        this.usrCodigo = usrCodigo;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getEmpRuc() {
        return empRuc;
    }

    public void setEmpRuc(String empRuc) {
        this.empRuc = empRuc;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpRazonSocial() {
        return empRazonSocial;
    }

    public void setEmpRazonSocial(String empRazonSocial) {
        this.empRazonSocial = empRazonSocial;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public String getEmpCiudad() {
        return empCiudad;
    }

    public void setEmpCiudad(String empCiudad) {
        this.empCiudad = empCiudad;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public String getEmpFax() {
        return empFax;
    }

    public void setEmpFax(String empFax) {
        this.empFax = empFax;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpClave() {
        return empClave;
    }

    public void setEmpClave(String empClave) {
        this.empClave = empClave;
    }

    public byte[] getEmpLogo() {
        return empLogo;
    }

    public void setEmpLogo(byte[] empLogo) {
        this.empLogo = empLogo;
    }

    public Boolean getEmpActiva() {
        return empActiva;
    }

    public void setEmpActiva(Boolean empActiva) {
        this.empActiva = empActiva;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInsertaEmpresa() {
        return usrFechaInsertaEmpresa;
    }

    public void setUsrFechaInsertaEmpresa(Date usrFechaInsertaEmpresa) {
        this.usrFechaInsertaEmpresa = usrFechaInsertaEmpresa;
    }

    public List<SisGrupo> getSisGrupoList() {
        return sisGrupoList;
    }

    public void setSisGrupoList(List<SisGrupo> sisGrupoList) {
        this.sisGrupoList = sisGrupoList;
    }

    public List<SisEmpresaParametros> getSisEmpresaParametrosList() {
        return sisEmpresaParametrosList;
    }

    public void setSisEmpresaParametrosList(List<SisEmpresaParametros> sisEmpresaParametrosList) {
        this.sisEmpresaParametrosList = sisEmpresaParametrosList;
    }

    public List<SisPermiso> getSisPermisoList() {
        return sisPermisoList;
    }

    public void setSisPermisoList(List<SisPermiso> sisPermisoList) {
        this.sisPermisoList = sisPermisoList;
    }

    public List<SisPeriodo> getSisPeriodoList() {
        return sisPeriodoList;
    }

    public void setSisPeriodoList(List<SisPeriodo> sisPeriodoList) {
        this.sisPeriodoList = sisPeriodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empCodigo != null ? empCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisEmpresa)) {
            return false;
        }
        SisEmpresa other = (SisEmpresa) object;
        if ((this.empCodigo == null && other.empCodigo != null) || (this.empCodigo != null && !this.empCodigo.equals(other.empCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisEmpresa[ empCodigo=" + empCodigo + " ]";
    }
    
}
