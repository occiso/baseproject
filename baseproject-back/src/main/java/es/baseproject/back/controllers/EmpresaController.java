package es.baseproject.back.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import es.baseproject.ejb.entities.Empresa;
import es.baseproject.ejb.service.EmpresaInterface;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;


@ManagedBean
@ViewScoped
public class EmpresaController {
    
    @EJB(name = "empresaService")
    private EmpresaInterface empresaService;
    
    private List<Empresa> empresas;
    private Empresa selectedEmpresa;
    
    @PostConstruct
    public void init(){
        this.empresas = empresaService.list();
    }
    
    public void handleEmpresaChange(ValueChangeEvent e){
        this.selectedEmpresa = (Empresa) e.getNewValue();
        
    }
    
    //getters y setters
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public EmpresaInterface getEmpresaService() {
        return empresaService;
    }

    public void setEmpresaService(EmpresaInterface empresaService) {
        this.empresaService = empresaService;
    }

    public Empresa getSelectedEmpresa() {
        return selectedEmpresa;
    }

    public void setSelectedEmpresa(Empresa selectedEmpresa) {
        this.selectedEmpresa = selectedEmpresa;
    }
    
}