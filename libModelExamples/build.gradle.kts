
// val usedKotlinVersion = embeddedKotlinVersion
val usedKotlinVersion   = properties["kotlinVersion"] // "1.3.72"
val xmlutilVersion      = properties["xmlutilVersion"]
val kotlinJdkVersion    = properties["kotlinJdkVersion"]

plugins {
    id("java-library")
    id("kotlin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

repositories {
    jcenter()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk$kotlinJdkVersion:$usedKotlinVersion")

    //implementation("net.devrieze:xmlutil:$xmlutilVersion")
    implementation("net.devrieze:xmlutil-jvm:$xmlutilVersion")
    //implementation("net.devrieze:xmlutil-serialization:$xmlutilVersion")
    implementation("net.devrieze:xmlutil-serialization-jvm:$xmlutilVersion")
}