@file:JsModule("@codemirror/view")
@file:JsNonModule

package codemirror.extensions.view

import codemirror.state.*
import codemirror.view.EditorViewConfig
import codemirror.view.FromTo
import codemirror.view.IDecoration
import codemirror.view.IEditorView
import org.w3c.dom.HTMLElement

external val keymap: dynamic //Facet<readonly KeyBinding[]>

external fun logException(state: dynamic, exception: Any, context: String?)
external fun crosshairCursor(options: dynamic = definedExternally): dynamic
external fun drawSelection(config: dynamic = definedExternally): dynamic
external fun dropCursor(): dynamic
external fun highlightActiveLine(): dynamic
external fun highlightActiveLineGutter(): dynamic
external fun highlightSpecialChars(): dynamic
external fun lineNumbers(config: dynamic = definedExternally): dynamic
external fun rectangularSelection():dynamic
external fun placeholder(content:String):dynamic

external class EditorView(
    config: EditorViewConfig?
) : IEditorView {
    override val state: EditorState
    override val viewport: FromTo
    override val visibleRanges:Array<FromTo>
    override val inView:Boolean
    override val composing:Boolean
    override  val compositionStarted:Boolean
    override val dom: HTMLElement
    override val themeClasses: String

    override fun setState(newState: IEditorState)
    override fun dispatch(vararg specs: TransactionSpec)
}

external class Decoration : IDecoration {
    override val spec: Any
    override fun range(from: Int, to: Int?): IRange<IRangeValue>
}