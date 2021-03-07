package com.knoldus;

import java.util.*;

//Class for ClassRoom that contains roomId and student list.//
class ClassRoom {
    int roomId;
    Optional<List<Student>> studentList;


    /*
     * Constructor of class Classroom.
     */
    ClassRoom(int roomId, Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;
    }

    /*
     * Method to return if students are there in class
     * return boolean Return true if students are present, false otherwise.
     */
    public boolean hasStudent() {
        long count = studentList.get().stream()
                .filter(student -> student.subjects.get().size() == 0)
                .count();
        if(count != 0) return true;
        else return false;
    }

    /*
     * Method to return student name associated with particular subjects
     */
    public boolean studentsWithParticularRoomId() {
        studentList.get().stream()
                .filter(student -> this.roomId == roomId)
                .forEach(student -> System.out.println("Student name : " + student.name + ", Student subjects :" + student.subjects +", Student room Id :" + student.roomID));
        return true;
    }

    /*
     *Method to return student name who is not associated with any subject
     */
    public void studentWithNoSubjects() {
        studentList.get().stream()
                .filter(student -> student.subjects.get().size() == 0)
                .forEach(student -> System.out.println("Student which has no subjects associated with it "+student.name));
    }
}

//Class for Student that contains student name, roll number and subject list.//
class Student {
    String name;
    int rollNumber;
    Optional<List<String>> subjects;
    int roomID;

    /*
     * Constructor of class Student.
     */
    Student(String name, int rollNumber, Optional<List<String>> subjects, int roomID) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
        this.roomID = roomID;
    }

}

//Main class of the program//
class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hindi");
        list1.add("C");

        Optional<List<String>> subjectList1 = Optional.of(list1);

        Student student1 = new Student("Vaibhav",1,subjectList1, 301);

        List<String> list2 = new ArrayList<>();
        list2.add("English");
        list2.add("C++");

        Optional<List<String>> subjectList2 = Optional.of(list2);

        Student student2 = new Student("Gaurav",2,subjectList2, 301);

        List<String> list3 = new ArrayList<>();

        Optional<List<String>> subjectList3 = Optional.of(list3);

        Student student3 = new Student("Harshit",3,subjectList3, 301);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Optional<List<Student>> studentList = Optional.of(students);

        ClassRoom room = new ClassRoom(301,studentList);

        //Student with no associated subjects
        room.studentWithNoSubjects();

        // students with particular room ID
        boolean flag1 =  room.studentsWithParticularRoomId();
        // System.out.println(flag1);

        // If a room has students associated with it or not
        boolean flag = room.hasStudent();

        if(flag) {
            System.out.println("Hello Students!");
        }
        else {
            System.out.println("Room " + room.roomId + "has no students in it");
        }
    }
}