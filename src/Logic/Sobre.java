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
public class Sobre extends Entregable {
    private String tipo; //aereo o de manila
    private String contenido; //articulo pequeño o documentos
    private double peso;

    /**
     * constructor de una de las clases hijas   
     * @param tipo
     * @param contenido
     * @param peso
     * @param codReferencia
     * @param estadoEntrega
     * @param descripcion 
     */
    public Sobre(String tipo, String contenido, double peso, int codReferencia, boolean estadoEntrega, String descripcion, Cliente remitente) {
        super(codReferencia, estadoEntrega, descripcion, remitente);
        setTipo(tipo);
        setContenido(contenido);
        setPeso(peso);
    }
    
    /**
     * 
     * @return el tipo del sobre
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * setter del tipo
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return el contenido del sobre
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * setter del contenido
     * @param contenido 
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * 
     * @return  el peso del sobre
     */
    public double getPeso() {
        return peso;
    }

    /**
     * setter del peso
     * @param peso 
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    /**
     * metodo del padre, calcula el impuesto del hijo
     * @return el impuesto
     */
    @Override
    public double calcularImpuesto() {
        double result = 0;
        if(tipo.equals("Aereo") && contenido.equals("Documentacion")){
            result = 0;
        }
        else if(tipo.equals("Aereo") && contenido.equals("ArticuloPequeno")){
            result = 1;
        }
        else if(tipo.equals("Manila") && contenido.equals("Documentacion")){
            result = 1;
        }
        else if(tipo.equals("Manila") && contenido.equals("ArticuloPequeno")){
            result = 2;
        }
        return result;
    }
    
    /**
     * toString de la clase
     */
    public String toString(){
        String msg = "";
        msg += "Codigo: " + super.getCodReferencia() + "\n";
        msg += "Tipo: " + getTipo() + "\n";
        msg += "Contenido: " + getContenido() + "\n";
        msg += "Peso: " + + getPeso() + " gramos" + "\n";
        if(super.getEstadoEntrega()){
            msg += "Estado:"  + " Entregado\n";
        }
        else{
            msg += "Estado:" + " No Entregado\n";
        }
        msg += "Descripcion: " + super.getDescripcion() + "\n";
        msg += "Remitente: " + "\n" + "\t" + remitente.toString() + "\n";
        return msg;
    }
    
}
