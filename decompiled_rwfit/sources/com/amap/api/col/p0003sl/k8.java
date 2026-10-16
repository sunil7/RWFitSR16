package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class k8 implements INearbySearch {

    /* renamed from: l, reason: collision with root package name */
    private static long f4370l;

    /* renamed from: b, reason: collision with root package name */
    private String f4372b;

    /* renamed from: c, reason: collision with root package name */
    private Context f4373c;

    /* renamed from: d, reason: collision with root package name */
    private x6 f4374d;
    private ExecutorService e;

    /* renamed from: j, reason: collision with root package name */
    private UploadInfoCallback f4379j;

    /* renamed from: k, reason: collision with root package name */
    private TimerTask f4380k;

    /* renamed from: a, reason: collision with root package name */
    private List<NearbySearch.NearbyListener> f4371a = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f4375f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f4376g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4377h = false;

    /* renamed from: i, reason: collision with root package name */
    private Timer f4378i = new Timer();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = k8.this.f4374d.obtainMessage();
            obtainMessage.arg1 = 8;
            obtainMessage.obj = k8.this.f4371a;
            try {
                try {
                    k8.c(k8.this);
                    obtainMessage.what = 1000;
                    if (k8.this.f4374d == null) {
                        return;
                    }
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                    d6.a(e, "NearbySearch", "clearUserInfoAsyn");
                    if (k8.this.f4374d == null) {
                        return;
                    }
                }
                k8.this.f4374d.sendMessage(obtainMessage);
            } catch (Throwable th2) {
                if (k8.this.f4374d != null) {
                    k8.this.f4374d.sendMessage(obtainMessage);
                }
                throw th2;
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadInfo f4382a;

        public b(UploadInfo uploadInfo) {
            this.f4382a = uploadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Message obtainMessage = k8.this.f4374d.obtainMessage();
                obtainMessage.arg1 = 10;
                obtainMessage.obj = k8.this.f4371a;
                obtainMessage.what = k8.a(k8.this, this.f4382a);
                k8.this.f4374d.sendMessage(obtainMessage);
            } catch (Throwable th2) {
                d6.a(th2, "NearbySearch", "uploadNearbyInfoAsyn");
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NearbySearch.NearbyQuery f4384a;

        public c(NearbySearch.NearbyQuery nearbyQuery) {
            this.f4384a = nearbyQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = k8.this.f4374d.obtainMessage();
            obtainMessage.arg1 = 9;
            x6.g gVar = new x6.g();
            gVar.f5357a = k8.this.f4371a;
            obtainMessage.obj = gVar;
            try {
                try {
                    gVar.f5358b = k8.this.searchNearbyInfo(this.f4384a);
                    obtainMessage.what = 1000;
                    if (k8.this.f4374d == null) {
                        return;
                    }
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                    d6.a(e, "NearbySearch", "searchNearbyInfoAsyn");
                    if (k8.this.f4374d == null) {
                        return;
                    }
                }
                k8.this.f4374d.sendMessage(obtainMessage);
            } catch (Throwable th2) {
                if (k8.this.f4374d != null) {
                    k8.this.f4374d.sendMessage(obtainMessage);
                }
                throw th2;
            }
        }
    }

    public class d extends TimerTask {
        private d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (k8.this.f4379j != null) {
                    int a3 = k8.this.a(k8.this.f4379j.OnUploadInfoCallback());
                    Message obtainMessage = k8.this.f4374d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = k8.this.f4371a;
                    obtainMessage.what = a3;
                    k8.this.f4374d.sendMessage(obtainMessage);
                }
            } catch (Throwable th2) {
                d6.a(th2, "NearbySearch", "UpdateDataTask");
            }
        }

        public /* synthetic */ d(k8 k8Var, a aVar) {
            this();
        }
    }

    public k8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4373c = context.getApplicationContext();
        this.f4374d = x6.a();
    }

    public static int c(k8 k8Var) throws AMapException {
        k8Var.getClass();
        try {
            if (k8Var.f4377h) {
                throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
            }
            String str = k8Var.f4372b;
            if (!(TextUtils.isEmpty(str) ? false : Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find())) {
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            v6.a(k8Var.f4373c);
            return new y6(k8Var.f4373c, k8Var.f4372b).c().intValue();
        } catch (AMapException e) {
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f4371a.add(nearbyListener);
        } finally {
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void clearUserInfoAsyn() {
        try {
            u7.b().a(new a());
        } catch (Throwable th2) {
            d6.a(th2, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void destroy() {
        try {
            this.f4378i.cancel();
        } finally {
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.f4371a.remove(nearbyListener);
        } finally {
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            v6.a(this.f4373c);
            if (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            return new z6(this.f4373c, nearbyQuery).c();
        } catch (AMapException e) {
            throw e;
        } catch (Throwable th2) {
            d6.a(th2, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void searchNearbyInfoAsyn(NearbySearch.NearbyQuery nearbyQuery) {
        try {
            u7.b().a(new c(nearbyQuery));
        } catch (Throwable th2) {
            d6.a(th2, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void setUserID(String str) {
        this.f4372b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i3) {
        TimerTask timerTask;
        if (i3 < 7000) {
            i3 = 7000;
        }
        try {
            this.f4379j = uploadInfoCallback;
            if (this.f4377h && (timerTask = this.f4380k) != null) {
                timerTask.cancel();
            }
            this.f4377h = true;
            d dVar = new d(this, null);
            this.f4380k = dVar;
            this.f4378i.schedule(dVar, 0L, i3);
        } finally {
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public synchronized void stopUploadNearbyInfoAuto() {
        try {
            TimerTask timerTask = this.f4380k;
            if (timerTask != null) {
                timerTask.cancel();
            }
        } finally {
            this.f4377h = false;
            this.f4380k = null;
        }
        this.f4377h = false;
        this.f4380k = null;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        if (this.e == null) {
            this.e = Executors.newSingleThreadExecutor();
        }
        this.e.submit(new b(uploadInfo));
    }

    public static int a(k8 k8Var, UploadInfo uploadInfo) {
        return k8Var.f4377h ? AMapException.CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR : k8Var.a(uploadInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        try {
            v6.a(this.f4373c);
            if (uploadInfo == null) {
                return AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
            }
            long time = new Date().getTime();
            if (time - f4370l < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            f4370l = time;
            String userID = uploadInfo.getUserID();
            if (!(TextUtils.isEmpty(userID) ? false : Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(userID).find())) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            if (TextUtils.isEmpty(this.f4376g)) {
                this.f4376g = userID;
            }
            if (!userID.equals(this.f4376g)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point != null && !point.equals(this.f4375f)) {
                new a7(this.f4373c, uploadInfo).c();
                this.f4375f = point.copy();
                return 1000;
            }
            return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
        } catch (AMapException e) {
            return e.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }
}
