package edu.cs390p.flashcards.services;

import java.util.List;

import edu.cs390p.flashcards.repositories.FlashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cs390p.flashcards.entities.FlashCard;

/**
 * The FlashCard service.
 */
@Service
public class FlashCardService {

    /** The FlashCard repository. */
    @Autowired
    private FlashCardRepository flashCardRepository;

    /**
     * Gets the list of all FlashCards.
     * @return the list of all FlashCards
     */
    public List<FlashCard> getAllFlashCards() {
        return flashCardRepository.findAll();
    }

    /**
     * Gets a FlashCard by id.
     * @param id the FlashCard id
     * @return the FlashCard
     */
    public FlashCard getFlashCard(final String id) {
        return flashCardRepository.findOne(id);
    }

    /**
     * Adds a FlashCard.
     * @param flashCard the FlashCard to add
     */
    public void addFlashCard(final FlashCard flashCard) {
        flashCardRepository.save(flashCard);
    }

    /**
     * Updates a FlashCard.
     * @param flashCard the FlashCard to update
     */
    public void updateFlashCard(final FlashCard flashCard) {
        flashCardRepository.save(flashCard);
    }

    /**
     * Deletes a FlashCard.
     * @param id the FlashCard id
     */
    public void deleteFlashCard(final String id) {
        flashCardRepository.delete(id);
    }
}
