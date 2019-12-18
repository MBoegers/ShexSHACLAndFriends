package example.ocl.expressions

val ifExpressionRegEx = Regex("if(\\X*?)then(\\X*?)else(\\X*?)endif", RegexOption.IGNORE_CASE)
val comparisonRegEx = Regex(
    "\\(?([a-z0-9$._\\->()]+)\\s+(<|>|<>|=|<=|>=|or|and|not)\\s+([a-z0-9$._\\->()]+)\\)?",
    RegexOption.IGNORE_CASE
)
val logicalRegEx =
    Regex("\\(?([()\\sa-z0-9$.\\-<>=]+)\\s(or|and|not)\\s+([\\sa-z0-9$.\\->()<=]+)\\)?", RegexOption.IGNORE_CASE)

fun parseToExpresion(exp: String): OCLExpression = when {
    ifExpressionRegEx.matches(exp) -> IfExpression(exp = exp)
    comparisonRegEx.matches(exp) -> ComparisonExpression(exp = exp)
    logicalRegEx.matches(exp) -> LogicalExpression(exp = exp)
    else -> throw IllegalArgumentException("Could not parse expression: ".plus(exp))
}