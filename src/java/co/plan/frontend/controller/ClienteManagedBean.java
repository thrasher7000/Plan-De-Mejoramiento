
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Cliente;
import co.plan.backend.persistence.facades.ClienteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author miguelangel
 */
@Named(value = "clienteManagedBean")
@SessionScoped
public class ClienteManagedBean implements Serializable {
    private Cliente cliente;
    @Inject private ClienteFacadeLocal cFL;
    public ClienteManagedBean() {
    }
    @PostConstruct 
    public void init (){
        cliente = new Cliente();
    }
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
    public List <Cliente> Listar(){
        return cFL.findAll();
    }
    public void eliminar (Cliente c){
        cFL.remove(cliente);
    }
    
}
