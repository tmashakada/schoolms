package com.mashsoft.sms.repositories;

import com.mashsoft.sms.domain.StudyGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends CrudRepository<StudyGroup, Long> {

}
