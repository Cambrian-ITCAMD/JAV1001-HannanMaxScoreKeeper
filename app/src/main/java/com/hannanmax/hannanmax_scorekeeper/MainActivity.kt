package com.hannanmax.hannanmax_scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.hannanmax.hannanmax_scorekeeper.databinding.ActivityMainBinding
import java.math.RoundingMode.valueOf

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
            if (binding.edtTeam1Name.text.toString().trim().isNotEmpty() ||
                binding.edtTeam1Name.text.toString().trim().isNotBlank()) {
                binding.scScoreSide.textOff = binding.edtTeam1Name.text.toString()
            } else {
                binding.scScoreSide.textOff = "Team 1"
            }

            if (binding.edtTeam2Name.text.toString().trim().isNotEmpty() ||
                binding.edtTeam2Name.text.toString().trim().isNotBlank()) {
                binding.scScoreSide.textOn = binding.edtTeam2Name.text.toString()
            } else {
                binding.scScoreSide.textOn = "Team 2"
            }

            binding.tvTeam1Score.text = "0"
            binding.tvTeam2Score.text = "0"
            binding.llScore.visibility = View.VISIBLE
            binding.edtTeam1Name.isEnabled = false
            binding.edtTeam2Name.isEnabled = false
            binding.btnReset.isEnabled = true
            binding.btnSave.isEnabled = false
            binding.spinnerGames.isEnabled = false
        }

        binding.btnReset.setOnClickListener {
            binding.edtTeam1Name.text = null
            binding.edtTeam2Name.text = null
            binding.tvTeam1Score.text = "0"
            binding.tvTeam2Score.text = "0"
            binding.llScore.visibility = View.INVISIBLE
            binding.edtTeam1Name.isEnabled = true
            binding.edtTeam2Name.isEnabled = true
            binding.btnSave.isEnabled = true
            binding.btnReset.isEnabled = false
            binding.spinnerGames.isEnabled = true
            binding.spinnerGames.setSelection(0)
        }

        binding.btnAmericanFootballScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnAmericanFootballScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnAmericanFootballScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnAmericanFootballScore6.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 6
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 6
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnBasketballScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnBasketballScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnBasketballScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnFreestyleWrestlingScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnFreestyleWrestlingScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnFreestyleWrestlingScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnFreestyleWrestlingScore4.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 4
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 4
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnFreestyleWrestlingScore5.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 5
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 5
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnCricketScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnCricketScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnCricketScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnCricketScore4.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 4
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 4
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }
        binding.btnCricketScore6.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 6
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 6
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

    }
}