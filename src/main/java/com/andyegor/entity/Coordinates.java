package com.andyegor.entity;

import com.andyegor.DTO.CoordinatesDTO;
import com.andyegor.helper.ValidationHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
public class Coordinates {
    private Integer x;
    private Long y;
    public Coordinates(Integer x, Long y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates(CoordinatesDTO dto){
        this.x = dto.getX();
        this.y = dto.getY();
    }
    CoordinatesDTO getCoordinatesDTO(){
        return new CoordinatesDTO(x, y);
    }
}
