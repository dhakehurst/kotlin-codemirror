package codemirror.autocomplete

import org.w3c.dom.HTMLElement
import org.w3c.dom.events.EventListener

external interface CompletionContext {
    val pos:Int
    val aborted:Boolean
    fun addEventListener(type:String, listener: ()->Unit)
}

external interface CompletionResult {
    /**
     * The start of the range that is being completed.
     */
    val from:Int

    /**
     * The end of the range that is being completed. Defaults to the main cursor position.
     */
    val to:Int?

    /**
     * The completions returned. These don't have to be compared with the input
     * by the source—the autocompletion system will do its own matching
     * (against the text between from and to) and sorting.
     */
    val options: Array<Completion>
    //val validFor:

    /**
     * By default, the library filters and scores completions.
     * Set filter to false to disable this, and cause your completions to all be included,
     * in the order they were given. When there are other sources, unfiltered completions
     * appear at the top of the list of completions. validFor must not be given when filter
     * is false, because it only works when filtering.
     */
    val filter:Boolean?

    val update: ((current:CompletionResult, from:Int, to:Int, context:CompletionContext)->CompletionResult)?

}

external interface Completion {
    val label: String
    val displayLabel: String?
    val detail:String?
    val info:String? // | function| Promise | object
    val apply:String?
    val type:String?
    val boost:Int?
    val section:String?

    // fun apply(view:EditorView, completion: Completion, from:Int, to:Int) : String?
}


external interface CompletionSection {
    val name:String
    val rank:Int?
    fun header(section: CompletionSection): HTMLElement
}