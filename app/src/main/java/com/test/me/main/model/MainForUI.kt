package com.test.me.main.model

data class MainForUI(val itemData: ItemData?) {

    fun isEmpty(): Boolean {

        return itemData == null
    }

    data class ItemData(val title: String, val desc: String?) {
    }
}
