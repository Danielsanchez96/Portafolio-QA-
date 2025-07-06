package co.com.client.project.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DriverTask;

public class Alert {

    private Alert() {
    }

    public static Performable accept() {
        return new DriverTask(driver -> driver.switchTo().alert().accept());
    }
}
