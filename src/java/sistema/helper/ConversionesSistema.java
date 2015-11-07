/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import sistema.TO.*;
import sistemaWeb.entity.*;
import validaciones.Validacion;

/**
 *
 * @author misael
 */
public class ConversionesSistema {

    /**
     * @autor Misayo, Jack Krauser Metodo que convierte objetos de tipo
     * SisEmpresa a SisEmpresaTO
     *
     * @param sisEmpresa el objeto tipo SisEmpresa
     * @return sisEmpresaTO Un objeto tipo SisEmpresaTO
     */
    public static SisEmpresaTO ConvertirSisEmpresa_SisEmpresaTO(SisEmpresa sisEmpresa) {

        SisEmpresaTO sisEmpresaTO = new SisEmpresaTO();
        sisEmpresaTO.setEmpCodigo(sisEmpresa.getEmpCodigo().trim());
        sisEmpresaTO.setEmpRuc(sisEmpresa.getEmpRuc().trim());
        sisEmpresaTO.setEmpNombre(sisEmpresa.getEmpNombre().trim());
        sisEmpresaTO.setEmpRazonSocial(sisEmpresa.getEmpRazonSocial().trim());
        sisEmpresaTO.setEmpDireccion(sisEmpresa.getEmpDireccion().trim());
        sisEmpresaTO.setEmpCiudad(sisEmpresa.getEmpCiudad());
        sisEmpresaTO.setEmpTelefono(sisEmpresa.getEmpTelefono().trim());
        sisEmpresaTO.setEmpFax(sisEmpresa.getEmpFax().trim());
        sisEmpresaTO.setEmpEmail(sisEmpresa.getEmpEmail().trim());
        //sisEmpresaTO.setEmpActiva(Boolean.FALSE);        
        sisEmpresaTO.setUsrFechaInsertaUsuario(sisEmpresa.getUsrFechaInsertaEmpresa());
        return sisEmpresaTO;
    }

    /**
     * @autor Misayo, Jack Krauser Metodo que convierte un objeto de tipo
     * SisEmpresaTO a SisEmpresa
     *
     * @param sisEmpresaTO Objeto de tipo sisEmpresaTO
     * @return sisEmpresa Devuelve un objeto de tipo SisEmpresa
     */
    public static SisEmpresa ConvertirSisEmpresaTO_SisEmpresa(SisEmpresaTO sisEmpresaTO) {
        SisEmpresa sisEmpresa = new SisEmpresa();
        sisEmpresa.setEmpCodigo(sisEmpresaTO.getEmpCodigo());
        sisEmpresa.setEmpRuc(sisEmpresaTO.getEmpRuc());
        sisEmpresa.setEmpNombre(sisEmpresaTO.getEmpNombre());
        sisEmpresa.setEmpRazonSocial(sisEmpresaTO.getEmpRazonSocial());
        sisEmpresa.setEmpDireccion(sisEmpresaTO.getEmpDireccion());
        sisEmpresa.setEmpCiudad(sisEmpresaTO.getEmpCiudad());
        //sisEmpresa.setEmpActividad(sisEmpresaTO.getParActividad());
        sisEmpresa.setEmpTelefono(sisEmpresaTO.getEmpTelefono());
        sisEmpresa.setEmpFax(sisEmpresaTO.getEmpFax());
        sisEmpresa.setEmpEmail(sisEmpresaTO.getEmpEmail());
        sisEmpresa.setEmpClave(sisEmpresaTO.getEmpClave());
        sisEmpresa.setEmpLogo(sisEmpresaTO.getEmpLogo());

//        sisEmpresa.setEmpGerente(sisEmpresaTO.getEmpGerente());
//        sisEmpresa.setEmpTipoIdGerente(sisEmpresaTO.getEmpTipoIdGerente());
//        sisEmpresa.setEmpIdGerente(sisEmpresaTO.getEmpIdGerente());
//        sisEmpresa.setEmpContador(sisEmpresaTO.getEmpContador());
//        sisEmpresa.setEmpRucContador(sisEmpresaTO.getEmpRucContador());

        sisEmpresa.setEmpActiva(sisEmpresaTO.getEmpActiva());
        sisEmpresa.setUsrCodigo(sisEmpresaTO.getUsrInsertaUsuario());
        // sisEmpresa.setUsrInsertaEmpresa(sisEmpresaTO.getUsrInsertaUsuario());
        sisEmpresa.setUsrFechaInsertaEmpresa(sisEmpresaTO.getUsrFechaInsertaUsuario());
//        sisEmpresa.setEmpCodigo(sisEmpresa.getEmpCodigo().trim());
//        sisEmpresa.setEmpRuc(sisEmpresa.getEmpRuc().trim());
//        sisEmpresa.setEmpNombre(sisEmpresa.getEmpNombre().trim());
//        sisEmpresa.setEmpRazonSocial(sisEmpresa.getEmpRazonSocial().trim());
//        sisEmpresa.setEmpDireccion(sisEmpresa.getEmpDireccion().trim());
//        sisEmpresa.setEmpTelefono(sisEmpresa.getEmpTelefono().trim());
//        sisEmpresa.setEmpFax(sisEmpresa.getEmpFax().trim());
//        sisEmpresa.setEmpEmail(sisEmpresa.getEmpEmail().trim());
//        sisEmpresa.setEmpGerente(sisEmpresa.getEmpGerente().trim());
//        sisEmpresa.setEmpTipoIdGerente(sisEmpresa.getEmpTipoIdGerente());
//        sisEmpresa.setEmpIdGerente(sisEmpresa.getEmpIdGerente().trim());
//        sisEmpresa.setEmpContador(sisEmpresa.getEmpContador().trim());
        return sisEmpresa;
    }

    private static String obtenerDatoString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static List<SisEmpresaTO> convertirListaSisEmpresa_ListaSisEmpresaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;

