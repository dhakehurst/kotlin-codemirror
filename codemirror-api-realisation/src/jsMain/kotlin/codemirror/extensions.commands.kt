@file:JsModule("@codemirror/commands")
@file:JsNonModule

package codemirror.extensions.commands

import codemirror.view.KeyBinding

external val defaultKeymap:Array<KeyBinding>
external val indentWithTab:KeyBinding
external val historyKeymap:Array<KeyBinding>

external fun history():dynamic
