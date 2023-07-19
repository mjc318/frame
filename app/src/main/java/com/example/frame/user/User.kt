package com.mj.loginproject.user


data class User(
    val name:String,
    val pin:String,
    val pattern:String,
    var isLogin:Boolean
)