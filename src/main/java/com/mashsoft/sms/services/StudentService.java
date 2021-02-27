package com.mashsoft.sms.services;

import com.mashsoft.sms.domain.Student;
import com.mashsoft.sms.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return (List) studentRepository.findAll();
    }

    public List<Student> findByStudyGroupId(Long studyGroupId) {
        return (List) studentRepository.findByStudyGroupId(studyGroupId);
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
