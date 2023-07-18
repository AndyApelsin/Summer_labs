package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.entity.MusicBand;
import com.andyegor.helper.InputHelper;

public class UpdateById implements Command {
    private MusicBandService musicBandService;

    public UpdateById(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        int oldId = InputHelper.idInput();
        MusicBand newMusicBand = InputHelper.bandInput();
        musicBandService.updateById(oldId, newMusicBand);
    }
}