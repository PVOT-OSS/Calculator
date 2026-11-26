// SPDX-FileCopyrightText: 2026 Saalim Quadri <danascape@gmail.com>
// SPDX-License-Identifier: Apache-2.0

import dev.detekt.gradle.Detekt
import dev.detekt.gradle.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) =
        with(target) {
            pluginManager.apply("dev.detekt")
            extensions.configure<DetektExtension> {
                config.setFrom(rootProject.file("config/detekt/detekt.yml"))
                buildUponDefaultConfig.set(true)
                parallel.set(true)
            }
            tasks.withType<Detekt>().configureEach {
                jvmTarget.set(JAVA_VERSION.toString())
                reports {
                    checkstyle.required.set(false)
                    html.required.set(true)
                    sarif.required.set(true)
                    markdown.required.set(false)
                }
            }
            dependencies { add("detektPlugins", libs.lib("compose-rules-detekt")) }
        }
}
