package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.x6;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import com.google.mlkit.common.MlKitException;
import java.util.List;

/* loaded from: classes.dex */
public final class i8 implements IGeocodeSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f4292a;

    /* renamed from: b, reason: collision with root package name */
    private GeocodeSearch.OnGeocodeSearchListener f4293b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4294c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RegeocodeQuery f4295a;

        public a(RegeocodeQuery regeocodeQuery) {
            this.f4295a = regeocodeQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 2;
                    obtainMessage.what = MlKitException.CODE_SCANNER_CANCELLED;
                    x6.l lVar = new x6.l();
                    lVar.f5368b = i8.this.f4293b;
                    obtainMessage.obj = lVar;
                    lVar.f5367a = new RegeocodeResult(this.f4295a, i8.this.getFromLocation(this.f4295a));
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                i8.this.f4294c.sendMessage(obtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeocodeQuery f4297a;

        public b(GeocodeQuery geocodeQuery) {
            this.f4297a = geocodeQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = x6.a().obtainMessage();
            try {
                try {
                    obtainMessage.what = 200;
                    obtainMessage.arg1 = 2;
                    obtainMessage.arg2 = 1000;
                    x6.f fVar = new x6.f();
                    fVar.f5356b = i8.this.f4293b;
                    obtainMessage.obj = fVar;
                    fVar.f5355a = new GeocodeResult(this.f4297a, i8.this.getFromLocationName(this.f4297a));
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                i8.this.f4294c.sendMessage(obtainMessage);
            }
        }
    }

    public i8(Context context) throws AMapException {
        l9 a3 = k9.a(context, m6.a(false));
        if (a3.f4490a != k9.e.SuccessCode) {
            String str = a3.f4491b;
            throw new AMapException(str, 1, str, a3.f4490a.a());
        }
        this.f4292a = context.getApplicationContext();
        this.f4294c = x6.a();
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            v6.a(this.f4292a);
            if (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) {
                throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
            }
            return new p7(this.f4292a, regeocodeQuery).c();
        } catch (AMapException e) {
            d6.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public void getFromLocationAsyn(RegeocodeQuery regeocodeQuery) {
        try {
            u7.b().a(new a(regeocodeQuery));
        } catch (Throwable th2) {
            d6.a(th2, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            v6.a(this.f4292a);
            if (geocodeQuery != null) {
                return new s6(this.f4292a, geocodeQuery).c();
            }
            throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
        } catch (AMapException e) {
            d6.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public void getFromLocationNameAsyn(GeocodeQuery geocodeQuery) {
        try {
            u7.b().a(new b(geocodeQuery));
        } catch (Throwable th2) {
            d6.a(th2, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f4293b = onGeocodeSearchListener;
    }
}
