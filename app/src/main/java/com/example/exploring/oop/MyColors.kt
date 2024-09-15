package com.example.exploring.oop

enum class MyColors (val wight: Double){
     RED(0.25), WHITE(0.30), BLUE(0.4), YELLOW(0.05)
}

fun main(){
     val colorDegree = MyColors.YELLOW
     println(colorDegree)


}