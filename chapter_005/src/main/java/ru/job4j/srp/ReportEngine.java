package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    protected Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
