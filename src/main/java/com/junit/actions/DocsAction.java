package com.junit.actions;

import com.junit.pages.DocsPage;

public final class DocsAction extends BaseAction {
    private final DocsPage docsPage;

    public DocsAction() {
        super();
        docsPage = new DocsPage(getDriver());
    }

    public boolean isPageWithTitleDisplayed(String pageTitle) {
        return isElementDisplayed(docsPage.getPageTitleLocator(pageTitle));
    }
}
