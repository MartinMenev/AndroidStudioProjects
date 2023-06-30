import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


open class SmartDevice(val name: String, val category: String) {
    private var deviceStatus = "online"

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType");
    }
}

open class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun printSmartTvInfo() {
        super.printDeviceInfo()
    }

}


class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    fun printSmartLightInfo() {
        super.printDeviceInfo()
    }
}


open class SmartHome(
    private val smartTvDevice: SmartTvDevice,
    private val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        smartTvDevice.turnOn()
        deviceTurnOnCount++
    }

    private fun turnOffTv() {
        smartTvDevice.turnOff()
        deviceTurnOnCount--
    }

    fun increaseTvVolume() {
        if (deviceTurnOnCount > 0) smartTvDevice.increaseSpeakerVolume()
    }

    fun decreaseTvVolume() {
        if (deviceTurnOnCount > 0) smartTvDevice.decreaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        if (deviceTurnOnCount > 0)  smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious() {
        if (deviceTurnOnCount > 0)  smartTvDevice.previousChannel()
    }

    fun printSmartTvInfo() {
        smartTvDevice.printSmartTvInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printSmartLightInfo()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
        deviceTurnOnCount++
    }

    private fun turnOffLight() {
        smartLightDevice.turnOff()
        deviceTurnOnCount--
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

fun main(args: Array<String>) {

    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.increaseTvVolume()
    smartHome.increaseTvVolume()

    smartHome.changeTvChannelToNext()

    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()

    println()
    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }

}
