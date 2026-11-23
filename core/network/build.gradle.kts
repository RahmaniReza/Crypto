import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.buildConfig)
}

val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { load(it) }
    }
}

val apiKey: String = (project.findProperty("COINGECKO_API_KEY") as? String)
    ?: localProperties.getProperty("COINGECKO_API_KEY")
    ?: "CG-3hrU4djQ9RosnmqzmTctgmHk"

val baseUrl: String = (project.findProperty("COINGECKO_BASE_URL") as? String)
    ?: localProperties.getProperty("COINGECKO_BASE_URL")
    ?: "https://api.coingecko.com/api/v3/"

buildConfig {
    packageName("com.reza.crypto.core.network")
    buildConfigField("API_KEY", apiKey)
    buildConfigField("BASE_URL", baseUrl)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    )

    android {
        namespace = "com.reza.crypto.core.network"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:common"))
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
