
package co.plan.frontend.controller;

import co.plan.backend.model.entities.Concesionario;
import co.plan.backend.persistence.facades.ConcesionarioFacadeLocal;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author miguelangel
 */
@Named(value = "concesionarioManagedBean")
@Dependent
public class ConcesionarioManagedBean {
    private Concesionario con;
    @Inject private ConcesionarioFacadeLocal cFL;
    public ConcesionarioManagedBean() {
    }
    public void init (){
        con = new Concesionario();
    }

    public Concesionario getCon() {
        return con;
    }

    public void setCon(Concesionario con) {
        this.con = con;
    }

    public ConcesionarioFacadeLocal getcFL() {
        return cFL;
    }

    public void setcFL(ConcesionarioFacadeLocal cFL) {
        this.cFL = cFL;
    }
    public void registrarConcesionario (){
        cFL.create(con);
    }
    public List<Concesionario> ListarConsesionario(){
        return cFL.findAll();
    }
    public void eliminarConcesionario (){
        cFL.remove(con);
    }
}
