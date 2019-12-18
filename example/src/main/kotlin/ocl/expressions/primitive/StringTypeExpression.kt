package example.ocl.expressions.primitive

import example.ocl.expressions.OCLExpression

class StringTypeExpression(private val value: String) : OCLExpression {
    override fun toString(): String = "StringEpx ( ".plus(value).plus(" ) ")
}