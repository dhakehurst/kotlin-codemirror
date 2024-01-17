package codemirror.state

import org.w3c.dom.SelectionMode

external interface EditorStateConfig {
    var doc: String
    var selection: dynamic //EditorSelection | {anchor: number, head?: number}
    var extensions: dynamic //Extension
}

external interface IEditorState {
    val doc: IText
    val selection: IEditorSelection
}

external interface IText {
    val length: Int
    val lines: Int

    fun lineAt(pos:Int):ILine
    fun line(n:Int):ILine
}

external interface IEditorSelection {
    val ranges: Array<ISelectionRange>
    val main:ISelectionRange
}

external interface ISelectionRange {

}

external interface CodeMirrorOptions {

}

external interface ILine {
    val from:Int
    val to:Int
    val number:Int
    val text:String
    val length:Int
}


external interface TransactionSpec {
    var changes: ChangeSpec?
    var selection: IEditorSelection?
    var effects: Array<IStateEffect<*>>?
    var annotations: Annotation?
    var userEvent: String?
    var scrollIntoView: Boolean?
    var filter: Boolean?
    var sequential: Boolean?
}

external interface ChangeSpec {
    var from: Int
    var to: Int
    var insert: String
}

external interface IStateEffect<Value> {
    val value:Value

    fun map(mapping:dynamic):IStateEffect<Value>
    @JsName("is")
    fun <T:Any> _is(type:IStateEffectType<T>):Boolean
}

external interface IStateEffectType<Value> {
    fun of(value: Value): IStateEffect<Value>
}

external interface IStateField<Value>

interface IStateField_static {
    fun <Value> define(config: StateFieldConfig<Value>): IStateField<Value>
}

interface StateFieldConfig<Value> {
    var create: (state: IEditorState) -> Value
    var update: (value: Value, transaction: ITransaction) -> Value
    var compare: ((a: Value, b: Value) -> Boolean)?
    var provide: ((field: IStateField<Value>) -> dynamic)?
    var toJSON: ((value: Value, state: IEditorState) -> Any)?
    var fromJSON: ((json: Any, state: IEditorState) -> Value)?
}

external interface ICompartment {
    fun of(extension: dynamic): dynamic
    fun reconfigure(content: dynamic): IStateEffect<*>
    fun get(state: IEditorState): dynamic
}

external interface IFacet<Input, Output> {
    fun of(value: dynamic): dynamic //Extension
    fun <T : Any> from(field: IStateField<T>): dynamic //Extension
}

external interface ITransaction {
    val startState: IEditorState
    val changes: dynamic //ChangeSet
    val selection: IEditorSelection
    val effects: Array<IStateEffect<*>>
    val scrollIntoView: Boolean
    val newDoc: IText
    val newSelection: IEditorSelection
    val state: IEditorState
    val annotation: dynamic //annotation<T>(type: AnnotationType<T>) → T | undefined
    val docChanged: Boolean
    val reconfigured: Boolean
    val isUserEvent:dynamic //(event: string) → boolean
}

external interface IRange<T:Any>{
    val from:Int
    val to:Int
    val value:T
}

external interface IRangeValue {
    fun range(from:Int, to:Int? = definedExternally): IRange<IRangeValue>
}

external interface IRangeSet<T : IRangeValue> {
    fun <U:T> update(updateSpec:RangeSetUpdate<U>):IRangeSet<T>
    fun map(changes: dynamic) : IRangeSet<T>
}

interface RangeSetUpdate<U : IRangeValue> {
    var add: Array<IRange<U>>
    var sort: Boolean?
    var filter: ((from: Int, to: Int, value: U) -> Boolean)?
    var filterFrom: Int?
    var filterTo: Int?
}