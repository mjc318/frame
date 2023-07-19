package com.example.frame.tool

import android.util.Log
//v i d e
object  MyLog {
    private const val IS_RELEASE = true

    fun v(content:String,tag:String = "mj"){
        if (!IS_RELEASE){
            Log.v(tag,content)
        }
    }
}