package com.example.pruebacodigosdebarra

import android.content.Context
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