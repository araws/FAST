package modul_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import modul_8.pages.BasePage;

public class ContactUsFormSection extends BasePage {

    private final Locator sendButton;

    @Getter
    private final Locator errorMessage;

    public ContactUsFormSection(Page page) {
        super(page);
        this.sendButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send"));
        this.errorMessage = page.getByText("Invalid email address.");
    }

    public void clickAtSendButton() {
        sendButton.click();
    }
}
