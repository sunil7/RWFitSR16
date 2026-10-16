package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.map3d.R;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* loaded from: classes.dex */
public class w1 {

    /* renamed from: d, reason: collision with root package name */
    private View f5211d;
    private TextView e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f5212f;

    /* renamed from: h, reason: collision with root package name */
    Context f5214h;

    /* renamed from: i, reason: collision with root package name */
    private IInfoWindowAction f5215i;

    /* renamed from: j, reason: collision with root package name */
    private IInfoWindowAction f5216j;

    /* renamed from: k, reason: collision with root package name */
    private BaseOverlay f5217k;

    /* renamed from: a, reason: collision with root package name */
    AMap.InfoWindowAdapter f5208a = null;

    /* renamed from: b, reason: collision with root package name */
    AMap.CommonInfoWindowAdapter f5209b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5210c = true;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f5213g = null;

    /* renamed from: l, reason: collision with root package name */
    private AMap.InfoWindowAdapter f5218l = new a();

    /* renamed from: m, reason: collision with root package name */
    private AMap.CommonInfoWindowAdapter f5219m = new b();

    public class a implements AMap.InfoWindowAdapter {
        public a() {
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoWindow(Marker marker) {
            try {
                if (w1.this.f5213g == null) {
                    w1 w1Var = w1.this;
                    w1Var.f5213g = o4.a(w1Var.f5214h, "infowindow_bg.9.png");
                }
                if (w1.this.f5211d == null) {
                    w1.this.f5211d = new LinearLayout(w1.this.f5214h);
                    w1.this.f5211d.setBackground(w1.this.f5213g);
                    w1.this.e = new TextView(w1.this.f5214h);
                    w1.this.e.setText(marker.getTitle());
                    w1.this.e.setTextColor(-16777216);
                    w1.this.f5212f = new TextView(w1.this.f5214h);
                    w1.this.f5212f.setTextColor(-16777216);
                    w1.this.f5212f.setText(marker.getSnippet());
                    ((LinearLayout) w1.this.f5211d).setOrientation(1);
                    ((LinearLayout) w1.this.f5211d).addView(w1.this.e);
                    ((LinearLayout) w1.this.f5211d).addView(w1.this.f5212f);
                }
            } catch (Throwable th2) {
                ka.a(th2, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th2.printStackTrace();
            }
            return w1.this.f5211d;
        }
    }

    public class b implements AMap.CommonInfoWindowAdapter {

        /* renamed from: a, reason: collision with root package name */
        private InfoWindowParams f5221a = null;

        public b() {
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f5221a == null) {
                    this.f5221a = new InfoWindowParams();
                    if (w1.this.f5213g == null) {
                        w1 w1Var = w1.this;
                        w1Var.f5213g = o4.a(w1Var.f5214h, "infowindow_bg.9.png");
                    }
                    w1.this.f5211d = new LinearLayout(w1.this.f5214h);
                    w1.this.f5211d.setBackground(w1.this.f5213g);
                    w1.this.e = new TextView(w1.this.f5214h);
                    w1.this.e.setText(n1.a(R.string.O105492_68));
                    w1.this.e.setTextColor(-16777216);
                    w1.this.f5212f = new TextView(w1.this.f5214h);
                    w1.this.f5212f.setTextColor(-16777216);
                    w1.this.f5212f.setText(n1.a(R.string.O105492_69));
                    ((LinearLayout) w1.this.f5211d).setOrientation(1);
                    ((LinearLayout) w1.this.f5211d).addView(w1.this.e);
                    ((LinearLayout) w1.this.f5211d).addView(w1.this.f5212f);
                    this.f5221a.setInfoWindowType(2);
                    this.f5221a.setInfoWindow(w1.this.f5211d);
                }
                return this.f5221a;
            } catch (Throwable th2) {
                ka.a(th2, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th2.printStackTrace();
                return null;
            }
        }
    }

    public w1(Context context) {
        this.f5214h = context;
    }

