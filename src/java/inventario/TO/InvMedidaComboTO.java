/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvMedidaComboTO implements java.io.Serializable{
    private String medidaCodigo;
    private String medidaDetalle;
    private String conversionLibras;

    public InvMedidaComboTO() {
    }

    public InvMedidaComboTO(String medidaCodigo, String medidaDetalle, String conversionLibras) {
        this.medidaCodigo = medidaCodigo;
        this.medidaDetalle = medidaDetalle;
        this.conversionLibras = conversionLibras;
    }

    public String getConversionLibras() {
        return conversionLibras;
    }

    public void setConversionLibras(String conversionLibras) {
        this.conversionLibras = conversionLibras;
    }

    public String getMedidaCodigo() {
        return medidaCodigo;
    }

    public void setMedidaCodigo(String medidaCodigo) {
        this.medidaCodigo = medidaCodigo;
    }

    public String getMedidaDetalle() {
        return medidaDetalle;
    }

    public void setMedidaDetalle(String medidaDetalle) {
        this.medidaDetalle = medidaDetalle;
    }

    @Override
    public String toString(){
        return this.medidaDetalle;
    }
}
