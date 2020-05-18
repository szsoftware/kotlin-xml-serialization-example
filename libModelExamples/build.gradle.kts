
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

    // Need this actually to resolve dependencies due to publishing issues
    // See: https://github.com/pdvrieze/xmlutil/issues/26
    maven(url = "https://dl.bintray.com/pdvrieze/maven")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk$kotlinJdkVersion:$usedKotlinVersion")

    // xmlutil:
    // -------------------------------------------------------------------
    // Multiplatform (can run on any supported platform):
    // Core:
    implementation("net.devrieze:xmlutil:$xmlutilVersion")
    // Serialization
    implementation("net.devrieze:xmlutil-serialization:$xmlutilVersion")

    // Standard jvm (e.g. Gradle plugin project running directly on developing machine)
    implementation("net.devrieze:xmlutil-jvm:$xmlutilVersion")
    implementation("net.devrieze:xmlutil-serialization-jvm:$xmlutilVersion")

    /* TODO: Still "Could not resolve:" ... (bintray)
    // Android (e.g. Android project where the code, respectively serializable model, runs on an android device)
    implementation("net.devrieze:xmlutil-android:$xmlutilVersion")
    implementation("net.devrieze:xmlutil-serialization-android:$xmlutilVersion")

    // JS -- Wraps DOM
    implementation("net.devrieze:xmlutil-js:$xmlutilVersion")
    implementation("net.devrieze:xmlutil-serialization-js:$xmlutilVersion")
    */

}