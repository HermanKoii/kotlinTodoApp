plugins {
    id(\"com.android.application\")
    id(\"kotlin-android\")
    id(\"kotlin-kapt\")
}

android {
    compileSdk = 33
    
    defaultConfig {
        applicationId = \"com.todoapp\"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = \"1.0\"

        testInstrumentationRunner = \"androidx.test.runner.AndroidJUnitRunner\"
    }

    buildTypes {
        getByName(\"release\") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(\"proguard-android-optimize.txt\"), \"proguard-rules.pro\")
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = \"11\"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(\"androidx.core:core-ktx:1.9.0\")
    implementation(\"androidx.appcompat:appcompat:1.6.1\")
    implementation(\"androidx.recyclerview:recyclerview:1.3.0\")
    
    // Room dependencies
    implementation(\"androidx.room:room-runtime:2.5.1\")
    implementation(\"androidx.room:room-ktx:2.5.1\")
    kapt(\"androidx.room:room-compiler:2.5.1\")

    // Testing dependencies
    testImplementation(\"junit:junit:4.13.2\")
    testImplementation(\"org.mockito:mockito-core:4.8.0\")
    testImplementation(\"org.robolectric:robolectric:4.9\")
    testImplementation(\"org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4\")
    testImplementation(\"androidx.arch.core:core-testing:2.1.0\")
    
    androidTestImplementation(\"androidx.test.ext:junit:1.1.5\")
    androidTestImplementation(\"androidx.test.espresso:espresso-core:3.5.1\")
}