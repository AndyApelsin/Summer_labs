package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class PrintFieldAscendingGenre implements Command {
    private MusicBandService musicBandService;

    public PrintFieldAscendingGenre (MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        musicBandService.printFieldAscendingGenre();
    }
}
