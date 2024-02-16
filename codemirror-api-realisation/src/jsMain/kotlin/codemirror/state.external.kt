@file:JsModule("@codemirror/state")
@file:JsNonModule

package codemirror.state

external class EditorState : IEditorState {
    companion object {
        fun create(config:EditorStateConfig?): EditorState
        val allowMultipleSelections:dynamic
    }

    override val doc: Text
    override val selection: EditorSelection
}

external class Text : IText {
    override val length:Int
    override val lines:Int

    override fun lineAt(pos:Int):ILine
    override fun line(n:Int):ILine
}


external class EditorSelection : IEditorSelection {
    override val main: ISelectionRange
    override val ranges: Array<ISelectionRange>
}

external class StateEffect<Value:Any> : IStateEffect<Value> {
    override val value:Value

    override fun map(mapping:dynamic):IStateEffect<Value>
    override fun <T:Any> _is(type:IStateEffectType<T>):Boolean
}

external class StateEffectType<Value> : IStateEffectType<Value> {
    override fun of(value: Value): IStateEffect<Value>
}

external class StateField<Value> : IStateField<Value> {

}

external class Compartment : ICompartment {
    override fun of(extension:dynamic):dynamic
    override fun reconfigure(content:dynamic):IStateEffect<*>
    override fun get(state:IEditorState):dynamic

}