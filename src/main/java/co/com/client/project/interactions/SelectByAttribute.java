package co.com.client.project.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class SelectByAttribute implements Interaction {
    private Target target;
    private String attribute;
    private String value;

    public SelectByAttribute(Target target, String attribute, String value) {
        this.target = target;
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> webElementFacades = target.resolveAllFor(actor);
        for (WebElementFacade element : webElementFacades) {
            if (element.getAttribute(this.attribute).equalsIgnoreCase(value)) {
                element.click();
                break;
            }
        }
    }
}
