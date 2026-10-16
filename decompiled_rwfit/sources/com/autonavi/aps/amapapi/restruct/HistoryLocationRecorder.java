package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.h9;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.utils.Utils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import k3.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HistoryLocationRecorder {

    /* renamed from: b, reason: collision with root package name */
    private File f6698b;

    /* renamed from: d, reason: collision with root package name */
    private Handler f6700d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6701f;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<HistoryLocation> f6697a = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f6699c = false;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f6702g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder.1
        @Override // java.lang.Runnable
        public void run() {
            if (HistoryLocationRecorder.this.f6699c) {
                return;
            }
            if (HistoryLocationRecorder.this.f6701f) {
                HistoryLocationRecorder.c(HistoryLocationRecorder.this);
                HistoryLocationRecorder.this.f6701f = false;
            }
            if (HistoryLocationRecorder.this.f6700d != null) {
                HistoryLocationRecorder.this.f6700d.postDelayed(HistoryLocationRecorder.this.f6702g, 60000L);
            }
        }
    };

    public HistoryLocationRecorder(Context context, Handler handler) {
        this.e = null;
        this.f6700d = handler;
        String path = context.getFilesDir().getPath();
        if (this.e == null) {
            this.e = Utils.getPackageNameMD5(context);
        }
        try {
            this.f6698b = new File(path, "hisloc");
        } catch (Throwable unused) {
        }
        a();
        Handler handler2 = this.f6700d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.f6702g);
            this.f6700d.postDelayed(this.f6702g, 60000L);
        }
    }

    public static void c(HistoryLocationRecorder historyLocationRecorder) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<HistoryLocation> it = historyLocationRecorder.f6697a.iterator();
        while (it.hasNext()) {
            try {
                sb2.append(h9.c(Encrypt.aesEncrypt(it.next().toJson().getBytes("UTF-8"), historyLocationRecorder.e)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb3 = sb2.toString();
        if (TextUtils.isEmpty(sb3)) {
            return;
        }
        Utils.writeStringToFile(historyLocationRecorder.f6698b, sb3, false);
    }

    public void addGpsLocation(HistoryLocation historyLocation) {
        addSysLocation(historyLocation, 1);
    }

    public void addLBSLocation(HistoryLocation historyLocation) {
        if (historyLocation != null && this.f6697a.size() > 0) {
            int i3 = historyLocation.locationType;
            if (i3 != 6 && i3 != 5) {
                if (this.f6697a.contains(historyLocation)) {
                    return;
                }
                if (this.f6697a.size() >= 10) {
                    this.f6697a.removeFirst();
                }
                this.f6697a.add(historyLocation);
                this.f6701f = true;
                return;
            }
            HistoryLocation last = this.f6697a.getLast();
            if (last.longitude == historyLocation.longitude && last.latitude == historyLocation.latitude && last.radius == historyLocation.radius) {
                return;
            }
            if (this.f6697a.size() >= 10) {
                this.f6697a.removeFirst();
            }
            this.f6697a.add(historyLocation);
            this.f6701f = true;
        }
    }

    public void addNetworkLocation(HistoryLocation historyLocation) {
        addSysLocation(historyLocation, 12);
    }

    public void addSysLocation(HistoryLocation historyLocation, int i3) {
        if (historyLocation == null) {
            return;
        }
        Iterator<HistoryLocation> it = this.f6697a.iterator();
        HistoryLocation historyLocation2 = null;
        int i10 = 0;
        HistoryLocation historyLocation3 = null;
        while (it.hasNext()) {
            HistoryLocation next = it.next();
            if (next.locationType == i3) {
                if (historyLocation3 == null) {
                    historyLocation3 = next;
                }
                i10++;
                historyLocation2 = next;
            }
        }
        if (historyLocation2 == null || historyLocation.time - historyLocation2.time >= 20000 || Utils.dist(new double[]{historyLocation.latitude, historyLocation.longitude, historyLocation2.latitude, historyLocation2.longitude}) >= 20.0f) {
            if (i10 >= 5) {
                this.f6697a.remove(historyLocation3);
            }
            if (this.f6697a.size() >= 10) {
                this.f6697a.removeFirst();
            }
            this.f6697a.add(historyLocation);
            this.f6701f = true;
        }
    }

    public void destroy(boolean z5) {
        if (!z5) {
            this.f6702g.run();
        }
        Handler handler = this.f6700d;
        if (handler != null) {
            handler.removeCallbacks(this.f6702g);
        }
        this.f6699c = true;
    }

    public List<HistoryLocation> produceContextContent(ArrayList<Cgi> arrayList, ArrayList<a> arrayList2) {
        if (arrayList != null && arrayList.size() > 0 && arrayList2 != null && arrayList2.size() > 0 && (arrayList.size() >= 4 || arrayList2.size() >= 20)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        Iterator<HistoryLocation> it = this.f6697a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            HistoryLocation next = it.next();
            if (currentTimeMillis - next.time < 21600000000L) {
                arrayList3.add(next);
                i3++;
            }
            if (i3 == 10) {
                break;
            }
        }
        return arrayList3;
    }

    public void synToDisk() {
        Handler handler = this.f6700d;
        if (handler != null) {
            handler.removeCallbacks(this.f6702g);
        }
        this.f6702g.run();
    }

    private void a() {
        LinkedList<HistoryLocation> linkedList = this.f6697a;
        if (linkedList == null || linkedList.size() <= 0) {
            Iterator<String> it = Utils.readLines(this.f6698b).iterator();
            while (it.hasNext()) {
                try {
                    String str = new String(Encrypt.aesDecrypt(h9.a(it.next()), this.e), "UTF-8");
                    HistoryLocation historyLocation = new HistoryLocation();
                    historyLocation.transformLocation(new JSONObject(str));
                    this.f6697a.add(historyLocation);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
