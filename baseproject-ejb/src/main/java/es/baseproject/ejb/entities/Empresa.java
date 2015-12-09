package es.baseproject.ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Empresa")
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

    public Empresa(){ 
        super();
    }
    public Empresa(Long id, String nombre){
        super();
        this.id = id;
        this.nombre = nombre;
    }
    
    @Id
    //@GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Departamento> departamentos = new ArrayList<>();
    
    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
   
    /*Idem en el resto de clases entity*/
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Long) {
            return getId().equals((Long) obj);
        } else if (obj instanceof Empresa) {
            return getId().equals((((Empresa) obj).getId()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 31 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 31 * hash + (this.departamentos != null ? this.departamentos.hashCode() : 0);        
        return hash;
    }
}