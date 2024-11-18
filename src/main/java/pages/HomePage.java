package pages;

import objectbehaviors.rules.WebElement;

public class HomePage extends BasePage {

    public WebElement tableHeadingEmployee() {
        return xpathTableHeadingByText("Employee");
    }

    public WebElement tableHeadingJobInfo() {
        return xpathTableHeadingByText("Job Info");
    }

    public WebElement buttonExpandAll() {
        return xpathButtonByAriaLabel("Expand all");
    }
}
