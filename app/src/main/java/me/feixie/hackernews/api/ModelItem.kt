package me.feixie.hackernews.api


data class ModelItem(
		val by: String,
		val descendants: Int,
		val id: Int,
		val kids: List<Int>,
		val score: Int,
		val time: Int,
		val title: String,
		val type: String,
		val url: String
)