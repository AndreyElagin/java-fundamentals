package javase02.t05;

/**
 * Created by daddyingrave on 28/06/2017.
 */
public class Student {

    private final String name;
    private final int id = counter++;
    private static int counter;

    public Student(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id;
        return result;
    }

}
