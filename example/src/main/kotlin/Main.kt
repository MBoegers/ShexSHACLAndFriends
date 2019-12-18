package example

import example.ocl.readOCL
import java.io.File

fun main() {
    val path = "./src/main/resources/cgmes"
    val file = File(path)
    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    file.list()
        .map { readOCL(path.plus("/").plus(it)) }
        .forEach { print("found ".plus(it.size).plus(" rules")) }
    print("Done!")
}