package example.ocl.expressions

import example.ocl.expressions.primitive.StringTypeExpression

class LogicalExpression(exp: String) : OCLExpression {
    private val left: OCLExpression
    private val operation: String
    private val right: OCLExpression

    init {
        val parts = comparisonRegEx.find(exp)!!.groupValues

        left = StringTypeExpression(parts[1])
        operation = parts[2]
        right = StringTypeExpression(parts[3])
    }

    override fun toString(): String = "LogicalExp ( ".plus(left).plus(operation).plus(right).plus(" ) ")
}