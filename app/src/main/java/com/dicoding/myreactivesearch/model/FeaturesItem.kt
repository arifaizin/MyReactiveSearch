package com.dicoding.myreactivesearch.model

import com.google.gson.annotations.SerializedName

data class FeaturesItem(

	@field:SerializedName("place_name")
	val placeName: String? = null,

	@field:SerializedName("place_type")
	val placeType: List<String?>? = null,

	@field:SerializedName("center")
	val center: List<Double?>? = null,

	@field:SerializedName("context")
	val context: List<ContextItem?>? = null,

	@field:SerializedName("geometry")
	val geometry: Geometry? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("relevance")
	val relevance: Double? = null,

	@field:SerializedName("properties")
	val properties: Properties? = null
)