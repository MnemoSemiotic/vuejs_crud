package edu.cs390p.flashcards.controllers;

import edu.cs390p.flashcards.entities.FlashCard;
import edu.cs390p.flashcards.services.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The controller for the FlashCard class.
 */
@RestController
public class FlashCardController {

    /** The FlashCard service. */
    @Autowired
    private FlashCardService flashCardService;


    /**
     * Gets the list of all FlashCards.
     *
     * @return the list of all FlashCards
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/flashcards", method = RequestMethod.GET)
    public List<FlashCard> getAllFlashCards() {
        return flashCardService.getAllFlashCards();
    }

    /**
     * Gets a FlashCard by id number.
     *
     * @param id the flashcard id
     * @return the flashcard
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/flashcards/{id}")
    public FlashCard getFlashCard(@PathVariable final String id) {
        System.out.println(flashCardService.getFlashCard(id));
        return flashCardService.getFlashCard(id);
    }

    /**
     * Adds a flashcard.
     *
     * @param flashCardQuestion the flashcard question
     * @param flashCardAnswer the flashcard answer
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(method = RequestMethod.POST, value = "/flashcards/addflashcard")
    public void addFlashCard(@RequestParam final String flashCardQuestion,
            final String flashCardAnswer) {

        FlashCard flashCard = new FlashCard(flashCardQuestion, flashCardAnswer);
        System.out.println(flashCard.getQuestion() + " : " + flashCard.getAnswer());
        flashCardService.addFlashCard(flashCard);
    }

    /**
     * Updates a flashCard.
     *
     * @param question the flashCard question
     * @param answer the flashCard answer
     * @return the model and view
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(method = RequestMethod.GET,
            value = "/flashcards/updateflashcard/{id}")
    public void updateFlashCard(@RequestParam final String question,
            final String answer, @PathVariable final String id) {
        FlashCard flashCard = flashCardService.getFlashCard(id);
        flashCard.setAnswer(answer);
        flashCard.setQuestion(question);
        System.out.println(flashCard.getQuestion() + " : " + flashCard.getAnswer());

        flashCardService.updateFlashCard(flashCard);
    }

    /**
     * Deletes a flashCard.
     *
     * @param id the flashCard's id
     * @return the model and view
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(method = RequestMethod.GET,
            value = "/flashCards/deleteflashcard/{id}")
    public void deleteFlashCard(@PathVariable final String id) {
        flashCardService.deleteFlashCard(id);
    }

    /**
     * Maps to the edit flashcard form.
     *
     * @param id id of the selected flashcard
     * @return ModelAndView containing the selected flashcard
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/flashcards/editflashcard/{id}")
    public ModelAndView editFlashCard(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editflashcardform");
        mav.addObject("flashcard", flashCardService.getFlashCard(id));
        return mav;
    }

    /**
     * Maps to the add flashcard form.
     *
     * @return ModelAndView redirecting to the form
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/flashcards/addflashcard")
    ModelAndView addFlashCardForm() {
        ModelAndView mav = new ModelAndView("addflashcardform");
        return mav;
    }
}
