/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.business;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sistema.DAO.OperacionesSistemaDAOLocal;
import sistema.DAO.OperacionesSistemaDAOTransaccionLocal;
import sistema.TO.*;
import sistema.helper.ConversionesSistema;
import sistemaWeb.entity.*;
import validaciones.Desencriptar;
import validaciones.Validacion;
import static util.UtilsArchivos.*;
import validaciones.Excepciones;
import validaciones.Suceso;

/**
 *
 * @author misael
 */
@Stateless
public class OperacionesSistemaBusiness implements OperacionesSistemaBusinessLocal {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Boolean comprobar = false;
    private String susTabla;
    private String susClave;
    private String susSuceso;
    private String susDetalle;
    // <editor-fold defaultstate="collapsed" desc="DECLARACIONES DE EJB">
    @javax.ejb.EJB
    sistema.DAO.OperacionesSistemaDAOTransaccionLocal operacionesSistemaDAOTransaccionLocal;
    @EJB
    OperacionesSistemaDAOLocal operacionesSistemaDAOLocal;
    @EJB
    OperacionesSistemaDAOTransaccionLocal operacionesDAOTransaccionLocal;
    // </editor-fold>

//    // <editor-fold defaultstate="collapsed" desc="METODOS PARA INICIAR LA PERSISTENCIA MANUAL (YA NO SE USA)">
//    @PersistenceUnit(unitName = "EJBShrimp-PU")
//    EntityManagerFactory emf;
//    EntityManager em;
//
//    @PostConstruct
//    public void inicializaBean() {
//        try{
//            if (!em.isOpen())
//              this.em = this.emf.createEntityManager();
//        }catch (java.lang.IllegalStateException ise){
//            this.em = this.emf.createEntityManager();
//            //*System.out.println("Error de servicio de glassfish -->" + ise);
//        }catch(java.lang.NullPointerException npe){
//            this.em = this.emf.createEntityManager();
//        }
//
//
////        this.em = this.emf.createEntityManager();
//    }
//
//    @PreDestroy
//    public void finalizalizaBean() {
//        this.emf.close();
//        em.close();
//    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA ERRORES">
    /**
     * @autor Misayo Metodo que permite ingresar errores en la BD
     *
     * @param sisErrorTO Objeto con el error a ingresar
     * @param empresa
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public void insertarSisErrorTO(SisErrorTO sisErrorTO, String empresa) throws Exception {
        operacionesDAOTransaccionLocal.insertarSisErrorTO(sisErrorTO, empresa);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA EL LOGUIN">
    /**
     * @autor Jack Krauser y Misayo
     *
     * @param mac la mac del equipo
     * @return true si esta en la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean comprobarSisPcs(String mac) throws Exception {
        return operacionesSistemaDAOLocal.comprobarSisPcs(mac);
    }

    /**
     * @autor Jack Krauser y Misayo Metodo que retorna una lista de empresas
     *
     * @return lista de empresas donde esta registrado el usuario
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaEmpresaTO> getListaLoginEmpresaTO(String usrCodigo) throws Exception {
        return operacionesSistemaDAOLocal.getListaLoginEmpresaTO(usrCodigo);
    }

    /**
     * @autor Jack Krauser y Misayo
     *
     * @param empCodigo Codigo de la empresa
     * @param nick El nick del usuario pero encriptado
     * @param password El password del usuario pero encriptado
     * @return Un objeto con el contenido del usuario que exista en la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public SisLoginTO getSisAccesoTO(
            String nick,
            String password,
            String empresa) throws Exception {

        String nickApp = nick;
        String passwordApp = password;
        return operacionesSistemaDAOLocal.getSisAcceso(nickApp, passwordApp, empresa);
    }

    @Override
    public SisLoginTO getPermisoInventarioTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaDAOLocal.getPermisoInventarioTO(sisInfoTO);
    }

    /**
     * @autor Misayo Metodo que permite obtener los permisos para los menus
     *
     * @param empCodigo Codigo de la empresa
     * @param usrCodigo Codigo del usuario
     * @param perModulo Modulo que se esta queriendo acceder
     * @return lista de empresas donde esta registrado el usuario
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaLoginPermisoTO> getListaPermisoTO(String empCodigo, String usrCodigo, String perModulo) throws Exception {
        return operacionesSistemaDAOLocal.getListaPermisoTO(empCodigo, usrCodigo, perModulo);
    }// </editor-fold>

    /////METODOS PARA REPORTES
    @Override
    public SisReporteTO getSisReporteTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaDAOLocal.getSisReporteTO(sisInfoTO);
    }

    @Override
    public String updateSisReporteTO(
            SisReporteTO sisReporteTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String mensaje = "";
        comprobar = false;
        try {
            ///// CREANDO Suceso
            susClave = sisInfoTO.getInfMac();
            susDetalle = "Se modificó la(s) ruta(s) del equipo " + sisInfoTO.getInfMac();
            susSuceso = "UPDATE";
            susTabla = "sistemaweb.sis_pcs";
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            ///// CREANDO SisPcs
            SisPcs sisPcs = ConversionesSistema.ConvertirSisPcs_SisPcs(
                    operacionesSistemaDAOLocal.findSisPcs(sisInfoTO),
                    sisReporteTO);
            comprobar = operacionesSistemaDAOTransaccionLocal.updateSisReporteTO(sisPcs, sisSuceso);
            if (comprobar) {
                mensaje = "TSe modificó correctamente la Forma de Pagos";
            }
        } catch (Exception e) {
            mensaje = "FOcurrió un error al guardar la(s) ruta(s), inténtelo de nuevo...";
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionRhFormaPago",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return mensaje;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="METODOS DE GRUPO">
    @Override
    public SisGrupoTO sisGrupoUsuariosTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaDAOLocal.sisGrupoUsuariosTO(sisInfoTO);
    }

    @Override
    public boolean accionSisGrupoTO(
            SisGrupoTO sisGrupoTO,
            char accion,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        comprobar = false;
        try {
            susClave = sisGrupoTO.getGruCodigo();
            susTabla = "sistemaWeb.sis_grupo";
            if (accion == 'I') {
                susDetalle = "Se insertó al grupo " + sisGrupoTO.getGruNombre();
                susSuceso = "INSERT";
            }
            if (accion == 'M') {
                susDetalle = "Se modificó datos del grupo " + sisGrupoTO.getGruCodigo();
                susSuceso = "UPDATE";
            }
            if (accion == 'E') {
                susDetalle = "Se eliminó al grupo " + sisGrupoTO.getGruNombre();
                susSuceso = "DELETE";
            }
            sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                    susTabla,
                    susClave,
                    susSuceso,
                    susDetalle,
                    sisInfoTO);
            if (accion == 'I') {
                if (operacionesSistemaDAOLocal.buscarGrupo(sisGrupoTO.getGruEmpresa().trim(), sisGrupoTO.getGruCodigo().trim()) == null) {
                    SisGrupo sisGrupo = ConversionesSistema.ConvertirSisGrupoTO_SisGrupo(sisGrupoTO);
                    sisGrupo.setSisGrupoPK(new SisGrupoPK(sisGrupoTO.getEmpCodigo(), sisGrupoTO.getGruCodigo()));
                    sisGrupo.setEmpCodigo(operacionesSistemaDAOLocal.buscarEmpresa(sisGrupoTO.getEmpCodigo()));
                    comprobar = operacionesDAOTransaccionLocal.insertarSisGrupo(sisGrupo, sisSuceso);
                }
            }
            if (accion == 'M') {
                if (operacionesSistemaDAOLocal.buscarGrupo(sisGrupoTO.getGruEmpresa().trim(), sisGrupoTO.getGruCodigo().trim()) != null) {
                    SisGrupo sisGrupoAux = operacionesSistemaDAOLocal.buscarGrupo(sisGrupoTO.getGruEmpresa(), sisGrupoTO.getGruCodigo());
                    sisGrupoTO.setUsrInsertaGrupo(sisGrupoAux.getUsrInsertaGrupo());
                    sisGrupoTO.setUsrFechaInsertaGrupo(sisGrupoAux.getUsrFechaInsertaGrupo());
                    SisGrupo sisGrupo = ConversionesSistema.ConvertirSisGrupoTO_SisGrupo(sisGrupoTO);
                    sisGrupo.setSisGrupoPK(new SisGrupoPK(sisGrupoTO.getGruEmpresa(), sisGrupoTO.getGruCodigo()));
                    sisGrupo.setEmpCodigo(operacionesSistemaDAOLocal.buscarEmpresa(sisGrupoTO.getEmpCodigo()));
                    comprobar = operacionesDAOTransaccionLocal.modificarSisGrupo(sisGrupo, sisSuceso);
                }
            }
            if (accion == 'E') {
                int contador = operacionesSistemaDAOLocal.retornoContadoEliminarGrupo(sisGrupoTO.getEmpCodigo(), sisGrupoTO.getGruCodigo());
                if (contador == 0) {
                    SisGrupo sisGrupo = ConversionesSistema.ConvertirSisGrupoTO_SisGrupo(sisGrupoTO);
                    sisGrupo.setSisGrupoPK(new SisGrupoPK(sisGrupoTO.getGruEmpresa(), sisGrupoTO.getGruCodigo()));
                    sisGrupo.setEmpCodigo(operacionesSistemaDAOLocal.buscarEmpresa(sisGrupoTO.getEmpCodigo()));
                    comprobar = operacionesDAOTransaccionLocal.eliminarSisGrupo(sisGrupo, sisSuceso);
                }
            }

        } catch (Exception e) {
            comprobar = false;
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "accionSisGrupoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    /**
     * @autor Misayo Metodo para listar empresas
     *
     * @return Lista con empresas de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisGrupoTO> getSisGrupoTOs(String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getSisGrupoTOs(empresa);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA USUARIO">
    /**
     * @autor Jack Krauser Metodo para ingresar un usuario
     *
     * @param sisUsuarioTO Objeto TO con datos del usuario
     * @return true si ingreso, false si no guardo y ocurrio una excepcion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String insertarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        String retorno = "";
        sisUsuarioTO.setUsrNick((sisUsuarioTO.getUsrNick()));
        SisUsuario sisUsuario = null;

        try {
            if (operacionesSistemaDAOLocal.buscarUsuario(sisUsuarioTO.getUsrCodigo()) == null) {
                /////BUSCAR POR NICK
                if (operacionesSistemaDAOLocal.getUsuarioRepetido(null, (sisUsuarioTO.getUsrNick().trim().isEmpty() ? null : "'" + sisUsuarioTO.getUsrNick() + "'"), null, null)) {
                    retorno = "FEl Nick del Usuario ya existe en los registros.\nIntente ingresando otro Nick...";
                } else {
                    /////BUSCAR POR NOMBRE Y APELLIDO
                    if (operacionesSistemaDAOLocal.getUsuarioRepetido(null, null, (sisUsuarioTO.getUsrNombre().trim().isEmpty() ? null : "'" + sisUsuarioTO.getUsrNombre() + "'"), (sisUsuarioTO.getUsrApellido().trim().isEmpty() ? null : "'" + sisUsuarioTO.getUsrApellido() + "'"))) {
                        retorno = "FEl Nombre y Apellido que ingresó ya existe en los registros.\nIntente ingresando otro Nombre y Apellido...";
                    } else {
                        retorno = "T";
                    }
                }
                if (retorno.charAt(0) == 'T') {
                    sisUsuarioTO.setUsrFechaInsertaUsuario(Validacion.fechaSistema());
                    sisUsuario = ConversionesSistema.ConvertirSisUsuarioTO_SisUsuario(sisUsuarioTO);
                    sistemaWeb.entity.SisUsuarioDetalle sisUsuarioDetalle = new sistemaWeb.entity.SisUsuarioDetalle(
                            new sistemaWeb.entity.SisUsuarioDetallePK(sisInfoTO.getInfEmpresa(), sisUsuario.getUsrCodigo()),
                            "",
                            true,
                            validaciones.Validacion.fechaString_Date(Validacion.fechaSistema()));
                    sisUsuarioDetalle.setUsrCodigo(sisUsuario);
                    sisUsuarioDetalle.setSisGrupo(new SisGrupo(new SisGrupoPK(sisInfoTO.getInfEmpresa(), sisUsuarioTO.getGruCodigo())));

                    comprobar = false;
                    //SUCESO
                    susClave = sisUsuarioTO.getUsrCodigo();
                    susTabla = "sistemaWeb.sis_usuario";
                    susDetalle = "Se insertó datos del usuario " + sisUsuarioTO.getUsrCodigo();
                    susSuceso = "INSERT";
                    sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                            susTabla,
                            susClave,
                            susSuceso,
                            susDetalle,
                            sisInfoTO);

                    comprobar = operacionesDAOTransaccionLocal.insertarSisUsuario(sisUsuario, sisUsuarioDetalle, sisSuceso);
                    if (comprobar) {
                        retorno = "TUsuario guardado correctamente...";
                    } else {
                        retorno = "FHubo un error al guardar el usuario...\nIntente de nuevo o contacte con el administrador.";
                    }
                }
            } else {
                retorno = "FEl Código del Usuario que va a ingresar ya existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarSisUsuarioTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    /**
     * @autor Jack Krauser Metodo que permite modificar un Usuario
     *
     * @param sisUsuarioTO Objeto con el contenido de Usuario
     * @param pass Clave del usuario
     * @return true o false segun se ejecute la accion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String modificarPasswordSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            String pass) throws Exception{
         sistemaWeb.entity.SisUsuario sisUsuario = operacionesSistemaDAOLocal.buscarUsuario(sisUsuarioTO.getUsrCodigo());
         sisUsuario.setUsrPassword(pass);
         sisUsuario.setUsrCambiarContrasenia(false);
         //System.out.println(pass);
         //System.out.println(sisUsuario.getUsrPassword());
         if (operacionesDAOTransaccionLocal.modificarSisUsuario(sisUsuario)) {
                        return "TSu contraseña se modifico correctamente...";
                    } else {
                        return "FHubo un error al actualizar la contraseña...\nIntente de nuevo o contacte con el administrador.";
                    }
    }

    @Override
    public String modificarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            String pass,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        sisUsuarioTO.setUsrNick(sisUsuarioTO.getUsrNick());
        SisUsuario sisUsuario = null;
        String fechaEnviar = "";
        String retorno = "";
        try {
            if (operacionesSistemaDAOLocal.buscarUsuario(sisUsuarioTO.getUsrCodigo()) != null) {
                /////BUSCAR POR NICK
                if (operacionesSistemaDAOLocal.getUsuarioRepetido("'" + sisUsuarioTO.getUsrCodigo().trim() + "'", (sisUsuarioTO.getUsrNick().trim().isEmpty() ? null : "'" + sisUsuarioTO.getUsrNick() + "'"), null, null)) {
                    retorno = "FEl Nick del Usuario ya existe en los registros.\nIntente ingresando otro Nick...";
                } else {
                    /////BUSCAR POR NOMBRE Y APELLIDO
                    if (operacionesSistemaDAOLocal.getUsuarioRepetido("'" + sisUsuarioTO.getUsrCodigo().trim() + "'", null, (sisUsuarioTO.getUsrNombre().trim().isEmpty() ? null : "'" + sisUsuarioTO.getUsrNombre() + "'"), (sisUsuarioTO.getUsrApellido().trim().isEmpty() ? null : "'" + sisUsuarioTO.getUsrApellido() + "'"))) {
                        retorno = "FEl Nombre y Apellido que ingresó ya existe en los registros.\nIntente ingresando otro Nombre y Apellido...";
                    } else {
                        retorno = "T";
                    }
                }
                if (retorno.charAt(0) == 'T') {
                    comprobar = false;
                    if (operacionesSistemaDAOLocal.buscarUsuario(sisUsuarioTO.getUsrCodigo()) != null) {
//                        if (sisUsuarioTO.getGruCodigo().equals("ASIGNADO")) {
                        //sisUsuarioTO.setUsrActivo(true);
                        //sisUsuarioTO.setUsrCambiarContrasenia(false);

                        if (sisUsuarioTO.getUsrCaduca() == null) {
                            SisUsuario sisUsuarioAux = operacionesSistemaDAOLocal.buscarUsuario(sisUsuarioTO.getUsrCodigo());
                            if (sisUsuarioAux.getUsrCaduca() == null) {
                                fechaEnviar = null;
                            } else {
                                fechaEnviar = sisUsuarioAux.getUsrCaduca().toString();
                                java.util.Calendar c1 = java.util.Calendar.getInstance();
                                c1.setTime(sisUsuarioAux.getUsrCaduca());
                                fechaEnviar = Validacion.fecha(c1.getTime(), "yyyy-MM-dd HH:mm:ss");
                            }
                        } else {
                            fechaEnviar = Validacion.fechaSumarDias(Validacion.fechaString_Date(sisUsuarioTO.getUsrCaduca()), 72);
                        }
//                        } else {
//                            if (sisUsuarioTO.getUsrCaduca() == null) {
//                                fechaEnviar = null;
//                            } else {
//                                fechaEnviar = sisUsuarioTO.getUsrCaduca();
//                            }
//                        }
                        sisUsuarioTO.setUsrCaduca(fechaEnviar);
                        //SUCESO
                        susClave = sisUsuarioTO.getUsrCodigo();
                        susTabla = "sistemaWeb.sis_usuario";
                        susDetalle = "Se modificó datos del usuario " + sisUsuarioTO.getUsrCodigo();
                        susSuceso = "UPDATE";
                        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                                susTabla,
                                susClave,
                                susSuceso,
                                susDetalle,
                                sisInfoTO);
                        if (pass == null) {
                            SisUsuario sisUsuarioDato = operacionesSistemaDAOLocal.buscarUsuario(sisUsuarioTO.getUsrCodigo());
                            sisUsuarioTO.setUsrPassword(sisUsuarioDato.getUsrPassword());
                            sisUsuarioTO.setUsrInsertaUsuario("");
                            sisUsuarioTO.setUsrFechaInsertaUsuario(Validacion.fechaSistema());
                            sisUsuario = ConversionesSistema.ConvertirSisUsuarioTO_SisUsuario(sisUsuarioTO);
                            sisUsuario.setUsrCodigo(sisUsuarioTO.getUsrCodigo());
                            sisUsuario.setUsrCodigoInserta(sisInfoTO.getInfUsuario());
                            sisUsuario.setUsrFechaInsertaUsuario(sisUsuarioDato.getUsrFechaInsertaUsuario());
                            sistemaWeb.entity.SisUsuarioDetalle sisUsuarioDetalle = new sistemaWeb.entity.SisUsuarioDetalle(
                                    new sistemaWeb.entity.SisUsuarioDetallePK(sisInfoTO.getInfEmpresa(), sisUsuario.getUsrCodigo()),
                                    "",
                                    true,
                                    validaciones.Validacion.fechaString_Date(Validacion.fechaSistema()));
                            sisUsuarioDetalle.setUsrCodigo(sisUsuario);
                            sisUsuarioDetalle.setSisGrupo(new SisGrupo(new SisGrupoPK(sisInfoTO.getInfEmpresa(), sisUsuarioTO.getGruCodigo())));
                            comprobar = operacionesDAOTransaccionLocal.modificarSisUsuario(sisUsuario, sisUsuarioDetalle, sisSuceso);
                            if (comprobar) {
                                retorno = "TUsuario modificado correctamente...";
                            } else {
                                retorno = "FHubo un error al modificar el usuario...\nIntente de nuevo o contacte con el administrador.";
                            }
                        } else {
                            SisUsuario sisUsuarioDato = operacionesSistemaDAOLocal.buscarUsuario(sisUsuarioTO.getUsrCodigo());
                            sisUsuarioTO.setUsrFechaInsertaUsuario(validaciones.Validacion.fecha(sisUsuarioDato.getUsrFechaInsertaUsuario(), "yyyy-MM-dd HH:mm:ss"));
                            sisUsuario = ConversionesSistema.ConvertirSisUsuarioTO_SisUsuario(sisUsuarioTO);
                            sisUsuario.setUsrCodigoInserta(sisInfoTO.getInfUsuario());
                            sisUsuario.setUsrFechaInsertaUsuario(sisUsuarioDato.getUsrFechaInsertaUsuario());
                            sisUsuario.setUsrCodigo(sisUsuarioTO.getUsrCodigo());

                            sistemaWeb.entity.SisUsuarioDetalle sisUsuarioDetalle = new sistemaWeb.entity.SisUsuarioDetalle(
                                    new sistemaWeb.entity.SisUsuarioDetallePK(sisInfoTO.getInfEmpresa(), sisUsuario.getUsrCodigo()),
                                    "",
                                    true,
                                    validaciones.Validacion.fechaString_Date(Validacion.fechaSistema()));
                            sisUsuarioDetalle.setUsrCodigo(sisUsuario);

                            sisUsuarioDetalle.setSisGrupo(new SisGrupo(new SisGrupoPK(sisInfoTO.getInfEmpresa(), sisUsuarioTO.getGruCodigo())));
                            comprobar = operacionesDAOTransaccionLocal.modificarSisUsuario(sisUsuario, sisUsuarioDetalle, sisSuceso);
                            if (comprobar) {
                                retorno = "TUsuario modificado correctamente...";
                            } else {
                                retorno = "FHubo un error al modificar el usuario...\nIntente de nuevo o contacte con el administrador.";
                            }
                        }
                    }
                }
            } else {
                retorno = "FEl Código del Usuario que va a modificar ya no existe...\nIntente con otro...";
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarSisUsuarioTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return retorno;
        }
    }

    /**
     * @autor Jack Krauser Metodo para eliminar un usuario
     *
     * @param sisUsuarioTO Objeto con el usuario a eliminar
     * @return true o false segun se elimine al usuario o no
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean eliminarSisUsuarioTO(
            SisUsuarioTO sisUsuarioTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        int contador = operacionesSistemaDAOLocal.retornoContadoEliminarUsuario(sisUsuarioTO.getUsrCodigo());
        SisUsuario sisUsuario = null;
        try {
            comprobar = false;
            if (contador == 0) {
                sisUsuarioTO.setUsrFechaInsertaUsuario(Validacion.fechaSistema());
                sisUsuario = ConversionesSistema.ConvertirSisUsuarioTO_SisUsuario(sisUsuarioTO);
                sistemaWeb.entity.SisUsuarioDetalle sisUsuarioDetalle = new sistemaWeb.entity.SisUsuarioDetalle(
                        new sistemaWeb.entity.SisUsuarioDetallePK(sisInfoTO.getInfEmpresa(), sisUsuario.getUsrCodigo()),
                        "",
                        true,
                        validaciones.Validacion.fechaString_Date(Validacion.fechaSistema()));
                sisUsuarioDetalle.setUsrCodigo(sisUsuario);
                sisUsuarioDetalle.setSisGrupo(new SisGrupo(new SisGrupoPK(sisInfoTO.getInfEmpresa(), sisUsuarioTO.getGruCodigo())));

                //SUCESO
                susClave = sisUsuarioTO.getUsrCodigo();
                susTabla = "sistemaWeb.sis_usuario";
                susDetalle = "Se eliminó datos del usuario " + sisUsuarioTO.getUsrCodigo();
                susSuceso = "DELETE";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesDAOTransaccionLocal.eliminarSisUsuario(sisUsuario, sisUsuarioDetalle, sisSuceso);
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "eliminarSisUsuarioTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public String getUsuarioNombreApellido(String usrEmpresa, String usrCodigo) throws Exception {
        return operacionesSistemaDAOLocal.getUsuarioNombreApellido(usrEmpresa, usrCodigo);
    }

    /**
     * @param empresa @autor Misayo Metodo para listar grupos
     * @return Lista con grupos de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisGrupoTO> getListaSisGrupo(String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getListaSisGrupo(empresa);
    }

    /**
     * @autor Jack Krauser Metodo que muestra usuarios y a que grupo pertenecen
     *
     * @param usuario Codigo del usuario
     * @param empresa Codigo de la empresa
     * @return Objeto TO de grupo
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public SisUsuario buscarUsuario(String empCodigo, String usrCodigo) throws Exception {
        return operacionesSistemaDAOLocal.buscarUsuario(usrCodigo);
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa Codigo de la empresa a filtrar Metodo que obtiene una
     * lista de usuarios y a que grupo pertenecen
     * @return Una lista con la lista de usuarios y a que grupo pertenecen
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisConsultaUsuarioGrupoTO> getListaUsuario(
            String parametro,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaDAOLocal.getListaUsuario(parametro, sisInfoTO);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODO PARA REGISTRAR EVENTOS DE USUARIO">
    /**
     * @autor Jack Krauser Metodo para registrar los eventos de los usuarios
     *
     * @param usuario Codigo del usuario
     * @param empresa Codigo de la empresa
     * @param suceso Descripcion del suceso
     * @param mensaje Detalle del suceso
     * @param tabla En que tabla paso el suceso
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public void sisRegistrarEventosUsuario(
            String suceso,
            String mensaje,
            String tabla,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            SisSucesoTO sisSucesoTO = new SisSucesoTO();
            sisSucesoTO.setUsrEmpresa(sisInfoTO.getInfEmpresa());
            sisSucesoTO.setUsrCodigo(sisInfoTO.getInfUsuario());
            sisSucesoTO.setSusDetalle("El usuario " + sisInfoTO.getInfUsuario() + mensaje + " " + Validacion.fechaSistema());
            sisSucesoTO.setSusSuceso(suceso);
            sisSucesoTO.setSusSecuencia(0);
            sisSucesoTO.setSusClave(sisInfoTO.getInfUsuario());
            sisSucesoTO.setSusFecha(Validacion.fechaSistema());
            sisSucesoTO.setSusTabla(tabla);
            sistemaWeb.entity.SisSuceso sisSuceso = ConversionesSistema.ConvertirSisSucesoTO_SisSuceso(sisSucesoTO);
            sisSuceso.setSusMac(sisInfoTO.getInfMac());
            operacionesSistemaDAOLocal.sisRegistrarSucesosUsuario(sisSuceso);
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "sisRegistrarEventosUsuario",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PERIODO">
    /**
     * @autor Misayo
     *
     * @param empresa Codigo de la empresa
     * @param fecha fecha de la transaccion
     * @return true="Abierto"-false="Cerrado"-null="No existe"
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public String estadoPeriodo(String empresa, String fecha) throws Exception {
        String periodoCerrado = "No se puede realizar la acción, Periodo no existe.!";
        java.util.List<sistema.TO.SisListaPeriodoTO> listaSisPeriodoTO = operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);
        for (sistema.TO.SisListaPeriodoTO sisListaPeriodoTO : listaSisPeriodoTO) {
            if (validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                    >= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerDesde(), "yyyy-MM-dd").getTime()
                    && validaciones.Validacion.fecha(fecha, "yyyy-MM-dd").getTime()
                    <= validaciones.Validacion.fecha(sisListaPeriodoTO.getPerHasta(), "yyyy-MM-dd").getTime()) {
                periodoCerrado = sisListaPeriodoTO.getPerCerrado()
                        ? "No se puede realizar la acción, Periodo cerrado.!"
                        : "";
            }
        }
        //true="Cerrado"-false="Abierto"-null="No existe"
        return periodoCerrado;
    }

    /**
     * @autor Jack Krauser
     *
     * @param empresa Codigo de la empresa
     * @return lista de periodos
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisListaPeriodoTO> getListaPeriodoTO(String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getListaSisPeriodo(empresa);
    }

    @Override
    public List<SisComboPeriodoTO> getSisComboPeriodoTO(String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getSisComboPeriodo(empresa);
    }

    /**
     * * @autor Jack Krauser
     *
     * @param sisPeriodoTO el periodo a ingresar
     * @return true si inserto o false si ocurrio una excepcion
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean insertarSisPeriodoTO(SisPeriodoTO sisPeriodoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            sisPeriodoTO.setUsrFechaInsertaPeriodo(Validacion.fechaSistema());
            comprobar = false;
            if (operacionesSistemaDAOLocal.buscarPeriodo(sisPeriodoTO.getPerEmpresa().trim(), sisPeriodoTO.getPerCodigo().trim()) == null) {
                SisPeriodo sisPeriodo = ConversionesSistema.ConvertirSisPeriodoTO_SisPeriodo(sisPeriodoTO);
                sisPeriodo.setSisPeriodoPK(new SisPeriodoPK(sisPeriodoTO.getPerEmpresa(), sisPeriodoTO.getPerCodigo()));
                susClave = sisPeriodoTO.getPerCodigo();
                susDetalle = "Se insertó un periodo desde "
                        + sisPeriodoTO.getPerDesde() + " hasta "
                        + sisPeriodoTO.getPerHasta();
                susSuceso = "INSERT";
                susTabla = "sistema.sis_usuario";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesDAOTransaccionLocal.insertarSisPeriodo(sisPeriodo, sisSuceso);
            }
        } catch (Exception e) {
            comprobar = false;

            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarSisPeriodoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    /**
     * @autor Misayo y Jack Krauser Metodo para modificar Periodo
     *
     * @param sisPeriodoTO
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean modificarSisPeriodoTO(SisPeriodoTO sisPeriodoTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {

        try {
            sisPeriodoTO.setUsrFechaInsertaPeriodo(Validacion.fechaSistema());
            comprobar = false;
            if (operacionesSistemaDAOLocal.buscarPeriodo(sisPeriodoTO.getPerEmpresa().trim(), sisPeriodoTO.getPerCodigo().trim()) != null) {

                susClave = sisPeriodoTO.getPerCodigo();
                susDetalle = "Se modificó datos del periodo "
                        + sisPeriodoTO.getPerCodigo();
                susSuceso = "UPDATE";
                susTabla = "sistema.sis_usuario";
                SisPeriodo sisPeriodoAux = operacionesSistemaDAOLocal.buscarPeriodo(sisPeriodoTO.getPerEmpresa().trim(), sisPeriodoTO.getPerCodigo().trim());
                sisPeriodoTO.setUsrFechaInsertaPeriodo(Validacion.fecha(sisPeriodoAux.getUsrFechaInsertaPeriodo(), "yyyy-MM-dd HH:mm:ss"));
                SisPeriodo sisPeriodo = ConversionesSistema.ConvertirSisPeriodoTO_SisPeriodo(sisPeriodoTO);
                sisPeriodo.setSisPeriodoPK(new SisPeriodoPK(sisPeriodoTO.getEmpCodigo(), sisPeriodoTO.getPerCodigo()));
                sisPeriodo.setEmpCodigo(new SisEmpresa(sisInfoTO.getInfEmpresa()));
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);
                comprobar = operacionesDAOTransaccionLocal.modificarSisPeriodo(sisPeriodo, sisSuceso);
            }
            comprobar = true;
        } catch (Exception e) {
            comprobar = false;

            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarSisPeriodoTO",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA ERRORES">
    /**
     * @autor Jack Krauser Metodo para listar empresas
     *
     * @param desde Fecha desde
     * @param hasta Fecha hasta
     * @param usuario Codigo del usuario
     * @param empresa Codigo de la empresa
     * @return Lista con empresas de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisErrorTO> getListaSisErrorTO(String desde, String hasta,
            String usuario, String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getListaSisError(desde, hasta,
                usuario, empresa);
    }
    public SisErrorTO sisErrorTO = null;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="METODOS PARA SUCESOS">
    /**
     * @autor Jack Krauser Metodo para listar empresas
     *
     * @param desde Fecha desde
     * @param hasta Fecha hasta
     * @param usuario Codigo del usuario
     * @param suceso Descripcion del suceso
     * @param cadenaGeneral Cadena especifica para busqueda
     * @param empresa Codigo de la empresa
     * @return Lista con empresas de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisSucesoTO> getListaSisSucesoTO(
            String desde,
            String hasta,
            String usuario,
            String suceso,
            String cadenaGeneral,
            sistema.TO.SisInfoTO sisInfoTO) {
        List<SisSucesoTO> sisSucesoTOs = null;
        try {
            sisSucesoTOs = operacionesSistemaDAOLocal.getListaSisSuceso(desde, hasta,
                    usuario, suceso, cadenaGeneral, sisInfoTO.getInfEmpresa());
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "insertarRhAnticipoConContable",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        }
        return sisSucesoTOs;
    }

    /**
     * @autor Misayo Metodo que obtiene una lista de todos los usuarios
     *
     * @param empresa Codigo de la empresa
     * @return Una lista de usuarios
     * @throws Exception cualquier error inesperado
     */
    @Override
    public List<SisListaSusTablaTO> getListaSisSusTablaTOs(String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getListaSisSusTablaTOs(empresa);
    }

