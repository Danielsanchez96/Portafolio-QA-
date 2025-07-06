package co.com.client.project.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.selectactions.SelectByIndexFromTarget;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Select {

    private Select() {
    }

    public static Interaction byAttribute(Target target, String attribute, String value) {
        return instrumented(SelectByAttribute.class, target, attribute, value);
    }

    public static Interaction byVisibleText(Target target, String visibleText) {
        return instrumented(SelectByVisibleTextFromTarget.class, target, visibleText);
    }

    public static Interaction byIndex(Target target, Integer index) {
        return instrumented(SelectByIndexFromTarget.class, target, index);
    }

    public static Interaction byRandomIndex(Target target) {
        return instrumented(SelectByRandomIndexFromTarget.class, target);
    }

    public static Interaction byRandomListPosition(Target target) {
        return instrumented(SelectByRandomPositionFromList.class, target);
    }
}
