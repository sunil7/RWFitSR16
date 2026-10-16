package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class a implements IDiffDevOAuth {

    /* renamed from: d, reason: collision with root package name */
    private d f11872d;
    private Handler handler = null;

    /* renamed from: c, reason: collision with root package name */
    private List<OAuthListener> f11871c = new ArrayList();
    private OAuthListener e = new b(this);

    public static /* synthetic */ d c(a aVar) {
        aVar.f11872d = null;
        return null;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void addListener(OAuthListener oAuthListener) {
        if (this.f11871c.contains(oAuthListener)) {
            return;
        }
        this.f11871c.add(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth fail, invalid argument, appId = " + str + ", scope = " + str2);
            return false;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.f11872d != null) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        d dVar = new d(str, str2, str3, str4, str5, this.e);
        this.f11872d = dVar;
        dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f11871c.clear();
        stopAuth();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeAllListeners() {
        this.f11871c.clear();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final void removeListener(OAuthListener oAuthListener) {
        this.f11871c.remove(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public final boolean stopAuth() {
        boolean z5;
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            d dVar = this.f11872d;
            z5 = dVar == null ? true : dVar.a();
        } catch (Exception e) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            z5 = false;
        }
        this.f11872d = null;
        return z5;
    }
}
