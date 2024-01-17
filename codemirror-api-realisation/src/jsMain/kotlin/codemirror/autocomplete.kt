package codemirror.autocomplete

interface Completion {
    val label: String
    val displayLabel: String?
    val detail:String?
    val type:String?
    val boost:Int?
    val section:String?
}


interface CompletionSection {

}
