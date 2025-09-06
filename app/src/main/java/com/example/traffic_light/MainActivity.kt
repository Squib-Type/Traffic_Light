package com.example.traffic_light

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.traffic_light.databinding.ActivityMainBinding

private const val isStop = 0
private const val isGo = 1
private const val isWait = 2

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var currentState = isStop

        binding.trafficLightButton.setOnClickListener {
            if(currentState == isStop) {
                binding.trafficLightButton.text = "GO"
                // binding.trafficLightButton.backgroundTint(R.color.green)
                binding.redlight.visibility = View.INVISIBLE
                binding.yellowlight.visibility = View.INVISIBLE
                binding.greenlight.visibility = View.VISIBLE
                currentState = isGo


            } else if(currentState == isGo) {
                binding.trafficLightButton.text = "WAIT"
                // binding.trafficLightButton.backgroundTint(R.color.yellow)
                binding.redlight.visibility = View.INVISIBLE
                binding.yellowlight.visibility = View.VISIBLE
                binding.greenlight.visibility = View.INVISIBLE
                currentState = isWait
            } else {
                binding.trafficLightButton.text = "STOP"
                // binding.trafficLightButton.backgroundTint(R.color.red)
                binding.redlight.visibility = View.VISIBLE
                binding.yellowlight.visibility = View.INVISIBLE
                binding.greenlight.visibility = View.INVISIBLE
                currentState = isStop
            }
        }
    }
}
