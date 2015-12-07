
package es.baseproject.ejb.service;

import javax.ejb.Local;
import es.baseproject.ejb.entities.Empresa;
import java.util.List;

@Local
public interface EmpresaInterface {
    
    public List<Empresa> list();
    public Empresa findById(Long idEmpresa);
}
