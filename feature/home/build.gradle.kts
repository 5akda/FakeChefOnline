plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "iam5akda.fakechef.feature.home"
    compileSdk = Configs.COMPILE_SDK_VER

    defaultConfig {
        minSdk = Configs.MIN_SDK_VER

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
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
    implementation("androidx.lifecycle:lifecycle-runtime-compose:${Versions.LIFECYCLE_RUNTIME_KTS}")
    implementation("androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}")

    implementation(platform("androidx.compose:compose-bom:${Versions.COMPOSE_BOM}"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    androidTestImplementation(platform("androidx.compose:compose-bom:${Versions.COMPOSE_BOM}"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("com.google.dagger:hilt-android:${Versions.DAGGER_HILT}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}")

    implementation("androidx.navigation:navigation-compose:${Versions.NAVIGATION_COMPOSE}")
    implementation("androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_COMPOSE}")

    implementation(project(":core:design"))
    implementation(project(":core:common"))
    implementation(project(":core:realtime"))
}

kapt {
    correctErrorTypes = true
}