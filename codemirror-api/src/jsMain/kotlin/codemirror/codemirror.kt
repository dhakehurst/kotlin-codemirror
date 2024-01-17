package codemirror

import codemirror.language.*
import codemirror.state.*
import codemirror.view.*

interface ICodeMirror {
    val extensions: IExtensions

    val language: ILanguage_static
    val view: IView_static

    val StateEffect: IStateEffect_static

    val StateField: IStateField_static

    fun createState(config: EditorStateConfig): IEditorState
    fun createCompartment(): ICompartment


}

interface IExtensions {
    val view: IViewExtensions
    val commands: ICommandsExtensions
    val language: ILanguageExtensions
}

interface IViewExtensions {
    fun crosshairCursor(options: dynamic = object : Any() {}): dynamic
    fun drawSelection(config: dynamic = object : Any() {}): dynamic
    fun dropCursor(): dynamic
    fun highlightActiveLine(): dynamic
    fun highlightActiveLineGutter(): dynamic
    fun highlightSpecialChars(): dynamic
    fun keymap(): dynamic
    fun lineNumbers(config: dynamic = object : Any() {}): dynamic
    fun rectangularSelection(): dynamic
}

interface ICommandsExtensions {
    fun defaultKeymap(): dynamic
    fun history(): dynamic
    fun historyKeymap(): dynamic
}

interface ILanguageExtensions {
    val defaultHighlightStyle: dynamic
    fun syntaxHighlighting(highlighter: dynamic, options: dynamic = object : Any() {}): dynamic
    fun bracketMatching(config: dynamic = object : Any() {}): dynamic
    fun foldGutter(config: dynamic = object : Any() {}): dynamic
}

interface IStateEffect_static {
    fun <V> define(spec: dynamic = object : Any() {}): IStateEffectType<V>
    fun <V> appendConfig(): IStateEffectType<V>
}


