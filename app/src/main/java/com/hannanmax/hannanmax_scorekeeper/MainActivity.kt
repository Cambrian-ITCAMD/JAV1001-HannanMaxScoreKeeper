package com.hannanmax.hannanmax_scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.hannanmax.hannanmax_scorekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Array of sports
    private var sports = arrayOf("American Football", "Basketball", "Freestyle Wrestling", "Cricket")
    // Binding variable initialization
    private lateinit var binding: ActivityMainBinding
    private var undoTeamSide: Boolean = false
    private var undoTeamScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setting sports array to spinner using adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sports)
        binding.spinnerGames.adapter = adapter

        binding.btnBasketballScoreUndo.visibility = View.GONE
        binding.btnAmericanFootballScoreUndo.visibility = View.GONE
        binding.btnFreestyleWrestlingScoreUndo.visibility = View.GONE
        binding.btnCricketScoreUndo.visibility = View.GONE

        // Spinner on item selected listener for enabling visibility of sports layout
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
            increaseTeamScores(binding.scScoreSide.isChecked, 1)
            initUndoTeamScores(binding.btnAmericanFootballScoreUndo, binding.scScoreSide.isChecked, 1)
        }

        // Score button American Football for 2 score
        binding.btnAmericanFootballScore2.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 2)
            initUndoTeamScores(binding.btnAmericanFootballScoreUndo, binding.scScoreSide.isChecked, 2)
        }

        // Score button American Football for 3 score
        binding.btnAmericanFootballScore3.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 3)
            initUndoTeamScores(binding.btnAmericanFootballScoreUndo, binding.scScoreSide.isChecked, 3)
        }

        // Score button American Football for 6 score
        binding.btnAmericanFootballScore6.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 6)
            initUndoTeamScores(binding.btnAmericanFootballScoreUndo, binding.scScoreSide.isChecked, 6)
        }

        binding.btnAmericanFootballScoreUndo.setOnClickListener{
            undoTeamScore(binding.btnAmericanFootballScoreUndo, undoTeamSide, undoTeamScore)
        }

        // Score button Basket for 1 score
        binding.btnBasketballScore1.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 1)
            initUndoTeamScores(binding.btnBasketballScoreUndo, binding.scScoreSide.isChecked, 1)
        }

        // Score button Basket for 2 score
        binding.btnBasketballScore2.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 2)
            initUndoTeamScores(binding.btnBasketballScoreUndo, binding.scScoreSide.isChecked, 2)
        }

        // Score button Basket for 3 score
        binding.btnBasketballScore3.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 3)
            initUndoTeamScores(binding.btnBasketballScoreUndo, binding.scScoreSide.isChecked, 3)
        }

        binding.btnBasketballScoreUndo.setOnClickListener{
            undoTeamScore(binding.btnBasketballScoreUndo, undoTeamSide, undoTeamScore)
        }

        // Score button FreeStyleWrestling for 1 score
        binding.btnFreestyleWrestlingScore1.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 1)
            initUndoTeamScores(binding.btnFreestyleWrestlingScoreUndo, binding.scScoreSide.isChecked, 1)
        }

        // Score button FreeStyleWrestling for 2 score
        binding.btnFreestyleWrestlingScore2.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 2)
            initUndoTeamScores(binding.btnFreestyleWrestlingScoreUndo, binding.scScoreSide.isChecked, 2)
        }

        // Score button FreeStyleWrestling for 3 score
        binding.btnFreestyleWrestlingScore3.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 3)
            initUndoTeamScores(binding.btnFreestyleWrestlingScoreUndo, binding.scScoreSide.isChecked, 3)
        }

        // Score button FreeStyleWrestling for 4 score
        binding.btnFreestyleWrestlingScore4.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 4)
            initUndoTeamScores(binding.btnFreestyleWrestlingScoreUndo, binding.scScoreSide.isChecked, 4)
        }

        // Score button FreeStyleWrestling for 5 score
        binding.btnFreestyleWrestlingScore5.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 5)
            initUndoTeamScores(binding.btnFreestyleWrestlingScoreUndo, binding.scScoreSide.isChecked, 5)
        }

        binding.btnFreestyleWrestlingScoreUndo.setOnClickListener{
            undoTeamScore(binding.btnFreestyleWrestlingScoreUndo, undoTeamSide, undoTeamScore)
        }

        // Score button Cricket for 1 score
        binding.btnCricketScore1.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 1)
            initUndoTeamScores(binding.btnCricketScoreUndo, binding.scScoreSide.isChecked, 1)
        }

        // Score button Cricket for 2 score
        binding.btnCricketScore2.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 2)
            initUndoTeamScores(binding.btnCricketScoreUndo, binding.scScoreSide.isChecked, 2)
        }

        // Score button Cricket for 3 score
        binding.btnCricketScore3.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 3)
            initUndoTeamScores(binding.btnCricketScoreUndo, binding.scScoreSide.isChecked, 3)
        }

        // Score button Cricket for 4 score
        binding.btnCricketScore4.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 4)
            initUndoTeamScores(binding.btnCricketScoreUndo, binding.scScoreSide.isChecked, 4)
        }

        // Score button Cricket for 6 score
        binding.btnCricketScore6.setOnClickListener{
            increaseTeamScores(binding.scScoreSide.isChecked, 6)
            initUndoTeamScores(binding.btnCricketScoreUndo, binding.scScoreSide.isChecked, 6)
        }

        binding.btnCricketScoreUndo.setOnClickListener{
            undoTeamScore(binding.btnCricketScoreUndo, undoTeamSide, undoTeamScore)

        }
    }

    private fun increaseTeamScores(teamSide: Boolean, increaseScoreValue: Int) {
        if(teamSide){
            val currentScore = binding.tvTeam2Score.text.toString().toInt() + increaseScoreValue
            binding.tvTeam2Score.text = currentScore.toString()
        } else {
            val currentScore = binding.tvTeam1Score.text.toString().toInt() + increaseScoreValue
            binding.tvTeam1Score.text = currentScore.toString()
        }
    }

    private fun initUndoTeamScores(btnScoreUndo: Button, teamSide: Boolean, undoScoreValue: Int) {
        btnScoreUndo.visibility = View.VISIBLE
        undoTeamSide = teamSide
        undoTeamScore = undoScoreValue
    }

    private fun undoTeamScore(btnUndoButton: Button, teamSide: Boolean, undoScoreValue: Int){
        if(teamSide){
            val currentScore = binding.tvTeam2Score.text.toString().toInt() - undoScoreValue
            binding.tvTeam2Score.text = currentScore.toString()
        } else {
            val currentScore = binding.tvTeam1Score.text.toString().toInt() - undoScoreValue
            binding.tvTeam1Score.text = currentScore.toString()
        }
        undoTeamScore = 0
        btnUndoButton.visibility = View.GONE
    }
}