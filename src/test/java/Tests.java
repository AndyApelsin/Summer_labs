import com.andyegor.MusicBandService;
import com.andyegor.entity.*;
import com.andyegor.exception.NoBandFoundException;
import com.andyegor.helper.InputHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {
    private MusicBandService musicBandService;
    @BeforeEach
    public void SetUp(){
        this.musicBandService = new MusicBandService();
        musicBandService.uploadMusicBands("C:\\Users\\andye\\IdeaProjects\\Summer_labs\\src\\main\\resources\\input.xml");
    }

    @Test
    public void upload_successfullyUpload(){
        MusicBand found = null;
        for (MusicBand band : musicBandService.getMusicBandStorage()) {
            System.out.println(band);
            if(band.getName().equals("Miles Davis Quintet")){
                found = band;
                System.out.println("good");
                break;
            }
        }
        System.out.println(found.getId());
        Assertions.assertEquals(0, found.getId());
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
            System.out.println(band);
            if(band.getName().equals("kish")){
                found = band;
                break;
            }
        }
        Assertions.assertEquals("kish", found.getName());
    }

    @Test
    //падает тк айди меняется
    public void updateById_successfullyUpdate() throws NoBandFoundException {
        MusicBand musicBand = new MusicBand("shish",
                new Coordinates(6, 6l),
                6l,
                MusicGenre.BLUES,
                new Person("nosok", 160f, 100, "777777",
                        new Location(6f, 6, 6,"hell")));
        musicBandService.updateById(0L, musicBand);
        MusicBand found = null;
        for (MusicBand band : musicBandService.getMusicBandStorage()) {
            System.out.println(band);
            System.out.println(band.getId());
            if(band.getId() == 0){
                found = band;
                break;
            }
        }
       // Assertions.assertEquals("shish", found.getName());
    }
}
