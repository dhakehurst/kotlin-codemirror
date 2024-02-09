package codemirror

import codemirror.language.*
import codemirror.state.*
import codemirror.view.*

object CodeMirror : ICodeMirror {
    override val extensions = object : IExtensions {
        override val view: IViewExtensions = object : IViewExtensions {
            override fun crosshairCursor(options: dynamic) = codemirror.extensions.view.crosshairCursor(options)
            override fun drawSelection(config: dynamic) = codemirror.extensions.view.drawSelection(config)
            override fun dropCursor() = codemirror.extensions.view.dropCursor()
            override fun highlightActiveLine() = codemirror.extensions.view.highlightActiveLine()
            override fun highlightActiveLineGutter() = codemirror.extensions.view.highlightActiveLineGutter()
            override fun highlightSpecialChars() = codemirror.extensions.view.highlightSpecialChars()
            override fun keymap() = codemirror.extensions.view.keymap()
            override fun lineNumbers(config: dynamic) = codemirror.extensions.view.lineNumbers(config)
            override fun rectangularSelection() = codemirror.extensions.view.rectangularSelection()
        }

        override val commands: ICommandsExtensions = object : ICommandsExtensions {
            override fun defaultKeymap() = codemirror.extensions.commands.defaultKeymap()
            override fun history() = codemirror.extensions.commands.history()
            override fun historyKeymap() = codemirror.extensions.commands.historyKeymap()
        }

        override val language: ILanguageExtensions = object : ILanguageExtensions {
            override val defaultHighlightStyle get() = codemirror.extensions.language.defaultHighlightStyle
            override fun syntaxHighlighting(highlighter: dynamic, options: dynamic) = codemirror.extensions.language.syntaxHighlighting(highlighter, options)
            override fun bracketMatching(config: dynamic) = codemirror.extensions.language.bracketMatching(config)
            override fun foldGutter(config: dynamic) = codemirror.extensions.language.foldGutter(config)

        }

        override val autocomplete: IAutocompleteExtensions = object :IAutocompleteExtensions {
            override fun autocompletion(config: dynamic): dynamic = codemirror.extensions.autocomplete.autocompletion(config)
        }
    }

    override val view = object : IView_static {
        override val EditorView = object : IEditorView_static {
            override val updateListener: IFacet<(update: IViewUpdate) -> Unit, Any>
                get() {
                    val EV = codemirror.view.EditorView::class.js
                    return js("EV.updateListener") as IFacet<(update: IViewUpdate) -> Unit, Any>
                }
            override val decorations: IFacet<(view: IEditorView) -> DecorationSet, Any>
                get() {
                    val EV = codemirror.view.EditorView::class.js
                    return js("EV.decorations") as IFacet<(view: IEditorView) -> DecorationSet, Any>
                }

            override fun scrollIntoView(pos: Int): IStateEffect<*> {
                val EV = codemirror.view.EditorView::class.js
                return js("EV.scrollIntoView(pos)") as IStateEffect<*>
            }

            override fun theme(spec: dynamic, options: dynamic): dynamic {
                val EV = codemirror.view.EditorView::class.js
                return js("EV.theme(spec,options)")
            }
        }
        override val Decoration = object : IDecoration_static {
            override val none: DecorationSet
                get() {
                    val D = codemirror.view.Decoration::class.js
                    return js("D.none") as DecorationSet
                }

            override fun mark(spec: MarkDecorationSpec): IDecoration {
                val D = codemirror.view.Decoration::class.js
                return js("D.mark(spec)") as IDecoration
            }

            override fun line(spec: dynamic): IDecoration {
                val D = codemirror.view.Decoration::class.js
                return js("D.line(spec)") as IDecoration
            }

            override fun set(of: Array<IRange<IDecoration>>, sort: Boolean): DecorationSet {
                val D = codemirror.view.Decoration::class.js
                return js("D.set(of, sort)") as DecorationSet
            }
        }
    }

    override val language = object: ILanguage_static{


    }

    override val StateEffect = object : IStateEffect_static {
        override fun <V> define(spec: dynamic): IStateEffectType<V> {
            val SE = codemirror.state.StateEffect::class.js
            return js("SE.define(spec)") as IStateEffectType<V>
        }

        override fun <V> appendConfig(): StateEffectType<V> {
            val SE = codemirror.state.StateEffect::class.js
            return js("SE.appendConfig") as StateEffectType<V>
        }
    }


    override val StateField = object : IStateField_static {
        override fun <Value> define(config: StateFieldConfig<Value>): IStateField<Value> {
            val SF = codemirror.state.StateField::class.js
            return js("SF.define(config)") as IStateField<Value>
        }
    }

    override fun createState(config: EditorStateConfig): IEditorState = EditorState.create(config)

    override fun createCompartment(): ICompartment = Compartment()

}