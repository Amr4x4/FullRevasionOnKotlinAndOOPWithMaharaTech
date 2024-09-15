package com.example.exploring.basic

import kotlin.random.Random

fun main() {
    // Variables in Kotlin
    val x = 5 // It detect the type automatically -> val x:Int = 5
    // val refer to final value can not be reassigned
    var z = 6
    z = 7 // when var refer that you can reassignment

// Null In Kotlin
    // Default case
    val x1: Int = 5
    // x = null     rejected we must declare the type as Nullable

    // Type 1 " Null Safety "
    val x2: Int? = null // Nullable type
    println(x2?.dec()) /* This process could null safety " ? "
                          The main benefit from this is that the app will not
                          going to crash */
    // Type 2 " Assertion Operator "
    val x3: Int? = 5
    println(x3!!.dec()) /* This process could null assertion " !! "
                           we enforce the compiler to accept the operation
                           but the problem is if the value will be null the app
                           will going to crash */
    // Type 3 " Elves Operator "
    val x4: Int? = null
    val y = x4 ?: 0/* This process could Elves Operator " ?: "
                           _The point here is that we put another choice
                            if the first one is null */
    println(y)

// If expression
    val age = 50
    /*
     The old way is :
     ---------------
      val massage = null
      if(age <= 22 ){
       massage = "Accepted"
       } else {
       massage = "Unaccepted"
       }*/

    var massage = if (age <= 22) "Accepted" else "UnAccepted"

// when expression
    /* when in kotlin works as switch in java but there is
      added feature is we can add range
   */
    // Usage 1
    when (age) {
        0 -> println("Special Case")
        in 1..22 -> println("Accepted")
        else -> println("Unaccepted")
    }
    // Usage 2
    massage = when (age) {
        0 -> "Special Case"
        in 1..22 -> "Accepted"
        else -> "Unaccepted"
    }
    // Usage 3
    when {
        massage.equals("Accepted") -> println("Congratulation")
        massage.equals("Unaccepted") -> println("Bad Luck")
    }

    // -----------------<< Collections >>---------------------

// "List" Collection <<Same as in java but with new features ( mutable, immutable )>>
    // Mutable is like in java so we can read and write but Immutable is only for read
    // So we can not modify in Immutable collection

    //Example for mutable list
    val listOfAges = mutableListOf<Int>()
    listOfAges.add(20)
    listOfAges.add(22)
    // [ 20, 22 ]
    listOfAges.add(0, 18)
    // [ 18, 20, 22 ]
    println(listOfAges)

    //Example for immutable list
    val list = listOf<Int>(22, 18, 29)
    println(list)
    println(list[0])
    //list.add(15)  rejected because it's read only method

// "Set"  it's main functionality is to avoid doublecated elements
    val setOfElements = mutableSetOf<Int>()
    setOfElements.add(20)
    setOfElements.add(20)
    setOfElements.add(20)
    println(setOfElements) // Result is [20]

    /* Sample task to understand the main point for the Set collection
    * Imagine that we want to take all the numbers that the user will insert
       and we want both the unique numbers and whole numbers to be printed*/
    // task1() //call it

// Map Collection
    // 1
    val map1 = mutableMapOf<Int, String>(Pair(1, "Kotlin"), Pair(2, "Java"))
    // 2
    val map2 = mutableMapOf<Int, String>(1 to "Kotlin", 2 to "Java")
    // 3
    val map3 = mutableMapOf<Int, String>(1 to "Kotlin", 2 to "Java")
    map3[3] = "C++"  // Or map3.set(3 , "C++")

    println(map3.values)
    println(map3.keys)
    println(map3)

    // -----------------<< Loops >>---------------------
    // For Loop
    for( i in 0..10 step 2){
        println("Number $i")
    }
    val string = "Android"
    for( i in string ){ // The default step is 1
       println("$i") // i carries the things that is looping on like ex string
    }
    for(item in list){
        println(item)
    }

    // While Loop & Do While
    //Exactly like in java
    var counter = 0
    while(counter < 10){
        println("$counter")
        counter++
    }

    do {
        println("$counter")
        counter--
    }while (counter > 0)

    task2()

// Function takes multi able inputs
    println(checkForAge(12,20,10))
    println(checkForAge(30,25,28,18))

// Functions with named argument
    val programing = mutableListOf("Android", "Kotlin", "Java")
    println(customizingListSeparator(programing))
    println(customizingListSeparator(programing, " @ "))
    println(customizingListSeparator(separator = " , ", list = programing))

// Extension Function
    val unknown = 5
    println(unknown.evenOrOdd())
// Infix Function
    println( unknown addAndCheck 5 )
    
}


fun task1(){
    println("Enter the maximum number that you will insert")
    var counter = readln().toInt()

    val userNumbers = mutableListOf<Int>()
    val userUniqueNumbers = mutableSetOf<Int>()

    var flag = 0

    if(counter > 0){
        println("Enter the $counter numbers : ")
        while (counter > 0){
            userNumbers.add(flag, readln().toInt())
            userUniqueNumbers.add(userNumbers[flag])
            flag++
            counter--
        }
        println("The whole numbers is : $userNumbers")
        println("The unique numbers is : $userUniqueNumbers")
    } else {
        println("Error : Number must be > 0 .")
    }
}
/* Challenge fill a list with random numbers from 0 to 100 and print the numbers
   less than or equal to 10 without using if or when */
fun task2(){
    val list = mutableListOf<Int>()
    for( i in 1..100){
        list.add(Random.nextInt(0,100))
    }
    var i = 0
    while(list[i] <= 10 && i != list.size-1){
        println(list[i])
        i++
    }
}

// This function takes a group of integers if one of them less than 18 this group will be no accepted
fun checkForAge(vararg numbers:Int):Boolean{
    for(num in numbers){
        if (num < 18){
            return false
        }
    }
    return true
}
// This function is to return list with a customizing separator
fun customizingListSeparator (list :List<String>, separator: String = " - ") = list.joinToString(separator)

// Extension Function " the Ability to add and modify function from created class "
fun Int.evenOrOdd (): String{
    return if(this % 2 == 0){
        "Even"
    }
    else{
        "Odd"
    }
}
// Infix method " Method you call call it by different ways " $Must be Extension$
infix fun Int.addAndCheck(number :Int ) :String = (this + number).evenOrOdd()