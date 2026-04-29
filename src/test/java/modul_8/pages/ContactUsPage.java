package modul_8.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;

public class ContactUsPage {
    private Page page;
    private Locator sendButton;

    @Getter
    private Locator errorMessage;

    public ContactUsPage(Page page) {
        this.page = page;
        this.sendButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send"));
        this.errorMessage = page.getByText("Invalid email address.");
    }

    public void clickAtSendButton() {
        sendButton.click();
    }
}
