class People {
    private String name;
    private String ssn;

    void setName(String name) {
        this.name = name;
    }
    void setSsn(String ssn) {
        this.ssn = ssn;
    }
    String getName() {
        return this.name;
    }
    String getSsn() {
        return this.ssn;
    }
}

class Student extends People {
    private int Id;

    Student(String name, String ssn, int id) {
        setName(name);
        setSsn(ssn);
        this.Id = id;
    }

    int getId() {
        return Id;
    }
}
public class Lab05_1 {
    public static void main(String[] args) {
        Student s = new Student("dlwlrlma", "930516-2xxxxxx", 12231234);
        System.out.println("name : " + s.getName());
        System.out.println("ssn : " + s.getSsn());
        System.out.println("id : " + s.getId());
    }
}