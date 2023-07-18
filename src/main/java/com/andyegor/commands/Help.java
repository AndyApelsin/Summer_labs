package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.commands.Command;

public class Help implements Command {

    private MusicBandService musicBandService;
    public Help(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }
    @Override
    public void execute() {
        musicBandService.help();
    }
}

