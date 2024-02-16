@file:JsModule("@codemirror/lint")
@file:JsNonModule

package codemirror.extensions.lint


import codemirror.lint.LintGutterConfig
import codemirror.lint.LintSource
import codemirror.lint.LinterConfig

external fun lintGutter(config: LintGutterConfig?): dynamic

external fun linter(source: LintSource?, config: LinterConfig?): dynamic




