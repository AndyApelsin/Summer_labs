package com.andyegor.entity;

import com.andyegor.generator.IdGenerator;
import com.andyegor.helper.ValidationHelper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBand implements Comparable<MusicBand>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name = "coordinates")
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement(name = "numberOfParticipants")
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement(name = "genre")
    private MusicGenre genre; //Поле может быть null
    @XmlElement(name = "frontMan")
    private Person frontMan; //Поле не может быть null

    public MusicBand(String name, Coordinates coordinates, Long numberOfParticipants, MusicGenre genre, Person frontMan) {
        ValidationHelper.checkForNull(name, "band name is null");
        ValidationHelper.checkStringNotEmpty(name, "band name is empty");
        ValidationHelper.checkForNull(coordinates, "coordinates are null");
        ValidationHelper.checkForNull(numberOfParticipants, "number of participants is null");
        ValidationHelper.checkLongPositivity(numberOfParticipants, "number of participants is 0");
        ValidationHelper.checkForNull(frontMan, "frontman is null");
        this.id = IdGenerator.generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.frontMan = frontMan;
    }

    @Override
    public int compareTo(MusicBand m) {
        if (this.name.compareTo(m.getName()) == 1) {
            return 1;
        } else if (this.name.compareTo(m.getName()) == 0 && this.frontMan.compareTo(m.getFrontMan()) == 1) {
            return 1;
        } else if (this.name.compareTo(m.getName()) == 0 && this.frontMan.compareTo(m.getFrontMan()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }
    @Override
    public String toString() {
        return "Music band name: " + this.name + "\n"
                + "Front man name: " + this.frontMan.getName() + "\n"
                + "Creation date: " + this.creationDate.toString() + "\n";
    }
}
