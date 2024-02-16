@file:JsModule("@codemirror/commands")
@file:JsNonModule

package codemirror.extensions.commands

external val defaultKeymap:dynamic //readonly KeyBinding[]
external val indentWithTab:dynamic
external val historyKeymap:dynamic

external fun history():dynamic
