package com.network.social.neo4j.repositories;

import com.network.social.neo4j.pojos.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
    Person findByName(String name);

    @Query("MATCH (p1) RETURN p1")
    Collection<Person> getAll();

    //    @Query("MATCH (p1:Person)-[r:IS_FRIEND]->(p2:Person) RETURN p1,r,p2 LIMIT {limit}")
    @Query("MATCH (p1)-[r:IS_FRIEND]->(p2) RETURN p1,r,p2")
    Collection<Person> getPeople();
}
