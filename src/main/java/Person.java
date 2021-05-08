public class Person {
    private String fullName;
    private String address;
    private long phoneNumber;
    private int GUID;

    public Person(String fullName, String address, long phoneNumber, int GUID) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.GUID = GUID;
    }

    public Person(String firstName, String lastName, String patronymic, String address, long phoneNumber, int GUID) {
        this.fullName = lastName + ' ' + firstName + ' ' + patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.GUID = GUID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getGUID() {
        return GUID;
    }

    @Override
    public String toString() {
        return "\n{\n" +
                "fullName = '" + fullName + "\',\n" +
                "address = '" + address + "\',\n" +
                "phoneNumber = " + phoneNumber + ",\n" +
                "GUID = " + GUID + "\n" +
                '}' ;
    }
}
