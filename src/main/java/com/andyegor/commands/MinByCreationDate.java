package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class MinByCreationDate implements Command {
    private MusicBandService musicBandService;

    public MinByCreationDate(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        musicBandService.minByCreationDate();
    }
}