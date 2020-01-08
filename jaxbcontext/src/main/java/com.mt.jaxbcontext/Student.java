package com.mt.jaxbcontext;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * author: liqm
 * 2020-01-08
 */
@Data
@ToString
@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {

    @XmlElement(name = "username")
    private String username;

    @XmlElements(value={@XmlElement(name="classs", type=Classs.class)})
    private List<Classs> classs;



}
