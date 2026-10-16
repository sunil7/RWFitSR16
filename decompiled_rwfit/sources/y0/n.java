package y0;

import android.app.Notification;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f19896a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19897b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f19898c;

    public n(String str, int i3, Notification notification) {
        this.f19896a = str;
        this.f19897b = i3;
        this.f19898c = notification;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("NotifyTask[packageName:");
        sb2.append(this.f19896a);
        sb2.append(", id:");
        return r5.a.e(sb2, this.f19897b, ", tag:null]");
    }
}
