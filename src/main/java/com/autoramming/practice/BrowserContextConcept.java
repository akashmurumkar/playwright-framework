package com.autoramming.practice;

import com.microsoft.playwright.*;
public class BrowserContextConcept {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false));
            com.microsoft.playwright.BrowserContext context1 = browser.newContext();
            com.microsoft.playwright.BrowserContext context2 = browser.newContext();
            Page pWright = context1.newPage();
            Page google = context2.newPage();
            pWright.navigate("http://playwright.dev");
            google.navigate("http://www.google.co.in");
            System.out.println(pWright.title());
            System.out.println(google.title());
            pWright.close();
            google.close();
        }
    }
}