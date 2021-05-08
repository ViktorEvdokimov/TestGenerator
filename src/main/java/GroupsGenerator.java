public class GroupsGenerator {
    private String[] names = new String[]{"IT", "DevOps", "Testers", "Managers", "Students", "OfficeManagers",
    "Engineers", "Unemployed", "IE", "Developers"};

    public Group[] generateGroups(int quantityOfGroups, int quantityOfPersons){
        Group[] groups = new Group[quantityOfGroups];
        int[] nameNumbersArray = getNameNumbersArray(quantityOfGroups);
        int[] quantityArray = getQuantityArray(quantityOfGroups, quantityOfPersons);
        for (int i = 0; i < (quantityOfGroups); i++) {
            groups[i] = getRandomGroup(quantityArray[i], nameNumbersArray[i]);
        }
        return groups;
    }

    public Group getRandomGroup (int personsQuantity, int nameNumber) {
        PersonsGenerator pg = new PersonsGenerator();
        Person[] persons = pg.getPersonArray(personsQuantity);
        String name = names[nameNumber];
        return new Group(name, persons);
    }

    private int[] getNameNumbersArray(int quantityOfGroups){
        int[] nameNumbers = new int[quantityOfGroups];
        for (int i = 0; i < (quantityOfGroups); i++) {
            int nameNumber;
            boolean isNameNumberBusy;
            do {
                nameNumber = (int) (Math.random() * names.length + 1);
                isNameNumberBusy = false;
                for (int number : nameNumbers) {
                    if ((number) == nameNumber) {
                        isNameNumberBusy = true;
                    }
                }
            }while (isNameNumberBusy);
            nameNumbers[i] = nameNumber;
        }
        for (int i = 0; i < quantityOfGroups; i++) {
            nameNumbers[i]--;
        }
        return nameNumbers;
    }

    private int[] getQuantityArray (int quantityOfGroups, int quantityOfPersons){
        int countOfDefinedPersons = 0;
        int[] quantityArray = new int[quantityOfGroups];
        for (int i = 0; i < (quantityOfGroups); i++) {
            int quantityOfDefinedPersons;
            if (i < (quantityOfGroups-1)) {
                quantityOfDefinedPersons = (int) (Math.random() * (quantityOfPersons - countOfDefinedPersons)
                        * 2 / (quantityOfGroups - i));
            } else quantityOfDefinedPersons = quantityOfPersons - countOfDefinedPersons;
            quantityArray[i] = quantityOfDefinedPersons;
        }
        return quantityArray;
    }
}
