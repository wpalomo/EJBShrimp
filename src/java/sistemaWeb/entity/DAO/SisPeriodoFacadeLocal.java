/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import sistemaWeb.entity.SisPeriodo;

/**
 *
 * @author developer1
 */
@Local
public interface SisPeriodoFacadeLocal {

    void create(SisPeriodo sisPeriodo);

    void edit(SisPeriodo sisPeriodo);

    void remove(SisPeriodo sisPeriodo);

    SisPeriodo find(Object id);

    List<SisPeriodo> findAll();

    List<SisPeriodo> findRange(int[] range);

    int count();
    
}
