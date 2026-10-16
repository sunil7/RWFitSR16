package com.amap.api.col.p0003sl;

import android.graphics.Rect;
import android.view.View;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.DPoint;

/* loaded from: classes.dex */
public class c1 {

    /* renamed from: a, reason: collision with root package name */
    private Marker f3797a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f3798b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f3799c = 0;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f3800d = 0;
    private volatile int e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3801f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3802g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3803h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f3804i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f3805j = 0;

    public c1(Marker marker) {
        this.f3797a = marker;
    }

    public void a(boolean z5) {
        this.f3803h = z5;
    }

    public synchronized int b() {
        return this.e;
    }

    public BaseOverlay c() {
        return this.f3797a;
    }

    public View d() {
        MarkerOptions options = this.f3797a.getOptions();
        if (options == null) {
            return null;
        }
        return options.getIconView();
    }

    public int e() {
        MarkerOptions options = this.f3797a.getOptions();
        if (options == null) {
            return 0;
        }
        View iconView = options.getIconView();
        int width = iconView.getWidth();
        if (width != 0) {
            return width;
        }
        a(iconView);
        return this.f3804i;
    }

    public boolean f() {
        return this.f3803h;
    }

    public boolean g() {
        return this.f3802g;
    }

    public boolean h() {
        return this.f3801f;
    }

    public void i() {
        View iconView;
        MarkerOptions options = this.f3797a.getOptions();
        if (options == null || (iconView = options.getIconView()) == null) {
            return;
        }
        if (options.isVisible() == (iconView.getVisibility() == 0)) {
            return;
        }
        iconView.setVisibility(options.isVisible() ? 0 : 8);
    }

    private void a(View view) {
        if (this.f3804i == 0 && this.f3805j == 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f3804i = view.getMeasuredWidth();
            this.f3805j = view.getMeasuredHeight();
        }
    }

    public synchronized void b(int i3, int i10) {
        int i11;
        int i12;
        int i13;
        try {
            MarkerOptions options = this.f3797a.getOptions();
            if (options == null) {
                return;
            }
            float anchorU = options.getAnchorU();
            float anchorV = options.getAnchorV();
            View iconView = options.getIconView();
            int i14 = 0;
            if (iconView != null) {
                i11 = e();
                MarkerOptions options2 = this.f3797a.getOptions();
                if (options2 == null) {
                    i12 = 0;
                } else {
                    View iconView2 = options2.getIconView();
                    i12 = iconView2.getHeight();
                    if (i12 == 0) {
                        a(iconView2);
                        i12 = this.f3805j;
                    }
                }
            } else {
                i11 = 0;
                i12 = 0;
            }
            if (iconView != null) {
                i14 = (int) (i11 * anchorU);
                i13 = (int) (i12 * anchorV);
            } else {
                i13 = 0;
            }
            if (i14 != 0 && i13 != 0) {
                if (Math.abs(this.f3798b - i3) > 2) {
                    this.f3800d = i3 - i14;
                    this.f3801f = true;
                }
                if (Math.abs(this.f3799c - i10) > 2) {
                    this.e = i10 - i13;
                    this.f3801f = true;
                }
            }
        } finally {
        }
    }

    public synchronized int a() {
        return this.f3800d;
    }

    public synchronized void a(int i3, int i10) {
        try {
            if (this.f3801f) {
                MarkerOptions options = this.f3797a.getOptions();
                if (options == null) {
                    return;
                }
                View iconView = options.getIconView();
                if (iconView == null) {
                    return;
                }
                iconView.setX(this.f3800d);
                iconView.setY(this.e);
                iconView.setZ(options.getZIndex());
                if (i3 != -1) {
                    this.f3798b = i3;
                }
                if (i10 != -1) {
                    this.f3799c = i10;
                }
                this.f3801f = false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(boolean z5, int i3, int i10) {
        this.f3801f = z5;
        this.f3798b = i3;
        this.f3799c = i10;
    }

    public void b(boolean z5) {
        this.f3802g = z5;
    }

    public boolean a(DPoint dPoint) {
        View iconView = this.f3797a.getOptions().getIconView();
        Rect rect = new Rect();
        if (iconView != null) {
            iconView.getHitRect(rect);
        }
        return rect.contains((int) dPoint.f6570x, (int) dPoint.f6571y);
    }
}
