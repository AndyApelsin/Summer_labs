package com.andyegor.DTO;

import com.andyegor.helper.ValidationHelper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationDTO {
    @XmlElement(name = "x")
    private Float x;
    @XmlElement(name = "y")
    private Integer y;
    @XmlElement(name = "z")
    private double z;
    @XmlElement(name = "name")
    private String name; //Длина строки не должна быть больше 629, Поле может быть null

    public void setX(Float x) {
        ValidationHelper.checkNotNullXml(x, "x coord in location is null in xml");
        this.x = x;
    }

    public void setY(Integer y) {
        ValidationHelper.checkNotNullXml(y, "y coord in location is null in xml");
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setName(String name) {
        if (name != ""){
            ValidationHelper.checkStringSizeXml(name, "Location name is too long in xml");
        }
        if (name == ""){
            name = null;
        }
        this.name = name;
    }
}
