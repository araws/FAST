package modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import modul_8.pages.sections.TopMenuSection;

public class HomePage extends BasePage{

    @Getter
    private final TopMenuSection topMenuSection;

    public HomePage(Page page) {
        super(page);
        this.topMenuSection = new TopMenuSection(page);
    }
}
