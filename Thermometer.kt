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

    thermometer = Thermometer(
        SensorLogger(SensorLimits(RandomSensor(-10.0, 10.0), 5.0, 10.0)),
        WeatherReport()
    )
    thermometer.doWhatAThermometerDoes(103)

    thermometer = Thermometer(
        SensorLogger(RandomSensor(0.0, 25.0)),
        HeatingSystem()
    )
    thermometer.doWhatAThermometerDoes(10)

    thermometer = Thermometer(SensorLogger(UpDownSensor(20.0f)), TemperatureAlert(100, ""))
    thermometer.doWhatAThermometerDoes(100)
}
