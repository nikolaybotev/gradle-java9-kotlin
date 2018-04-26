module org.example.javaandkotlin {
    exports javaandkotlin;

    requires org.example.javaonly;
    requires kotlin.stdlib;
    requires java.base;
}
