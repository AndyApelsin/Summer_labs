package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.exception.CollectionEmptyException;

public class PrintFieldAscendingGenre implements Command {
    private MusicBandService musicBandService;

    public PrintFieldAscendingGenre (MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        try {
            musicBandService.printFieldAscendingGenre();
        } catch (CollectionEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
