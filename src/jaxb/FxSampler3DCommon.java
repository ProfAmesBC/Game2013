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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 			A three-dimensional texture sampler.
 * 			
 * 
 * <p>Java class for fx_sampler3D_common complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fx_sampler3D_common">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}NCName"/>
 *         &lt;element name="wrap_s" type="{http://www.collada.org/2005/11/COLLADASchema}fx_sampler_wrap_common" minOccurs="0"/>
 *         &lt;element name="wrap_t" type="{http://www.collada.org/2005/11/COLLADASchema}fx_sampler_wrap_common" minOccurs="0"/>
 *         &lt;element name="wrap_p" type="{http://www.collada.org/2005/11/COLLADASchema}fx_sampler_wrap_common" minOccurs="0"/>
 *         &lt;element name="minfilter" type="{http://www.collada.org/2005/11/COLLADASchema}fx_sampler_filter_common" minOccurs="0"/>
 *         &lt;element name="magfilter" type="{http://www.collada.org/2005/11/COLLADASchema}fx_sampler_filter_common" minOccurs="0"/>
 *         &lt;element name="mipfilter" type="{http://www.collada.org/2005/11/COLLADASchema}fx_sampler_filter_common" minOccurs="0"/>
 *         &lt;element name="border_color" type="{http://www.collada.org/2005/11/COLLADASchema}fx_color_common" minOccurs="0"/>
 *         &lt;element name="mipmap_maxlevel" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/>
 *         &lt;element name="mipmap_bias" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element ref="{http://www.collada.org/2005/11/COLLADASchema}extra" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fx_sampler3D_common", propOrder = {
    "source",
    "wrapS",
    "wrapT",
    "wrapP",
    "minfilter",
    "magfilter",
    "mipfilter",
    "borderColor",
    "mipmapMaxlevel",
    "mipmapBias",
    "extras"
})
@XmlSeeAlso({
    CgSampler3D.class,
    GlSampler3D.class
})
public class FxSampler3DCommon {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String source;
    @XmlElement(name = "wrap_s", defaultValue = "WRAP")
    protected FxSamplerWrapCommon wrapS;
    @XmlElement(name = "wrap_t", defaultValue = "WRAP")
    protected FxSamplerWrapCommon wrapT;
    @XmlElement(name = "wrap_p", defaultValue = "WRAP")
    protected FxSamplerWrapCommon wrapP;
    @XmlElement(defaultValue = "NONE")
    protected FxSamplerFilterCommon minfilter;
    @XmlElement(defaultValue = "NONE")
    protected FxSamplerFilterCommon magfilter;
    @XmlElement(defaultValue = "NONE")
    protected FxSamplerFilterCommon mipfilter;
    @XmlList
    @XmlElement(name = "border_color", type = Double.class)
    protected List<Double> borderColor;
    @XmlElement(name = "mipmap_maxlevel", defaultValue = "255")
    @XmlSchemaType(name = "unsignedByte")
    protected Short mipmapMaxlevel;
    @XmlElement(name = "mipmap_bias", defaultValue = "0.0")
    protected Float mipmapBias;
    @XmlElement(name = "extra")
    protected List<Extra> extras;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the wrapS property.
     * 
     * @return
     *     possible object is
     *     {@link FxSamplerWrapCommon }
     *     
     */
    public FxSamplerWrapCommon getWrapS() {
        return wrapS;
    }

    /**
     * Sets the value of the wrapS property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSamplerWrapCommon }
     *     
     */
    public void setWrapS(FxSamplerWrapCommon value) {
        this.wrapS = value;
    }

    /**
     * Gets the value of the wrapT property.
     * 
     * @return
     *     possible object is
     *     {@link FxSamplerWrapCommon }
     *     
     */
    public FxSamplerWrapCommon getWrapT() {
        return wrapT;
    }

    /**
     * Sets the value of the wrapT property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSamplerWrapCommon }
     *     
     */
    public void setWrapT(FxSamplerWrapCommon value) {
        this.wrapT = value;
    }

    /**
     * Gets the value of the wrapP property.
     * 
     * @return
     *     possible object is
     *     {@link FxSamplerWrapCommon }
     *     
     */
    public FxSamplerWrapCommon getWrapP() {
        return wrapP;
    }

    /**
     * Sets the value of the wrapP property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSamplerWrapCommon }
     *     
     */
    public void setWrapP(FxSamplerWrapCommon value) {
        this.wrapP = value;
    }

    /**
     * Gets the value of the minfilter property.
     * 
     * @return
     *     possible object is
     *     {@link FxSamplerFilterCommon }
     *     
     */
    public FxSamplerFilterCommon getMinfilter() {
        return minfilter;
    }

    /**
     * Sets the value of the minfilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSamplerFilterCommon }
     *     
     */
    public void setMinfilter(FxSamplerFilterCommon value) {
        this.minfilter = value;
    }

    /**
     * Gets the value of the magfilter property.
     * 
     * @return
     *     possible object is
     *     {@link FxSamplerFilterCommon }
     *     
     */
    public FxSamplerFilterCommon getMagfilter() {
        return magfilter;
    }

    /**
     * Sets the value of the magfilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSamplerFilterCommon }
     *     
     */
    public void setMagfilter(FxSamplerFilterCommon value) {
        this.magfilter = value;
    }

    /**
     * Gets the value of the mipfilter property.
     * 
     * @return
     *     possible object is
     *     {@link FxSamplerFilterCommon }
     *     
     */
    public FxSamplerFilterCommon getMipfilter() {
        return mipfilter;
    }

    /**
     * Sets the value of the mipfilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxSamplerFilterCommon }
     *     
     */
    public void setMipfilter(FxSamplerFilterCommon value) {
        this.mipfilter = value;
    }

    /**
     * Gets the value of the borderColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the borderColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorderColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getBorderColor() {
        if (borderColor == null) {
            borderColor = new ArrayList<Double>();
        }
        return this.borderColor;
    }

    /**
     * Gets the value of the mipmapMaxlevel property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMipmapMaxlevel() {
        return mipmapMaxlevel;
    }

    /**
     * Sets the value of the mipmapMaxlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMipmapMaxlevel(Short value) {
        this.mipmapMaxlevel = value;
    }

    /**
     * Gets the value of the mipmapBias property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMipmapBias() {
        return mipmapBias;
    }

    /**
     * Sets the value of the mipmapBias property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMipmapBias(Float value) {
        this.mipmapBias = value;
    }

    /**
     * Gets the value of the extras property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extras property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtras().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extra }
     * 
     * 
     */
    public List<Extra> getExtras() {
        if (extras == null) {
            extras = new ArrayList<Extra>();
        }
        return this.extras;
    }

}
