package com.example.pruebacodigosdebarra

import android.content.Context
import android.util.Log
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

class ScannerRepo {
    fun crearScanner(context: Context): GmsBarcodeScanner {
        return GmsBarcodeScanning.getClient(context)
    }
    fun comenzarScan(scanner: GmsBarcodeScanner): String?{
        var resultado: String? = ""
        scanner.startScan()
            .addOnSuccessListener { barcode ->
                Log.e("Barcode", "code: "+ barcode.displayValue)
                Log.e("Barcode", "Raw value: "+ barcode.rawValue)
                Log.e("Barcode", "code type: "+ barcode.valueType)
                resultado = barcode.rawValue
            }
            .addOnCanceledListener {
                resultado = "Scaneo cancelado"
            }
            .addOnFailureListener { e ->
                resultado = e.printStackTrace().toString()

            }
        return resultado
    }
}