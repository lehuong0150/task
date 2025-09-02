package com.example.lib_task

//demo basic
data class Student(val id: Int, var name: String, var age: Int, var score: Double){
    fun displayInfo() {

        println("ID: $id, Name: $name, Age: $age, Score: $score, Passed: $pass")
    }
    val pass: String
        get() = if (isPassed) "Dat" else "Khong dat"
    val isPassed: Boolean
        get() = score >= 5.0
}
// ep kieu
fun addStudent( students:MutableList <Student>){
    println("Nhap thong tin sinh vien moi:")
    print("ID: ")
    val id = readLine()!!.toInt()
    print("Name: ")
    val name = readLine()!!
    print("Age: ")
    val age = readLine()!!.toInt()

    print("Score: ")
    val score = readLine()!!.toDouble()

    val newStudent = Student(id, name, age, score)
    students.add(newStudent)
}
//demo operator
fun demoOperator( students: List<Student>){
    // diem cao nhat va thap nhat
    var maxScore = students.maxByOrNull { it.score }?.score ?: 0.0
    var minScore = students.minByOrNull { it.score }?.score ?: 0.0

    //tong 2 diem thap va cao nhat
    println("Tổng điểm = ${maxScore + minScore}")
    println("Hiệu điểm = ${maxScore - minScore}")
    println("Nhân điểm = ${maxScore * minScore}")

    println("\nSinh vien co diem tren 9:")
    students.filter { it.score>9 }.forEach({ it.displayInfo() })
    println("\nSinh vien co diem duoi 7:")
    students.filter { it.score < 7 }.forEach { it.displayInfo() }
    //hien thi so sinh vien 20 tuoi
    println("\nSo sinh vien 20 tuoi: ${students.count { it.age == 20 }}")

    //hien thi so sinh vien khac 20 tuoi
    println("So sinh vien khac 20 tuoi: ${students.count { it.age != 20 }}")
    // su dung when

}
fun demoCondition(student: MutableList<Student>){
    //if else
    if (minScore != 0.0) {
        println("Chia điểm = ${maxScore / minScore}")
        println("Chia lấy dư = ${maxScore.toInt() % minScore.toInt()}")
    }
    else{
        println("Chia điểm = Không thể chia cho 0")
        println("Chia lấy dư = Không thể chia cho 0")
    }
    //when
    println("\nSinh vien tu 20 den 22 :")
    for (student in students){
        when(student.age){
            in 20..22 -> student.displayInfo()
            else -> {"Khong ton tai sinh vien o do tuoi nay"}
        }
    }
    println("Sinh vien tu :")
    for (s in student){
        when(s.age){
            20 -> "20: " + s.displayInfo()
            21 -> "21: " + s.displayInfo()
            22 -> "22: " + s.displayInfo()
            else -> {"Khong ton tai sinh vien o do tuoi nay"}

        }
    }
}
fun demoLoop(students: List<Student>){
    //for hien thi ds sinh vien theo nhieu cach
    displayListstudent(students)
    //while
    demoWhile(students)
    //break, continue
    demoBreakContinue()
    //demo cac loai for khac
    demoFor()

}

fun demoWhile(student: MutableList<Student>){
    //while
    println("\nDanh sach sinh vien (while):")
    var index = 0
    while (index < students.size){
        students[index].displayInfo()
        index++
    }

    //do-while
    println("\nDanh sach sinh vien (do-while):")
    index = 0
    do {
        students[index].displayInfo()
        index++
    } while (index < students.size)

}
fun displayListstudent(students: List<Student>){
    //for
    println("Danh sach sinh vien:")
    for (student in students){
        student.displayInfo()
    }
    //forEach
    println("\nDanh sach sinh vien (forEach):")
    students.forEach { it.displayInfo() }
    //forEachIndexed
    println("\nDanh sach sinh vien (forEachIndexed):")
    students.forEachIndexed { index, student ->
        println("Index: $index")
        student.displayInfo()
    }
    //for with index
    println("\nDanh sach sinh vien (for with index):")
    for (index in students.indices){
        println("Index: $index")
        students[index].displayInfo()
    }
}
fun demoBreakContinue(){
    println("\nDanh sach sinh vien (break, continue):")
    for (student in students){
        if (student.score < 5.0){
            println("Sinh vien bi loai:")
            student.displayInfo()
            continue
        }
        if (student.score > 9.0){
            println("Sinh vien xuat sac:")
            student.displayInfo()
            break
        }
        student.displayInfo()
    }
}
fun demoFor(){
    //for
    println("Demo for:")
    for (i in 1..5){
        println("i = $i")
    }
    //for with if
    println("Demo for with if:")
    for (i in 1..10){
        if (i % 2 == 0){
            println("i = $i")
        }
    }
    // nested loop
    println("Demo nested loop:")
    for (i in 1..3){
        for (j in 1..3){
            println("i = $i, j = $j")
        }
    }
    //for array
    println("Demo for array:")
    val arr = arrayOf(1, 2, 3, 4, 5)
    for (i in arr){
        println("i = $i")
    }
    //for array with index
    println("Demo for array with index:")
    for (i in arr.indices){
        println("Index: $i, Value: ${arr[i]}")
    }
}