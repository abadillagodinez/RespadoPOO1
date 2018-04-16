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
    private int cantCasilleros;
    private String IdCasillero;
    private boolean estado;
    private ArrayList<Entregable> entregables;
    private Cliente cliente;
    private int entregados=0;
    private static int plataMilestone=10;
    private static int oroMilestone=20;

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

    public int getEntregados() {
        return entregados;
    }

    public void setEntregados(int entregados) {
        this.entregados = entregados;
    }

    public int getCantCasilleros() {
        return cantCasilleros;
    }

    public void setCantCasilleros(int cantCasilleros) {
        this.cantCasilleros = cantCasilleros;
    }

    public String getIdCasillero() {
        return IdCasillero;
    }

    public void setIdCasillero(String IdCasillero) {
        this.IdCasillero = IdCasillero;
    }

    public static int getPlataMilestone() {
        return plataMilestone;
    }

    public static void setPlataMilestone(int plataMilestone) {
        System.out.println("El rango para ser tipo PLATA ha cambiado, ahora es: "+String.valueOf(plataMilestone)
                +" los clientes que ya eran tipo PLATA no se veran afectados por este cambio");
        Casillero.plataMilestone = plataMilestone;
    }

    public static int getOroMilestone() {
        return oroMilestone;
    }

    public static void setOroMilestone(int oroMilestone) {
        System.out.println("El rango para ser tipo ORO ha cambiado, ahora es: "+String.valueOf(oroMilestone)
                +" los clientes que ya eran tipo ORO no se veran afectados por este cambio");
        Casillero.oroMilestone = oroMilestone;
    }
    
    
    
    public String to_String(){
        String s="";
        s+="ID Casillero: "+this.getIdCasillero()+" \n";
        s+="Cantidad de paquetes recibidos en total: "+String.valueOf(this.entregables.size())+" \n";
        s+="Cantidad de paquetes entregados: "+String.valueOf(entregados)+" \n";
        if(estado){
            s+="Estado: Ocupado \n";
        }else{
            s+="Estado: Desocupado \n";
        }
        return s;
    }
    
    
    /**
     * metodo para insertar un nuevo entregable
     * @param entregable
     */
    public void agregarEntregable(Entregable entregable){
        entregables.add(entregable);
        if(entregables.size()==plataMilestone){
            cliente.setTipo(Tipo.PLATA);
            System.out.println("El cliente :"+cliente.getIdCliente()+"\n Nombre :"+cliente.getNombre()+
                    " ha asencido de tipo, ahora es PLATA, disfrute de su recien adquirido 5% de descuento");
        }
        if(entregables.size()==oroMilestone){
            cliente.setTipo(Tipo.ORO);
            System.out.println("El cliente :"+cliente.getIdCliente()+"\n Nombre :"+cliente.getNombre()+
                    " ha asencido de tipo, ahora es ORO, disfrute de su recien adquirido 10% de descuento");
        }
    }
    
    public void entregarEntregable(String idEntregable){
        for (Entregable entregable : entregables) {
            if(entregable.codReferencia.equals(idEntregable)){
                entregable.entregar();
                entregados++;
                break;
            }else{
                System.out.println("El articulo no pudo ser entregado porque no se encontro su ID");
            }
        }
    }
    
    
}
