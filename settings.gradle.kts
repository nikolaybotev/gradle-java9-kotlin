// Configure repositories for all projects
gradle.beforeProject {
    repositories {
        jcenter()
    }
}

include(":java-only")
include(":java-and-kotlin")
