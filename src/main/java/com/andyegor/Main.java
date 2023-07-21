package com.andyegor;

import com.andyegor.commands.*;
import com.andyegor.helper.LimitedQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicBandService service = new MusicBandService();
        service.uploadMusicBands(System.getenv("VAR"));

        LimitedQueue<String> history = new LimitedQueue<>(7);
        Map<Integer, Command> commandMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Command helpCommand = new Help(service);
        commandMap.put(1, helpCommand);
        Command infoCommand = new Info(service);
        commandMap.put(2, infoCommand);
        Command showCommand = new Show(service);
        commandMap.put(3, showCommand);
        Command addCommand = new Add(service);
        commandMap.put(4, addCommand);
        Command updateByIdCommand = new UpdateById(service);
        commandMap.put(5, updateByIdCommand);
        Command removeByIdCommand = new RemoveById(service);
        commandMap.put(6, removeByIdCommand);
        Command clearCommand = new Clear(service);
        commandMap.put(7, clearCommand);
        Command saveCommand = new Save(service);
        commandMap.put(8, saveCommand);
        Command executeScriptByFilenameCommand = new ExecuteScriptByFilename();
        commandMap.put(9, executeScriptByFilenameCommand);
        Command exitCommand = new Exit(service);
        commandMap.put(10, exitCommand);
        Command removeFirstCommand = new RemoveFirst(service);
        commandMap.put(11, removeFirstCommand);
        Command removeHeadCommand = new RemoveHead(service);
        commandMap.put(12, removeHeadCommand);
        Command minByCreationDateCommand = new MinByCreationDate(service);
        commandMap.put(14, minByCreationDateCommand);
        Command filterLessThanFrontManCommand = new FilterLessThanFrontMan(service);
        commandMap.put(15, filterLessThanFrontManCommand);
        Command printFieldAscendingGenreCommand = new PrintFieldAscendingGenre(service);
        commandMap.put(16, printFieldAscendingGenreCommand);

        while (service.getWorkState()) {
            System.out.println("""
                    What do you want to do?
                    1. help
                    2. info
                    3. show
                    4. add element
                    5. update element by id
                    6. remove by id
                    7. clear collection
                    8. save in file
                    9. execute script by filename
                    10. exit
                    11. remove first element
                    12. print and remove first element
                    13. command history
                    14. min by creation date
                    15. filter less than front man
                    16. print genre of sorted elements
                    """);
            int num = scanner.nextInt();
            scanner.nextLine(); // вызов чтобы убрать символ переноса строки
            switch (num) {
                case 1 -> {
                    commandMap.get(1).execute();
                }
                case 2 -> {
                    commandMap.get(2).execute();
                }
                case 3 -> {
                    commandMap.get(3).execute();
                }
                case 4 -> {
                    commandMap.get(4).execute();
                }
                case 5 -> {
                    commandMap.get(5).execute();
                }
                case 6 -> {
                    commandMap.get(6).execute();
                }
                case 7 -> {
                    commandMap.get(7).execute();
                }
                case 8 -> {
                    commandMap.get(8).execute();
                }
                case 9 -> {
                    //Это сделано ради того, чтобы избежать циклической ссылки внутри commandMap на executeScriptCommand
                    ExecuteScriptByFilename executeCommand = (ExecuteScriptByFilename) commandMap.get(9);
                    executeCommand.setCommandMap(commandMap);
                    executeCommand.execute();
                }
                case 10 -> {
                    commandMap.get(10).execute();
                }
                case 11 -> {
                    commandMap.get(11).execute();

                }
                case 12 -> {
                    commandMap.get(12).execute();
                }
                case 13 -> {
                    //TODO stringpool char good or bad; how sout works with stringpool
                    for (String command: history) {
                        System.out.print(command + ' ');
                    }
                }
                case 14 -> {
                    commandMap.get(14).execute();;
                }
                case 15 -> {
                    commandMap.get(15).execute();
                }
                case 16 -> {
                    commandMap.get(16).execute();
                }
            }
            history.add(commandMap.get(num).getClass().getName());
        }
    }
}