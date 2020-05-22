package com.dicoding.myreactivesearch.model

import com.google.gson.annotations.SerializedName

data class Properties(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("landmark")
	val landmark: Boolean? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("maki")
	val maki: String? = null
)