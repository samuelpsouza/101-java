public class Person {
    public String name;
    public Integer age;

    private String email;

    public Person() {
    }

    private Person(String email, String age) {
    }

    public Person(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
