package com.autoramming.practice;

public class Config {

    public static String browser;
    public static ThreadLocal<String> threadLocalBrowser = new ThreadLocal<>();

    public static String getBrowserType() {
        System.out.println("Getting Browser: " + threadLocalBrowser.get());
        if (browser != null)
            return browser;
        else
            throw new RuntimeException("Browser not specified in testng xml.");
    }

    public static void setBrowserType(String browser) {
        System.out.println("Setting Browser: " + browser);
        threadLocalBrowser.set(browser);
    }

}
