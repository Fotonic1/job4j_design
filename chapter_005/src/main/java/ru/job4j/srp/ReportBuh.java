package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportBuh implements Report {
    private Store store;

    public ReportBuh(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; SalaryInThousand")
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary() / 1000).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
