package org.fis.maven.services;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis.maven.model.GymProgram;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static org.fis.maven.services.FileSystemService.getPathToFile;
public class GymProgramService {
    private static ObjectRepository<GymProgram> gymProgramRepository;
    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("GymProgram2.db").toFile())
                .openOrCreate("test", "test");
        gymProgramRepository = database.getRepository(GymProgram.class);
    }

    public static void addGymProgram(String Antrenament, String Ziua, String Ora,String Descriere)
            throws NullPointerException{
        gymProgramRepository.insert(new GymProgram(Antrenament, Ziua, Ora,Descriere));
    }
    public static void deleteGymProgram(String Antrenament, String Ziua, String Ora,String Descriere)
            throws NullPointerException{
        fileProgram(Antrenament, Ziua, Ora, Descriere);
    }
    public static void fileProgram(String Antrenament, String Ziua, String Ora,String Descriere) throws NullPointerException
    {
        for (GymProgram gym : gymProgramRepository.find()) {
            if (Antrenament.equals(gym.getAntrenament())) {
                if(Ziua.equals( gym.getZiua()))
                {
                    if(Ora.equals(gym.getOra()))
                    {
                        if(Descriere.equals(gym.getDescriere()))
                        {
                            gymProgramRepository.remove(gym);
                        }
                    }
                }
            }
        }
    }
    public static ArrayList<GymProgram> getPrograms(){
        ArrayList<GymProgram> programe= new ArrayList<GymProgram>();
        for(GymProgram g:gymProgramRepository.find()){
            programe.add(g);
        }
        return programe;
    }


    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }
}