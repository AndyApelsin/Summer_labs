package com.andyegor.DTO;

import com.andyegor.entity.MusicBand;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Queue;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "musicbandservicedto")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandServiceDTO {
    @XmlElementWrapper(name = "musicbandstorage")
    @XmlElement(name = "musicbanddto")
    private Queue<MusicBandDTO> musicBandStorage;
}
