package com.example.platform_view_poc

import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView

class TextCounterView : FrameLayout {

    constructor(context: android.content.Context) : super(context)

    constructor(context: android.content.Context, attrs: android.util.AttributeSet) : super(context, attrs)

    constructor(context: android.content.Context, attrs: android.util.AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var mTextView: TextView

    private var mTextCounter: TextCounter = TextCounter.instance

    init {
        Log.v("PlatformView", "TextCounter init with $this")
        inflate(context, R.layout.layout, this)
        mTextView = findViewById(R.id.textView)
        mTextCounter.setOnTickRunnable(object : TickCounterRunnable {
            override fun run(millisUntilFinished: Long) {
                mTextView.text = millisUntilFinished.toString()
            }
        })

        mTextCounter.setOnFinishRunnable(object : TickCounterRunnable {
            override fun run(millisUntilFinished: Long) {
                mTextView.text = "FINISHED"
            }
        })
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.v("PlatformView", "onAttachedToWindow for $this")
        mTextCounter.startCountDown()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        if (visibility == View.VISIBLE) {
            Log.v("PlatformView", "onVisibilityChanged for $this")
            mTextCounter.startCountDown()
        } else {
            mTextCounter.cancelCountDown()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.v("PlatformView", "onDetachedFromWindow for $this")
        mTextCounter.cancelCountDown()
    }


}