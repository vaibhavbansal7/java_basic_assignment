package com.knoldus;

import org.junit.Test;
import java.util.*;


public class ClassRoomTest {

    @Test
    public void invalidTestCaseForHasStudent(){
        List<Student> students= new ArrayList<>();
        Optional<List<Student>> studentList = Optional.of(students);
        ClassRoom room = new ClassRoom(301, studentList);

        assert(!room.hasStudent());
    }

    @Test
    public void validTestCaseForStudentsWithParticularRoomId(){
        Student student1 = new Student("Vaibhav", 1,  Optional.of(Arrays.asList("Physics", "Chemistry")),301);
        Student student2 = new Student("Gaurav", 2,  Optional.of(Arrays.asList("Physics", "Chemistry", "C++")),301);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Optional<List<Student>> studentList = Optional.of(students);
        ClassRoom room = new ClassRoom(301,studentList);

        assert(room.studentsWithParticularRoomId());
    }

    @Test
    public void invalidTestCaseForStudentsWithParticularRoomId(){
        Student student1 = new Student("Nitin", 1,  Optional.of(Arrays.asList("Physics", "Chemistry")), 301);
        Student student2 = new Student("Aman", 2,  Optional.of(Arrays.asList("Physics", "Chemistry", "C++")), 301);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Optional<List<Student>> studentList = Optional.of(students);
        ClassRoom room = new ClassRoom(111,studentList);

        assert(room.studentsWithParticularRoomId());
    }
}
