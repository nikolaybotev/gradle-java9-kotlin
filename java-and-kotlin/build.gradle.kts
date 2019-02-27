import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
   `idea`
   `java-library`
   id("com.zyxist.chainsaw")
   kotlin("jvm")
   id("com.alkimiapps.gradle-dplink-plugin")
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
val jar: Jar by tasks

// Enable Kotlin compilattion to Java 8 class files with method parameter name metadata
compileKotlin.kotlinOptions.jvmTarget = "1.8"
compileKotlin.kotlinOptions.javaParameters = true

// As per https://stackoverflow.com/a/47669720
// See also https://discuss.kotlinlang.org/t/kotlin-support-for-java-9-module-system/2499/9
compileKotlin.destinationDir = compileJava.destinationDir
jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE

// Allow cross-references between java and kotlin
sourceSets.main.get().withConvention(KotlinSourceSet::class) {
   kotlin.srcDir("src/main/java")
}

dependencies {
   implementation(kotlin("stdlib"))
   implementation(project(":java-only"))
}

tasks.create("run", JavaExec::class) {
   main = "javaandkotlin.KotlinFileKt"
   classpath = sourceSets.main.get().runtimeClasspath
}
