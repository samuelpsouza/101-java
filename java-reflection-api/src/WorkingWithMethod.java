import java.lang.reflect.Method;

public class WorkingWithMethod {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> clss = Person.class;
        Method method = clss.getMethod("setEmail", String.class);

        Method[] declaredMethods = clss.getDeclaredMethods();
        Method[] methods = clss.getMethods();
    }
}
