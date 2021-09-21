package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;

public class HomePage extends Page {


    private final static Configuration PROP  = Properties.Config;
    private final static String cardCdiscountURI = PROP.getEnvironment()+"banque-et-assurances#cm_sp=Site:HeaderServices:HUBBA";

    public void navigateToHomePage() {
        get(PROP.getEnvironment());
        handleFrame();
    }



}
