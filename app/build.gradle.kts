plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "iam5akda.fakechef.online"
    compileSdk = 33

    defaultConfig {
        applicationId = "iam5akda.fakechef.online"
        minSdk = 24
        targetSdk = 33
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
    implementation("androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}")

    implementation(platform("androidx.compose:compose-bom:${Versions.COMPOSE_BOM}"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    androidTestImplementation(platform("androidx.compose:compose-bom:${Versions.COMPOSE_BOM}"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation("junit:junit:${Versions.JUNIT}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.ANDROID_JUNIT}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}")

    implementation("com.google.dagger:hilt-android:${Versions.DAGGER_HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}")

    implementation("androidx.core:core-splashscreen:${Versions.SPLASH_SCREEN}")
}

kapt {
    correctErrorTypes = true
}

private object Versions {
    const val CORE_KTX = "1.9.0"
    const val LIFECYCLE_RUNTIME_KTS = "2.6.1"
    const val ACTIVITY_COMPOSE = "1.7.0"
    const val COMPOSE_BOM = "2023.03.00"
    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.5"
    const val ESPRESSO_CORE = "3.5.1"
    const val DAGGER_HILT = "2.44.2"
    const val SPLASH_SCREEN = "1.0.1"
}