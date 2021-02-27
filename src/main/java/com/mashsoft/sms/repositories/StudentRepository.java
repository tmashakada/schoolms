package com.mashsoft.sms.repositories;

import com.mashsoft.sms.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByStudyGroupId(Long studyGroupId);

}
