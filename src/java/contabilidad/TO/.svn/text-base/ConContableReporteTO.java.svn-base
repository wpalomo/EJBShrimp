/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.TO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jack
 */
public class ConContableReporteTO implements Serializable {

    private String titulo;
    private List<String> cuentaPadre;
    private ConContableTO conContableTO;
    private List<ConDetalleTablaTO> listConDetalleTablaTO;

    public ConContableReporteTO(String titulo, List<String> cuentaPadre, ConContableTO conContableTO, List<ConDetalleTablaTO> listConDetalleTablaTO) {
        this.titulo = titulo;
        this.cuentaPadre = cuentaPadre;
        this.conContableTO = conContableTO;
        this.listConDetalleTablaTO = listConDetalleTablaTO;
    }

    public ConContableTO getConContableTO() {
        return conContableTO;
    }

    public void setConContableTO(ConContableTO conContableTO) {
        this.conContableTO = conContableTO;
    }

    public List<String> getCuentaPadre() {
        return cuentaPadre;
    }

    public void setCuentaPadre(List<String> cuentaPadre) {
        this.cuentaPadre = cuentaPadre;
    }

    public List<ConDetalleTablaTO> getListConDetalleTablaTO() {
        return listConDetalleTablaTO;
    }

    public void setListConDetalleTablaTO(List<ConDetalleTablaTO> listConDetalleTablaTO) {
        this.listConDetalleTablaTO = listConDetalleTablaTO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
