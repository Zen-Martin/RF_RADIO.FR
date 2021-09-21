package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CookiePage extends Page {

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/div/div/div/div[1]/ul[4]/li[3]/a")
    private WebElement cookieNetwork;

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/div/div/div/div[1]/ul[6]/li[2]/a")
    private WebElement supportApple;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"informations-cookies";
    private int verification = 0;

    public void goToCookiePage() {
        get(URI);
    }

    public void checkCookieNetwork(){
        shortUntil(visibilityOf(cookieNetwork));
        verification += checkErrorpage(cookieNetwork);
    }

    public void checkSupportApple(){
        shortUntil(visibilityOf(supportApple));
        verification += checkErrorpage(supportApple);
    }

    public boolean verifyCookieNetwork(){
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

    public boolean verifySupportApple(){
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
