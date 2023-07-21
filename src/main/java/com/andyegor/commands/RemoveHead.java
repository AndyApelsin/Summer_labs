package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.exception.CollectionEmptyException;

public class RemoveHead implements Command{
    private MusicBandService musicBandService;

    public RemoveHead(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        try {
            musicBandService.removeHead();
        } catch (CollectionEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
