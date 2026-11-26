/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

plugins { alias(libs.plugins.pvot.android.application) }

android {
    namespace = "org.prauga.calculator"

    defaultConfig {
        applicationId = "org.prauga.calculator"
        targetSdk = 37
        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String
    }

    buildTypes {
        debug { applicationIdSuffix = ".dev" }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.gridlayout)
    implementation(libs.androidx.webkit)
    implementation(libs.material)
    implementation(libs.pvot.design.system.views)
    implementation(project(":crcalc"))
    testImplementation(libs.assertk)
}
