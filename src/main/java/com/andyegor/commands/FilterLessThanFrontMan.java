package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.entity.Person;
import com.andyegor.helper.InputHelper;
import com.andyegor.helper.ValidationHelper;

public class FilterLessThanFrontMan implements Command {
    private MusicBandService musicBandService;

    public FilterLessThanFrontMan(MusicBandService musicBandService) {
        this.musicBandService = musicBandService;
    }

    @Override
    public void execute() {
        Person startFrontMan = InputHelper.personInput();
        musicBandService.filterLessThanFrontMan(startFrontMan);
    }
}
