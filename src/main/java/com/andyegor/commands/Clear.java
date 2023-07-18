package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class Clear implements Command{
    private MusicBandService musicBandService;

    public Clear(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        musicBandService.clear();
    }
}
