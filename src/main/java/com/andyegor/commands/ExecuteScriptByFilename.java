package com.andyegor.commands;

import com.andyegor.helper.InputHelper;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
@Setter
@NoArgsConstructor
public class ExecuteScriptByFilename implements Command {
    private Map<Integer, Command> commandMap;

    @Override
    public void execute () {
        //TODO исправить вайл, чтобы работал без пробела в конце файла
        String filename = InputHelper.filenameInput();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            int tmp = inputStreamReader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (tmp != -1){
                if((char) tmp != ' '){
                    stringBuilder.append((char) tmp);
                }else {
                    String commandCode = stringBuilder.toString();
                    checkAndUseCommand(commandCode);
                    stringBuilder.setLength(0);
                }
                tmp = inputStreamReader.read();
            }
        } catch (Exception e) {
            //TODO
            throw new RuntimeException(e);
        }

    }
    private void checkAndUseCommand(String commandCode){
        int commandNumber = Integer.parseInt(commandCode);
        if( commandNumber <= 16 && commandNumber >= 1){
            commandMap.get(commandNumber).execute();
        }else{
            //TODO exception
            throw new RuntimeException();
        }

    }
}

