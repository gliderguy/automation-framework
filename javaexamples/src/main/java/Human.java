import java.util.Objects;

public class Human {
private String name;
private int age;

        public Human() {
            super();
        }

        public Human(String name, int age) {
                super();

                this.name = name;
                this.age = age;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        // Test equal, override equals() and hashCode()
        @Override
        public boolean equals(Object c) {
                if (this == c)
                        return true;
                if (c == null || getClass() != c.getClass())
                        return false;
                Human human = (Human) c;
                return Objects.equals(age, human.age)  && Objects.equals(name, human.name);
        }

        @Override
        public int hashCode() {
                return Objects.hash(name, age);
        }

    public static int compareByNameThenAge(Human lhs, Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return lhs.age - rhs.age;
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }
}