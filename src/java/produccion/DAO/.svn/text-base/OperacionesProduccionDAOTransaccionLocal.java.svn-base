/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produccion.DAO;

import javax.ejb.Local;
import produccion.entity.PrdGrameaje;
import produccion.entity.PrdPiscina;
import produccion.entity.PrdSector;
import produccion.entity.PrdSobrevivencia;
import sistemaWeb.entity.SisSuceso;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesProduccionDAOTransaccionLocal {

    boolean insertarPrdSector(PrdSector prdSector, SisSuceso sisSuceso) throws Exception;
    boolean modificarPrdSector(PrdSector prdSector, SisSuceso sisSuceso) throws Exception;
    boolean eliminarPrdSector(PrdSector prdSector, SisSuceso sisSuceso) throws Exception;

    boolean insertarPrdPiscina(PrdPiscina prdPiscina, SisSuceso sisSuceso) throws Exception;
    boolean modificarPrdPiscina(PrdPiscina prdPiscina, SisSuceso sisSuceso) throws Exception;
    boolean eliminarPrdPiscina(PrdPiscina prdPiscina, SisSuceso sisSuceso) throws Exception;

    java.lang.Boolean accionPrdCorrida(produccion.entity.PrdCorrida prdCorrida, sistemaWeb.entity.SisSuceso sisSuceso, char accion) throws Exception;
    java.lang.Boolean accionPrdVehiculos(
            produccion.entity.PrdVehiculos prdVehiculos, 
            produccion.entity.PrdPiscina prdPiscina, 
            sistemaWeb.entity.SisSuceso sisSuceso, 
            char accion) throws Exception;

    boolean insertarPrdGrameaje(PrdGrameaje prdGrameaje, SisSuceso sisSuceso) throws Exception;
    boolean eliminarPrdGrameaje(PrdGrameaje prdGrameaje, SisSuceso sisSuceso) throws Exception;

    boolean insertarPrdSobrevivencia(PrdSobrevivencia prdSobrevivencia, SisSuceso sisSuceso) throws Exception;
    boolean modificarPrdSobrevivencia(PrdSobrevivencia prdSobrevivencia, SisSuceso sisSuceso) throws Exception;
    boolean eliminarPrdSobrevivencia(PrdSobrevivencia prdSobrevivencia, SisSuceso sisSuceso) throws Exception;

    boolean insertarPrdLiquidacionLotesValorizada(produccion.entity.PrdLiquidacion prdLiquidacion, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;

    java.lang.Boolean modificarCorrida(java.util.List<produccion.entity.PrdCorrida> prdCorrida) throws Exception;
    boolean modificarBooleanoCorrida(java.util.List<produccion.entity.PrdCorrida> prdCorridaBooleanoTrue) throws Exception;
    
    boolean insertarPrdLiquidacionMotivo(produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo, SisSuceso sisSuceso) throws Exception;
    boolean modificarPrdLiquidacionMotivo(produccion.entity.PrdLiquidacionMotivo prdLiquidacionMotivo, SisSuceso sisSuceso) throws Exception;
    
    boolean insertarPrdLiquidacionTalla(produccion.entity.PrdLiquidacionTalla prdLiquidacionTalla, SisSuceso sisSuceso) throws Exception;
    boolean modificarPrdLiquidacionTalla(produccion.entity.PrdLiquidacionTalla prdLiquidaciontalla, SisSuceso sisSuceso) throws Exception;
    
    boolean insertarPrdLiquidacionProducto(produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto, SisSuceso sisSuceso) throws Exception;
    boolean modificarPrdLiquidacionProducto(produccion.entity.PrdLiquidacionProducto prdLiquidacionProducto, SisSuceso sisSuceso) throws Exception;

    boolean insertarTransaccionPrdLiquidacion(produccion.entity.PrdLiquidacion prdLiquidacion,java.util.List<produccion.entity.PrdLiquidacionDetalle> listaPrdLiquidacionDetalles,sistemaWeb.entity.SisSuceso sisSuceso,produccion.entity.PrdLiquidacionNumeracion prdLiquidacionNumeracion) throws Exception;
    boolean modificarPrdLiquidacion (produccion.entity.PrdLiquidacion prdLiquidacion,java.util.List <produccion.entity.PrdLiquidacionDetalle> listaPrdDetalle,java.util.List <produccion.entity.PrdLiquidacionDetalle> listaPrdDetalleEliminar,sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;
    
}
