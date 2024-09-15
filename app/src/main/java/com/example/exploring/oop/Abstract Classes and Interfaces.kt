package com.example.exploring.oop

abstract class Body(){ // when we can not make object from abstract class so open here not necessary
    abstract fun hasDimensions()
    fun shapeName(item: String){
        println(item)
    }
}

class Square: Body(){
    override fun hasDimensions() {
        println("Has Length and Width equal to each Other")
    }
}
class Circle: Body(){
    override fun hasDimensions() {
        println("Has Diameter")
    }

}


interface Animal{ // The main difference between abstract class and Interface is
                        // 1- we use implement ( we can implement multiple interfaces )
                        // 2- constructor only in abstract class
    fun hasEyes(numOfEyes: Int){
        println("It has $numOfEyes Eyes")
    }
    fun makesSound()
}
interface Pet{
    fun isItPet():Boolean
}

class Cat : Animal, Pet{
    override fun makesSound() {
        println("Mwo Mwo")
    }

    override fun isItPet(): Boolean {
        return true
    }

}

fun main(){
    val sq = Square()
    sq.hasDimensions()
    sq.shapeName("This is Square")

    val circle = Circle()
    circle.hasDimensions()
    circle.shapeName("This is Circle")
}