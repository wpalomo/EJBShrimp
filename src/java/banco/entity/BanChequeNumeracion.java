/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "banco.ban_cheques_numeracion", schema = "banco")
@NamedQueries({
    @NamedQuery(name = "BanBanco.findAll", query = "SELECT b FROM BanChequeNumeracion b"),
    @NamedQuery(name = "BanBanco.findByBanSecuencial", query = "SELECT b FROM BanChequeNumeracion b WHERE b.banSecuencial = :banSecuencial"),
    @NamedQuery(name = "BanBanco.findByBanDesde", query = "SELECT b FROM BanChequeNumeracion b WHERE b.banDesde = :banDesde"),
    @NamedQuery(name = "BanBanco.findByBanHasta", query = "SELECT b FROM BanChequeNumeracion b WHERE b.banHasta = :banHasta"),
    @NamedQuery(name = "BanBanco.findByBanCtaEmpresa", query = "SELECT b FROM BanChequeNumeracion b WHERE b.banCtaEmpresa = :banCtaEmpresa"),
    @NamedQuery(name = "BanBanco.findBybanCtaContable", query = "SELECT b FROM BanChequeNumeracion b WHERE b.banCtaContable = :banCtaContable"),})
public class BanChequeNumeracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chq_secuencial serial")
    private Integer banSecuencial;
    @Column(name = "chq_desde")
    private Integer banDesde;
    @Column(name = "chq_hasta")
    private Integer banHasta;
    @Column(name = "cta_empresa")
    private String banCtaEmpresa;
    @Column(name = "cta_cuenta_contable")
    private String banCtaContable;

    public BanChequeNumeracion() {
    }

    public BanChequeNumeracion(Integer banSecuencial) {
        this.banSecuencial = banSecuencial;
    }

    public BanChequeNumeracion(Integer banSecuencial, Integer banDesde, Integer banHasta, String banCtaEmpresa, String banCtaContable) {
        this.banSecuencial = banSecuencial;
        this.banDesde = banDesde;
        this.banHasta = banHasta;
        this.banCtaEmpresa = banCtaEmpresa;
        this.banCtaContable = banCtaContable;
    }

    public String getBanCtaContable() {
        return banCtaContable;
    }

    public void setBanCtaContable(String banCtaContable) {
        this.banCtaContable = banCtaContable;
    }

    public String getBanCtaEmpresa() {
        return banCtaEmpresa;
    }

    public void setBanCtaEmpresa(String banCtaEmpresa) {
        this.banCtaEmpresa = banCtaEmpresa;
    }

    public Integer getBanDesde() {
        return banDesde;
    }

    public void setBanDesde(Integer banDesde) {
        this.banDesde = banDesde;
    }

    public Integer getBanHasta() {
        return banHasta;
    }

    public void setBanHasta(Integer banHasta) {
        this.banHasta = banHasta;
    }

    public Integer getBanSecuencial() {
        return banSecuencial;
    }

    public void setBanSecuencial(Integer banSecuencial) {
        this.banSecuencial = banSecuencial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banSecuencial != null ? banSecuencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanChequeNumeracion)) {
            return false;
        }
        BanChequeNumeracion other = (BanChequeNumeracion) object;
        if ((this.banSecuencial == null && other.banSecuencial != null) || (this.banSecuencial != null && !this.banSecuencial.equals(other.banSecuencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.entity.BanChequeNumeracion[ banSecuencial=" + banSecuencial + " ]";
    }
}
