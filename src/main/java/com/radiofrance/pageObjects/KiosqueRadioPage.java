package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class KiosqueRadioPage extends Page{

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/article/div[2]/div/div[1]/div/div/div/div/div[2]/div/p[4]/a")
    private WebElement kiosqueRadio;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"prix-et-recompenses/une-production-des-editions-radio-france-recompensee";
    private int verification = 0;

    public void goToKiosqueRadioPage() {
        get(URI);
    }

    public void checkLink(){
        shortUntil(visibilityOf(kiosqueRadio));
        verification += checkErrorpage(kiosqueRadio);
    }

    public boolean verifyKiosqueRadioLink(){
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
