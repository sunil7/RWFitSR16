package l6;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.qd;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public final class m extends BluetoothGattCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f15798a;

    public m(o oVar) {
        this.f15798a = oVar;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothDevice device;
        if (bluetoothGatt != null) {
            o oVar = this.f15798a;
            if (!qd.a(oVar.f15808a) || (device = bluetoothGatt.getDevice()) == null || bluetoothGattCharacteristic == null) {
                return;
            }
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            byte[] value = bluetoothGattCharacteristic.getValue();
            BluetoothGattService service = bluetoothGattCharacteristic.getService();
            UUID uuid2 = service != null ? service.getUuid() : null;
            o oVar2 = o.f15804o;
            Locale.getDefault();
            ee.c.b(2, "o", "onCharacteristicChanged : deice : " + ee.a.e(oVar.f15808a, device) + ", serviceUuid = " + uuid2 + ", characteristicUuid = " + uuid + ", \ndata : [" + ee.b.c(value) + "]");
            oVar.f15815i.d(device, uuid2, uuid, value);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        UUID uuid;
        byte[] bArr;
        UUID uuid2;
        if (bluetoothGatt == null || bluetoothGatt.getDevice() == null || bluetoothGattCharacteristic == null) {
            return;
        }
        o oVar = this.f15798a;
        if (qd.a(oVar.f15808a)) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            UUID uuid3 = bluetoothGattCharacteristic.getUuid();
            BluetoothGattService service = bluetoothGattCharacteristic.getService();
            UUID uuid4 = service != null ? service.getUuid() : null;
            byte[] value = bluetoothGattCharacteristic.getValue();
            o oVar2 = o.f15804o;
            ee.c.b(2, "o", String.format(Locale.getDefault(), "onCharacteristicWrite : device : %s, status = %d", ee.a.e(oVar.f15808a, device), Integer.valueOf(i3)));
            n6.b d5 = oVar.d(bluetoothGatt.getDevice());
            if (d5 != null) {
                bArr = value;
                uuid2 = uuid4;
                uuid = uuid3;
                p pVar = new p(bluetoothGatt, uuid2, uuid, bArr, null);
                pVar.e = i3;
                if (d5.e != null && d5.f16383b.equals(bluetoothGatt)) {
                    d5.e.c(pVar);
                }
            } else {
                uuid = uuid3;
                bArr = value;
                uuid2 = uuid4;
            }
            oVar.f15815i.g(device, uuid2, uuid, bArr, i3);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i3, int i10) {
        BluetoothDevice device;
        if (bluetoothGatt == null || !qd.a(this.f15798a.f15808a) || (device = bluetoothGatt.getDevice()) == null) {
            return;
        }
        o oVar = o.f15804o;
        ee.c.b(3, "o", String.format(Locale.getDefault(), "onConnectionStateChange : device : %s, status = %d, newState = %d.", ee.a.e(this.f15798a.f15808a, device), Integer.valueOf(i3), Integer.valueOf(i10)));
        if (i10 == 0 || i10 == 3 || i10 == 2) {
            Handler handler = this.f15798a.f15819m;
            if (handler.hasMessages(4113)) {
                handler.removeMessages(4113);
            }
            this.f15798a.e = null;
            if (i10 == 2) {
                this.f15798a.f15817k = 0;
                boolean discoverServices = bluetoothGatt.discoverServices();
                ee.c.b(2, "o", "onConnectionStateChange >> discoverServices : " + discoverServices);
                o oVar2 = this.f15798a;
                String address = device.getAddress();
                oVar2.getClass();
                if (BluetoothAdapter.checkBluetoothAddress(address)) {
                    n6.b bVar = new n6.b(oVar2.f15808a, bluetoothGatt);
                    bVar.f16385d = System.currentTimeMillis();
                    oVar2.f15813g.put(address, bVar);
                    if (oVar2.f15812f == null) {
                        oVar2.f15812f = bluetoothGatt.getDevice();
                    }
                    ee.c.b(3, "o", "putConnectedGattInMap >>>>>>>>>>>>> start");
                    Iterator it = oVar2.f15813g.keySet().iterator();
                    while (it.hasNext()) {
                        ee.c.b(2, "o", "putConnectedGattInMap >>>>>>>>>>>>> " + ((String) it.next()));
                    }
                    ee.c.b(3, "o", "putConnectedGattInMap >>>>>>>>>>>>> end");
                }
                if (!discoverServices) {
                    this.f15798a.b(device);
                    return;
                }
                this.f15798a.f15819m.removeMessages(4117);
                Handler handler2 = this.f15798a.f15819m;
                handler2.sendMessageDelayed(handler2.obtainMessage(4117, device), 6000L);
                return;
            }
            this.f15798a.g(device);
            if (qd.a(this.f15798a.f15808a)) {
                try {
                    bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            bluetoothGatt.close();
            long currentTimeMillis = System.currentTimeMillis() - this.f15798a.f15818l;
            o oVar3 = o.f15804o;
            ee.c.b(2, "o", "onConnectionStateChange >> usedConnectTime = " + currentTimeMillis + ", limit time = 5000");
            if (i3 == 133 && currentTimeMillis < 5000) {
                o oVar4 = this.f15798a;
                int i11 = oVar4.f15817k;
                if (i11 < 1) {
                    oVar4.f15817k = i11 + 1;
                    oVar4.a(device);
                    return;
                }
                oVar4.f15817k = 0;
            }
        }
        this.f15798a.f(device, i10);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        BluetoothDevice device;
        UUID uuid;
        UUID uuid2;
        if (bluetoothGatt != null) {
            o oVar = this.f15798a;
            if (!qd.a(oVar.f15808a) || (device = bluetoothGatt.getDevice()) == null || bluetoothGattDescriptor == null) {
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
            if (characteristic != null) {
                uuid2 = characteristic.getUuid();
                BluetoothGattService service = characteristic.getService();
                uuid = service != null ? service.getUuid() : null;
            } else {
                uuid = null;
                uuid2 = null;
            }
            o oVar2 = o.f15804o;
            Locale locale = Locale.getDefault();
            XXApplication xXApplication = oVar.f15808a;
            ee.c.b(3, "o", String.format(locale, "onDescriptorWrite : device : %s, serviceUuid = %s, characteristicUuid = %s, descriptor = %s, status = %d", ee.a.e(xXApplication, device), uuid, uuid2, bluetoothGattDescriptor.getUuid(), Integer.valueOf(i3)));
            oVar.f15815i.e(device, uuid, uuid2, i3);
            n nVar = oVar.f15816j;
            if (nVar != null) {
                BluetoothGatt bluetoothGatt2 = nVar.f15799a;
                if (ee.a.b(device, bluetoothGatt2 == null ? null : bluetoothGatt2.getDevice()) && uuid != null && uuid.equals(oVar.f15816j.f15800b) && uuid2 != null && uuid2.equals(oVar.f15816j.f15801c) && bluetoothGattDescriptor.getUuid() != null && bluetoothGattDescriptor.getUuid().equals(oVar.f15816j.f15802d)) {
                    Handler handler = oVar.f15819m;
                    if (i3 != 0) {
                        n nVar2 = oVar.f15816j;
                        int i10 = nVar2.e;
                        if (i10 >= 3) {
                            oVar.b(device);
                            return;
                        } else {
                            nVar2.e = i10 + 1;
                            handler.postDelayed(nVar2, 100L);
                            return;
                        }
                    }
                    oVar.f15816j = null;
                    int i11 = oVar.f15809b.f15327a.getInt("ble_mtu_value", 509);
                    int i12 = i11 <= 509 ? i11 : 509;
                    if (!qd.a(xXApplication)) {
                        ee.c.b(4, "o", "-startChangeMtu- param is error.");
                        return;
                    }
                    BluetoothDevice device2 = bluetoothGatt.getDevice();
                    if (device2 == null) {
                        ee.c.b(4, "o", "-startChangeMtu- device is null.");
                        return;
                    }
                    if (handler.hasMessages(4116)) {
                        ee.c.b(4, "o", "-startChangeMtu- Adjusting the MTU for BLE");
                        return;
                    }
                    boolean requestMtu = i12 > 20 ? bluetoothGatt.requestMtu(i12 + 3) : false;
                    ee.c.b(2, "o", "-startChangeMtu- ret = " + requestMtu);
                    if (requestMtu) {
                        handler.sendMessageDelayed(handler.obtainMessage(4116, device2), 6000L);
                    } else {
                        oVar.e(device2);
                    }
                }
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i3, int i10) {
        BluetoothDevice device;
        if (bluetoothGatt != null) {
            o oVar = this.f15798a;
            if (qd.a(oVar.f15808a) && (device = bluetoothGatt.getDevice()) != null) {
                o oVar2 = o.f15804o;
                ee.c.b(2, "o", String.format(Locale.getDefault(), "onMtuChanged : device : %s, mtu = %d, status = %d", ee.a.e(oVar.f15808a, device), Integer.valueOf(i3), Integer.valueOf(i10)));
                oVar.f15815i.c(device, i3, i10);
                n6.b d5 = oVar.d(device);
                if (i10 == 0) {
                    int i11 = i3 - 3;
                    if (d5 != null) {
                        Handler handler = oVar.f15819m;
                        if (handler.hasMessages(4116)) {
                            handler.removeMessages(4116);
                            d5.f16384c = i11;
                            ee.c.b(3, "o", "-onMtuChanged- handleBleConnectedEvent");
                            oVar.e(device);
                        }
                    }
                }
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i3) {
        BluetoothDevice device;
        boolean z5;
        if (bluetoothGatt != null) {
            o oVar = this.f15798a;
            if (qd.a(oVar.f15808a) && (device = bluetoothGatt.getDevice()) != null) {
                Handler handler = oVar.f15819m;
                handler.removeMessages(4117);
                oVar.f15815i.f(device, i3, bluetoothGatt.getServices());
                if (i3 == 0) {
                    XXApplication xXApplication = oVar.f15808a;
                    if (qd.a(xXApplication)) {
                        SimpleDateFormat simpleDateFormat = ee.c.f12596a;
                        ee.c.b(2, "ble", String.format(Locale.getDefault(), "[[============================Bluetooth[%s], Discovery Services status[%d]=================================]]\n", ee.a.e(xXApplication, device), Integer.valueOf(i3)));
                        List<BluetoothGattService> services = bluetoothGatt.getServices();
                        if (services != null) {
                            ee.c.b(2, "ble", "[[======Service Size:" + services.size() + "======================\n");
                            for (BluetoothGattService bluetoothGattService : services) {
                                if (bluetoothGattService != null) {
                                    ee.c.b(2, "ble", "[[======Service:" + bluetoothGattService.getUuid() + "======================\n");
                                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                                    if (characteristics != null) {
                                        ee.c.b(2, "ble", "[[[[=============characteristics Size:" + characteristics.size() + "======================\n");
                                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                            if (bluetoothGattCharacteristic != null) {
                                                ee.c.b(2, "ble", "[[[[=============characteristic:" + bluetoothGattCharacteristic.getUuid() + ",write type : " + bluetoothGattCharacteristic.getWriteType() + "======================\n");
                                                List<BluetoothGattDescriptor> descriptors = bluetoothGattCharacteristic.getDescriptors();
                                                if (descriptors != null) {
                                                    ee.c.b(2, "ble", "[[[[[[=============descriptors Size:" + descriptors.size() + "======================\n");
                                                    for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                        if (bluetoothGattDescriptor != null) {
                                                            ee.c.b(2, "ble", "[[[[[[=============descriptor:" + bluetoothGattDescriptor.getUuid() + ",permission:" + bluetoothGattDescriptor.getPermissions() + "\nvalue : " + ee.b.c(bluetoothGattDescriptor.getValue()) + "======================\n");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        ee.c.b(2, "ble", "[[============================Bluetooth[" + ee.a.e(xXApplication, device) + "] Services show End=================================]]\n");
                    }
                    for (BluetoothGattService bluetoothGattService2 : bluetoothGatt.getServices()) {
                        UUID uuid = o.f15805p;
                        if (uuid.equals(bluetoothGattService2.getUuid()) && bluetoothGattService2.getCharacteristic(o.f15806q) != null) {
                            UUID uuid2 = o.r;
                            if (bluetoothGattService2.getCharacteristic(uuid2) != null) {
                                ee.c.b(3, "o", "start NotifyCharacteristicRunnable...");
                                oVar.f15816j = new n(oVar, bluetoothGatt, uuid, uuid2);
                                handler.post(oVar.f15816j);
                                z5 = true;
                                break;
                            }
                        }
                    }
                }
                z5 = false;
                o oVar2 = o.f15804o;
                ee.c.b(3, "o", "onServicesDiscovered : " + z5);
                if (z5) {
                    return;
                }
                oVar.b(device);
            }
        }
    }
}
