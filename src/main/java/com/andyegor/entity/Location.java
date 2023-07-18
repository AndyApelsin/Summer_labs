package com.andyegor.entity;

import com.andyegor.helper.ValidationHelper;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Location {
    @XmlElement(name = "x")
    private Float x;
    @XmlElement(name = "y")
    private Integer y;
    @XmlElement(name = "z")
    private double z;
    @XmlElement(name = "name")
    private String name; //Длина строки не должна быть больше 629, Поле может быть null

    public Location(Float x, Integer y, double z, String name) {
        ValidationHelper.checkForNull(x, "x coord is null");
        ValidationHelper.checkForNull(y, "y coord is null");
        ValidationHelper.checkStringSize(name, "location name is too long");
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
}
