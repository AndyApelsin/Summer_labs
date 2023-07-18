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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandServiceDTO {
    @XmlElementWrapper
    @XmlElement(name = "musicbandstorage")
    private Queue<MusicBand> musicBandStorage;
}
