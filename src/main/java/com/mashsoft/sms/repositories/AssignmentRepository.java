package com.mashsoft.sms.repositories;



import com.mashsoft.sms.domain.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {

}
