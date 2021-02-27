package com.mashsoft.sms.repositories;

import com.mashsoft.sms.domain.Solution2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends CrudRepository<Solution2, Long>{
}
