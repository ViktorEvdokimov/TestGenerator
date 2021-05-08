
import java.util.UUID;

public class Person {
    private String fullName;
    private String address;
    private long phoneNumber;
    private UUID GUID;

    public Person(String fullName, String address, long phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.GUID = UUID.randomUUID();
    }

    public Person(String firstName, String lastName, String patronymic, String address, long phoneNumber) {
        this(lastName + ' ' + firstName + ' ' + patronymic, address, phoneNumber);
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
