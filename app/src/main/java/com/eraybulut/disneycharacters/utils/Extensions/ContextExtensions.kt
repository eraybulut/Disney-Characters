package com.eraybulut.disneycharacters.utils.Extensions

import android.content.Context
import android.widget.Toast

fun Context?.showToast(message:String,duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

}