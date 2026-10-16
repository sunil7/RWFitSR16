package n;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import com.google.android.gms.internal.mlkit_vision_barcode.oe;
import com.google.android.gms.internal.mlkit_vision_barcode.re;
import com.google.android.gms.internal.mlkit_vision_barcode.se;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16203a;

    /* renamed from: b, reason: collision with root package name */
    public final f8.f f16204b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.camera.core.impl.b f16205c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.impl.z f16206d;
    public final androidx.camera.camera2.internal.compat.u e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f16207f;

    /* renamed from: g, reason: collision with root package name */
    public final y f16208g;

    /* renamed from: h, reason: collision with root package name */
    public final long f16209h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f16210i = new HashMap();

    public i(Context context, androidx.camera.core.impl.b bVar, t.q qVar, long j4) {
        String str;
        this.f16203a = context;
        this.f16205c = bVar;
        androidx.camera.camera2.internal.compat.u a3 = androidx.camera.camera2.internal.compat.u.a(context, bVar.f1349b);
        this.e = a3;
        this.f16208g = y.b(context);
        try {
            ArrayList arrayList = new ArrayList();
            ef.i iVar = a3.f1223a;
            iVar.getClass();
            try {
                List<String> asList = Arrays.asList(((CameraManager) iVar.f12629b).getCameraIdList());
                int i3 = 0;
                if (qVar == null) {
                    Iterator it = asList.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                } else {
                    try {
                        str = re.a(a3, qVar.b(), asList);
                    } catch (IllegalStateException unused) {
                        str = null;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String str2 : asList) {
                        if (!str2.equals(str)) {
                            arrayList2.add(b(str2));
                        }
                    }
                    ArrayList a10 = qVar.a(arrayList2);
                    int size = a10.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = a10.get(i10);
                        i10++;
                        arrayList.add(((androidx.camera.core.impl.u) obj).c());
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList.size();
                while (i3 < size2) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    String str3 = (String) obj2;
                    if (str3.equals("0") || str3.equals("1")) {
                        arrayList3.add(str3);
                    } else if (oe.a(this.e, str3)) {
                        arrayList3.add(str3);
                    } else {
                        com.google.android.gms.internal.mlkit_vision_common.a0.a("Camera2CameraFactory", "Camera " + str3 + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
                    }
                }
                this.f16207f = arrayList3;
                f8.f fVar = new f8.f(this.e);
                this.f16204b = fVar;
                androidx.camera.core.impl.z zVar = new androidx.camera.core.impl.z(fVar);
                this.f16206d = zVar;
                ((ArrayList) fVar.f13517c).add(zVar);
                this.f16209h = j4;
            } catch (CameraAccessException e) {
                throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
            }
        } catch (CameraAccessExceptionCompat e10) {
            throw new InitializationException(se.a(e10));
        } catch (CameraUnavailableException e11) {
            throw new InitializationException(e11);
        }
    }

    public final androidx.camera.camera2.internal.i a(String str) {
        if (!this.f16207f.contains(str)) {
            throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
        }
        o b3 = b(str);
        androidx.camera.core.impl.b bVar = this.f16205c;
        Executor executor = bVar.f1348a;
        return new androidx.camera.camera2.internal.i(this.f16203a, this.e, str, b3, this.f16204b, this.f16206d, executor, bVar.f1349b, this.f16208g, this.f16209h);
    }

    public final o b(String str) {
        HashMap hashMap = this.f16210i;
        try {
            o oVar = (o) hashMap.get(str);
            if (oVar != null) {
                return oVar;
            }
            o oVar2 = new o(this.e, str);
            hashMap.put(str, oVar2);
            return oVar2;
        } catch (CameraAccessExceptionCompat e) {
            throw se.a(e);
        }
    }
}
