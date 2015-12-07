package es.baseproject.ejb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "departamento")
public class Departamento implements Serializable {
    
    public Departamento(){
        super();        
    }
    
    public Departamento(Long id, String nombre, Empresa empresa){
        super();
        this.id = id;
        this.nombre = nombre;
        this.setEmpresa(empresa);
    }
        
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "empresa_id" )
    public Empresa empresa;

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        empresa.getDepartamentos().add(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.empresa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}