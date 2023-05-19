package com.example.appaula1

import android.os.Bundle
import android.text.method.MovementMethod
import android.view.translation.Translator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import com.example.appaula1.ui.theme.AppAula1Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.translationMatrix


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LayoutNome(Nome("Jeferson"))


            //Conversation(SampleData.conversationSample)
            //Conversation2(SampleData2.conversationSample2)

        }

    }
    data class Nome(val nome: String)
    @Composable
    fun LayoutNome(msg: Nome) {
        Surface(
                color = Color(0xC2078069),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.size(width = 700.dp, height = 56.dp)
            ) {
                Row(modifier = Modifier.padding(all = 11.dp)) {


                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(R.drawable.jef),
                        contentDescription = "Contact profile picture",
                        modifier = Modifier
                            // Set image size to 40 dp
                            .size(35.dp)
                            // Clip image to be shaped as a circle
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(9.dp))

                    var isExpanded by remember { mutableStateOf(false) }

                    // We toggle the isExpanded variable when we click on this Column
                    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(

                            text = msg.nome,
                            color = MaterialTheme.colors.surface,
                            style = MaterialTheme.typography.h6

                        )


                    }
                }
            }
        }
        data class Message( val jef: String)

        @Composable
        fun MessageCard(msg: Message) {
            Surface(modifier = Modifier.size(width = 20.dp, height = 30.dp)) {


                Row(modifier = Modifier.height(9.dp)) {
                    Spacer(modifier = Modifier.width(1.dp))

                    // We toggle the isExpanded variable when we click on this Column


                    Text(
                        text = msg.jef,

                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line

                        style = MaterialTheme.typography.body2
                    )
                }

            }
        }

    data class Message2( val gus: String)

    @Composable
    fun MessageCard2(msg: Message2) {

    Row() {
        Spacer(modifier = Modifier.width(220.dp))


        // We toggle the isExpanded variable when we click on this Column


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = msg.gus,
            // If the message is expanded, we display all its content
            // otherwise we only display the first line

            style = MaterialTheme.typography.body2
        )
    }

}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { messages ->
            MessageCard(messages)

        }

    }
}
    @Composable
    fun Conversation2(messages2: List<Message2>) {
        LazyColumn {
            items(messages2){ messages2 ->
                MessageCard2(messages2)

            }
        }
    }
}







