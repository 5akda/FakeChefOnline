plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "iam5akda.fakechef.online"
    compileSdk = Configs.COMPILE_SDK_VER

    defaultConfig {
        applicationId = "iam5akda.fakechef.online"
        minSdk = Configs.MIN_SDK_VER
        targetSdk = Configs.COMPILE_SDK_VER
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${Versions.CORE_KTX}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME_KTS}")

    implementation("com.google.dagger:hilt-android:${Versions.DAGGER_HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}")

    implementation("androidx.core:core-splashscreen:${Versions.SPLASH_SCREEN}")

    implementation(project(":core:design"))
    implementation(project(":feature:home"))
}

kapt {
    correctErrorTypes = true
}