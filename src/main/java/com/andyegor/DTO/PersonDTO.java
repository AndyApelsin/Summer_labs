package com.andyegor.DTO;

import com.andyegor.helper.PassportIdHelper;
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
public class PersonDTO {
    @XmlElement(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "height")
    private Float height; //Значение поля должно быть больше 0
    @XmlElement(name = "weight")
    private float weight; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement(name = "passportid")
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле может быть null
    @XmlElement(name = "location")
    private LocationDTO location; //Поле может быть null

    public void setName(String name) {
        ValidationHelper.checkNotNullXml(name, "Front man name is null in xml");
        ValidationHelper.checkStringNotEmptyXml(name, "Front man name is empty in xml");
        this.name = name;
    }

    public void setHeight(Float height) {
        ValidationHelper.checkNumberPositivityXml(height, "Height is negative in xml");
        this.height = height;
    }

    public void setWeight(float weight) {
        ValidationHelper.checkNotNullXml(weight, "Weight is negative in xml");
        this.weight = weight;
    }

    public void setPassportID(String passportID) {
        if (passportID != "") {
            PassportIdHelper.checkPassportIdLengthXml(passportID, "Passport ID is too short in xml");
            PassportIdHelper.addPassportIdXml(passportID, "Passport ID is not unique in xml");
        }
        if(passportID == ""){
            passportID = null;
        }
        this.passportID = passportID;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }
}
