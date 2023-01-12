package com.learn.countries.view


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import coil.compose.rememberImagePainter
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.learn.countries.model.Country
import com.learn.countries.viewModel.FirstScreenViewModel

@Composable
fun FirstScreen(
    viewModel: FirstScreenViewModel = hiltViewModel()
    ) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(modifier = Modifier.padding(10.dp)) {
            LazyColumn(contentPadding = PaddingValues(10.dp)) {
                viewModel.countryList.value.let {
                    items(it){ list ->
                        Countries(list)
                    }
                }
            }
        }
        }
}

@Composable
fun Countries(country: Country) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(color = Color.DarkGray)

    ) {
        Row {
            Image(painter = rememberImagePainter(country.imageUrl), contentDescription = null,
                modifier = Modifier
                    .padding(2.dp)
                    .size(60.dp)
                    .align(Alignment.CenterVertically)

            )

        Column(modifier = Modifier
            .align(Alignment.CenterVertically)
            .fillMaxWidth(0.9f)
            .padding(15.dp)

        ) {
                Text(text = country.countryName!!,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(text = country.countryCapital!!,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(5.dp),
                    color = MaterialTheme.colors.primaryVariant,

                )
                Text(text = country.countryRegion!!,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,

                )
                Text(text = country.countryLanguage!!,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,

                )
                Text(text = country.countryCurrency!!,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,)
            }
        Icon(
            imageVector = Icons.Filled.ArrowLeft
            , contentDescription = "",
            modifier = Modifier
                .padding(1.dp)
                .align(Alignment.CenterVertically)
        )
        }
    }


}

