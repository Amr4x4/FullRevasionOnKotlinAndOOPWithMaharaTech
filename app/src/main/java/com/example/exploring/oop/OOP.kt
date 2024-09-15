package com.example.exploring.oop

class Empty // if it is an empty class there is no need for { }.

class City{
    var citzien = 0 // You can set a default value
    var name:String? = null // Or you can make it nullable and gave it null
    var size:Double? = null // null can be with all types .
}

class Student{
    var name:String? = null
    var age = 0          // You can customize the setter and getter
        set(value) {
            field = if(value < 0)
                0
            else
                value
        }
        get() = field * 2
}
class Car(
    var model:String,    // Not that there is a different between { var model:String and model:String }
                        // var model:String -> is an attribute in the class and model:String -> is parameter
    var year:Int,
    var description:String
){

}

// Overloading the constructor
class House( var onwer: String ){ // Primary constructor
    constructor( theOwner:String, zone:String, salary:Int ):this( theOwner ){ // secondary constructor

    }
    constructor( theOwner: String, zone:String):this(theOwner){ // secondary constructor

    }
}

// The difference between class and data class
class ClassTest(var something:String){
}
data class DataClassTest(var something: String){
}

fun main(){

    // How to create Object
    val obj = Empty()
    val city1 = City()
    city1.apply {
        citzien = 2000000 // You are not calling the variable directly but the setter method
        name = "New Cairo"
        size = 16.5
    }
                        // and here you are not accessing it directly but you are using the default getter
    println("1) Name = ${city1.name} \t Population = ${city1.citzien} \t Size = ${city1.size} KM^2 ")

    val student1 = Student()
    student1.apply {
        name = "Amr"
        age = -22
    }
    println("${student1.name}, ${student1.age}")
    val student2 = Student()
    student2.apply {
        name = "Ahmed"
        age = 22
    }
    println("${student2.name}, ${student2.age}")

    val house1 = House("Amr Anwar")
    val house2 =  House("Amr Anwar", "Cairo")
    val house3 = House("Amr Anwar", "Cairo", 50000)

    // Class and Data Class
    println(ClassTest("Class"))
    println(DataClassTest("Data Class"))


}