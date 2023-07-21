package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.exception.NoBandFoundException;
import com.andyegor.helper.InputHelper;

public class RemoveById implements Command{
    private MusicBandService musicBandService;

    public RemoveById(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }
    @Override
    public void execute() {
        int bandId = InputHelper.idInput();
        try {
            musicBandService.removeById(bandId);
        } catch (NoBandFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
