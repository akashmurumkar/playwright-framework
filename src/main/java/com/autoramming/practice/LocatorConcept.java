package com.autoramming.practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class LocatorConcept {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context= browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.orangehrm.com/");

            page.locator("text = Book a Free Demo").last().click();


            page.close();
        }
    }
}