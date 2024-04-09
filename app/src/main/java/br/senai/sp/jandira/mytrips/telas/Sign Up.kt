package br.senai.sp.jandira.mytrips.telas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.ui.theme.Poppins

@Composable
fun SignUp(controleDeNavegacao: NavHostController) {

    var usuarioState = remember {
        mutableStateOf("")
    }

    var phoneState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var  isErrorState = remember {
        mutableStateOf(false)
    }

    var overState = remember {
        mutableStateOf(false)
    }

    var  mensagemErrorState = remember {
        mutableStateOf("")
    }

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


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Card(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults
                    .cardColors(containerColor = Color(0xFFF6F6F6)),
                border = BorderStroke(
                    2.dp,
                    Brush.horizontalGradient(listOf(Color(0xFFCF06F0), Color.White))
                )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "perfil foto",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(top = 16.dp),
                    alignment = Alignment.Center
                )
            }
        }
        Image(
            modifier = Modifier
                .size(30.dp)
                .offset(x = 220.dp, y = -25.dp),
            painter = painterResource(id = R.drawable.camera),
            contentDescription = "câmera"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 18.dp),
                value = usuarioState.value,
                onValueChange = {
                    usuarioState.value = it
                },
                isError = isErrorState.value,
                label = {
                    Text(
                        text = "Username",
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
                        Icons.Filled.Person,
                        contentDescription = "icone pessoa",
                        modifier = Modifier.size(30.dp),
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 18.dp),
                value = phoneState.value,
                onValueChange = {
                    phoneState.value = it
                },
                isError = isErrorState.value,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = {
                    Text(
                        text = "Phone",
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
                    Image(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "telefone",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 18.dp),
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                isError = isErrorState.value,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
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
                        contentDescription = "icone email",
                        modifier = Modifier.size(30.dp),
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 18.dp),
                value = senhaState.value,
                onValueChange = {
                    senhaState.value = it
                },
                isError = isErrorState.value,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
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
                        contentDescription = "icone senha",
                        modifier = Modifier.size(30.dp),
                    )
                }
            )
            Text(
                text = mensagemErrorState.value,
                color = Color.Red
            )
        }

        Row (
            modifier = Modifier
                .padding(start = 25.dp),
        ) {
            Card(
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp),
                shape = RectangleShape,
                colors = CardDefaults
                    .cardColors(containerColor = Color(0xFF)),
                border = BorderStroke(1.dp, color = Color(0xFFCF06F0))
            )
            {
                Checkbox(
                    checked = overState.value,
                    onCheckedChange = {
                        overState.value = it
                    }
                )
            }
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = "Over 18?"
            )
        }
        Button(
            onClick = {
                if (usuarioState.value == "" || senhaState.value == "" || phoneState.value == "" || emailState.value == ""){
                    isErrorState.value = true
                    mensagemErrorState.value = "Preencha todos os campos"

                } else {
                    controleDeNavegacao.navigate("login")
                } },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 12.dp, end = 12.dp, top = 15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFCF06F0)
            ),
            shape = RoundedCornerShape(10.dp)

        ) {
            Text(
                text = "CREATE ACCOUNT",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )
        }

        Row(
            modifier = Modifier
                .offset(130.dp)
                .padding(top = 12.dp)
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 14.sp,
                color = Color(0xFFA09C9C),
                fontFamily = Poppins
            )
            Text(
                modifier = Modifier.clickable { controleDeNavegacao.navigate("login") },
                text = " Sign in",
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
                    .offset(y = 25.dp)
                    .offset(x = -40.dp),
                colors = CardDefaults
                    .cardColors(containerColor = Color(0xFFCF06F0))
            ){

            }
        }
    }
}