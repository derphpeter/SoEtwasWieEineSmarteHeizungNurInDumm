import kotlin.math.round

class SensorLogger(private val sensor : Sensor) : Sensor
{
    override fun getTemperature() : Float
    {
        val temp = sensor.getTemperature()
        println(temp)
        return temp
    }
}

class RoundValues(private val sensor : Sensor) : Sensor
{
    override fun getTemperature() : Float = round(sensor.getTemperature())
}

class SensorLimits(private val sensor : Sensor, private val min : Double, private val max : Double) : Sensor
{
    override fun getTemperature() : Float
    {
        var temp : Float

        do
            temp = sensor.getTemperature()
        while(temp !in min..max)

        return temp
    }
}

var value : Float = 0f

class IgnoreDuplicates(private val sensor : Sensor) : Sensor
{
    override fun getTemperature() : Float
    {
        var temp : Float

        do
            temp = sensor.getTemperature()
        while(temp.toInt() == value.toInt())

        value = temp
        return temp
    }
}
