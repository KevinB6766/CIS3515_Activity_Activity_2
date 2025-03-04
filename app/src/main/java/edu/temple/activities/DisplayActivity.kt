package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text

const val SIZE_KEY = "TEXT_SIZE_KEY"
class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    val launcher = registerForActivityResult(ActivityResultContracts()) {
        it.data?.run{
            textView.textSize =getIntExtra(TEXT_SIZE_KEY, 22).toFloat()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)


        textSizeSelectorButton.setOnClickListener() {
            startActivity(
                Intent(this, TextSizeActivity::class.java)
            )
            launcher.launch(Intent(this, TextSizeActivity::class.java))
        }
    }
}


