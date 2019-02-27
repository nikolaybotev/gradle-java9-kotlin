plugins {
    `idea`
    `java-library`
    id("com.zyxist.chainsaw")// version "0.3.1"
    id("com.alkimiapps.gradle-dplink-plugin")// version "0.3"
}

dependencies {
    implementation("com.google.guava:guava:24.1-jre")
}

tasks.dplink {
    mainClassName = "javaonly.JavaOnlyClass"
}

tasks.create("run", JavaExec::class) {
    main = "javaonly.JavaOnlyClass"
    classpath = sourceSets.main.get().runtimeClasspath
}