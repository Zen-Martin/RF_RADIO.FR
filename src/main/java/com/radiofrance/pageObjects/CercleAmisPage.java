package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CercleAmisPage extends Page{

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div[3]/p[34]/a")
    private WebElement fond_musc1;

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div/p[6]/a")
    private WebElement fond_musc2;

    @FindBy(xpath = "/html/body/main/section[5]/div/div[1]/div/div/p[7]/a")
    private WebElement fond_musc3;


    private final static Configuration PROP  = Properties.Config;
    private final static String cercleAmisURI = PROP.getEnvironment()+"cercle-des-amis";
    private final static String donateURI = PROP.getEnvironment()+"faire-un-don-par-cheque-ou-par-virement";
    private int verification = 0;

    public void goToCercleAmisPage() {
        get(cercleAmisURI);
    }

    public void goToDonate() {
        get(donateURI);
    }

    public void checkLink_1() {
        shortUntil(visibilityOf(fond_musc1));
        verification += checkErrorpage(fond_musc1);
    }

    public void checkLink_2() {
        shortUntil(visibilityOf(fond_musc2));
        verification += checkErrorpage(fond_musc2);
        shortUntil(visibilityOf(fond_musc3));
        verification += checkErrorpage(fond_musc3);
    }

    public boolean verifyLinkRedirection(){

            if (verification>=3) {

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
