// SPDX-FileCopyrightText: 2026 Saalim Quadri <danascape@gmail.com>
// SPDX-License-Identifier: Apache-2.0

import com.android.build.api.dsl.Lint
import org.gradle.api.Project

internal fun Lint.applyPvotDefaults(project: Project) {
    warningsAsErrors = false
    abortOnError = true
    checkDependencies = true
    lintConfig = project.rootProject.file("lint.xml")
    val baselineFile = project.file("lint-baseline.xml")
    if (baselineFile.exists()) baseline = baselineFile
}
