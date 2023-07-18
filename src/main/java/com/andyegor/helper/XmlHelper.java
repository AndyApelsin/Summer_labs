package com.andyegor.helper;

import com.andyegor.DTO.MusicBandServiceDTO;
import com.andyegor.MusicBandService;
import com.andyegor.entity.MusicBand;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;

public class XmlHelper {
    public static void parseMusicBandsToXml (MusicBandServiceDTO serviceDTO, String filename) {
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        Path fileOut = Paths.get(filename);
        try (
                OutputStream outputStream =
                        new BufferedOutputStream(Files.newOutputStream(fileOut));
                ){
            XMLEventWriter xew = xof.createXMLEventWriter(outputStream);
            JAXBContext jc = JAXBContext.newInstance(MusicBandServiceDTO.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(serviceDTO, xew);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static MusicBandServiceDTO parseXmlToMusicBands (String filename){
        XMLInputFactory xif = XMLInputFactory.newFactory();
        final Path fileIn = Paths.get(filename);
        try(InputStreamReader inputStreamReader =
                    new InputStreamReader(Files.newInputStream(fileIn));) {
            XMLEventReader xer = xif.createXMLEventReader(inputStreamReader);
            JAXBContext jc = JAXBContext.newInstance(MusicBandServiceDTO.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            MusicBandServiceDTO serviceDTO = null;
            while(xer.hasNext()) {
                if(xer.peek().isStartElement() && xer.peek().asStartElement().getName().getLocalPart().equals("musicBandServiceDTO")){
                serviceDTO = (MusicBandServiceDTO) unmarshaller.unmarshal(xer);}
                else{
                xer.nextEvent();
                }
            }
            return serviceDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
