package com.example.pruebacodigosdebarra
import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

class ViewModel : ViewModel(){
    private val _state = mutableStateOf(HomeState())

    val state: State<HomeState> = _state

    fun crearScanner(context: Context): GmsBarcodeScanner {
        return GmsBarcodeScanning.getClient(context)
    }

    fun comenzarScan(scanner: GmsBarcodeScanner){
        scanner.startScan()
            .addOnSuccessListener { barcode ->
                Log.e("Barcode", "code: "+ barcode.displayValue)
                Log.e("Barcode", "Raw value: "+ barcode.rawValue)
                Log.e("Barcode", "code type: "+ barcode.valueType)
                val nuevo = barcode.rawValue
                Log.e("Barcode", "codigo recibido: $nuevo")
                _state.value = state.value.copy(
                    barcodeRawValue = nuevo
                )
                Log.e("Barcode", "estado: " + _state.value.barcodeRawValue)

            }
            .addOnFailureListener { e ->
                e.printStackTrace()

            }
    }
}