/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fconza
 */
@Entity
@Table(name = "anx_cuentascontables",  schema = "anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnxCuentascontables.findAll", query = "SELECT a FROM AnxCuentascontables a"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaSecuencial", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaSecuencial = :ctaSecuencial"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaEmpresa", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaEmpresa = :ctaEmpresa"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaIvaPagado", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaIvaPagado = :ctaIvaPagado"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaIvaCobrado", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaIvaCobrado = :ctaIvaCobrado"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaRetFteIvaPagado", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaRetFteIvaPagado = :ctaRetFteIvaPagado"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaRetFteIvaCobrado", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaRetFteIvaCobrado = :ctaRetFteIvaCobrado"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaRetFteIvaAsumido", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaRetFteIvaAsumido = :ctaRetFteIvaAsumido"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaRetFteIrPagado", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaRetFteIrPagado = :ctaRetFteIrPagado"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaRetFteIrCobrado", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaRetFteIrCobrado = :ctaRetFteIrCobrado"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaRetFteIrAsumido", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaRetFteIrAsumido = :ctaRetFteIrAsumido"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaOtrosImpuestos", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaOtrosImpuestos = :ctaOtrosImpuestos"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaCuentasPorCobrar", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaCuentasPorCobrar = :ctaCuentasPorCobrar"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaCuentasPorPagar", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaCuentasPorPagar = :ctaCuentasPorPagar"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaCuentasPorPagarActivoFijo", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaCuentasPorPagarActivoFijo = :ctaCuentasPorPagarActivoFijo"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaAnticiposDeClientes", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaAnticiposDeClientes = :ctaAnticiposDeClientes"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaAnticiposAProveedores", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaAnticiposAProveedores = :ctaAnticiposAProveedores"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaBienesBase0", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaBienesBase0 = :ctaVentaBienesBase0"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaBienesBaseImponible", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaBienesBaseImponible = :ctaVentaBienesBaseImponible"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaBienesBaseNoObjeto", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaBienesBaseNoObjeto = :ctaVentaBienesBaseNoObjeto"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaBienesBaseExenta", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaBienesBaseExenta = :ctaVentaBienesBaseExenta"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaServiciosBase0", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaServiciosBase0 = :ctaVentaServiciosBase0"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaServiciosBaseImponible", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaServiciosBaseImponible = :ctaVentaServiciosBaseImponible"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaServiciosBaseNoObjeto", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaServiciosBaseNoObjeto = :ctaVentaServiciosBaseNoObjeto"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaVentaServiciosBaseExenta", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaVentaServiciosBaseExenta = :ctaVentaServiciosBaseExenta"),
    @NamedQuery(name = "AnxCuentascontables.findByCtaDiferencias", query = "SELECT a FROM AnxCuentascontables a WHERE a.ctaDiferencias = :ctaDiferencias")})
