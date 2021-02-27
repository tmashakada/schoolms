package com.mashsoft.sms.controllers;

import com.mashsoft.sms.domain.Student;
import com.mashsoft.sms.domain.StudyGroup;
import com.mashsoft.sms.services.StudentService;
import com.mashsoft.sms.services.StudyGroupService;
import com.mashsoft.sms.utils.FacesMessageFactory;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;

@ManagedBean
@SessionScoped
public class StudyGroupBean {

    Logger logger = LoggerFactory.getLogger(StudyGroupBean.class);

    @ManagedProperty(value = "#{studentService}")
    private StudentService studentService;
    @ManagedProperty(value = "#{studyGroupService}")
    private StudyGroupService studyGroupService;

    private List<StudyGroup> studyGroups;

    private StudyGroup studyGroup = new StudyGroup();

    private StudyGroup currentStudyGroup = new StudyGroup();

    @PostConstruct
    public void loadStudyGroups() {
        logger.debug("Post construct called..." + this.getClass().getName());
        studyGroups = studyGroupService.findAll();
    }

    public void selectStudents(StudyGroup studyGroup) {
        currentStudyGroup = studyGroup;
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("selectStudents", options, null);
    }

    public String saveStudyGroup() {
        studyGroupService.saveStudyGroup(studyGroup);
        studyGroup = new StudyGroup();
        studyGroups = studyGroupService.findAll();
        FacesContext.getCurrentInstance().addMessage(null, FacesMessageFactory.onObjectCreation(studyGroup));
        return "overview";
    }

    public List<Student> loadStudentForSelectedGroup(Long studyGroupId) {
        return studentService.findByStudyGroupId(studyGroupId);
    }

    public List<Student> getStudentsForCurrentGroup() {
        return studentService.findAll();
    }

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public StudyGroupService getStudyGroupService() {
        return studyGroupService;
    }

    public void setStudyGroupService(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public StudyGroup getCurrentStudyGroup() {
        return currentStudyGroup;
    }

    public void setCurrentStudyGroup(StudyGroup currentStudyGroup) {
        this.currentStudyGroup = currentStudyGroup;
    }
}
