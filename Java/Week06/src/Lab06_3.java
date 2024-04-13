import java.util.Objects;
class Student {
    private int id;
    private String name;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        if (s.hashCode()==this.hashCode()) return true;
        return false;
    }
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
public class Lab06_3 {
    public static void main(String[] args) {
        Student s1 = new Student(16, "dlwlrma");
        Student s2 = new Student(16, "dlwlrma");

        if (s1.equals(s2)) {
            System.out.println("s1 == s2");
        }
        else {
            System.out.println("s1 != s2");
        }
    }
}
