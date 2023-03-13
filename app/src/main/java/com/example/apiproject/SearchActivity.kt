package com.example.apiproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiproject.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
companion object{
    val EXTRA_SEARCH = "name"
}
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSearchFindplayers.setOnClickListener{
            val listIntent = Intent(this, BallDontLieActivity::class.java)
            listIntent.putExtra(EXTRA_SEARCH, binding.editTextSearchName.text.toString())
            startActivity(listIntent)
        }

    }
}