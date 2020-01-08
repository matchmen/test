package com.mt.jaxbcontext;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author: liqm
 * 2020-01-08
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Classs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Classs {

    @XmlElement(name = "className")
    private String className;

    @XmlElement(name = "classCode")
    private String classCode;

}
