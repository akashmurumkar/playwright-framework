package com.autoramming.practice;

import com.microsoft.playwright.*;

public class StartConcept {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context= browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.orangehrm.com/");




            page.close();
        }
    }
}