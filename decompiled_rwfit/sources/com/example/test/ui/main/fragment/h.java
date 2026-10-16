package com.example.test.ui.main.fragment;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class h implements w5.b {
    @Override // w5.b
    public final void d(int i3, int i10) {
        u5.c cVar;
        byte b3 = (byte) i3;
        if (b3 == -51) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", l0.j(i10, "设置 日期格式 失败，原因:"));
        } else if (b3 == -42) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", l0.j(i10, "设置 防丢提醒 失败，原因:"));
        } else if (b3 == -41) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", l0.j(i10, "设置 来电提醒 失败，原因:"));
        }
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

    @Override // w5.b
    public final void h(int i3) {
        u5.c cVar;
        byte b3 = (byte) i3;
        if (b3 == -51) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", "设置 日期格式 成功");
        } else if (b3 == -42) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", "设置 防丢提醒 成功");
        } else if (b3 == -41) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", "设置 来电提醒 成功");
        }
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
}
