package com.example.lesson5511.presenter

import android.graphics.Color
import com.example.lesson5511.model.CounterModel
import com.example.lesson5511.view.CounterView


class Presenter {
    private val model = CounterModel()
    lateinit var view: CounterView
    fun increment() {
        model.increment()
        view.changeCount(model.count)
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count == 15) {
            view.changeColor(Color.GREEN)
        } else {
            view.changeColor(Color.BLACK)
        }
    }

    fun decrement() {
        model.decrement()
        view.changeCount(model.count)
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count != 15) {
            view.changeColor(Color.BLACK)
        } else {
            view.changeColor(Color.GREEN)
        }

    }

    fun attachView(view: CounterView) {
        this.view = view

    }

}