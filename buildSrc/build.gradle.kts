import com.gradle.publish.MavenCoordinates

plugins {
   `java-gradle-plugin`
   kotlin("jvm") version "1.3.21"
   id("com.gradle.plugin-publish") version "0.10.0"
}

repositories {
   mavenCentral()
   jcenter()
}

group = "com.example"
version = "0.0"

dependencies {
   compile(gradleApi())
   compile(kotlin("stdlib"))
}

gradlePlugin {
   plugins {
      register("jigsawGradlePlugin") {
         id = project.group as String + "." + project.name
         displayName = "Jigsaw Gradle Plugin"
         implementationClass = "com.example.JigsawPlugin"
         description = "Jigsaw module and jlink support."
      }
   }
}

pluginBundle {
   website = "https://github.com/calvertdw/gradle-kotlin-dsl-jigsaw"
   vcsUrl = "https://github.com/calvertdw/gradle-kotlin-dsl-jigsaw"
   description = "Jigsaw module and jlink support."
   tags = listOf("jigsaw", "jlink")

   plugins.getByName("jigsawGradlePlugin") {
      id = project.group as String + "." + project.name
      version = project.version as String
      displayName = "Jigsaw Gradle Plugin"
   }

   mavenCoordinates(closureOf<MavenCoordinates> {
      groupId = project.group as String
      artifactId = project.name
      version = project.version as String
   })
}