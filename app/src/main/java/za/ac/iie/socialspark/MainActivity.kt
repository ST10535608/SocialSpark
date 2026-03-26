package za.ac.iie.socialspark

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // References are from the UI elements from the layout
        val timeOfDayInput = findViewById<EditText>(R.id.edtTimeOfDay)
        val checkButton = findViewById<Button>(R.id.btnContinue)
        val resetButton = findViewById<Button>(R.id.btnReset)
        val resultText = findViewById<TextView>(R.id.txtDisplay)

        // this listens to when the user clicks the "Get Suggestion" button
        checkButton.setOnClickListener {

            // Get the user's input and convert to lowercase
            val timeOfDay = timeOfDayInput.text.toString().trim().lowercase()
            Log.d("SocialSpark", "User entered: $timeOfDay")

            // This is to check if the input is empty
            if (timeOfDay.isEmpty()){
                resultText.text = "Please enter valid input"
                Log.d("SocialSpark", "Error: Empty input received")
            }
            // to determine the social spark suggestion based on the user's input
            else if (timeOfDay == "morning"){
                resultText.text = "Send a 'Good Morning' message to a family member."
                Log.d("SocialSpark", "Suggestion displayed: Morning")
            }
            else if (timeOfDay == "mid-morning"){
                resultText.text = "Reach out to a colleague with a quick 'Thank you'."
                Log.d("SocialSpark", "Suggestion displayed: Mid-morning")
            }
            else if (timeOfDay == "afternoon"){
                resultText.text = "Share a funny meme or interesting link with a friend."
                Log.d("SocialSpark", "Suggestion displayed: Afternoon")
            }
            else if (timeOfDay == "afternoon snack time"){
                resultText.text = "Send a quick 'thinking of you' message."
                Log.d("SocialSpark", "Suggestion displayed: Afternoon Snack Time")
            }
            else if (timeOfDay == "dinner"){
                resultText.text = "Call a friend or relative for a quick 5-minute catch-up."
                Log.d("SocialSpark", "Suggestion displayed: Dinner")
            }
            else if (timeOfDay == "after dinner/night"){
                resultText.text = "Leave a thoughtful comment on a friend's post."
                Log.d("SocialSpark", "Suggestion displayed: After Dinner/Night")
            }
            // handles any input that doesn't match the expected time of day value
            else {
                resultText.text = "Please enter a valid time of day"
                Log.d("SocialSpark", "Error: Invalid input - $timeOfDay")
            }
        }

        // Listens for when the user clicks the reset button
        resetButton.setOnClickListener {
            // Clears the input field and resets the suggestion text
            timeOfDayInput.text.clear()
            resultText.text = ""
            Log.d("SocialSpark", "Reset button clicked - input cleared")
        }

    }
}