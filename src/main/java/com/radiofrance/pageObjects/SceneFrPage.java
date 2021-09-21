package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SceneFrPage extends Page{

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/article/div[2]/div[2]/div[1]/div/div/div/p[1]/a[1]")
    private WebElement palmares2020;

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/article/div[2]/div[2]/div[1]/div/div/div/p[1]/a[2]")
    private WebElement journalSld;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"actualite/journee-de-solidarite-la-scene-francaise-lundi-7-decembre-2020";
    private int verification = 0;

    public void goToSceneFrPage() {
        get(URI);
    }

    public void checkLinks() {
        shortUntil(visibilityOf(palmares2020));
        verification += checkErrorpage(palmares2020);
        shortUntil(visibilityOf(journalSld));
        verification += checkErrorpage(journalSld);
    }

    public boolean verifySceneFrLinks(){
        System.out.println("\nnombre de redirection avec contenu effectif : "+verification);

        if (verification>=2) {

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