            String emp_codigo = obtenerDatoString(array[0]);
            String emp_ruc = obtenerDatoString(array[1]);
            String emp_nombre = obtenerDatoString(array[2]);
            String emp_razon_social = obtenerDatoString(array[3]);
            String emp_direccion = obtenerDatoString(array[4]);
            String emp_ciudad = obtenerDatoString(array[5]);
            String emp_telefono = obtenerDatoString(array[6]);
            String emp_fax = obtenerDatoString(array[7]);
            String emp_email = obtenerDatoString(array[8]);
            String emp_clave = obtenerDatoString(array[9]);
            byte[] emp_logo;
            try {
                emp_logo = (byte[]) array[10];
            } catch (Exception e) {
                emp_logo = null;
            }
            String par_resolucion_contribuyente_especial = obtenerDatoString(array[11]);
            Boolean par_obligado_llevar_contabilidad = Boolean.valueOf(obtenerDatoString(array[12]));
            String par_gerente = obtenerDatoString(array[13]);
            Character par_gerente_tipo_id = obtenerDatoString(array[14]).charAt(0);
            String par_gerente_id = obtenerDatoString(array[15]);
            String par_contador = obtenerDatoString(array[16]);
            String par_contador_ruc = obtenerDatoString(array[17]);
            Boolean emp_activa = Boolean.valueOf(obtenerDatoString(array[18]));
            String usr_codigo = obtenerDatoString(array[19]);
            Date usr_fecha_inserta_empresa = new Date(Timestamp.valueOf(obtenerDatoString(array[20])).getTime());
            String par_actividad = obtenerDatoString(array[21]);
            String par_escoger_precio_por = obtenerDatoString(array[22]);
            String parFinanciero = obtenerDatoString(array[23]);
            String parFinancieroId = obtenerDatoString(array[24]);
            short parColumnasEstadosFinancieros = Short.valueOf(obtenerDatoString(array[25]));
            String parCodigoDinardap = obtenerDatoString(array[26]);

