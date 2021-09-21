package com.radiofrance.config;

import com.radiofrance.driverManager.WebDriverManager;

public abstract class Properties {

    public final static Configuration       Config          = Configuration.getInstance();
    public final static WebDriverManager    DriverManager   = WebDriverManager.getInstance();

}
