package ru.job4j.srp;

public class ConvertInThousand implements SalaryConverter {
    @Override
    public double convert(double salary) {
        return salary / 1000;
    }
}
