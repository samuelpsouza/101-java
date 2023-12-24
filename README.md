# 101-java

## Reflection API

Fundamental classes:

- Class
- Field
- Method
- Constructor
- Annotation

Three Patterns to get a Class Instance

- from an Object

```java
String hello = "Hello";
Class helloClass = hello.getClass();
```

- from a known class

```java
Class helloClassInstance = String.class;
```

- from the name of the class

```java
String className = "java.lang.String";
Class helloClass = Class.forName(className);
```

    