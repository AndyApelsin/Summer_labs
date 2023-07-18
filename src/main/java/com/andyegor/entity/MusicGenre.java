package com.andyegor.entity;

import jakarta.xml.bind.annotation.XmlEnum;
import lombok.Getter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@Getter
@XmlEnum
public enum MusicGenre {
    PSYCHEDELIC_CLOUD_RAP,
    JAZZ,
    SOUL,
    BLUES;
    public String value(){
        return name();
    }
    public static MusicGenre fromValue(String value){
        return valueOf(value);
    }
}