package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ChoeurRadioPage extends Page {

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div[2]/p[1]/a[1]")
    private WebElement orch_nat_fr;

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div[2]/p[1]/a[2]")
    private WebElement orch_phil_fr;

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div[2]/p[1]/a[3]")
    private WebElement maitr_fr;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"choeur-de-radio-france";
    private int verification = 0;

    public void goToChoeurDeRadioPage() {
        get(URI);
    }

    public void checkLink() {
        shortUntil(visibilityOf(orch_nat_fr));
        verification += checkErrorpage(orch_nat_fr);
        shortUntil(visibilityOf(orch_phil_fr));
        verification += checkErrorpage(orch_phil_fr);
        shortUntil(visibilityOf(maitr_fr));
        verification += checkErrorpage(maitr_fr);
    }

    public boolean verifyLinkRedirection(){

            System.out.println("\nnombre de redirection avec contenu effectif : "+verification);

            if (verification>=3) {

                System.out.println("\n Probleme de securite et d'affichage de la page resolu : "
                        + "\n\n\tBug Corrigé !!!");
                return true;

            } else {

                System.out.println("\n Probleme de securite et d'affichage de la page non-resolu : "
                        + "\n\n\tBug Non Corrigé !!!");
                return  false;
            }

    }






}
