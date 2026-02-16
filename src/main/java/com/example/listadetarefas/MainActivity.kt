package com.example.listadetarefas

import android.content.Intent
import android.media.AudioDeviceInfo
import android.os.Bundle
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerificar = findViewById<Button>(R.id.btnVerificarAudio)
        val listaResultados = findViewById<ListView>(R.id.listaResultados)
        val resultados = ArrayList<String>()
        val adapter = ArrayAdapter(this, R.layout.item_lista, resultados)
        listaResultados.adapter = adapter

        btnVerificar.setOnClickListener {
            resultados.clear()
            val audioHelper = AudioHelper(this)

            // 1. Verifica Alto-falante (Speaker)
            val temSpeaker = audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)
            if (temSpeaker) {
                resultados.add("Alto-falante: CONECTADO")
            } else {
                resultados.add("Alto-falante: NÃO DETECTADO")
            }

            // 2. Verifica Bluetooth
            val temBluetooth = audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP)
            if (temBluetooth) {
                resultados.add("Bluetooth: CONECTADO")
            } else {
                resultados.add("Bluetooth: NÃO DETECTADO")
                abrirConfiguracoesBluetooth() // Abre configurações se não tiver bluetooth
            }

            adapter.notifyDataSetChanged()
        }
    }

    // Função pedida no PDF para abrir configurações de Bluetooth
    private fun abrirConfiguracoesBluetooth() {
        Toast.makeText(this, "Abrindo configurações...", Toast.LENGTH_SHORT).show()
        val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            putExtra("EXTRA_CONNECTION_ONLY", true)
            putExtra("EXTRA_CLOSE_ON_CONNECT", true)
            putExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 1)
        }
        try {
            startActivity(intent)
        } catch (e: Exception) {
            // Emulador às vezes não tem o app de settings completo, isso evita crash
            resultados.add("Erro ao abrir ajustes (Emulador?)")
        }
    }

    // Variável auxiliar para acesso à lista dentro do catch, se necessário
    private val resultados = ArrayList<String>()
}