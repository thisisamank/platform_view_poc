package com.example.platform_view_poc

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ViewSwitcher.ViewFactory
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class TextCounterFactory : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    init {
        Log.v("PlatformView", "Factory init")
    }

    override fun create(context: Context?, viewId: Int, args: Any?): PlatformView {
        Log.v("PlatformView", "TextCounterFactory create with $this")
        if (context == null){
            throw AssertionError("context for TextCounter is null!")
        }
        return TextCounterPlatformView(context)
    }
}