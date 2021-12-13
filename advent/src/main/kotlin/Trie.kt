class Trie {
    private val root = TrieNode()

    fun add(word: String) {
        var current = root
        word.toCharArray().forEach {
            current.size++
            current = current.children.computeIfAbsent(it) { TrieNode() }
        }
        current.isWord = true
        current.content = word
    }


    operator fun plusAssign(collection: Collection<String>) {
        collection.forEach { this.add(it) }
    }

    private fun HashMap<Char, TrieNode>.max(): TrieNode {
        if (this.size == 1) {
            return this.values.first()
        }

        val first = if (this.contains('0')) this['0']!!.size else 0
        val second = if (this.contains('1')) this['1']!!.size else 0
        return if (first > second) {
            this['0']!!
        } else {
            this['1']!!
        }
    }

    private fun HashMap<Char, TrieNode>.min(): TrieNode {
        if (this.size == 1) {
            return this.values.first()
        }

        val first = if (this.contains('0')) this['0']!!.size else 0
        val second = if (this.contains('1')) this['1']!!.size else 0
        return if (first <= second) {
            this['0']!!
        } else {
            this['1']!!
        }
    }


    fun findMostCommon(): String {
        var current: TrieNode = root
        while (!current.isWord) {
            current = current.children
                .max()
        }
        return current.content;
    }

    fun findLeastCommon(): String {
        var current: TrieNode = root
        while (!current.isWord) {
            current = current.children
                .min()
        }
        return current.content
    }

}