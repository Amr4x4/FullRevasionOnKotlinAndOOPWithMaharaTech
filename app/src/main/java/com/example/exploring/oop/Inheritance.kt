package com.example.exploring.oop

/* All classes in kotlin is final so we can not inherit from it
 directly we have to use in the super class the keyword ( open )  */
open class Employee(
    var name: String ,
    var id:Int ,
    var age:Int ){


    open fun salary():Int{
        return 5000 + age*5
    }
    fun styleCard(){
        println("Name: $name \nID: $id")
    }
}


class Engineering(
     engName: String ,
     engID:Int ,
     engAge:Int ,
     var role :String
    ): Employee(engName,engID,engAge){

    override fun salary(): Int {
        return 6000 + age * 10
    }

    fun printRole(){
        println("Role: $role")
    }
}

fun main(){
    val eng1 = Engineering(engName = "Amr", engID = 11, engAge = 22, role = "Android")
    println(eng1.salary())
    eng1.printRole()
    eng1.styleCard()

}