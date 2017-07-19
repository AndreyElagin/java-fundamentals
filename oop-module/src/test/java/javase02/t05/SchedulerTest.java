package javase02.t05;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daddyingrave on 29/06/2017.
 */
public class SchedulerTest {

    @Test
    public void findGroups() throws Exception {
        Scheduler scheduler = new Scheduler();
        Student student = new Student("Egor");
        Student student1 = new Student("Egor2");
        Student student2 = new Student("Egor3");
        Student student3 = new Student("Egor4");
        Student student4 = new Student("Egor5");
        Student student5 = new Student("Egor6");
        scheduler.assingToGroup(student, Subjects.FOREIGN_LANGUAGE);
        scheduler.assingToGroup(student1, Subjects.FOREIGN_LANGUAGE);
        scheduler.assingToGroup(student2, Subjects.MATH);
        scheduler.assingToGroup(student3, Subjects.MATH);
        scheduler.assingToGroup(student4, Subjects.PHYSICS);
        scheduler.assingToGroup(student4, Subjects.HISTORY);
        scheduler.assingToGroup(student5, Subjects.PHYSICS);

        scheduler.getStudyGroup(Subjects.PHYSICS).toRateStudent(student4, 2.);
        scheduler.getStudyGroup(Subjects.PHYSICS).toRateStudent(student4, 1.3);
        scheduler.getStudyGroup(Subjects.PHYSICS).toRateStudent(student4, 5.8);
        scheduler.getStudyGroup(Subjects.HISTORY).toRateStudent(student4, 2);
        scheduler.getStudyGroup(Subjects.HISTORY).toRateStudent(student4, 4);
        scheduler.getStudyGroup(Subjects.HISTORY).toRateStudent(student4, 5);
        scheduler.findGroups(student4);
    }

}