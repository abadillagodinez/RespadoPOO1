/**
 * ObtenerIndicadoresEconomicosXML.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cr.fi.bccr.sdde.ws;

public class ObtenerIndicadoresEconomicosXML  implements java.io.Serializable {
    private java.lang.String tcIndicador;

    private java.lang.String tcFechaInicio;

    private java.lang.String tcFechaFinal;

    private java.lang.String tcNombre;

    private java.lang.String tnSubNiveles;

    public ObtenerIndicadoresEconomicosXML() {
    }

    public ObtenerIndicadoresEconomicosXML(
           String tcIndicador,
           String tcFechaInicio,
           String tcFechaFinal,
           String tcNombre,
           String tnSubNiveles) {
           this.tcIndicador = tcIndicador;
           this.tcFechaInicio = tcFechaInicio;
           this.tcFechaFinal = tcFechaFinal;
           this.tcNombre = tcNombre;
           this.tnSubNiveles = tnSubNiveles;
    }


    /**
     * Gets the tcIndicador value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @return tcIndicador
     */
    public java.lang.String getTcIndicador() {
        return tcIndicador;
    }


    /**
     * Sets the tcIndicador value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @param tcIndicador
     */
    public void setTcIndicador(java.lang.String tcIndicador) {
        this.tcIndicador = tcIndicador;
    }


    /**
     * Gets the tcFechaInicio value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @return tcFechaInicio
     */
    public java.lang.String getTcFechaInicio() {
        return tcFechaInicio;
    }


    /**
     * Sets the tcFechaInicio value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @param tcFechaInicio
     */
    public void setTcFechaInicio(java.lang.String tcFechaInicio) {
        this.tcFechaInicio = tcFechaInicio;
    }


    /**
     * Gets the tcFechaFinal value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @return tcFechaFinal
     */
    public java.lang.String getTcFechaFinal() {
        return tcFechaFinal;
    }


    /**
     * Sets the tcFechaFinal value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @param tcFechaFinal
     */
    public void setTcFechaFinal(java.lang.String tcFechaFinal) {
        this.tcFechaFinal = tcFechaFinal;
    }


    /**
     * Gets the tcNombre value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @return tcNombre
     */
    public java.lang.String getTcNombre() {
        return tcNombre;
    }


    /**
     * Sets the tcNombre value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @param tcNombre
     */
    public void setTcNombre(java.lang.String tcNombre) {
        this.tcNombre = tcNombre;
    }


    /**
     * Gets the tnSubNiveles value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @return tnSubNiveles
     */
    public java.lang.String getTnSubNiveles() {
        return tnSubNiveles;
    }


    /**
     * Sets the tnSubNiveles value for this ObtenerIndicadoresEconomicosXML.
     * 
     * @param tnSubNiveles
     */
    public void setTnSubNiveles(java.lang.String tnSubNiveles) {
        this.tnSubNiveles = tnSubNiveles;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerIndicadoresEconomicosXML)) return false;
        ObtenerIndicadoresEconomicosXML other = (ObtenerIndicadoresEconomicosXML) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tcIndicador==null && other.getTcIndicador()==null) || 
             (this.tcIndicador!=null &&
              this.tcIndicador.equals(other.getTcIndicador()))) &&
            ((this.tcFechaInicio==null && other.getTcFechaInicio()==null) || 
             (this.tcFechaInicio!=null &&
              this.tcFechaInicio.equals(other.getTcFechaInicio()))) &&
            ((this.tcFechaFinal==null && other.getTcFechaFinal()==null) || 
             (this.tcFechaFinal!=null &&
              this.tcFechaFinal.equals(other.getTcFechaFinal()))) &&
            ((this.tcNombre==null && other.getTcNombre()==null) || 
             (this.tcNombre!=null &&
              this.tcNombre.equals(other.getTcNombre()))) &&
            ((this.tnSubNiveles==null && other.getTnSubNiveles()==null) || 
             (this.tnSubNiveles!=null &&
              this.tnSubNiveles.equals(other.getTnSubNiveles())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getTcIndicador() != null) {
            _hashCode += getTcIndicador().hashCode();
        }
        if (getTcFechaInicio() != null) {
            _hashCode += getTcFechaInicio().hashCode();
        }
        if (getTcFechaFinal() != null) {
            _hashCode += getTcFechaFinal().hashCode();
        }
        if (getTcNombre() != null) {
            _hashCode += getTcNombre().hashCode();
        }
        if (getTnSubNiveles() != null) {
            _hashCode += getTnSubNiveles().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerIndicadoresEconomicosXML.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", ">ObtenerIndicadoresEconomicosXML"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tcIndicador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", "tcIndicador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tcFechaInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", "tcFechaInicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tcFechaFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", "tcFechaFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tcNombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", "tcNombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tnSubNiveles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", "tnSubNiveles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public  org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
