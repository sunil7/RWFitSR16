package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003sl.a2;
import com.amap.api.col.p0003sl.e2;
import com.amap.api.col.p0003sl.i9;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.l9;
import com.amap.api.col.p0003sl.n1;
import com.amap.api.col.p0003sl.t4;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.col.p0003sl.z1;
import com.amap.api.map3d.R;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class OfflineMapManager {

    /* renamed from: a, reason: collision with root package name */
    private Context f5792a;

    /* renamed from: b, reason: collision with root package name */
    private OfflineMapDownloadListener f5793b;

    /* renamed from: c, reason: collision with root package name */
    private OfflineLoadedListener f5794c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f5795d;
    private Handler e;

    /* renamed from: f, reason: collision with root package name */
    e2 f5796f;

    /* renamed from: g, reason: collision with root package name */
    a2 f5797g;

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z5, String str);

        void onDownload(int i3, int i10, String str);

        void onRemove(boolean z5, String str, String str2);
    }

    public class a implements a2.d {

        /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$a$a, reason: collision with other inner class name */
        public class RunnableC0012a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ z1 f5799a;

            public RunnableC0012a(z1 z1Var) {
                this.f5799a = z1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    OfflineMapManager.this.f5793b.onDownload(this.f5799a.k().e(), this.f5799a.getcompleteCode(), this.f5799a.getCity());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ z1 f5801a;

            public b(z1 z1Var) {
                this.f5801a = z1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!this.f5801a.k().equals(this.f5801a.f5530q) && !this.f5801a.k().equals(this.f5801a.f5524k)) {
                        OfflineMapManager.this.f5793b.onCheckUpdate(false, this.f5801a.getCity());
                        return;
                    }
                    OfflineMapManager.this.f5793b.onCheckUpdate(true, this.f5801a.getCity());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ z1 f5803a;

            public c(z1 z1Var) {
                this.f5803a = z1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.f5803a.k().equals(this.f5803a.f5524k)) {
                        OfflineMapManager.this.f5793b.onRemove(true, this.f5803a.getCity(), "");
                    } else {
                        OfflineMapManager.this.f5793b.onRemove(false, this.f5803a.getCity(), "");
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    OfflineMapManager.this.f5794c.onVerifyComplete();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        public a() {
        }

        @Override // com.amap.api.col.3sl.a2.d
        public void a(z1 z1Var) {
            if (OfflineMapManager.this.f5793b != null) {
                OfflineMapManager.this.f5795d.post(new RunnableC0012a(z1Var));
            }
        }

        @Override // com.amap.api.col.3sl.a2.d
        public void b(z1 z1Var) {
            if (OfflineMapManager.this.f5793b == null || z1Var == null) {
                return;
            }
            OfflineMapManager.this.f5795d.post(new b(z1Var));
        }

        @Override // com.amap.api.col.3sl.a2.d
        public void c(z1 z1Var) {
            if (OfflineMapManager.this.f5793b == null || z1Var == null) {
                return;
            }
            OfflineMapManager.this.f5795d.post(new c(z1Var));
        }

        @Override // com.amap.api.col.3sl.a2.d
        public void onVerifyComplete() {
            if (OfflineMapManager.this.f5794c != null) {
                OfflineMapManager.this.f5795d.post(new d());
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5806a;

        public b(String str) {
            this.f5806a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                OfflineMapManager.this.f5797g.g(this.f5806a);
            } catch (AMapException e) {
                ka.a(e, "OfflineMapManager", "downloadByProvinceName");
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5808a;

        public c(String str) {
            this.f5808a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            OfflineMapManager.this.f5797g.f(this.f5808a);
        }
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) throws Exception {
        l9 a3 = k9.a(context, v4.b());
        if (a3.f4490a != k9.e.SuccessCode) {
            throw new Exception(a3.f4491b);
        }
        this.f5793b = offlineMapDownloadListener;
        this.f5792a = context.getApplicationContext();
        this.f5795d = new Handler(this.f5792a.getMainLooper());
        this.e = new Handler(this.f5792a.getMainLooper());
        a(context);
        i9.a().a(this.f5792a);
    }

    public void destroy() {
        try {
            a2 a2Var = this.f5797g;
            if (a2Var != null) {
                a2Var.a();
            }
            this.f5793b = null;
            Handler handler = this.f5795d;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f5795d = null;
            Handler handler2 = this.e;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.e = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void downloadByCityCode(String str) throws AMapException {
        try {
            this.f5797g.h(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void downloadByCityName(String str) throws AMapException {
        try {
            this.f5797g.g(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void downloadByProvinceName(String str) throws AMapException {
        try {
            if (!v4.d(this.f5792a)) {
                throw new AMapException(AMapException.ERROR_CONNECTION);
            }
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
            }
            ArrayList<OfflineMapCity> cityList = itemByProvinceName.getCityList();
            int size = cityList.size();
            int i3 = 0;
            while (i3 < size) {
                OfflineMapCity offlineMapCity = cityList.get(i3);
                i3++;
                this.e.post(new b(offlineMapCity.getCity()));
            }
        } catch (Throwable th2) {
            if (th2 instanceof AMapException) {
                throw th2;
            }
            ka.a(th2, "OfflineMapManager", "downloadByProvinceName");
        }
    }

    public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        ArrayList<OfflineMapCity> arrayList;
        e2 e2Var = this.f5796f;
        synchronized (e2Var.f3956a) {
            try {
                arrayList = new ArrayList<>();
                ArrayList<OfflineMapProvince> arrayList2 = e2Var.f3956a;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList2.get(i3);
                    i3++;
                    OfflineMapProvince offlineMapProvince2 = offlineMapProvince;
                    if (offlineMapProvince2 != null) {
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        int size2 = cityList.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            OfflineMapCity offlineMapCity = cityList.get(i10);
                            i10++;
                            OfflineMapCity offlineMapCity2 = offlineMapCity;
                            if (offlineMapCity2.getState() != 4 && offlineMapCity2.getState() != 7) {
                            }
                            arrayList.add(offlineMapCity2);
                        }
                    }
                }
            } finally {
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        ArrayList<OfflineMapProvince> arrayList;
        e2 e2Var = this.f5796f;
        synchronized (e2Var.f3956a) {
            try {
                arrayList = new ArrayList<>();
                ArrayList<OfflineMapProvince> arrayList2 = e2Var.f3956a;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList2.get(i3);
                    i3++;
                    OfflineMapProvince offlineMapProvince2 = offlineMapProvince;
                    if (offlineMapProvince2 != null) {
                        if (offlineMapProvince2.getState() != 4 && offlineMapProvince2.getState() != 7) {
                        }
                        arrayList.add(offlineMapProvince2);
                    }
                }
            } finally {
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        ArrayList<OfflineMapCity> arrayList;
        e2 e2Var = this.f5796f;
        synchronized (e2Var.f3956a) {
            try {
                arrayList = new ArrayList<>();
                ArrayList<OfflineMapProvince> arrayList2 = e2Var.f3956a;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList2.get(i3);
                    i3++;
                    OfflineMapProvince offlineMapProvince2 = offlineMapProvince;
                    if (offlineMapProvince2 != null) {
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        int size2 = cityList.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            OfflineMapCity offlineMapCity = cityList.get(i10);
                            i10++;
                            OfflineMapCity offlineMapCity2 = offlineMapCity;
                            if (e2Var.a(offlineMapCity2.getState())) {
                                arrayList.add(offlineMapCity2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        ArrayList<OfflineMapProvince> arrayList;
        e2 e2Var = this.f5796f;
        synchronized (e2Var.f3956a) {
            try {
                arrayList = new ArrayList<>();
                ArrayList<OfflineMapProvince> arrayList2 = e2Var.f3956a;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList2.get(i3);
                    i3++;
                    OfflineMapProvince offlineMapProvince2 = offlineMapProvince;
                    if (offlineMapProvince2 != null && e2Var.a(offlineMapProvince2.getState())) {
                        arrayList.add(offlineMapProvince2);
                    }
                }
            } finally {
            }
        }
        return arrayList;
    }

    public OfflineMapCity getItemByCityCode(String str) {
        e2 e2Var = this.f5796f;
        e2Var.getClass();
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (e2Var.f3956a) {
            try {
                ArrayList<OfflineMapProvince> arrayList = e2Var.f3956a;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList.get(i3);
                    i3++;
                    ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
                    int size2 = cityList.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        OfflineMapCity offlineMapCity = cityList.get(i10);
                        i10++;
                        OfflineMapCity offlineMapCity2 = offlineMapCity;
                        if (offlineMapCity2.getCode().equals(str)) {
                            return offlineMapCity2;
                        }
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public OfflineMapCity getItemByCityName(String str) {
        e2 e2Var = this.f5796f;
        e2Var.getClass();
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (e2Var.f3956a) {
            try {
                ArrayList<OfflineMapProvince> arrayList = e2Var.f3956a;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList.get(i3);
                    i3++;
                    ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
                    int size2 = cityList.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        OfflineMapCity offlineMapCity = cityList.get(i10);
                        i10++;
                        OfflineMapCity offlineMapCity2 = offlineMapCity;
                        if (offlineMapCity2.getCity().trim().equalsIgnoreCase(str.trim())) {
                            return offlineMapCity2;
                        }
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public OfflineMapProvince getItemByProvinceName(String str) {
        return this.f5796f.a(str);
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        e2 e2Var = this.f5796f;
        e2Var.getClass();
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (e2Var.f3956a) {
            try {
                ArrayList<OfflineMapProvince> arrayList2 = e2Var.f3956a;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList2.get(i3);
                    i3++;
                    ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
                    int size2 = cityList.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        OfflineMapCity offlineMapCity = cityList.get(i10);
                        i10++;
                        arrayList.add(offlineMapCity);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f5796f.b();
    }

    public void pause() {
        this.f5797g.d();
    }

    public void pauseByName(String str) {
        this.f5797g.e(str);
    }

    public void remove(String str) {
        try {
            if (this.f5797g.d(str)) {
                this.f5797g.f(str);
                return;
            }
            OfflineMapProvince a3 = this.f5796f.a(str);
            int i3 = 0;
            if (a3 != null && a3.getCityList() != null) {
                ArrayList<OfflineMapCity> cityList = a3.getCityList();
                int size = cityList.size();
                while (i3 < size) {
                    OfflineMapCity offlineMapCity = cityList.get(i3);
                    i3++;
                    this.e.post(new c(offlineMapCity.getCity()));
                }
                return;
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.f5793b;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, n1.a(R.string.O105492_84));
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void restart() {
    }

    public void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.f5794c = offlineLoadedListener;
    }

    public void stop() {
        this.f5797g.c();
    }

    public void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.f5797g.a(itemByCityCode.getCity());
    }

    public void updateOfflineCityByName(String str) throws AMapException {
        this.f5797g.a(str);
    }

    public void updateOfflineMapProvinceByName(String str) throws AMapException {
        this.f5797g.a(str);
    }

    private void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5792a = applicationContext;
        a2.f3569o = false;
        a2 a3 = a2.a(applicationContext);
        this.f5797g = a3;
        a3.a(new a());
        try {
            this.f5797g.b();
            this.f5796f = this.f5797g.f3581k;
            t4.d(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f5793b = offlineMapDownloadListener;
        this.f5792a = context.getApplicationContext();
        this.f5795d = new Handler(this.f5792a.getMainLooper());
        this.e = new Handler(this.f5792a.getMainLooper());
        try {
            a(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
