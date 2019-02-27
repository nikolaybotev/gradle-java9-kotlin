plugins {
    `idea`
    `java-library`
    id("com.zyxist.chainsaw")
}

dependencies {
    implementation("com.google.guava:guava:24.1-jre")
}

tasks.create("run", JavaExec::class) {
    main = "javaonly.JavaOnlyClass"
    classpath = sourceSets.main.get().runtimeClasspath
}