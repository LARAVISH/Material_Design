package com.githab.laravish.material_design.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.githab.laravish.material_design.BuildConfig
import com.githab.laravish.material_design.model.PictureOfTheDayResponseData
import com.githab.laravish.material_design.model.RepositoryImplementation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val repositoryImplementation: RepositoryImplementation = RepositoryImplementation(),
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
) : ViewModel() {

    fun getLiveData() = liveData

    fun sentRequest() {
        liveData.postValue(AppState.Loading)
        repositoryImplementation.getPictureOfTheDateAPI().getPicture(BuildConfig.NASA_API_KEY)
            .enqueue(callBack)
    }

    private val callBack = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>,
        ) {
            if (response.isSuccessful) {
                liveData.postValue(response.body()?.let { AppState.Success(it) })
            } else {
                val message = response.message()
                if (message.isNullOrEmpty()) {
                    liveData.postValue(AppState.Error(Throwable("Unidentified error")))
                } else {
                    liveData.postValue(AppState.Error(Throwable(message)))
                }
            }
        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            liveData.postValue(AppState.Error(t))
        }
    }
}