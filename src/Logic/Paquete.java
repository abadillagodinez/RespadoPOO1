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
public class Paquete extends Entregable{
    private String contenido; //electronico o no
    private boolean fragil;
    private double peso;

    public Paquete(String contenido, boolean fragil, double peso, String codReferencia,
            boolean estadoEntrega, String descripcion, String remitente) {
        super(codReferencia, estadoEntrega, descripcion, remitente);
        setContenido(contenido);
        setFragil(fragil);
        setPeso(peso);
    }

    
    /**
     * 
     * @return el contenido del paquete
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
     * @return si es fragil o no
     */
    public boolean isFragil() {
        return fragil;
    }

    /**
     * setter de fragilidad
     * @param fragil 
     */
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    /**
     * 
     * @return el peso del paquete
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
     * metodo abstrac implementado que genera el impuesto
     * @return 
     */
    @Override
    public double calcularImpuesto(){
        String s="";
        double result = 0;
        if(contenido.equals("Electronico") && isFragil()){
            result = (peso * 0.02) + 4;
            s="Contenido electronico fragil\n. Impuesto \n= Peso: "+String.valueOf(peso)+" * 0.02 +4 = "+String.valueOf(result);
        }
        else if((contenido.equals("Electronico") && !isFragil()) || (!contenido.equals("Electronico") && isFragil())){
            result = (peso * 0.02) + 2;
            s="Contenido electronico no fragil\n o contenido no electronico fragil.\n Impuesto \n= Peso: "
                    +String.valueOf(peso)+" * 0.02 +2 = "+String.valueOf(result);
        }
        else if(!contenido.equals("Electronico") && !isFragil()){
            s="Contenido ni electronico ni fragil.\n Impuesto \n= Peso: "+String.valueOf(peso)+" * 0.02 = "+String.valueOf(result);
            result = (peso * 0.02);
        }
        this.impuesto=s;
        return result;
    }
    
    /**
     * toString de la clase
     */
    public String toString(){
        String msg = "\tPaquete\n";
        msg += "\tCodigo: " + super.getCodReferencia() + "\n";
        msg += "\tContenido: " + getContenido()+ "\n";
        if(isFragil()){
            msg += "\tFragil\n";
        }
        else{
            msg += "\tNo Fragil\n"; 
        }
        msg += "\tPeso: " + getPeso()+ " gramos\n";
        if(super.getEstadoEntrega()){
            msg += "\tEstado: "  + " Entregado\n";
            msg += "\tFecha de entrega: "+ super.fechaEntrega +"\n";
            msg += "\tHora de entrega: "+ super.horaEntrega +"\n";
        }
        else{
            msg += "\tEstado: " + " No Entregado\n";
        }
        msg += "\tFecha recepcion: " + super.fechaRecepcion + "\n";
        msg += "\tDescripcion: " + super.getDescripcion() + "\n";
        msg += "\tRemitente:" + remitente.toString() + "\n";
        return msg;
    }
    
    /**
     * toList
     * @return 
     */
    @Override
    public String toList() {
        String msg="";
        msg+="Codigo: "+this.codReferencia;
        msg+=";Paquete de: "+this.remitente;
        msg+=" Impuesto: "+String.valueOf(calcularImpuesto());
        return msg;
    }
    
}
