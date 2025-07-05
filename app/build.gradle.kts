plugins {
    id(\"com.android.application\")
    id(\"kotlin-android\")
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
    
    // Testing dependencies
    testImplementation(\"junit:junit:4.13.2\")
    testImplementation(\"org.mockito:mockito-core:4.8.0\")
    testImplementation(\"org.mockito:mockito-inline:4.8.0\")
    testImplementation(\"org.robolectric:robolectric:4.9\")
    
    androidTestImplementation(\"androidx.test.ext:junit:1.1.5\")
    androidTestImplementation(\"androidx.test.espresso:espresso-core:3.5.1\")
}