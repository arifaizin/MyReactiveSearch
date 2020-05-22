package com.dicoding.myreactivesearch.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(

	@field:SerializedName("features")
	val features: List<FeaturesItem?>? = null,

	@field:SerializedName("query")
	val query: List<String?>? = null,

	@field:SerializedName("attribution")
	val attribution: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)