package com.hannanmax.hannanmax_scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.hannanmax.hannanmax_scorekeeper.databinding.ActivityMainBinding
import java.math.RoundingMode.valueOf

class MainActivity : AppCompatActivity() {

    // Array of sports
    private var sports = arrayOf("American Football", "Basketball", "Freestyle Wrestling", "Cricket")
    // Binding variable initialization
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setting sports array to spinner using adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sports)
        binding.spinnerGames.adapter = adapter

        // Spinner on item selected listener for enabling visibility of sports
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

        // Save button on click listener for saving data of edittext to textview of scorecard layout
        // Initializing scores to zero and disabling save button and enabling reset button
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

        // Reset button on click listener for removing data of textview in scorecard layout
        // Resetting scores to zero and enabling save button and disabling reset button
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

        // Score button American Football for 1 score
        binding.btnAmericanFootballScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button American Football for 2 score
        binding.btnAmericanFootballScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button American Football for 3 score
        binding.btnAmericanFootballScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button American Football for 6 score
        binding.btnAmericanFootballScore6.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 6
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 6
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Basket for 1 score
        binding.btnBasketballScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Basket for 2 score
        binding.btnBasketballScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Basket for 3 score
        binding.btnBasketballScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button FreeStyleWrestling for 1 score
        binding.btnFreestyleWrestlingScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button FreeStyleWrestling for 2 score
        binding.btnFreestyleWrestlingScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button FreeStyleWrestling for 3 score
        binding.btnFreestyleWrestlingScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button FreeStyleWrestling for 4 score
        binding.btnFreestyleWrestlingScore4.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 4
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 4
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button FreeStyleWrestling for 5 score
        binding.btnFreestyleWrestlingScore5.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 5
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 5
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Cricket for 1 score
        binding.btnCricketScore1.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 1
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 1
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Cricket for 2 score
        binding.btnCricketScore2.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 2
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 2
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Cricket for 3 score
        binding.btnCricketScore3.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 3
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 3
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Cricket for 4 score
        binding.btnCricketScore4.setOnClickListener{
            if(binding.scScoreSide.isChecked){
                var currentScore = binding.tvTeam2Score.text.toString().toInt() + 4
                binding.tvTeam2Score.text = currentScore.toString()
            } else {
                var currentScore = binding.tvTeam1Score.text.toString().toInt() + 4
                binding.tvTeam1Score.text = currentScore.toString()
            }
        }

        // Score button Cricket for 6 score
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