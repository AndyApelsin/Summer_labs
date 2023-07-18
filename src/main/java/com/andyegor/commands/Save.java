package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class Save implements Command{
    private MusicBandService musicBandService;

    public Save(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    //TODO exception
    public void execute() {
        musicBandService.save();
    }
}
