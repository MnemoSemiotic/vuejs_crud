package edu.cs390p.flashcards.controllers;

import edu.cs390p.flashcards.entities.FlashCard;
import edu.cs390p.flashcards.services.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller for the FlashCard class.
 */
@Controller
public class FlashCardController {

    /** The FlashCard service. */
    @Autowired
    private FlashCardService flashCardService;


    /**
     * Gets the list of all FlashCards.
     *
     * @return the list of all FlashCards
     */
    @RequestMapping(value = "/flashcards", method = RequestMethod.GET)
    public ModelAndView getAllFlashCards() {
        ModelAndView mav = new ModelAndView("flashcards");
        mav.addObject("allflashcards", flashCardService.getAllFlashCards());
        return mav;
    }

    /**
     * Gets a FlashCard by id number.
     *
     * @param id the flashcard id
     * @return the flashcard
     */
    @RequestMapping("/flashcards/{id}")
    public ModelAndView getFlashCard(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showflashcard");
        FlashCard flashCard = flashCardService.getFlashCard(id);
        mav.addObject("flashcard", flashCard);

        return mav;
    }

    /**
     * Adds a flashcard.
     *
     * @param flashCardQuestion the flashcard question
     * @param flashCardAnswer the flashcard answer
     * @return the flashcard
     */
    @RequestMapping(method = RequestMethod.POST, value = "/flashcards/addflashcard")
    public ModelAndView addFlashCard(@RequestParam final String flashCardQuestion,
            final String flashCardAnswer) {

        FlashCard flashCard = new FlashCard(flashCardQuestion, flashCardAnswer);
        flashCardService.addFlashCard(flashCard);

        ModelAndView mav = new ModelAndView("showflashcard");
        mav.addObject("flashcard", flashCard);

        return mav;
    }

    /**
     * Updates a flashCard.
     *
     * @param question the flashCard question
     * @param answer the flashCard answer
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/flashcards/updateflashcard/{id}")
    public ModelAndView updateFlashCard(@RequestParam final String question,
            final String answer, @PathVariable final String id) {
        FlashCard flashCard = flashCardService.getFlashCard(id);
        flashCard.setAnswer(answer);
        flashCard.setQuestion(question);

        flashCardService.updateFlashCard(flashCard);
        ModelAndView mav = new ModelAndView("showflashcard");
        mav.addObject("flashcard", flashCard);
        return mav;
    }

    /**
     * Deletes a flashCard.
     *
     * @param id the flashCard's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/flashCards/deleteflashcard/{id}")
    public ModelAndView deleteFlashCard(@PathVariable final String id) {
        flashCardService.deleteFlashCard(id);
        ModelAndView mav = new ModelAndView("flashcards");
        mav.addObject("allflashcards", flashCardService.getAllFlashCards());
        return mav;
    }

    /**
     * Maps to the edit flashcard form.
     *
     * @param id id of the selected flashcard
     * @return ModelAndView containing the selected flashcard
     */
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
    @RequestMapping("/flashcards/addflashcard")
    ModelAndView addFlashCardForm() {
        ModelAndView mav = new ModelAndView("addflashcardform");
        return mav;
    }
}
