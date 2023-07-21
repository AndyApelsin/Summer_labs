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
public class CoordinatesDTO {
    @XmlElement(name = "x")
    private Integer x;
    @XmlElement(name = "y")
    private Long y;

    public void setX(Integer x) {
        ValidationHelper.checkNotNullXml(x, "x coord is null in location in xml");
        this.x = x;
    }

    public void setY(Long y) {
        ValidationHelper.checkNotNullXml(y, "y coord is null in location in xml");
        this.y = y;
    }
}
