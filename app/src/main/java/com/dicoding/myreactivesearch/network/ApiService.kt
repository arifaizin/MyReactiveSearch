package com.dicoding.myreactivesearch.network

import com.dicoding.myreactivesearch.model.PlaceResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("mapbox.places/{query}.json?access_token=pk.eyJ1IjoiYXJpZmFpemluIiwiYSI6ImNrYTI2c3R1cjAwNXAzbm1zaDYyZW1ra2cifQ.okSWF0zf58rWkhoVuYjShQ")
    fun getCountry(
        @Path("query") query: String
    ): Observable<PlaceResponse>
}
