package com.andyegor;

import com.andyegor.DTO.MusicBandServiceDTO;
import com.andyegor.comparator.MusicBandComparator;
import com.andyegor.entity.*;
import com.andyegor.helper.XmlHelper;

import java.util.PriorityQueue;
import java.util.Queue;

public class test
{
    public static void main(String[] args) {
        MusicBand musicBand1 = new MusicBand("kish",
                new Coordinates(6, 6l),
                6l,
                MusicGenre.BLUES,
                new Person("Gorshok", 160f, 100, "666666",
                        new Location(6f, 6, 6,"hell")));
        MusicBand musicBand2 = new MusicBand("shish",
                new Coordinates(5, 5l),
                6l,
                MusicGenre.BLUES,
                new Person("nosok", 160f, 100, "555555",
                        new Location(6f, 6, 6,"hell")));
        MusicBandServiceDTO serviceDTO = new MusicBandServiceDTO();
        Queue<MusicBand> queue = new PriorityQueue<>(new MusicBandComparator());
        queue.add(musicBand2);
        queue.add(musicBand1);
        serviceDTO.setMusicBandStorage(queue);
        XmlHelper.parseMusicBandsToXml(serviceDTO, "C:\\Users\\andye\\SummerLabs_files\\tmptest.xml");
    }
}
