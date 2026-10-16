package j2;

import android.view.View;
import com.king.logx.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: b, reason: collision with root package name */
    public final View f15264b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f15263a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f15265c = new ArrayList();

    public m0(View view) {
        this.f15264b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.f15264b == m0Var.f15264b && this.f15263a.equals(m0Var.f15263a);
    }

    public final int hashCode() {
        return this.f15263a.hashCode() + (this.f15264b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder u10 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        u10.append(this.f15264b);
        u10.append("\n");
        String l3 = android.support.v4.media.session.e.l(u10.toString(), "    values:");
        HashMap hashMap = this.f15263a;
        for (String str : hashMap.keySet()) {
            l3 = l3 + Logger.INDENT + str + ": " + hashMap.get(str) + "\n";
        }
        return l3;
    }
}
