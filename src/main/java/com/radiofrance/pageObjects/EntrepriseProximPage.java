package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class EntrepriseProximPage extends Page{

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div[3]/ul[5]/li[4]/a")
    private WebElement chor_act;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"radio-france-et-la-proximite";
    private int verification = 0;

    public void goToEnsProximPage() {
       get(URI);
    }

    public void checkLink() {
        shortUntil(visibilityOf(chor_act));
        verification += checkErrorpage(chor_act);
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
