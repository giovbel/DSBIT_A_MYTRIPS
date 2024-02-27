package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyTrips()
                }
            }
        }
    }
}

@Composable
fun MyTrips() {
    Column() {
        Card(
            modifier = Modifier
                .width(80.dp)
                .height(50.dp),
            colors = CardDefaults
                .cardColors(containerColor = Color(0xFFCF06F0)),
        ){
        }
        Column() {
            Text(
                text = "Login",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Please sign in to continue."
            )
            OutlinedTextField(
                value = "teste@email.com",
                onValueChange = {},
                label =  {
                    Text(
                        text = "E-mail",
                        color = Color(0xFF000000)
                    )
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        unfocusedContainerColor = Color(0xFFFFFFFF),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                value = "************",
                onValueChange = {},
                label =  {
                    Text(
                        text = "Password",
                        color = Color(0xFF000000),
                    )
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        unfocusedContainerColor = Color(0xFFFFFFFF),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                shape = RoundedCornerShape(12.dp)
            )
        }
    }
}
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        MyTripsTheme {
            MyTrips()
        }
    }
