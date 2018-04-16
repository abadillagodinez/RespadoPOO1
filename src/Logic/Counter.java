/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.*;

/**
 *
 * @author retr0
 */
public class Counter {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Casillero> casilleros;
    int cantidadCasilleros;
    ArrayList<String[]> Reporte=new ArrayList<>();

    public Counter(int cantidadCasilleros) {
        setCantidadCasilleros(cantidadCasilleros);
        casilleros = new ArrayList<>(this.cantidadCasilleros);
    }

    /**
     * 
     * @return la lista de clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * setter de la lista de clientes
     * @param clientes 
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * 
     * @return la lista de casilleros
     */
    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    /**
     * setter de la lista de casilleros
     * @param casilleros 
     */
    public void setCasilleros(ArrayList<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

    /**
     * 
     * @return la cantidad de casilleros
     */
    public int getCantidadCasilleros() {
        return cantidadCasilleros;
    }

    /**
     * setter de la cantidad de casilleros
     * @param cantidadCasilleros 
     */
    public void setCantidadCasilleros(int cantidadCasilleros) {
        this.cantidadCasilleros = cantidadCasilleros;
    }
    
    public void registrarCliente(String nombre, String correo, String telefono, String direccion, String sexo, String fechaNacimiento){
        if(clientes.size() < cantidadCasilleros){
            Cliente nuevo = new Cliente(nombre, correo, telefono, direccion, sexo, fechaNacimiento);
            clientes.add(nuevo);
        }
        else{
            System.out.println("No quedan casilleros disponibles");
        }
    }
    
    public void eliminarCliente(String idCliente){
        for(int i=0; clientes.size()>i;i++){
            if(clientes.get(i).getIdCliente().equals(idCliente)){
                clientes.remove(i);
                System.out.println("Cliente eliminado");
            }
        }
    }
    
    public void consultarCliente(String idCliente){
        Cliente cliente=selecionarCliente(idCliente);
        if("0".equals(cliente.getIdCliente())){
            System.out.println("Cliente no encontrado");
        }else{
            System.out.println(cliente.toString());
        }
    }
    
    public void consultarClientes(){
        for(int i=0;clientes.size()>i;i++){
            System.out.println(clientes.get(i).toString());
        }
    }
    
    public Cliente selecionarCliente(String idCliente ){
        boolean encontrado=false;
        Cliente cliente=new Cliente();
        for(int i=0;clientes.size()>i;i++){
            if(clientes.get(i).getIdCliente().equals(idCliente)){
                encontrado=true;
                cliente= clientes.get(i);
                break;
            }
        }
        if(!encontrado){
            cliente=clientes.get(0);
        }
        return cliente;
    }
    
    public void enviarCorreo(Cliente cliente){
        //correo
    }
    
    public void recibirArticulo(Entregable entregable){
        String idCliente=entregable.destinatario.getIdCliente();
        Cliente cliente=selecionarCliente(idCliente);
        if(cliente.getIdCliente().equals("0")){
            System.out.println("El cliente no existe");
        }else{
            cliente.getCasillero().agregarEntregable(entregable);
            System.out.println("Articulo Dejado en el casillero corrrespondiente");
            enviarCorreo(cliente);
        }
    }
    
    public void entregarArticulo(String idArticulo, String IDcliente){
        Cliente cliente=selecionarCliente(IDcliente);
        if(cliente.getIdCliente().equals("0")){
            System.out.println("Cliente no encontrado");
        }else{
            cliente.getCasillero().entregarEntregable(IDcliente);
        }
    }
    
    public void consultarCasillero(String idCasillero){
        boolean encontrado=false;
        for(Casillero casillero:casilleros){
            if(idCasillero.equals(casillero.getIdCasillero())){
                System.out.println(casillero.toString());
                encontrado=true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("Casillero no encontrado");
        }
    }
    
    public void consultarCasilleroCliente(String idCliente){
        Cliente cliente=selecionarCliente(idCliente);
        if(cliente.getIdCliente().equals("0")){
            System.out.println("El cliente no existe");
        }else{
            System.out.println(cliente.getCasillero().toString());
        }
    }
    
    public ArrayList<String> consultEntregableFechaRecepcion(String fecha){
        ArrayList<String> entregables=new ArrayList<>();
        for(Casillero casillero:casilleros){
            for(Entregable entregable:casillero.getEntregables()){
                if(entregable.fechaRecepcion.equals(fecha)){
                    entregables.add(entregable.toString());
                }
            }
        }
        if(entregables.isEmpty()){
            entregables.add("No se encontro ningun entregable con la fecha:"+fecha);
        }
        return entregables;
    }
    
    public ArrayList<String> consultEntregableFechaEntrega(String fecha){
        ArrayList<String> entregables=new ArrayList<>();
        for(Casillero casillero:casilleros){
            for(Entregable entregable:casillero.getEntregables()){
                if(entregable.fechaEntrega.equals(fecha)){
                    entregables.add(entregable.toString());
                }
            }
        }
        if(entregables.isEmpty()){
            entregables.add("No se encontro ningun entregable con la fecha:"+fecha);
        }
        return entregables;
    }
    
    public ArrayList<String> consultPaquetesSinEntregar(){
        ArrayList<String> entregables=new ArrayList<>();
        for(Casillero casillero:casilleros){
            for(Entregable entregable:casillero.getEntregables()){
                if(!entregable.estadoEntrega){
                   entregables.add(entregable.toString());
                }
            }
        }
        if(entregables.isEmpty()){
            entregables.add("Todos los paquetes se han entregado");
        }
        return entregables;
    }
    
    public ArrayList<String> consultClientesPaquetesPendientes(){
        ArrayList<String> clients=new ArrayList<>();
        int i;
        boolean tienePendientes=false;
        for(Casillero casillero:casilleros){
            i=0;
            for(Entregable entregable:casillero.getEntregables()){
                if(!entregable.estadoEntrega){
                    tienePendientes=true;
                    i++;
                }
            }
            if(tienePendientes){
                clients.add(casillero.getCliente().toString()+ " Tiene: "+
                        String.valueOf(i)+" paquetes pendientes");
            }
            tienePendientes=false;
        }
        return clients;
    }
    
    public void correoTodosPendientes(ArrayList<Cliente> clientus){
        clientus.forEach(this::enviarCorreo);
    }
    
    public ArrayList<String> informeContable(String fecha){
        ArrayList<String> informe=new ArrayList<>();
        String descontado;
        String impuesto;
        double descontado2;
        double impuesto2;
        String informe2;
        for(Casillero casillero:casilleros){
            informe2="";
            descontado="";
            impuesto="";
            descontado2=0;
            impuesto2=0;
            for(Entregable entregable:casillero.getEntregables()){
                if(entregable.getFechaEntrega().equals(fecha)){
                    impuesto2+=entregable.calcularImpuesto();
                }
            }
            if(casillero.getCliente().getTipo()==Tipo.PLATA){
                descontado2=0.1;
            }else if(casillero.getCliente().getTipo()==Tipo.ORO){
                descontado2=0.2;
            }
            descontado2*=impuesto2;
            descontado=String.valueOf(descontado2);
            impuesto=String.valueOf(impuesto2);
            informe2="Impuesto Cobrado: "+String.valueOf(impuesto2-descontado2)+" \n Descuento Aplicado: "+
                    descontado+" \n Impuesto Total: "+impuesto;
            informe.add(informe2);
        }
        return informe;
    }
    
}
