/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Venta;
import co.plan.backend.persistence.facades.VentaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author miguelangel
 */
@Named(value = "ventaManagedBean")
@SessionScoped
public class VentaManagedBean implements Serializable {
    private Venta venta;
    @Inject private VentaFacadeLocal vFL;
    public VentaManagedBean() {
    }
    public void init(){
        venta = new Venta();
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public VentaFacadeLocal getvFL() {
        return vFL;
    }

    public void setvFL(VentaFacadeLocal vFL) {
        this.vFL = vFL;
    }
     public void registrarVenta() {
        vFL.create(venta);
    }

    public List<Venta> ListarVenta() {
        return vFL.findAll();
    }

    public void eliminarVenta(Venta v) {
        vFL.remove(v);
    }
}
