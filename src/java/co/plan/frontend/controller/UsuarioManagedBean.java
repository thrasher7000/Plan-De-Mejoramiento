
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Usuario;
import co.plan.backend.persistence.facades.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author miguelangel
 */
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable {
    private Usuario usu;
    @Inject private UsuarioFacadeLocal uFL;
    public UsuarioManagedBean() {
    }
    @PostConstruct
    public void init (){
        usu= new Usuario();
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public UsuarioFacadeLocal getuFL() {
        return uFL;
    }

    public void setuFL(UsuarioFacadeLocal uFL) {
        this.uFL = uFL;
    }
    //C.R.U.D
     public void registrar(){
       uFL.create(usu);
    }
    public List <Usuario> ListarUsuario(){
        return uFL.findAll();
    }
    public void eliminar (Usuario u){
        uFL.remove(u);
    }
    public void validar(){
        System.out.println("hola");
        FacesMessage msg = null;
        try {
        uFL.find(this.usu);
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"bienvenido",this.usu.getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            System.out.println("error");
             msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"error","error en el metodo");
             FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
}
