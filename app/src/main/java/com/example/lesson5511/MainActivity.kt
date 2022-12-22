package com.example.lesson5511
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson5511.databinding.ActivityMainBinding
import com.example.lesson5511.presenter.Presenter
import com.example.lesson5511.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    var presenter = Presenter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()

    }

    private fun initClicker() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()

            }

        }

    }

    override fun changeCount(count: Int) {
        binding.counterTv.text = count.toString()

    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_LONG).show()
    }


    override fun changeColor(color: Int) {
        binding.counterTv.setTextColor(color)
    }


}