            lista.add(
                    new SisEmpresaTO(
                    emp_codigo,
                    emp_ruc,
                    emp_nombre,
                    emp_razon_social,
                    emp_direccion,
                    emp_ciudad,
                    emp_telefono,
                    emp_fax,
                    emp_email,
                    emp_clave,
                    emp_logo,
                    par_resolucion_contribuyente_especial,
                    par_obligado_llevar_contabilidad,
                    par_gerente,
                    par_gerente_tipo_id,
                    par_gerente_id,
                    par_contador,
                    par_contador_ruc,
                    emp_activa,
                    usr_codigo,
                    usr_fecha_inserta_empresa,
                    par_actividad,
                    par_escoger_precio_por, parFinanciero, parFinancieroId, parColumnasEstadosFinancieros, parCodigoDinardap));
        }
        return lista;
    }

    /**
     * @autor Misayo, Jack Krauser Metodo que convierte una lista de objetos
     * SisEmpresa a una lista de objetos de tipo SisEmpresaTO
     *
     * @param datos
     * @return
     */
    public static List<SisListaEmpresaTO> convertirListaSisLoginEmpresa_ListaSisLoginEmpresaTO(List datos) {
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String emp_codigo;//sis_empresa.emp_codigo, 
            try {
                emp_codigo = array[0].toString().trim();
            } catch (Exception e) {
                emp_codigo = null;
            }
            String emp_ruc;//emp_ruc, 
            try {
                emp_ruc = array[1].toString().trim();
            } catch (Exception e) {
                emp_ruc = null;
            }
            String emp_razon_social;//emp_razon_social, 
            try {
                emp_razon_social = array[2].toString().trim();
            } catch (Exception e) {
                emp_razon_social = null;
            }
            String emp_nombre;//emp_nombre, 
            try {
                emp_nombre = array[3].toString().trim();
            } catch (Exception e) {
                emp_nombre = null;
            }
            String emp_direccion;//emp_direccion, 
            try {
                emp_direccion = array[4].toString().trim();
            } catch (Exception e) {
                emp_direccion = null;
            }
            String emp_telefono;//emp_telefono, 
            try {
                emp_telefono = array[5].toString().trim();
            } catch (Exception e) {
                emp_telefono = null;
            }
            String emp_ciudad;//emp_ciudad, 
            try {
                emp_ciudad = array[6].toString().trim();
            } catch (Exception e) {
                emp_ciudad = null;
            }
            String par_gerente;//par_gerente
            try {
                par_gerente = array[7].toString().trim();
            } catch (Exception e) {
                par_gerente = null;
            }
            String par_gerente_id;//par_gerente_id
            try {
                par_gerente_id = array[8].toString().trim();
            } catch (Exception e) {
                par_gerente_id = null;
            }
            String emp_contador;//par_contador
            try {
                emp_contador = array[9].toString().trim();
            } catch (Exception e) {
                emp_contador = null;
            }
            String emp_contador_ruc;//par_contador_ruc
            try {
                emp_contador_ruc = array[10].toString().trim();
            } catch (Exception e) {
                emp_contador_ruc = null;
            }
            String par_actividad;//par_actividad
            try {
                par_actividad = array[11].toString().trim();
            } catch (Exception e) {
                par_actividad = null;
            }
            String par_escoger_precio_por;//par_escoger_precio_por
            try {
                par_escoger_precio_por = array[12].toString().trim();
            } catch (Exception e) {
                par_escoger_precio_por = null;
            }
            Boolean par_obligado_llevar_contabilidad;//par_obligado_llevar_contabilidad
            try {
                par_obligado_llevar_contabilidad = Boolean.parseBoolean(array[13].toString().trim());
            } catch (Exception e) {
                par_obligado_llevar_contabilidad = null;
            }
            String det_equipo;//det_equipo
            try {
                det_equipo = array[14].toString().trim();
            } catch (Exception e) {
                det_equipo = null;
            }
            String par_resolucion_contribuyente_especia;//par_resolucion_contribuyente_especial
            try {
                par_resolucion_contribuyente_especia = array[15].toString().trim();
            } catch (Exception e) {
                par_resolucion_contribuyente_especia = null;
            }
            String emp_email;//emp_email
            try {
                emp_email = array[16].toString().trim();
            } catch (Exception e) {
                emp_email = null;
            }
            String emp_clave;//emp_clave
            try {
                emp_clave = array[17].toString().trim();
            } catch (Exception e) {
                emp_clave = null;
            }
            String par_web_documentos_electronicos;//emp_clave
            try {
                par_web_documentos_electronicos = array[18].toString().trim();
            } catch (Exception e) {
                par_web_documentos_electronicos = null;
            }

            lista.add(new SisListaEmpresaTO(
                    emp_codigo,
                    emp_ruc,
                    emp_razon_social,
                    emp_nombre,
                    emp_direccion,
                    emp_telefono,
                    emp_ciudad,
                    par_gerente,
                    par_gerente_id,
                    emp_contador,
                    emp_contador_ruc,
                    par_actividad,
                    par_escoger_precio_por,
                    par_obligado_llevar_contabilidad,
                    det_equipo,
                    par_resolucion_contribuyente_especia,
                    emp_email,
                    emp_clave,
                    par_web_documentos_electronicos));
        }
        return lista;
    }

    /**
     * @autor Misayo Metodo que convierte una lista de objetos de tipo
     * SisPermiso a una lista de objetos de tipo SisPermisoTO
     *
     * @param datos Una lista de objetos
     * @return lista La lista de objetos
     */
    public static List<SisListaLoginPermisoTO> convertirListaSisPermiso_ListaSisPermisoTO(List datos) {
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString().trim();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString().trim();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString().trim();
            } catch (Exception e) {
                dato3 = null;
            }
            Boolean dato4;
            try {
                dato4 = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                dato4 = null;
            }
            lista.add(new SisListaLoginPermisoTO(dato1, dato2, dato3, dato4));
        }
        return lista;
    }

    public static SisSuceso ConvertirSisSucesoTO_SisSuceso(SisSucesoTO sisSucesoTO) {
        /*
         *
         *
         *
         *
         *
         * inf_mac character(17) NOT NULL,
         *
         * sus_fecha timestamp without time zone NOT NULL, CONSTRAINT
         * sis_suceso_pk PRIMARY KEY (sus_secuencia ), CONSTRAINT
         * sis_usuario_detalle_fk FOREIGN KEY (det_empresa, det_usuario)
         * REFERENCES sistemaweb.sis_usuario_detalle (det_empresa, det_usuario)
         * MATCH SIMPLE
         */

        /*
         * sus_secuencia serial NOT NULL,/// sus_tabla character(50) NOT NULL,//
         * sus_clave character(50) NOT NULL,// sus_suceso character(10) NOT
         * NULL,/// sus_detalle character(300),/// inf_mac character(17) NOT
         * NULL, emp_codigo character(7) NOT NULL,//--- usr_codigo character(7)
         * NOT NULL,//--- sus_fecha timestamp without time zone NOT NULL,
         * CONSTRAINT sis_suceso_pk PRIMARY KEY (sus_secuencia )
         */
        SisSuceso sisSuceso = new SisSuceso();
        sisSuceso.setSusSecuencia(sisSucesoTO.getSusSecuencia());
        sisSuceso.setSusTabla(sisSucesoTO.getSusTabla());
        sisSuceso.setSusClave(sisSucesoTO.getSusClave());
        sisSuceso.setSusSuceso(sisSucesoTO.getSusSuceso());
        sisSuceso.setSusDetalle(sisSucesoTO.getSusDetalle());
        sisSuceso.setSisUsuarioDetalle(new SisUsuarioDetalle(new SisUsuarioDetallePK(sisSucesoTO.getUsrEmpresa(), sisSucesoTO.getUsrCodigo())));
        //new SisPeriodoPK(sisPeriodoTO.getPerEmpresa(), sisPeriodoTO.getPerCodigo())
        //sisPeriodo.setSisPeriodoPK(new SisPeriodoPK(sisPeriodoTO.getPerEmpresa(), sisPeriodoTO.getPerCodigo()));
        /*
         * sisSuceso.setUsrCodigo(sisSucesoTO.getUsrCodigo());
         * sisSuceso.setEmpCodigo(sisSucesoTO.getUsrEmpresa())
         */;

        sisSuceso.setSusFecha(Validacion.fechaString_Date(sisSucesoTO.getSusFecha()));
        return sisSuceso;
    }

    public static List<SisGrupoTO> convertirListaSisGrupo_ListaSisGrupoTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String gruEmpresa;
            try {
                gruEmpresa = array[0].toString().trim();
            } catch (Exception e) {
                gruEmpresa = null;
            }
            String gruCodigo;
            try {
                gruCodigo = array[1].toString().trim();
            } catch (Exception e) {
                gruCodigo = null;
            }
            String gruNombre;
            try {
                gruNombre = array[2].toString().trim();
            } catch (Exception e) {
                gruNombre = null;
            }
            Boolean gruCrear;
            try {
                gruCrear = Boolean.valueOf(array[3].toString());
            } catch (Exception e) {
                gruCrear = null;
            }
            Boolean gruModificar;
            try {
                gruModificar = Boolean.valueOf(array[4].toString());
            } catch (Exception e) {
                gruModificar = null;
            }
            Boolean gruEliminar;
            try {
                gruEliminar = Boolean.valueOf(array[5].toString());
            } catch (Exception e) {
                gruEliminar = null;
            }
            Boolean gruConfigurar;
            try {
                gruConfigurar = Boolean.valueOf(array[6].toString());
            } catch (Exception e) {
                gruConfigurar = null;
            }
            Boolean gruImprimir;
            try {
                gruImprimir = Boolean.valueOf(array[7].toString());
            } catch (Exception e) {
                gruImprimir = null;
            }

            Boolean gruExportar;
            try {
                gruExportar = Boolean.valueOf(array[8].toString());
            } catch (Exception e) {
                gruExportar = null;
            }

            Boolean gruDesmayorizarCompras;
            try {
                gruDesmayorizarCompras = Boolean.parseBoolean(array[9].toString());
            } catch (Exception e) {
                gruDesmayorizarCompras = null;
            }
            Boolean gruDesmayorizarVentas;
            try {
                gruDesmayorizarVentas = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                gruDesmayorizarVentas = null;
            }
            Boolean gruDesmayorizarConsumos;
            try {
                gruDesmayorizarConsumos = Boolean.parseBoolean(array[11].toString());
            } catch (Exception e) {
                gruDesmayorizarConsumos = null;
            }
            Boolean gruDesmayorizarTransferencias;
            try {
                gruDesmayorizarTransferencias = Boolean.parseBoolean(array[12].toString());
            } catch (Exception e) {
                gruDesmayorizarTransferencias = null;
            }
            Boolean gruDesmayorizarContables;
            try {
                gruDesmayorizarContables = Boolean.parseBoolean(array[13].toString());
            } catch (Exception e) {
                gruDesmayorizarContables = null;
            }

            Boolean gruAnularCompras;
            try {
                gruAnularCompras = Boolean.valueOf(array[14].toString());
            } catch (Exception e) {
                gruAnularCompras = null;
            }

            Boolean gruAnularVentas;
            try {
                gruAnularVentas = Boolean.valueOf(array[15].toString());
            } catch (Exception e) {
                gruAnularVentas = null;
            }

            Boolean gruAnularConsumos;
            try {
                gruAnularConsumos = Boolean.valueOf(array[16].toString());
            } catch (Exception e) {
                gruAnularConsumos = null;
            }

            Boolean gruAnularTransferencias;
            try {
                gruAnularTransferencias = Boolean.valueOf(array[17].toString());
            } catch (Exception e) {
                gruAnularTransferencias = null;
            }
            Boolean gruAnularContables;
            try {
                gruAnularContables = Boolean.valueOf(array[18].toString());
            } catch (Exception e) {
                gruAnularContables = null;
            }

            String empCodigo;
            try {
                empCodigo = array[29].toString().trim();
            } catch (Exception e) {
                empCodigo = null;
            }
            String usrInsertaGrupo;
            try {
                usrInsertaGrupo = array[20].toString().trim();
            } catch (Exception e) {
                usrInsertaGrupo = null;
            }
            Date usrFechaInsertaGrupo;
            try {
                usrFechaInsertaGrupo = new Date(array[21].toString().trim());
            } catch (Exception e) {
                usrFechaInsertaGrupo = null;
            }

            lista.add(new SisGrupoTO(
                    gruEmpresa,
                    gruCodigo,
                    gruNombre,
                    gruCrear,
                    gruModificar,
                    gruEliminar,
                    gruConfigurar,
                    gruImprimir,
                    gruExportar,
                    gruDesmayorizarCompras,
                    gruDesmayorizarVentas,
                    gruDesmayorizarConsumos,
                    gruDesmayorizarTransferencias,
                    gruDesmayorizarContables,
                    gruAnularCompras,
                    gruAnularVentas,
                    gruAnularConsumos,
                    gruAnularTransferencias,
                    gruAnularContables,
                    empCodigo,
                    usrInsertaGrupo,
                    usrFechaInsertaGrupo));
        }
        return lista;
    }

    public static List<SisGrupoTO> convertirGetSisGrupos_GetSisGrupoTOs(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String gruCodigo;
            try {
                gruCodigo = array[0].toString().trim();
            } catch (Exception e) {
                gruCodigo = null;
            }
            String gruNombre;
            try {
                gruNombre = array[1].toString().trim();
            } catch (Exception e) {
                gruNombre = null;
            }
            SisGrupoTO sisGrupoTO = new SisGrupoTO();
            sisGrupoTO.setGruCodigo(gruCodigo);
            sisGrupoTO.setGruNombre(gruNombre);
            lista.add(sisGrupoTO);
        }
        return lista;
    }

    public static List<SisConsultaUsuarioGrupoTO> convertirTOSisUsuarioTO_ListaSisUsuario(List datos) {
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String usrCodigo;
            try {
                usrCodigo = array[0].toString().trim();
            } catch (Exception e) {
                usrCodigo = null;
            }
            String usrNick;
            try {
                usrNick = array[1].toString().trim();
            } catch (Exception e) {
                usrNick = null;
            }
            String usrNombre;
            try {
                usrNombre = array[2].toString().trim();
            } catch (Exception e) {
                usrNombre = null;
            }
            String usrApellido;
            try {
                usrApellido = array[3].toString().trim();
            } catch (Exception e) {
                usrApellido = null;
            }
            String usrPassword;
            try {
                usrPassword = array[4].toString().trim();
            } catch (Exception e) {
                usrPassword = null;
            }
            String usrCaduca;
            try {
                usrCaduca = array[5].toString().trim();
            } catch (Exception e) {
                usrCaduca = null;
            }
            Boolean usrActivo;
            try {
                usrActivo = Boolean.parseBoolean(array[6].toString());
            } catch (Exception e) {
                usrActivo = null;
            }
            Boolean usrCambiarContrasenia;
            try {
                usrCambiarContrasenia = Boolean.parseBoolean(array[7].toString());
            } catch (Exception e) {
                usrCambiarContrasenia = null;
            }
            String usrCodigoInserta;
            try {
                usrCodigoInserta = array[8].toString().trim();
            } catch (Exception e) {
                usrCodigoInserta = null;
            }
            String usrFechaInsertaUsuario;
            try {
                usrFechaInsertaUsuario = array[9].toString().trim();
            } catch (Exception e) {
                usrFechaInsertaUsuario = null;
            }
            String gruCodigo;
            try {
                gruCodigo = array[10].toString().trim();
            } catch (Exception e) {
                gruCodigo = null;
            }
            lista.add(new SisConsultaUsuarioGrupoTO(
                    usrCodigo,
                    usrNick,
                    usrNombre,
                    usrApellido,
                    usrPassword,
                    usrCaduca,
                    usrActivo,
                    usrCambiarContrasenia,
                    usrCodigoInserta,
                    usrFechaInsertaUsuario,
                    gruCodigo));
        }

        return lista;
    }

    public static List<SisPermisoTO> convertirSisListaPermiso_SisListaPermisoTO(List datos) {
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            Integer dato5;
            try {
                dato5 = Integer.valueOf(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            Boolean dato7;
            try {
                dato7 = Boolean.parseBoolean(array[6].toString());
            } catch (Exception e) {
                dato7 = null;
            }
            lista.add(new SisPermisoTO("", dato1, dato2, dato3, dato4, dato5, dato6, dato7, ""));
        }
        return lista;
    }

    public static SisPcs ConvertirSisPcs_SisPcs(SisPcs sisPcs, SisReporteTO sisReporteTO) {
        SisPcs sisPcsAux = new SisPcs();
        sisPcsAux.setInfMac(sisPcs.getInfMac());
        sisPcsAux.setInfIp(sisPcs.getInfIp());
        sisPcsAux.setInfNombre(sisPcs.getInfNombre());
        sisPcsAux.setInfDescripcion(sisPcs.getInfDescripcion());
        if (sisReporteTO == null) {
            sisPcsAux.setInfReporteRutaDefault(sisPcs.getInfReporteRutaDefault());
            sisPcsAux.setInfReporteFactura(sisPcs.getInfReporteFactura());
            sisPcsAux.setInfReporteNotaCredito(sisPcs.getInfReporteNotaCredito());
            sisPcsAux.setInfReporteLiquidacion(sisPcs.getInfReporteLiquidacion());
            sisPcsAux.setInfReporteRetencion(sisPcs.getInfReporteRetencion());
            sisPcsAux.setInfReporteGuiaRemision(sisPcs.getInfReporteGuiaRemision());
        } else {
            sisPcsAux.setInfReporteRutaDefault(sisReporteTO.getReporteRutaDefault() == null ? sisPcs.getInfReporteRutaDefault() : sisReporteTO.getReporteRutaDefault());
            sisPcsAux.setInfReporteFactura(sisReporteTO.getReporteFactura() == null ? sisPcs.getInfReporteFactura() : sisReporteTO.getReporteFactura());
            sisPcsAux.setInfReporteNotaCredito(sisReporteTO.getReporteNotaCredito() == null ? sisPcs.getInfReporteNotaCredito() : sisReporteTO.getReporteNotaCredito());
            sisPcsAux.setInfReporteLiquidacion(sisReporteTO.getReporteLiquidacion() == null ? sisPcs.getInfReporteLiquidacion() : sisReporteTO.getReporteLiquidacion());
            sisPcsAux.setInfReporteRetencion(sisReporteTO.getReporteRetencion() == null ? sisPcs.getInfReporteRetencion() : sisReporteTO.getReporteRetencion());
            sisPcsAux.setInfReporteGuiaRemision(sisReporteTO.getReporteGuiaRemision() == null ? sisPcs.getInfReporteGuiaRemision() : sisReporteTO.getReporteGuiaRemision());
        }
        sisPcsAux.setInfEstado(sisPcs.getInfEstado());
        sisPcsAux.setUsrCodigo(sisPcs.getUsrCodigo());
        sisPcsAux.setUsrFechaInsertaPc(sisPcs.getUsrFechaInsertaPc());
        return sisPcsAux;
    }

    public static SisReporteTO ConvertirSisReporte_SisReporteTO(List datos) {
        SisReporteTO sisReporteTO = new SisReporteTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String reporteRutaDefault;
            try {
                reporteRutaDefault = array[0].toString();
            } catch (Exception e) {
                reporteRutaDefault = null;
            }
            String reporteFactura;
            try {
                reporteFactura = array[1].toString();
            } catch (Exception e) {
                reporteFactura = null;
            }
            String reporteNotaCredito;
            try {
                reporteNotaCredito = array[2].toString();
            } catch (Exception e) {
                reporteNotaCredito = null;
            }
            String reporteLiquidacion;
            try {
                reporteLiquidacion = array[3].toString();
            } catch (Exception e) {
                reporteLiquidacion = null;
            }
            String reporteRetencion;
            try {
                reporteRetencion = array[4].toString();
            } catch (Exception e) {
                reporteRetencion = null;
            }
            String reporteGuiaRemision;
            try {
                reporteGuiaRemision = array[5].toString();
            } catch (Exception e) {
                reporteGuiaRemision = null;
            }
            sisReporteTO = new SisReporteTO(
                    reporteRutaDefault,
                    reporteFactura,
                    reporteNotaCredito,
                    reporteLiquidacion,
                    reporteRetencion,
                    reporteGuiaRemision);
        }
        return sisReporteTO;
    }

    public static SisGrupoTO ConvertirSisGrupo_SisGrupoTO(List datos) {
        SisGrupoTO sisGrupoTO = new SisGrupoTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String gru_empresa;
            try {
                gru_empresa = array[0].toString();
            } catch (Exception e) {
                gru_empresa = null;
            }
            String gru_codigo;
            try {
                gru_codigo = array[1].toString();
            } catch (Exception e) {
                gru_codigo = null;
            }
            String gru_nombre;
            try {
                gru_nombre = array[2].toString();
            } catch (Exception e) {
                gru_nombre = null;
            }
            Boolean gru_crear;
            try {
                gru_crear = Boolean.parseBoolean(array[3].toString());
            } catch (Exception e) {
                gru_crear = null;
            }
            Boolean gru_modificar;
            try {
                gru_modificar = Boolean.parseBoolean(array[4].toString());
            } catch (Exception e) {
                gru_modificar = null;
            }
            Boolean gru_eliminar;
            try {
                gru_eliminar = Boolean.parseBoolean(array[5].toString());
            } catch (Exception e) {
                gru_eliminar = null;
            }
            Boolean gru_configurar;
            try {
                gru_configurar = Boolean.parseBoolean(array[6].toString());
            } catch (Exception e) {
                gru_configurar = null;
            }
            Boolean gru_imprimir;
            try {
                gru_imprimir = Boolean.parseBoolean(array[7].toString());
            } catch (Exception e) {
                gru_imprimir = null;
            }
            Boolean gru_exportar;
            try {
                gru_exportar = Boolean.parseBoolean(array[8].toString());
            } catch (Exception e) {
                gru_exportar = null;
            }
            Boolean gru_desmayorizar_compras;
            try {
                gru_desmayorizar_compras = Boolean.parseBoolean(array[9].toString());
            } catch (Exception e) {
                gru_desmayorizar_compras = null;
            }
            Boolean gru_desmayorizar_ventas;
            try {
                gru_desmayorizar_ventas = Boolean.parseBoolean(array[10].toString());
            } catch (Exception e) {
                gru_desmayorizar_ventas = null;
            }
            Boolean gru_desmayorizar_consumos;
            try {
                gru_desmayorizar_consumos = Boolean.parseBoolean(array[11].toString());
            } catch (Exception e) {
                gru_desmayorizar_consumos = null;
            }
            Boolean gru_desmayorizar_transferencias;
            try {
                gru_desmayorizar_transferencias = Boolean.parseBoolean(array[12].toString());
            } catch (Exception e) {
                gru_desmayorizar_transferencias = null;
            }
            Boolean gru_desmayorizar_contables;
            try {
                gru_desmayorizar_contables = Boolean.parseBoolean(array[13].toString());
            } catch (Exception e) {
                gru_desmayorizar_contables = null;
            }
            Boolean gru_anular_compras;
            try {
                gru_anular_compras = Boolean.parseBoolean(array[14].toString());
            } catch (Exception e) {
                gru_anular_compras = null;
            }
            Boolean gru_anular_ventas;
            try {
                gru_anular_ventas = Boolean.parseBoolean(array[15].toString());
            } catch (Exception e) {
                gru_anular_ventas = null;
            }
            Boolean gru_anular_consumos;
            try {
                gru_anular_consumos = Boolean.parseBoolean(array[16].toString());
            } catch (Exception e) {
                gru_anular_consumos = null;
            }
            Boolean gru_anular_transferencias;
            try {
                gru_anular_transferencias = Boolean.parseBoolean(array[17].toString());
            } catch (Exception e) {
                gru_anular_transferencias = null;
            }
            Boolean gru_anular_contables;
            try {
                gru_anular_contables = Boolean.parseBoolean(array[18].toString());
            } catch (Exception e) {
                gru_anular_contables = null;
            }
            sisGrupoTO.setGruEmpresa(gru_empresa);
            sisGrupoTO.setGruCodigo(gru_codigo);
            sisGrupoTO.setGruNombre(gru_nombre);
            sisGrupoTO.setGruCrear(gru_crear);
            sisGrupoTO.setGruModificar(gru_modificar);
            sisGrupoTO.setGruEliminar(gru_eliminar);
            sisGrupoTO.setGruConfigurar(gru_configurar);
            sisGrupoTO.setGruImprimir(gru_imprimir);
            sisGrupoTO.setGruExportar(gru_exportar);
            sisGrupoTO.setGruDesmayorizarCompras(gru_desmayorizar_compras);
            sisGrupoTO.setGruDesmayorizarVentas(gru_desmayorizar_ventas);
            sisGrupoTO.setGruDesmayorizarConsumos(gru_desmayorizar_consumos);
            sisGrupoTO.setGruDesmayorizarTransferencias(gru_desmayorizar_transferencias);
            sisGrupoTO.setGruDesmayorizarContables(gru_desmayorizar_contables);
            sisGrupoTO.setGruAnularCompras(gru_anular_compras);
            sisGrupoTO.setGruAnularVentas(gru_anular_ventas);
            sisGrupoTO.setGruAnularConsumos(gru_anular_consumos);
            sisGrupoTO.setGruAnularTransferencias(gru_anular_transferencias);
            sisGrupoTO.setGruAnularContables(gru_anular_contables);
        }
        return sisGrupoTO;
    }
    //si funciona, reemplazar despues de terminar formulario grupo
