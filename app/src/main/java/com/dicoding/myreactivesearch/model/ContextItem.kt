package com.dicoding.myreactivesearch.model

import com.google.gson.annotations.SerializedName

data class ContextItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("wikidata")
	val wikidata: String? = null,

	@field:SerializedName("short_code")
	val shortCode: String? = null
)