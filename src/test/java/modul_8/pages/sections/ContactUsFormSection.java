package modul_8.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import lombok.Getter;
import modul_8.pages.BasePage;

import java.nio.file.Paths;

@Getter
public class ContactUsFormSection extends BasePage {

    private final Locator sendMessageButton;
    private final Locator errorMessage;
    private final Locator subjectHeading;
    private final Locator emailAddressInput;
    private final Locator orderReferenceInput;
    private final Locator fileUploadInput;
    private final Locator messageText;
    private final Locator confirmationMessage;

    public ContactUsFormSection(Page page) {
        super(page);
        this.sendMessageButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send"));
        this.errorMessage = page.getByText("Invalid email address.");
        this.subjectHeading = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Subject Heading"));
        this.emailAddressInput = page.getByLabel("Email address");
        this.orderReferenceInput = page.locator("#id_order");
        this.fileUploadInput = page.getByLabel("Attach File");
        this.messageText = page.getByLabel("Message");
        this.confirmationMessage = page.getByText("Your message has been successfully sent to our team.");
    }

    public ContactUsFormSection clickOnSendMessageButton() {
        sendMessageButton.click();
        return this;
    }

    public ContactUsFormSection selectSubjectHeading(String option) {
        subjectHeading.selectOption(option);
        return this;
    }

    public ContactUsFormSection enterEmailAddress(String email) {
        emailAddressInput.fill(email);
        return this;
    }

    public ContactUsFormSection enterOrderReference(String orderReference) {
        orderReferenceInput.fill(orderReference);
        return this;
    }

    public ContactUsFormSection selectFileToUpload(String filePath) {
        fileUploadInput.setInputFiles(Paths.get(filePath));
        return this;
    }

    public ContactUsFormSection enterMessage(String message) {
        messageText.fill(message);
        return this;
    }
}
