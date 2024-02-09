val ktor_version = "3.0.0-beta-1"
val kotlin_version = "1.9.22"
val logback_version = "1.4.14"
val exposed_version = "0.41.1"
val h2_version = "2.1.214"
val postgres_version = "42.5.1"

plugins {
    kotlin("jvm")
    application
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

group = "fr.racomach.server"
version = "0.0.1"

application {
    mainClass.set("fr.racomach.server.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {

    implementation(libs.server.ktor.auto.head.response.jvm)
    implementation(libs.server.ktor.call.id.jvm)
    implementation(libs.server.ktor.call.logging.jvm)
    implementation(libs.server.ktor.core.jvm)
    implementation(libs.server.ktor.content.negotiation.jvm)
    implementation(libs.server.ktor.netty)
    implementation(libs.server.ktor.compression.jvm)

    implementation(libs.server.database.exposed.core)
    implementation(libs.server.database.exposed.jdbc)
    implementation(libs.server.database.h2)
    implementation(libs.server.database.postgres)

    implementation(libs.ktor.serialization.kotlinx.json.jvm)

    implementation(libs.server.logback)

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}