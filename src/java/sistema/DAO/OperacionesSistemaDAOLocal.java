/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.DAO;

import java.util.List;
import javax.ejb.Local;
import sistema.TO.*;
import sistemaWeb.entity.SisPcs;

/**
 *
 * @author misael
 */
@Local
public interface OperacionesSistemaDAOLocal {
    //////// METODOS PARA EL LOGUEO

    boolean comprobarSisPcs(String mac) throws Exception;

    List<SisListaEmpresaTO> getListaLoginEmpresaTO(String usrCodigo) throws Exception;

    SisLoginTO getSisAcceso(
            String nick,
            String password,
            String empresa) throws Exception;

    SisLoginTO getPermisoInventarioTO(
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<SisListaLoginPermisoTO> getListaPermisoTO(
            String empCodigo,
            String usrCodigo,
            String perModulo) throws Exception;

    void sisRegistrarSucesosUsuario(
            sistemaWeb.entity.SisSuceso sisSuceso) throws Exception;

    ////// METODOS PARA USUARIOS
    String getUsuarioNombreApellido(
            String usrEmpresa,
            String usrCodigo) throws Exception;

    sistemaWeb.entity.SisUsuario buscarUsuario(
            String usrCodigo) throws Exception;

    boolean getUsuarioRepetido(
            String codigo,
            String nick,
            String nombre,
            String apellido) throws Exception;

    int retornoContadoEliminarUsuario(String codUsuario) throws Exception;

    List<SisGrupoTO> getListaSisGrupo(String empresa) throws Exception;

    List<SisGrupoTO> getSisGrupoTOs(String empresa) throws Exception;

    List<SisConsultaUsuarioGrupoTO> getListaUsuario(
            String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    /////////////METODOS DE PERIODO
    sistemaWeb.entity.SisPeriodo buscarPeriodo(String empCodigo, String perCodigo) throws Exception;

    List<SisListaPeriodoTO> getListaSisPeriodo(String empresa) throws Exception;

    java.util.List<sistema.TO.SisComboPeriodoTO> getSisComboPeriodo(java.lang.String empresa) throws java.lang.Exception;

    //////////// METODOS PARA ERRORES
    List<SisListaUsuarioTO> getListaSisUsuario(String empresa) throws Exception;

    List<SisListaSusTablaTO> getListaSisSusTablaTOs(String empresa) throws Exception;

    List<SisErrorTO> getListaSisError(String desde, String hasta, String usuario, String empresa) throws Exception;

    ////////// METODOS PARA SUCESOS
    List<SisSucesoTO> getListaSisSuceso(String desde, String hasta, String usuario, String suceso, String cadenaGenera, String empresa) throws Exception;

    ///////// METODOS PARA PERMISOS
    List<SisPermisoTO> getListaPermisoTO(String usrCodigo, String empCodigo) throws Exception;

    //////// METODOS PARA EMPRESA
    List<SisEmpresaTO> getListaSisEmpresa(String usrCodigo, String empresa) throws Exception;

    sistemaWeb.entity.SisEmpresa buscarEmpresa(String empCodigo) throws Exception;

    /////METODOS PARA REPORTES
    SisPcs findSisPcs(sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    SisReporteTO getSisReporteTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    //////// METODOS PARA GRUPO
    SisGrupoTO sisGrupoUsuariosTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    sistemaWeb.entity.SisGrupo buscarGrupo(String empCodigo, String codGrupo) throws Exception;

    int retornoContadoEliminarGrupo(String codEmpresa, String codGrupo) throws Exception;

    sistemaWeb.entity.SisEmpresaParametros buscarEmpresaParametros(String empCodigo) throws Exception;

    Integer getColumnasEstadosFinancieros(String empCodigo) throws Exception;

    SisPckeystoreTO getSisPckeystoreTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception;
}
