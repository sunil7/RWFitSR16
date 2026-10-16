package q9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f17841d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f17842a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17843b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17844c;

    public u(String str, boolean z5) {
        n.c(str);
        this.f17842a = str;
        n.c("com.google.android.gms");
        this.f17843b = "com.google.android.gms";
        this.f17844c = z5;
    }

    public final Intent a(Context context) {
        Bundle bundle;
        String str = this.f17842a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.f17844c) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", str);
            try {
                bundle = context.getContentResolver().call(f17841d, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
            }
            r1 = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (r1 == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return r1 == null ? new Intent(str).setPackage(this.f17843b) : r1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return n.h(this.f17842a, uVar.f17842a) && n.h(this.f17843b, uVar.f17843b) && n.h(null, null) && this.f17844c == uVar.f17844c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17842a, this.f17843b, null, 4225, Boolean.valueOf(this.f17844c)});
    }

    public final String toString() {
        String str = this.f17842a;
        if (str != null) {
            return str;
        }
        n.e(null);
        throw null;
    }
}
