package com.githab.laravish.material_design.model

import com.githab.laravish.material_design.API_KEY
import com.githab.laravish.material_design.GET_REQUEST
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureOfTheDayAPI {
    @GET(GET_REQUEST)
    fun getPicture(@Query(API_KEY) apiKey : String) : Call<PictureOfTheDayResponseData>
}