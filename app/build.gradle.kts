plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.deliveryya"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.deliveryya"
        minSdk = 19
        multiDexEnabled = true

        //noinspection EditedTargetSdkVersion
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
}

dependencies {

    implementation("com.android.volley:volley:1.2.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.squareup.picasso:picasso:2.71828")

    implementation ("com.google.firebase:firebase-storage:20.3.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.activity:activity:1.8.1")

    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.firebase:firebase-auth:22.3.0")

    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.firebase:firebase-firestore:24.10.0")
    implementation("com.google.android.libraries.maps:maps:3.1.0-beta")

    testImplementation("junit:junit:4.13.2")

    implementation("com.google.firebase:firebase-bom:32.7.0")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.22")

    implementation("com.google.android.gms:play-services-maps:18.2.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}