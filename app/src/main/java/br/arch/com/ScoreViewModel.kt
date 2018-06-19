package br.arch.com

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ScoreViewModel : ViewModel(){
    var scoreTeamA = MutableLiveData<Int>().apply { value = 0 }
    var scoreTeamB = MutableLiveData<Int>().apply { value = 0 }

    fun updateTeamA(){
        update(scoreTeamA)
    }

    fun updateTeamB(){
        update(scoreTeamB)
    }

    fun reset(){
        scoreTeamA.value = 0
        scoreTeamB.value = 0
    }

    private fun update(score: MutableLiveData<Int>){
        val value = score.value ?: 0
        score.value = value +1
    }
}