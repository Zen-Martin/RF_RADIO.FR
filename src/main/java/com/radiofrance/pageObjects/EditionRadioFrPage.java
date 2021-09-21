package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class EditionRadioFrPage extends Page{

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/article/div[2]/div/div[1]/div/div/div/p[1]/a[1]")
    private WebElement algeriaWar;

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/article/div[2]/div/div[1]/div/div/div/p[1]/a[2]")
    private WebElement algeriaRange;

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div/article/div[2]/div/div[1]/div/div/div/p[1]/a[3]")
    private WebElement memoWar;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"prix-et-recompenses/les-editions-radio-france-recompensees";
    private int verification = 0;

    public void goToEditionRadioPage() {
        get(URI);
    }

    public void checkAlgeriaWarLink(){
        shortUntil(visibilityOf(algeriaWar));
        verification += checkErrorpage(algeriaWar);
    }

    public void checkOthersLinks(){
        shortUntil(visibilityOf(algeriaRange));
        verification += checkErrorpage(algeriaRange);
        shortUntil(visibilityOf(memoWar));
        verification += checkErrorpage(memoWar);
    }

    public boolean verifyLinkContent(){
        System.out.println("\nnombre de redirection avec contenu effectif : "+verification);

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
