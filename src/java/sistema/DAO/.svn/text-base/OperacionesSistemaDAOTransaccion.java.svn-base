/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.DAO;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import sistema.TO.SisErrorTO;
import sistemaWeb.entity.SisGrupo;
import sistemaWeb.entity.SisPeriodo;
import sistemaWeb.entity.SisSuceso;
import sistemaWeb.entity.SisEmpresa;
import sistemaWeb.entity.SisUsuario;
import sistema.excepciones.NoCreationCompanyException;
import sistemaWeb.entity.*;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesSistemaDAOTransaccion implements OperacionesSistemaDAOTransaccionLocal {

    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    sistemaWeb.entity.DAO.SisErrorFacadeLocal sisErrorFacadeLocal;
    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "EJBShrimpPU")
    private EntityManager em;
    boolean comprobar = false;

    // <editor-fold defaultstate="collapsed" desc="USUARIO">
    /**
     * @autor Misayo y Jack Krauser Metodo que permite insertar un usuario pero
     * con un arreglo de que comprueba primero si existe el usuario antes de
     * insertarlo
     *
     * @param sisUsuario Objeto con el contenido del usuario
     * @param sisSuceso Suceso a guardar
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarSisUsuario(SisUsuario sisUsuario, SisUsuarioDetalle sisUsuarioDetalle, SisSuceso sisSuceso) throws Exception {
        em.persist(sisUsuario);
        em.persist(sisUsuarioDetalle);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean modificarSisUsuario(SisUsuario sisUsuario) throws Exception {
        em.merge(sisUsuario);
        em.flush();
        return true;
    }

    /**
     * @autor Jack Krauser Metodo que permite modificar un Usuario
     *
     * @param sisUsuario Objeto con el contenido de Usuario
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean modificarSisUsuario(SisUsuario sisUsuario, SisUsuarioDetalle sisUsuarioDetalle, SisSuceso sisSuceso) throws Exception {
        em.merge(sisUsuario);
        em.merge(sisUsuarioDetalle);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean cambiarClaveSisUsuario(SisUsuario sisUsuario, SisSuceso sisSuceso) throws Exception {
        em.merge(sisUsuario);
        em.flush();
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor Jack Krauser Metodo para eliminar un usuario
     *
     * @param sisUsuario Objeto con el usuario a eliminar
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarSisUsuario(SisUsuario sisUsuario, SisUsuarioDetalle sisUsuarioDetalle, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(sisUsuario));
        em.remove(em.merge(sisUsuarioDetalle));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PCS">
    @javax.ejb.TransactionAttribute(javax.ejb.TransactionAttributeType.REQUIRED)
    public boolean updateSisReporteTO(SisPcs sisPcs, SisSuceso sisSuceso) throws Exception {
        em.merge(sisPcs);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PERIODO">
    /**
     * @autor Jack Krauser Metodo para ingresar periodo
     *
     * @param sisPeriodo
     * @param sisSuceso Objeto entidad
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarSisPeriodo(SisPeriodo sisPeriodo, SisSuceso sisSuceso) throws Exception {
        em.persist(sisPeriodo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor Jack Krauser Metodo para modificar periodos
     *
     * @param sisPeriodo
     * @param sisSuceso
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarSisPeriodo(SisPeriodo sisPeriodo, SisSuceso sisSuceso) throws Exception {
        em.merge(sisPeriodo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="EMPRESA">
    /**
     * @autor Misayo Metodo para ingresar empresa
     *
     * @param sisEmpresa Objeto TO
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean insertarSisEmpresa(SisEmpresa sisEmpresa, SisSuceso sisSuceso, sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros) throws Exception {
        em.persist(sisEmpresa);
        em.persist(sisEmpresaParametros);
        em.persist(sisSuceso);
        boolean creo = Boolean.parseBoolean(((List) em.createNativeQuery(
                "select * from sistema.fun_registros_complementarios('"
                + sisEmpresa.getEmpCodigo().trim() + "')").getResultList().
                get(0)).get(0).toString());
        if (!creo) {
            throw new NoCreationCompanyException("Empresa no fue creada");
        }
        em.flush();
        return true;
    }

    /**
     * @autor Misayo Metodo para modificar empresa
     *
     * @param sisEmpresa Objeto TO
     * @param sisSuceso
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean modificarSisEmpresa(SisEmpresa sisEmpresa, SisSuceso sisSuceso, sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros) throws Exception {
        em.persist(sisSuceso);
        em.merge(sisEmpresa);
        em.merge(sisEmpresaParametros);
        em.flush();
        return true;
    }

    /**
     * @autor Misayo Metodo para eliminar empresa
     *
     * @param sisEmpresaTO Objeto TO
     * @param sisSuceso
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean eliminarSisEmpresa(SisEmpresa sisEmpresa, SisSuceso sisSuceso, sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros) throws Exception {
        em.remove(em.merge(sisEmpresaParametros));
        em.remove(em.merge(sisEmpresa));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GRUPO">
    /**
     * @autor Jack Krauser Metodo para ingresar empresa
     *
     * @param sisGrupo
     * @param sisSuceso
     * @return
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean insertarSisGrupo(SisGrupo sisGrupo, SisSuceso sisSuceso) throws Exception {
        em.persist(sisGrupo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor Misayo Metodo para modificar empresa
     *
     * @param sisGrupo
     * @param sisSuceso
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean modificarSisGrupo(SisGrupo sisGrupo, SisSuceso sisSuceso) throws Exception {
        em.merge(sisGrupo);
        em.persist(sisSuceso);
        em.flush();
        return true;
    }

    /**
     * @autor Misayo Metodo para eliminar empresa
     *
     * @param sisGrupo
     * @param sisEmpresaTO Objeto TO
     * @param sisSuceso
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean eliminarSisGrupo(SisGrupo sisGrupo, SisSuceso sisSuceso) throws Exception {
        em.remove(em.merge(sisGrupo));
        em.persist(sisSuceso);
        em.flush();
        return true;
    }
//    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODO PARA PERMISOS">
    /**
     * @autor Misayo Metodo para modificar Permisos para usuarios
     *
     * @param sisPermiso Entidad de la tabla Permiso
     * @param usuario Codigo del usuario
     * @return true o false segun se ejecute la accion
     * @throws Exception Cualquier error inesperado
     */
//    public boolean modificarSisPermiso(SisPermiso sisPermiso, String usuario) throws Exception {
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean modificarSisPermiso(List<sistemaWeb.entity.SisPermiso> sisPermisos, sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        for (sistemaWeb.entity.SisPermiso sisPermiso : sisPermisos) {
            em.merge(sisPermiso);
        }
        em.persist(sisSuceso);
        em.flush();

        comprobar = true;
        return comprobar;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ALMACENAR ERRORES Y SUCESOS">
    /**
     * @autor Misayo Metodo que permite ingresar errores en la BD
     *
     * @param sisErrorTO Objeto con el error a ingresar
     * @param empresa
     * @throws Exception Cualquier error inesperado
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void insertarSisErrorTO(SisErrorTO sisErrorTO, String codigoEmpresa) throws Exception {
        sistemaWeb.entity.SisError sisError = sistema.helper.ConversionesSistema.ConvertirSisErrorTO_SisError(sisErrorTO);
        sisErrorFacadeLocal.create(sisError);
//            em.remove(em.merge(sisGrupo));
//            em.persist(sisSuceso);
//            em.flush();
//        return true;
    }// </editor-fold>
}