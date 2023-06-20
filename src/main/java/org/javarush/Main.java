package org.javarush;

import org.javarush.entity.Office;
import org.javarush.repository.OfficeDbRepository;
import org.javarush.repository.hibernate.SessionCreator;

public class Main {
    public static void main(String[] args) {
        OfficeDbRepository repository = new OfficeDbRepository(SessionCreator.getInstance());

//        Office office = new Office("123","London","+44 20 7877 2041,25", "Old Broad Street,Level 7","UK","EC2N" ,"asdasd", "123", "123");


        Office office = repository.findById(1);

        System.out.println(office);
    }
}