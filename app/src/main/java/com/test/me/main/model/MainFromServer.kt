package com.test.me.main.model

import com.google.gson.annotations.SerializedName

data class MainFromServer(
        @SerializedName("itemData")
        val itemData: List<ItemData> = listOf()
) {
    data class ItemData(
            @SerializedName("price")
            val price: Double = 0.0,
            @SerializedName("productId")
            val productId: String = "",
            @SerializedName("type")
            val type: Int = 0
    )

}