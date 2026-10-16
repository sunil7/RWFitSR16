package com.amap.api.col.p0003sl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class y8 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile y8 f5465b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f5466a;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        private int f5467a;

        /* renamed from: b, reason: collision with root package name */
        private int f5468b;

        /* renamed from: d, reason: collision with root package name */
        private int f5470d;

        /* renamed from: f, reason: collision with root package name */
        private HashMap<Integer, List<LatLng>> f5471f;

        /* renamed from: c, reason: collision with root package name */
        private int f5469c = 0;
        private int e = 0;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLng> f5472g = new ArrayList();

        public a(int i3, int i10, int i11, HashMap<Integer, List<LatLng>> hashMap) {
            this.f5467a = 0;
            this.f5468b = 0;
            this.f5470d = 0;
            this.f5467a = i10;
            this.f5471f = hashMap;
            this.f5468b = i3;
            this.f5470d = i11;
        }

        public HashMap<Integer, List<LatLng>> a() {
            return this.f5471f;
        }

        public void a(Handler handler) {
            List<LatLng> list;
            for (int i3 = this.f5469c; i3 <= this.f5467a && (list = this.f5471f.get(Integer.valueOf(i3))) != null; i3++) {
                this.f5472g.addAll(list);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = list;
                obtainMessage.what = 100;
                obtainMessage.arg1 = this.f5469c;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.f5468b);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                this.f5469c++;
                this.e++;
            }
            if (this.f5469c == this.f5467a + 1) {
                if (this.e <= 0) {
                    y8.this.a(handler, this.f5468b, LBSTraceClient.MIN_GRASP_POINT_ERROR);
                    return;
                }
                List<LatLng> list2 = this.f5472g;
                int i10 = 0;
                if (list2 != null && list2.size() != 0) {
                    int i11 = 0;
                    while (i10 < list2.size() - 1) {
                        LatLng latLng = list2.get(i10);
                        i10++;
                        LatLng latLng2 = list2.get(i10);
                        if (latLng == null || latLng2 == null) {
                            break;
                        } else {
                            i11 = (int) (AMapUtils.calculateLineDistance(latLng, latLng2) + i11);
                        }
                    }
                    i10 = i11;
                }
                Message obtainMessage2 = handler.obtainMessage();
                obtainMessage2.obj = this.f5472g;
                obtainMessage2.what = 101;
                obtainMessage2.arg1 = i10;
                obtainMessage2.arg2 = this.f5470d;
                Bundle bundle2 = new Bundle();
                bundle2.putInt("lineID", this.f5468b);
                obtainMessage2.setData(bundle2);
                handler.sendMessage(obtainMessage2);
            }
        }
    }

    public y8() {
        this.f5466a = null;
        this.f5466a = Collections.synchronizedMap(new HashMap());
    }

    public static y8 a() {
        if (f5465b == null) {
            synchronized (y8.class) {
                try {
                    if (f5465b == null) {
                        f5465b = new y8();
                    }
                } finally {
                }
            }
        }
        return f5465b;
    }

    public synchronized void a(String str, int i3, List<LatLng> list) {
        Map<String, a> map = this.f5466a;
        if (map != null) {
            map.get(str).a().put(Integer.valueOf(i3), list);
        }
    }

    public synchronized void a(String str, int i3, int i10, int i11) {
        try {
            try {
                Map<String, a> map = this.f5466a;
                if (map != null) {
                    map.put(str, new a(i3, i10, i11, new HashMap(16)));
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            throw th;
        }
    }

    public synchronized a a(String str) {
        Map<String, a> map = this.f5466a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public void a(Handler handler, int i3, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i3);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }
}
