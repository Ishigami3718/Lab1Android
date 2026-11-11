package com.example.lab1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lab1.ViewModels.CatViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CatScreen(modifier: Modifier, catViewModel: CatViewModel = viewModel()){

    val currentCat by catViewModel.CurrentCat.collectAsStateWithLifecycle()
    val currentCatImage by catViewModel.CurrentCatImage.collectAsStateWithLifecycle()
    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ваша порода кота: $currentCat",
        )
        Image(
            painter = painterResource(currentCatImage),
            contentDescription = null,
            modifier = Modifier.size(300.dp)

        )
        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            onClick ={ catViewModel.changeCat()}
        ){
            Text(
                text = "Наступна порода"
            )
        }
    }
}