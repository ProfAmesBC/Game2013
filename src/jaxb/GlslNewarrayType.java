//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.30 at 09:30:35 AM EDT 
//


package jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			The glsl_newarray_type is used to creates a parameter of a one-dimensional array type.
 * 			
 * 
 * <playerA>Java class for glsl_newarray_type complex type.
 * 
 * <playerA>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="glsl_newarray_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://www.collada.org/2005/11/COLLADASchema}glsl_param_type"/>
 *         &lt;element name="array" type="{http://www.collada.org/2005/11/COLLADASchema}glsl_newarray_type"/>
 *       &lt;/choice>
 *       &lt;attribute name="length" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "glsl_newarray_type", propOrder = {
    "boolsAndBool2SAndBool3S"
})
public class GlslNewarrayType {

    @XmlElementRefs({
        @XmlElementRef(name = "int4", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "float3", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "array", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "samplerCUBE", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "samplerRECT", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "bool2", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "float3x3", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "int3", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "enum", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "sampler1D", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "sampler3D", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "bool3", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "surface", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "samplerDEPTH", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "bool", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "bool4", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "sampler2D", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "float", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "float4x4", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "float2", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "float2x2", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "int", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "int2", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class),
        @XmlElementRef(name = "float4", namespace = "http://www.collada.org/2005/11/COLLADASchema", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> boolsAndBool2SAndBool3S;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger length;

    /**
     * Gets the value of the boolsAndBool2SAndBool3S property.
     * 
     * <playerA>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boolsAndBool2SAndBool3S property.
     * 
     * <playerA>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoolsAndBool2sAndBool3s().add(newItem);
     * </pre>
     * 
     * 
     * <playerA>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Integer }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link GlSamplerCUBE }{@code >}
     * {@link JAXBElement }{@code <}{@link GlslNewarrayType }{@code >}
     * {@link JAXBElement }{@code <}{@link GlSamplerRECT }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Boolean }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Integer }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link GlSampler1D }{@code >}
     * {@link JAXBElement }{@code <}{@link GlSampler3D }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Boolean }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link GlslSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link GlSamplerDEPTH }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Boolean }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link GlSampler2D }{@code >}
     * {@link JAXBElement }{@code <}{@link Float }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Float }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Integer }{@code >}{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getBoolsAndBool2sAndBool3s() {
        if (boolsAndBool2SAndBool3S == null) {
            boolsAndBool2SAndBool3S = new ArrayList<JAXBElement<?>>();
        }
        return this.boolsAndBool2SAndBool3S;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLength(BigInteger value) {
        this.length = value;
    }

}
