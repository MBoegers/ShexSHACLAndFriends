package example.ocl.expressions

/**
 * Represents a OCL expression
 */
interface OCLExpression {
    fun print() = print(toString())
}