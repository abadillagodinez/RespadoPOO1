/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
/**
 *
 * @author retr0
 */
public interface WSBCCR {
    /**
     * se implementa para obtener el tipo de cambio de compra
     * @param fecha
     * @return 
     */
    double obtenerCompraDelTipoDeCambio(String fecha);
    /**
     * se implementa para obtener el tipo de cambio de compra
     * @param fecha
     * @return 
     */
    double obtenerVentaDelTipoDeCambio(String fecha);
}

