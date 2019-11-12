interface HeatingStrategy
{
    fun needsHeating(last10measures : List<Float>) : Boolean
}

class InstantHeatingStrategy : HeatingStrategy
{
    override fun needsHeating(last10measures : List<Float>) : Boolean = last10measures.last() < 19
}

class SensibleHeatingStrategy : HeatingStrategy
{
    override fun needsHeating(last10measures : List<Float>) : Boolean = last10measures.any { it < 20 }
}

class ReasonableHeatingStrategy : HeatingStrategy
{
    override fun needsHeating(last10measures : List<Float>) : Boolean
    {
        var tmp = 0
        for(i in last10measures)
            if(i < 15)
                tmp++
        return tmp >= 5
    }
}
