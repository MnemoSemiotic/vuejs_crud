package edu.cs390p.flashcards.repositories;

import java.util.List;

import edu.cs390p.flashcards.entities.FlashCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository for the FlashCard class.
 */
@RepositoryRestResource
public interface FlashCardRepository extends MongoRepository<FlashCard, String> {
    /**
     * Finds a FlashCard by id.
     *
     * @param id the FlashCard id
     * @return the FlashCard
     */
    FlashCard findById(String id);

    /**
     * Finds all FlashCards.
     *
     * @return the list of FlashCard
     */
    List<FlashCard> findAll();
}
