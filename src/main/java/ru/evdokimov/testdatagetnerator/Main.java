package ru.evdokimov.testdatagetnerator;

import ru.evdokimov.testdatagetnerator.Entities.Group;
import ru.evdokimov.testdatagetnerator.Entities.GroupsGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int groupCount = 25;
        int personCount = 500;
        try {
            if (args.length == 2) {
                System.out.println(Arrays.toString(args));
                groupCount = Integer.parseInt(args[0]);
                personCount = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e){
            System.out.println("Invalid arguments, please enter 2 positive integer numbers.");
            throw new RuntimeException(e);
        }
        createJsonFile("src/main/resources/Data/", groupCount, personCount);
    }

    public static void createJsonFile (String address, int groupCount, int personCount){
        GroupsGenerator gg = new GroupsGenerator(address);
        Group[] groupsArray = gg.generateGroups(groupCount, personCount);
        ObjectMapper obj = new ObjectMapper();
        try {
            String result = obj.writeValueAsString(groupsArray);
            WriterToFile writer = new WriterToFile("groups.json");
            writer.writeToFile(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
