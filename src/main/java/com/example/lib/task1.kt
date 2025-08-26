package com.example.lib

//Xây dựng chương trình Quản lý Sinh viên bằng Kotlin
data class Student(val id: Int, var name: String, var age: Int, var score: Double){
    fun displayInfo() {

        println("ID: $id, Name: $name, Age: $age, Score: $score, Passed: $pass")
    }
    val pass: String
        get() = if (isPassed) "Dat" else "Khong dat"
    val isPassed: Boolean
        get() = score >= 5.0
}
fun main(){
    val student1 = Student(1, "Dao Thi My", 20, 8.5)
    val student2 = Student(2, "Vu Hong Hanh", 20, 4.5)
    val student3 = Student(3, "Luong Thi Trang", 22, 5.0)
    val student4 = Student(4, "Tran Cong Chien", 19, 9.0)
    val  student5 = Student(5, "Le Huu Chung", 21, 6.5)
    val students = mutableListOf(student1, student2, student3, student4, student5)

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
    println("Danh sach sinh vien:")
    students.forEach { it.displayInfo() }
    println("\nSinh vien co diem tren 9:")
    students.filter { it.score>9 }.forEach({ it.displayInfo() })
    println("\nSinh vien co diem duoi 7:")
    students.filter { it.score < 7 }.forEach { it.displayInfo() }

    // trung binh diem
    val averageScore = students.map { it.score }.average()
    println("\nDiem trung binh cua lop: $averageScore")

    // diem cao nhat va thap nhat
    var maxScore = students.maxByOrNull { it.score }?.score ?: 0.0
    var minScore = students.minByOrNull { it.score }?.score ?: 0.0

    //tong 2 diem thap va cao nhat
    println("Tổng điểm = ${maxScore + minScore}")
    println("Hiệu điểm = ${maxScore - minScore}")
    println("Nhân điểm = ${maxScore * minScore}")
    if (minScore != 0.0) {
        println("Chia điểm = ${maxScore / minScore}")
        println("Chia lấy dư = ${maxScore.toInt() % minScore.toInt()}")
    }
    else{
        println("Chia điểm = Không thể chia cho 0")
        println("Chia lấy dư = Không thể chia cho 0")
    }

    //hien thi so sinh vien 20 tuoi
    println("\nSo sinh vien 20 tuoi: ${students.count { it.age == 20 }}")

    //hien thi so sinh vien khac 20 tuoi
    println("So sinh vien khac 20 tuoi: ${students.count { it.age != 20 }}")

    //hien thi sinh vien hon 20 tuoi va co diem tren 5
    println("\nSinh vien hon 20 tuoi va co diem tren 5:")
    students.filter { it.age > 20 && it.score > 5 }.forEach { it.displayInfo() }

    // set ( tap hop khong trung lap)
    val studentSet = mutableSetOf<Student>()
    studentSet.addAll(students)
    println("So sinh vien trong set: ${studentSet.size}")

    // map ( tap hop key-value)
    val studentMap = mutableMapOf<Int, Student>()
    students.forEach { studentMap[it.id] = it }
    println("So sinh vien trong map: ${studentMap.size}")

    //last, first, reduce
    println("Sinh vien dau tien trong danh sach: ")
    students.first().displayInfo()
    println("Sinh vien cuoi cung trong danh sach: ")
    students.last().displayInfo()
    val totalScore = students.map { it.score }.reduce { acc, score -> acc + score }
    println("Tong diem cua lop: $totalScore")



}