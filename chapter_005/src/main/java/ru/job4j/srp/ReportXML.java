package ru.job4j.srp;

import org.json.JSONObject;

import java.util.function.Predicate;

public class ReportXML extends ReportEngine {

    public ReportXML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter, TypeReport type) {
        StringBuilder text = new StringBuilder();
        for (Employer employer : store.findBy(filter)) {
            text.append("<employer>").append(System.lineSeparator())
                    .append("<name>")
                    .append(employer.getName())
                    .append("</name>")
                    .append(System.lineSeparator())
                    .append("<hired>")
                    .append(employer.getHired())
                    .append("</hired>")
                    .append(System.lineSeparator())
                    .append("<fired>")
                    .append(employer.getFired())
                    .append("</fired>")
                    .append(System.lineSeparator())
                    .append("<salary>")
                    .append(employer.getSalary())
                    .append("</salary>")
                    .append(System.lineSeparator())
                    .append("</employer>");
        }
        return text.toString();
    }
}
