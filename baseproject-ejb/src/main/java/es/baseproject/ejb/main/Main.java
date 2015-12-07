package es.baseproject.ejb.main;

import es.baseproject.ejb.entities.Departamento;
import es.baseproject.ejb.entities.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    
    

    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-main-PU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            Empresa empresa = new Empresa(new Long(3), "Mango");
            Empresa empresa2 = new Empresa(new Long(4), "Zara");

            Departamento departamento = new Departamento(new Long(5), "administrativo", empresa);
            Departamento departamento2 = new Departamento(new Long(6), "Informatica", empresa);
            Departamento departamento3 = new Departamento(new Long(7), "recursos Humanos", empresa);

            transaction.begin();

            em.persist(empresa);
        //em.persist(departamento);
            //em.persist(departamento2);
            //em.persist(departamento3);

            transaction.commit();
            em.close();

            System.out.println("fin proceso");
        }catch(Exception e){
            //transaction
            //em.close();
        }
                

    }

}
