package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiproject.databinding.ActivityPlayerDetailViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayerDetailView : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "ID"
        const val TAG = "DetailActivity"
    }
    private lateinit var binding: ActivityPlayerDetailViewBinding
    private lateinit var data: List<SeasonAvg>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<PlayerData>(EXTRA_ID)
        if (hero != null) {
            val id = arrayOf(hero.id)
            getBallDataByID(id)
        }
    }
    private fun getBallDataByID(id: Array<Int>) {
        val ballDataService = RetrofitHelper.getInstance().create(BallDataService::class.java)
        val ballDataCall = ballDataService.getPlayerSeasonAverages(id)

        ballDataCall.enqueue(object: Callback<SeasonAvgWrapper> {
            override fun onResponse(
                call: Call<SeasonAvgWrapper>,
                response: Response<SeasonAvgWrapper>
            ) {
                Log.d(PlayerDetailView.TAG, "onResponse: ${response.raw()}")

                if(response.body() != null){
                    data = response.body()!!.data
                } else {
                    Log.d(PlayerDetailView.TAG, "null")
                }
                Log.d(PlayerDetailView.TAG, "onResponse: ${response.body()?.data}")


            }

            override fun onFailure(call: Call<SeasonAvgWrapper>, t: Throwable) {
                Log.d(PlayerDetailView.TAG, "onFailure: ${t.message}")
            }
            })
    }
}