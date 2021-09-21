package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ArticleCulturePage extends Page{

    @FindBy(xpath = "/html/body/main/section[4]/div/div/div[1]/div/div/div/div[9]/article/div[2]/div[1]/div[1]/h2/a")
    private WebElement artCult16;

    private final static Configuration PROP  = Properties.Config;
    private final static String URI = PROP.getEnvironment()+"les-editions/rechercher?format=All&radio=All&theme=155&collection=All&title=&page=2";
    private int verification = 0;

    public void goToArticleCulturePage() {
        get(URI);
    }

    public void checkLink(){
        shortUntil(visibilityOf(artCult16));
        verification += checkErrorpage(artCult16);
    }

    public boolean verifyArticleCultureContent(){
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
