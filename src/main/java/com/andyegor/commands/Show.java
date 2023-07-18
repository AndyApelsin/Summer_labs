package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class Show implements Command {
    private MusicBandService musicBandService;

    public Show(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        musicBandService.show();
    }
}
