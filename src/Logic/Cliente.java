/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.PopupMenu;

/**
 *
 * @author retr0
 */
public class Cliente {
    private static int cantidadClientes = 1;
    private int idCliente;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String sexo;
    private String fechaNacimiento;
    private Tipo tipo;
    private Casillero casillero;

    /**
     * constructor de la clase
     * @param nombre
     * @param correo
     * @param telefono
     * @param direccion
     * @param sexo
     * @param fechaNacimiento
     * @param tipo 
     */
    public Cliente(String nombre, String correo, String telefono, String direccion, String sexo, String fechaNacimiento, Tipo tipo) {
        idCliente = cantidadClientes;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        cantidadClientes++;
    }

    /**
     * es un metodo de la clase
     * @return la cantidad de clientes
     */
    public static int getCantidadClientes() {
        return cantidadClientes;
    }

    /**
     * 
     * @return el id del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * setter del id de cliente
     * @param idCliente 
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * 
     * @return el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * setter del nombre del cliente
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return el correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * setter del correo
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * 
     * @return el numero de telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * setter del telefono
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * 
     * @return la direccion del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * setter de la direccion
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return el sexo del cliente
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * setter del sexo
     * @param sexo 
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * 
     * @return la fecha de nacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * setter de la fecha de nacimiento
     * @param fechaNacimiento 
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * 
     * @return el tipo del cliente
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * setter del tipo 
     * @param tipo 
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return el casillero
     */
    public Casillero getCasillero() {
        return casillero;
    }

    /**
     * setter del casillero
     * @param casillero 
     */
    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }
    
    
    public String toString(){
        String msg = "";
        msg += "Nombre: " + nombre + "\n";
        msg += "\t" + "ID: " + idCliente + "\n";
        msg += "\t" + "Correo: " + correo + "\n";
        msg += "\t" + "Direccion: " + direccion + "\n";
        msg += "\t" + "Telefono: " + telefono + "\n";
        msg += "\t" + "Sexo: " + sexo + "\n";
        msg += "\t" + "Fecha de nacimiento: " + fechaNacimiento + "\n";
        msg += "\t" + "Tipo: " + tipo.name() + "\n";
        return msg;
    }

    public String toLst() {
        String msg = "";
        msg += "ID: " + idCliente + "    ";
        msg += "Nombre: " + nombre + "    ";
        msg += "Correo: " + correo;
        return msg;
    }    
    
}
