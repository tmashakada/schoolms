package com.mashsoft.sms.services;

import com.mashsoft.sms.domain.Assignment;
import com.mashsoft.sms.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public void saveAssignment(Assignment assignment){
        assignmentRepository.save(assignment);
    }

    public List<Assignment> findAll() {
        return (List) assignmentRepository.findAll();
    }

    public AssignmentRepository getAssignmentRepository() {
        return assignmentRepository;
    }

    public void setAssignmentRepository(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }
}
