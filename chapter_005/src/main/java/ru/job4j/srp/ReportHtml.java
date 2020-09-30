package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportHtml implements Report {
    private Store store;

    public ReportHtml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>\n"
                + "<header><title>Report</title></header>\n"
                + "<body>")
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>\n"
                + "</html>");
        return text.toString();
    }
}
