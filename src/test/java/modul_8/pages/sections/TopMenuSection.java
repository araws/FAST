package modul_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import modul_8.pages.BasePage;
import modul_8.pages.ContactUsPage;

public class TopMenuSection extends BasePage {

    private final Locator contactUsLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
    }

    public ContactUsPage clickAtContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(page);
    }
}