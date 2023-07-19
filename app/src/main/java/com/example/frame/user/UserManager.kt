package com.mj.loginproject.user

import android.content.Context
import com.mj.loginproject.file.FileManager
import java.lang.ref.WeakReference

class UserManager private constructor(private val context:WeakReference<Context>){    //私有化构造函数
    private val users = arrayListOf<User>()  //保存用户
    private val fileManager = FileManager.sharedInstance()

    companion object{
        private var instance: UserManager? = null
        fun sharedInstance(context: Context): UserManager?{
            if (instance == null){
                synchronized(this){
                    if (instance == null)
                        instance = UserManager(WeakReference(context))
                }
            }
            return instance!!
        }
    }

    fun loadAllUserInfo(){           //get()返回值为可选
        fileManager.readData(context.get()!!).also {
            users.addAll(it)
        }

    }

    fun hasUser() = users.size > 0   //返回值为Boolean，>0则返回true，否则返回false

    fun checkUser(name:String):Boolean{
        users.forEach {
            if (it.name == name){
                return true
            }
        }
        return false
    }

    fun checkUser(name: String,password:String,type:Int):Boolean{
        users.forEach { user ->
            if (user.name == name){
                if (type == PasswordType.LoginType_Pin){
                     return user.pin == password
                }else{
                    return user.pattern == password
                }
            }

        }
        return false
    }

    fun currentUser():User?{
        //过滤，形成一个集合
        users.filter {it.isLogin }.also {
            return if (it.isNotEmpty()){
                it[0]    //同一时间只有一个用户登录
            }else{
                null
            }
        }
    }

    fun registerUser(name: String,pin:String,pattern:String){
        users.add(User(name,pin,pattern,false))
    }

    fun login(name: String,password:String,type:Int):Boolean{
        var user:User? = null
        users.forEach {
            if (it.name == name) {
                if (type == PasswordType.LoginType_Pin) {
                    if (it.pin == password) {
                        user = it
                    }
                } else {
                    if (it.pattern == password) {
                        user = it
                    }
                }
            }
        }
            return if (user != null){
                currentUser()?.let { it.isLogin = false }//将之前的登陆状态改为false
                user?.isLogin = true
                fileManager.writeData(context.get()!!,users)
                true
            }else{
                false
            }
        }


}



















