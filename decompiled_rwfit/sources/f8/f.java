package f8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import android.view.View;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.u;
import com.google.android.datatransport.runtime.backends.BackendResponse$Status;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.oe;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.j;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import n.o;
import pb.i;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements h8.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13515a;

    /* renamed from: b, reason: collision with root package name */
    public int f13516b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13517c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13518d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f13519f;

    public /* synthetic */ f(int i3) {
        this.f13515a = i3;
    }

    public static View d(SparseArray sparseArray, int i3) {
        int size = sparseArray.size();
        if (size <= 0) {
            return null;
        }
        for (int i10 = 0; i10 < size; i10++) {
            int keyAt = sparseArray.keyAt(i10);
            View view = (View) sparseArray.get(keyAt);
            if (keyAt == i3) {
                sparseArray.remove(keyAt);
                return view;
            }
        }
        int i11 = size - 1;
        View view2 = (View) sparseArray.valueAt(i11);
        sparseArray.remove(sparseArray.keyAt(i11));
        return view2;
    }

    public void a(i iVar) {
        if (((HashSet) this.f13517c).contains(iVar.f17516a)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        ((HashSet) this.f13518d).add(iVar);
    }

    public pb.a b() {
        if (((pb.b) this.e) != null) {
            return new pb.a(new HashSet((HashSet) this.f13517c), new HashSet((HashSet) this.f13518d), this.f13516b, (pb.b) this.e, (HashSet) this.f13519f);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public String c(String str) {
        HashMap hashMap = (HashMap) this.f13518d;
        if (!hashMap.containsKey(str)) {
            return null;
        }
        for (String str2 : (List) hashMap.get(str)) {
            ArrayList arrayList = (ArrayList) this.e;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                u h4 = ((u) obj).h();
                pd.a("CameraInfo doesn't contain Camera2 implementation.", h4 instanceof o);
                if (str2.equals(((o) ((o) h4).f16280c.f16254b).f16278a)) {
                    return str2;
                }
            }
        }
        return null;
    }

    @Override // h8.a
    public Object execute() {
        SQLiteDatabase b3;
        Boolean bool;
        b8.a aVar = (b8.a) this.f13518d;
        BackendResponse$Status backendResponse$Status = BackendResponse$Status.TRANSIENT_ERROR;
        Iterable iterable = (Iterable) this.e;
        a8.b bVar = (a8.b) this.f13519f;
        BackendResponse$Status backendResponse$Status2 = aVar.f3165a;
        g gVar = (g) this.f13517c;
        if (backendResponse$Status2 == backendResponse$Status) {
            g8.g gVar2 = (g8.g) gVar.f13522c;
            gVar2.getClass();
            if (iterable.iterator().hasNext()) {
                String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + g8.g.g(iterable);
                b3 = gVar2.b();
                b3.beginTransaction();
                try {
                    b3.compileStatement(str).execute();
                    b3.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    b3.setTransactionSuccessful();
                } finally {
                }
            }
            gVar.f13523d.a(bVar, this.f13516b + 1, false);
            return null;
        }
        g8.g gVar3 = (g8.g) gVar.f13522c;
        gVar3.getClass();
        if (iterable.iterator().hasNext()) {
            gVar3.b().compileStatement("DELETE FROM events WHERE _id in " + g8.g.g(iterable)).execute();
        }
        BackendResponse$Status backendResponse$Status3 = BackendResponse$Status.OK;
        g8.c cVar = gVar.f13522c;
        if (backendResponse$Status2 == backendResponse$Status3) {
            long c9 = gVar.f13525g.c() + aVar.f3166b;
            g8.g gVar4 = (g8.g) cVar;
            gVar4.getClass();
            gVar4.e(new androidx.recyclerview.widget.e(c9, bVar));
        }
        g8.g gVar5 = (g8.g) cVar;
        b3 = gVar5.b();
        b3.beginTransaction();
        try {
            Long c10 = g8.g.c(b3, bVar);
            if (c10 == null) {
                bool = Boolean.FALSE;
            } else {
                Cursor rawQuery = gVar5.b().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{c10.toString()});
                try {
                    Boolean valueOf = Boolean.valueOf(rawQuery.moveToNext());
                    rawQuery.close();
                    bool = valueOf;
                } catch (Throwable th2) {
                    rawQuery.close();
                    throw th2;
                }
            }
            b3.setTransactionSuccessful();
            b3.endTransaction();
            if (!bool.booleanValue()) {
                return null;
            }
            gVar.f13523d.a(bVar, 1, true);
            return null;
        } finally {
        }
    }

    public String toString() {
        switch (this.f13515a) {
            case 1:
                StringBuilder sb2 = new StringBuilder(200);
                sb2.append("<<\n mode: ");
                sb2.append((Mode) this.f13517c);
                sb2.append("\n ecLevel: ");
                sb2.append((ErrorCorrectionLevel) this.f13518d);
                sb2.append("\n version: ");
                sb2.append((jd.f) this.e);
                sb2.append("\n maskPattern: ");
                sb2.append(this.f13516b);
                if (((i6.a) this.f13519f) == null) {
                    sb2.append("\n matrix: null\n");
                } else {
                    sb2.append("\n matrix:\n");
                    sb2.append((i6.a) this.f13519f);
                }
                sb2.append(">>\n");
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public f(g gVar, b8.a aVar, Iterable iterable, a8.b bVar, int i3) {
        this.f13515a = 0;
        this.f13517c = gVar;
        this.f13518d = aVar;
        this.e = iterable;
        this.f13519f = bVar;
        this.f13516b = i3;
    }

    public f(androidx.camera.camera2.internal.compat.u uVar) {
        this.f13515a = 3;
        this.f13516b = 0;
        this.f13518d = new HashMap();
        this.f13519f = new HashSet();
        this.f13517c = new ArrayList();
        this.e = new ArrayList();
        Set hashSet = new HashSet();
        try {
            hashSet = uVar.f1223a.w();
        } catch (CameraAccessExceptionCompat unused) {
            a0.b("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ArrayList arrayList = new ArrayList((Set) it.next());
            if (arrayList.size() >= 2) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                try {
                    if (oe.a(uVar, str) && oe.a(uVar, str2)) {
                        ((HashSet) this.f13519f).add(new HashSet(Arrays.asList(str, str2)));
                        HashMap hashMap = (HashMap) this.f13518d;
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, new ArrayList());
                        }
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        ((List) hashMap.get(str)).add((String) arrayList.get(1));
                        ((List) hashMap.get(str2)).add((String) arrayList.get(0));
                    }
                } catch (InitializationException unused2) {
                    a0.a("Camera2CameraCoordinator", l0.q("Concurrent camera id pair: (", str, ", ", str2, ") is not backward compatible"));
                }
            }
        }
    }

    public f(Class cls, Class[] clsArr) {
        this.f13515a = 2;
        HashSet hashSet = new HashSet();
        this.f13517c = hashSet;
        this.f13518d = new HashSet();
        this.f13516b = 0;
        this.f13519f = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            j.a(cls2, "Null interface");
        }
        Collections.addAll((HashSet) this.f13517c, clsArr);
    }
}
