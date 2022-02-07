package com.carolinabarrossilva.nihongo.data

data class Searcher(val terms: List<Term>) {
    private infix fun Term.hasEnglishDefinitionsFor(search: String): Boolean {
        return englishDefinitions.any { definition ->
            definition.contains(search, ignoreCase = true)
        }
    }

    infix fun searchFor(search: String): List<Term> {
        return when {
            search.isNotBlank() ->
                terms.filter { term -> term.word.contains(search, ignoreCase = true) || term hasEnglishDefinitionsFor search }
            else ->
                terms
        }
    }
}