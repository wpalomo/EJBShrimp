/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import sistemaWeb.entity.SisUsuario;

/**
 *
 * @author developer1
 */
@Local
public interface SisUsuarioFacadeLocal {

    void create(SisUsuario sisUsuario);

    void edit(SisUsuario sisUsuario);

    void remove(SisUsuario sisUsuario);

    SisUsuario find(Object id);

    List<SisUsuario> findAll();

    List<SisUsuario> findRange(int[] range);

    int count();
    
}
