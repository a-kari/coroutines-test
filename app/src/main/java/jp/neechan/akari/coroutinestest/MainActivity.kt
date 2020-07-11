package jp.neechan.akari.coroutinestest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.textLiveData.observe(this, Observer { text ->
            textView.text = text
        })
    }
}