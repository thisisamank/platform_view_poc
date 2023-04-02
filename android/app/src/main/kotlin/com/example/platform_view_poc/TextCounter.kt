package com.example.platform_view_poc

import android.os.CountDownTimer

object TextCounter {
//    private var mCountDownTimer: CountDownTimer? = null
    private lateinit var onTickRunnable: TickCounterRunnable
    private lateinit var onFinishRunnable: TickCounterRunnable

    private val countDownTimer = object : CountDownTimer(100000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            onTickRunnable.run(millisUntilFinished)
        }

        override fun onFinish() {
            onFinishRunnable.run(0)
        }
    }



    fun setOnTickRunnable(runnable: TickCounterRunnable) {
        onTickRunnable = runnable
    }

    fun setOnFinishRunnable(runnable: TickCounterRunnable) {
        onFinishRunnable = runnable
    }

    fun startCountDown() {
        countDownTimer.start()
    }


    fun cancelCountDown() {
        countDownTimer.cancel()
    }




}