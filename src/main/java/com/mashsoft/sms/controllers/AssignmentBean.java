package com.mashsoft.sms.controllers;

import com.mashsoft.sms.domain.Assignment;
import com.mashsoft.sms.domain.SolutionStore;
import com.mashsoft.sms.domain.StudyGroup;
import com.mashsoft.sms.services.AssignmentService;
import com.mashsoft.sms.services.SolutionStoreService;
import com.mashsoft.sms.utils.FacesMessageFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class AssignmentBean {

    @ManagedProperty(value = "#{assignmentService}")
    private AssignmentService assignmentService;
    @ManagedProperty(value = "#{solutionStoreService}")
    private SolutionStoreService solutionStoreService;
    @ManagedProperty(value = "#{solutionStoreBean}")
    private SolutionStoreBean solutionStoreBean;

    private Assignment assignment = new Assignment();
    private List<Assignment> assignments = new ArrayList<>();
    private List<StudyGroup> selectedStudyGroups = new ArrayList<>();

    public String saveAssignment() {
        assignmentService.saveAssignment(assignment);
        // create SolutionStore
        solutionStoreService.saveSolutionStore(createSolutionStore());
        resetAssignment();
        // send email
        FacesContext.getCurrentInstance().addMessage(null, FacesMessageFactory.onObjectCreation(assignment));
        return "/assignments?faces-redirect=true";
    }

    public String showDetail() {
        return "assignmentDetail";
    }

    private SolutionStore createSolutionStore() {
        SolutionStore solutionStore = new SolutionStore();
        solutionStore.setAssignment(assignment);
        solutionStore.setStudyGroups(selectedStudyGroups);
        return solutionStore;
    }

    private void resetAssignment() {
        this.assignment = new Assignment();
    }

    public AssignmentService getAssignmentService() {
        return assignmentService;
    }

    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment newAssignment) {
        this.assignment = newAssignment;
    }

    public SolutionStoreService getSolutionStoreService() {
        return solutionStoreService;
    }

    public void setSolutionStoreService(SolutionStoreService solutionStoreService) {
        this.solutionStoreService = solutionStoreService;
    }

    public List<Assignment> getAssignments() {
        assignments = assignmentService.findAll();
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public SolutionStoreBean getSolutionStoreBean() {
        return solutionStoreBean;
    }

    public void setSolutionStoreBean(SolutionStoreBean solutionStoreBean) {
        this.solutionStoreBean = solutionStoreBean;
    }

    public List<StudyGroup> getSelectedStudyGroups() {
        return selectedStudyGroups;
    }

    public void setSelectedStudyGroups(List<StudyGroup> selectedStudyGroups) {
        this.selectedStudyGroups = selectedStudyGroups;
    }
}
