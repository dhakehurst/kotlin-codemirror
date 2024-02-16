package codemirror

import codemirror.language.*
import codemirror.lint.Diagnostic
import codemirror.lint.ILintExtensions
import codemirror.lint.LinterConfig
import codemirror.state.*
import codemirror.view.*
import kotlin.js.Promise

interface ICodeMirror {
    val extensions: IExtensions

    val language: ILanguage_static
    val view: IView_static

    val state:IState_static

}

interface IExtensions {
    val view: IViewExtensions
    val commands: ICommandsExtensions
    val language: ILanguageExtensions
    val autocomplete: IAutocompleteExtensions
    val lint: ILintExtensions
}



interface ICommandsExtensions {
    fun history(): dynamic
    fun historyKeymap(): dynamic
}

interface ILanguageExtensions {
    val defaultHighlightStyle: dynamic
    fun syntaxHighlighting(highlighter: dynamic, options: dynamic = object : Any() {}): dynamic
    fun bracketMatching(config: dynamic = object : Any() {}): dynamic
    fun foldGutter(config: dynamic = object : Any() {}): dynamic
}

interface IAutocompleteExtensions {
    fun autocompletion(config: dynamic = object : Any() {}): dynamic
}






