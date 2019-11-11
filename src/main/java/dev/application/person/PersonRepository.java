package dev.application.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    
    @Query(
        value = "SELECT * FROM person WHERE first_name = :first_name"
        ,nativeQuery = true
    )
    List<Person> findByFirstName (@Param("first_name") String first_name);

    @Query(
        value = "select MAX(id) from person"
        ,nativeQuery = true
    )
    Long getLastId ();
}