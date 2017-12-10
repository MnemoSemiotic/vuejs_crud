package edu.cs390p.flashcards;

import edu.cs390p.flashcards.repositories.FlashCardRepository;
import edu.cs390p.flashcards.repositories.UserRepository;
import edu.cs390p.flashcards.entities.FlashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The flashcards application.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "edu" })
public class FlashCardApplication
        implements CommandLineRunner {

    /** The flashCard repository. */
    @Autowired
    private FlashCardRepository flashCardRepository;

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /**
     * Starts the spring application.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(FlashCardApplication.class, args);
    }

    @Override
    public final void run(final String... args) throws Exception {
        System.out.println("\n\n\n----------\nWorking Directory = "
                + System.getProperty("user.dir") + "\n\n\n\n");


        flashCardRepository.deleteAll();
        userRepository.deleteAll();

        deleteRepositories();

        FlashCard flashCard = new FlashCard();

        flashCard.setQuestion("What is the color of your soul?");
        flashCard.setId("0");
        flashCard.setAnswer("dingy brown");
        flashCardRepository.save(flashCard);

        FlashCard flashCard2 = new FlashCard();

        flashCard2.setQuestion("What do amethysts smell like?");
        flashCard2.setId("1");
        flashCard2.setAnswer("purple");
        flashCardRepository.save(flashCard2);

        FlashCard flashCard3 = new FlashCard();
        flashCard3.setId("2");
        flashCard3.setQuestion("What is the width of an infinite bridge, lengthwise?");
        flashCard3.setAnswer("prehensile");
        flashCardRepository.save(flashCard3);

        FlashCard flashCard4 = new FlashCard();
        flashCard4.setId("3");
        flashCard4.setQuestion("What is an imperative statement?");
        flashCard4.setAnswer("don't take rock for granite");
        flashCardRepository.save(flashCard4);
        FlashCard flashCard5 = new FlashCard();

        flashCard5.setQuestion("What do you think of <insert controversial topic here>?");
        flashCard5.setId("4");
        flashCard5.setAnswer("I have very strong opinions about <insert controversial topic here>");
        flashCardRepository.save(flashCard5);
        FlashCard flashCard6 = new FlashCard();

        flashCard6.setQuestion("What is your favorite type of sleep paralysis?");
        flashCard6.setId("5");
        flashCard6.setAnswer("terror");
        flashCardRepository.save(flashCard6);

        FlashCard flashCard7 = new FlashCard();
        flashCard7.setId("6");
        flashCard7.setQuestion("How do you clean a fish?");
        flashCard7.setAnswer("with steelhead wool");
        flashCardRepository.save(flashCard7);

        FlashCard flashCard8 = new FlashCard();
        flashCard8.setId("7");
        flashCard8.setQuestion("What is the color of your friend's soul?");
        flashCard8.setAnswer("mustard yellow");
        flashCardRepository.save(flashCard8);

        FlashCard flashCard9 = new FlashCard();
        flashCard9.setId("8");
        flashCard9.setQuestion("What does parallax mean?");
        flashCard9.setAnswer("Parallax is a displacement or difference in the apparent position of an object viewed along two different lines of sight, and is measured by the angle or semi-angle of inclination between those two lines.");
        flashCardRepository.save(flashCard9);

    }

    /**
     * Deletes repositories to prepare for prepopulation.
     */
    private void deleteRepositories() {
        flashCardRepository.deleteAll();
        userRepository.deleteAll();

    }

}
