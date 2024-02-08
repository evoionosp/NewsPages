object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.compose}" }
    val composeUi by lazy { "androidx.compose.ui:ui:" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics:" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigationCompose}" }
    val composeTestJUnit4 by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx: ${Versions.lifecycleViewModelKtx} " }

    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android: ${Versions.coroutines}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompiler}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions. retrofit}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }

    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

    val jUnit by lazy {"junit:junit:${Versions.junit}"}
    val androidXjUnit by lazy {"androidx.test.ext:junit:${Versions.androidXjUnit}"}
    val androidXjUnitKtx by lazy {"androidx.test.ext:junit-ktx:${Versions.androidXjUnit}"}
    val androidXTest by lazy {"androidx.test:core:${Versions.androidXTest}"}
    val androidXcoreKTXTest by lazy {"androidx.test:core-ktx:${Versions.androidXTest}"}
    val testMonitor by lazy {"androidx.test:monitor:${Versions.testMonitor}"}

}

object Versions {
    const val coreKtx = "1.12.0"
    const val appcompat = "1.6.1"
    const val material = "1.9.0"
    const val lifecycleRuntimeKtx = "2.6.1"
    const val activityCompose = "1.7.2"
    const val compose = "2023.03.00"
    const val navigationCompose = "2.7.0"
    const val lifecycleViewModelKtx = "2.6.1"
    const val hilt = "2.48"
    const val hiltCompiler = "1.1.0"
    const val retrofit = "2.9.0"
    const val okhttp = "5.0.0-alpha.2"
    const val gsonConverter = "2.9.0"
    const val moshi = "1.13.0"
    const val moshiConverter = "2.9.0"
    const val loggingInterceptor = "4.8.1"
    const val coroutines = "1.7.3"
    const val splashScreen = "1.0.0-beta02"
    const val coil = "2.2.0"
    const val junit = "4.12"
    const val androidXjUnit = "1.1.5"
    const val androidXTest = "1.5.0"
    const val testMonitor = "1.6.1"
}