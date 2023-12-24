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

Getting Fields of a class

- getField(name)
- getDeclaredFields()
- getFields()

Gettings methods of a class

- getMethod(name, types)
- getDeclaredMethods()
- getMethods()

Getting constructors of a class

- getConstructor(types)
- getDeclaredConstructors()
- getConstructors()

Java Modifiers

The getModifiers() returns an int. Each modifier is represented by a bit. For instance, the first bit is the public modifier, the second one is the private, and so forth. To know what is the modifer, we use the Modifier.java static methods.