package com.example.frame.view.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.example.frame.R
import com.example.frame.databinding.LayoutUserInputBinding


/** 使用代码创建一个控件时，调用这个构造方法*/
//          constructor(context:Context):super(context)
/** 在xml中添加一个控件 并设置对应属性时，调用这个构造方法*/
//          constructor(context:Context,attrs:AttributeSet?):super(context, attrs){}
/** 在xml中添加一个控件 并设置了style样式的，调用这个构造方法*/
//          constructor(context:Context,attrs:AttributeSet?,style:Int):super(context, attrs,style){}

                 //提供一个主构造函数
class UserInputView(context:Context,attrs:AttributeSet?):FrameLayout(context,attrs){
        //当一个对象被创建时   先 1.构造函数 再 2.init方法
//     private var titleTextView:TextView
//     private var inputEditText:EditText
     private  val binding:LayoutUserInputBinding by lazy {
         LayoutUserInputBinding.inflate(LayoutInflater.from(context))
        }
    init {    //当一个对象被创建时   先 1.构造函数 再 2.init方法
        //将layout布局文件和当前这个类相关联
            val layoutInflater = LayoutInflater.from(context)           //root 父容器
            //创建一个布局参数layoutParam
            val lp =FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            //将解析出来的View添加到当前容器里面，显示出来
            addView(binding.root,lp)    //两个参数：将哪个添加到Frame layout中，，怎么放


    }
            //暴露给外部配置信息
    fun setTitle(title:String){
        binding.titleTextView.text = title
    }

    fun setPlaceholder(text:String){
        binding.inputEditText.hint = text
    }

}






















