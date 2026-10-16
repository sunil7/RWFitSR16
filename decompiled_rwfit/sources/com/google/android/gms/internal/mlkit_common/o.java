package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.view.GestureDetector;
import android.view.ViewConfiguration;
import androidx.camera.core.impl.i1;
import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import d4.b0;
import d4.q;
import d4.r;
import d4.x;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentSkipListMap;
import pb.p;

/* loaded from: classes.dex */
public final class o implements u4.a, ca.c, t6.b, a7.f, com.google.gson.internal.i, pb.b, td.a, r, m4.k, ue.d, vg.g, y6.b {

    /* renamed from: b, reason: collision with root package name */
    public static o f9183b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9184a;

    public /* synthetic */ o(int i3) {
        this.f9184a = i3;
    }

    public static int a(String str, String str2, boolean z5) {
        if (!z5) {
            int i3 = ye.e.f20123a;
            Locale locale = Locale.ENGLISH;
            return ye.e.i(str + "p" + str2).hashCode();
        }
        int i10 = ye.e.f20123a;
        Locale locale2 = Locale.ENGLISH;
        return ye.e.i(str + "p" + str2 + "@dir").hashCode();
    }

    @Override // y6.b
    public int b() {
        return 2;
    }

    @Override // d4.r
    public q c(x xVar) {
        return new b0(xVar.a(d4.g.class, InputStream.class), 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x0174, code lost:
    
        if (r5 != 0) goto L148;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(java.util.ArrayList r18, com.liulishuo.filedownloader.message.MessageSnapshot r19) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.o.d(java.util.ArrayList, com.liulishuo.filedownloader.message.MessageSnapshot):boolean");
    }

    @Override // u4.a
    public Object e() {
        switch (this.f9184a) {
            case 3:
                try {
                    return new b4.h(MessageDigest.getInstance("SHA-256"));
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            default:
                return new z3.r();
        }
    }

    @Override // vg.g
    public void f(Object obj) {
        a1.b(new OnErrorNotImplementedException((Throwable) obj));
    }

    @Override // ue.d
    public void g(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.h()).intern()) {
            try {
                ArrayList h4 = pe.e.f17562a.h(messageSnapshot.h());
                if (h4.size() > 0) {
                    ((pe.b) h4.get(0)).getClass();
                    if (!d(h4, messageSnapshot)) {
                        StringBuilder sb2 = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.h() + " status:" + ((int) messageSnapshot.n()) + " task-count:" + h4.size());
                        int size = h4.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj = h4.get(i3);
                            i3++;
                            pe.b bVar = (pe.b) obj;
                            sb2.append(" | ");
                            bVar.getClass();
                            sb2.append((int) bVar.f17544a.f17558d);
                        }
                        o6.a(4, this, null, sb2.toString(), new Object[0]);
                    }
                } else {
                    o6.a(4, this, null, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.n()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // td.a
    public Object h(vd.b bVar) {
        if (bVar instanceof xd.n) {
            return Integer.valueOf(((be.g) ((xd.n) bVar).f19230g).f3233d);
        }
        return 7;
    }

    @Override // pb.b
    public Object i(p pVar) {
        return new gc.b(0);
    }

    @Override // a7.f
    public void j(int i3) {
    }

    @Override // ca.c
    public b4.g k(Context context, String str, ca.b bVar) {
        b4.g gVar = new b4.g();
        int c9 = bVar.c(context, str);
        gVar.f3158a = c9;
        if (c9 != 0) {
            gVar.f3160c = -1;
            return gVar;
        }
        int e = bVar.e(context, str, true);
        gVar.f3159b = e;
        if (e != 0) {
            gVar.f3160c = 1;
        }
        return gVar;
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        switch (this.f9184a) {
            case 7:
                return new LinkedHashMap();
            default:
                return new ConcurrentSkipListMap();
        }
    }

    public o(Context context, b9.a aVar) {
        this.f9184a = 13;
        ViewConfiguration.get(context).getScaledTouchSlop();
        new GestureDetector(context, new com.dh.imagepick.preview.widgets.video.c(this, 2));
    }

    public o(n.h hVar, androidx.camera.camera2.internal.compat.n nVar, i1 i1Var, androidx.camera.core.impl.utils.executor.b bVar, w.c cVar) {
        this.f9184a = 16;
        Integer num = (Integer) nVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num != null) {
            num.intValue();
        }
        new gc.b(i1Var);
        com.google.android.gms.internal.mlkit_vision_common.o.a(new af.a(nVar, 19));
    }
}
