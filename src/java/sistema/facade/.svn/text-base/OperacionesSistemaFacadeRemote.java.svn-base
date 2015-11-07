/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.facade;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.ejb.Remote;
import sistema.TO.*;

/**
 *
 * @author misael
 */
@Remote
public interface OperacionesSistemaFacadeRemote {

    void insertarSisErrorTO(SisErrorTO sisErrorTO, String empresa) throws Exception;

    //////// METODOS PARA LOGUIN
    boolean comprobarSisPcs(String mac) throws Exception;

    List<SisListaEmpresaTO> getListaLoginEmpresaTO(String usrCodigo) throws Exception;

    SisLoginTO getSisAccesoTO(
            String nick,
            String password) throws Exception;

    SisLoginTO getPermisoInventarioTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<SisListaLoginPermisoTO> getListaPermisoTO(
            String empCodigo,
            String usrCodigo,
            String perModulo) throws Exception;

    void sisRegistrarEventosUsuario(
            String suceso,
            String mensaje,
            String tabla,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    /////METODOS PARA REPORTES
    SisReporteTO getSisReporteTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String updateSisReporteTO(
            SisReporteTO sisReporteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    /////METODOS PARA GRUPOS
    SisGrupoTO sisGrupoUsuariosTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean accionSisGrupoTO(
            SisGrupoTO sisGrupoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<SisGrupoTO> getSisGrupoTOs(String empresa) throws Exception;
    //////// METODOS PARA USUARIOS

    String insertarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;
    
     String modificarPasswordSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            String pass) throws Exception;

    String modificarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            String pass,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean eliminarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String getUsuarioNombreApellido(
            String usrEmpresa,
            String usrCodigo) throws Exception;

    List<SisGrupoTO> getListaSisGrupo(String empresa) throws Exception;

    List<SisConsultaUsuarioGrupoTO> getListaUsuario(
            String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    sistemaWeb.entity.SisUsuario buscarUsuario(
            String empCodigo,
            String usrCodigo) throws Exception;

    /////// METODOS PARA PERIODOS
    String estadoPeriodo(
            String empresa,
            String fecha) throws Exception;

    List<SisListaPeriodoTO> getListaSisPeriodosTO(String empresa) throws Exception;

    java.util.List<sistema.TO.SisComboPeriodoTO> getSisComboPeriodosTO(java.lang.String empresa) throws java.lang.Exception;

    boolean insertarSisPeriodoTO(
            SisPeriodoTO sisPeriodoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarSisPeriodoTO(
            SisPeriodoTO sisPeriodoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    /////// METODOS PARA ERRORES
    List<SisListaSusTablaTO> getListaSisSusTablaTOs(String empresa) throws Exception;

    List<SisListaUsuarioTO> getListaSisUsuario(String empresa) throws Exception;

    List<SisErrorTO> getListaSisErrorTO(
            String desde,
            String hasta,
            String usuario,
            String empresa) throws Exception;

    //////// METODOS PARA SUCESOS
    List<SisSucesoTO> getListaSisSucesoTO(
            String desde,
            String hasta,
            String usuario,
            String suceso,
            String cadenaGeneral,
            String empresa,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    ////// METODOS PARA EMPRESA
    boolean insertarSisEmpresa(
            SisEmpresaTO sisEmpresaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    boolean modificarSisEmpresa(
            SisEmpresaTO sisEmpresaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    String guardarImagenEmpresa(byte[] imagen, String nombre) throws Exception;

    String eliminarImagenEmpresa(String nombre) throws Exception;

    byte[] obtenerImagenEmpresa(String nombre) throws Exception;

    List<SisEmpresaTO> getListaSisEmpresaTO(
            String usrCodigo,
            String empresa) throws Exception;

    /////// METODOS PARA PERMISOS
    boolean modificarSisPermiso(
            List<SisPermisoTO> listaSisPermisoTO,
            String usuario,
            String codModifUsuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception;

    List<SisPermisoTO> getListaPermisoTO(
            String usrCodigo,
            String empCodigo) throws Exception;

    Integer getColumnasEstadosFinancieros(String empCodigo) throws Exception;

    SisPckeystoreTO getSisPckeystoreTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception;
}
