/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.helper;

/**
 *
 * @author jack
 */
public class CostoPiscinaSemanalNombres {
    private String codigo;
    private String producto;
    private String medida;

    public CostoPiscinaSemanalNombres() {
    }

    public CostoPiscinaSemanalNombres(String codigo, String producto, String medida) {
        this.codigo = codigo;
        this.producto = producto;
        this.medida = medida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
