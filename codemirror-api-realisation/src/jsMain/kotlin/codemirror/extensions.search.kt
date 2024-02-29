@file:JsModule("@codemirror/search")
@file:JsNonModule

package codemirror.extensions.search

import codemirror.view.KeyBinding

external val searchKeymap:Array<KeyBinding>

external fun highlightSelectionMatches():dynamic
