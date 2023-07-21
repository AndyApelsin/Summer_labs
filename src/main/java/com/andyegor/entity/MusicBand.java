package com.andyegor.entity;

import com.andyegor.DTO.MusicBandDTO;
import com.andyegor.generator.IdGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MusicBand implements Comparable<MusicBand> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null

    public MusicBand(String name, Coordinates coordinates, Long numberOfParticipants, MusicGenre genre, Person frontMan) {
        this.id = IdGenerator.generateId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.frontMan = frontMan;
    }
    public MusicBand(MusicBandDTO dto){
        this.id = IdGenerator.generateId();
        this.creationDate = LocalDateTime.now();
        this.coordinates = new Coordinates(dto.getCoordinates());
        this.frontMan = new Person(dto.getFrontMan());
        this.name = dto.getName();
        this.numberOfParticipants = dto.getNumberOfParticipants();
        this.genre = dto.getGenre();

    }
    public MusicBand(MusicBand musicBand){
        this.id = musicBand.getId();
        this.name = musicBand.getName();
        this.coordinates = musicBand.getCoordinates();
        this.creationDate = musicBand.getCreationDate();
        this.numberOfParticipants = musicBand.getNumberOfParticipants();
        this.genre = musicBand.getGenre();
        this.frontMan = musicBand.getFrontMan();
    }
    public MusicBandDTO getMusicBandDTO(){
        return new MusicBandDTO(name, coordinates.getCoordinatesDTO(), numberOfParticipants, genre, frontMan.getPersonDTO());
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