    public long c(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5208a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5209b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public void b(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            try {
                this.f5215i = iInfoWindowAction;
                if (iInfoWindowAction != null) {
                    ((g5) iInfoWindowAction).setInfoWindowAdapterManager(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f5216j = iInfoWindowAction;
            synchronized (((o3) iInfoWindowAction)) {
            }
        }
    }

    public synchronized boolean b() {
        return this.f5210c;
    }

    public View b(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5208a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            a(infoWindow, basePointOverlay);
            return infoWindow;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5209b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoWindow2 = infoWindowParams.getInfoWindow();
            a(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        InfoWindowParams infoWindowParams2 = this.f5219m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public void a(String str, String str2) {
        TextView textView = this.e;
        if (textView != null) {
            textView.requestLayout();
            this.e.setText(str);
        }
        TextView textView2 = this.f5212f;
        if (textView2 != null) {
            textView2.requestLayout();
            this.f5212f.setText(str2);
        }
        View view = this.f5211d;
        if (view != null) {
            view.requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0001, B:6:0x0021, B:7:0x002e, B:9:0x0032, B:10:0x0035, B:12:0x0039, B:17:0x0009, B:19:0x001b, B:21:0x002b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0001, B:6:0x0021, B:7:0x002e, B:9:0x0032, B:10:0x0035, B:12:0x0039, B:17:0x0009, B:19:0x001b, B:21:0x002b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(com.amap.api.maps.AMap.InfoWindowAdapter r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.f5208a = r5     // Catch: java.lang.Throwable -> L29
            r0 = 0
            r4.f5209b = r0     // Catch: java.lang.Throwable -> L29
            if (r5 != 0) goto L9
            goto L21
        L9:
            com.amap.api.maps.model.Marker r1 = new com.amap.api.maps.model.Marker     // Catch: java.lang.Throwable -> L29
            com.amap.api.maps.model.MarkerOptions r2 = new com.amap.api.maps.model.MarkerOptions     // Catch: java.lang.Throwable -> L29
            r2.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = "check"
            r1.<init>(r0, r0, r2, r3)     // Catch: java.lang.Throwable -> L29
            android.view.View r0 = r5.getInfoWindow(r1)     // Catch: java.lang.Throwable -> L29
            if (r0 != 0) goto L2b
            android.view.View r5 = r5.getInfoContents(r1)     // Catch: java.lang.Throwable -> L29
            if (r5 != 0) goto L2b
        L21:
            com.amap.api.maps.AMap$InfoWindowAdapter r5 = r4.f5218l     // Catch: java.lang.Throwable -> L29
            r4.f5208a = r5     // Catch: java.lang.Throwable -> L29
            r5 = 1
            r4.f5210c = r5     // Catch: java.lang.Throwable -> L29
            goto L2e
        L29:
            r5 = move-exception
            goto L3e
        L2b:
            r5 = 0
            r4.f5210c = r5     // Catch: java.lang.Throwable -> L29
        L2e:
            com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction r5 = r4.f5216j     // Catch: java.lang.Throwable -> L29
            if (r5 == 0) goto L35
            r5.hideInfoWindow()     // Catch: java.lang.Throwable -> L29
        L35:
            com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction r5 = r4.f5215i     // Catch: java.lang.Throwable -> L29
            if (r5 == 0) goto L3c
            r5.hideInfoWindow()     // Catch: java.lang.Throwable -> L29
        L3c:
            monitor-exit(r4)
            return
        L3e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L29
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.w1.a(com.amap.api.maps.AMap$InfoWindowAdapter):void");
    }

    public synchronized void a(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        try {
            this.f5209b = commonInfoWindowAdapter;
            this.f5208a = null;
            if (commonInfoWindowAdapter == null) {
                this.f5209b = this.f5219m;
                this.f5210c = true;
            } else {
                this.f5210c = false;
            }
            IInfoWindowAction iInfoWindowAction = this.f5216j;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.hideInfoWindow();
            }
            IInfoWindowAction iInfoWindowAction2 = this.f5215i;
            if (iInfoWindowAction2 != null) {
                iInfoWindowAction2.hideInfoWindow();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void a(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !n4.c()) {
            return;
        }
        String b3 = v4.b(view);
        if (TextUtils.isEmpty(b3)) {
            return;
        }
        n4.b().a(basePointOverlay.getPosition(), b3, "");
    }

    public View a(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5208a;
        if (infoWindowAdapter != null) {
            View infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
            a(infoContents, basePointOverlay);
            return infoContents;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5209b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoContents2 = infoWindowParams.getInfoContents();
            a(infoContents2, basePointOverlay);
            return infoContents2;
        }
        InfoWindowParams infoWindowParams2 = this.f5219m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public synchronized IInfoWindowAction a() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5208a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.f5216j;
            }
            if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.f5216j;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5209b;
        if (commonInfoWindowAdapter != null && commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() == 1) {
            return this.f5216j;
        }
        return this.f5215i;
    }

    public BaseOverlay a(MotionEvent motionEvent) {
        IInfoWindowAction a3 = a();
        if (a3 == null || !a3.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.f5217k;
    }

    public void a(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction a3 = a();
        if (a3 == null || !(baseOverlay instanceof BasePointOverlay)) {
            return;
        }
        a3.showInfoWindow((BasePointOverlay) baseOverlay);
        this.f5217k = baseOverlay;
    }
}
