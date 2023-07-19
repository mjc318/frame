package com.example.frame.tool

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.frame.R
import com.example.frame.view.fragments.PinRegisterFragment

fun Fragment.navigateTo(target: Fragment,
                        enterAnima:Int = R.anim.enter_from_right,
                        exitAnima:Int = R.anim.exit_to_left,
                        popEnter:Int = R.anim.pop_enter_from_left,
                        popExit:Int = R.anim.pop_exit_to_right,
                        addToStack:Boolean = true){      //导航  navigation
    parentFragmentManager.commit {
        setCustomAnimations(enterAnima,exitAnima,popEnter,popExit)
        replace(R.id.fragmentContainerView, target)
        setReorderingAllowed(true)
        if(addToStack){
            addToBackStack(null)
        }
    }
}