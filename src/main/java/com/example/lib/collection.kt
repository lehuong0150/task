package com.example.lib_task

fun demoCollection(students: List<Student>) {

    //demo set
    demoSet(students)

    // map ( tap hop key-value)
    demoMap(students)

    //last, first
    demoFirstLast(students)
    //demo reduce
    demoReduce(students)
    //deque
    demoDeque(students)

    //sortedList
    demoSort(students)

    //reversed
    demoReverse(students)

    //partition
    demopartition(students)

    //groupBy
    demoGroupBy(students)

    //flatMap
    demoFlatMap(students)

    //elementAtOrNull
    demoElementAtOrNull(students)
}
fun demoSet(students: List<Student>) {
    val studentSet = mutableSetOf<Student>()
    studentSet.addAll(students)
    println("So sinh vien trong set: ${studentSet.size}")
    studentSet.forEach { it.displayInfo() }
    studentSet.remove(students[0])
    println("So sinh vien trong set sau khi xoa: ${studentSet.size}")
    studentSet.forEach { it.displayInfo() }
}
fun demoMap(students: List<Student>) {
    val studentMap = mutableMapOf<Int, Student>()
    students.forEach { studentMap[it.id] = it }
    println("So sinh vien trong map: ${studentMap.size}")
    studentMap.forEach { (id, student) ->
        println("ID: $id")
        student.displayInfo()
    }
    studentMap.remove(students[0].id)
    println("So sinh vien trong map sau khi xoa: ${studentMap.size}")
    studentMap.forEach { (id, student) ->
        println("ID: $id")
        student.displayInfo()
    }
}
fun demoDeque(students: List<Student>) {
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
    studentDeque.forEach { it.displayInfo() }
}
fun demoFilter(students: List<Student>) {
    println("Sinh vien co diem tren 5:")
    val filteredStudents = students.filter { it.score > 5 }
    filteredStudents.forEach { it.displayInfo() }
}
fun demopartition(students: List<Student>) {
    val (pass, fail) = students.partition { it.score >= 5 }
    println("Danh sach sinh vien dat: ")
    pass.forEach { it.displayInfo() }
    println("Danh sach sinh vien truot: ")
    fail.forEach { it.displayInfo() }
}
fun demoSort(students: List<Student>) {
    val sortedStudents = students.sortedBy { it.score }
    println("Danh sach sinh vien sap xep theo diem tang dan: ")
    sortedStudents.forEach { it.displayInfo() }
    val sortedStudentsDesc = students.sortedByDescending { it.score }
    println("Danh sach sinh vien sap xep theo diem giam dan: ")
    sortedStudentsDesc.forEach { it.displayInfo() }
}
fun demoReduce(students: List<Student>) {
    val totalScore = students.map { it.score }.reduce { acc, score -> acc + score }
    println("Tong diem cua lop: $totalScore")
}
fun demoFirstLast(students: List<Student>) {
    val firstStudent = students.first()
    println("Sinh vien dau tien trong danh sach: ")
    firstStudent.displayInfo()
    val lastStudent = students.last()
    println("Sinh vien cuoi cung trong danh sach: ")
    lastStudent.displayInfo()
}
fun demoReverse(students: List<Student>) {
    val reversedStudents = students.reversed()
    println("Danh sach sinh vien dao nguoc: ")
    reversedStudents.forEach { it.displayInfo() }
}
fun demoGroupBy(students: List<Student>) {
    val groupByAge = students.groupBy { it.age }
    println("Danh sach sinh vien theo tuoi: ")
    groupByAge.forEach { (age, students) ->
        println("Tuoi $age:")
        students.forEach { it.displayInfo() }
    }
}
fun demoFlatMap(students: List<Student>) {
    val flatMapScores = students.flatMap { listOf(it.score) }
    println("Danh sach diem cua sinh vien: $flatMapScores")
}
fun demoElementAtOrNull(students: List<Student>) {
    val elementAtOrNull = students.elementAtOrNull(10)
    if (elementAtOrNull != null) {
        println("Sinh vien o vi tri 10: ")
        elementAtOrNull.displayInfo()
    } else {
        println("Khong co sinh vien o vi tri 10")
    }
}