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
public class Coordinates {
    @XmlElement(name = "x")
    private Integer x;
    @XmlElement(name = "y")
    private Long y;
    public Coordinates(Integer x, Long y) {
        ValidationHelper.checkForNull(x, "x is null");
        ValidationHelper.checkForNull(y, "y is null");
        this.x = x;
        this.y = y;
    }
}
