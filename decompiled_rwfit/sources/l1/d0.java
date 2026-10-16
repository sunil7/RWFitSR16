package l1;

import android.text.TextUtils;
import android.view.View;

/* loaded from: classes.dex */
public final class d0 extends f0 {
    public final /* synthetic */ int e;

    public d0(int i3, Class cls, int i10, int i11, int i12) {
        this.e = i12;
        this.f15694a = i3;
        this.f15697d = cls;
        this.f15696c = i10;
        this.f15695b = i11;
    }

    @Override // l1.f0
    public final Object b(View view) {
        switch (this.e) {
            case 0:
                return Boolean.valueOf(s0.d(view));
            case 1:
                return s0.b(view);
            case 2:
                return u0.a(view);
            default:
                return Boolean.valueOf(s0.c(view));
        }
    }

    @Override // l1.f0
    public final void c(View view, Object obj) {
        switch (this.e) {
            case 0:
                s0.i(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                s0.h(view, (CharSequence) obj);
                break;
            case 2:
                u0.b(view, (CharSequence) obj);
                break;
            default:
                s0.g(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // l1.f0
    public final boolean e(Object obj, Object obj2) {
        switch (this.e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            case 2:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
    }
}
