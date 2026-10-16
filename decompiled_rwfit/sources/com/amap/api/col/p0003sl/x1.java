package com.amap.api.col.p0003sl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.ae.gmap.glyph.ReflectUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class x1 implements LocationSource {
    private Method A;
    private Method B;
    private Method C;
    private Method D;
    private Method E;
    private Method F;
    private Method G;
    private Method H;
    private Method I;
    private boolean J = false;
    private long K = 2000;
    private InvocationHandler L = new a();

    /* renamed from: a, reason: collision with root package name */
    private Context f5293a;

    /* renamed from: b, reason: collision with root package name */
    private LocationSource.OnLocationChangedListener f5294b;

    /* renamed from: c, reason: collision with root package name */
    private Object f5295c;

    /* renamed from: d, reason: collision with root package name */
    private Object f5296d;
    private Object e;

    /* renamed from: f, reason: collision with root package name */
    private Method f5297f;

    /* renamed from: g, reason: collision with root package name */
    private Method f5298g;

    /* renamed from: h, reason: collision with root package name */
    private Method f5299h;

    /* renamed from: i, reason: collision with root package name */
    private Method f5300i;

    /* renamed from: j, reason: collision with root package name */
    private Method f5301j;

    /* renamed from: k, reason: collision with root package name */
    private Method f5302k;

    /* renamed from: l, reason: collision with root package name */
    private Method f5303l;

    /* renamed from: m, reason: collision with root package name */
    private Method f5304m;

    /* renamed from: n, reason: collision with root package name */
    private Method f5305n;

    /* renamed from: o, reason: collision with root package name */
    private Method f5306o;

    /* renamed from: p, reason: collision with root package name */
    private Method f5307p;

    /* renamed from: q, reason: collision with root package name */
    private Method f5308q;
    private Method r;

    /* renamed from: s, reason: collision with root package name */
    private Method f5309s;

    /* renamed from: t, reason: collision with root package name */
    private Method f5310t;

    /* renamed from: u, reason: collision with root package name */
    private Method f5311u;

    /* renamed from: v, reason: collision with root package name */
    private Method f5312v;

    /* renamed from: w, reason: collision with root package name */
    private Method f5313w;

    /* renamed from: x, reason: collision with root package name */
    private Method f5314x;

    /* renamed from: y, reason: collision with root package name */
    private Method f5315y;

    /* renamed from: z, reason: collision with root package name */
    private Method f5316z;

    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!TextUtils.equals(method.getName(), "onLocationChanged") || x1.this.f5294b == null || objArr == null || objArr.length != 1) {
                return null;
            }
            Object obj2 = objArr[0];
            Location location = (Location) obj2;
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Object invokeMethod = ReflectUtil.invokeMethod(obj2, x1.this.f5307p, new Object[0]);
            if (invokeMethod instanceof Integer) {
                extras.putInt("errorCode", ((Integer) invokeMethod).intValue());
            }
            Object invokeMethod2 = ReflectUtil.invokeMethod(obj2, x1.this.f5308q, new Object[0]);
            if (invokeMethod2 instanceof String) {
                extras.putString("errorInfo", (String) invokeMethod2);
            }
            Object invokeMethod3 = ReflectUtil.invokeMethod(obj2, x1.this.r, new Object[0]);
            if (invokeMethod3 instanceof Integer) {
                extras.putInt("locationType", ((Integer) invokeMethod3).intValue());
            }
            Object invokeMethod4 = ReflectUtil.invokeMethod(obj2, x1.this.f5309s, new Object[0]);
            if (invokeMethod4 instanceof Float) {
                extras.putFloat("Accuracy", ((Float) invokeMethod4).floatValue());
            }
            Object invokeMethod5 = ReflectUtil.invokeMethod(obj2, x1.this.f5310t, new Object[0]);
            if (invokeMethod5 instanceof String) {
                extras.putString("AdCode", (String) invokeMethod5);
            }
            Object invokeMethod6 = ReflectUtil.invokeMethod(obj2, x1.this.f5311u, new Object[0]);
            if (invokeMethod6 instanceof String) {
                extras.putString("Address", (String) invokeMethod6);
            }
            Object invokeMethod7 = ReflectUtil.invokeMethod(obj2, x1.this.f5312v, new Object[0]);
            if (invokeMethod7 instanceof String) {
                extras.putString("AoiName", (String) invokeMethod7);
            }
            Object invokeMethod8 = ReflectUtil.invokeMethod(obj2, x1.this.f5313w, new Object[0]);
            if (invokeMethod8 instanceof String) {
                extras.putString("City", (String) invokeMethod8);
            }
            Object invokeMethod9 = ReflectUtil.invokeMethod(obj2, x1.this.f5314x, new Object[0]);
            if (invokeMethod9 instanceof String) {
                extras.putString("CityCode", (String) invokeMethod9);
            }
            Object invokeMethod10 = ReflectUtil.invokeMethod(obj2, x1.this.f5315y, new Object[0]);
            if (invokeMethod10 instanceof String) {
                extras.putString("Country", (String) invokeMethod10);
            }
            Object invokeMethod11 = ReflectUtil.invokeMethod(obj2, x1.this.f5316z, new Object[0]);
            if (invokeMethod11 instanceof String) {
                extras.putString("District", (String) invokeMethod11);
            }
            Object invokeMethod12 = ReflectUtil.invokeMethod(obj2, x1.this.A, new Object[0]);
            if (invokeMethod12 instanceof String) {
                extras.putString("Street", (String) invokeMethod12);
            }
            Object invokeMethod13 = ReflectUtil.invokeMethod(obj2, x1.this.B, new Object[0]);
            if (invokeMethod13 instanceof String) {
                extras.putString("StreetNum", (String) invokeMethod13);
            }
            Object invokeMethod14 = ReflectUtil.invokeMethod(obj2, x1.this.C, new Object[0]);
            if (invokeMethod14 instanceof String) {
                extras.putString("PoiName", (String) invokeMethod14);
            }
            Object invokeMethod15 = ReflectUtil.invokeMethod(obj2, x1.this.D, new Object[0]);
            if (invokeMethod15 instanceof String) {
                extras.putString("Province", (String) invokeMethod15);
            }
            Object invokeMethod16 = ReflectUtil.invokeMethod(obj2, x1.this.E, new Object[0]);
            if (invokeMethod16 instanceof Float) {
                extras.putFloat("Speed", ((Float) invokeMethod16).floatValue());
            }
            Object invokeMethod17 = ReflectUtil.invokeMethod(obj2, x1.this.F, new Object[0]);
            if (invokeMethod17 instanceof String) {
                extras.putString("Floor", (String) invokeMethod17);
            }
            Object invokeMethod18 = ReflectUtil.invokeMethod(obj2, x1.this.G, new Object[0]);
            if (invokeMethod18 instanceof Float) {
                extras.putFloat("Bearing", ((Float) invokeMethod18).floatValue());
            }
            Object invokeMethod19 = ReflectUtil.invokeMethod(obj2, x1.this.H, new Object[0]);
            if (invokeMethod19 instanceof String) {
                extras.putString("BuildingId", (String) invokeMethod19);
            }
            Object invokeMethod20 = ReflectUtil.invokeMethod(obj2, x1.this.I, new Object[0]);
            if (invokeMethod20 instanceof Double) {
                extras.putDouble("Altitude", ((Double) invokeMethod20).doubleValue());
            }
            location.setExtras(extras);
            x1.this.f5294b.onLocationChanged(location);
            return null;
        }
    }

    public x1(Context context) {
        this.f5293a = context;
        b();
        c();
        a();
    }

    @Override // com.amap.api.maps.LocationSource
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.f5294b = onLocationChangedListener;
        if (k9.a(this.f5293a, v4.b()).f4490a == k9.e.SuccessCode && this.f5295c == null) {
            try {
                Object newInstance = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f5293a});
                this.f5295c = newInstance;
                if (newInstance == null) {
                    return;
                }
                this.f5296d = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClientOption", null, null);
                Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{AMapLocationListener.class}, this.L);
                this.e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f5295c, this.f5297f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f5296d, this.f5302k, Long.valueOf(this.K));
                ReflectUtil.invokeMethod(this.f5296d, this.f5303l, Boolean.valueOf(this.J));
                ReflectUtil.invokeMethod(this.f5296d, this.f5304m, ReflectUtil.getField("com.amap.api.location.AMapLocationClientOption$AMapLocationMode", null, "Hight_Accuracy"));
                ReflectUtil.invokeMethod(this.f5296d, this.f5305n, Boolean.FALSE);
                ReflectUtil.invokeMethod(this.f5295c, this.f5298g, this.f5296d);
                ReflectUtil.invokeMethod(this.f5295c, this.f5299h, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public void deactivate() {
        this.f5294b = null;
        Object obj = this.f5295c;
        if (obj != null) {
            ReflectUtil.invokeMethod(obj, this.f5300i, new Object[0]);
            ReflectUtil.invokeMethod(this.f5295c, this.f5301j, new Object[0]);
        }
        this.f5295c = null;
    }

    private void b() {
        try {
            this.f5297f = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationListener", AMapLocationListener.class);
            String str = AMapLocationClientOption.APIKEY;
            this.f5298g = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationOption", AMapLocationClientOption.class);
            this.f5299h = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "startLocation", new Class[0]);
            this.f5300i = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "stopLocation", new Class[0]);
            this.f5301j = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "onDestroy", new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        try {
            this.f5302k = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setInterval", Long.TYPE);
            Class cls = Boolean.TYPE;
            this.f5303l = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setOnceLocation", cls);
            AMapLocationClientOption.AMapLocationMode aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
            this.f5304m = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setLocationMode", AMapLocationClientOption.AMapLocationMode.class);
            this.f5305n = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setNeedAddress", cls);
            this.f5306o = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "getInterval", new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(long j4) {
        Object obj = this.f5296d;
        if (obj != null && this.f5295c != null) {
            Object invokeMethod = ReflectUtil.invokeMethod(obj, this.f5306o, new Object[0]);
            if ((invokeMethod instanceof Long) && ((Long) invokeMethod).longValue() != j4) {
                ReflectUtil.invokeMethod(this.f5296d, this.f5302k, Long.valueOf(j4));
                ReflectUtil.invokeMethod(this.f5295c, this.f5298g, this.f5296d);
            }
        }
        this.K = j4;
    }

    public void a(int i3) {
        if (i3 != 1 && i3 != 0) {
            a(false);
        } else {
            a(true);
        }
    }

    private void a(boolean z5) {
        Object obj;
        if (this.f5296d != null && (obj = this.f5295c) != null) {
            try {
                ReflectUtil.invokeMethod(obj, this.f5301j, new Object[0]);
                this.f5295c = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f5293a});
                Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{AMapLocationListener.class}, this.L);
                this.e = newProxyInstance;
                ReflectUtil.invokeMethod(this.f5295c, this.f5297f, newProxyInstance);
                ReflectUtil.invokeMethod(this.f5296d, this.f5303l, Boolean.valueOf(z5));
                ReflectUtil.invokeMethod(this.f5296d, this.f5305n, Boolean.FALSE);
                if (!z5) {
                    ReflectUtil.invokeMethod(this.f5296d, this.f5302k, Long.valueOf(this.K));
                }
                ReflectUtil.invokeMethod(this.f5295c, this.f5298g, this.f5296d);
                ReflectUtil.invokeMethod(this.f5295c, this.f5299h, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.J = z5;
    }

    private void a() {
        try {
            this.f5307p = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorCode", new Class[0]);
            this.f5308q = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorInfo", new Class[0]);
            this.r = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getLocationType", new Class[0]);
            this.f5309s = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAccuracy", new Class[0]);
            this.f5310t = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAdCode", new Class[0]);
            this.f5311u = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAddress", new Class[0]);
            this.f5312v = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAoiName", new Class[0]);
            this.f5313w = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCity", new Class[0]);
            this.f5314x = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCityCode", new Class[0]);
            this.f5315y = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCountry", new Class[0]);
            this.f5316z = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getDistrict", new Class[0]);
            this.A = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreet", new Class[0]);
            this.B = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreetNum", new Class[0]);
            this.C = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getPoiName", new Class[0]);
            this.D = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getProvince", new Class[0]);
            this.E = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getSpeed", new Class[0]);
            this.F = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getFloor", new Class[0]);
            this.G = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBearing", new Class[0]);
            this.H = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBuildingId", new Class[0]);
            this.I = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAltitude", new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
