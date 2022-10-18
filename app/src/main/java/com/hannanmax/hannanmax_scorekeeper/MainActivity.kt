package com.hannanmax.hannanmax_scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.hannanmax.hannanmax_scorekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var games = arrayOf("American Football", "Basketball", "Freestyle Wrestling", "Cricket")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, games)
        binding.spinnerGames.adapter = adapter

        binding.spinnerGames.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if(binding.spinnerGames.selectedItem.toString() == "American Football") {
                    binding.llAmericanFootball.visibility = View.VISIBLE
                    binding.llBasketball.visibility = View.INVISIBLE
                    binding.llFreestyleWrestling.visibility = View.INVISIBLE
                    binding.llCricket.visibility = View.INVISIBLE
                } else if(binding.spinnerGames.selectedItem.toString() == "Basketball") {
                    binding.llAmericanFootball.visibility = View.INVISIBLE
                    binding.llBasketball.visibility = View.VISIBLE
                    binding.llFreestyleWrestling.visibility = View.INVISIBLE
                    binding.llCricket.visibility = View.INVISIBLE
                } else if(binding.spinnerGames.selectedItem.toString() == "Freestyle Wrestling") {
                    binding.llAmericanFootball.visibility = View.INVISIBLE
                    binding.llBasketball.visibility = View.INVISIBLE
                    binding.llFreestyleWrestling.visibility = View.VISIBLE
                    binding.llCricket.visibility = View.INVISIBLE
                } else if(binding.spinnerGames.selectedItem.toString() == "Cricket") {
                    binding.llAmericanFootball.visibility = View.INVISIBLE
                    binding.llBasketball.visibility = View.INVISIBLE
                    binding.llFreestyleWrestling.visibility = View.INVISIBLE
                    binding.llCricket.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding.btnSave.setOnClickListener {

        }
    }
}