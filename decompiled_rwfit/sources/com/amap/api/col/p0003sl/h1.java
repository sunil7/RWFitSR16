package com.amap.api.col.p0003sl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* loaded from: classes.dex */
class h1 implements IUiSettingsDelegate {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f4242a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4243b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4244c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4245d = true;
    private boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4246f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4247g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4248h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4249i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4250j = true;

    /* renamed from: k, reason: collision with root package name */
    private int f4251k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f4252l = 1;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4253m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4254n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4255o = false;

    /* renamed from: p, reason: collision with root package name */
    final Handler f4256p = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || h1.this.f4242a == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        h1.this.f4242a.showZoomControlsEnabled(h1.this.f4247g);
                        break;
                    case 1:
                        h1.this.f4242a.showScaleEnabled(h1.this.f4249i);
                        break;
                    case 2:
                        h1.this.f4242a.showCompassEnabled(h1.this.f4248h);
                        break;
                    case 3:
                        h1.this.f4242a.showMyLocationButtonEnabled(h1.this.e);
                        break;
                    case 4:
                        h1.this.f4242a.showIndoorSwitchControlsEnabled(h1.this.f4253m);
                        break;
                    case 5:
                        h1.this.f4242a.showLogoEnabled(h1.this.f4250j);
                        break;
                    case 6:
                        h1.this.f4242a.refreshLogo();
                        break;
                }
            } catch (Throwable th2) {
                ka.a(th2, "UiSettingsDelegateImp", "handleMessage");
            }
        }
    }

    public h1(IAMapDelegate iAMapDelegate) {
        this.f4242a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public float getLogoMarginRate(int i3) {
        return this.f4242a.getLogoMarginRate(i3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getLogoPosition() throws RemoteException {
        return this.f4251k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public int getZoomPosition() throws RemoteException {
        return this.f4252l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isCompassEnabled() throws RemoteException {
        return this.f4248h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.f4255o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.f4253m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isLogoEnable() {
        return this.f4250j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f4243b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScaleControlsEnabled() throws RemoteException {
        return this.f4249i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isScrollGesturesEnabled() throws RemoteException {
        return this.f4244c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isTiltGesturesEnabled() throws RemoteException {
        return this.f4245d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomControlsEnabled() throws RemoteException {
        return this.f4247g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomGesturesEnabled() throws RemoteException {
        return this.f4246f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public boolean isZoomInByScreenCenter() {
        return this.f4254n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void requestRefreshLogo() {
        this.f4256p.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setAllGesturesEnabled(boolean z5) throws RemoteException {
        this.f4243b = z5;
        this.f4245d = z5;
        this.f4246f = z5;
        this.f4244c = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setCompassEnabled(boolean z5) throws RemoteException {
        this.f4248h = z5;
        this.f4256p.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setGestureScaleByMapCenter(boolean z5) throws RemoteException {
        this.f4255o = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setIndoorSwitchEnabled(boolean z5) throws RemoteException {
        this.f4253m = z5;
        this.f4256p.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoBottomMargin(int i3) {
        this.f4242a.setLogoBottomMargin(i3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoEnable(boolean z5) {
        this.f4250j = z5;
        this.f4256p.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoLeftMargin(int i3) {
        this.f4242a.setLogoLeftMargin(i3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoMarginRate(int i3, float f2) {
        this.f4242a.setLogoMarginRate(i3, f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setLogoPosition(int i3) throws RemoteException {
        this.f4251k = i3;
        this.f4242a.setLogoPosition(i3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setMyLocationButtonEnabled(boolean z5) throws RemoteException {
        this.e = z5;
        this.f4256p.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setRotateGesturesEnabled(boolean z5) throws RemoteException {
        this.f4243b = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScaleControlsEnabled(boolean z5) throws RemoteException {
        this.f4249i = z5;
        this.f4256p.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setScrollGesturesEnabled(boolean z5) throws RemoteException {
        this.f4244c = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setTiltGesturesEnabled(boolean z5) throws RemoteException {
        this.f4245d = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomControlsEnabled(boolean z5) throws RemoteException {
        this.f4247g = z5;
        this.f4256p.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomGesturesEnabled(boolean z5) throws RemoteException {
        this.f4246f = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomInByScreenCenter(boolean z5) {
        this.f4254n = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public void setZoomPosition(int i3) throws RemoteException {
        this.f4252l = i3;
        this.f4242a.setZoomPosition(i3);
    }
}
