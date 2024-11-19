package helpers;

import org.openqa.selenium.By;

public class TableRow {
    private final By name;
    private final By email;
    private final By salary;
    private final By jobTitle;
    private final By startDate;

    public TableRow(By name, By email, By salary, By jobTitle, By startDate) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
    }

    public By getName() { return name; }
    public By getEmail() { return email; }
    public By getSalary() { return salary; }
    public By getJobTitle() { return jobTitle; }
    public By getStartDate() { return startDate; }
}
