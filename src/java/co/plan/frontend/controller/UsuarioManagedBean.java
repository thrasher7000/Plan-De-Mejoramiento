package co.plan.frontend.controller;

import co.plan.backend.model.entities.Usuario;
import co.plan.backend.persistence.facades.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author miguelangel
 */
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable {

    private Usuario usu;
    @Inject 
    private UsuarioFacadeLocal uFL;

    public UsuarioManagedBean() {
    }

    @PostConstruct
    public void init() {
        usu = new Usuario();
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
    public void registrar() {
        uFL.create(usu);
    }

    public List<Usuario> ListarUsuario() {
        return uFL.findAll();
    }

    public void eliminar(Usuario u) {
        uFL.remove(u);
    }

    public Usuario loginControl(String username, String password) {
        try {
            List<Usuario> myusu = uFL.logIn(username, password);
            if (myusu.size() > 0) {
                for (Usuario us : myusu) {
                    return us;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public void validar() {
        try {
            Usuario usu = this.loginControl(this.usu.getUsuario(), this.usu.getContrasena());
            if (usu != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login Succes", "Bienvenido "+usu.getNombre()));
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/inicio.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario o Contraseña Incorrecta"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
        }

    }
}
