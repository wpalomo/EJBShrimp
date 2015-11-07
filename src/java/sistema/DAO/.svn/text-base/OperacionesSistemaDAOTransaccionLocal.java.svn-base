/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.DAO;

import javax.ejb.Local;
import sistemaWeb.entity.*;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesSistemaDAOTransaccionLocal {

    ////// METODOS PARA USUARIOS
    boolean insertarSisUsuario(SisUsuario sisUsuario, SisUsuarioDetalle sisUsuarioDetalle, SisSuceso sisSuceso) throws Exception;

    boolean modificarSisUsuario(SisUsuario sisUsuario, SisUsuarioDetalle sisUsuarioDetalle, SisSuceso sisSuceso) throws Exception;
    
    boolean modificarSisUsuario(SisUsuario sisUsuario) throws Exception;

    boolean cambiarClaveSisUsuario(SisUsuario sisUsuario, SisSuceso sisSuceso) throws Exception;

    boolean eliminarSisUsuario(SisUsuario sisUsuario, SisUsuarioDetalle sisUsuarioDetalle, SisSuceso sisSuceso) throws Exception;

    /////// METODOS PARA PCS
    boolean updateSisReporteTO(SisPcs sisPcs, SisSuceso sisSuceso) throws Exception;

    /////// METODOS PARA PERIODOS
    boolean insertarSisPeriodo(SisPeriodo sisPeriodo, SisSuceso sisSuceso) throws Exception;

    boolean modificarSisPeriodo(SisPeriodo sisPeriodo, SisSuceso sisSuceso) throws Exception;

    /////// METODOS PARA EMPRESAS
    boolean insertarSisEmpresa(SisEmpresa sisEmpresa, SisSuceso sisSuceso, sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros) throws Exception;

    boolean modificarSisEmpresa(SisEmpresa sisEmpresa, SisSuceso sisSuceso, sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros) throws Exception;

    boolean eliminarSisEmpresa(SisEmpresa sisEmpresa, SisSuceso sisSuceso, sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros) throws Exception;

    /////// METODOS PARA GRUPOS
    boolean insertarSisGrupo(SisGrupo sisGrupo, SisSuceso sisSuceso) throws Exception;

    boolean modificarSisGrupo(SisGrupo sisGrupo, SisSuceso sisSuceso) throws Exception;

    boolean eliminarSisGrupo(SisGrupo sisGrupo, SisSuceso sisSuceso) throws Exception;

    ////// METODOS PARA PERMISOS
//    boolean modificarSisPermiso(SisPermiso sisPermiso, String usuario) throws Exception;
    boolean modificarSisPermiso(java.util.List<sistemaWeb.entity.SisPermiso> sisPermisos, sistemaWeb.entity.SisSuceso sisSuceso) throws java.lang.Exception;

    void insertarSisErrorTO(sistema.TO.SisErrorTO sisErrorTO, String codigoEmpresa) throws Exception;
}
