package fi.developer.rxvscoroutines.presentation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import fi.developer.rxvscoroutines.domain.model.CoinItem
import fi.developer.rxvscoroutines.presentation.ui.components.CoinItem
import fi.developer.rxvscoroutines.presentation.ui.components.ErrorMessage
import fi.developer.rxvscoroutines.presentation.ui.viewmodel.CoinListState

@Composable
fun HomeScreenContent(
    state: CoinListState,
    onItemClick: (CoinItem) -> Unit = {},
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(10.dp),
    ) {
        LazyColumn(
            modifier = Modifier.testTag("coin_list"),
        ) {
            items(state.data) { coin ->
                CoinItem(
                    coinItem = coin,
                    onItemClick = onItemClick,
                )
            }
        }

        if (state.error.isNotBlank()) {
            ErrorMessage(state.error)
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.testTag("loading"),
            )
        }
    }
}
