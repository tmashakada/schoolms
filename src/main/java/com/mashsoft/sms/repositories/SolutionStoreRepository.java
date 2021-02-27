package com.mashsoft.sms.repositories;

import com.mashsoft.sms.domain.SolutionStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionStoreRepository extends CrudRepository<SolutionStore, Long> {

    public SolutionStore findByAssignmentId(Long id);
}
