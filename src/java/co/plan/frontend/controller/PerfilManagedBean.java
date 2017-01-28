package co.plan.frontend.controller;

import co.plan.backend.model.entities.Usuario;
import co.plan.backend.persistence.facades.UsuarioFacadeLocal;
import co.plan.frontend.logica.IManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
/**
 *
 * @author miguelangel
 */
@Named(value = "perfilManagedBean")
@SessionScoped
public class PerfilManagedBean implements  Serializable {
   
    private Usuario usu;
   

    public PerfilManagedBean() {
    }

    @PostConstruct
    public void init() {
        usu = FacesUtils.getUsuarioLogueado();
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }
    public String cerrarSesion(){
        FacesUtils.removerUsuario();
        usu = null;
        return "/index.xhtml?faces-redirect=true";
    }
}
