package com.dicoding.myreactivesearch

import androidx.lifecycle.*
import com.dicoding.myreactivesearch.network.ApiConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {

    private val apiKey = "pk.eyJ1IjoiYXJpZmFpemluIiwiYSI6ImNrYTI2c3R1cjAwNXAzbm1zaDYyZW1ra2cifQ.okSWF0zf58rWkhoVuYjShQ"
    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    val searchResult = queryChannel.asFlow()
            .debounce(300)
            .filter {
                it.trim().isEmpty().not()
            }
            .distinctUntilChanged()
            .mapLatest {
                ApiConfig.provideApiService().getCountry(it, apiKey).features
            }
            .asLiveData()
}