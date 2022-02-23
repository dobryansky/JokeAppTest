package com.artem.jokeapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.actionBtn)
        val progressBar = findViewById<View>(R.id.progress_bar)
        val textView = findViewById<TextView>(R.id.textView)

        viewModel = (application as JokeApp).viewModel

        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
           viewModel.getJoke()
        }

        viewModel.init(object : TextCallback {
            override fun provideText(str: String) = runOnUiThread {
                button.isEnabled = true
                progressBar.visibility = View.INVISIBLE
                textView.text = str
            }

        })


    }

    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()
    }
}
