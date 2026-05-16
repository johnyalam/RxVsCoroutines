package fi.developer.rxvscoroutines.presentation.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fi.developer.rxvscoroutines.presentation.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    HomeScreenContent(
        state = state.value,
        onItemClick = { coin ->
            Log.d("TAG", "Item Clicked ${coin.name}")
        }
    )
}
