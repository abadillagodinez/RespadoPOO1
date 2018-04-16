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
public abstract class Entregable {
    protected int codReferencia;
    protected boolean estadoEntrega;
    protected String descripcion;
    protected Cliente remitente;
    
    /**
     * constructor de la clase padre entregable
     * @param codReferencia
     * @param estadoEntrega
     * @param descripcion 
     */
    
    public Entregable(int codReferencia, boolean estadoEntrega, String descripcion, Cliente remitente) {
        setCodReferencia(codReferencia);
        setEstadoEntrega(estadoEntrega);
        setDescripcion(descripcion);
        setRemitente(remitente);
    }
    
    /**
     * 
     * @return codigo de referencia del objeto
     */
    public int getCodReferencia() {
        return codReferencia;
    }

    /**
     * setter del codigo de referencia
     * @param codReferencia 
     */
    public void setCodReferencia(int codReferencia) {
        this.codReferencia = codReferencia;
    }

    
    /**
     * 
     * @return el estado de entrega
     */
    public boolean getEstadoEntrega() {
        return estadoEntrega;
    }

    /**
     * setter del estado de entrega
     * @param estadoEntrega 
     */
    public void setEstadoEntrega(boolean estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    /**
     * 
     * @return la descripcion del entregable
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * setter del la descripcion
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 

    /**
     * 
     * @return el remitente del entregable
     */
    public Cliente getRemitente() {
        return remitente;
    }

    /**
     * setter del remite
     * @param remitente 
     */
    public void setRemitente(Cliente remitente) {
        this.remitente = remitente;
    }
    
    
    
    /**
     *metodo abstracto de calculo de impuesto en los hijos
     */
    public abstract double calcularImpuesto();
}
