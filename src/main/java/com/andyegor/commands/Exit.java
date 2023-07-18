package com.andyegor.commands;

import com.andyegor.MusicBandService;

public class Exit implements Command{

    private MusicBandService service;

    public Exit(MusicBandService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.exit();
    }
}