//    public static SisGrupoTO ConvertirSisGrupo_SisGrupoTO(SisGrupo sisGrupo){
//        SisGrupoTO sisGrupoTO = new SisGrupoTO();
//        sisGrupoTO.setGruEmpresa(sisGrupo.getSisGrupoPK().getGruEmpresa());
//        sisGrupoTO.setGruCodigo(sisGrupo.getSisGrupoPK().getGruCodigo());
//        sisGrupoTO.setGruNombre(sisGrupo.getGruNombre());
//        sisGrupoTO.setGruCrear(sisGrupo.getGruCrear());
//        sisGrupoTO.setGruModificar(sisGrupo.getGruModificar());
//        sisGrupoTO.setGruEliminar(sisGrupo.getGruEliminar());
//        sisGrupoTO.setGruConfigurar(sisGrupo.getGruConfigurar());
//        sisGrupoTO.setGruImprimir(sisGrupo.getGruImprimir());
//        sisGrupoTO.setGruExportar(sisGrupo.getGruExportar());
//        sisGrupoTO.setGruDesmayorizarCompras(sisGrupo.getGruDesmayorizarCompras());
//        sisGrupoTO.setGruDesmayorizarVentas(sisGrupo.getGruDesmayorizarVentas());
//        sisGrupoTO.setGruDesmayorizarConsumos(sisGrupo.getGruDesmayorizarConsumos());
//        sisGrupoTO.setGruDesmayorizarTransferencias(sisGrupo.getGruDesmayorizarTransferencias());
//        sisGrupoTO.setGruDesmayorizarContables(sisGrupo.getGruDesmayorizarContables());
//        sisGrupoTO.setGruAnularCompras(sisGrupo.getGruAnularCompras());
//        sisGrupoTO.setGruAnularVentas(sisGrupo.getGruAnularVentas());
//        sisGrupoTO.setGruAnularConsumos(sisGrupo.getGruAnularConsumos());
//        sisGrupoTO.setGruAnularTransferencias(sisGrupo.getGruAnularTransferencias());
//        sisGrupoTO.setGruAnularContables(sisGrupo.getGruAnularContables());
////        sisGrupoTO.setEmpCodigo(sisGrupo.getSisEmpresa().getEmpCodigo());
////        sisGrupoTO.setUsrInsertaGrupo(sisGrupo.getSisUsuarioList().get(0).getUsrCaduca().toString());
//        return sisGrupoTO;
//    }

    public static SisUsuario ConvertirSisUsuarioTO_SisUsuario(SisUsuarioTO sisUsuarioTO) {
        SisUsuario sisUsuario = new SisUsuario();
        sisUsuario.setUsrCodigo(sisUsuarioTO.getUsrCodigo());
        sisUsuario.setUsrNick(sisUsuarioTO.getUsrNick());
        sisUsuario.setUsrNombre(sisUsuarioTO.getUsrNombre());
        sisUsuario.setUsrApellido(sisUsuarioTO.getUsrApellido());
        sisUsuario.setUsrPassword(sisUsuarioTO.getUsrPassword());
        sisUsuario.setUsrCaduca(Validacion.fechaString_Date(sisUsuarioTO.getUsrCaduca()));
        sisUsuario.setUsrActivo(sisUsuarioTO.getUsrActivo());
        
        sisUsuario.setUsrCambiarContrasenia(sisUsuarioTO.getUsrCambiarContrasenia());
        sisUsuario.setUsrCodigoInserta(sisUsuarioTO.getUsrInsertaUsuario());
        sisUsuario.setUsrFechaInsertaUsuario(Validacion.fechaString_Date(sisUsuarioTO.getUsrFechaInsertaUsuario()));
        return sisUsuario;
    }

    public static SisError ConvertirSisErrorTO_SisError(SisErrorTO sisErrorTO) {
        SisError sisError = new SisError();
        sisError.setErSecuencia(sisErrorTO.getErSecuencia());
        sisError.setErSentencia(sisErrorTO.getErSentencia());
        sisError.setErClase(sisErrorTO.getErClase());
        sisError.setErArchivo(sisErrorTO.getErArchivo());
        sisError.setErLinea(sisErrorTO.getErLinea());
        sisError.setErMetodo(sisErrorTO.getErMetodo());
        sisError.setErMac(sisErrorTO.getInfMac());
        sisError.setSisUsuarioDetalle(new SisUsuarioDetalle(new SisUsuarioDetallePK(sisErrorTO.getEmpCodigo(), sisErrorTO.getUsrCodigo())));
        sisError.setErFecha(Validacion.fechaString_Date(sisErrorTO.getErFecha()));
        return sisError;
    }

    public static SisPeriodo ConvertirSisPeriodoTO_SisPeriodo(SisPeriodoTO sisPeriodoTO) {
        SisPeriodo sisPeriodo = new SisPeriodo();
        sisPeriodo.setSisPeriodoPK(new SisPeriodoPK(sisPeriodoTO.getPerEmpresa(), sisPeriodoTO.getPerCodigo()));
        sisPeriodo.setPerDetalle(sisPeriodoTO.getPerDetalle());
        sisPeriodo.setPerDesde(Validacion.fecha(sisPeriodoTO.getPerDesde(), "yyyy-MM-dd"));
        sisPeriodo.setPerHasta(Validacion.fecha(sisPeriodoTO.getPerHasta(), "yyyy-MM-dd"));
        sisPeriodo.setPerCerrado(sisPeriodoTO.getPerCerrado());
        sisPeriodo.setEmpCodigo(new SisEmpresa(sisPeriodoTO.getEmpCodigo()));
        sisPeriodo.setUsrCodigo(sisPeriodoTO.getUsrInsertaPeriodo());
        sisPeriodo.setUsrFechaInsertaPeriodo(Validacion.fechaString_Date(sisPeriodoTO.getUsrFechaInsertaPeriodo()));
        return sisPeriodo;
    }

    public static List<SisListaPeriodoTO> convertirListaSisPeriodo_ListaSisPeriodoTO(List datos) {
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            Boolean dato5;
            try {
                dato5 = Boolean.parseBoolean(array[4].toString());
            } catch (Exception e) {
                dato5 = null;
            }
            lista.add(new SisListaPeriodoTO(dato1, dato2, dato3, dato4, dato5));
        }
        return lista;
    }

    public static List<SisComboPeriodoTO> convertirSisComboPeriodo_SisComboPeriodoTO(List datos) {
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            lista.add(new SisComboPeriodoTO(dato1, dato2));
        }
        return lista;
    }

    public static SisGrupo ConvertirSisGrupoTO_SisGrupo(SisGrupoTO sisGrupoTO) {
        SisGrupo sisGrupo = new SisGrupo();
        sisGrupo.setSisGrupoPK(new SisGrupoPK(sisGrupoTO.getGruEmpresa(), sisGrupoTO.getGruCodigo()));
        sisGrupo.setGruNombre(sisGrupoTO.getGruNombre());
        sisGrupo.setGruCrear(sisGrupoTO.getGruCrear());
        sisGrupo.setGruModificar(sisGrupoTO.getGruModificar());
        sisGrupo.setGruImprimir(sisGrupoTO.getGruImprimir());
        sisGrupo.setGruExportar(sisGrupoTO.getGruExportar());
        sisGrupo.setGruAnularCompras(sisGrupoTO.getGruAnularCompras());
        sisGrupo.setGruAnularConsumos(sisGrupoTO.getGruAnularConsumos());
        sisGrupo.setGruAnularContables(sisGrupoTO.getGruAnularContables());
        sisGrupo.setGruAnularTransferencias(sisGrupoTO.getGruAnularTransferencias());
        sisGrupo.setGruAnularVentas(sisGrupoTO.getGruAnularVentas());
        sisGrupo.setGruConfigurar(sisGrupoTO.getGruConfigurar());
        sisGrupo.setGruEliminar(sisGrupoTO.getGruEliminar());
        sisGrupo.setGruDesmayorizarCompras(sisGrupoTO.getGruDesmayorizarCompras());
        sisGrupo.setGruDesmayorizarConsumos(sisGrupoTO.getGruDesmayorizarConsumos());
        sisGrupo.setGruDesmayorizarContables(sisGrupoTO.getGruDesmayorizarContables());
        sisGrupo.setGruDesmayorizarTransferencias(sisGrupoTO.getGruDesmayorizarTransferencias());
        sisGrupo.setGruDesmayorizarVentas(sisGrupoTO.getGruDesmayorizarVentas());
        sisGrupo.setUsrInsertaGrupo(sisGrupoTO.getUsrInsertaGrupo());
        sisGrupo.setUsrFechaInsertaGrupo(sisGrupoTO.getUsrFechaInsertaGrupo());
        return sisGrupo;
    }

    public static List<SisListaUsuarioTO> convertirListaSisUsuarios_ListaSisUsuariosTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            lista.add(new SisListaUsuarioTO(dato1, dato2, dato3));
        }
        return lista;
    }

    public static List<SisSucesoTO> convertirListaSisSuceso_ListaSisSucesoTO(List datos) {
        /*
         * sus_fecha
         */
        List lista = new ArrayList(1);
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            Integer dato1;//sus_secuencia
            try {
                dato1 = new Integer(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;//sus_tabla
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;// sus_clave
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;//  sus_suceso
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;// sus_detalle
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;// sus_mac
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;//det_empresa
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;// det_usuario
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;// det_usuario
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }


            lista.add(new SisSucesoTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9));
        }
        return lista;
    }

    public static List<SisErrorTO> convertirListaSisError_ListaSisErrorTO(List datos) {
        List lista = new ArrayList(1);
        /*
         * private Integer erSecuencia; private String erSentencia; private
         * String erClase; private String erArchivo; private String erLinea;
         * private String erMetodo; private String infMac; private String
         * empCodigo; private String usrCodigo; private String erFecha;
         */

        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            Integer dato1;
            try {
                dato1 = new Integer(array[0].toString());
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }
            String dato3;
            try {
                dato3 = array[2].toString();
            } catch (Exception e) {
                dato3 = null;
            }
            String dato4;
            try {
                dato4 = array[3].toString();
            } catch (Exception e) {
                dato4 = null;
            }
            String dato5;
            try {
                dato5 = array[4].toString();
            } catch (Exception e) {
                dato5 = null;
            }
            String dato6;
            try {
                dato6 = array[5].toString();
            } catch (Exception e) {
                dato6 = null;
            }
            String dato7;
            try {
                dato7 = array[6].toString();
            } catch (Exception e) {
                dato7 = null;
            }
            String dato8;
            try {
                dato8 = array[7].toString();
            } catch (Exception e) {
                dato8 = null;
            }
            String dato9;
            try {
                dato9 = array[8].toString();
            } catch (Exception e) {
                dato9 = null;
            }
            String dato10;
            try {
                dato10 = array[9].toString();
            } catch (Exception e) {
                dato10 = null;
            }
            lista.add(new SisErrorTO(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, dato9, dato10));
        }
        return lista;
    }

    public static List<SisListaUsuarioTO> convertirListaUsuario_ListaUsuarioTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String usrCodigo;
            try {
                usrCodigo = array[0].toString();
            } catch (Exception e) {
                usrCodigo = null;
            }
            String usrNombre;
            try {
                usrNombre = array[1].toString();
            } catch (Exception e) {
                usrNombre = null;
            }
            String usrApellido;
            try {
                usrApellido = array[2].toString();
            } catch (Exception e) {
                usrApellido = null;
            }
            lista.add(new SisListaUsuarioTO(usrCodigo, usrNombre, usrApellido));
        }
        return lista;
    }

    public static List<SisListaSusTablaTO> convertirListaSusTabla_ListaSusTablaTO(List datos) {
        List lista = new ArrayList(1);//interface que extiende de array list, recibe parametros de dimencion
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {//clase iteracion(no todo se puede iterar, solo listas)
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }

            lista.add(new SisListaSusTablaTO(dato1));
        }
        return lista;
    }

    public static SisPckeystoreTO ConvertirSisPckeystore_SisPckeystoreTO(List datos) {
        SisPckeystoreTO sisPckeystoreTO = new SisPckeystoreTO();
        for (Iterator i$ = datos.iterator(); i$.hasNext();) {
            Object obj = i$.next();
            Object[] array = ((java.util.List) obj).toArray();
            //Object[] array = (Object[]) obj;
            String dato1;
            try {
                dato1 = array[0].toString();
            } catch (Exception e) {
                dato1 = null;
            }
            String dato2;
            try {
                dato2 = array[1].toString();
            } catch (Exception e) {
                dato2 = null;
            }

            sisPckeystoreTO = new SisPckeystoreTO(dato1, dato2);
        }
        return sisPckeystoreTO;
    }
}
