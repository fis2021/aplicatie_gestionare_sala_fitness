package org.fis.maven.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis.maven.model.CustomerEvolution;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static org.fis.maven.services.FileSystemService.getPathToFile;

public class CustomerEvolutionService {

    private static ObjectRepository<CustomerEvolution> customerEvolutionRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("CustomerEvolution.db").toFile())
                .openOrCreate("test", "test");

        customerEvolutionRepository = database.getRepository(CustomerEvolution.class);
    }

    public static void addCustomerEvolution(String name, String Kg, String Inaltimea, String CentimetriiTaliei)
            throws NullPointerException {

        customerEvolutionRepository.insert(new CustomerEvolution(name, Kg, Inaltimea, CentimetriiTaliei));
    }

    public static ArrayList<CustomerEvolution> getevolutii(){
        ArrayList<CustomerEvolution> evolutii= new ArrayList<CustomerEvolution>();
        for(CustomerEvolution c:customerEvolutionRepository.find()){
            {
                evolutii.add(c);
            }
        }
        return evolutii;
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
