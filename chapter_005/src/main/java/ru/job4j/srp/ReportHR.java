package ru.job4j.srp;

import java.util.Comparator;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        var list = store.findBy(filter);
        list.sort(Comparator.comparingDouble(Employer::getSalary).reversed());
        text.append("Name; Salary")
                .append(System.lineSeparator());
        for (Employer employer : list) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
