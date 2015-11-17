/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.DAO;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistema.TO.*;
import sistema.helper.ConversionesSistema;
import sistemaWeb.entity.DAO.*;
import sistemaWeb.entity.*;
import validaciones.Desencriptar;

/**
 *
 * @author Jack Krauser, misael
 */
@Stateless
public class OperacionesSistemaDAO implements OperacionesSistemaDAOLocal {

    @PersistenceContext(unitName = "EJBShrimpPU")
    EntityManager em;
    // <editor-fold defaultstate="collapsed" desc="Declaraciones de EJB">
    @EJB
    SisUsuarioFacadeLocal sisUsuarioFacadeLocal;
    @EJB
    SisGrupoFacadeLocal sisGrupoFacadeLocal;
    @EJB
    SisPeriodoFacadeLocal sisPeriodoFacadeLocal;
    @EJB
    SisErrorFacadeLocal sisErrorFacadeLocal;
    @EJB
    SisSucesoFacadeLocal sisSucesoFacadeLocal;
    @EJB
    SisEmpresaFacadeLocal sisEmpresaFacadeLocal;
    @EJB
    SisPcsFacadeLocal sisPcsFacadeLocal;
    @EJB
    SisEmpresaParametrosFacadeLocal sisEmpresaParametrosFacadeLocal;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA LOGUEO">
    /**
     * @autor Jack Krauser y Misayo Metodo que permite comprobar la pc en la
     * BB.DD.
     *
     * @param mac la mac del equipo
     * @return true si esta en la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean comprobarSisPcs(String mac) throws Exception {
        int conteo = 0;
//        conteo = Integer.parseInt(((List) em.createNativeQuery("SELECT count(inf_mac) "
//                + "FROM sistemaweb.sis_pcs WHERE inf_mac = ('" + mac + "') "
//                + "and inf_estado = TRUE").getResultList().get(0)).get(0).toString());
//        conteo = Integer.parseInt(validaciones.ConvertirListaObject.convertir(em.createNativeQuery("SELECT count(inf_mac) "
//                + "FROM sistemaweb.sis_pcs WHERE inf_mac = ('" + mac + "') "
//                + "and inf_estado = TRUE").getResultList().toArray())[0].toString());
        conteo = Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT count(inf_mac) "
                + "FROM sistemaweb.sis_pcs WHERE inf_mac = ('" + mac + "') "
                + "and inf_estado = TRUE").getResultList(), 0)[0].toString());
        if (conteo > 0) {
            return true;

        } else {
            return false;

        }
    }

    /**
     * @autor Jack Krauser y Misayo Metodo que permite obtener una lista de
     * empresas
     *
     * @return lista de empresas donde esta registrado el usuario
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaEmpresaTO> getListaLoginEmpresaTO(String usrCodigo) throws Exception {
        return ConversionesSistema.convertirListaSisLoginEmpresa_ListaSisLoginEmpresaTO(
                em.createNativeQuery(
                "SELECT "
                + "sis_empresa.emp_codigo, "
                + "emp_ruc, "
                + "emp_razon_social, "
                + "emp_nombre, "
                + "emp_direccion, "
                + "emp_telefono, "
                + "emp_ciudad, "
                + "par_gerente, "
                + "par_gerente_id, "
                + "par_contador, "
                + "par_contador_ruc, "
                + "par_actividad, "
                + "par_escoger_precio_por, "
                + "par_obligado_llevar_contabilidad, "
                + "det_equipo, "
                + "par_resolucion_contribuyente_especial, "
                + "emp_email, "
                + "emp_clave, "
                + "par_web_documentos_electronicos "
                + "FROM sistemaweb.sis_usuario_detalle "
                + "INNER JOIN sistemaweb.sis_empresa "
                + "LEFT JOIN sistemaweb.sis_empresa_parametros "
                + "ON sis_empresa.emp_codigo = sis_empresa_parametros.emp_codigo "
                + "ON sis_usuario_detalle.det_empresa = sis_empresa.emp_codigo "
                + "WHERE sis_usuario_detalle.usr_codigo = '" + usrCodigo + "' "
                + "AND det_activo ORDER BY sis_empresa.emp_razon_social;").getResultList());
        /*
         * emp_email character(50), emp_clave character(300),
         */
    }

    /**
     * @autor Misayo y Jack Krauser Metodo que permite dar acceso al sistema
     *
     * @param empCodigo Codigo de la empresa
     * @param nick El nick del usuario pero encriptado
     * @param password El password del usuario pero encriptado
     * @return Un objeto con el contenido del usuario que exista en la BD
     * @throws Exception Cualquier error inesperado
     */
   
    @Override
    public SisLoginTO getSisAcceso(
            String nick,
            String password,
            String empresa) throws Exception {
        SisLoginTO sisLoginTO = new SisLoginTO();
        Desencriptar desencriptar = new Desencriptar();
        String loginPassword = "";
        Boolean loginActivo = null;
        Boolean loginCaducado = null;
        Boolean loginCambiarPassword = null;
        String completarWhere="";
        try {
            if(empresa != null){
                completarWhere = "AND  login_empresa=('" + empresa + "')";
            }
            Object[] array = validaciones.ConvertirListaObject.convertirListToArray(
                    em.createNativeQuery(
                    "SELECT * FROM sistemaweb.sis_login WHERE login_nick=('" + nick + "')"+completarWhere).getResultList(), 0);
            if (array != null) {
                sisLoginTO.setUsrCodigo((String) array[1].toString().trim());
                sisLoginTO.setUsrNick((String) array[2].toString().trim());
                sisLoginTO.setUsrNombre((String) array[3].toString().trim());
                sisLoginTO.setUsrApellido((String) array[4].toString().trim());

                loginPassword = (String) array[5].toString().trim();
                loginActivo = (Boolean) array[6];
                loginCaducado = (Boolean) array[7];
                loginCambiarPassword = (Boolean) array[8];

                sisLoginTO.setPerEliminarFilas((Boolean) array[9]);
                sisLoginTO.setPerCambiarPrecio((Boolean) array[10]);
                sisLoginTO.setPerAplicarDescuentos((Boolean) array[11]);
                sisLoginTO.setPerCambiarFecha((Boolean) array[12]);

                if (array[13] != null) {
                    sisLoginTO.setPerMotivoPermitido((String) array[13].toString().trim());
                } else {
                    sisLoginTO.setPerMotivoPermitido(null);
                }
                if (array[14] != null) {
                    sisLoginTO.setPerBodegaPermitida((String) array[14].toString().trim());
                } else {
                    sisLoginTO.setPerBodegaPermitida(null);
                }
                if (array[15] != null) {
                    sisLoginTO.setPerDocumentoPermitido((String) array[15].toString().trim());
                } else {
                    sisLoginTO.setPerDocumentoPermitido(null);
                }
                if (array[16] != null) {
                    sisLoginTO.setPerSecuencialPermitido((String) array[16].toString().trim());
                } else {
                    sisLoginTO.setPerSecuencialPermitido(null);
                }
                sisLoginTO.setPerFormaPagoPermitida((String) array[17].toString().trim());

                sisLoginTO.setPerPermisoCredito((Boolean) array[18]);

                sisLoginTO.setPerPrecioPermitido((Integer) array[19]);

                loginPassword = loginPassword.trim();
                if (loginPassword.equals(password)) {
                    if (!loginActivo) {
                        sisLoginTO.setUsrEstado("DENEGADO");
                    } else {
                        if ((loginActivo) && (loginCaducado) && (loginCambiarPassword)) {
                            sisLoginTO.setUsrEstado("CADUCAPASSWORD");
                        }
                        if ((loginActivo) && (!loginCaducado) && (loginCambiarPassword)) {
                            sisLoginTO.setUsrEstado("PASSWORD");
                        }
                        if ((loginActivo) && (loginCaducado) && (!loginCambiarPassword)) {
                            sisLoginTO.setUsrEstado("CADUCA");
                        }
                        if ((loginActivo) && (!loginCaducado) && (!loginCambiarPassword)) {
                            sisLoginTO.setUsrEstado("CONCEDIDO");
                        }
                    }
                } else {
                    sisLoginTO.setUsrEstado("ERROR");
                }
            } else {
                sisLoginTO = null;
            }
//            Object[] array = (Object[]) em.createNativeQuery("SELECT * FROM sistemaweb.sis_login WHERE "
//                    + "login_empresa = ('" + empCodigo + "') "
//                    + "AND login_nick=('" + nick + "')").getResultList().get(0);

//            List lista = (List) em.createNativeQuery("SELECT * FROM sistemaweb.sis_login WHERE "
//                    + "login_empresa = ('" + empCodigo + "') "
//                    + "AND login_nick=('" + nick + "')").getResultList().get(0);

        } catch (Exception e) {
//            sisLoginTO.setUsrEstado("ERROR");
            sisLoginTO = null;
            //*System.out.println(e);
        }
        return sisLoginTO;
    }

    @Override
    public SisLoginTO getPermisoInventarioTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        SisLoginTO sisLoginTO = new SisLoginTO();
        try {
            Object[] array = validaciones.ConvertirListaObject.convertirListToArray(
                    em.createNativeQuery(
                    "SELECT * FROM sistemaweb.sis_login "
                    + "WHERE login_empresa=('" + sisInfoTO.getInfEmpresa() + "') AND "
                    + "login_codigo=('" + sisInfoTO.getInfUsuario() + "')").getResultList(), 0);
            if (array != null) {
                sisLoginTO.setPerEliminarFilas((Boolean) array[9]);
                sisLoginTO.setPerCambiarPrecio((Boolean) array[10]);
                sisLoginTO.setPerAplicarDescuentos((Boolean) array[11]);
                sisLoginTO.setPerCambiarFecha((Boolean) array[12]);
                if (array[13] != null) {
                    sisLoginTO.setPerMotivoPermitido((String) array[13].toString().trim());
                } else {
                    sisLoginTO.setPerMotivoPermitido(null);
                }
                if (array[14] != null) {
                    sisLoginTO.setPerBodegaPermitida((String) array[14].toString().trim());
                } else {
                    sisLoginTO.setPerBodegaPermitida(null);
                }
                if (array[15] != null) {
                    sisLoginTO.setPerDocumentoPermitido((String) array[15].toString().trim());
                } else {
                    sisLoginTO.setPerDocumentoPermitido(null);
                }
                if (array[16] != null) {
                    sisLoginTO.setPerSecuencialPermitido((String) array[16].toString().trim());
                } else {
                    sisLoginTO.setPerSecuencialPermitido(null);
                }
                sisLoginTO.setPerFormaPagoPermitida((String) array[17].toString().trim());
                sisLoginTO.setPerPermisoCredito((Boolean) array[18]);
                sisLoginTO.setPerPrecioPermitido((Integer) array[19]);
            } else {
                sisLoginTO = null;
            }
        } catch (Exception e) {
            sisLoginTO = null;
        }
        return sisLoginTO;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS DE USUARIO">
    /**
     * @autor misayo
     *
     * @param String empCodigo
     * @param String empId
     * @return codigo de cuenta anticipo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String getUsuarioNombreApellido(String usrEmpresa, String usrCodigo) throws Exception {
        try {
            return (validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                    "SELECT usr_nombre || ' ' || usr_apellido "
                    + "FROM sistemaweb.sis_usuario INNER JOIN sistemaweb.sis_usuario_detalle "
                    + "ON sis_usuario.usr_codigo=sis_usuario_detalle.usr_codigo "
                    + "WHERE det_empresa = '" + usrEmpresa + "' AND det_usuario = '" + usrCodigo + "'").
                    getResultList(), 0)[0].toString());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public SisUsuario buscarUsuario(String usrCodigo) throws Exception {
        return sisUsuarioFacadeLocal.find(usrCodigo);
    }

    @Override
    public boolean getUsuarioRepetido(String codigo, String nick, String nombre, String apellido) throws Exception {
        return Boolean.parseBoolean(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery("SELECT * FROM sistemaweb."
                + "fun_sw_usuario_repetido(" + codigo + ", " + nick + ", " + nombre + ", " + apellido + ")").
                getResultList(), 0)[0].toString());
    }

    @Override
    public int retornoContadoEliminarUsuario(String codUsuario) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "SELECT COUNT (*) ::text from sistemaweb.sis_suceso WHERE det_usuario = ('" + codUsuario.trim() + "')").getResultList(), 0)[0].toString());
    }

    /**
     * @autor Jack Krauser Metodo que obtiene una lista de usuarios y a que
     * grupo pertenecen
     *
     * @param empresa
     * @return Una lista con la lista de usuarios y a que grupo pertenecen
     * @throws Exception Cualquier error inesperado
     */
