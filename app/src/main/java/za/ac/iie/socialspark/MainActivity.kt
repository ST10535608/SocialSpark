package za.ac.iie.socialspark

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val timeOfDayInput = findViewById<EditText>(R.id.edtTimeOfDay)
        val checkButton = findViewById<Button>(R.id.btnContinue)
        val resetButton = findViewById<Button>(R.id.btnReset)
        val resultText = findViewById<TextView>(R.id.txtDisplay)

        checkButton.setOnClickListener {

            // input validation
            val timeOfDay = timeOfDayInput.text.toString().trim().lowercase()

            if (timeOfDay.isEmpty()){
                resultText.text = "Please enter valid input"
            }
            else if (timeOfDay == "morning"){
                resultText.text = "Send a 'Good Morning' message to a family member."
            }
            else if (timeOfDay == "mid-morning"){
                resultText.text = "Reach out to a colleague with a quick 'Thank you'."
            }
            else if (timeOfDay == "afternoon"){
                resultText.text = "Share a funny meme or interesting link with a friend."
            }
            else if (timeOfDay == "afternoon Snack Time"){
                resultText.text = "Send a quick 'thinking of you' message."
            }
            else if (timeOfDay == "dinner"){
                resultText.text = "Call a friend or realtive for a quick 5-minute catch-up."
            }
            else if (timeOfDay == "after Dinner/Night"){
                resultText.text = "Leave a thoughtful comment on a friend's post."
            }
            else {
                resultText.text = "Please enter a valid time of day"
            }
        }

        resetButton.setOnClickListener {
            timeOfDayInput.text.clear()
            resultText.text = ""
        }

    }
}