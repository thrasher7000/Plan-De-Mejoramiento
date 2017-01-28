
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Cliente;
import co.plan.backend.persistence.facades.ClienteFacadeLocal;
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
@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean implements Serializable, IManagedBean<Cliente> {
    private Cliente cliente;
    @Inject private ClienteFacadeLocal cFL;
    public ClienteManagedBean() {
    }
    @PostConstruct 
    public void init (){
        cliente = new Cliente();
    }
    @Override
    public Cliente getObjectByKey(Integer key){
        return cFL.find(key);
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteFacadeLocal getcFL() {
        return cFL;
    }

    public void setcFL(ClienteFacadeLocal cFL) {
        this.cFL = cFL;
    }
    //C.R.U.D
    public void registrar(){
       cFL.create(cliente);
    }
    public List <Cliente> listarCliente(){
        return cFL.findAll();
    }
    public void eliminar (Cliente c){
        cFL.remove(cliente);
    }
}