    @Override
    public List<SisListaUsuarioTO> getListaSisUsuarios(String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getListaSisUsuario(empresa);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA EMPRESA">
    /**
     * @autor Misayo Metodo para ingresar empresa
     *
     * @param sisEmpresaTO Objeto TO
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean insertarSisEmpresa(SisEmpresaTO sisEmpresaTO, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            sisEmpresaTO.setUsrFechaInsertaUsuario(Validacion.fechaString_Date(
                    Validacion.fechaSistema()));
            comprobar = false;
            if (operacionesSistemaDAOLocal.buscarEmpresa(sisEmpresaTO.getEmpCodigo()) == null) {
                SisEmpresa sisEmpresa = ConversionesSistema.ConvertirSisEmpresaTO_SisEmpresa(sisEmpresaTO);

                //SUCESO
                susClave = sisEmpresaTO.getEmpCodigo();
                susTabla = "sistemaWeb.sis_empresa";
                susDetalle = "Se insertó la empresa " + sisEmpresaTO.getEmpCodigo();
                susSuceso = "INSERT";
                SisSuceso sisSuceso = Suceso.crearSisSuceso(susTabla,
                        susClave, susSuceso, susDetalle, sisInfoTO);

                SisEmpresaParametros sisEmpresaParametros = new SisEmpresaParametros();
                sisEmpresaParametros.setEmpCodigo(sisEmpresa);
                sisEmpresaParametros.setParEmpresa(sisEmpresaTO.getEmpCodigo());
                sisEmpresaParametros.setParGerente(sisEmpresaTO.getEmpGerente());                
                sisEmpresaParametros.setParGerenteTipoId(sisEmpresaTO.getEmpTipoIdGerente());
                sisEmpresaParametros.setParGerenteId(sisEmpresaTO.getEmpIdGerente());                
                sisEmpresaParametros.setParContador(sisEmpresaTO.getEmpContador());
                sisEmpresaParametros.setParContadorRuc(sisEmpresaTO.getEmpRucContador());
                sisEmpresaParametros.setParFinanciero(sisEmpresaTO.getParFinanciero());
                sisEmpresaParametros.setParFinancieroId(sisEmpresaTO.getParFinancieroId());
                sisEmpresaParametros.setParActividad(sisEmpresaTO.getParActividad());
                sisEmpresaParametros.setParEscogerPrecioPor(sisEmpresaTO.getParEscogerPrecioPor());
                //sisEmpresaParametros.setParObligadoLlevarContabilidad(true);                
                sisEmpresaParametros.setParResolucionContribuyenteEspecial(sisEmpresaTO.getEmResolucionContribuyenteEspecial());                                               
                sisEmpresaParametros.setParColumnasEstadosFinancieros(sisEmpresaTO.getParColumnasEstadosFinancieros());
                sisEmpresaParametros.setParCodigoDinardap(sisEmpresaTO.getParCodigoDinardap());                                                                                
                //(sisEmpresaParametros.setParWebDocumentosElectronicos(sisEmpresaTO.get);
                
                
                comprobar = operacionesDAOTransaccionLocal.insertarSisEmpresa(
                        sisEmpresa, sisSuceso, sisEmpresaParametros);
            }
        } catch (Exception e) {
            Excepciones.guardarExcepcionesEJB(e,
                    getClass().getName(), "modificarSisEmpresa",
                    sisInfoTO, operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    @Override
    public String guardarImagenEmpresa(byte[] imagen, String nombre) throws Exception {
        return guardarImagen(getRutaImagen(), imagen, nombre, 400, 450);
    }

    @Override
    public String eliminarImagenEmpresa(String nombre) throws Exception {
        String mensaje = "";
        if (eliminarArchivo(getRutaImagen() + nombre + ".jpg")) {
            mensaje = "Imagen Eliminada con exito..";
        } else {
            mensaje = "No tiene una Imagen ah eliminar..";
        }
        return mensaje;
    }

    @Override
    public byte[] obtenerImagenEmpresa(String nombre) throws Exception {
        InputStream is = leerImagen(getRutaImagen() + nombre + ".jpg");
        byte[] bytes = null;
        if (is != null) {
            bytes = new byte[is.available()];
            is.read(bytes);
        }
        return bytes;
    }

    /**
     * @autor Misayo Metodo para modificar empresa
     *
     * @param sisEmpresaTO Objeto TO
     * @return true si realiza la accion sobre el registro, false si ya existe
     * el registro
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public boolean modificarSisEmpresa(
            SisEmpresaTO sisEmpresaTO,
            sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        try {
            sisEmpresaTO.setUsrFechaInsertaUsuario(Validacion.fechaString_Date(Validacion.fechaSistema()));
            comprobar = false;
            if (operacionesSistemaDAOLocal.buscarEmpresa(sisEmpresaTO.getEmpCodigo()) != null) {                
                SisEmpresa sisEmpresa = ConversionesSistema.ConvertirSisEmpresaTO_SisEmpresa(sisEmpresaTO);

                susClave = sisEmpresaTO.getEmpCodigo();
                susTabla = "sistemaWeb.sis_empresa";
                susDetalle = "Se modifico datos de la empresa " + sisEmpresaTO.getEmpCodigo();
                susSuceso = "UPDATE";
                sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                        susTabla,
                        susClave,
                        susSuceso,
                        susDetalle,
                        sisInfoTO);

                sistemaWeb.entity.SisEmpresaParametros sisEmpresaParametros = operacionesSistemaDAOLocal.buscarEmpresaParametros(sisEmpresaTO.getEmpCodigo());                
                sisEmpresaParametros.setEmpCodigo(sisEmpresa);                
//                sisEmpresaParametros.setParEmpresa(sisEmpresaTO.getEmpCodigo());
                sisEmpresaParametros.setParGerente(sisEmpresaTO.getEmpGerente());                
                sisEmpresaParametros.setParGerenteTipoId(sisEmpresaTO.getEmpTipoIdGerente());
                sisEmpresaParametros.setParGerenteId(sisEmpresaTO.getEmpIdGerente());                
                sisEmpresaParametros.setParContador(sisEmpresaTO.getEmpContador());
                sisEmpresaParametros.setParContadorRuc(sisEmpresaTO.getEmpRucContador());
                sisEmpresaParametros.setParFinanciero(sisEmpresaTO.getParFinanciero());
                sisEmpresaParametros.setParFinancieroId(sisEmpresaTO.getParFinancieroId());
                sisEmpresaParametros.setParActividad(sisEmpresaTO.getParActividad());
                sisEmpresaParametros.setParEscogerPrecioPor(sisEmpresaTO.getParEscogerPrecioPor());
                //sisEmpresaParametros.setParObligadoLlevarContabilidad(true);                
                sisEmpresaParametros.setParResolucionContribuyenteEspecial(sisEmpresaTO.getEmResolucionContribuyenteEspecial());                                               
                sisEmpresaParametros.setParColumnasEstadosFinancieros(sisEmpresaTO.getParColumnasEstadosFinancieros());
                sisEmpresaParametros.setParCodigoDinardap(sisEmpresaTO.getParCodigoDinardap());                                                                                
                //(sisEmpresaParametros.setPa

                comprobar = operacionesDAOTransaccionLocal.modificarSisEmpresa(sisEmpresa, sisSuceso, sisEmpresaParametros);
            }
        } catch (Exception e) {
            validaciones.Excepciones.guardarExcepcionesEJB(
                    e,
                    getClass().getName(),
                    "modificarSisEmpresa",
                    sisInfoTO,
                    operacionesSistemaDAOTransaccionLocal);
        } finally {
            return comprobar;
        }
    }

    /**
     * @autor Misayo Metodo para listar empresas
     *
     * @return Lista con empresas de la BD
     * @throws Exception Cualquier error inesperado
     */
    @Override
    public List<SisEmpresaTO> getListaSisEmpresaTO(
            String usrCodigo,
            String empresa) throws Exception {
        return operacionesSistemaDAOLocal.getListaSisEmpresa(
                usrCodigo,
                empresa);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METODOS PARA PERMISOS">
    /**
     * @autor Misayo, Jack Krauser Metodo para modificar Permisos para usuarios
     *
     * @param listaSisPermisoTO Lista con permisos
     * @param usuarioCod Codigo del usuario que hizo la modificacion
     * @param codModifUsuario Codigo del usuario a quien se le modifica los
     * permisos
     * @return true o false segun se ejecute la accion
     * @throws Exception Cualquier error inesperado
     */
//    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public boolean modificarSisPermiso(List<SisPermisoTO> listaSisPermisoTO, String usuarioCod, String codModifUsuario, sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        SisEmpresa empresa = null;
        sistemaWeb.entity.SisPermiso sisPermiso = null;
        sistemaWeb.entity.SisUsuario sisUsuario = null;
        java.util.List<sistemaWeb.entity.SisPermiso> sisPermisos = new java.util.ArrayList();

        comprobar = false;
        for (SisPermisoTO sisPermisoTO : listaSisPermisoTO) {
            //BUSCANDO EMPRESA
            empresa = operacionesSistemaDAOLocal.buscarEmpresa(sisPermisoTO.getEmpCodigo());

            sisPermiso = new sistemaWeb.entity.SisPermiso();
            sisPermiso.setEmpCodigo(empresa);
            sisPermiso.setPerSecuencia(sisPermisoTO.getPerSecuencia());

            sisPermiso.setSisPermisoPK(new sistemaWeb.entity.SisPermisoPK(
                    sisPermisoTO.getEmpCodigo(),
                    sisPermisoTO.getPerModulo(),
                    sisPermisoTO.getPerMenu(),
                    sisPermisoTO.getPerItem()));

            sisPermiso.setPerItemEtiqueta(sisPermisoTO.getPerItemEtiqueta());
            sisPermiso.setPerUsuarios(sisPermisoTO.getPerUsuarios());
            sisPermisos.add(sisPermiso);
        }
        //BUSCANDO USUARIO
        sisUsuario = operacionesSistemaDAOLocal.buscarUsuario(codModifUsuario);
        susClave = codModifUsuario;
        susDetalle = "Cambio de permisos a " + sisUsuario.getUsrNombre() + " " + sisUsuario.getUsrApellido();
        susSuceso = "UPDATE";
        susTabla = "sistema.sis_permiso";
        sistemaWeb.entity.SisSuceso sisSuceso = validaciones.Suceso.crearSisSuceso(
                susTabla,
                susClave,
                susSuceso,
                susDetalle,
                sisInfoTO);
        return operacionesDAOTransaccionLocal.modificarSisPermiso(sisPermisos, sisSuceso);
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
        return operacionesSistemaDAOLocal.getListaPermisoTO(usrCodigo, empCodigo);
    }// </editor-fold>

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
        return operacionesSistemaDAOLocal.getColumnasEstadosFinancieros(empCodigo);
    }

    @Override
    public SisPckeystoreTO getSisPckeystoreTO(sistema.TO.SisInfoTO sisInfoTO) throws Exception {
        return operacionesSistemaDAOLocal.getSisPckeystoreTO(sisInfoTO);
    }
}
