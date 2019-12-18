package example.ocl.expressions

class IfExpression(exp: String) : OCLExpression {
    private val condition: OCLExpression
    private val thenExpression: OCLExpression
    private val elseExpression: OCLExpression

    init {
        val parts = ifExpressionRegEx.find(exp)!!.groupValues
        condition = parseToExpresion(parts[1])
        thenExpression = parseToExpresion(parts[2])
        elseExpression = parseToExpresion(parts[3])
    }

    override fun toString(): String =
        "IFExpr ( ".plus(condition).plus(" ? ").plus(thenExpression).plus(" : ").plus(elseExpression).plus(" ) ")
}