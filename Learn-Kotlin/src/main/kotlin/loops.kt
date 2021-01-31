fun forLoop1() {
    print("Forwards : ")
    for (i in 1..10) { // boundary inclusive
        print("$i ")
    }
    println()
}

fun forLoop2() {
    print("Backwards : ")
    for (i in 10 downTo 1) { // boundary inclusive
        print("$i ")
    }
    println()
}

fun main() {
    forLoop1()
    forLoop2()
}