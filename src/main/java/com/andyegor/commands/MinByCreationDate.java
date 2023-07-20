package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.exception.CollectionEmptyException;

public class MinByCreationDate implements Command {
    private MusicBandService musicBandService;

    public MinByCreationDate(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        try {
            musicBandService.minByCreationDate();
        } catch (CollectionEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}