package ru.geekbrains.spring_students.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring_students.models.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student(1L, "Андрей", 28));
        students.add(new Student(2L, "Алексей", 35));
        students.add(new Student(3L, "Вика", 25));
        students.add(new Student(4L, "Света", 32));
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    public List<Student> getById(Long id) {
        List<Student> studentsById = new ArrayList<>();
        for (Student student: students) {
            if (student.getId().equals(id))
                studentsById.add(student);
        }
        return Collections.unmodifiableList(studentsById);
    }

    public Student getStudentById(Long id) {
        List<Student> studentsById = new ArrayList<>();
        for (Student student: students) {
            if (student.getId().equals(id))
                return student;
        }
        return null;
    }

    public void save(Student student) {
        List<Student> studentsById = new ArrayList<>();
        for (Student onde_student: students) {
            if (onde_student.getId().equals(student.getId())) {
                onde_student.setName(student.getName());
                onde_student.setAge(student.getAge());
                return;
            }
        }
        students.add(student);
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }

}
