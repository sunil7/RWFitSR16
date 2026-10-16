package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.u4;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@JBindingInclude
/* loaded from: classes.dex */
public class NetworkProxyManager {
    private static NetworkProxyManager sInstance;
    private Context context;
    private WeakReference<IAMapDelegate> mapDelegate;
    private NetworkProxy networkProxy;
    private NetworkState networkState;
    private String userAgent;
    private boolean isNetworkConnected = false;
    private Map<Long, AMapLoader> aMapLoaderHashtable = new ConcurrentHashMap();
    private Map<Long, GLMapEngine> engines = new ConcurrentHashMap();
    private boolean isOversea = false;
    private NetworkState.NetworkChangeListener networkChangeListener = new NetworkState.NetworkChangeListener() { // from class: com.autonavi.base.ae.gmap.NetworkProxyManager.1
        @Override // com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener
        public void networkStateChanged(Context context) {
            NetworkProxyManager.this.isNetworkConnected = NetworkState.isNetworkConnected(context);
            Iterator it = NetworkProxyManager.this.engines.entrySet().iterator();
            while (it.hasNext()) {
                ((GLMapEngine) ((Map.Entry) it.next()).getValue()).setNetStatus(NetworkProxyManager.this.isNetworkConnected);
            }
        }
    };

    private synchronized void cancelAllAMapDownload() {
        try {
            Iterator it = new ConcurrentHashMap(this.aMapLoaderHashtable).entrySet().iterator();
            while (it.hasNext()) {
                ((AMapLoader) ((Map.Entry) it.next()).getValue()).doCancelAndNotify();
            }
        } finally {
        }
    }

    private void initNetworkState() {
        this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(this.context);
        NetworkState networkState = new NetworkState();
        this.networkState = networkState;
        networkState.setNetworkListener(this.networkChangeListener);
        this.networkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        this.isNetworkConnected = NetworkState.isNetworkConnected(this.context.getApplicationContext());
    }

    private static native void nativeCancelDownLoad(long j4);

    private static native long nativeCreateNetworkProxy(Object obj);

    private static native void nativeDestroyNetworkProxy(long j4);

    private static native void nativeFailedDownLoad(long j4, int i3);

    private static native void nativeFinishDownLoad(long j4);

    private static native void nativeInitNetworkProxy(long j4);

    private static native void nativeReceiveNetData(byte[] bArr, long j4, int i3);

    private static native void nativeSetOverseaEnable(long j4, boolean z5);

