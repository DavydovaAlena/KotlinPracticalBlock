package ru.adavydova.practicalblockkotlin.task3

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Start task3
@Preview
@Composable
private fun ButtonWithLogMessageBlockPreview() {
    ButtonWithLogMessageBlock(
        listAnyValues = ListAnyValues(),
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ButtonWithLogMessageBlock(
    listAnyValues: ListAnyValues,
    modifier: Modifier = Modifier
) {

    val countClick = remember {
        mutableIntStateOf(0)
    }
    val intValue = remember() {
        mutableStateOf<Int?>(null)
    }

    LaunchedEffect(key1 = countClick.intValue) {
        if (countClick.intValue != 0) {
            intValue.value = listAnyValues.findCertainTypeValueOrNull()
            Log.d("intValue", intValue.value.toString())
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "List value:"
        )

        listAnyValues.forEach {
            Text(text = it.toString())
            Divider(thickness = 1.dp)
        }


        ButtonWithLog(
            onClick = { countClick.intValue = countClick.intValue.plus(1) },
            text = "Find integer"
        )

    }
}

@Composable
fun ButtonWithLog(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier,
        onClick = onClick
    )
    {
        Text(text = text)
    }
}
