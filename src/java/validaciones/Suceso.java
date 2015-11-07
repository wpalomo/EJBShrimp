/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import sistemaWeb.entity.SisUsuarioDetalle;
import sistemaWeb.entity.SisUsuarioDetallePK;

/**
 *
 * @author developer2
 */
public class Suceso {
    public static sistemaWeb.entity.SisSuceso crearSisSuceso(
            String susTabla, 
            String susClave, 
            String susSuceso, 
            String susDetalle, 
            sistema.TO.SisInfoTO sisInfoTO) {
        sistemaWeb.entity.SisSuceso sisSuceso = new sistemaWeb.entity.SisSuceso();
        sisSuceso.setSusSecuencia(0);
        sisSuceso.setSusTabla(susTabla);
        sisSuceso.setSusTabla(sisSuceso.getSusTabla() == null ? null : (sisSuceso.getSusTabla().length() > 50 ? sisSuceso.getSusTabla().substring(0, 50) : sisSuceso.getSusTabla()));
        sisSuceso.setSusClave(susClave);
        sisSuceso.setSusClave(sisSuceso.getSusClave() == null ? null : (sisSuceso.getSusClave().length() > 50 ? sisSuceso.getSusClave().substring(0, 50) : sisSuceso.getSusClave()));
        sisSuceso.setSusSuceso(susSuceso);
        sisSuceso.setSusSuceso(sisSuceso.getSusSuceso() == null ? null : (sisSuceso.getSusSuceso().length() > 10 ? sisSuceso.getSusSuceso().substring(0, 10) : sisSuceso.getSusSuceso()));
        sisSuceso.setSusDetalle(susDetalle);
        sisSuceso.setSusDetalle(sisSuceso.getSusDetalle() == null ? null : (sisSuceso.getSusDetalle().length() > 300 ? sisSuceso.getSusDetalle().substring(0, 300) : sisSuceso.getSusDetalle()));
        sisSuceso.setSusMac(sisInfoTO.getInfMac());
        sisSuceso.setSisUsuarioDetalle(new SisUsuarioDetalle(new SisUsuarioDetallePK(sisInfoTO.getInfEmpresa(), sisInfoTO.getInfUsuario())));
        sisSuceso.setSusFecha(validaciones.Validacion.fechaString_Date(validaciones.Validacion.fechaSistema()));
        return sisSuceso;
    }
    
    
}
