package fi.developer.rxvscoroutines.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fi.developer.rxvscoroutines.presentation.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    val numberCoroutine by viewModel.number.collectAsState()
    val numberRxJava by viewModel.numberRxJava.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        Column {
            Text("RxJava number: $numberRxJava")
            Spacer(Modifier.height(10.dp))
            Text("Coroutine number: $numberCoroutine")
        }
    }
}
