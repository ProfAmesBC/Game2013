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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <playerA>Java class for anonymous complex type.
 * 
 * <playerA>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contributor" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="authoring_tool" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="copyright" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="source_data" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="keywords" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unit" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="meter" type="{http://www.collada.org/2005/11/COLLADASchema}float" default="1.0" />
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" default="meter" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="up_axis" type="{http://www.collada.org/2005/11/COLLADASchema}UpAxisType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contributors",
    "created",
    "keywords",
    "modified",
    "revision",
    "subject",
    "title",
    "unit",
    "upAxis"
})
@XmlRootElement(name = "asset")
public class Asset {

    @XmlElement(name = "contributor")
    protected List<Asset.Contributor> contributors;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    protected String keywords;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modified;
    protected String revision;
    protected String subject;
    protected String title;
    protected Asset.Unit unit;
    @XmlElement(name = "up_axis", defaultValue = "Y_UP")
    protected UpAxisType upAxis;

    /**
     * Gets the value of the contributors property.
     * 
     * <playerA>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contributors property.
     * 
     * <playerA>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContributors().add(newItem);
     * </pre>
     * 
     * 
     * <playerA>
     * Objects of the following type(s) are allowed in the list
     * {@link Asset.Contributor }
     * 
     * 
     */
    public List<Asset.Contributor> getContributors() {
        if (contributors == null) {
            contributors = new ArrayList<Asset.Contributor>();
        }
        return this.contributors;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Sets the value of the keywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeywords(String value) {
        this.keywords = value;
    }

    /**
     * Gets the value of the modified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModified() {
        return modified;
    }

    /**
     * Sets the value of the modified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModified(XMLGregorianCalendar value) {
        this.modified = value;
    }

    /**
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(String value) {
        this.revision = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link Asset.Unit }
     *     
     */
    public Asset.Unit getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Asset.Unit }
     *     
     */
    public void setUnit(Asset.Unit value) {
        this.unit = value;
    }

    /**
     * Gets the value of the upAxis property.
     * 
     * @return
     *     possible object is
     *     {@link UpAxisType }
     *     
     */
    public UpAxisType getUpAxis() {
        return upAxis;
    }

    /**
     * Sets the value of the upAxis property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpAxisType }
     *     
     */
    public void setUpAxis(UpAxisType value) {
        this.upAxis = value;
    }


    /**
     * <playerA>Java class for anonymous complex type.
     * 
     * <playerA>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="authoring_tool" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="copyright" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="source_data" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "author",
        "authoringTool",
        "comments",
        "copyright",
        "sourceData"
    })
    public static class Contributor {

        protected String author;
        @XmlElement(name = "authoring_tool")
        protected String authoringTool;
        protected String comments;
        protected String copyright;
        @XmlElement(name = "source_data")
        @XmlSchemaType(name = "anyURI")
        protected String sourceData;

        /**
         * Gets the value of the author property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthor() {
            return author;
        }

        /**
         * Sets the value of the author property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthor(String value) {
            this.author = value;
        }

        /**
         * Gets the value of the authoringTool property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthoringTool() {
            return authoringTool;
        }

        /**
         * Sets the value of the authoringTool property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthoringTool(String value) {
            this.authoringTool = value;
        }

        /**
         * Gets the value of the comments property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComments() {
            return comments;
        }

        /**
         * Sets the value of the comments property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComments(String value) {
            this.comments = value;
        }

        /**
         * Gets the value of the copyright property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCopyright() {
            return copyright;
        }

        /**
         * Sets the value of the copyright property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCopyright(String value) {
            this.copyright = value;
        }

        /**
         * Gets the value of the sourceData property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceData() {
            return sourceData;
        }

        /**
         * Sets the value of the sourceData property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceData(String value) {
            this.sourceData = value;
        }

    }


    /**
     * <playerA>Java class for anonymous complex type.
     * 
     * <playerA>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="meter" type="{http://www.collada.org/2005/11/COLLADASchema}float" default="1.0" />
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" default="meter" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Unit {

        @XmlAttribute
        protected Double meter;
        @XmlAttribute
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NMTOKEN")
        protected String name;

        /**
         * Gets the value of the meter property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public double getMeter() {
            if (meter == null) {
                return  1.0D;
            } else {
                return meter;
            }
        }

        /**
         * Sets the value of the meter property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setMeter(Double value) {
            this.meter = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            if (name == null) {
                return "meter";
            } else {
                return name;
            }
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }

}
