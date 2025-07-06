package co.com.client.project.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.security.SecureRandom;
import java.util.List;
import net.thucydides.core.annotations.*;

// Ensure that the Thucydides dependency is included in your project's build file

public class SelectByRandomIndexFromTarget implements Interaction {

    private Target target;

    public SelectByRandomIndexFromTarget(Target target) {
        this.target = target;
    }

    @Step("{0} selects index random in #target")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade elementFacade = target.resolveFor(actor);
        List<String> selectOptions = elementFacade.getSelectOptions();
        int index = new SecureRandom().nextInt(selectOptions.size());
        target.resolveFor(actor).selectByIndex(index);
    }
}
