package br.com.desafioviacelerometro

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var textViewX: TextView
    lateinit var textViewY: TextView
    lateinit var textViewZ: TextView
    
    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(
            Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

        textViewX = findViewById(R.id.EixoX)
        textViewY = findViewById(R.id.EixoY)
        textViewZ = findViewById(R.id.EixoZ)

    }

    override fun onSensorChanged(event: SensorEvent?) {

        textViewX.setBackgroundColor(Color.RED)

        textViewY.setBackgroundColor(Color.WHITE)
        textViewZ.setBackgroundColor(Color.BLUE)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        textViewX.setBackgroundColor(Color.RED)
        textViewY.setBackgroundColor(Color.WHITE)
        textViewZ.setBackgroundColor(Color.BLUE)
    }

}

