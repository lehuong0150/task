package com.example.lib_task

fun demoCollection(students: List<Student>) {

    // trung binh diem
    val averageScore = students.map { it.score }.average()
    println("\nDiem trung binh cua lop: $averageScore")

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
    // tinh tong diem cua lop
    val totalScore = students.map { it.score }.reduce { acc, score -> acc + score }
    println("Tong diem cua lop: $totalScore")

    //deque
    val studentDeque = ArrayDeque<Student>()
    studentDeque.addAll(students)
    println("So sinh vien trong deque: ${studentDeque.size}")
    println("Sinh vien o dau deque: ")
    studentDeque.first().displayInfo()
    println("Sinh vien o cuoi deque: ")
    studentDeque.last().displayInfo()
    studentDeque.removeFirst()
    println("So sinh vien trong deque sau khi xoa: ${studentDeque.size}")
    studentDeque.removeLast()
    println("So sinh vien trong deque sau khi xoa: ${studentDeque.size}")

    //set
    val studentHashSet = hashSetOf<Student>()
    studentHashSet.addAll(students)
    println("So sinh vien trong hash set: ${studentHashSet.size}")
    studentHashSet.forEach { it.displayInfo() }
    studentHashSet.remove(students[0])
    println("So sinh vien trong hash set sau khi xoa: ${studentHashSet.size}")
    studentHashSet.forEach { it.displayInfo() }


    //sortedList
    val studentSortedList = students.sortedBy { it.score }
    println("Danh sach sinh vien sap xep theo diem tang dan: ")
    studentSortedList.forEach { it.displayInfo() }
    val studentSortedListDesc = students.sortedByDescending { it.score }
    println("Danh sach sinh vien sap xep theo diem giam dan: ")
    studentSortedListDesc.forEach { it.displayInfo() }

    //reversed
    val studentReversedList = students.reversed()
    println("Danh sach sinh vien dao nguoc: ")
    studentReversedList.forEach { it.displayInfo() }

    //partition
    val (pass, fail) = students.partition { it.score >= 5 }
    println("Danh sach sinh vien dat: ")
    pass.forEach { it.displayInfo() }
    println("Danh sach sinh vien truot: ")
    fail.forEach { it.displayInfo() }

    //groupBy
    val groupByAge = students.groupBy { it.age }
    println("Danh sach sinh vien theo tuoi: ")
    groupByAge.forEach { (age, students) ->
        println("Tuoi $age:")
        students.forEach { it.displayInfo() }
    }

    //flatMap
    val flatMapScores = students.flatMap { listOf(it.score) }
    println("Danh sach diem cua sinh vien: $flatMapScores")

    //elementAtOrNull
    val elementAtOrNull = students.elementAtOrNull(10)
    if (elementAtOrNull != null) {
        println("Sinh vien o vi tri 10: ")
        elementAtOrNull.displayInfo()
    } else {
        println("Khong co sinh vien o vi tri 10")
    }
}