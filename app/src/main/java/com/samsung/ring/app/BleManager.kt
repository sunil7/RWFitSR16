package com.samsung.ring.app

import android.annotation.SuppressLint
import android.bluetooth.*
import android.content.Context
import android.util.Log
import java.util.UUID

@SuppressLint("MissingPermission")
object BleManager {
    private const val TAG = "SamsungRing_BLE"

    private val SERVICE_UUID = UUID.fromString("0000a00a-0000-1000-8000-00805f9b34fb")
    private val WRITE_UUID   = UUID.fromString("0000b002-0000-1000-8000-00805f9b34fb")
    private val NOTIFY_UUID  = UUID.fromString("0000b003-0000-1000-8000-00805f9b34fb")
    private val CCCD_UUID    = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")

    private var bluetoothGatt: BluetoothGatt? = null
    private var writeCharacteristic: BluetoothGattCharacteristic? = null

    fun connect(context: Context, device: BluetoothDevice, onStatus: (String) -> Unit) {
        onStatus("Connecting to ${device.address}...")
        bluetoothGatt = device.connectGatt(context, false, object : BluetoothGattCallback() {
            override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
                if (newState == BluetoothProfile.STATE_CONNECTED) {
                    onStatus("Connected! Discovering services...")
                    gatt.requestMtu(239)
                    gatt.discoverServices()
                } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                    onStatus("Disconnected.")
                    bluetoothGatt = null
                }
            }

            override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
                if (status == BluetoothGatt.GATT_SUCCESS) {
                    val service = gatt.getService(SERVICE_UUID)
                    if (service != null) {
                        writeCharacteristic = service.getCharacteristic(WRITE_UUID)
                        val notifyCharacteristic = service.getCharacteristic(NOTIFY_UUID)

                        gatt.setCharacteristicNotification(notifyCharacteristic, true)
                        notifyCharacteristic.descriptors.forEach { descriptor ->
                            if (descriptor.uuid == CCCD_UUID) {
                                descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                                gatt.writeDescriptor(descriptor)
                            }
                        }
                        onStatus("Samsung Ring Initialized Successfully!")
                    } else {
                        onStatus("Error: Ring Service UUID not found.")
                    }
                } else {
                    onStatus("Service discovery failed: $status")
                }
            }

            override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
                if (characteristic.uuid == NOTIFY_UUID) {
                    val data = characteristic.value
                    if (data != null && data.isNotEmpty()) {
                        Log.d(TAG, "Notification: ${data.joinToString(", ") { "%02X".format(it) }}")
                    }
                }
            }
        }, BluetoothDevice.TRANSPORT_LE)
    }

    fun sendCommand(cmdId: Byte, payload: ByteArray) {
        val gatt = bluetoothGatt
        val characteristic = writeCharacteristic
        if (gatt == null || characteristic == null) {
            Log.e(TAG, "BLE not connected.")
            return
        }

        val packet = ByteArray(8 + payload.size)
        packet[0] = 0x7E.toByte()
        packet[1] = 0x01.toByte()
        packet[2] = cmdId
        packet[3] = 0x00.toByte()
        packet[4] = payload.size.toByte()
        packet[5] = 0x01.toByte()
        packet[6] = 0x00.toByte()
        packet[7] = payload.fold(0) { acc, b -> acc + b }.toByte()
        System.arraycopy(payload, 0, packet, 8, payload.size)

        characteristic.value = packet
        gatt.writeCharacteristic(characteristic)
    }

    fun disconnect() {
        bluetoothGatt?.disconnect()
        bluetoothGatt?.close()
        bluetoothGatt = null
    }
}
