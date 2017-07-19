package javase02.t05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by daddyingrave on 28/06/2017.
 */
public class StudyGroup {

    private Subjects subject;
    private List<Student> students = new ArrayList<>();
    private HashMap<Student, List<Number>> assessments = new HashMap<>();

    public StudyGroup(Subjects subject) {
        this.subject = subject;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void toRateStudent(Student student, Number rate) {
        if (!subject.checkType(rate) || !students.contains(student))
            throw new UnsupportedOperationException();
        List<Number> rates = assessments.computeIfAbsent(student, k -> new ArrayList<>());
        rates.add(rate);
    }

    public List<Number> getStudentAssessments(Student student) {
        List<Number> ratings = assessments.get(student);
        if (ratings == null) throw new NoSuchElementException();
        return ratings;
    }

    public boolean isParticipant(Student student) {
        return students.contains(student);
    }

    public Subjects getSubject() {
        return subject;
    }

}