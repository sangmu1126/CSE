class Student {
    private String name;
    private int birth;

    Student(String name, int birth) {
        this.name = name;
        this.birth = birth;
    }
    boolean isOlder(Student other) {
        return this.birth < other.birth;
    }

    String getName() {
        return this.name;
    }

}

public class Lab04_2 {
    public static void printInfor(Student std1, Student std2) {
        if (std1.isOlder(std2)) {
            System.out.println(std1.getName() + " > " + std2.getName());
        }
        else {
            System.out.println(std1.getName() + " <= " + std2.getName());
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("pby", 19900212);
        Student s2 = new Student("dlwlrlma", 19930516);
        Student s3 = new Student("JianLee", 19981104);
        printInfor(s1, s2);
        printInfor(s3, s2);
    }
}
