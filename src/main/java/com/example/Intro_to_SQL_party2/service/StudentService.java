package com.example.Intro_to_SQL_party2.service;

import com.example.Intro_to_SQL_party2.model.Student;
import com.example.Intro_to_SQL_party2.repository.StudentByCategory;
import com.example.Intro_to_SQL_party2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


    public Collection<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    public Student findByName(String name) {
        return studentRepository.findByNameIgnoreCase(name);
    }

    public Collection<Student> findStudentByName(String name) {
        return studentRepository.findStudentByNameContainsIgnoreCase(name);
    }

    public Collection<Student> findAllByNameContains(String namePart) {
        return studentRepository.findAllByNameContainsIgnoreCase(namePart);
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public List<StudentByCategory> getStudentsCount() {
        return studentRepository.getStudentsCount();
    }
    public double avgAgeByStudents() {
        return studentRepository.avgAgeByStudents();
    }

    public List<StudentByCategory> getLastFiveStudent() {
        return studentRepository.getLastFiveStudent();
    }
}

