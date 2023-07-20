package com.andyegor.entity;

import com.andyegor.DTO.LocationDTO;
import com.andyegor.DTO.PersonDTO;
import com.andyegor.helper.ValidationHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
public class Person implements Comparable<Person> {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Float height; //Значение поля должно быть больше 0
    private float weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле может быть null
    private Location location; //Поле может быть null

    public Person(String name, Float height, float weight, String passportID, Location location) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.location = location;
    }
    public Person(PersonDTO dto, Location location){
        this.name = dto.getName();
        this.height = dto.getHeight();
        this.weight = dto.getWeight();
        this.passportID = dto.getPassportID();
        this.location = location;
    }
    PersonDTO getPersonDTO (){
        return new PersonDTO(name, height, weight, passportID, location.getLocationDTO());
    }
    @Override
    public int compareTo(Person p){
        return this.name.compareTo(p.name);
    }
}
