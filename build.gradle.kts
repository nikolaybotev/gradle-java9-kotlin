import com.zyxist.chainsaw.ChainsawPlugin

plugins {
    id("idea")
    id("com.zyxist.chainsaw") version "0.3.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.3.21" apply false
}

subprojects {
    apply(mapOf("plugin" to IdeaPlugin::class.java))
    apply(mapOf("plugin" to JavaLibraryPlugin::class.java))
    apply(mapOf("plugin" to ChainsawPlugin::class.java))
}

