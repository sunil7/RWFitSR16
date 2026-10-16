package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class x3 implements k1 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f1109a;

    /* renamed from: b, reason: collision with root package name */
    public int f1110b;

    /* renamed from: c, reason: collision with root package name */
    public View f1111c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f1112d;
    public Drawable e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1113f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1114g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f1115h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f1116i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f1117j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f1118k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1119l;

    /* renamed from: m, reason: collision with root package name */
    public l f1120m;

    /* renamed from: n, reason: collision with root package name */
    public int f1121n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f1122o;

    public final void a(int i3) {
        View view;
        int i10 = this.f1110b ^ i3;
        this.f1110b = i3;
        if (i10 != 0) {
            if ((i10 & 4) != 0) {
                if ((i3 & 4) != 0) {
                    b();
                }
                int i11 = this.f1110b & 4;
                Toolbar toolbar = this.f1109a;
                if (i11 != 0) {
                    Drawable drawable = this.f1113f;
                    if (drawable == null) {
                        drawable = this.f1122o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i10 & 3) != 0) {
                c();
            }
            int i12 = i10 & 8;
            Toolbar toolbar2 = this.f1109a;
            if (i12 != 0) {
                if ((i3 & 8) != 0) {
                    toolbar2.setTitle(this.f1115h);
                    toolbar2.setSubtitle(this.f1116i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i10 & 16) == 0 || (view = this.f1111c) == null) {
                return;
            }
            if ((i3 & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final void b() {
        if ((this.f1110b & 4) != 0) {
            boolean isEmpty = TextUtils.isEmpty(this.f1117j);
            Toolbar toolbar = this.f1109a;
            if (isEmpty) {
                toolbar.setNavigationContentDescription(this.f1121n);
            } else {
                toolbar.setNavigationContentDescription(this.f1117j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i3 = this.f1110b;
        if ((i3 & 2) == 0) {
            drawable = null;
        } else if ((i3 & 1) != 0) {
            drawable = this.e;
            if (drawable == null) {
                drawable = this.f1112d;
            }
        } else {
            drawable = this.f1112d;
        }
        this.f1109a.setLogo(drawable);
    }
}
