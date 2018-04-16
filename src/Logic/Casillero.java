/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author retr0
 */
public class Casillero {
    private boolean estado;
    private ArrayList<Entregable> entregables;
    private Cliente cliente;

    public Casillero() {
        entregables = new ArrayList<Entregable>();
    }

    
    /**
     * verifica si esta ocupado o no
     * @return el estado del casillero
     */
    public boolean isLibre() {
        return estado;
    }

    /**
     * setter del estado
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * 
     * @return el arraylist de los entregables 
     */
    public ArrayList<Entregable> getEntregables() {
        return entregables;
    }

    /**
     * setter de los entregables
     * @param entregables 
     */
    public void setEntregables(ArrayList<Entregable> entregables) {
        this.entregables = entregables;
    }

    /**
     * 
     * @return el cliente del casillero
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * setter del cliente
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    /**
     * metodo para insertar un nuevo entregable
     */
    public void agregarEntregable(Entregable entregable){
        entregables.add(entregable);
    }
    
    
}
