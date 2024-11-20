package helpers;

public class TableRow {
    private final String name;
    private final String email;
    private final String salary;
    private final String jobTitle;
    private final String startDate;

    public TableRow(String name, String email, String salary, String jobTitle, String startDate) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getSalary() { return salary; }
    public String getJobTitle() { return jobTitle; }
    public String getStartDate() { return startDate; }
}