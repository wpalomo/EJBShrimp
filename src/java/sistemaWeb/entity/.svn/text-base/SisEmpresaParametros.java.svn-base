/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_empresa_parametros", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisEmpresaParametros.findAll", query = "SELECT s FROM SisEmpresaParametros s"),
    @NamedQuery(name = "SisEmpresaParametros.findByParEmpresa", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parEmpresa = :parEmpresa"),
    @NamedQuery(name = "SisEmpresaParametros.findByParGerente", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parGerente = :parGerente"),
    @NamedQuery(name = "SisEmpresaParametros.findByParGerenteTipoId", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parGerenteTipoId = :parGerenteTipoId"),
    @NamedQuery(name = "SisEmpresaParametros.findByParGerenteId", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parGerenteId = :parGerenteId"),
    @NamedQuery(name = "SisEmpresaParametros.findByParContador", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parContador = :parContador"),
    @NamedQuery(name = "SisEmpresaParametros.findByParContadorRuc", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parContadorRuc = :parContadorRuc"),
    @NamedQuery(name = "SisEmpresaParametros.findByParFinanciero", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parFinanciero = :parFinanciero"),
    @NamedQuery(name = "SisEmpresaParametros.findByParFinancieroId", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parFinancieroId = :parFinancieroId"),
    @NamedQuery(name = "SisEmpresaParametros.findByParActividad", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parActividad = :parActividad"),
    @NamedQuery(name = "SisEmpresaParametros.findByParEscogerPrecioPor", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parEscogerPrecioPor = :parEscogerPrecioPor"),
    @NamedQuery(name = "SisEmpresaParametros.findByParObligadoLlevarContabilidad", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parObligadoLlevarContabilidad = :parObligadoLlevarContabilidad"),
    @NamedQuery(name = "SisEmpresaParametros.findByParResolucionContribuyenteEspecial", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parResolucionContribuyenteEspecial = :parResolucionContribuyenteEspecial"),
    @NamedQuery(name = "SisEmpresaParametros.findByParColumnasEstadosFinancieros", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parColumnasEstadosFinancieros = :parColumnasEstadosFinancieros"),
    @NamedQuery(name = "SisEmpresaParametros.findByParCodigoDinardap", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parCodigoDinardap = :parCodigoDinardap"),
    @NamedQuery(name = "SisEmpresaParametros.findByParWebDocumentosElectronicos", query = "SELECT s FROM SisEmpresaParametros s WHERE s.parWebDocumentosElectronicos = :parWebDocumentosElectronicos")})
public class SisEmpresaParametros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "par_empresa")
    private String parEmpresa;
    @Column(name = "par_gerente")
    private String parGerente;
    @Column(name = "par_gerente_tipo_id")
    private Character parGerenteTipoId;
    @Column(name = "par_gerente_id")
    private String parGerenteId;
    @Column(name = "par_contador")
    private String parContador;
    @Column(name = "par_contador_ruc")
    private String parContadorRuc;
    @Column(name = "par_financiero")
    private String parFinanciero;
    @Column(name = "par_financiero_id")
    private String parFinancieroId;
    @Basic(optional = false)
    @Column(name = "par_actividad")
    private String parActividad;
    @Basic(optional = false)
    @Column(name = "par_escoger_precio_por")
    private String parEscogerPrecioPor;
    @Basic(optional = false)
    @Column(name = "par_obligado_llevar_contabilidad")
    private boolean parObligadoLlevarContabilidad;
    @Basic(optional = false)
    @Column(name = "par_resolucion_contribuyente_especial")
    private String parResolucionContribuyenteEspecial;
    @Basic(optional = false)
    @Column(name = "par_columnas_estados_financieros")
    private short parColumnasEstadosFinancieros;
    @Column(name = "par_codigo_dinardap")
    private String parCodigoDinardap;
    @Column(name = "par_web_documentos_electronicos")
    private String parWebDocumentosElectronicos;
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    @ManyToOne(optional = false)
    private SisEmpresa empCodigo;

    public SisEmpresaParametros() {
    }

    public SisEmpresaParametros(String parEmpresa) {
        this.parEmpresa = parEmpresa;
    }

    public SisEmpresaParametros(String parEmpresa, String parActividad, String parEscogerPrecioPor, boolean parObligadoLlevarContabilidad, String parResolucionContribuyenteEspecial, short parColumnasEstadosFinancieros) {
        this.parEmpresa = parEmpresa;
        this.parActividad = parActividad;
        this.parEscogerPrecioPor = parEscogerPrecioPor;
        this.parObligadoLlevarContabilidad = parObligadoLlevarContabilidad;
        this.parResolucionContribuyenteEspecial = parResolucionContribuyenteEspecial;
        this.parColumnasEstadosFinancieros = parColumnasEstadosFinancieros;
    }

    public String getParEmpresa() {
        return parEmpresa;
    }

    public void setParEmpresa(String parEmpresa) {
        this.parEmpresa = parEmpresa;
    }

    public String getParGerente() {
        return parGerente;
    }

    public void setParGerente(String parGerente) {
        this.parGerente = parGerente;
    }

    public Character getParGerenteTipoId() {
        return parGerenteTipoId;
    }

    public void setParGerenteTipoId(Character parGerenteTipoId) {
        this.parGerenteTipoId = parGerenteTipoId;
    }

    public String getParGerenteId() {
        return parGerenteId;
    }

    public void setParGerenteId(String parGerenteId) {
        this.parGerenteId = parGerenteId;
    }

    public String getParContador() {
        return parContador;
    }

    public void setParContador(String parContador) {
        this.parContador = parContador;
    }

    public String getParContadorRuc() {
        return parContadorRuc;
    }

    public void setParContadorRuc(String parContadorRuc) {
        this.parContadorRuc = parContadorRuc;
    }

    public String getParFinanciero() {
        return parFinanciero;
    }

    public void setParFinanciero(String parFinanciero) {
        this.parFinanciero = parFinanciero;
    }

    public String getParFinancieroId() {
        return parFinancieroId;
    }

    public void setParFinancieroId(String parFinancieroId) {
        this.parFinancieroId = parFinancieroId;
    }

    public String getParActividad() {
        return parActividad;
    }

    public void setParActividad(String parActividad) {
        this.parActividad = parActividad;
    }

    public String getParEscogerPrecioPor() {
        return parEscogerPrecioPor;
    }

    public void setParEscogerPrecioPor(String parEscogerPrecioPor) {
        this.parEscogerPrecioPor = parEscogerPrecioPor;
    }

    public boolean getParObligadoLlevarContabilidad() {
        return parObligadoLlevarContabilidad;
    }

    public void setParObligadoLlevarContabilidad(boolean parObligadoLlevarContabilidad) {
        this.parObligadoLlevarContabilidad = parObligadoLlevarContabilidad;
    }

    public String getParResolucionContribuyenteEspecial() {
        return parResolucionContribuyenteEspecial;
    }

    public void setParResolucionContribuyenteEspecial(String parResolucionContribuyenteEspecial) {
        this.parResolucionContribuyenteEspecial = parResolucionContribuyenteEspecial;
    }

    public short getParColumnasEstadosFinancieros() {
        return parColumnasEstadosFinancieros;
    }

    public void setParColumnasEstadosFinancieros(short parColumnasEstadosFinancieros) {
        this.parColumnasEstadosFinancieros = parColumnasEstadosFinancieros;
    }

    public String getParCodigoDinardap() {
        return parCodigoDinardap;
    }

    public void setParCodigoDinardap(String parCodigoDinardap) {
        this.parCodigoDinardap = parCodigoDinardap;
    }

    public String getParWebDocumentosElectronicos() {
        return parWebDocumentosElectronicos;
    }

    public void setParWebDocumentosElectronicos(String parWebDocumentosElectronicos) {
        this.parWebDocumentosElectronicos = parWebDocumentosElectronicos;
    }

    public SisEmpresa getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(SisEmpresa empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parEmpresa != null ? parEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisEmpresaParametros)) {
            return false;
        }
        SisEmpresaParametros other = (SisEmpresaParametros) object;
        if ((this.parEmpresa == null && other.parEmpresa != null) || (this.parEmpresa != null && !this.parEmpresa.equals(other.parEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisEmpresaParametros[ parEmpresa=" + parEmpresa + " ]";
    }
    
}
