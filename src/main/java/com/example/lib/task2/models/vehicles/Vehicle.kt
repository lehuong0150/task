abstract class Vehicle(
    var name: String? = null,
    var speed: Int? = null
) {
    abstract fun start()
}