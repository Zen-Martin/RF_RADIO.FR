package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class IntRadioAwardPage extends Page{

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/article/div[2]/div/div[1]/div/div/div/p[6]/strong/a")
    private WebElement intAward;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"prix-et-recompenses/radio-france-quatre-fois-recompensees-aux-new-york-festivals-et-au-grand-prix";
    private int verification = 0;

    public void goToIntRadioAwardPage() {
        get(URI);
    }

    public void checkLink(){
        shortUntil(visibilityOf(intAward));
        verification += checkErrorpage(intAward);
    }

    public boolean verifyIntRadioAwardLink(){
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
