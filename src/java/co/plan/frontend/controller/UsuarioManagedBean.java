package co.plan.frontend.controller;

import co.plan.backend.model.entities.Usuario;
import co.plan.backend.persistence.facades.UsuarioFacadeLocal;
import co.plan.frontend.logica.IManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
/**
 *
 * @author miguelangel
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements  Serializable, IManagedBean<Usuario> {
    private String user;
    private String password;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public Usuario getObjectByKey(Integer key) {
        return uFL.find(key);
    }
    public String inicioSesion(){
        try {
            usu = uFL.validarUsuario(user, password);
            if (usu!= null ) {
                FacesUtils.setUsuarioLogueado(usu);
                return "seguridad/inicio.xhtml";
            }
            FacesUtils.mensaje("error usuario invalido");
            return null;
        } catch (Exception e) {
            FacesUtils.mensaje("error exeption");
            return null;
        }
    }
}
