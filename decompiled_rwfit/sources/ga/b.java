package ga;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import n.g0;
import o9.n;
import okhttp3.internal.http.StatusLine;
import q9.f;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14021a;

    public com.google.android.gms.common.api.c a(Context context, Looper looper, g0 g0Var, Object obj, g gVar, h hVar) {
        switch (this.f14021a) {
            case 0:
                g0Var.getClass();
                Integer num = (Integer) g0Var.f16178f;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new ha.a(context, looper, g0Var, bundle, gVar, hVar);
            case 1:
                throw l0.f(obj);
            default:
                n nVar = (n) gVar;
                switch (this.f14021a) {
                    case 2:
                        return new s9.c(context, looper, g0Var, (f) obj, nVar, hVar);
                    case 3:
                        return new u9.g(context, looper, StatusLine.HTTP_PERM_REDIRECT, g0Var, nVar, hVar);
                    default:
                        throw new UnsupportedOperationException("buildClient must be implemented");
                }
        }
    }
}
