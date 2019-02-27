import com.zyxist.chainsaw.ChainsawPlugin

plugins {
   `idea`
   id("com.example.jigsaw")
   id("com.zyxist.chainsaw") version "0.3.1" apply false
   kotlin("jvm") version "1.3.21" apply false
   id("com.alkimiapps.gradle-dplink-plugin") version "0.3" apply false
}
