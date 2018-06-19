package br.arch.com

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btTeamA.setOnClickListener{viewModel.updateTeamA()}
        btTeamB.setOnClickListener{viewModel.updateTeamB()}
        btReset.setOnClickListener{viewModel.reset()}

        viewModel.scoreTeamA.observe(this, Observer { value ->
            tvTeamA.text = value.toString()
        })

        viewModel.scoreTeamB.observe(this, Observer { value ->
            tvTeamB.text = value.toString()
        })

    }
}
