import javax.management.MBeanServerInvocationHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;

class Student {
    private String name;
    private String birth;
    private int height;

    Student(String name, String birth, int height) {
        this.name = name;
        this.birth = birth;
        this.height = height;
    }

    String printInfo() {
        return name + " " + birth + " " + height;
    }
}
public class Lab07_4 {
    public static void main(String[] args) {
        HashMap<Student, Integer> h = new HashMap<>();

        h.put(new Student("dlwlrma","930516", 162), 10000);
        h.put(new Student("pby","900212", 158), 15000);
        h.put(new Student("pby","000720", 158), 15000);
        h.put(new Student("dlwlrma","930516", 162), 20000);

        for(Map.Entry<Student, Integer> s : h.entrySet()) {
            System.out.println(s.getKey().printInfo() + " " + s.getValue());
        }
    }
}
