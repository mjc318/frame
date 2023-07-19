package com.example.frame.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.frame.R
import com.example.frame.databinding.FragmentPinLoginBinding
import com.example.frame.tool.navigateTo

class PinLoginFragment : Fragment() {
    private lateinit var binding: FragmentPinLoginBinding    //xxxBinding  :xxx为绑定对象
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPinLoginBinding.inflate(inflater,null,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameInputView.setTitle("用户名")
        binding.nameInputView.setPlaceholder("请输入用户名")

        binding.passwordInputView.setTitle("密码")
        binding.passwordInputView.setPlaceholder("请输入密码")

    }
}
