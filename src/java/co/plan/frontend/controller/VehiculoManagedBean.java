
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Vehiculo;
import co.plan.backend.persistence.facades.VehiculoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.faces.event.ActionEvent;

/**
 *
 * @author miguelangel
 */
@Named(value = "vehiculoManagedBean")
@SessionScoped
public class VehiculoManagedBean implements Serializable {
    private Vehiculo vehiculo;
    @Inject private VehiculoFacadeLocal vFL;
    public VehiculoManagedBean() {
    }
    @PostConstruct
    public void init(){
        vehiculo = new Vehiculo();
    } 

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public VehiculoFacadeLocal getvFL() {
        return vFL;
    }

    public void setvFL(VehiculoFacadeLocal vFL) {
        this.vFL = vFL;
    }
    //C.R.U.D
    public void registrarVehiculo(ActionEvent e){
        System.out.println("co.plan.frontend.controller.VehiculoManagedBean.registrarVehiculo()");
        vFL.create(vehiculo);
    }
    public List <Vehiculo> ListarVehiculos(){
        return vFL.findAll();
    }
    public void eliminar (Vehiculo v){
        vFL.remove(vehiculo);
    }
    public void prueba(ActionEvent e){
        System.out.println("co.plan.frontend.controller.VehiculoManagedBean.registrarVehiculo()"+e);
    }
}
