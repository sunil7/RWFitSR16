package com.amap.api.col.p0003sl;

import android.webkit.WebView;

/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4524a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ n f4525b;

    public m(n nVar, String str) {
        this.f4525b = nVar;
        this.f4524a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebView webView;
        String str;
        webView = this.f4525b.f4665d;
        StringBuilder sb2 = new StringBuilder("javascript:");
        str = this.f4525b.e;
        sb2.append(str);
        sb2.append("('");
        sb2.append(this.f4524a);
        sb2.append("')");
        webView.loadUrl(sb2.toString());
    }
}
