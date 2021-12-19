package com.example.dietrecord.food

import java.io.Serializable

class Food (
            var NO: String?= null,
            var calorie: String?= null,
            var carbo: String?= null,
            var fat: String?= null,
            var foodName: String?= null,
            var gram: String?= null,
            var protein: String?= null,
            var sodium: String?= null,
) : Serializable