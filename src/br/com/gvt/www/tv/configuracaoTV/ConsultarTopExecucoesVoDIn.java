/**
 * ConsultarTopExecucoesVoDIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.gvt.www.tv.configuracaoTV;

public class ConsultarTopExecucoesVoDIn  implements java.io.Serializable {
    private java.lang.Integer numeroFilmes;

    public ConsultarTopExecucoesVoDIn() {
    }

    public ConsultarTopExecucoesVoDIn(
           java.lang.Integer numeroFilmes) {
           this.numeroFilmes = numeroFilmes;
    }


    /**
     * Gets the numeroFilmes value for this ConsultarTopExecucoesVoDIn.
     * 
     * @return numeroFilmes
     */
    public java.lang.Integer getNumeroFilmes() {
        return numeroFilmes;
    }


    /**
     * Sets the numeroFilmes value for this ConsultarTopExecucoesVoDIn.
     * 
     * @param numeroFilmes
     */
    public void setNumeroFilmes(java.lang.Integer numeroFilmes) {
        this.numeroFilmes = numeroFilmes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarTopExecucoesVoDIn)) return false;
        ConsultarTopExecucoesVoDIn other = (ConsultarTopExecucoesVoDIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroFilmes==null && other.getNumeroFilmes()==null) || 
             (this.numeroFilmes!=null &&
              this.numeroFilmes.equals(other.getNumeroFilmes())));
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
        if (getNumeroFilmes() != null) {
            _hashCode += getNumeroFilmes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarTopExecucoesVoDIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.gvt.com.br/tv/configuracaoTV", "ConsultarTopExecucoesVoDIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroFilmes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.gvt.com.br/tv/configuracaoTV", "numeroFilmes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
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
