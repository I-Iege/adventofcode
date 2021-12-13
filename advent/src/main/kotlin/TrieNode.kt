class TrieNode {
    var children: HashMap<Char, TrieNode> = hashMapOf()
    var content: String = ""
    var isWord: Boolean = false
    var size: Int = 0
}