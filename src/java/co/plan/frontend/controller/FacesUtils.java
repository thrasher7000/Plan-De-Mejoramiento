/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author miguelangel
 */
public class FacesUtils {

    public static void setUsuarioLogueado(Usuario u) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("usuario", u);
    }

    public static void mensaje(String mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(mensaje));
    }

    public static Usuario getUsuarioLogueado() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (Usuario) context.getExternalContext().getSessionMap().get("usuario");
    }
    public static void removerUsuario(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuario");
        context.getExternalContext().invalidateSession();
    }
}
