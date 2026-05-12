package fi.developer.rxvscoroutines.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinResponseItem(
    @SerialName("id") val id: String,
    @SerialName("is_active") val isActive: Boolean,
    @SerialName("is_new") val isNew: Boolean,
    @SerialName("name") val name: String,
    @SerialName("rank") val rank: Int,
    @SerialName("symbol") val symbol: String,
    @SerialName("type") val type: String,
)
