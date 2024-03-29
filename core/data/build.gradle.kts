@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    kotlin("kapt")
    id("kotlin-parcelize")

}

android {
    namespace = "com.adel.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.bundles.network)
    //hilt
    implementation(libs.bundles.hilt)
    kapt(libs.hilt.compiler)
    //add util
    implementation(project(":util"))
    //room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
    //test
    testImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // JUNIT 5
    testImplementation (libs.jupiter)
    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.inline)

    // MOCKITO
    testImplementation (libs.mockito.kotlin)

    // CORE UNIT TESTING
    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.junit.ext)

    // COROUTINES TEST
    testImplementation (libs.core.testing)
}