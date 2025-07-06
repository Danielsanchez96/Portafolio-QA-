package co.com.client.project.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class Page extends PageObject {
    //Elementos de inicio de sesion
    public static final Target TEXTBOX_CORREO_ELECTRONICO =
            Target.the("Textbox correo electronico")
                    .locatedBy("//input [@name='username']");

    public static final Target TEXTBOX_PASSWORD =
            Target.the("Textbox password")
                    .locatedBy("//input [@name='password']");

    public static final Target BOTON_INICIAR_SESION =
            Target.the("Boton iniciar sesion")
                    .locatedBy("//button [@type='submit']");

    public static final Target LOGO_ORANGE =
            Target.the("Logo Orange")
                    .locatedBy("//div [@class='oxd-brand-banner']");

    //Elementos de datos del usuario
    public static final Target BOTON_MY_INFO =
            Target.the("Boton My info")
                    .locatedBy("//span[contains(@class, 'oxd-main-menu-item--name') and normalize-space()='My Info']");
    public static final Target BOTON_CONTACT_DETAILS =
            Target.the("Boton Contact Details")
                    .locatedBy("//a[normalize-space()='Contact Details']");
    public static final Target TEXTBOX_TELEFONO =
            Target.the("Textbox Telefono")
                    .locatedBy("//label[normalize-space()='Home']/following::input[1]");
    public static final Target TEXTBOX_EMAIL =
            Target.the("Textbox Email")
                    .locatedBy("//label[normalize-space()='Work Email']/following::input[1]");
    public static final Target TEXTBOX_CIUDAD =
            Target.the("Textbox Ciudad")
                    .locatedBy("//label[normalize-space()='City']/following::input[1]");
    public static final Target BOTON_GUARDAR =
            Target.the("Boton Guardar")
                    .locatedBy("//button [@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    public static final Target TOAST_ACTUALIZACION_EXITOSA =
            Target.the("Actualización exitosa")
                    .locatedBy("//div[@class=\"oxd-toast oxd-toast--success oxd-toast-container--toast oxd-toast-list-leave-active oxd-toast-list-leave-to\"]");

}
