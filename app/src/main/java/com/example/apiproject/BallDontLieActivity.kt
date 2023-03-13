package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiproject.databinding.ActivityBalldontlieBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BallDontLieActivity : AppCompatActivity() {
    companion object{
        const val TAG = "BallDontLieActivity"
        const val per_page = 40
    }
    private lateinit var binding: ActivityBalldontlieBinding
    private lateinit var adapter: BallAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBalldontlieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var page = 0

        getBallDataByPage(page)

        binding.buttonListPrev.setOnClickListener{
            if(page>0){
                page--
                getBallDataByPage(page)
            }
        }
        binding.buttonListNext.setOnClickListener{
            page++
            getBallDataByPage(page)
        }
        binding.buttonSearchBack.setOnClickListener {
            finish()
        }
    }

    private fun getBallDataByPage(page: Int) {
        val search = intent.getStringExtra(SearchActivity.EXTRA_SEARCH) ?: ""
        val ballDataService = RetrofitHelper.getInstance().create(BallDataService::class.java)
        val ballDataCall = ballDataService.getPlayersByPage(page, per_page, search)

        ballDataCall.enqueue(object: Callback<PlayerDataWrapper> {
            override fun onResponse(
                call: Call<PlayerDataWrapper>,
                response: Response<PlayerDataWrapper>
            ) {
                if(response.body() != null){
                    //Log.d(TAG, "onResponse: ${response.body()}")
                    adapter = BallAdapter(response.body()!!.data)
                } else {
                    Log.d(TAG, "null")
                }
                Log.d(TAG, "onResponse: ${response.body()}")
                binding.recyclerBallPlayerList.adapter = adapter
                binding.recyclerBallPlayerList.layoutManager = LinearLayoutManager(null)
            }

            override fun onFailure(call: Call<PlayerDataWrapper>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        }

        )
    }
}