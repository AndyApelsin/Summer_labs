package com.andyegor;

import com.andyegor.DTO.CoordinatesDTO;
import com.andyegor.DTO.MusicBandDTO;
import com.andyegor.DTO.MusicBandServiceDTO;
import com.andyegor.comparator.MusicBandComparator;
import com.andyegor.entity.Coordinates;
import com.andyegor.entity.Location;
import com.andyegor.entity.MusicBand;
import com.andyegor.entity.Person;
import com.andyegor.exception.CollectionEmptyException;
import com.andyegor.exception.NoBandFoundException;
import com.andyegor.helper.ValidationHelper;
import com.andyegor.helper.XmlHelper;
import jakarta.xml.bind.JAXBException;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
@Getter
public class MusicBandService {
    private Queue<MusicBand> musicBandStorage;
    private LocalDateTime initializingTime;
    private Boolean workState = true;

    public MusicBandService() {
        this.musicBandStorage = new PriorityQueue<>(new MusicBandComparator());
        this.initializingTime = LocalDateTime.now();
    }
    public void uploadMusicBands(String filename){
        MusicBandServiceDTO serviceDTO = null;
        try {
            serviceDTO = XmlHelper.parseXmlToMusicBands(filename);
        } catch (JAXBException e) {
            //TODO: correct words
            throw new RuntimeException("problem with uploading from xml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("incorrect filepath");
        }
        for (MusicBandDTO musicBandDTO: serviceDTO.getMusicBandStorage()){
            Location location = new Location(musicBandDTO.getFrontMan().getLocation());
            Person frontMan = new Person(musicBandDTO.getFrontMan(), location);
            Coordinates coordinates = new Coordinates(musicBandDTO.getCoordinates());
            MusicBand musicBand = new MusicBand(musicBandDTO, frontMan, coordinates);
            this.musicBandStorage.add(musicBand);
        }
    }

    public void help() {
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "history : вывести последние 7 команд (без их аргументов)\n" +
                "min_by_creation_date : вывести любой объект из коллекции, значение поля creationDate которого является минимальным\n" +
                "filter_less_than_front_man frontMan : вывести элементы, значение поля frontMan которых меньше заданного\n" +
                "print_field_ascending_genre : вывести значения поля genre всех элементов в порядке возрастания");
    }
    public void info() {
        String collectionType = String.valueOf(musicBandStorage.getClass());
        String collectionSize = String.valueOf(musicBandStorage.size());
        System.out.println("Collection Type: " + collectionType);
        System.out.println("Initializing Time: " + String.valueOf(initializingTime));
        System.out.println("Collection Size: " + collectionSize);
    }
    public void show() {
        for (MusicBand musicBand : musicBandStorage) {
            System.out.println(musicBand.toString());
        }
    }
    public void add(MusicBand musicBand) {
        musicBandStorage.add(musicBand);
    }
    public void updateById(long oldBandID, MusicBand newMusicBand) throws NoBandFoundException {
        MusicBand foundMusicBand = musicBandStorage.stream()
                .filter(musicBand -> musicBand.getId() == oldBandID)
                .findFirst()
                .orElse(null);
        if(!ValidationHelper.checkNotNull(foundMusicBand)){
            throw new NoBandFoundException("No band with such ID in collection");
        }
        musicBandStorage.add(newMusicBand);
        musicBandStorage.remove(foundMusicBand);
    }
    public void removeById (long id) throws NoBandFoundException {
        MusicBand foundMusicBand = musicBandStorage.stream() //перевели коллекцию в стрим
                .filter(musicBand -> musicBand.getId() == id) //выбрали из коллекции те муз группы, которые подходят по айди
                .findFirst()
                .orElse(null);
        if(!ValidationHelper.checkNotNull(foundMusicBand)){
            throw new NoBandFoundException("No band with such ID in collection");
        }
        musicBandStorage.remove(foundMusicBand);
    }
    public void clear() {
        musicBandStorage.clear();
    }
    public void save() {
        Queue<MusicBandDTO> musicBandStorageDTO = new LinkedList<>();
        for (MusicBand musicBand: musicBandStorage) {
            MusicBandDTO musicBandDTO = musicBand.getMusicBandDTO();
            musicBandStorageDTO.add(musicBandDTO);
        }
        MusicBandServiceDTO serviceDTO = new MusicBandServiceDTO(musicBandStorageDTO);
        //TODO:filename
        XmlHelper.parseMusicBandsToXml(serviceDTO, "C:\\Users\\andye\\IdeaProjects\\Summer_labs\\src\\main\\resources\\output.xml");
    }
    public void exit() {
        this.setWorkState(false);
    }

    public void setWorkState(Boolean workState) {
        this.workState = workState;
    }

    public Boolean getWorkState() {
        return workState;
    }
    public void removeFirst() throws CollectionEmptyException {
        if (musicBandStorage.size() == 0) {
            throw new CollectionEmptyException("Collection is empty, cannot remove first");
        }
        musicBandStorage.poll();
    }

    public void removeHead() throws CollectionEmptyException {
        if (musicBandStorage.size() == 0) {
            throw new CollectionEmptyException("Collection is empty, cannot remove head");
        }
        System.out.println(musicBandStorage.poll().toString());
    }
    public void minByCreationDate() throws CollectionEmptyException {
        if (musicBandStorage.size() == 0) {
            throw new CollectionEmptyException("Collection is empty, cannot find min by creation date");
        }
        MusicBand tmp = musicBandStorage.peek();
        for (MusicBand musicBand : musicBandStorage) {
            if (musicBand.getCreationDate().isBefore(tmp.getCreationDate())){
                tmp = musicBand;
            }
        }
        System.out.println(tmp.toString());
    }
    public void filterLessThanFrontMan (Person startFrontMan) throws NoBandFoundException {
        List<MusicBand> foundMusicBands = musicBandStorage.stream()
                .filter(musicBand -> musicBand.getFrontMan().compareTo(startFrontMan) == -1)
                .collect(Collectors.toList());
        if (foundMusicBands.isEmpty()) {
            throw new NoBandFoundException("No bands with frontman less than put");
        }
        for (MusicBand foundMusicBand : foundMusicBands) {
            System.out.println(foundMusicBand.toString());
        }
    }
    //TODO printFieldAscendingGenre test
    public void printFieldAscendingGenre () throws CollectionEmptyException {
        if (musicBandStorage.size() == 0) {
            throw new CollectionEmptyException("Collection is empty");
        }
        for (MusicBand musicBand : musicBandStorage) {
            System.out.println(musicBand.getGenre().toString());
        }
    }
}