//    @Override
//    public List<SisConsultaUsuarioGrupoTO> getListaUsuarioGrupo(String empresa) throws Exception {
//        String var = "('" + empresa.trim() + "')";
//        return ConversionesSistema.convertirTOSisUsuarioTO_ListaSisUsuario(
//                em.createNativeQuery("SELECT usr_codigo, usr_nick, usr_nombre, usr_apellido, usr_password, "
//                + "usr_caduca, sis_grupo.gru_codigo, usr_activo, usr_cambiar_contrasenia, gru_nombre, "
//                + "current_date::text FROM sistemaweb.sis_usuario INNER JOIN sistemaweb.sis_grupo ON "
//                + "sis_usuario.usr_empresa || sis_usuario.gru_codigo = sis_grupo.gru_empresa || sis_grupo.gru_codigo "
//                + "WHERE sis_grupo.gru_empresa = " + var + " ORDER BY usr_nick").
//                getResultList());
//    }
    @Override
    public List<SisConsultaUsuarioGrupoTO> getListaUsuario(
            String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String empresa = "('" + sisInfoTO.getInfEmpresa().trim() + "')";
        System.out.println("SELECT usuarios.*, sis_usuario_detalle.gru_codigo "
                + "FROM (SELECT * FROM sistemaweb.fun_usuario('" + sisInfoTO.getInfUsuario() + "','" + parametro + "')) "
                + "AS usuarios INNER JOIN sistemaweb.sis_usuario_detalle "
                + "ON usuarios.usr_codigo = sis_usuario_detalle.usr_codigo "
                + "WHERE sis_usuario_detalle.gru_empresa=" + empresa + ";");
        return ConversionesSistema.convertirTOSisUsuarioTO_ListaSisUsuario(
                em.createNativeQuery(
                "SELECT usuarios.*, sis_usuario_detalle.gru_codigo "
                + "FROM (SELECT * FROM sistemaweb.fun_usuario('" + sisInfoTO.getInfUsuario() + "','" + parametro + "')) "
                + "AS usuarios INNER JOIN sistemaweb.sis_usuario_detalle "
                + "ON usuarios.usr_codigo = sis_usuario_detalle.usr_codigo "
                + "WHERE sis_usuario_detalle.gru_empresa=" + empresa + ";").getResultList());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA CONTROLAR FORMULARIOS">
    /**
     * @autor Misayo Metodo para listar empresas
     *
     * @return Lista con empresas de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisEmpresaTO> getListaSisEmpresa(String usrCodigo, String empresa) throws Exception {
        String where = "";
        if (!usrCodigo.equals("ADM")) {
            where = " WHERE sis_empresa.emp_codigo = '" + empresa + "'";
        }
        return ConversionesSistema.convertirListaSisEmpresa_ListaSisEmpresaTO(
                em.createNativeQuery(
                "SELECT "
                + "sis_empresa.emp_codigo, "
                + "emp_ruc, "
                + "emp_nombre, "
                + "emp_razon_social, "
                + "emp_direccion, "
                + "emp_ciudad, "
                + "emp_telefono, "
                + "emp_fax, "
                + "emp_email, "
                + "emp_clave, "
                + "emp_logo, "
                + "par_resolucion_contribuyente_especial, "
                + "par_obligado_llevar_contabilidad, "
                + "par_gerente, "
                + "par_gerente_tipo_id, "
                + "par_gerente_id, "
                + "par_contador, "
                + "par_contador_ruc, "
                + "emp_activa, "
                + "usr_codigo, "
                + "usr_fecha_inserta_empresa, "
                + "par_actividad, "
                + "par_escoger_precio_por, "
                + "par_financiero, "
                + "par_financiero_id, "
                + "par_columnas_estados_financieros, "
                + "par_codigo_dinardap "
                + "FROM sistemaweb.sis_empresa LEFT JOIN sistemaweb.sis_empresa_parametros "
                + "ON sis_empresa.emp_codigo = sis_empresa_parametros.emp_codigo " + where + " ORDER BY sis_empresa.emp_nombre").
                getResultList());
    }

    /**
     * @autor Misayo Metodo para listar Permisos para usuarios
     *
     * @param usrCodigo Codigo del usuario
     * @param empCodigo Codigo de la empresa
     * @return Lista con permisos para usuarios de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisPermisoTO> getListaPermisoTO(String usrCodigo, String empCodigo) throws Exception {
        if (usrCodigo.equals("ADM")) {
            usrCodigo = usrCodigo + "~";
        } else {
            usrCodigo = "~" + usrCodigo + "~";
        }
        return ConversionesSistema.convertirSisListaPermiso_SisListaPermisoTO(
                em.createNativeQuery("SELECT per_modulo, per_menu, per_item, "
                + "per_item_etiqueta, per_secuencia, per_usuarios, CASE "
                + "WHEN POSITION(('" + usrCodigo + "') IN per_usuarios)>0 "
                + "THEN TRUE ELSE FALSE END AS per_activo "
                + "FROM sistemaweb.sis_permiso WHERE emp_codigo = ('" + empCodigo + "') "
                + "ORDER BY per_modulo, per_menu, per_secuencia").getResultList());
    }

    /**
     * @autor Jack Krauser Metodo que sirve para obtener el nombre y apellido de
     * usuarios para los combosbox
     *
     * @param empresa Codigo de la empresa
     * @return lista de periodos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaUsuarioTO> getListaSisUsuario(String empresa) throws Exception {
        String var = "('" + empresa.trim() + "')";
        return ConversionesSistema.convertirListaUsuario_ListaUsuarioTO(em.createNativeQuery("SELECT sis_usuario.usr_codigo, usr_nombre, usr_apellido "
                + "FROM sistemaweb.sis_usuario_detalle "
                + "INNER JOIN sistemaweb.sis_usuario "
                + "ON sis_usuario.usr_codigo = sis_usuario_detalle.usr_codigo  "
                + "WHERE det_empresa = "
                + var + "AND usr_activo ORDER BY usr_nombre, usr_apellido").getResultList());


    }

    @Override
    public List<SisListaSusTablaTO> getListaSisSusTablaTOs(String empresa) throws Exception {
        String var = "('" + empresa.trim() + "')";
        return ConversionesSistema.convertirListaSusTabla_ListaSusTablaTO(em.createNativeQuery("SELECT sus_tabla FROM sistemaweb.sis_suceso "
                + "WHERE det_empresa= " + var + " GROUP BY sus_tabla ORDER BY sus_tabla;").getResultList());
    }

    /**
     * @autor Misayo Metodo que permite sacar los permisos de los menues segun
     * el usuario
     *
     * @param empCodigo Codigo de la empresa
     * @param usrCodigo Codigo del usuario
     * @param perModulo con el modulo del sistema
     * @return lista de empresas donde esta registrado el usuario
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaLoginPermisoTO> getListaPermisoTO(String empCodigo,
            String usrCodigo, String perModulo) throws Exception {
        if (usrCodigo.equals("ADM")) {
            usrCodigo = usrCodigo + "~";
        } else {
            usrCodigo = "~" + usrCodigo + "~";
        }
        return ConversionesSistema.convertirListaSisPermiso_ListaSisPermisoTO(
                em.createNativeQuery(
                "SELECT "
                + "per_menu, "
                + "per_item, "
                + "per_item_etiqueta, "
                + "POSITION(('" + usrCodigo + "') IN per_usuarios)>0 per_estado "
                + "FROM sistemaweb.fun_usuario_permiso('" + empCodigo + "','" + usrCodigo + "') "
                + "WHERE per_modulo=('" + perModulo + "')").getResultList());
    }

    /**
     * @autor Jack Krauser Metodo que permite Registrar sucesos de la BB.DD.
     *
     * @param sisSucesoTO Objeto TO con los datos de Suceso
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public void sisRegistrarSucesosUsuario(sistemaWeb.entity.SisSuceso sisSuceso) throws Exception {
        sisSucesoFacadeLocal.create(sisSuceso);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PERIODO">
    @Override
    public SisPeriodo buscarPeriodo(String empCodigo, String perCodigo) throws Exception {
        return sisPeriodoFacadeLocal.find(new SisPeriodoPK(empCodigo, perCodigo));
    }

    /**
     * * @autor Jack Krauser
     *
     * @param empresa Nombre de la empresa para poder filtrar
     * @return lista de periodos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaPeriodoTO> getListaSisPeriodo(String empresa) throws Exception {
        //em.createQuery("select s from SisGrupo").getResultList();//JQL;
        return ConversionesSistema.convertirListaSisPeriodo_ListaSisPeriodoTO(
                em.createNativeQuery("select per_codigo, per_detalle, "
                + "per_desde::text, per_hasta::text, "
                + "per_cerrado from sistemaweb.sis_periodo where per_empresa = ('"
                + empresa.trim() + "') ORDER BY per_codigo DESC;").getResultList());//SQL;
    }

    /**
     * @autor Misael
     *
     * @param empresa Nombre de la empresa para poder filtrar
     * @return SisComboPeriodoTOs
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisComboPeriodoTO> getSisComboPeriodo(String empresa) throws Exception {
        //em.createQuery("select s from SisGrupo").getResultList();//JQL;
        return ConversionesSistema.convertirSisComboPeriodo_SisComboPeriodoTO(
                em.createNativeQuery("SELECT per_codigo, per_detalle "
                + "FROM sistemaweb.sis_periodo "
                + "WHERE per_empresa = ('" + empresa + "') ORDER BY per_codigo DESC;").getResultList());//SQL;
    }// </editor-fold>

    /////METODOS PARA REPORTES
    @Override
    public SisPcs findSisPcs(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return sisPcsFacadeLocal.find(sisInfoTO.getInfMac());
    }

    @Override
    public SisReporteTO getSisReporteTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return ConversionesSistema.ConvertirSisReporte_SisReporteTO(em.createNativeQuery(
                "SELECT "
                + "inf_reporte_ruta_default, "
                + "inf_reporte_factura, "
                + "inf_reporte_nota_credito, "
                + "inf_reporte_liquidacion, "
                + "inf_reporte_retencion, "
                + "inf_reporte_guia_remision "
                + "FROM sistemaweb.sis_pcs "
                + "WHERE inf_mac='" + sisInfoTO.getInfMac() + "';").getResultList());
    }

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA GRUPO">
    @Override
    public SisGrupoTO sisGrupoUsuariosTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String sql = "SELECT sis_grupo.* "
                + "FROM sistemaweb.sis_usuario_detalle INNER JOIN sistemaweb.sis_grupo "
                + "ON sis_usuario_detalle.gru_empresa = sis_grupo.gru_empresa AND "
                + "sis_usuario_detalle.gru_codigo = sis_grupo.gru_codigo "
                + "WHERE sis_usuario_detalle.det_empresa='" + sisInfoTO.getInfEmpresa() + "' "
                + "AND sis_usuario_detalle.det_usuario='" + sisInfoTO.getInfUsuario() + "'";
        return ConversionesSistema.ConvertirSisGrupo_SisGrupoTO(em.createNativeQuery(
                sql).getResultList());
    }

    @Override
    public SisGrupo buscarGrupo(String empCodigo, String codGrupo) throws Exception {
        return sisGrupoFacadeLocal.find(new SisGrupoPK(empCodigo, codGrupo));
    }

    @Override
    public int retornoContadoEliminarGrupo(String codEmpresa, String codGrupo) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(em.createNativeQuery(
                "select count(usr_codigo)::text  "
                + "from sistemaweb.sis_usuario_detalle "
                + "where gru_codigo = ('" + codGrupo.trim() + "') and det_empresa = ('" + codEmpresa.trim() + "')").
                getResultList(), 0)[0].toString());
    }

    /**
     * @autor Misayo Metodo para listar grupos
     *
     * @param empresa
     * @return Lista con grupos de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisGrupoTO> getListaSisGrupo(String empresa) throws Exception {
        String var = "('" + empresa.trim() + "')";

        return ConversionesSistema.convertirListaSisGrupo_ListaSisGrupoTO(em.createNativeQuery(
                "select "
                + "gru_empresa, "
                + "gru_codigo, "
                + "gru_nombre, "
                + "gru_crear ,  "
                + "gru_modificar ,  "
                + "gru_eliminar ,  "
                + "gru_configurar , "
                + "gru_imprimir ,  "
                + "gru_exportar ,  "
                + "gru_desmayorizar_compras ,  "
                + "gru_desmayorizar_ventas ,  "
                + "gru_desmayorizar_consumos ,  "
                + "gru_desmayorizar_transferencias ,"
                + "gru_desmayorizar_contables ,  "
                + "gru_anular_compras ,  "
                + "gru_anular_ventas ,  "
                + "gru_anular_consumos ,  "
                + "gru_anular_transferencias ,"
                + "gru_anular_contables ,"
                + "emp_codigo ,"
                + "usr_inserta_grupo ,"
                + "usr_fecha_inserta_grupo "
                + "FROM sistemaweb.sis_grupo "
                + "where gru_empresa = " + var + " ORDER BY gru_nombre").getResultList());
    }

    @Override
    public List<SisGrupoTO> getSisGrupoTOs(String empresa) throws Exception {
        String var = "('" + empresa.trim() + "')";

        return ConversionesSistema.convertirGetSisGrupos_GetSisGrupoTOs(em.createNativeQuery(
                "SELECT gru_codigo, gru_nombre "
                + "FROM sistemaweb.sis_grupo "
                + "WHERE (gru_empresa = " + var + ")").getResultList());
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA ERRORES">
    /**
     * @autor Jack Krauser Metodo que permite listar los errores del sistema
     *
     * @param desde Fecha desde
     * @param hasta Fecha hasta
     * @param usuario Codigo del usuario a buscar
     * @param empresa Codigo de la empresa a buscar
     * @return lista de periodos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisErrorTO> getListaSisError(String desde, String hasta, String usuario, String empresa) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        usuario = usuario == null ? usuario : "'" + usuario + "'";
        return ConversionesSistema.convertirListaSisError_ListaSisErrorTO(
                em.createNativeQuery("SELECT * FROM sistemaweb.fun_errores((" + empresa + "), "
                + "('" + desde + "'), ('" + hasta + "'), (" + usuario + ")) "
                + "ORDER BY er_secuencia").getResultList());
//                em.createNativeQuery("SELECT er_secuencia, er_sentencia, er_clase"
//                + ", er_archivo, er_linea, er_metodo, usr_codigo, er_fecha FROM "
//                + "sistema.fun_errores(('" + empresa + "'), ('" + desde + "'), ('"
//                + hasta + "'), ('" + usuario + "')) ORDER BY er_secuencia").getResultList());
//        return ConversionesSistema.convertirListaSisError_ListaSisErrorTO(
//                em.createNativeQuery("SELECT er_secuencia, er_sentencia, er_clase"
//                + ", er_archivo, er_linea, er_metodo, usr_codigo, er_fecha FROM "
//                + "sistema.fun_errores(('" + desde + "'), ('" + hasta + "'), ('"
//                + usuario + "')) WHERE usr_empresa = ('" + empresa + "') ORDER BY er_secuencia").getResultList());
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODO PARA SUCESOS">
    /**
     * @autor Jack Krauser Metodo que obtiene una lista de sucesos
     *
     * @param desde Fecha desde
     * @param hasta Fecha hasta
     * @param usuario Codigo del usuario
     * @param suceso Descripcion del suceso (insert, delete, etc)
     * @param cadenaGeneral Palabras mas especificas
     * @param empresa Codigo de la empresa
     * @return lista de periodos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisSucesoTO> getListaSisSuceso(String desde, String hasta, String usuario, String suceso, String cadenaGeneral, String empresa) throws Exception {
        empresa = empresa == null ? empresa : "'" + empresa + "'";
        suceso = suceso == null ? suceso : "'" + suceso + "'";
        usuario = usuario == null ? usuario : "'" + usuario + "'";
        cadenaGeneral = cadenaGeneral == null ? cadenaGeneral : "'" + cadenaGeneral + "'";
        return ConversionesSistema.convertirListaSisSuceso_ListaSisSucesoTO(
                em.createNativeQuery(
                "SELECT * FROM sistemaweb.fun_sucesos("
                + "(" + empresa + "),"
                + "('" + desde + "'), "
                + "('" + hasta + "'), "
                + "(" + usuario + "), "
                + "(" + suceso + "), "
                + "(" + cadenaGeneral + ")) ORDER BY sus_secuencia").
                getResultList());
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODO PARA EMPRESA">
    @Override
    public SisEmpresa buscarEmpresa(String empCodigo) throws Exception {
        return sisEmpresaFacadeLocal.find(empCodigo);
    }// </editor-fold>

    @Override
    public SisEmpresaParametros buscarEmpresaParametros(String empCodigo) throws Exception {
        return sisEmpresaParametrosFacadeLocal.find(empCodigo);
    }

    /**
     * @autor Misayo Metodo para listar Permisos para usuarios
     *
     * @param usrCodigo Codigo del usuario
     * @param empCodigo Codigo de la empresa
     * @return Lista con permisos para usuarios de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public Integer getColumnasEstadosFinancieros(String empCodigo) throws Exception {
        return Integer.parseInt(validaciones.ConvertirListaObject.convertirListToArray(
                em.createNativeQuery("SELECT par_columnas_estados_financieros "
                + "FROM sistemaweb.sis_empresa_parametros "
                + "WHERE (emp_codigo = '" + empCodigo + "');").getResultList(), 0)[0].toString());
    }

    @Override
    public SisPckeystoreTO getSisPckeystoreTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return ConversionesSistema.ConvertirSisPckeystore_SisPckeystoreTO(em.createNativeQuery(
                "SELECT "
                + "inf_keystore_ruta, "
                + "inf_keystore_password "
                + "FROM sistemaweb.sis_pcs "
                + "WHERE inf_mac='" + sisInfoTO.getInfMac() + "';").getResultList());
    }
}