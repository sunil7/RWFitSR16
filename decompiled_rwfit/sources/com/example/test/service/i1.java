package com.example.test.service;

import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class i1 implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7721a;

    public i1(u1 u1Var) {
        this.f7721a = u1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        u5.c cVar;
        this.f7721a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "获取经典蓝牙信息失败" + i3);
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    @Override // u5.g
    public final void c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
    
        if (((android.bluetooth.BluetoothDevice) r4) != null) goto L35;
     */
    @Override // u5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r7) {
        /*
            r6 = this;
            com.example.blesdk.bean.function.BlueToothBean r7 = (com.example.blesdk.bean.function.BlueToothBean) r7
            com.example.test.service.u1 r0 = r6.f7721a
            r0.getClass()
            java.lang.String r0 = "SyncService"
            java.lang.String r1 = com.example.baselibrary.utils.b.z(r7)
            java.lang.String r2 = "获取经典蓝牙信息："
            java.lang.String r1 = com.google.android.gms.internal.mlkit_vision_barcode.l0.n(r2, r1)
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1}
            java.lang.String r1 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r1, r0)
            if (r7 == 0) goto Le9
            com.example.test.service.u1 r0 = r6.f7721a
            boolean r1 = r7.isNeedBound()
            r2 = 0
            if (r1 == 0) goto Lad
            java.lang.String r1 = r7.getMac()
            if (r1 == 0) goto Lad
            java.lang.String r1 = r7.getMac()
            java.lang.String r3 = "getMac(...)"
            kotlin.jvm.internal.e.e(r1, r3)
            android.bluetooth.BluetoothAdapter r3 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()
            kotlin.jvm.internal.e.c(r3)
            java.util.Set r3 = r3.getBondedDevices()
            int r4 = r3.size()
            if (r4 <= 0) goto L69
            java.util.Iterator r3 = r3.iterator()
        L4b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L63
            java.lang.Object r4 = r3.next()
            r5 = r4
            android.bluetooth.BluetoothDevice r5 = (android.bluetooth.BluetoothDevice) r5
            java.lang.String r5 = r5.getAddress()
            boolean r5 = kotlin.jvm.internal.e.a(r5, r1)
            if (r5 == 0) goto L4b
            goto L64
        L63:
            r4 = r2
        L64:
            android.bluetooth.BluetoothDevice r4 = (android.bluetooth.BluetoothDevice) r4
            if (r4 == 0) goto L69
            goto L9c
        L69:
            r5.b r1 = r5.b.k()
            boolean r1 = r1.f18054c
            if (r1 == 0) goto L9c
            com.example.baselibrary.utils.e r0 = r0.b()
            androidx.activity.b r1 = new androidx.activity.b
            r3 = 17
            r1.<init>(r7, r3)
            r3 = 200(0xc8, double:9.9E-322)
            r0.postDelayed(r1, r3)
            com.example.test.utils.k r0 = com.example.test.utils.k.f8731b
            if (r0 != 0) goto L94
            java.lang.Class<com.example.test.utils.k> r0 = com.example.test.utils.k.class
            monitor-enter(r0)
            com.example.test.utils.k r1 = new com.example.test.utils.k     // Catch: java.lang.Throwable -> L91
            r1.<init>()     // Catch: java.lang.Throwable -> L91
            com.example.test.utils.k.f8731b = r1     // Catch: java.lang.Throwable -> L91
            monitor-exit(r0)
            goto L94
        L91:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L94:
            com.example.test.utils.k r0 = com.example.test.utils.k.f8731b
            if (r0 == 0) goto Lbd
            r0.P(r7)
            goto Lbd
        L9c:
            r0.getClass()
            java.lang.String r7 = "SyncService"
            java.lang.String r0 = "经典蓝牙已绑定"
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r0}
            java.lang.String r0 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r0, r7)
            goto Lbd
        Lad:
            r0.getClass()
            java.lang.String r7 = "SyncService"
            java.lang.String r0 = "经典蓝牙信息错误"
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r0}
            java.lang.String r0 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r0, r7)
        Lbd:
            x5.b r7 = x5.b.I0()
            boolean r0 = r7.J0(r6)
            if (r0 != 0) goto Lc8
            goto Le9
        Lc8:
            java.util.LinkedList r7 = r7.f19795a
            java.util.Iterator r0 = r7.iterator()
        Lce:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Le3
            java.lang.Object r1 = r0.next()
            u5.c r1 = (u5.c) r1
            if (r1 == 0) goto Lce
            u5.b r3 = r1.g()
            if (r3 != r6) goto Lce
            r2 = r1
        Le3:
            if (r2 != 0) goto Le6
            goto Le9
        Le6:
            r7.remove(r2)
        Le9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.i1.e(java.lang.Object):void");
    }
}
