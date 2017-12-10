package edu.cs390p.flashcards.services;

import java.util.List;

import edu.cs390p.flashcards.entities.User;
import edu.cs390p.flashcards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The user service class.
 */
@Service
public class UserService {

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /**
     * Gets the list of all users.
     * @return the list of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Gets a user by id.
     * @param id the user id
     * @return the user
     */
    public User getUser(final String id) {
        return userRepository.findOne(id);
    }

    /**
     * Adds a user.
     * @param user the user to add
     */
    public void addUser(final User user) {
        userRepository.save(user);
    }

    /**
     * Updates a user.
     * @param user the user to update
     */
    public void updateUser(final User user) {
        userRepository.save(user);
    }

    /**
     * Deletes a user.
     * @param id the user id
     */
    public void deleteUser(final String id) {
        userRepository.delete(id);
    }
}
