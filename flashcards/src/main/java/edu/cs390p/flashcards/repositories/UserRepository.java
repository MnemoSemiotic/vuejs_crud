package edu.cs390p.flashcards.repositories;

import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.cs390p.flashcards.entities.User;

/**
 * Data repository interface for User class. Using Repository pattern over DAO
 * pattern due to available documentation.
 */
@RepositoryRestResource
@Persistent
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Finds a user by id.
     *
     * @param id the user's id
     * @return the user
     */
    User findById(String id);

    /**
     * Finds all users.
     *
     * @return the list of users
     */
    List<User> findAll();
}
