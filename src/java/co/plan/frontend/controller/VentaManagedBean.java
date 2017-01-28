/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Venta;
import co.plan.backend.persistence.facades.VentaFacadeLocal;
import co.plan.frontend.logica.IManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author miguelangel
 */
@Named(value = "ventaManagedBean")
@RequestScoped
public class VentaManagedBean implements Serializable , IManagedBean<Venta>  {
    private Venta venta;
    @Inject private VentaFacadeLocal vFL;
    public VentaManagedBean() {
    }
    @PostConstruct
    public void init(){
        venta = new Venta();
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
     public void registrarVenta() {
         venta.setFecha(new Date());
        vFL.create(venta);
    }

    public List<Venta> listarVenta() {
        return vFL.findAll();
    }

    public void eliminarVenta(Venta v) {
        vFL.remove(v);
    }

    @Override
    public Venta getObjectByKey(Integer key) {
        return vFL.find(key);
    }
}
