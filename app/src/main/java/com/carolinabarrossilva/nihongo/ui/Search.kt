package com.carolinabarrossilva.nihongo.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.carolinabarrossilva.nihongo.data.Term
import com.carolinabarrossilva.nihongo.model.Searcher
import com.carolinabarrossilva.nihongo.ui.component.TermCard
import com.carolinabarrossilva.nihongo.ui.theme.NihongoTheme

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SearchPreview() {
    NihongoTheme {
        Search()
    }
}

@Composable
fun Search(modifier: Modifier = Modifier) {
    val searcher = remember { Searcher(Term.samples) }
    var search by remember { mutableStateOf("") }
    val terms by derivedStateOf { searcher searchFor search }

    Surface(
        Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier) {
            TextField(
                search,
                onValueChange = { search = it },
                Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null ) },
                label = { Text(text = "Search...") },
                shape = RectangleShape
            )

            LazyColumn {
                items(terms) { term ->
                    TermCard(term)
                }
            }
        }
    }
}