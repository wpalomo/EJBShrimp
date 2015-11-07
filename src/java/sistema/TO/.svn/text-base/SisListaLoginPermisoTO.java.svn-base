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
public class SisListaLoginPermisoTO implements Serializable{
    private String perMenu;
    private String perItem;
    private String perItemEtiqueta;
    private Boolean perEstado;

    public SisListaLoginPermisoTO() {
    }

    public SisListaLoginPermisoTO(String perMenu, String perItem, String perItemEtiqueta, Boolean perEstado) {
        this.perMenu = perMenu;
        this.perItem = perItem;
        this.perItemEtiqueta = perItemEtiqueta;
        this.perEstado = perEstado;
    }

    public Boolean getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(Boolean perEstado) {
        this.perEstado = perEstado;
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

    @Override
    public String toString(){
        return this.perMenu+" "+
                this.perItem +" "+
                this.perItemEtiqueta+" "+
                this.perEstado;
    }

}
