import com.andyegor.MusicBandService;
import com.andyegor.entity.*;
import com.andyegor.helper.InputHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
    private MusicBandService musicBandService;
    @BeforeEach
    public void SetUp(){
        this.musicBandService = new MusicBandService();
        musicBandService.uploadMusicBands("C:\\Users\\andye\\SummerLabs_files\\tmptest.xml");
    }

    @Test
    public void add_successfullyAdd(){

        MusicBand musicBand = new MusicBand("kish",
                new Coordinates(6, 6l),
                6l,
                MusicGenre.BLUES,
                new Person("Gorshok", 160f, 100, "666666",
                        new Location(6f, 6, 6,"hell")));
        musicBandService.add(musicBand);
        MusicBand found = null;
        for (MusicBand band : musicBandService.getMusicBandStorage()) {
            if(band.getName().equals("kish")){
                found = band;
                break;
            }
        }
        Assertions.assertEquals("kish", found.getName());
    }
}
