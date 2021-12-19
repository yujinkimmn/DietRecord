package com.example.dietrecord.splash

import java.io.Serializable

class Profile(
    var userName: String?= null,
    var goal: String?= null,
    var sex: String?=null,
    var act: String?= null,
    var wgt: String?= null,
    var hgt: String?= null,
    var birth: String?= null,
    var age: String? = null
) : Serializable