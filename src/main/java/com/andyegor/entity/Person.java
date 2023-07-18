package com.andyegor.entity;

import com.andyegor.helper.PassportIdHelper;
import com.andyegor.helper.ValidationHelper;
import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparable<Person> {
    @XmlElement(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "height")
    private Float height; //Значение поля должно быть больше 0
    @XmlElement(name = "weight")
    private float weight; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement(name = "passportID")
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле может быть null
    @XmlElement(name = "location")
    private Location location; //Поле может быть null

    public Person(String name, Float height, float weight, String passportID, Location location) {
        ValidationHelper.checkForNull(name, "person name is null");
        ValidationHelper.checkStringNotEmpty(name, "person name is empty");
        ValidationHelper.checkForNull(height, "height is null");
        ValidationHelper.checkFloatPositivity(height, "height <= 0 ");
        ValidationHelper.checkFloatPositivity(weight, "weight <= 0");
        ValidationHelper.checkStringNotEmpty(passportID, "passport id is empty");
        PassportIdHelper.addPassportId(passportID);
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.location = location;
    }
    @Override
    public int compareTo(Person p){
        return this.passportID.compareTo(p.passportID);
    }
}
