plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.evoionosp.newspages.presentation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.evoionosp.newspages.presentation"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Modules.utilities))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies. activityCompose)
    implementation(platform (Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
    implementation(Dependencies.hiltAndroid)
    implementation(Dependencies.hiltNavigationCompose)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)
    implementation(Dependencies.splashScreen)
    implementation(Dependencies.coil)

    implementation(Dependencies.androidXjUnitKtx)
    implementation(Dependencies.androidXjUnit)
    implementation(Dependencies.testMonitor)
    androidTestImplementation(Dependencies.jUnit)
    testImplementation(Dependencies.jUnit)
    testImplementation(Dependencies.androidXjUnit)
    testImplementation(Dependencies.androidXjUnitKtx)
    testImplementation(Dependencies.androidXTest)
    testImplementation(Dependencies.androidXcoreKTXTest)

}

kapt {
    correctErrorTypes = true
}