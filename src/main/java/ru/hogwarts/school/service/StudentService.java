package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private Long studentId = 1L;

    public Student createStudent(Student student) {
        student.setId(studentId);
        studentMap.put(studentId, student);
        studentId++;
        return student;
    }

    public Student getStudentById(Long studentId) {
        return studentMap.get(studentId);
    }

    public Student updateStudent(Long studentId, Student student) {
        studentMap.put(studentId, student);
        return student;
    }

    public Student deleteStudent(Long studentId) {
        return studentMap.remove(studentId);
    }

    public List<Student> getByAge(int age) {
        Collection<Student> allStudents = studentMap.values();
        List<Student> studentsByAge = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }
}
