package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class RemoveHead implements Command{
    private MusicBandService musicBandService;

    public RemoveHead(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        musicBandService.removeHead();
    }
}
