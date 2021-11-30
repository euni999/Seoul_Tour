package com.example.middle.data
import java.io.Serializable

data class Seoul(
    var name:String,
    var address:String,
    var content:String,
    var pic:Int,
    var type:Int
    ) : Serializable