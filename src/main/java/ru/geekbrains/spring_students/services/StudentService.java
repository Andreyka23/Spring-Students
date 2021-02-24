package ru.geekbrains.spring_students.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_students.models.Student;
import ru.geekbrains.spring_students.repositories.StudentRepository;

import java.util.List;

@Component
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setBoxRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<Student> getById(Long id) {
        return studentRepository.getById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
