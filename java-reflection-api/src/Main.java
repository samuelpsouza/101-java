public class Main {
    
    public static void main(String[] args) throws ClassNotFoundException {
        String hello = "Hello";
        Class helloClass = hello.getClass();

        System.out.println(helloClass.getName());

        Class<?> helloClass2 = "World".getClass();

        // Class<String> helloClass3 = "error".getClass();
        // Class<Object> helloClass4 = "error".getClass();

        Class<? extends String> helloClass5 = "works".getClass();
        Class<? extends Object> helloClass6 = "works".getClass();

        Class<?> helloClassInstance = String.class;

        System.out.println(helloClassInstance.getSimpleName());

        String className = helloClassInstance.getName();
        Class<?> helloClass7 = Class.forName(className);

        System.out.println(helloClass7.getName());

        try{
            Class<?> unknownClass = Class.forName("DoesNotExists");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
