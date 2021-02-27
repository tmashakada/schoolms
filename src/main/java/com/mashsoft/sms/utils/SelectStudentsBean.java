package com.mashsoft.sms.utils;


import com.mashsoft.sms.controllers.StudyGroupBean;
import com.mashsoft.sms.domain.Student;
import com.mashsoft.sms.services.StudentService;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class SelectStudentsBean {

    @ManagedProperty(value = "#{studyGroupBean}")
    private StudyGroupBean studyGroupBean;
    @ManagedProperty(value = "#{studentService}")
    private StudentService studentService;

    private List<Student> selectedStudents = new ArrayList<>();

    @Transactional
    public void assignStudents() {
        for(Student student : selectedStudents) {
            student.setStudyGroup(studyGroupBean.getCurrentStudyGroup());
            studentService.saveStudent(student);
        }
        RequestContext.getCurrentInstance().closeDialog(selectedStudents);
        selectedStudents = new ArrayList<>();
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }

    public StudyGroupBean getStudyGroupBean() {
        return studyGroupBean;
    }

    public void setStudyGroupBean(StudyGroupBean studyGroupBean) {
        this.studyGroupBean = studyGroupBean;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
