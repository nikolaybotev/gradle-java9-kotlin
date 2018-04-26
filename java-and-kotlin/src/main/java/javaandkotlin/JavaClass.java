package javaandkotlin;

import javaonly.JavaOnlyClass;

public class JavaClass {
    public static final String JAVA = "Java";
    public static final String STATE = JavaOnlyClass.STATE.replace("Lonely", "HappyWith");

    public static void main(String[] args) {
        System.out.printf("Java + Kotlin = %s%s%n", STATE, KotlinFileKt.getKOTLIN());
    }
}
