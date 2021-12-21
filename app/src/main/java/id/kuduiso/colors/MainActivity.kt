package id.kuduiso.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_color)?.setOnClickListener {
            var redChannelText = findViewById<TextInputEditText>(R.id.redChannel)?.text.toString().trim()
            var greenChannelText = findViewById<TextInputEditText>(R.id.greenChannel)?.text.toString().trim()
            var blueChannelText = findViewById<TextInputEditText>(R.id.blueChannel)?.text.toString().trim()
            val tvResultRGB = findViewById<TextView>(R.id.tv_color_result)

            // Validation
            if (redChannelText.isNotEmpty() || greenChannelText.isNotEmpty() || blueChannelText.isNotEmpty()) {
                if (redChannelText.length == 1) redChannelText = redChannelText.plus(redChannelText)
                if (greenChannelText.length == 1) greenChannelText = greenChannelText.plus(greenChannelText)
                if (blueChannelText.length == 1) blueChannelText = blueChannelText.plus(blueChannelText)

                val colorResult = redChannelText.plus(greenChannelText).plus(blueChannelText)

                val colorAsInt = Color.parseColor("#".plus(colorResult))
                tvResultRGB?.setBackgroundColor(colorAsInt)
            } else {
                Toast.makeText(this, "All Values are required", Toast.LENGTH_LONG).show()
            }
        }

    }
}