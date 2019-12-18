package example.oclstartsWith

import example.ocl.expressions.OCLExpression
import example.ocl.expressions.parseToExpresion

/**
 * represents a OCL rule, basically a container which can be used to store a rule
 */
class OCLRule(context: String, inv: String) {
    /** store the rules context, e.q. the class for which the rule should hold */
    private val ruleContext: String = context.removePrefix("context").trim()
    /** Name of the rule, only used to recognise the rule */
    private val ruleName: String = inv.substringBefore(":").removePrefix("inv").trim()
    /** String repentant of the invariant rule */
    private val ruleInvariant: OCLExpression = parseToExpresion(inv.substringAfter(":").trim())

    /** Print the rule for debugging purpose */
    fun print() = print(ruleContext.plus("\t\"").plus(ruleName).plus("\" : ").plus(ruleInvariant).plus("\n"))
}
