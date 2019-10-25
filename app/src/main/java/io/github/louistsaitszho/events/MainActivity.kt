package io.github.louistsaitszho.events

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}

data class Event(
        val title: String,
        val link: String,
        val `when`: When,
        val where: Where,
        val platform: Platform
)

data class When(val startsAt: LocalDateTime, val endsAt: LocalDateTime) {
    fun isFullDay(): Boolean = false // TODO fix me
}

data class Where(
        val coordinate: Coordinate,
        val name: String,
        val description: String?
)

typealias Coordinate = Pair<Double, Double>

enum class Platform {
    MEETUP, EVENTBRITE, CHAPTER, FACEBOOK
}

@Composable
fun EventRow(event: Event) {
    Column {
        Text(text = event.title)
        Text(text = event.`when`.toString())
    }
}

@Preview
@Composable
fun EventRowPreview() {
    EventRow(event = Event(
            "React Day Berlin",
            "https://www.eventbrite.com/e/react-day-berlin-2019-tickets-61442110005?aff=ebdshpfprimarybucket",
            When(
                    LocalDateTime.of(2019, 12, 6, 8, 30),
                    LocalDateTime.of(2019, 12, 6, 22, 0)
            ),
            Where(0.0 to 0.0, "Kosmos (conf) and SRH Hochschule (workshops)", "IDK"),
            Platform.EVENTBRITE
    ))
}