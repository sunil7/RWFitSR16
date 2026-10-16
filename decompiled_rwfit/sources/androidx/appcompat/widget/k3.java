package androidx.appcompat.widget;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class k3 extends androidx.emoji2.text.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f951a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f952b;

    public k3(EditText editText) {
        this.f952b = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.h
    public void a() {
        switch (this.f951a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f952b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
        }
    }

    @Override // androidx.emoji2.text.h
    public final void b() {
        switch (this.f951a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f952b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
            default:
                t1.h.a((EditText) this.f952b.get(), 1);
                break;
        }
    }

    public k3(SwitchCompat switchCompat) {
        this.f952b = new WeakReference(switchCompat);
    }
}
