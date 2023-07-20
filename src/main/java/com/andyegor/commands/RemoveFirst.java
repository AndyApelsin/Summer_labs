package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.exception.CollectionEmptyException;

public class RemoveFirst implements Command{
    private MusicBandService musicBandService;

    public RemoveFirst(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        try {
            musicBandService.removeFirst();
        } catch (CollectionEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
