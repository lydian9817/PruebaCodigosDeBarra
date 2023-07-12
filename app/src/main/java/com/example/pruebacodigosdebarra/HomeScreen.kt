package com.example.pruebacodigosdebarra

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    viewModel: ViewModel = viewModel()
) {
    val scanner = viewModel.crearScanner(LocalContext.current)
    val state = viewModel.state

    Log.i("barcodeValie", state.value.barcodeRawValue!!)
    Scaffold {
        Column(modifier = Modifier
            .padding(top = it.calculateTopPadding())
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = state.value.barcodeRawValue!!)

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    viewModel.comenzarScan(scanner)
                }
            ) {
                Text(text = "Comenzar a scanear")
            }
        }
    }
}