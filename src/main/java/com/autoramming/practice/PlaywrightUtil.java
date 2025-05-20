package com.autoramming.practice;

import com.microsoft.playwright.*;

public class PlaywrightUtil {

    public static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    public static final ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();
    public static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    public static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    public static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static synchronized void setPage(String browserName) {
        if (playwrightThreadLocal.get() == null) {
            Playwright playwright = Playwright.create();
            playwrightThreadLocal.set(playwright);
            Page page = createPage(playwright, browserName);
            pageThreadLocal.set(page);
        }
    }

    public static synchronized Page getPage() {
        return pageThreadLocal.get();
    }

    private static synchronized Page createPage(Playwright playwright, String browserName) {
        BrowserType browserType = getBrowserType(playwright, browserName);
        Browser browser= browserType.launch(setDefaultLaunchOptions());

        Browser.NewContextOptions newContextOptions = new Browser.NewContextOptions();
        newContextOptions.acceptDownloads = true;

        BrowserContext browserContext = browser.newContext(newContextOptions);

        browserTypeThreadLocal.set(browserType);
        browserThreadLocal.set(browser);
        browserContextThreadLocal.set(browserContext);

        return browserContext.newPage();
    }

    private static synchronized BrowserType.LaunchOptions setDefaultLaunchOptions() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false);
        return options;
    }

    private static synchronized BrowserType getBrowserType(Playwright playwright, String browserName) {
        switch (browserName.toLowerCase()) {
            case "chromium":
                return playwright.chromium();
            case "webkit":
                return playwright.webkit();
            case "firefox":
                return playwright.firefox();
            default:
                throw new IllegalArgumentException("Browser name passed in invalid.");
        }
    }

    public static synchronized void closePage() {
        Playwright playwright = playwrightThreadLocal.get();
        Page page = pageThreadLocal.get();
        if (playwright != null) {
            page.close();
            pageThreadLocal.remove();
            playwright.close();
            playwrightThreadLocal.remove();
        }
    }

}
