package com.kapango.morty.repo;

import com.kapango.morty.api.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface IncidentRepository extends MongoRepository<Incident, String> {


    List<Incident> findAllBySeverity(@Param("severity") String severity);

    List<Incident> findAllBySystemsIsContaining(@Param("system") List<String> systems);

    List<Incident> findAllByState(@Param("state") String state);
}
