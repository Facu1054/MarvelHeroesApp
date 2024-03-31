
val ktor_version: String by rootProject.project
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    //alias(libs.plugins.ksp)
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.9.20"
    //id("com.google.dagger.hilt.android")
    alias(libs.plugins.hiltPlugin)

}

android {
    namespace = "com.facundo.marveHeroesApp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.facundo.marveHeroesApp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
var moshiVersion = "1.10.0"
val nav_version = "2.7.7"
dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    //implementation(libs.retrofit.converter.moshi)

    //OKHttp
    /*implementation(libs.ktor.client.core)
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    */


    //implementation("io.ktor:ktor-client-okhttp:$ktor_version")

    //Moshi
    //implementation(libs.moshi)
    //ksp(libs.moshi.kotlin.codegen)

    //Hilt
    //implementation(libs.hilt)
    //ksp(libs.hilt.compiler)
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    //MVVM
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.6.0")


    //Navigation
    implementation("androidx.navigation:navigation-compose:$nav_version")

    //Coroutines
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")


    //implementation("com.squareup.retrofit2:converter-name:$retrofit_version")

}
kapt {
    correctErrorTypes = true
}