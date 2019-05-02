package com.kata.bowling.kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var lineOfRoll: String = ""

    private var showMessage: MutableLiveData<Boolean> = MutableLiveData()
    private var displayText: MutableLiveData<String> = MutableLiveData()
    private var scoreText: MutableLiveData<String> = MutableLiveData()

    fun getDisplayText() : LiveData<String> = displayText

    fun getScoreText() : LiveData<String> = scoreText

    fun getShowErrorMessage() : LiveData<Boolean> = showMessage

    private fun updateDisplayText() {
        displayText.postValue(lineOfRoll)
    }

    private fun setScoreText(text: String) {
        scoreText.postValue(text)
    }

    private fun showErrorMessage() {
        showMessage.postValue(true)
    }

    init {
        updateDisplayText()
        setScoreText("")
    }

    fun addRollToRollLine(s: String) {
        lineOfRoll += s
        updateDisplayText()
    }

    fun cleanRollLine() {
        lineOfRoll = ""
        updateDisplayText()
        setScoreText(lineOfRoll)
    }

    fun cancelLatestAddedRollToLine() {
        lineOfRoll = if (lineOfRoll.isNotEmpty()) {
            lineOfRoll.substring(0, lineOfRoll.length - 1)
        } else {
            ""
        }

        updateDisplayText()
        setScoreText("")
    }

    fun computeScore() {
        // TODO
        setScoreText("THIS NEEDS TO BE CALCULATED")
        updateDisplayText()
    }
}