public class AnxCuentascontables implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cta_secuencial")
    private Integer ctaSecuencial;
    @Basic(optional = false)
    @Column(name = "cta_empresa")
    private String ctaEmpresa;
    @Column(name = "cta_iva_pagado")
    private String ctaIvaPagado;
    @Column(name = "cta_iva_cobrado")
    private String ctaIvaCobrado;
    @Column(name = "cta_ret_fte_iva_pagado")
    private String ctaRetFteIvaPagado;
    @Column(name = "cta_ret_fte_iva_cobrado")
    private String ctaRetFteIvaCobrado;
    @Column(name = "cta_ret_fte_iva_asumido")
    private String ctaRetFteIvaAsumido;
    @Column(name = "cta_ret_fte_ir_pagado")
    private String ctaRetFteIrPagado;
    @Column(name = "cta_ret_fte_ir_cobrado")
    private String ctaRetFteIrCobrado;
    @Column(name = "cta_ret_fte_ir_asumido")
    private String ctaRetFteIrAsumido;
    @Column(name = "cta_otros_impuestos")
    private String ctaOtrosImpuestos;
    @Column(name = "cta_cuentas_por_cobrar")
    private String ctaCuentasPorCobrar;
    @Column(name = "cta_cuentas_por_pagar")
    private String ctaCuentasPorPagar;
    @Column(name = "cta_cuentas_por_pagar_activo_fijo")
    private String ctaCuentasPorPagarActivoFijo;
    @Column(name = "cta_anticipos_de_clientes")
    private String ctaAnticiposDeClientes;
    @Column(name = "cta_anticipos_a_proveedores")
    private String ctaAnticiposAProveedores;
    @Column(name = "cta_venta_bienes_base0")
    private String ctaVentaBienesBase0;
    @Column(name = "cta_venta_bienes_base_imponible")
    private String ctaVentaBienesBaseImponible;
    @Column(name = "cta_venta_bienes_base_no_objeto")
    private String ctaVentaBienesBaseNoObjeto;
    @Column(name = "cta_venta_bienes_base_exenta")
    private String ctaVentaBienesBaseExenta;
    @Column(name = "cta_venta_servicios_base0")
    private String ctaVentaServiciosBase0;
    @Column(name = "cta_venta_servicios_base_imponible")
    private String ctaVentaServiciosBaseImponible;
    @Column(name = "cta_venta_servicios_base_no_objeto")
    private String ctaVentaServiciosBaseNoObjeto;
    @Column(name = "cta_venta_servicios_base_exenta")
    private String ctaVentaServiciosBaseExenta;
    @Column(name = "cta_diferencias")
    private String ctaDiferencias;

    public AnxCuentascontables() {
    }

    public AnxCuentascontables(Integer ctaSecuencial) {
        this.ctaSecuencial = ctaSecuencial;
    }

    public AnxCuentascontables(Integer ctaSecuencial, String ctaEmpresa) {
        this.ctaSecuencial = ctaSecuencial;
        this.ctaEmpresa = ctaEmpresa;
    }

    public Integer getCtaSecuencial() {
        return ctaSecuencial;
    }

    public void setCtaSecuencial(Integer ctaSecuencial) {
        this.ctaSecuencial = ctaSecuencial;
    }

    public String getCtaEmpresa() {
        return ctaEmpresa;
    }

    public void setCtaEmpresa(String ctaEmpresa) {
        this.ctaEmpresa = ctaEmpresa;
    }

    public String getCtaIvaPagado() {
        return ctaIvaPagado;
    }

    public void setCtaIvaPagado(String ctaIvaPagado) {
        this.ctaIvaPagado = ctaIvaPagado;
    }

    public String getCtaIvaCobrado() {
        return ctaIvaCobrado;
    }

    public void setCtaIvaCobrado(String ctaIvaCobrado) {
        this.ctaIvaCobrado = ctaIvaCobrado;
    }

    public String getCtaRetFteIvaPagado() {
        return ctaRetFteIvaPagado;
    }

    public void setCtaRetFteIvaPagado(String ctaRetFteIvaPagado) {
        this.ctaRetFteIvaPagado = ctaRetFteIvaPagado;
    }

    public String getCtaRetFteIvaCobrado() {
        return ctaRetFteIvaCobrado;
    }

    public void setCtaRetFteIvaCobrado(String ctaRetFteIvaCobrado) {
        this.ctaRetFteIvaCobrado = ctaRetFteIvaCobrado;
    }

    public String getCtaRetFteIvaAsumido() {
        return ctaRetFteIvaAsumido;
    }

    public void setCtaRetFteIvaAsumido(String ctaRetFteIvaAsumido) {
        this.ctaRetFteIvaAsumido = ctaRetFteIvaAsumido;
    }

    public String getCtaRetFteIrPagado() {
        return ctaRetFteIrPagado;
    }

    public void setCtaRetFteIrPagado(String ctaRetFteIrPagado) {
        this.ctaRetFteIrPagado = ctaRetFteIrPagado;
    }

    public String getCtaRetFteIrCobrado() {
        return ctaRetFteIrCobrado;
    }

    public void setCtaRetFteIrCobrado(String ctaRetFteIrCobrado) {
        this.ctaRetFteIrCobrado = ctaRetFteIrCobrado;
    }

    public String getCtaRetFteIrAsumido() {
        return ctaRetFteIrAsumido;
    }

    public void setCtaRetFteIrAsumido(String ctaRetFteIrAsumido) {
        this.ctaRetFteIrAsumido = ctaRetFteIrAsumido;
    }

    public String getCtaOtrosImpuestos() {
        return ctaOtrosImpuestos;
    }

    public void setCtaOtrosImpuestos(String ctaOtrosImpuestos) {
        this.ctaOtrosImpuestos = ctaOtrosImpuestos;
    }

    public String getCtaCuentasPorCobrar() {
        return ctaCuentasPorCobrar;
    }

    public void setCtaCuentasPorCobrar(String ctaCuentasPorCobrar) {
        this.ctaCuentasPorCobrar = ctaCuentasPorCobrar;
    }

    public String getCtaCuentasPorPagar() {
        return ctaCuentasPorPagar;
    }

    public void setCtaCuentasPorPagar(String ctaCuentasPorPagar) {
        this.ctaCuentasPorPagar = ctaCuentasPorPagar;
    }

    public String getCtaCuentasPorPagarActivoFijo() {
        return ctaCuentasPorPagarActivoFijo;
    }

    public void setCtaCuentasPorPagarActivoFijo(String ctaCuentasPorPagarActivoFijo) {
        this.ctaCuentasPorPagarActivoFijo = ctaCuentasPorPagarActivoFijo;
    }

    public String getCtaAnticiposDeClientes() {
        return ctaAnticiposDeClientes;
    }

    public void setCtaAnticiposDeClientes(String ctaAnticiposDeClientes) {
        this.ctaAnticiposDeClientes = ctaAnticiposDeClientes;
    }

    public String getCtaAnticiposAProveedores() {
        return ctaAnticiposAProveedores;
    }

    public void setCtaAnticiposAProveedores(String ctaAnticiposAProveedores) {
        this.ctaAnticiposAProveedores = ctaAnticiposAProveedores;
    }

    public String getCtaVentaBienesBase0() {
        return ctaVentaBienesBase0;
    }

    public void setCtaVentaBienesBase0(String ctaVentaBienesBase0) {
        this.ctaVentaBienesBase0 = ctaVentaBienesBase0;
    }

    public String getCtaVentaBienesBaseImponible() {
        return ctaVentaBienesBaseImponible;
    }

    public void setCtaVentaBienesBaseImponible(String ctaVentaBienesBaseImponible) {
        this.ctaVentaBienesBaseImponible = ctaVentaBienesBaseImponible;
    }

    public String getCtaVentaBienesBaseNoObjeto() {
        return ctaVentaBienesBaseNoObjeto;
    }

    public void setCtaVentaBienesBaseNoObjeto(String ctaVentaBienesBaseNoObjeto) {
        this.ctaVentaBienesBaseNoObjeto = ctaVentaBienesBaseNoObjeto;
    }

    public String getCtaVentaBienesBaseExenta() {
        return ctaVentaBienesBaseExenta;
    }

    public void setCtaVentaBienesBaseExenta(String ctaVentaBienesBaseExenta) {
        this.ctaVentaBienesBaseExenta = ctaVentaBienesBaseExenta;
    }

    public String getCtaVentaServiciosBase0() {
        return ctaVentaServiciosBase0;
    }

    public void setCtaVentaServiciosBase0(String ctaVentaServiciosBase0) {
        this.ctaVentaServiciosBase0 = ctaVentaServiciosBase0;
    }

    public String getCtaVentaServiciosBaseImponible() {
        return ctaVentaServiciosBaseImponible;
    }

    public void setCtaVentaServiciosBaseImponible(String ctaVentaServiciosBaseImponible) {
        this.ctaVentaServiciosBaseImponible = ctaVentaServiciosBaseImponible;
    }

    public String getCtaVentaServiciosBaseNoObjeto() {
        return ctaVentaServiciosBaseNoObjeto;
    }

    public void setCtaVentaServiciosBaseNoObjeto(String ctaVentaServiciosBaseNoObjeto) {
        this.ctaVentaServiciosBaseNoObjeto = ctaVentaServiciosBaseNoObjeto;
    }

    public String getCtaVentaServiciosBaseExenta() {
        return ctaVentaServiciosBaseExenta;
    }

    public void setCtaVentaServiciosBaseExenta(String ctaVentaServiciosBaseExenta) {
        this.ctaVentaServiciosBaseExenta = ctaVentaServiciosBaseExenta;
    }

    public String getCtaDiferencias() {
        return ctaDiferencias;
    }

    public void setCtaDiferencias(String ctaDiferencias) {
        this.ctaDiferencias = ctaDiferencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctaSecuencial != null ? ctaSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnxCuentascontables)) {
            return false;
        }
        AnxCuentascontables other = (AnxCuentascontables) object;
        if ((this.ctaSecuencial == null && other.ctaSecuencial != null) || (this.ctaSecuencial != null && !this.ctaSecuencial.equals(other.ctaSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "anexos.entity.AnxCuentascontables[ ctaSecuencial=" + ctaSecuencial + " ]";
    }
    
}
