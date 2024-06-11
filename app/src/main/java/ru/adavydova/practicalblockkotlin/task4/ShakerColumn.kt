package ru.adavydova.practicalblockkotlin.task4

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//start task4
@Preview
@Composable
private fun ShakerColumnPreview() {
    ShakerColumn()
}


@Composable
fun ShakerColumn() {
    val list = remember {
        mutableStateListOf<Int?>(2, -100, null, 2, 1, 8, null, 4, 3)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
        ) {

            items(list) {
                ShakerItem(
                    modifier = Modifier,
                    title = it.toString()
                )
            }
        }

        Button(onClick = {
            list.shakerSorted()
        }) {
            Text(text = "Shaker sorted")
        }
    }


}

@Composable
private fun ShakerItem(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        Text(text = title)
    }
}


