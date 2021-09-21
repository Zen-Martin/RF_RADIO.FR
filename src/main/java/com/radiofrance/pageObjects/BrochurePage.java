package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BrochurePage extends Page{

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div[2]/ul/li[2]/a")
    private WebElement click_here;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"consulter-ou-recevoir-nos-brochures";
    private int verification = 0;

    public void goToBrochurePage() {
        get(URI);
    }

    public void checkLink() {
        shortUntil(visibilityOf(click_here));
        verification += checkErrorpage(click_here);
    }

    public boolean verifyLinkRedirection(){

        System.out.println("\nnombre de redirection avec contenu effectif : "+verification);

        if (verification>=1) {

            System.out.println("\n Probleme de securite et d'affichage de la page resolu : "
                    + "\n\n\tBug Corrigé !!!");
            return true;

        } else {

            System.out.println("\n Probleme de securite et d'affichage de la page non-resolu : "
                    + "\n\n\tBug Non Corrigé !!!");
            return false;
        }

    }

}
