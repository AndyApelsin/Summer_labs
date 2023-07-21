package com.andyegor.helper;

import com.andyegor.DTO.MusicBandServiceDTO;
import jakarta.xml.bind.*;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlHelper {
    public static void parseMusicBandsToXml (MusicBandServiceDTO serviceDTO, String filename) {
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        Path fileOut = Paths.get(filename);
        try (
                OutputStream outputStream =
                        new BufferedOutputStream(Files.newOutputStream(fileOut));
        ) {
            XMLEventWriter xew = xof.createXMLEventWriter(outputStream);
            JAXBContext jc = JAXBContext.newInstance(MusicBandServiceDTO.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(serviceDTO, xew);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
        public static MusicBandServiceDTO parseXmlToMusicBands (String filename) throws IOException {
//        XMLInputFactory xif = XMLInputFactory.newFactory();
//        final Path fileIn = Paths.get(filename);
//        try(InputStreamReader inputStreamReader =
//                    new InputStreamReader(Files.newInputStream(fileIn));) {
//            XMLEventReader xer = xif.createXMLEventReader(inputStreamReader);
//            JAXBContext jc = JAXBContext.newInstance(MusicBandServiceDTO.class);
//            Unmarshaller unmarshaller = jc.createUnmarshaller();
//            MusicBandServiceDTO serviceDTO = null;
//            while(xer.hasNext()) {
//                if(xer.peek().isStartElement() && xer.peek().asStartElement().getName().getLocalPart().equals("musicBandServiceDTO")){
//                serviceDTO = (MusicBandServiceDTO) unmarshaller.unmarshal(xer);}
//                else{
//                xer.nextEvent();
//                }
//            }
//            return serviceDTO;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        // it is working
//        JAXBContext context = JAXBContext.newInstance(MusicBandServiceDTO.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        FileReader fileReader = new FileReader(filename);
//        return (MusicBandServiceDTO) unmarshaller.unmarshal(fileReader);

        InputStream inputStream = Files.newInputStream(Path.of(filename));
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {
            JAXBContext jc = null;
            try {
                jc = JAXBContext.newInstance(com.andyegor.DTO.MusicBandServiceDTO.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                return (MusicBandServiceDTO) unmarshaller.unmarshal(inputStreamReader);
            } catch (JAXBException e) {
                System.out.println("Problems with parsing the xml file");
                throw new RuntimeException(e);
            }
        }
    }
}
