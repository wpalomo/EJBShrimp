package anexos.TO;

import java.io.Serializable;

/**
 *
 * @author javier tj
 */
public class AnxTipoComprobanteTablaTO implements Serializable{
    private String anxTcCodigo;
    private String anxTcDescripcion;
    private String anxTcAbreviatura;

    public AnxTipoComprobanteTablaTO() {
    }

    public AnxTipoComprobanteTablaTO(String anxTcCodigo, String anxTcDescripcion, String anxTcAbreviatura) {
        this.anxTcCodigo = anxTcCodigo;
        this.anxTcDescripcion = anxTcDescripcion;
        this.anxTcAbreviatura = anxTcAbreviatura;
    }

    public String getAnxTcAbreviatura() {
        return anxTcAbreviatura;
    }

    public void setAnxTcAbreviatura(String anxTcAbreviatura) {
        this.anxTcAbreviatura = anxTcAbreviatura;
    }

    public String getAnxTcCodigo() {
        return anxTcCodigo;
    }

    public void setAnxTcCodigo(String anxTcCodigo) {
        this.anxTcCodigo = anxTcCodigo;
    }

    public String getAnxTcDescripcion() {
        return anxTcDescripcion;
    }

    public void setAnxTcDescripcion(String anxTcDescripcion) {
        this.anxTcDescripcion = anxTcDescripcion;
    }
    
    
}
