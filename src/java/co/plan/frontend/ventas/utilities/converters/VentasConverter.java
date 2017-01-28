/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.plan.frontend.ventas.utilities.converters;

import co.plan.backend.model.entities.Venta;
import co.plan.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author miguelangel
 */
@FacesConverter (forClass = Venta.class)
public class VentasConverter extends AbstractConverter {
    public VentasConverter(){
        this.namedManagedBean = "ventaManagedBean";
    }
}
