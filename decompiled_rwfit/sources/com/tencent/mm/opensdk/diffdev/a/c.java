package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class c implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ b f11874g;

    public c(b bVar) {
        this.f11874g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ArrayList arrayList = new ArrayList();
        list = this.f11874g.f11873f.f11871c;
        arrayList.addAll(list);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((OAuthListener) obj).onQrcodeScanned();
        }
    }
}
