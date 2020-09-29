package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine {
    protected Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter, TypeReport type) {
        List<Employer> list = store.findBy(filter);
        if (type == TypeReport.BUH) {
            return buhGenerate(list);
        } else if (type == TypeReport.OLD) {
            return oldGenerate(list);
        } else if (type == TypeReport.PROG) {
            return progGenerate(list);
        } else {
            return hrGenerate(list);
        }
    }

    public String oldGenerate(List<Employer> list) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employer employer : list) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String buhGenerate(List<Employer> list) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; SalaryInThousand")
                .append(System.lineSeparator());
        for (Employer employer : list) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary() / 1000).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String progGenerate(List<Employer> list) {
        StringBuilder text = new StringBuilder();
        text.append("<html>\n"
                + "<header><title>Report</title></header>\n"
                + "<body>")
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employer employer : list) {
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

    public String hrGenerate(List<Employer> list) {
        StringBuilder text = new StringBuilder();
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

    public enum TypeReport {
        PROG,
        HR,
        BUH,
        OLD;
    }
}