    private void releaseNetworkState() {
        NetworkState networkState = this.networkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.networkState.setNetworkListener(null);
            this.networkState = null;
        }
    }

    public NetworkProxy createNetworkProxy() {
        return new NetworkProxy(nativeCreateNetworkProxy(this));
    }

    public void destroy() {
        NetworkProxy networkProxy = this.networkProxy;
        if (networkProxy != null) {
            destroyNetworkProxy(networkProxy);
            this.networkProxy = null;
        }
        releaseNetworkState();
        this.context = null;
    }

    public void destroyNetworkProxy(NetworkProxy networkProxy) {
        nativeDestroyNetworkProxy(networkProxy.networkProxyInstance);
    }

    public synchronized void finishDownLoad(long j4) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFinishDownLoad(j4);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
        }
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void init() {
        NetworkProxy createNetworkProxy = createNetworkProxy();
        this.networkProxy = createNetworkProxy;
        initNetworkProxy(createNetworkProxy);
        initNetworkState();
    }

    public void initContext(Context context) {
        if (context == null) {
            return;
        }
        this.context = context.getApplicationContext();
    }

    public void initNetworkProxy(NetworkProxy networkProxy) {
        nativeInitNetworkProxy(networkProxy.networkProxyInstance);
    }

    public boolean isLocationOversea() {
        return this.isOversea;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    public boolean isOverseaAuthed() {
        IAMapDelegate iAMapDelegate = this.mapDelegate.get();
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.isOverseaAuthed();
    }

    public boolean isReady() {
        return (this.context == null || this.networkProxy == null || this.networkState == null) ? false : true;
    }

    public synchronized void netCancel(long j4, int i3) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFailedDownLoad(j4, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
        }
    }

    public synchronized void netError(long j4, int i3, int i10) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFailedDownLoad(j4, i10);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
            try {
                if (MapsInitializer.getExceptionLogger() != null) {
                    MapsInitializer.getExceptionLogger().onDownloaderException(i3, i10);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void netStop(long j4, int i3) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeFailedDownLoad(j4, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j4));
        }
    }

    public void notifyMapEngineCreated(long j4, GLMapEngine gLMapEngine, IAMapDelegate iAMapDelegate) {
        this.mapDelegate = new WeakReference<>(iAMapDelegate);
        this.engines.put(Long.valueOf(j4), gLMapEngine);
    }

    public void notifyMapEngineDestroyed(long j4) {
        this.engines.remove(Long.valueOf(j4));
        cancelAllAMapDownload();
    }

    public synchronized void receiveNetData(long j4, byte[] bArr, int i3) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j4))) {
            nativeReceiveNetData(bArr, j4, i3);
        }
    }

    public synchronized int requireMapDataAsyn(int i3, byte[] bArr) {
        if (bArr != null) {
            try {
                AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
                int i10 = GLConvertUtil.getInt(bArr, 0);
                aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i10);
                int i11 = GLConvertUtil.getInt(bArr, i10 + 4);
                int i12 = i10 + 8;
                aDataRequestParam.requestUrl = GLConvertUtil.getSubBytes(bArr, i12, i11);
                int i13 = i12 + i11;
                int i14 = GLConvertUtil.getInt(bArr, i13);
                int i15 = i13 + 4;
                aDataRequestParam.headers = v4.a(GLConvertUtil.getString(bArr, i15, i14), "=>");
                int i16 = i15 + i14;
                int i17 = GLConvertUtil.getInt(bArr, i16);
                int i18 = i16 + 4;
                aDataRequestParam.queries = v4.a(GLConvertUtil.getString(bArr, i18, i17), "=>");
                int i19 = i18 + i17;
                int i20 = GLConvertUtil.getInt(bArr, i19);
                int i21 = i19 + 4;
                String string = GLConvertUtil.getString(bArr, i21, i20);
                ArrayList arrayList = new ArrayList();
                for (String str : string.split(Const.STR_MART_ADD)) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
                aDataRequestParam.signs = arrayList;
                int i22 = i21 + i20;
                aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i22);
                int i23 = GLConvertUtil.getInt(bArr, i22 + 8);
                int i24 = i22 + 12;
                aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i24, i23);
                int i25 = i24 + i23;
                aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i25);
                aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i25 + 4);
                aDataRequestParam.bodyType = GLConvertUtil.getInt(bArr, i25 + 8);
                final AMapLoader aMapLoader = new AMapLoader(this.context, aDataRequestParam, this);
                this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
                try {
                    u4.b().a(new rc() { // from class: com.autonavi.base.ae.gmap.NetworkProxyManager.2
                        @Override // com.amap.api.col.p0003sl.rc
                        public void runTask() {
                            try {
                                aMapLoader.doRequest();
                            } catch (Throwable th2) {
                                ka.a(th2, "download Thread", "AMapLoader doRequest");
                                v4.a(th2);
                            }
                        }
                    });
                } catch (Throwable th2) {
                    ka.a(th2, "download Thread", "requireMapData");
                    v4.a(th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return 0;
    }

    public void setLocationOversea(boolean z5) {
        this.isOversea = z5;
    }

    public void setOverseaEnable(boolean z5) {
        NetworkProxy networkProxy = this.networkProxy;
        if (networkProxy != null) {
            long j4 = networkProxy.networkProxyInstance;
            if (j4 == 0) {
                return;
            }
            nativeSetOverseaEnable(j4, z5);
        }
    }
}
