package com.andyegor.helper;

import com.andyegor.entity.*;
import com.andyegor.generator.IdGenerator;

import java.time.LocalDateTime;
import java.util.Scanner;

public class InputHelper {
    public static MusicBand bandInputWithoutIdAndCreationDate(){
        return bandInput();
    }
    public static MusicBand bandInputGeneratesIdAndCreationDate() {
        MusicBand musicBand = bandInput();
        musicBand.setId(IdGenerator.generateId());
        musicBand.setCreationDate(LocalDateTime.now());
        return musicBand;
    }

    public static Person personInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put frontman name");
        String frontManName = scanner.nextLine();
        while(! ValidationHelper.checkStringNotEmpty(frontManName)){
            System.out.println("Frontman name is empty");
            System.out.println("Put frontman name");
            frontManName = scanner.nextLine();
        }
        System.out.println("Put height");
        String inputTmp = scanner.nextLine();

        while (!(ValidationHelper.isDigit(inputTmp) &&
                ValidationHelper.checkNumberPositivity(Float.valueOf(inputTmp)))){
            System.out.println("Height must be a positive number");
            System.out.println("Put height");
            inputTmp = scanner.nextLine();
        }
        Float frontManHeight = Float.valueOf(inputTmp);

        System.out.println("Put weight");
        inputTmp = scanner.nextLine();
        while(!(ValidationHelper.isDigit(inputTmp) &&
                ValidationHelper.checkNumberPositivity(Float.valueOf(inputTmp)))){
            System.out.println("Weight weight must be a positive number");
            System.out.println("Put weight");
            inputTmp = scanner.nextLine();;
        }
        float frontManWeight = Float.valueOf(inputTmp);


        System.out.println("Put passport ID");
        String passportId = scanner.nextLine();;
        while (passportId != "" ||
                !(PassportIdHelper.checkPassportIdLength(passportId) &&
                PassportIdHelper.addPassportId(passportId))){
            System.out.println("Passport ID is not unique or not long enough");
            System.out.println("Put passport ID or empty string");
            passportId = scanner.nextLine();;
        }
        if(passportId == ""){
            passportId = null;
        }


        System.out.println("Put location name");
        String locationName = scanner.nextLine();
        if (locationName == ""){
            locationName = null;
        }
        System.out.println("Put x coord");
        inputTmp = scanner.nextLine();
        while(! ValidationHelper.isDigit(inputTmp)){
            System.out.println("x coord must be a number");
            System.out.println("Put x coord");
            inputTmp = scanner.nextLine();
        }
        Float x = Float.valueOf(inputTmp);

        System.out.println("Put y coord");
        inputTmp = scanner.nextLine();
        while(!ValidationHelper.isInteger(inputTmp)){
            System.out.println("y coord must be an integer");
            System.out.println("Put y coord");
            inputTmp = scanner.nextLine();
        }
        Integer y = Integer.valueOf(inputTmp);

        System.out.println("Put z coord");
        inputTmp = scanner.nextLine();
        while(!ValidationHelper.isDigit(inputTmp)){
            System.out.println("z coord must be a number");
            System.out.println("Put z coord");
            inputTmp = scanner.nextLine();
        }
        double z = Double.valueOf(inputTmp);
        Location personLocation = new Location(x, y, z, locationName);
        return new Person(frontManName, frontManHeight, frontManWeight, passportId, personLocation);
    }

    public static int idInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put ID");
        String inputTmp = scanner.nextLine();
        while (! ValidationHelper.isInteger(inputTmp)){
            System.out.println("ID must me an integer");
            System.out.println("Put ID");
        }
        return Integer.valueOf(inputTmp);
    }


    public static String filenameInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put full filepath");
        String filepath = scanner.nextLine();
        while(! ValidationHelper.checkStringNotEmpty(filepath)){
            System.out.println("Filepath cannot be empty");
            System.out.println("Put full filepath");
            filepath = scanner.nextLine();
        }
        return filepath;
    }
    private static MusicBand bandInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put band name");
        String bandName = scanner.nextLine();
        while (!ValidationHelper.checkStringNotEmpty(bandName)){
            System.out.println("Band name is empty");
            System.out.println("Put band name");
            bandName = scanner.nextLine();
        }
        System.out.println("Put x coord");
        String inputTmp = scanner.nextLine();
        while(!ValidationHelper.isInteger(inputTmp)){
            System.out.println("x coord must be an integer");
            System.out.println("Put x coord");
            inputTmp = scanner.nextLine();
        }
        Integer xCoord = Integer.valueOf(inputTmp);

        System.out.println("Put y coord");
        inputTmp = scanner.nextLine();
        while (!ValidationHelper.isInteger(inputTmp)){
            System.out.println("y coord must be Long");
            System.out.println("Put y coord");
            inputTmp = scanner.nextLine();
        }
        Long yCoord = Long.valueOf(inputTmp);
        Coordinates bandCoord = new Coordinates(xCoord, yCoord);

        System.out.println("Put number of participants");
        inputTmp = scanner.nextLine();
        while (!(ValidationHelper.isInteger(inputTmp) &&
                ValidationHelper.checkNumberPositivity(Long.valueOf(inputTmp)))) {
            System.out.println("Number of participants must be Long and positive");
            System.out.println("Put number of participants");
            inputTmp = scanner.nextLine();
        }
        Long numberOfParticipants = Long.valueOf(inputTmp);
        System.out.println("""
                Select music genre:
                1.Psychedelic cloud rap
                2.Jazz
                3.Soul
                4.Blues
                5.null
                """);
        MusicGenre genre = null;
        inputTmp = scanner.nextLine();
        while(!ValidationHelper.isInteger(inputTmp)){
            System.out.println("You must put an integer");
            System.out.println("""
                Select music genre:
                1.Psychedelic cloud rap
                2.Jazz
                3.Soul
                4.Blues
                5.null
                """);
            inputTmp = scanner.nextLine();
        }
        int num = Integer.parseInt(inputTmp);
        switch (num) {
            case 1 -> genre = MusicGenre.PSYCHEDELIC_CLOUD_RAP;
            case 2 -> genre = MusicGenre.JAZZ;
            case 3 -> genre = MusicGenre.SOUL;
            case 4 -> genre = MusicGenre.BLUES;
            default -> genre = null;
        }
        Person frontMan = InputHelper.personInput();
        MusicBand musicBand = new MusicBand();
        musicBand.setName(bandName);
        musicBand.setGenre(genre);
        musicBand.setNumberOfParticipants(numberOfParticipants);
        musicBand.setCoordinates(bandCoord);
        musicBand.setFrontMan(frontMan);
        return musicBand;
    }
    //отвечает за ввод строки через InputStreamReader
//    private static String getInput() {
//        char[] str = new char[100];
//        InputStreamReader reader = new InputStreamReader(System.in);
//        try {
//            reader.read(str);
//            //TODO exc
//        } catch (IOException e) {
//            System.out.println("Incorrect input");
//            return null;
//        }
//        return new String(str);
//    }
}
