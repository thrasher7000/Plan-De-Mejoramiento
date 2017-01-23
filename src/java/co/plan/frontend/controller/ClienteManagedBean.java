/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author miguelangel
 */
@Named(value = "clienteManagedBean")
@SessionScoped
public class ClienteManagedBean implements Serializable {

    /**
     * Creates a new instance of ClienteManagedBean
     */
    public ClienteManagedBean() {
    }
    
}
