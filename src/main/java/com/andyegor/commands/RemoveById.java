package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.helper.InputHelper;

public class RemoveById implements Command{
    private MusicBandService musicBandService;

    public RemoveById(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }
    @Override

    public void execute() {
        int bandId = InputHelper.idInput();
        musicBandService.removeById(bandId);
    }
}
