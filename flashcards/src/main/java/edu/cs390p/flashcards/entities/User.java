package edu.cs390p.flashcards.entities;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent User class.
 */
public class User {

    /** User's id number. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /** The user's first name. */
    private String firstName;

    /** The user's last name. */
    private String lastName;

    /** Default constructor for user class. */
    public User() {
        this.firstName = "First_Name";
        this.lastName = "Last_Name";
    }

    /**
     * Constructor.
     *
     * @param newFirstName the user's first name
     * @param newLastName the user's last name
     */
    public User(final String newFirstName, final String newLastName) {
        if (newFirstName == null || newFirstName.equals("")) {
            this.firstName = "First_Name";
        } else {
            this.firstName = newFirstName;
        }
        if (newLastName == null || newLastName.equals("")) {
            this.lastName = "Last_Name";
        } else {
            this.lastName = newLastName;
        }
    }

    /**
     * Returns the first name of the User.
     *
     * @return first name
     * @throws Exception if the first name field is blank
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the User.
     *
     * @return last name
     * @throws Exception if the last name field is blank
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the id number of the User.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the user's id.
     *
     * @param newId the id number
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Sets the user's first name.
     *
     * @param newFirstName the first name
     * @throws IllegalArgumentException if the first name value is null or empty
     */
    public void setFirstName(final String newFirstName)
            throws IllegalArgumentException {
        if (newFirstName == null || newFirstName.equals("")) {
            throw new IllegalArgumentException(
                    "First name must not be empty or null.");
        }
        this.firstName = newFirstName;
    }

    /**
     * Sets the user's last name.
     *
     * @param newLastName the last name
     * @throws IllegalArgumentException if the last name value is null or empty
     */
    public void setLastName(final String newLastName)
            throws IllegalArgumentException {
        if (newLastName == null || newLastName.equals("")) {
            throw new IllegalArgumentException(
                    "Last name must not be empty or null.");
        }
        this.lastName = newLastName;
    }

    /**
     * Equals for User.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof User)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        final User otherUser = (User) other;
        return Objects.equals(id, otherUser.id)
                && Objects.equals(firstName, otherUser.firstName)
                && Objects.equals(lastName, otherUser.lastName);
    }

    /**
     * hashCode for User.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    /**
     * Required explanation on how to implement this for classes that extend
     * User.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + firstName + " "
                + lastName + " " + id;
    }

}
