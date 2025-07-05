plugins {
    id("com.android.application")
<<<<<<< HEAD
    id("org.jetbrains.kotlin.android")
=======
    id("kotlin-android")
>>>>>>> pr-7-Ralfmal-kotlinTodoApp
    id("kotlin-kapt")
}

android {
<<<<<<< HEAD
    namespace = "com.todoapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.todoapp"
=======
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.todoapp"
>>>>>>> pr-7-Ralfmal-kotlinTodoApp
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
<<<<<<< HEAD

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Room Database
    implementation("androidx.room:room-runtime:2.5.1")
    implementation("androidx.room:room-ktx:2.5.1")
    kapt("androidx.room:room-compiler:2.5.1")

    // Kotlin standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.20")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.20")
    
    // Android testing
=======
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    // Room dependencies
    val roomVersion = "2.5.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // Testing dependencies
    testImplementation("androidx.room:room-testing:$roomVersion")
    testImplementation("junit:junit:4.13.2")
>>>>>>> pr-7-Ralfmal-kotlinTodoApp
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}