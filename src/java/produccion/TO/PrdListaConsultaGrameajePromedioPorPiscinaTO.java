package produccion.TO;

import java.io.Serializable;


public class PrdListaConsultaGrameajePromedioPorPiscinaTO implements Serializable{
    
    private String graFecha;
    private String graPiscina;
    private String corFechaSiembra;
    private String graEdad;
    private String graTPromedio;
    public PrdListaConsultaGrameajePromedioPorPiscinaTO() {
    }

    public PrdListaConsultaGrameajePromedioPorPiscinaTO(String graFecha, String graPiscina, String corFechaSiembra, String graEdad, String graTPromedio) {
        this.graFecha = graFecha;
        this.graPiscina = graPiscina;
        this.corFechaSiembra = corFechaSiembra;
        this.graEdad = graEdad;
        this.graTPromedio = graTPromedio;
    }

    public String getCorFechaSiembra() {
        return corFechaSiembra;
    }

    public void setCorFechaSiembra(String corFechaSiembra) {
        this.corFechaSiembra = corFechaSiembra;
    }

    public String getGraEdad() {
        return graEdad;
    }

    public void setGraEdad(String graEdad) {
        this.graEdad = graEdad;
    }

    public String getGraFecha() {
        return graFecha;
    }

    public void setGraFecha(String graFecha) {
        this.graFecha = graFecha;
    }

    public String getGraPiscina() {
        return graPiscina;
    }

    public void setGraPiscina(String graPiscina) {
        this.graPiscina = graPiscina;
    }

    public String getGraTPromedio() {
        return graTPromedio;
    }

    public void setGraTPromedio(String graTPromedio) {
        this.graTPromedio = graTPromedio;
    }
    
}
