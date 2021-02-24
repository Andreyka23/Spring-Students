package ru.geekbrains.spring_students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_students.models.Student;
import ru.geekbrains.spring_students.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public String getAllStudents(@RequestParam(name = "find_id", defaultValue = "0") Long find_id, Model model) {
        if (find_id > 0)
            model.addAttribute("students", studentService.getById(find_id));
        else
            model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @PostMapping("/add")
    public String getNewStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students/all";
    }


    @GetMapping("/edit")
    public String getEditStudent(@RequestParam(name = "id", defaultValue = "0") Long id, Model model) {
        if (id > 0) {
            model.addAttribute("student", studentService.getStudentById(id));
            return "edit";
        } else {
            return "redirect:/students/all";
        }
    }

    @PostMapping("/edit")
    public String postEditStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students/all";
    }

    @PostMapping("/find")
    public String findStudent(@RequestParam(name = "find_id", defaultValue = "0") String find_id) {
        //studentService.getById(student);
        return "redirect:/students/all?find_id=" + find_id;
    }

}
