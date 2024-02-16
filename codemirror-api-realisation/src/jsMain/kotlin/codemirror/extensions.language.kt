@file:JsModule("@codemirror/language")
@file:JsNonModule

package codemirror.extensions.language

external val defaultHighlightStyle: dynamic
external val foldKeymap:dynamic

external fun syntaxHighlighting(highlighter: dynamic, options: dynamic = definedExternally): dynamic
external fun bracketMatching(config: dynamic = definedExternally): dynamic
external fun foldGutter(config: dynamic = definedExternally): dynamic
