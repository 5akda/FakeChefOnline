plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "iam5akda.fakechef.core.realtime"
    compileSdk = Configs.COMPILE_SDK_VER

    defaultConfig {
        minSdk = Configs.MIN_SDK_VER
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${Versions.CORE_KTX}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME_KTS}")

    implementation("com.google.dagger:hilt-android:${Versions.DAGGER_HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}")

    implementation(platform("com.google.firebase:firebase-bom:${Versions.FIREBASE_BOM}"))
    implementation("com.google.firebase:firebase-database-ktx")
}

kapt {
    correctErrorTypes = true
}