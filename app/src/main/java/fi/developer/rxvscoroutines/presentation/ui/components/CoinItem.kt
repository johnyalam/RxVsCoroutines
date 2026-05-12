package fi.developer.rxvscoroutines.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fi.developer.rxvscoroutines.domain.model.CoinItem

@Composable
fun CoinItem(
    coinItem: CoinItem,
    onItemClick: (CoinItem) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxSize()
                .clickable {
                    onItemClick(coinItem)
                }.padding(10.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
    ) {
        Text(
            text = coinItem.name + coinItem.symbol,
            modifier = Modifier.weight(.8f),
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = if (coinItem.isActive) "Active" else "Inactive",
            modifier = Modifier.weight(0.2f),
        )
    }
}
