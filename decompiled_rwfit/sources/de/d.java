package de;

import androidx.recyclerview.widget.x;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12351a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f12352b;

    public /* synthetic */ d(int i3, x xVar) {
        this.f12351a = i3;
        this.f12352b = xVar;
    }

    @Override // de.l
    public final void k(Object obj) {
        switch (this.f12351a) {
            case 0:
                ((rd.c) obj).a(this.f12352b);
                break;
            default:
                ((rd.d) obj).a(this.f12352b);
                break;
        }
    }
}
