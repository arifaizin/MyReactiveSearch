package com.dicoding.myreactivesearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.dicoding.myreactivesearch.network.ApiConfig
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RxTextView.textChanges(ed_province)
            .skipInitialValue()
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .observeOn(Schedulers.io())
            .switchMap {
                ApiConfig.provideApiService().getCountry(it.toString())
            }
            .observeOn(AndroidSchedulers.mainThread())
            .retry()
            .subscribe { data ->
                val placesName = arrayListOf<String?>()
                data.features?.map {
                    placesName.add(it?.placeName)
                }

                val adapter = ArrayAdapter(this@MainActivity, android.R.layout.select_dialog_item, placesName)
                ed_province.threshold = 1
                ed_province.setAdapter(adapter)
            }


        val fruits = arrayOf(
            "Apple",
            "Banana",
            "Cherry",
            "Date",
            "Grape",
            "Kiwi",
            "Mango",
            "Pear"
        )


    }

    private fun searchPlace(query: String) {
        ApiConfig.provideApiService().getCountry(query)

            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { data ->
                val placesName = arrayListOf<String?>()
                data.features?.map {
                    placesName.add(it?.placeName)
                }

                val adapter = ArrayAdapter(this@MainActivity, android.R.layout.select_dialog_item, placesName)
                ed_province.threshold = 1
                ed_province.setAdapter(adapter)
            }
    }
}
