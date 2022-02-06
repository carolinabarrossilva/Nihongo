package com.carolinabarrossilva.nihongo.data

data class Term(
    val word: String,
    val partOfSpeech: String,
    val englishDefinitions: List<String>
) {
    companion object {
        val samples = listOf(
            Term(word = "私", partOfSpeech = "Noun", englishDefinitions = listOf("I", "me")),
            Term(word = "優しい", partOfSpeech = "adjective", englishDefinitions = listOf("Tender", "gentle", "graceful")),
            Term(word = "正しい", partOfSpeech = "adjective", englishDefinitions = listOf("Correct", "right")),
            Term(word = "正解", partOfSpeech = "Noun", englishDefinitions = listOf("Correct", "right")),
            Term(word = "昨日", partOfSpeech = "Adverb", englishDefinitions = listOf("Yesterday")),
            Term(word = "曲がる", partOfSpeech = "Verb", englishDefinitions = listOf("To turn", "to twist", "to curve")),
        )
        val sample = samples.random()
    }
}