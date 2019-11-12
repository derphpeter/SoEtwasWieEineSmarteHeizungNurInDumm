interface TemperatureObserver
{
    fun update(temp : Float)
}

class TemperatureAlert(private val alertTemp : Int, private val message : String) : TemperatureObserver
{
    override fun update(temp : Float)
    {
        if(temp >= alertTemp)
            println(message)
    }
}

class WeatherReport : TemperatureObserver
{
    private val tempList = arrayListOf<Float>()

    override fun update(temp : Float)
    {
        if(tempList.size < 100)
            tempList.add(temp)
        else if(tempList.size == 100)
        {
            for (i in tempList) println(i)
            tempList.clear()
        }
    }
}

class HeatingSystem : TemperatureObserver
{
    private val tempList = arrayListOf<Float>()

    override fun update(temp : Float)
    {
        if(tempList.size < 10)
            tempList.add(temp)
        else if(tempList.size == 10)
        {
            tempList.removeAt(0)
            tempList.add(temp)
        }

        val heatStrat1 = InstantHeatingStrategy()
        if(heatStrat1.needsHeating(tempList))
            println("Heizung ein")
        else
            println("Heizung aus")

        val heatStrat2 = SensibleHeatingStrategy()
        if(heatStrat2.needsHeating(tempList))
            println("Heizung ein")
        else
            println("Heizung aus")

        val heatStrat3 = ReasonableHeatingStrategy()
        if(heatStrat3.needsHeating(tempList))
            println("Heizung ein")
        else
            println("Heizung aus")
    }
}
