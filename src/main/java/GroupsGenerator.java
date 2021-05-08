public class GroupsGenerator {
    private String[] names = new String[]{"IT", "DevOps", "Testers", "Managers", "Students", "OfficeManagers",
    "Engineers", "Unemployed", "IE", "Developers"};

    public Group[] generateGroups(int quantityOfGroups, int quantityOfPersons){
        Group[] groups = new Group[quantityOfGroups];
        int countOfDefinedPersons = 0;
        PersonsGenerator pg = new PersonsGenerator();
        int[] usedNameNumbers = new int[quantityOfGroups];
        for (int i = 0; i < (quantityOfGroups); i++) {
            int quantityOfDefinedPersons;
            if (i < (quantityOfGroups-1)) {
                quantityOfDefinedPersons = (int) (Math.random() * (quantityOfPersons - countOfDefinedPersons)
                        * 2 / (quantityOfGroups - i));
            } else quantityOfDefinedPersons = quantityOfPersons - countOfDefinedPersons;
            countOfDefinedPersons +=quantityOfDefinedPersons;
            Person[] persons = pg.getPersonArray(quantityOfDefinedPersons);
            int nameNumber;
            boolean isNameNumberBusy;
            do {
                nameNumber = (int) (Math.random() * names.length + 1);
                isNameNumberBusy = false;
                for (int number : usedNameNumbers) {
                    if ((number) == nameNumber) {
                        isNameNumberBusy = true;
                    }
                }
            }while (isNameNumberBusy);
            usedNameNumbers[i] = nameNumber;
            String name = names[nameNumber-1];
            groups[i] = new Group(name, persons);
        }
        return groups;
    }
}
