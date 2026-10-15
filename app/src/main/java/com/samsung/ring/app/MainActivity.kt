package com.samsung.ring.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createUiLayout())
        checkPermissions()
    }

    private fun createUiLayout(): android.view.View {
        val layout = android.widget.LinearLayout(this).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            setPadding(48, 48, 48, 48)
        }

        statusText = TextView(this).apply {
            text = "Status: Samsung Ring Initialized"
            textSize = 16f
            setPadding(0, 0, 0, 32)
        }
        layout.addView(statusText)

        val syncButton = Button(this).apply {
            text = "Send Status Command"
            setOnClickListener {
                BleManager.sendCommand(0x01, byteArrayOf(0x00))
                statusText.text = "Status: Query packet sent."
            }
        }
        layout.addView(syncButton)

        return layout
    }

    private fun checkPermissions() {
        val perms = arrayOf(
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        if (perms.any { ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED }) {
            ActivityCompat.requestPermissions(this, perms, 101)
        }
    }
}
