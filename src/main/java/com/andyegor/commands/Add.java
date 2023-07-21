package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.entity.MusicBand;
import com.andyegor.helper.InputHelper;

public class Add implements Command{
    private MusicBandService musicBandService;

    public Add(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        MusicBand musicBand = InputHelper.bandInputGeneratesIdAndCreationDate();
        musicBandService.add(musicBand);
    }
}
