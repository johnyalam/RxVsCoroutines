package fi.developer.rxvscoroutines.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.developer.rxvscoroutines.presentation.ui.components.CoinItem
import fi.developer.rxvscoroutines.presentation.ui.components.ErrorMessage
import fi.developer.rxvscoroutines.presentation.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LazyColumn {
            items(
                items = state.value.data,
            ) { coin ->
                CoinItem(coin, onItemClick = {
                    Log.d("TAG", "Clicked!!!")
                })
            }
        }

        if (state.value.error.isNotBlank()) {
            ErrorMessage(message = state.value.error)
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
        }
    }
}
