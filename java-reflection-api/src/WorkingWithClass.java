public class WorkingWithClass {
    public static void main(String[] args) {
        Class<?> clss = "Hello".getClass();
        Class<?> superClss = clss.getSuperclass();

        Class<?>[] interfaces = clss.getInterfaces();
    }
}
