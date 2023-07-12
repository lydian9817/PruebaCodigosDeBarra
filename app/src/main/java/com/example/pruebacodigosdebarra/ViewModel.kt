package com.example.pruebacodigosdebarra
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner

class ViewModel : ViewModel(){
    private val scannerRepo = ScannerRepo()
    private val _state = mutableStateOf(HomeState())

    val state: State<HomeState> = _state

    fun crearScanner(context: Context): GmsBarcodeScanner{
        return scannerRepo.crearScanner(context)
    }

    fun comenzarScan(scanner: GmsBarcodeScanner){
        val barcodeRawValue = scannerRepo.comenzarScan(scanner)

        _state.value = state.value.copy(
            barcodeRawValue = barcodeRawValue
        )
    }
}