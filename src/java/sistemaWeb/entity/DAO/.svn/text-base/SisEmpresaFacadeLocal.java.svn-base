/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import sistemaWeb.entity.SisEmpresa;

/**
 *
 * @author developer1
 */
@Local
public interface SisEmpresaFacadeLocal {

    void create(SisEmpresa sisEmpresa);

    void edit(SisEmpresa sisEmpresa);

    void remove(SisEmpresa sisEmpresa);

    SisEmpresa find(Object id);

    List<SisEmpresa> findAll();

    List<SisEmpresa> findRange(int[] range);

    int count();
    
}
