package example.ocl.expressions

import example.ocl.expressions.primitive.StringTypeExpression

open class ComparisonExpression(exp: String) : OCLExpression {
    private val left: OCLExpression
    private val right: OCLExpression
    private val operation: String

    init {
        val parts = comparisonRegEx.find(exp)!!.groupValues

        left = StringTypeExpression(parts[1])
        operation = parts[2]
        right = StringTypeExpression(parts[3])
    }

    override fun toString(): String = " ( ".plus(left).plus(" ").plus(operation).plus(" ").plus(right).plus(" ) ")
}