package codemirror.view

import codemirror.language.Direction
import codemirror.state.*
import org.w3c.dom.HTMLElement

interface IView_static {
    val EditorView: IEditorView_static
    val Decoration: IDecoration_static
}

interface IDecoration_static {
    val none: DecorationSet
    fun mark(spec: MarkDecorationSpec): IDecoration
    fun line(spec: dynamic): IDecoration
    fun set(of: Array<IRange<IDecoration>>, sort: Boolean = false): DecorationSet
}


interface MarkDecorationSpec {
    var inclusive: Boolean?
    var inclusiveStart: Boolean?
    var inclusiveEnd: Boolean?
    var attributes: String?

    @JsName("class")
    var _class: String?
    var typeName: String?
    var bdiIsolate: Direction?

}

interface IEditorView_static {
    val updateListener: IFacet<(update: IViewUpdate) -> Unit, Any>
    val decorations: IFacet<(view: IEditorView) -> DecorationSet, Any>
    fun scrollIntoView(pos: Int): IStateEffect<*>
    fun theme(spec: dynamic, options: dynamic = null): dynamic //Extension

}

external interface EditorViewConfig : EditorStateConfig {
    var state: IEditorState
    var parent: dynamic
    var root: dynamic
    var dispatchTransactions: dynamic
}

external interface FromTo {
    val from:Int
    val to:Int
}

external interface IEditorView {
    val state: IEditorState
    val viewport: FromTo
    val visibleRanges:Array<FromTo>
    val inView:Boolean
    val composing:Boolean
    val compositionStarted:Boolean
    val dom: HTMLElement
    val themeClasses: String

    fun setState(newState: IEditorState)
    fun dispatch(vararg specs: TransactionSpec)
}

external interface IViewUpdate {
    val changes: dynamic
    val startState: IEditorState
    val view: IEditorView
    val state: IEditorState
    val transactions: Array<ITransaction>
    val viewportChanged: Boolean
    val heightChanged: Boolean
    val geometryChanged: Boolean
    val focusChanged: Boolean
    val docChanged: Boolean
    val selectionSet: Boolean
}

external interface IDecoration : IRangeValue {
    val spec:Any
}

typealias DecorationSet = IRangeSet<IDecoration>