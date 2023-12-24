public class Main {
    
    public static void main(String[] args) {
        String hello = "Hello";
        Class helloClass = hello.getClass();

        System.out.println(helloClass.getName());

        Class<?> helloClass2 = "World".getClass();

        // Class<String> helloClass3 = "error".getClass();
    }
}
