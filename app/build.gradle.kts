plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")

//    id("com.google.gms.google-services")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion
    setFlavorDimensions(AppConfig.dimensions)

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        multiDexEnabled = AppConfig.multiDexEnabled

        vectorDrawables.useSupportLibrary = true
    }


    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packagingOptions {
        resources.excludes.add("META-INF/atomicfu.kotlin_module")
    }
    configurations.all {
        resolutionStrategy.force("junit:junit:4.13")
    }
    productFlavors {
        create("dev") {
            dimension = AppConfig.dimensions[0]
            applicationIdSuffix = ".dev"
            buildConfigField(
                "String",
                "API_URL",
                "\"https://michel-thomas-app-server-web-dev.azurewebsites.net/\""
            )
        }
        create("prod") {
            dimension = AppConfig.dimensions[0]
            buildConfigField(
                "String",
                "API_URL",
                "\"https://michel-thomas-app-server-web-dev.azurewebsites.net/\""
            )
        }
    }
}

dependencies {
    //std lib
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //app libs
    implementation(AppDependencies.appLibraries)
    //kapt
    kapt(AppDependencies.androidLibrariesKapt)
    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    annotationProcessor(AppDependencies.roomCompiler)
}
kapt {
    correctErrorTypes = true
}
