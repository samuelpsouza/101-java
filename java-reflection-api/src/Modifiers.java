import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Modifiers {
    public static void main(String[] args) {
        Class<?> clss = Person.class;
        Field field = clss.getField("name");

        int modifiers = field.getModifiers();
        
        boolean isPublic = modifiers & 0x00000001;
        boolean publicMod = Modifier.isPublic(modifiers);
    }
}
