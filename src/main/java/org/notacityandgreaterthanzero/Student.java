public class Student implements Cloneable {
    String firstName;
    String lastName;
    Address address;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    public Student(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Student clone() {
        Student s;
        try {
            s = (Student) super.clone();
        }
        catch(CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        s.address = (Address) this.address.clone();
        return s;
    }

    public static void main(String[] args) {
        Address a = new Address("200 Lacebark", "Schererville", "Indiana");
        Student s = new Student("al", "pizano", a);

        // SHALLOW COPY
        Student s2 = s.clone();

        // Object is modified when original is modified (address)
        s.address.street = "300";
        // String field is deep copy however
        s.firstName = "bob";

        System.out.println("do both objects point to same object?: ");
        System.out.println(s == s2);
        System.out.println(s.toString());
        System.out.println(s2.toString());



    }
}

class Address implements Cloneable{
    String street;
    String city;
    String state;

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    @Override
    public Address clone() {
        Address a;
        try {
            a = (Address) super.clone();
        }
        catch(CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        return a;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public void setState(String state) {
        this.state = state;
    }
}

