package modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import modul_8.pages.sections.TopMenuSection;

public class HomePage {

    @Getter
    private TopMenuSection topMenuSection;

    public HomePage(Page page) {
        this.topMenuSection = new TopMenuSection(page);
    }
}
