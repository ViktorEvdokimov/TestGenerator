package ru.evdokimov.testdatagetnerator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.validators.PositiveInteger;
import ru.evdokimov.testdatagetnerator.Entities.Group;
import ru.evdokimov.testdatagetnerator.Entities.GroupsGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class Main {
    @Parameter(names="-gc", validateWith = PositiveInteger.class)
     int gc;

    @Parameter(names="-pc", validateWith = PositiveInteger.class)
     int pc;

    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder().addObject(main).build().parse(args);
        main.createJsonFile();
        System.out.println("Complete");
    }

    public void createJsonFile (){
        int groupCount = 25;
        int personCount = 500;
        if(gc > 0) groupCount = gc;
        if(pc > 0) personCount = pc;
        System.out.println("Group count: " + groupCount + "\nPerson count: " + personCount);
        GroupsGenerator gg = new GroupsGenerator("src/main/resources/Data/");
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
