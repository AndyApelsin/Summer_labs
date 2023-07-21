package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.entity.MusicBand;
import com.andyegor.exception.NoBandFoundException;
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
        try {
            musicBandService.updateById(oldId, newMusicBand);
        } catch (NoBandFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}