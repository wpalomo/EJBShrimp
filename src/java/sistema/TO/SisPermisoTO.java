/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class SisPermisoTO implements Serializable{

    private String perEmpresa;
    private String perModulo;
    private String perMenu;
    private String perItem;
    private String perItemEtiqueta;
    private Integer perSecuencia;
    private String perUsuarios;
    private Boolean perActivo;
    private String empCodigo;

    public SisPermisoTO() {
    }

    public SisPermisoTO(String perEmpresa, String perModulo, String perMenu, String perItem, String perItemEtiqueta, Integer perSecuencia, String perUsuarios, Boolean perActivo, String empCodigo) {
        this.perEmpresa = perEmpresa;
        this.perModulo = perModulo;
        this.perMenu = perMenu;
        this.perItem = perItem;
        this.perItemEtiqueta = perItemEtiqueta;
        this.perSecuencia = perSecuencia;
        this.perUsuarios = perUsuarios;
        this.perActivo = perActivo;
        this.empCodigo = empCodigo;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public Boolean getPerActivo() {
        return perActivo;
    }

    public void setPerActivo(Boolean perActivo) {
        this.perActivo = perActivo;
    }

    public String getPerEmpresa() {
        return perEmpresa;
    }

    public void setPerEmpresa(String perEmpresa) {
        this.perEmpresa = perEmpresa;
    }

    public String getPerItem() {
        return perItem;
    }

    public void setPerItem(String perItem) {
        this.perItem = perItem;
    }

    public String getPerItemEtiqueta() {
        return perItemEtiqueta;
    }

    public void setPerItemEtiqueta(String perItemEtiqueta) {
        this.perItemEtiqueta = perItemEtiqueta;
    }

    public String getPerMenu() {
        return perMenu;
    }

    public void setPerMenu(String perMenu) {
        this.perMenu = perMenu;
    }

    public String getPerModulo() {
        return perModulo;
    }

    public void setPerModulo(String perModulo) {
        this.perModulo = perModulo;
    }

    public Integer getPerSecuencia() {
        return perSecuencia;
    }

    public void setPerSecuencia(Integer perSecuencia) {
        this.perSecuencia = perSecuencia;
    }

    public String getPerUsuarios() {
        return perUsuarios;
    }

    public void setPerUsuarios(String perUsuarios) {
        this.perUsuarios = perUsuarios;
    }
}
