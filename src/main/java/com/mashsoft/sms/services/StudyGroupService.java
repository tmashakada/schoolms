package com.mashsoft.sms.services;

import com.mashsoft.sms.domain.StudyGroup;
import com.mashsoft.sms.repositories.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupService {

    @Autowired
    private StudyGroupRepository studyGroupRepository;

    public List<StudyGroup> findAll(){
        return (List) studyGroupRepository.findAll();
    }

    public void saveStudyGroup(StudyGroup studyGroup) {
        studyGroupRepository.save(studyGroup);
    }
}
