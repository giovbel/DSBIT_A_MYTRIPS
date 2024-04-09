package br.senai.sp.jandira.mytrips.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.ui.theme.Poppins


data class categories (
    val nome: String,
    val imagem : Int
)

val listaCategorias = listOf(
    categories(
        "Mountain",
        R.drawable.montain
    ),
    categories(
        "Snow",
        R.drawable.snow
    ),
    categories(
        "Beach",
        R.drawable.beach
    )
)


var count = 0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(controleDeNavegacao: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0x0FB3ABAB)),

        ) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp),
            shape = RectangleShape
        ){
            Box(modifier = Modifier.height(300.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.paisagem),
                    contentDescription = "Imagem",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Card(
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
                            .offset(x = 300.dp, y = 10.dp),
                        shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pessoa),
                            contentDescription = "perfil",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                    Text(
                        text = "Susanna Hoffs",
                        color = Color.White,
                        modifier =   Modifier
                            .offset(x = 260.dp, y = 20.dp),
                        fontFamily = Poppins
                    )
                }
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding( start = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ){
                    Row (
                        modifier = Modifier
                            .offset(y = 8.dp)
                    ){
                        Icon(
                            modifier = Modifier
                                .size(18.dp),
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "simbolo do mapa",
                            tint = Color.White
                        )
                        Text(
                            text = "You're in Paris",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = Poppins
                        )
                    }

                    Text(
                        text = "My Trips",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins
                    )
                }
            }
        }

        Column {
            Text(
                text = "Categories",
                fontSize = 18.sp,
                color = Color(0xFF565454),
                modifier = Modifier.padding(top = 15.dp, start = 12.dp),
                fontFamily = Poppins
            )

        }

        LazyRow() {
            items(listaCategorias) { categoria ->
                count++

                var color = 0xFFCF06F0
                if (count > 1){
                    color = 0xFFEAABF4
                }
                categoriasCards(categoria.nome, categoria.imagem, color)
            }
        }

        SearchBar(query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            modifier = Modifier.padding(15.dp),
            placeholder = {
                Text(
                    text = "Search your destiny",
                    fontSize = 16.sp,
                    color = Color(0xFFB7B7B7),
                    fontFamily = Poppins
                )
            },
            colors = SearchBarDefaults.colors(
                containerColor = Color.White,
            ),
            trailingIcon = {
                Icon(
                    Icons.Filled.Search, contentDescription = null,
                    tint = Color(0xFFB7B7B7),
                )
            }
        ) {
        }


        Text(
            text = "Past Trips",
            fontSize = 18.sp,
            color = Color(0xFF565454),
            modifier = Modifier.padding(top = 15.dp, start = 12.dp),
            fontFamily = Poppins
        )

        LazyColumn(){
            items(2){
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(start = 15.dp, end = 15.dp, top = 15.dp),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0xFFFFFFFF)),
                    elevation = CardDefaults.cardElevation( defaultElevation = 8.dp)
                ){
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(start = 8.dp, end = 8.dp, top = 5.dp),

                        ){
                        Image(
                            painter = painterResource(id = R.drawable.londres),
                            contentDescription = "londres",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(
                        text = "London, 2019",
                        modifier = Modifier
                            .padding(5.dp),
                        color = Color(0xFFCF06F0),
                        fontFamily = Poppins
                    )
                    Text(
                        text = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",
                        fontSize = 13.sp,
                        lineHeight = 13.sp,
                        modifier = Modifier
                            .padding(start = 8.dp),
                        color = Color(0xFFA09C9C),
                        fontFamily = Poppins
                    )
                    Text(
                        text = "18 Feb - 21 Feb",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .offset(x = 250.dp)
                            .padding(top = 7.dp),
                        color = Color(0xFFCF06F0),
                        fontFamily = Poppins
                    )
                }
            }
        }
    }
}

@Composable
fun categoriasCards(nome: String, imagem: Int, cor: Long) {
    Card(
        modifier = Modifier
            .height(92.dp)
            .width(135.dp)
            .padding(start = 10.dp, top = 12.dp),
        colors = CardDefaults
            .cardColors(containerColor = Color(cor))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painter = painterResource(id = imagem),
                contentDescription = "",
                modifier = Modifier
                    .size(38.dp)

            )
            Text(
                text = nome,
                color = Color.White,
                fontFamily = Poppins
            )
        }
    }
}