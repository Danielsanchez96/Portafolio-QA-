package co.com.client.project.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
//import net.thucydides.core.util.*;


import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static co.com.client.project.utils.PropertiesManager.getValue;


public class HooksAPI {

    public static Actor actor;
    public static EnvironmentVariables environmentVariables;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Usuario");
        environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        //environmentVariables = net.serenitybdd.core.environment.EnvironmentSpecificConfiguration.from(net.thucydides.core.util.SystemEnvironmentVariables.createEnvironmentVariables());

        String apiUrl = environmentVariables.optionalProperty("api.url").orElse(getValue("endpoint"));
        actor.whoCan(CallAnApi.at(apiUrl));
    }

}

