package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.commands.Command;

public class Info implements Command {
    private MusicBandService musicBandService;

    public Info(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        musicBandService.info();
    }
}

