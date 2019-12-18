package example.ocl

import example.oclstartsWith.OCLRule
import java.io.File
import java.io.InputStream

/**
 * The function is used to read all OCL rules to from the file
 * @param path to the OCL file
 */
fun readOCL(path: String): List<OCLRule> {

    fun isComment(s: String): Boolean = s.startsWith("--")
    fun isPackage(s: String): Boolean = s.startsWith("package") || s.startsWith("endpackage")
    fun isInvariant(s: String): Boolean = s.startsWith("inv")
    fun isContext(s: String): Boolean = s.startsWith("context")

    fun addNotComments(src: Sequence<String>, dest: MutableList<String>) =
        src.filterNot { isComment(it) }
            .filterNot { isPackage(it) }
            .filterNot { it.isBlank() }
            .forEach { dest.add(it) }

    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines { addNotComments(it, lineList) }
    inputStream.close()

    val rules = mutableListOf<OCLRule>()
    var context = ""
    var invRules = ""
    for (line in lineList) {
        try {
            when {
                isContext(line) -> context = line.trim()
                isInvariant(line) -> {
                    if (invRules.isNotEmpty())
                        rules.add(OCLRule(context = context, inv = invRules))
                    invRules = line.trim()
                }
                else -> invRules = invRules.plus(" ").plus(line.trim())
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            error(
                "faile to parse line: \"".plus(line)
                    .plus("\" in context: \"").plus(context).plus("\"")
                    .plus(" with content: \"").plus(invRules).plus("\"\n")
            )
        }
    }

    return rules
}