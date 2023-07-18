package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class RemoveFirst implements Command{
    private MusicBandService musicBandService;

    public RemoveFirst(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        musicBandService.removeFirst();
    }
}
