package co.com.client.project.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.*;

import java.security.SecureRandom;
import java.util.List;

public class SelectByRandomPositionFromList implements Interaction {
    private Target target;

    public SelectByRandomPositionFromList(Target target) {
        this.target = target;
    }

    @Step("{0} select random position on #target")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> webElementFacadeList = target.resolveAllFor(actor);
        int index = Math.toIntExact(new SecureRandom().nextInt(webElementFacadeList.size()));
        webElementFacadeList.get(index).click();
    }
}
