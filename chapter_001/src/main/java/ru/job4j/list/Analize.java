package ru.job4j.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        var map = new HashMap<Integer, String>();
        previous.forEach(user -> map.put(user.id, user.name));
        for (var a: current) {
            var res = map.remove(a.id);
            if (res == null) {
                added++;
            } else if (!res.equals(a.name)) {
                changed++;
            }
        }
        return new Info(added, changed, map.size());

    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        public Info(int added, int changed, int deleted) {
           this.added = added;
           this.changed = changed;
           this.deleted = deleted;
        }
    }
}
