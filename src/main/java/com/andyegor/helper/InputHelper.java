package com.andyegor.helper;

import com.andyegor.entity.*;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {
    public static MusicBand bandInput() {
        System.out.println("Put band name");
        String bandName = getValue();
        System.out.println("Put x coord");
        Integer xCoord = Integer.valueOf(getValue());
        System.out.println("Put y coord");
        Long yCoord = Long.valueOf(getValue());
        Coordinates bandCoord = new Coordinates(xCoord, yCoord);
        System.out.println("Put number of participants");
        Long numberOfParticipants = Long.valueOf(getValue());
        System.out.println("""
                Select music genre:
                1.Psychedelic cloud rap
                2.Jazz
                3.Soul
                4.Blues
                """);
        MusicGenre genre = null;
        int num = Integer.valueOf(getValue());
        switch (num) {
            case 1 -> genre = MusicGenre.PSYCHEDELIC_CLOUD_RAP;
            case 2 -> genre = MusicGenre.JAZZ;
            case 3 -> genre = MusicGenre.SOUL;
            case 4 -> genre = MusicGenre.BLUES;
        }
        Person frontMan = InputHelper.personInput();
        return new MusicBand(bandName, bandCoord, numberOfParticipants, genre, frontMan);
    }

    public static Person personInput() {
        System.out.println("Put frontman name");
        String frontManName = getValue();
        System.out.println("Put height");
        Float frontManHeight = Float.valueOf(getValue());
        System.out.println("Put weight");
        float frontManWeight = Float.valueOf(getValue());
        System.out.println("Put passport ID");
        String passportId = getValue();
        System.out.println("Put location name");
        String locationName = getValue();
        System.out.println("Put x coord");
        Float x = Float.valueOf(getValue());
        System.out.println("Put y coord");
        Integer y = Integer.valueOf(getValue());
        System.out.println("Put z coord");
        double z = Float.valueOf(getValue());
        Location personLocation = new Location(x, y, z, locationName);
        return new Person(frontManName, frontManHeight, frontManWeight, passportId, personLocation);
    }

    public static int idInput() {
        System.out.println("put ID");
        return Integer.valueOf(getValue());
    }

    public static int numberInput() {
        System.out.println("put number");
        return Integer.valueOf(getValue());
    }

    public static String filenameInput() {
        System.out.println("put full filepath");
        return getValue();
    }

    //отвечает за ввод строки через InputStreamReader
    public static String getValue() {
        char[] str = new char[100];
        InputStreamReader reader = new InputStreamReader(System.in);
        try {
            reader.read(str);
        } catch (IOException e) {
            // TODO make better
            e.printStackTrace();
        }
        return new String(str);
    }
}
