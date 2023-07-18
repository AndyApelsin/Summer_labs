package com.andyegor;

import com.andyegor.DTO.MusicBandServiceDTO;
import com.andyegor.comparator.MusicBandComparator;
import com.andyegor.entity.MusicBand;
import com.andyegor.entity.Person;
import com.andyegor.helper.ValidationHelper;
import com.andyegor.helper.XmlHelper;
import lombok.Getter;

import java.time.LocalDateTime;
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
        MusicBandServiceDTO serviceDTO = XmlHelper.parseXmlToMusicBands(filename);
        for (MusicBand musicBand: serviceDTO.getMusicBandStorage()){
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
    public void updateById(long oldBandID, MusicBand newMusicBand) {
        MusicBand foundMusicBand = musicBandStorage.stream()
                .filter(musicBand -> musicBand.getId() == oldBandID)
                .findFirst()
                .orElse(null);
        ValidationHelper.checkForNull(foundMusicBand, "no band with such ID");
        musicBandStorage.add(newMusicBand);
        musicBandStorage.remove(foundMusicBand);
    }
    public void removeById (long id) {
        MusicBand foundMusicBand = musicBandStorage.stream() //перевели коллекцию в стрим
                .filter(musicBand -> musicBand.getId() == id) //выбрали из коллекции те муз группы, которые подходят по айди
                .findFirst()
                .orElse(null);
        ValidationHelper.checkForNull(foundMusicBand, "no band with such id");
        musicBandStorage.remove(foundMusicBand);
    }
    public void clear() {
        musicBandStorage.clear();
    }
    public void save() {
        MusicBandServiceDTO serviceDTO = new MusicBandServiceDTO(musicBandStorage);
        XmlHelper.parseMusicBandsToXml(serviceDTO, "./MusicBands.xml");
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
    public void removeFirst() {
        if (musicBandStorage.size() == 0) {
            throw new RuntimeException("collection empty");
        }
        musicBandStorage.poll();
    }

    public void removeHead() {
        if (musicBandStorage.size() == 0) {
            throw new RuntimeException("collection empty");
        }
        System.out.println(musicBandStorage.poll().toString());
    }
    public void minByCreationDate(){
        MusicBand tmp = musicBandStorage.peek();
        for (MusicBand musicBand : musicBandStorage) {
            if (musicBand.getCreationDate().isBefore(tmp.getCreationDate())){
                tmp = musicBand;
            }
        }
        System.out.println(tmp.toString());
    }
    public void filterLessThanFrontMan (Person startFrontMan) {
        List<MusicBand> foundMusicBands = musicBandStorage.stream()
                .filter(musicBand -> musicBand.getFrontMan().compareTo(startFrontMan) == -1)
                .collect(Collectors.toList());
        if (foundMusicBands.isEmpty()) {
            System.out.println("No bands with such front man");
        } else {
            for (MusicBand foundMusicBand : foundMusicBands) {
                System.out.println(foundMusicBand.toString());
            }
        }
    }
    //TODO printFieldAscendingGenre test
    public void printFieldAscendingGenre () {
        for (MusicBand musicBand : musicBandStorage) {
            System.out.println(musicBand.getGenre().toString());
        }
    }
}
