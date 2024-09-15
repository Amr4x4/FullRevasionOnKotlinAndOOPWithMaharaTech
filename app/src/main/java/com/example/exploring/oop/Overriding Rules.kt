package com.example.exploring.oop

//Role 1
// At the override you can higher the scope but never go down with the scope
open class Base1 (open var x:Int)
class Child1(override var x:Int): Base1(x) // Accepted

open class Base2 (open var x:Int)
//class Child2(override val x:Int): Base2(x) // UnAccepted

open class Base3 (open val x:Int)
class Child3(override var x:Int): Base3(x) // Accepted

//Role 2
// If there is a method with the same signature in different places you have to overload it
open class MyClass{
    open fun test(){
        println("Class")
    }
}
interface MyInterface{
    fun test(){
        println("Interface")
    }
}

class Subclass: MyClass(),MyInterface{
    override fun test() {
        super<MyInterface>.test()
        super<MyClass>.test() // You have to say which super is it
    }


}
fun main(){

}