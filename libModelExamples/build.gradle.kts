val xmlutilVersion = "0.20.0.0"

plugins {
    id("java-library")
    id("kotlin")
    id("org.jetbrains.kotlin.plugin.serialization") version embeddedKotlinVersion
}

repositories {
    jcenter()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$embeddedKotlinVersion")

    implementation("net.devrieze:xmlutil:$xmlutilVersion")
    implementation("net.devrieze:xmlutil-jvm:$xmlutilVersion")
    //implementation("net.devrieze:xmlutil-serialization:$xmlutilVersion")
    implementation("net.devrieze:xmlutil-serialization-jvm:$xmlutilVersion")
}