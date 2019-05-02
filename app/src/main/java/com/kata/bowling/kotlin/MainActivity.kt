package com.kata.bowling.kotlin

import android.os.Bundle
import android.text.InputFilter
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_bowling_score_gui.*

class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null

    private fun attachViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private fun attachObservers() {
        viewModel?.getDisplayText()?.observe(this, Observer {
            displayText.text = it
        })

        viewModel?.getScoreText()?.observe(this, Observer {
            resultText.text = it
        })

        viewModel?.getShowErrorMessage()?.observe(this, Observer {
            if (it) showTooManyRollsMessage()
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bowling_score_gui)

        attachViewModel()
        attachObservers()
        setClickListeners()
    }

    private fun setClickListeners() {
        for (i in 1..12) {
            val button = findViewById<Button>(resources.getIdentifier("button_$i", "id", packageName))
            button.setOnClickListener { v -> viewModel?.addRollToRollLine(v.tag.toString()) }
        }

        button_clean.setOnClickListener { viewModel?.cleanRollLine() }
        button_cancel.setOnClickListener { viewModel?.cancelLatestAddedRollToLine() }
        button_calculateScore.setOnClickListener { viewModel?.computeScore() }
    }

    private fun showTooManyRollsMessage() {
        Toast.makeText(this, "Too Many Rolls", LENGTH_LONG).show()
    }
}
