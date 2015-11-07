/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import sistemaWeb.entity.SisError;

/**
 *
 * @author developer1
 */
@Local
public interface SisErrorFacadeLocal {

    void create(SisError sisError);

    void edit(SisError sisError);

    void remove(SisError sisError);

    SisError find(Object id);

    List<SisError> findAll();

    List<SisError> findRange(int[] range);

    int count();
    
}
