package com.amap.api.col.p0003sl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.map3d.R;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* loaded from: classes.dex */
public class a1 implements IMapFragmentDelegate {

    /* renamed from: f, reason: collision with root package name */
    public static volatile Context f3562f;

    /* renamed from: g, reason: collision with root package name */
    private static String f3563g;

    /* renamed from: a, reason: collision with root package name */
    private IAMap f3564a;

    /* renamed from: c, reason: collision with root package name */
    private int f3566c;

    /* renamed from: d, reason: collision with root package name */
    private AMapOptions f3567d;

    /* renamed from: b, reason: collision with root package name */
    public int f3565b = 0;
    boolean e = true;

    public a1(int i3) {
        this.f3566c = i3 % 3;
        a();
    }

    public void a(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.f3564a == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f3564a.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.f3564a.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.f3564a.setMapType(aMapOptions.getMapType());
        this.f3564a.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public IAMap getMap() throws RemoteException {
        if (this.f3564a == null) {
            if (f3562f == null) {
                Log.w("MapFragmentDelegateImp", n1.a(R.string.O105492_286));
                return null;
            }
            int i3 = f3562f.getResources().getDisplayMetrics().densityDpi;
            if (i3 <= 120) {
                v0.f5167b = 0.5f;
            } else if (i3 <= 160) {
                v0.f5167b = 0.8f;
            } else if (i3 <= 240) {
                v0.f5167b = 0.87f;
            } else if (i3 <= 320) {
                v0.f5167b = 1.0f;
            } else if (i3 <= 480) {
                v0.f5167b = 1.5f;
            } else if (i3 <= 640) {
                v0.f5167b = 1.8f;
            } else {
                v0.f5167b = 0.9f;
            }
            int i10 = this.f3566c;
            if (i10 == 0) {
                this.f3564a = new k0(f3562f, null, this.e).a();
            } else if (i10 == 1) {
                this.f3564a = new l0(f3562f, this.e).f();
            } else {
                this.f3564a = new j0(f3562f, null).a();
            }
        }
        return this.f3564a;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void loadWorldVectorMap(boolean z5) {
        this.e = z5;
        IAMap iAMap = this.f3564a;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z5);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (f3562f == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            IAMap map = getMap();
            this.f3564a = map;
            map.setVisibilityEx(this.f3565b);
            if (this.f3567d == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f3567d = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            a(this.f3567d);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return this.f3564a.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroy() throws RemoteException {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z5 = false;
            boolean z6 = false;
            boolean z8 = false;
            for (int i3 = 0; i3 < stackTrace.length; i3++) {
                if (stackTrace[i3].getClassName() != null && stackTrace[i3].getClassName().endsWith("TextureMapView")) {
                    z6 = true;
                }
                if (stackTrace[i3].getClassName() != null && stackTrace[i3].getClassName().endsWith("Fragment")) {
                    z5 = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i3].getMethodName())) {
                    z8 = true;
                }
            }
            if (z5 && z6 && !z8) {
                Log.i("errorLog", f3563g);
                Log.i("errorLog", "OnDestroy 方法需要在OnDestroyView中调用");
                Log.i("errorLog", f3563g);
            }
        } catch (Throwable unused) {
        }
        IAMap iAMap = this.f3564a;
        if (iAMap != null) {
            iAMap.destroy();
            this.f3564a = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity.getApplicationContext());
        this.f3567d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onPause() throws RemoteException {
        IAMap iAMap = this.f3564a;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onResume() throws RemoteException {
        IAMap iAMap = this.f3564a;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.f3564a != null) {
            if (this.f3567d == null) {
                this.f3567d = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                AMapOptions camera = this.f3567d.camera(getMap().getCameraPosition());
                this.f3567d = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setContext(Context context) {
        if (context != null) {
            f3562f = context.getApplicationContext();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setOptions(AMapOptions aMapOptions) {
        this.f3567d = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setUseForNavi(boolean z5) {
        IAMap iAMap = this.f3564a;
        if (iAMap != null) {
            iAMap.setUseForNavi(z5);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setVisibility(int i3) {
        this.f3565b = i3;
        IAMap iAMap = this.f3564a;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i3);
        }
    }

    private void a() {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i3 = 0; i3 < 80; i3++) {
                sb2.append("=");
            }
            f3563g = sb2.toString();
        } catch (Throwable unused) {
        }
    }
}
