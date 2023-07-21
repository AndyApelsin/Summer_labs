package com.andyegor.DTO;

import com.andyegor.entity.MusicGenre;
import com.andyegor.helper.ValidationHelper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "musicbanddto")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandDTO {
    @XmlElement(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "coordinates")
    private CoordinatesDTO coordinates; //Поле не может быть null
    @XmlElement(name = "numberofparticipants")
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement(name = "genre", nillable = true)
    private MusicGenre genre; //Поле может быть null
    @XmlElement(name = "frontman")
    private PersonDTO frontMan; //Поле не может быть null

    public void setName(String name) {
        ValidationHelper.checkNotNullXml(name, "Band name in uploaded xml is null");
        ValidationHelper.checkStringNotEmptyXml(name, "Band name is empty in uploaded xml");
        this.name = name;
    }

    public void setCoordinates(CoordinatesDTO coordinates) {
        ValidationHelper.checkNotNullXml(coordinates, "Coordinates is null in uploaded xml");
        this.coordinates = coordinates;
    }

    public void setNumberOfParticipants(Long numberOfParticipants) {
        ValidationHelper.checkNotNullXml(numberOfParticipants, "Number of participants is null in uploaded xml");
        ValidationHelper.checkNumberPositivityXml(numberOfParticipants, "Number of participants is negative in uploaded xml");
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setFrontMan(PersonDTO frontMan) {
        ValidationHelper.checkNotNullXml(frontMan, "Front man is null in uploaded xml");
        this.frontMan = frontMan;
    }
}

