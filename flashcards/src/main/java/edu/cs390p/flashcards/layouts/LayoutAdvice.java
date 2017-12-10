/*
 * Based on implementation at:
 * https://spring.io/blog/2016/11/21
 *     /the-joy-of-mustache-server-side-templates-for-the-jvm
 */

package edu.cs390p.flashcards.layouts;

import java.io.IOException;
import java.io.Writer;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template.Fragment;

/**
 * The layout advice class.
 */
@ControllerAdvice
class LayoutAdvice {

    /**
     * Gets a new layout.
     * @return the new layout
     */
    @ModelAttribute("layout")
    public Mustache.Lambda layout() {
        return new Layout();
    }
}

/**
 * The layout class.
 */
class Layout implements Mustache.Lambda {
    /** the body. */
    private String body;

    @Override
    public void execute(final Fragment frag, final Writer out)
            throws IOException {
        setBody(frag.execute());
    }

    /**
     * Gets the body.
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body.
     * @param newBody the body
     */
    public void setBody(final String newBody) {
        body = newBody;
    }
}
