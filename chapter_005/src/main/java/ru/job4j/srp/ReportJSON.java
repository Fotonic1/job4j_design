package ru.job4j.srp;

import org.json.JSONObject;

import java.util.function.Predicate;

public class ReportJSON extends ReportEngine {

    public ReportJSON(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        JSONObject report = new JSONObject();
        for (Employer em : store.findBy(filter)) {
            report.put("name", em.getName());
            report.put("hired", em.getHired());
            report.put("fired", em.getFired());
            report.put("salary", em.getSalary());
        }
        return report.toString();
    }
}
