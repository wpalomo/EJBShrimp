/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.facade;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sistema.TO.*;
import sistema.business.OperacionesSistemaBusinessLocal;
import sistemaWeb.entity.SisUsuario;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesSistemaFacade implements OperacionesSistemaFacadeRemote {

    @EJB
    OperacionesSistemaBusinessLocal operacionesSistemaBusinessLocal;

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA LOGIN">
    /**
     * @autor Jack Krauser y Misayo
     *
     * @param mac la mac del equipo
     * @return true si esta en la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean comprobarSisPcs(String mac) throws Exception {
        return operacionesSistemaBusinessLocal.comprobarSisPcs(mac);
    }

    /**
     * @autor Jack Krauser y Misayo
     *
     * @return lista de empresas donde esta registrado el usuario
     * @throws Exception CualquioperacionesSistemaBusinessLocaler error
     * inesperado
     */
    @Override
    public List<SisListaEmpresaTO> getListaLoginEmpresaTO(String usrCodigo) throws Exception {
        return operacionesSistemaBusinessLocal.getListaLoginEmpresaTO(usrCodigo);
    }

    /**
     * @autor Jack Krauser y Misayo
     *
     * @param empCodigo
     * @param nick
     * @param password
     * @return true si esta en la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public SisLoginTO getSisAccesoTO(
            String nick,
            String password) throws Exception {
        return operacionesSistemaBusinessLocal.getSisAccesoTO(
                nick,
                password);
    }

    @Override
    public SisLoginTO getPermisoInventarioTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.getPermisoInventarioTO(sisInfoTO);
    }

    /**
     * @autor Misayo
     *
     * @param empCodigo
     * @param usrCodigo
     * @param perModulo
     * @return lista de empresas donde esta registrado el usuario
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaLoginPermisoTO> getListaPermisoTO(
            String empCodigo,
            String usrCodigo,
            String perModulo) throws Exception {
        return operacionesSistemaBusinessLocal.getListaPermisoTO(
                empCodigo,
                usrCodigo,
                perModulo);
    }

    /**
     * @autor Jack Krauser Metodo que permite guardar la informacion de cuando
     * alguien se loguea al sistema
     *
     * @param usuario
     * @param empresa
     * @param suceso
     * @param mensaje
     * @param tabla
     * @throws Exception
     */
    @Override
    public void sisRegistrarEventosUsuario(
            String suceso,
            String mensaje,
            String tabla,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        operacionesSistemaBusinessLocal.sisRegistrarEventosUsuario(
                suceso,
                mensaje,
                tabla,
                sisInfoTO);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS DE USUARIO">
    @Override
    public String insertarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.insertarSisUsuarioTO(
                sisUsuarioTO,
                sisInfoTO);
    }

    @Override
    public String modificarPasswordSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            String pass) throws Exception {
        return operacionesSistemaBusinessLocal.modificarPasswordSisUsuarioTO(
                sisUsuarioTO,
                pass);
    }

    @Override
    public String modificarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            String pass,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.modificarSisUsuarioTO(
                sisUsuarioTO,
                pass,
                sisInfoTO);
    }

    @Override
    public boolean eliminarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.eliminarSisUsuarioTO(
                sisUsuarioTO,
                sisInfoTO);
    }

    @Override
    public String getUsuarioNombreApellido(
            String usrEmpresa,
            String usrCodigo) throws Exception {
        return operacionesSistemaBusinessLocal.getUsuarioNombreApellido(
                usrEmpresa,
                usrCodigo);
    }

    /**
     * @autor Misayo, Jack Krauser
     *
     * @param empresa Codigo de la empresa a filtrar Metodo para listar grupos
     * @return Lista con grupos de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisGrupoTO> getListaSisGrupo(String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getListaSisGrupo(empresa);
    }

    /**
     *
     * @autor Jack Krauser
     *
     * @param empresa Metodo que obtiene una lista de usuarios y a que grupo
     * pertenecen
     * @return Una lista con la lista de usuarios y a que grupo pertenecen
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisConsultaUsuarioGrupoTO> getListaUsuario(
            String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.getListaUsuario(parametro, sisInfoTO);
    }

    @Override
    public SisUsuario buscarUsuario(
            String empCodigo,
            String usrCodigo) throws Exception {
        return operacionesSistemaBusinessLocal.buscarUsuario(
                empCodigo,
                usrCodigo);
    }

    /**
     * @param empresa @autor Misayo Metodo para listar Usuarios para empresas
     * @return Lista con Usuarios para empresas de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaSusTablaTO> getListaSisSusTablaTOs(String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getListaSisSusTablaTOs(empresa);
    }

    @Override
    public List<SisListaUsuarioTO> getListaSisUsuario(String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getListaSisUsuarios(empresa);
    }

    // </editor-fold>
    /////METODOS PARA REPORTES
    @Override
    public SisReporteTO getSisReporteTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.getSisReporteTO(sisInfoTO);
    }

    @Override
    public String updateSisReporteTO(
            SisReporteTO sisReporteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.updateSisReporteTO(
                sisReporteTO,
                sisInfoTO);
    }

    // <editor-fold defaultstate="collapsed" desc="METODOS DE GRUPO">
    @Override
    public SisGrupoTO sisGrupoUsuariosTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.sisGrupoUsuariosTO(sisInfoTO);
    }

    @Override
    public boolean accionSisGrupoTO(
            SisGrupoTO sisGrupoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.accionSisGrupoTO(sisGrupoTO, accion, sisInfoTO);
    }

    @Override
    public List<SisGrupoTO> getSisGrupoTOs(String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getSisGrupoTOs(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS DE ERRORES">
    /**
     * @autor Misayo Metodo que permite ingresar errores en la BD
     *
     * @param sisErrorTO Objeto con el error a ingresar
     * @param empresa
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public void insertarSisErrorTO(
            SisErrorTO sisErrorTO,
            String empresa) throws Exception {
        operacionesSistemaBusinessLocal.insertarSisErrorTO(
                sisErrorTO,
                empresa);
    }

    @Override
    public List<SisErrorTO> getListaSisErrorTO(
            String desde,
            String hasta,
            String usuario,
            String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getListaSisErrorTO(
                desde,
                hasta,
                usuario,
                empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS DE PERIODO">
    @Override
    public String estadoPeriodo(String empresa, String fecha) throws Exception {
        return operacionesSistemaBusinessLocal.estadoPeriodo(empresa, fecha);
    }

    /**
     * @autor Jack Krauser Metodo que obtiene una lista de todos los periodos
     *
     * @return Una lista de periodos
     * @throws Exception cualquier error inesperado
     */
    @Override
    public List<SisListaPeriodoTO> getListaSisPeriodosTO(String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getListaPeriodoTO(empresa);
    }

    @Override
    public List<SisComboPeriodoTO> getSisComboPeriodosTO(String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getSisComboPeriodoTO(empresa);
    }

    @Override
    public boolean insertarSisPeriodoTO(
            SisPeriodoTO sisPeriodoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.insertarSisPeriodoTO(
                sisPeriodoTO,
                sisInfoTO);
    }

    @Override
    public boolean modificarSisPeriodoTO(
            SisPeriodoTO sisPeriodoTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.modificarSisPeriodoTO(
                sisPeriodoTO,
                sisInfoTO);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODO DE SUCESO">
    /**
     * @param desde
     * @param hasta
     * @param usuario
     * @param suceso
     * @param cadenaGeneral
     * @param empresa @autor Jack Krauser Metodo que obtiene una lista de todos
     * los periodos
     * @return Una lista de periodos
     * @throws Exception cualquier error inesperado
     */
    @Override
    public List<SisSucesoTO> getListaSisSucesoTO(
            String desde,
            String hasta,
            String usuario,
            String suceso,
            String cadenaGeneral,
            String empresa,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.getListaSisSucesoTO(
                desde,
                hasta,
                usuario,
                suceso,
                cadenaGeneral,
                sisInfoTO);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA EMPRESA">
    @Override
    public boolean insertarSisEmpresa(
            SisEmpresaTO sisEmpresaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.insertarSisEmpresa(
                sisEmpresaTO,
                sisInfoTO);
    }

    @Override
    public boolean modificarSisEmpresa(
            SisEmpresaTO sisEmpresaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.modificarSisEmpresa(
                sisEmpresaTO,
                sisInfoTO);
    }

    @Override
    public String guardarImagenEmpresa(byte[] imagen, String nombre) throws Exception {
        return operacionesSistemaBusinessLocal.guardarImagenEmpresa(imagen, nombre);
    }

    @Override
    public String eliminarImagenEmpresa(String nombre) throws Exception {
        return operacionesSistemaBusinessLocal.eliminarImagenEmpresa(nombre);
    }

    @Override
    public byte[] obtenerImagenEmpresa(String nombre) throws Exception {
        return operacionesSistemaBusinessLocal.obtenerImagenEmpresa(nombre);
    }

    /**
     * @autor Misayo Metodo para listar empresas
     *
     * @return Lista con empresas de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisEmpresaTO> getListaSisEmpresaTO(String usrCodigo, String empresa) throws Exception {
        return operacionesSistemaBusinessLocal.getListaSisEmpresaTO(usrCodigo, empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PERMISO">
    /**
     * @param usrCodigo
     * @param empCodigo @autor Misayo Metodo para listar Permisos para usuarios
     * @return Lista con permisos para usuarios de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisPermisoTO> getListaPermisoTO(String usrCodigo, String empCodigo) throws Exception {
        return operacionesSistemaBusinessLocal.getListaPermisoTO(usrCodigo, empCodigo);
    }

    /**
     * @param empCodigo @autor Misayo Metodo para listar Permisos para usuarios
     * @return Lista con permisos para usuarios de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Integer getColumnasEstadosFinancieros(String empCodigo) throws Exception {
        return operacionesSistemaBusinessLocal.getColumnasEstadosFinancieros(empCodigo);
    }

    /**
     * @autor Misayo Metodo para modificar Permisos para usuarios
     *
     * @param listaSisPermisoTO
     * @param usuario Codigo del usuario que esta haciendo el cambio
     * @param codModifUsuario Codigo del usuario a quien se le va a cambiar
     * @return true o false segun se ejecute la accion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean modificarSisPermiso(
            List<SisPermisoTO> listaSisPermisoTO,
            String usuario,
            String codModifUsuario,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.modificarSisPermiso(
                listaSisPermisoTO,
                usuario,
                codModifUsuario,
                sisInfoTO);
    }
    // </editor-fold>

    @Override
    public SisPckeystoreTO getSisPckeystoreTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaBusinessLocal.getSisPckeystoreTO(sisInfoTO);
    }
}