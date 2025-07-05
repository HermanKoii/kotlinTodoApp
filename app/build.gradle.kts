plugins {
    id("com.android.application")
    id("kotlin-android")
<<<<<<< HEAD
=======
    id("kotlin-kapt")
>>>>>>> pr-2-Aflame7121-kotlinTodoApp
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.todoapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

<<<<<<< HEAD
=======
    buildFeatures {
        viewBinding = true
    }

>>>>>>> pr-2-Aflame7121-kotlinTodoApp
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
<<<<<<< HEAD

=======
>>>>>>> pr-2-Aflame7121-kotlinTodoApp
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
<<<<<<< HEAD

=======
>>>>>>> pr-2-Aflame7121-kotlinTodoApp
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
<<<<<<< HEAD
    // Kotlin standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")

    // AndroidX
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.robolectric:robolectric:4.10.3")
    testImplementation("androidx.test:core:1.5.0")
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("org.mockito:mockito-core:4.8.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
=======
    // Android Core
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
    // ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test:core:1.5.0")
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("org.robolectric:robolectric:4.9")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
>>>>>>> pr-2-Aflame7121-kotlinTodoApp
}