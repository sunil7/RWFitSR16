package com.example.test.ui.testui;

import com.example.database.table.Devices;
import com.example.test.R$id;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u implements a7.f, q6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingEditCardActivity f8315a;

    public /* synthetic */ u(TRingEditCardActivity tRingEditCardActivity) {
        this.f8315a = tRingEditCardActivity;
    }

    @Override // a7.f
    public void j(int i3) {
        if (i3 == R$id.barStatusIv) {
            this.f8315a.finish();
        }
        if (i3 == R$id.option2) {
            if (this.f8315a.E != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    ArrayList arrayList = this.f8315a.E;
                    Devices c9 = kVar.c();
                    if (c9 != null) {
                        kVar.M(com.example.baselibrary.utils.b.z(arrayList), android.support.v4.media.session.e.l(c9.getMacAddress(), "home_card_data"));
                    }
                }
            }
            this.f8315a.finish();
        }
    }
}
