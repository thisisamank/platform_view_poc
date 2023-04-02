package com.example.platform_view_poc

import android.os.CountDownTimer

class TextCounter private constructor() {
    private lateinit var mCountDownTimer: CountDownTimer
    private lateinit var onTickRunnable: TickCounterRunnable
    private lateinit var onFinishRunnable: TickCounterRunnable


    companion object {
        val instance = TextCounter()
    }

    fun setOnTickRunnable(runnable: TickCounterRunnable) {
        onTickRunnable = runnable
    }

    fun setOnFinishRunnable(runnable: TickCounterRunnable) {
        onFinishRunnable = runnable
    }

    fun startCountDown() {
        mCountDownTimer = object : CountDownTimer(100000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                onTickRunnable.run(millisUntilFinished)
            }

            override fun onFinish() {
                onFinishRunnable.run(0)
            }
        }
        mCountDownTimer.start()
    }


    fun cancelCountDown() {
        mCountDownTimer.cancel()
    }




}