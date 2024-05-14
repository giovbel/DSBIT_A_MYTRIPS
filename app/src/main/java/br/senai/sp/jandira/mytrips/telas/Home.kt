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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repository.Categoria
import br.senai.sp.jandira.mytrips.repository.TripsRepository
import br.senai.sp.jandira.mytrips.repository.UserRepository
import br.senai.sp.jandira.mytrips.ui.theme.Poppins
import br.senai.sp.jandira.mytrips.ui.theme.simplificarData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(controleDeNavegacao: NavHostController) {

    val cr = UserRepository(LocalContext.current)

    val categorias = Categoria()
        .listarTodasAsCategorias(LocalContext.current)

    val viagens = TripsRepository()
        .listarTodasAsViagens(LocalContext.current)

    var searchState = remember {
        mutableStateOf("")
    }


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
            items(categorias){
                Card(
                    modifier = Modifier
                        .height(92.dp)
                        .width(135.dp)
                        .padding(start = 10.dp, top = 12.dp),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0xFFCF06F0))
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
                            painter = it.imagem!!,
                            contentDescription = "",
                            modifier = Modifier
                                .size(38.dp)

                        )
                        Text(
                            text = it.nome,
                            color = Color.White,
                            fontFamily = Poppins
                        )
                    }

                }
            }
        }

        SearchBar(query = searchState.value,
            onQueryChange = {
                searchState.value = it
                            },
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
            items(viagens){
                if (it.destino.uppercase() == searchState.value.uppercase() || searchState.value == "") {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(start = 15.dp, end = 15.dp, top = 15.dp),
                        colors = CardDefaults
                            .cardColors(containerColor = Color(0xFFFFFFFF)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .padding(start = 8.dp, end = 8.dp, top = 5.dp),

                            ) {
                            Image(
                                painter = it.imagem!!,
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Text(
                            text = "${it.destino}, ${it.dataChegada.year}",
                            modifier = Modifier
                                .padding(5.dp),
                            color = Color(0xFFCF06F0),
                            fontFamily = Poppins
                        )
                        Text(
                            text = it.descricao,
                            fontSize = 13.sp,
                            lineHeight = 13.sp,
                            modifier = Modifier
                                .padding(start = 8.dp),
                            color = Color(0xFFA09C9C),
                            fontFamily = Poppins
                        )
                        Text(
                            text = "${simplificarData(it.dataChegada)}, ${simplificarData(it.dataPartida)}",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .offset(x = 220.dp)
                                .padding(top = 7.dp),
                            color = Color(0xFFCF06F0),
                            fontFamily = Poppins
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun categoriasCards(nome: String, imagem: Int, cor: Long) {

}