package es.baseproject.ejb.main;

import es.baseproject.ejb.entities.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    
    private static String derbyMain = "hibernate-derby-main-PU";
    private static String oracleMain = "hibernate-oracle-main-PU";
    
    public static void main(String[] args) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = Persistence.createEntityManagerFactory(derbyMain).createEntityManager();  
            //em = emf.createEntityManager();
            transaction = em.getTransaction();
            Empresa empresa = new Empresa(new Long(4), "Mango");
            //Empresa empresa2 = new Empresa(new Long(4), "Zara");

//            Departamento departamento = new Departamento(new Long(5), "administrativo", empresa);
//            Departamento departamento2 = new Departamento(new Long(6), "Informatica", empresa);
//            Departamento departamento3 = new Departamento(new Long(7), "recursos Humanos", empresa);

            transaction.begin();            
            em.persist(empresa);
        //em.persist(departamento);
            //em.persist(departamento2);
            //em.persist(departamento3);            
            transaction.commit();                            

            System.out.println("fin proceso baseproject");
        }catch(Exception e){
            if (transaction != null && transaction.isActive()){
                transaction.rollback();
                 System.out.println("Error transaction.rollback()");
            }
            if (em != null && em.isOpen()){
                em.close();
                System.out.println("Error EntityManager.close()");
            }            
            System.out.println("Error: " + e.getMessage());
        }
                

    }

}
