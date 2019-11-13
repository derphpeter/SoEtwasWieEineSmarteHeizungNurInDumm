class Thermometer(private val sensor : Sensor, private val observer : TemperatureObserver)
{
    fun doWhatAThermometerDoes(n : Int)
    {
        for(i in 0 until n)
        {
            update(sensor.getTemperature())
        }
    }

    private fun update(temp : Float)
    {
        observer.update(temp)
    }
}

fun main()
{
    var thermometer = Thermometer(
        SensorLogger(RoundValues(RandomSensor(0.0, 50.0))),
        TemperatureAlert(37, "Ganz schön heiß")
    )
    thermometer.doWhatAThermometerDoes(10)
    println("---------------------------------------------------------------------------------------------------------")

    thermometer = Thermometer(
        SensorLimits(RandomSensor(-10.0, 10.0), 5.0, 10.0),
        WeatherReport()
    )
    thermometer.doWhatAThermometerDoes(103)
    println("---------------------------------------------------------------------------------------------------------")

    thermometer = Thermometer(
        RandomSensor(0.0, 25.0),
        HeatingSystem()
    )
    thermometer.doWhatAThermometerDoes(10)
    println("---------------------------------------------------------------------------------------------------------")

    thermometer = Thermometer(SensorLogger(UpDownSensor(20.0f)), TemperatureAlert(100, ""))
    thermometer.doWhatAThermometerDoes(100)
    println("---------------------------------------------------------------------------------------------------------")

    thermometer = Thermometer(
        SensorLogger(IgnoreDuplicates(RandomSensor(1.0, 5.0))),
        TemperatureAlert(100, "")
    )
    thermometer.doWhatAThermometerDoes(10)
}
