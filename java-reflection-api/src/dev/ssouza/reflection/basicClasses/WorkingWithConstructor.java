import java.lang.reflect.Constructor;

public class WorkingWithConstructor {
    public static void main(String[] args) {
        Class<?> clss = Person.class;
        Constructor constructor = clss.getConstructor(String.class);

        Constructor[] declaredConstructors = clss.getDeclaredConstructors();
        Constructor[] constructors = clss.getConstructors();
    }
}
