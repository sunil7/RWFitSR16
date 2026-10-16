package n9;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.media.CamcorderProfile;
import android.media.MediaMetadataRetriever;
import android.os.Vibrator;
import android.util.Log;
import androidx.camera.core.impl.CameraCaptureFailure$Reason;
import androidx.emoji2.text.m;
import com.example.test.XXApplication;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import g4.a0;
import g4.b0;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import pb.p;
import vg.o;

/* loaded from: classes.dex */
public final class e implements b4.a, ca.c, t6.b, a7.f, com.google.gson.internal.i, pb.b, td.a, b0, m4.e, n.d, p7.c, o {

    /* renamed from: b, reason: collision with root package name */
    public static e f16444b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16445a;

    public /* synthetic */ e(int i3) {
        this.f16445a = i3;
    }

    public static final i l(PackageInfo packageInfo, i... iVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            j jVar = new j(packageInfo.signatures[0].toByteArray());
            for (int i3 = 0; i3 < iVarArr.length; i3++) {
                if (iVarArr[i3].equals(jVar)) {
                    return iVarArr[i3];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m(android.content.pm.PackageInfo r4) {
        /*
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L2c
            java.lang.String r2 = "com.android.vending"
            java.lang.String r3 = r4.packageName
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L1c
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L19
            goto L1c
        L19:
            r2 = r4
        L1a:
            r3 = r0
            goto L2e
        L1c:
            android.content.pm.ApplicationInfo r2 = r4.applicationInfo
            if (r2 != 0) goto L22
        L20:
            r2 = r1
            goto L29
        L22:
            int r2 = r2.flags
            r2 = r2 & 129(0x81, float:1.81E-43)
            if (r2 == 0) goto L20
            r2 = r0
        L29:
            r3 = r2
            r2 = r4
            goto L2e
        L2c:
            r2 = 0
            goto L1a
        L2e:
            if (r4 == 0) goto L4c
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L4c
            if (r3 == 0) goto L3d
            n9.i[] r4 = n9.k.f16455a
            n9.i r4 = l(r2, r4)
            goto L49
        L3d:
            n9.i[] r4 = n9.k.f16455a
            r4 = r4[r1]
            n9.i[] r4 = new n9.i[]{r4}
            n9.i r4 = l(r2, r4)
        L49:
            if (r4 == 0) goto L4c
            return r0
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.e.m(android.content.pm.PackageInfo):boolean");
    }

    @Override // b4.a
    public void a(x3.c cVar, n.l lVar) {
    }

    @Override // vg.o
    public Object apply(Object obj) {
        return obj;
    }

    @Override // g4.b0
    public void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(new a0((ByteBuffer) obj));
    }

    @Override // n.d
    public CamcorderProfile c(int i3, int i10) {
        return CamcorderProfile.get(i3, i10);
    }

    @Override // n.d
    public boolean d(int i3, int i10) {
        return CamcorderProfile.hasProfile(i3, i10);
    }

    @Override // p7.c
    public float e(o7.k kVar, r7.g gVar) {
        float yChartMax = gVar.getYChartMax();
        float yChartMin = gVar.getYChartMin();
        o7.j lineData = gVar.getLineData();
        if (kVar.f16821p > 0.0f && kVar.f16822q < 0.0f) {
            return 0.0f;
        }
        if (lineData.f16826a > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.f16827b < 0.0f) {
            yChartMin = 0.0f;
        }
        return kVar.f16822q >= 0.0f ? yChartMin : yChartMax;
    }

    @Override // b4.a
    public File f(x3.c cVar) {
        return null;
    }

    public j6.a g() {
        j6.a aVar;
        j6.a aVar2 = j6.a.f15326c;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this) {
            aVar = j6.a.f15326c;
            if (aVar == null) {
                XXApplication xXApplication = XXApplication.f7400h;
                aVar = new j6.a(j1.a());
                j6.a.f15326c = aVar;
            }
        }
        return aVar;
    }

    @Override // td.a
    public Object h(vd.b bVar) {
        switch (this.f16445a) {
            case 9:
                return !(bVar instanceof xd.i) ? "" : ((be.e) ((xd.i) bVar).f19230g).f3231d;
            default:
                if (bVar instanceof xd.h) {
                    return Integer.valueOf(((be.d) ((xd.h) bVar).f19230g).f3230d);
                }
                return 1;
        }
    }

    @Override // pb.b
    public Object i(p pVar) {
        gc.a aVar = new gc.a();
        m mVar = new m(1);
        ReferenceQueue referenceQueue = aVar.f14023a;
        Set set = aVar.f14024b;
        set.add(new gc.i(aVar, referenceQueue, set, mVar));
        Thread thread = new Thread(new x.h(21, referenceQueue, set), "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return aVar;
    }

    @Override // a7.f
    public void j(int i3) {
    }

    @Override // ca.c
    public b4.g k(Context context, String str, ca.b bVar) {
        b4.g gVar = new b4.g();
        int e = bVar.e(context, str, true);
        gVar.f3159b = e;
        if (e != 0) {
            gVar.f3160c = 1;
            return gVar;
        }
        int c9 = bVar.c(context, str);
        gVar.f3158a = c9;
        if (c9 != 0) {
            gVar.f3160c = -1;
        }
        return gVar;
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        Vibrator vibrator = (Vibrator) ef.i.y().f12629b;
        if (vibrator != null) {
            vibrator.cancel();
        }
        ef.i.y().N();
        if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 66, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 66);
        }
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        switch (this.f16445a) {
            case 6:
                return new TreeMap();
            default:
                return new ArrayList();
        }
    }

    public String toString() {
        switch (this.f16445a) {
            case 23:
                return "IdentityFunction";
            default:
                return super.toString();
        }
    }

    public e(CameraCaptureFailure$Reason cameraCaptureFailure$Reason) {
        this.f16445a = 1;
    }
}
