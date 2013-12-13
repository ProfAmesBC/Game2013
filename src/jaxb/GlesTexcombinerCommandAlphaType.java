//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.30 at 09:30:35 AM EDT 
//


package jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gles_texcombiner_commandAlpha_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gles_texcombiner_commandAlpha_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="argument" type="{http://www.collada.org/2005/11/COLLADASchema}gles_texcombiner_argumentAlpha_type" maxOccurs="3"/>
 *       &lt;/sequence>
 *       &lt;attribute name="operator" type="{http://www.collada.org/2005/11/COLLADASchema}gles_texcombiner_operatorAlpha_enums" />
 *       &lt;attribute name="scale" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gles_texcombiner_commandAlpha_type", propOrder = {
    "arguments"
})
public class GlesTexcombinerCommandAlphaType {

    @XmlElement(name = "argument", required = true)
    protected List<GlesTexcombinerArgumentAlphaType> arguments;
    @XmlAttribute
    protected GlesTexcombinerOperatorAlphaEnums operator;
    @XmlAttribute
    protected Float scale;

    /**
     * Gets the value of the arguments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arguments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArguments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlesTexcombinerArgumentAlphaType }
     * 
     * 
     */
    public List<GlesTexcombinerArgumentAlphaType> getArguments() {
        if (arguments == null) {
            arguments = new ArrayList<GlesTexcombinerArgumentAlphaType>();
        }
        return this.arguments;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link GlesTexcombinerOperatorAlphaEnums }
     *     
     */
    public GlesTexcombinerOperatorAlphaEnums getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlesTexcombinerOperatorAlphaEnums }
     *     
     */
    public void setOperator(GlesTexcombinerOperatorAlphaEnums value) {
        this.operator = value;
    }

    /**
     * Gets the value of the scale property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setScale(Float value) {
        this.scale = value;
    }

}
