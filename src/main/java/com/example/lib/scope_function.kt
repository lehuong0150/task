package com.example.lib_task

fun main() {
    val student = Student("Alice", 20, 8.5)
    demoScopeFunction(student)
}
fun demoScopeFunction(student: Student) {
    // apply
    val studentApply = student.apply {
        age = 21
        score = 9.0
    }
    println("Student Apply: $studentApply")

    // also
    val studentAlso = student.also {
        it.age = 22
        it.score = 9.5
    }
    println("Student Also: $studentAlso")

    // let
    val studentLet = student.let {
        it.age = 23
        it.score = 10.0
        it
    }
    println("Student Let: $studentLet")

    // run
    val studentRun = student.run {
        age = 24
        score = 7.5
        this
    }
    println("Student Run: $studentRun")

    // with
    val studentWith = with(student) {
        age = 25
        score = 8.0
        this
    }
    println("Student With: $studentWith")
}