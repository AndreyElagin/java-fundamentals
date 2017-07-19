package javase02.t05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daddyingrave on 27/06/2017.
 * <p>
 * Задание 5. Параметризация, перечисления
 * Разработайте приложение, позволяющее формировать группы студентов по разным дисциплинам.
 * Состав групп может быть разным. Каждая дисциплина в отдельности определяет, целыми или
 * вещественными будут оценки по нет. Необходимо найти группы, в которые входит студент X,
 * и сравнить его оценки. Для огранизации перечня дисциплин можно использовать перечисление.
 */
public class Scheduler {

    private final List<StudyGroup> groups = new ArrayList<>();

    public Scheduler() {
        groups.add(new StudyGroup(Subjects.MATH));
        groups.add(new StudyGroup(Subjects.PHYSICS));
        groups.add(new StudyGroup(Subjects.HISTORY));
        groups.add(new StudyGroup(Subjects.FOREIGN_LANGUAGE));
    }

    public StudyGroup getStudyGroup(Subjects subject) {
        return groups.get(subject.ordinal());
    }

    public void assingToGroup(Student student, Subjects subject) {
        groups.get(subject.ordinal()).addStudent(student);
    }

    public void findGroups(Student student) {
        groups.stream()
                .filter(studyGroup -> studyGroup.isParticipant(student))
                .forEach(studyGroup -> {
                    System.out.printf("All assessments for student %s with id%d in group %s%n",
                            student.getName(), student.getId(), studyGroup.getSubject());
                    studyGroup.getStudentAssessments(student)
                            .forEach(number -> System.out.print(number + " "));
                    System.out.println();
                });
    }

}