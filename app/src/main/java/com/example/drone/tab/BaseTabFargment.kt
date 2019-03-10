package com.example.drone.tab

import androidx.fragment.app.Fragment

abstract class BaseTabFargment : Fragment(){
    abstract fun getIcon():Int
    abstract fun getSelectedIcon():Int

}