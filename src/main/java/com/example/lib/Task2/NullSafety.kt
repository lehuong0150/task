package com.example.lib_task.Task2
/*
    5. Null Safety (An toàn với null)
        Nullable (?) và Non-nullable
        Elvis Operator (?:)
        Safe Call (?.)
        Not-null Assertion (!!)
 */
fun main(){
    demoNullSafety()

}
fun demoNullSafety(){
    //Non-nullable
    var a: String = "Hello"
    //a = null //Loi vi a la non-nullable
    println(a)

    //Nullable
    var b: String? = "Kotlin"
    b = null //Khong loi vi b la nullable
    println(b)

    //Safe Call (?.)
    var length1 = b?.length
    println("Length1: $length1")

    //Elvis Operator (?:)
    var length2 = b?.length ?: 0
    println("Length2: $length2")

    //Not-null Assertion (!!)
    //var length3 = b!!.length
    //println("Length3: $length3")

    //Kiem tra null truoc khi su dung Not-null Assertion
    val  c: String = "Kotlin"
    var length3 = c!!.length
    println("Length of c: $length3")

}

