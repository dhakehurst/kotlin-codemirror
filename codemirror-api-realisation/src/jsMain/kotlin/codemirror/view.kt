@file:JsModule("@codemirror/view")
@file:JsNonModule

package codemirror.view

import codemirror.state.IRange
import codemirror.state.IRangeValue
import codemirror.state.EditorState
import codemirror.state.IEditorState
import codemirror.state.TransactionSpec
import org.w3c.dom.HTMLElement

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