package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme
import br.senai.sp.jandira.mytrips.ui.theme.Poppins

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
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun MyTrips() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .offset(x = 250.dp)
                .offset(y = -8.dp)
                .height(50.dp),
            colors = CardDefaults
                .cardColors(containerColor = Color(0xFFCF06F0)),
        ) {
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, top = 100.dp),
        ) {
            Text(
                modifier = Modifier
                    .height(80.dp),
                text = "Login",
                fontSize = 55.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                color = Color(0xFFCF06F0),

            )
            Text(
                text = "Please sign in to continue.",
                color = Color(0xFFA09C9C),
                fontFamily = Poppins
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 90.dp, bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 18.dp),
                value = "teste@email.com",
                onValueChange = {},
                label = {
                    Text(
                        text = "E-mail",
                        color = Color(0xFF000000),
                        fontFamily = Poppins
                    )
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        unfocusedContainerColor = Color(0xFFFFFFFF),
                        focusedBorderColor = Color(0xFFCF06F0),
                        unfocusedLeadingIconColor = Color(0xFFCF06F0)
                    ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = "Email",
                        modifier = Modifier.size(30.dp),
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp),
                value = "************",
                onValueChange = {},
                label = {
                    Text(
                        text = "Password",
                        color = Color(0xFF000000),
                        fontFamily = Poppins
                    )

                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        unfocusedContainerColor = Color(0xFFFFFFFF),
                        focusedBorderColor = Color(0xFFCF06F0),
                        unfocusedLeadingIconColor = Color(0xFFCF06F0)
                    ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Lock,
                        contentDescription = "lock",
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(130.dp)
                .height(50.dp)
                .offset(240.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFCF06F0)
            ),
            shape = RoundedCornerShape(10.dp)

        ) {
            Text(
                text = "SIGN IN",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )
            Icon(
                Icons.Filled.ArrowForward,
                contentDescription = "Seta",
            )
        }

        Row(
            modifier = Modifier
                .offset(130.dp)
                .padding(top = 12.dp)
        ) {
            Text(
                text = "Don’t have an account?",
                fontSize = 14.sp,
                color = Color(0xFFA09C9C),
                fontFamily = Poppins
            )
            Text(
                text = " Sign up",
                fontSize = 14.sp,
                color = Color(0xFFCF06F0),
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(70.dp)
                    .offset(y = 120.dp)
                    .offset(x = -40.dp),
                colors = CardDefaults
                    .cardColors(containerColor = Color(0xFFCF06F0))
            ){

            }
        }
    }
}

@Composable fun SignUp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .offset(x = 250.dp)
                .offset(y = -8.dp)
                .height(50.dp),
            colors = CardDefaults
                .cardColors(containerColor = Color(0xFFCF06F0)),

        ) {
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Sign up",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                color = Color(0xFFCF06F0),
            )
            Text(
                text = "Create a new account",
                fontFamily = Poppins,
                color = Color(0xFFA09C9C)
            )
        }
        Card (
            modifier = Modifier
                .height(30.dp)
                .width(30.dp),
            colors = CardDefaults
                .cardColors(containerColor = Color(0xFFF6F6F6))
        ){

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    MyTripsTheme {
        SignUp()
    }
}

