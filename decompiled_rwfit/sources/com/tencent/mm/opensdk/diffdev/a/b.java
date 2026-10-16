package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class b implements OAuthListener {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ a f11873f;

    public b(a aVar) {
        this.f11873f = aVar;
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthFinish, errCode = " + oAuthErrCode.toString() + ", authCode = " + str);
        a.c(this.f11873f);
        ArrayList arrayList = new ArrayList();
        list = this.f11873f.f11871c;
        arrayList.addAll(list);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((OAuthListener) obj).onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        List list;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        ArrayList arrayList = new ArrayList();
        list = this.f11873f.f11871c;
        arrayList.addAll(list);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((OAuthListener) obj).onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Handler handler;
        Handler handler2;
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        handler = this.f11873f.handler;
        if (handler != null) {
            handler2 = this.f11873f.handler;
            handler2.post(new c(this));
        }
    }
}
