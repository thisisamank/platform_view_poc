package com.example.platform_view_poc

import android.content.Context
import android.util.Log
import android.view.View
import io.flutter.plugin.platform.PlatformView

class TextCounterPlatformView(private val context: Context) : PlatformView {

    init {
        Log.v("PlatformView","TextCounterPlatformView init with $this")
    }

    private var mTextCounter: TextCounterView? = null


    override fun onFlutterViewAttached(flutterView: View) {
        Log.v("PlatformView", "onFlutterViewAttached for $this")
        super.onFlutterViewAttached(flutterView)
    }

    override fun onFlutterViewDetached() {
        Log.v("PlatformView", "onFlutterViewDetached for $this")
        super.onFlutterViewDetached()
    }

    override fun getView(): View? {
        if (mTextCounter == null) {
            Log.v("PlatformView", "getView is null for $this")
            mTextCounter = TextCounterView(context)
        }
        return mTextCounter
    }

    override fun dispose() {
        Log.v("PlatformView", "dispose with $this")
        mTextCounter = null
    }

}