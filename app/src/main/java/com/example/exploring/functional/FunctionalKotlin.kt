package com.example.exploring.functional

import kotlin.time.measureTime

fun main(){
   //Lambda Expression { Acts as inner method }
    val multiFormsInt : (Int) -> Unit = {
        val intAsChar = it.toChar()
        val intAsString = it.toString()
        val intAsDouble = it.toDouble()
        println("Char Form $intAsChar \nString Form $intAsString \nDouble Form $intAsDouble")
    }
    multiFormsInt(50)

    val contactInfo: (Int, String) -> Unit = {
        phone : Int, address : String ->
        println("Phone number : $phone \nAddress : $address")
    }
    contactInfo(22, "Amr")

    // Higher Order Function << It's a function with fun as input and fun as output >>
    val lambdaFun:(Int) -> Int = {it.dec()}
    val num = 50
    println(highOrderFunction(num = num, lambdaFun = lambdaFun))

    //Some Examples on The high order function ( filter , map, flatmap, Use zip )
    val list = (0..10).toList() //by this you can create a method without using loop
    // filter << it return only the values in the lis that achieve the condition >>
    val filteredList = list.filter { it % 2 == 0 }
    println(filteredList)
    // map << it return all the values but with the operation that we pass or condition with true or false>>
    val mapList = list.map { it % 2 == 0 }
    println(mapList) // now you see the difference
    // flatmap << it's related to the nested lists (list inside list) so it generate one list >>
    //Example
    val nestedLis = listOf(
        (0..10).toList(),
        (11..20).toList(),
        (21..30).toList()
    )
    println(nestedLis.flatMap { it }.sortedDescending())
    //Or
    println(nestedLis.flatten().sortedDescending())
    // zip method << it to concatenate two or more lists >>
    val names = listOf("Ahmed", "Amr", "Reem")
    val ages = listOf(23, 20, 10)
    val contact = listOf("0100000", "011000", "012000")

    val zipped = (names.zip(ages)).zip(contact)
    println("Zipped method : $zipped" )

    // Challenge on higher order function
    challenge()

    // Lazy sequences
    val newList = (0..100).toList()
    println(newList.take(10)) // to shows first n of list items
    println(newList.takeLast(10)) // to shows last b of list items
    println(newList.drop(50)) // it will show after n of list items from the start
    println(newList.dropLast(20)) // it will drop the last 20 items

    val seq = generateSequence<Long>(0){ (it * it) +2 }.take(10)
    println(seq.joinToString())
    //Sequence in arranging methods and sequence
    // Example
    val hugeList = (0..1000000L).toList()
    var summation = 0L
    val processTime = measureTime {
        summation = hugeList.map { it * 5 }
            .filter { it > 60 }
            .take(200)
            .sum()
    }
    println("Summation = $summation with processing in $processTime MS")
    val processTime2 = measureTime {
        summation = hugeList
            .asSequence()  // Only with large lists
            .map { it * 5 }
            .filter { it > 60 }
            .take(200)
            .sum()
    }
    println("Summation = $summation with processing in $processTime2 MS")

    /* Inline function "It helps us in higher order methods if it's input is lambda it will not
       create object it will take the lambda expression as it is */
    val modifiedText = modifyString("Hello Kotlin"){ it.lowercase()+" : Modified"}
    println(modifiedText)

    // It is important to note that there is cases we need the lambda to be object so we don't use inline


}
// A high order function that takes an int and  lambda function
fun highOrderFunction (num : Int, lambdaFun:(Int) -> Int) = num + lambdaFun(20)

// InLine Function
inline fun modifyString(text : String, modify:(String)-> String) = modify(text)

//Challenge
fun challenge(){
    //Input
    val data = mapOf(
        "users1.csv" to listOf(32, 45, 17, -1, 34),
        "users2.csv" to listOf(19, -1, 67, 22),
        "users3.csv" to listOf(),
        "users4.csv" to listOf(56, 32, 18, 44)
    )
    // 1- average ages for all users
    val flatAges = data.values.flatten()
    val filterAges = flatAges.filter { it > 0 }
    val averageAges = filterAges.average()
    println("The average ages to the users is : $averageAges")

    // 2- the users that have faulty data
    val faultyUsers = data.filter { it.value.any{ it < 0 } }.keys
    println(faultyUsers)
    // 3- count how many integers are faulty
    val numOfFaulty = data.values.filter { it.any{ it < 0 } }.size
    println(numOfFaulty)


}