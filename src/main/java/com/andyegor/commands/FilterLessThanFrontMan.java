package com.andyegor.commands;

import com.andyegor.MusicBandService;
import com.andyegor.entity.Person;
import com.andyegor.exception.NoBandFoundException;
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
        try {
            musicBandService.filterLessThanFrontMan(startFrontMan);
        } catch (NoBandFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
