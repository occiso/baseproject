package es.baseproject.ejb.service;

import es.baseproject.ejb.entities.Empresa;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@Local(EmpresaInterface.class)
public class EmpresaService implements EmpresaInterface {
    
    @PersistenceContext(unitName = "hibernate-PU")
    EntityManager em;
    
    public List<Empresa> list(){
        //consulta tener en cuenta nombre de la tabla con entity (debe coincidir nombre)
        return em.createQuery("from Empresa e").getResultList();
    }
    
    public Empresa findById(Long idempresa){
        return em.find(Empresa.class, idempresa);
    }
    
    public void save(Empresa empresa){
        em.persist(empresa);
    }
}