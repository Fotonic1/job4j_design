package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportBuh implements Report {
    private SalaryConverter converter;
    private Store store;

    public ReportBuh(Store store, SalaryConverter converter) {
        this.store = store;
        this.converter = converter;
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
                    .append(converter.convert(employer.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
