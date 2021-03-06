
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Vehiculo;
import co.plan.backend.persistence.facades.VehiculoFacadeLocal;
import co.plan.frontend.logica.IManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.faces.event.ActionEvent;

/**
 *
 * @author miguelangel
 */
@Named(value = "vehiculoManagedBean")
@RequestScoped
public class VehiculoManagedBean implements Serializable ,IManagedBean<Vehiculo> {
    private Vehiculo vehiculo;
    private int precioMayor;
    private List<Vehiculo> listaMayorPrecio;
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

    public int getPrecioMayor() {
        return precioMayor;
    }

    public void setPrecioMayor(int precioMayor) {
        this.precioMayor = precioMayor;
    }
    
    //C.R.U.D
    public void registrarVehiculo(){
        System.out.println("co.plan.frontend.controller.VehiculoManagedBean.registrarVehiculo()");
        vFL.create(vehiculo);
    }
    public List <Vehiculo> listarVehiculos(){
        return vFL.findAll();
    }
    public void eliminar (Vehiculo v){
        vFL.remove(vehiculo);
    }
    public void prueba(ActionEvent e){
        System.out.println("co.plan.frontend.controller.VehiculoManagedBean.registrarVehiculo()"+e);
    }
    public Vehiculo consultaMarcaModelo(){
        Vehiculo vs = new Vehiculo();
        int x = 0;
        for(Vehiculo v:this.listarVehiculos()){
            
            if (v.getModelo()>x) {
                x=v.getModelo();
                vs = v;
            }
        }
        return vs;
    }

    @Override
    public Vehiculo getObjectByKey(Integer key) {
        return vFL.find(key);
    }
    public void consultarListaPrecioMayor(){
        this.listaMayorPrecio = vFL.findbyMayorPrecio(precioMayor);
    }
    public List<Vehiculo> listaMayor(){
        return listaMayorPrecio;
    }
     public int consultaVehiculoCostoso(){
        int x = 0;
        for(Vehiculo v:this.listarVehiculos()){
            
            if (v.getPrecio()>x) {
                x=v.getPrecio();
            }
        }
        return x;
    }
     public Vehiculo consultarPrecioBajo(){
        Vehiculo vs = new Vehiculo();
        int x = this.consultaVehiculoCostoso();
        for(Vehiculo v:this.listarVehiculos()){
            
            if (v.getPrecio()<x) {
                x=v.getPrecio();
                vs = v;
            }
        }
        return vs;
    }
     public Vehiculo getVehiculoMasVendido(Vehiculo v){
         return vFL.find(v);
     }
}
