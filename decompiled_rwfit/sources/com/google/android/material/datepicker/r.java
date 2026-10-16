package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10456a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f10457b;

    public /* synthetic */ r(Fragment fragment, int i3) {
        this.f10456a = i3;
        this.f10457b = fragment;
    }

    public final void a() {
        switch (this.f10456a) {
            case 0:
                ((s) this.f10457b).G.setEnabled(false);
                break;
            default:
                Iterator it = ((t) this.f10457b).f10484a.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).a();
                }
                break;
        }
    }

    public final void b(Object obj) {
        switch (this.f10456a) {
            case 0:
                s sVar = (s) this.f10457b;
                sVar.h0();
                sVar.G.setEnabled(sVar.f10462v.A());
                break;
            default:
                Iterator it = ((t) this.f10457b).f10484a.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).b(obj);
                }
                break;
        }
    }
}
