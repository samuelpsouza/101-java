import java.lang.reflect.Field;

public class WorkingWithField {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        Class<?> clss = Person.class;
        Field name = clss.getField("name");
        Field age = clss.getField("age");

        Field[] declaredFields = clss.getDeclaredFields();
        Field[] fields = clss.getFields();
    }

}
