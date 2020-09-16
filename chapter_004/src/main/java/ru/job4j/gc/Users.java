package ru.job4j.gc;

public class Users {
    public static class User {
        String name;
        int age;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        info();
        for (int i = 0; i < 500; i++) {
            new User(String.valueOf(i), i);
            info();
        }
        System.out.println("end");
        info();
    }

    public static void info() {
        Runtime run = Runtime.getRuntime();
        System.out.println(run.totalMemory() - run.freeMemory());
    }
}
