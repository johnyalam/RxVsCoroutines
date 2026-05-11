plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jlleitschuh.ktlint)
    alias(libs.plugins.ksp)
    id("com.google.dagger.hilt.android")
}

ktlint {
    version.set(libs.versions.ktlint)
}

android {
    namespace = "fi.developer.rxvscoroutines"
    compileSdk {
        version =
            release(36) {
                minorApiLevel = 1
            }
    }

    defaultConfig {
        applicationId = "fi.developer.rxvscoroutines"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    lint {
        checkDependencies = true
        checkGeneratedSources = true
        baseline = file("lint-baseline.xml")
        lintConfig = file("lint.xml")
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // ── RxJava 3
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.rxkotlin)

    // Retrofit + RxJava adapter
    implementation(libs.adapter.rxjava3)

    // Room + RxJava
    implementation(libs.androidx.room.rxjava3)

    // RxJava + ViewModel (auto-dispose alternative)
    implementation(libs.autodispose)
    implementation(libs.autodispose.android)
    implementation(libs.autodispose.androidx.lifecycle)

    // ── Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Lifecycle + ViewModel scopes
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx.v283)

    // Retrofit suspend support
    implementation(libs.retrofit)

    // Room + Coroutines/Flow
    implementation(libs.androidx.room.ktx)

    // Testing
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.rxjava.v318)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}
