package codemirror.lint

import org.w3c.dom.Node
import kotlin.js.Promise

interface ILintExtensions {
    fun lintGutter(config: LintGutterConfig): dynamic //Extension
    fun linter(source: LintSource, config: LinterConfig): dynamic //Extension
}

interface LintGutterConfig {
    val hoverTime: Int?
    val markerFilter: ((diagnostics: Array<Diagnostic>, state: dynamic) -> Array<Diagnostic>)?
    val tooltipFilter: ((diagnostics: Array<Diagnostic>, state: dynamic) -> Array<Diagnostic>)?
}

typealias LintSource = (view:dynamic) -> Promise<Array<Diagnostic>>

external interface Diagnostic {
    val from: Int
    val to: Int
    val severity: SeverityKind
    val markClass: String?
    val source: String?
    val message: String?
    val renderMessage: (() -> Node)?
    val actions: Array<Action>?
}

@Suppress("NAME_CONTAINS_ILLEGAL_CHARS")
@JsName("{ error: 'error', hint: 'hint', info: 'info', warning: 'warning' }")
external enum class SeverityKind {
    error,
    hint,
    info,
    warning
}


external interface Action {
    val name: String
    fun apply(view: dynamic, from: Int, to: Int)
}

interface LinterConfig {
    val delay: Int?
    val needsRefresh: ((update: dynamic) -> Boolean)?
    val markerFilter: ((diagnostics: Array<Diagnostic>, state: dynamic) -> Array<Diagnostic>)?
    val tooltipFilter: ((diagnostics: Array<Diagnostic>, state: dynamic) -> Array<Diagnostic>)?
}

class LinterConfigDefault(
    override val delay: Int? = null,
    override val needsRefresh: ((update: dynamic) -> Boolean)? = null,
    override val markerFilter: ((diagnostics: Array<Diagnostic>, state: dynamic) -> Array<Diagnostic>)? = null,
    override val tooltipFilter: ((diagnostics: Array<Diagnostic>, state: dynamic) -> Array<Diagnostic>)? = null,
) : LinterConfig

class DiagnosticDefault(
    override val from: Int,
    override val to: Int,
    override val severity: SeverityKind,
    override val markClass: String? = null,
    override val source: String? = null,
    override val message: String? = null,
    override val renderMessage: (() -> Node)? = null,
    override val actions: Array<Action>? = null,
) : Diagnostic