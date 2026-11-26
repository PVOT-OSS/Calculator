// SPDX-FileCopyrightText: 2026 Saalim Quadri <danascape@gmail.com>
// SPDX-License-Identifier: Apache-2.0

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SpotlessConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) =
        with(target) {
            pluginManager.apply("com.diffplug.spotless")
            val ktfmtVersion = libs.version("ktfmt")
            val root = this == rootProject
            extensions.configure<SpotlessExtension> {
                kotlin {
                    target(if (root) "build-logic/convention/src/**/*.kt" else "src/**/*.kt")
                    ktfmt(ktfmtVersion).kotlinlangStyle()
                }
                kotlinGradle {
                    if (root) {
                        target(
                            "*.gradle.kts",
                            "build-logic/*.gradle.kts",
                            "build-logic/convention/*.gradle.kts",
                        )
                    } else {
                        target("*.gradle.kts")
                    }
                    ktfmt(ktfmtVersion).kotlinlangStyle()
                }
                format("misc") {
                    if (root) {
                        target(
                            ".editorconfig",
                            ".gitignore",
                            "*.properties",
                            "*.toml",
                            "*.xml",
                            ".github/**/*.yml",
                            "build-logic/convention/.gitignore",
                            "config/**/*.yml",
                            "fastlane/**/*.txt",
                            "gradle/*.toml",
                        )
                    } else {
                        target(".gitignore")
                    }
                    trimTrailingWhitespace()
                    endWithNewline()
                }
                if (root) {
                    format("markdown") {
                        target("*.md", "docs/**/*.md")
                        endWithNewline()
                    }
                }
            }
        }
}
