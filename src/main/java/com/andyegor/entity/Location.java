package com.andyegor.entity;

import com.andyegor.DTO.LocationDTO;
import com.andyegor.helper.ValidationHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
public class Location {
    private Float x;
    private Integer y;
    private double z;
    private String name; //Длина строки не должна быть больше 629, Поле может быть null

    public Location(Float x, Integer y, double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    public Location(LocationDTO dto){
        this.x = dto.getX();
        this.y = dto.getY();
        this.z = dto.getZ();
        this.name = dto.getName();
    }
    LocationDTO getLocationDTO(){
        return new LocationDTO(x, y, z, name);
    }
}
