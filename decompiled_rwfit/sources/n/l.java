package n;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.hardware.Camera;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Choreographer;
import android.view.WindowManager;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.mb;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.zxing.FormatException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class l implements rd.b, n0.g, vg.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16244a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16245b;

    /* renamed from: c, reason: collision with root package name */
    public Object f16246c;

    /* renamed from: d, reason: collision with root package name */
    public Object f16247d;

    public /* synthetic */ l(int i3) {
        this.f16244a = i3;
    }

    @Override // rd.b
    public void a(androidx.recyclerview.widget.x xVar) {
        ((rd.b) this.f16246c).a(xVar);
    }

    @Override // n0.g
    public Object b(androidx.concurrent.futures.b bVar) {
        pe.o oVar = new pe.o(this, 10);
        w.a a3 = a6.a();
        n0.j jVar = bVar.f1607c;
        if (jVar != null) {
            jVar.a(oVar, a3);
        }
        ((w.b) this.f16247d).f19272a.set(bVar);
        return "HandlerScheduledFuture-" + ((Callable) this.f16246c).toString();
    }

    public Object c() {
        Object a3 = ((k1.e) this.f16247d).a();
        if (a3 == null) {
            a3 = ((u4.a) this.f16245b).e();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + a3.getClass());
            }
        }
        if (a3 instanceof u4.b) {
            ((u4.b) a3).b().f18882a = false;
        }
        return a3;
    }

    public synchronized void d(z3.m mVar, z3.n nVar) {
        z3.a aVar = (z3.a) ((HashMap) this.f16245b).put(mVar, new z3.a(mVar, nVar, (ReferenceQueue) this.f16246c));
        if (aVar != null) {
            aVar.f20208c = null;
            aVar.clear();
        }
    }

    public void e(double d5, float f2) {
        int length = ((float[]) this.f16245b).length + 1;
        int binarySearch = Arrays.binarySearch((double[]) this.f16246c, d5);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f16246c = Arrays.copyOf((double[]) this.f16246c, length);
        this.f16245b = Arrays.copyOf((float[]) this.f16245b, length);
        this.f16247d = new double[length];
        double[] dArr = (double[]) this.f16246c;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        ((double[]) this.f16246c)[binarySearch] = d5;
        ((float[]) this.f16245b)[binarySearch] = f2;
    }

    public void f(z3.a aVar) {
        z3.s sVar;
        synchronized (this) {
            ((HashMap) this.f16245b).remove(aVar.f20206a);
            if (aVar.f20207b && (sVar = aVar.f20208c) != null) {
                ((com.bumptech.glide.load.engine.c) this.f16247d).e(aVar.f20206a, new z3.n(sVar, true, false, aVar.f20206a, (com.bumptech.glide.load.engine.c) this.f16247d));
            }
        }
    }

    public void finalize() {
        switch (this.f16244a) {
            case 14:
                p();
                break;
            default:
                super.finalize();
                break;
        }
    }

    public void g() {
        ((BufferedOutputStream) this.f16245b).close();
        ((RandomAccessFile) this.f16247d).close();
    }

    public double h(double d5) {
        if (d5 < 0.0d) {
            d5 = 0.0d;
        } else if (d5 > 1.0d) {
            d5 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch((double[]) this.f16246c, d5);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i3 = -binarySearch;
        int i10 = i3 - 1;
        float[] fArr = (float[]) this.f16245b;
        float f2 = fArr[i10];
        int i11 = i3 - 2;
        float f10 = fArr[i11];
        double[] dArr = (double[]) this.f16246c;
        double d8 = dArr[i10];
        double d10 = dArr[i11];
        double d11 = (f2 - f10) / (d8 - d10);
        return ((((d5 * d5) - (d10 * d10)) * d11) / 2.0d) + ((d5 - d10) * (f10 - (d11 * d10))) + ((double[]) this.f16247d)[i11];
    }

    @Override // vg.b
    public void i(Object obj, Object obj2) {
        Map map = (Map) obj;
        Object apply = ((vg.o) this.f16247d).apply(obj2);
        Collection collection = (Collection) map.get(apply);
        if (collection == null) {
            collection = (Collection) ((vg.o) this.f16245b).apply(apply);
            map.put(apply, collection);
        }
        collection.add(((vg.o) this.f16246c).apply(obj2));
    }

    public x2.d j(String str) {
        b2.l b3 = b2.l.b(1, "SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?");
        if (str == null) {
            b3.bindNull(1);
        } else {
            b3.bindString(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f16245b;
        workDatabase_Impl.b();
        Cursor g10 = workDatabase_Impl.g(b3);
        try {
            return g10.moveToFirst() ? new x2.d(g10.getString(mb.a(g10, "work_spec_id")), g10.getInt(mb.a(g10, "system_id"))) : null;
        } finally {
            g10.close();
            b3.c();
        }
    }

    public double k(double d5, double d8) {
        return Math.sin((h(d5) + d8) * 6.283185307179586d);
    }

    public void l(x2.d dVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f16245b;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((x2.b) this.f16246c).e(dVar);
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
        }
    }

    public boolean m(int i3, q0.f fVar, w0.f fVar2) {
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar.T;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArr[0];
        r0.b bVar = (r0.b) this.f16246c;
        bVar.f17958a = constraintWidget$DimensionBehaviour;
        bVar.f17959b = constraintWidget$DimensionBehaviourArr[1];
        bVar.f17960c = fVar.o();
        bVar.f17961d = fVar.l();
        bVar.f17965i = false;
        bVar.f17966j = i3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = bVar.f17958a;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z5 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3;
        boolean z6 = bVar.f17959b == constraintWidget$DimensionBehaviour3;
        boolean z8 = z5 && fVar.X > 0.0f;
        boolean z10 = z6 && fVar.X > 0.0f;
        int[] iArr = fVar.f17677s;
        if (z8 && iArr[0] == 4) {
            bVar.f17958a = ConstraintWidget$DimensionBehaviour.FIXED;
        }
        if (z10 && iArr[1] == 4) {
            bVar.f17959b = ConstraintWidget$DimensionBehaviour.FIXED;
        }
        fVar2.b(fVar, bVar);
        fVar.K(bVar.e);
        fVar.H(bVar.f17962f);
        fVar.D = bVar.f17964h;
        fVar.E(bVar.f17963g);
        bVar.f17966j = 0;
        return bVar.f17965i;
    }

    public boolean n(int i3, int i10, int i11, int i12) {
        if (i3 < 0) {
            i3 += i11;
            i10 += 4 - ((i11 + 4) & 7);
        }
        if (i10 < 0) {
            i10 += i12;
            i3 += 4 - ((i12 + 4) & 7);
        }
        if (i3 >= i11) {
            i3 -= i11;
        }
        ((sc.b) this.f16246c).h(i10, i3);
        return ((sc.b) this.f16245b).b(i10, i3);
    }

    public int o(int i3, int i10, int i11, int i12) {
        int i13 = i3 - 2;
        int i14 = i10 - 2;
        int i15 = (n(i13, i14, i11, i12) ? 1 : 0) << 1;
        int i16 = i10 - 1;
        if (n(i13, i16, i11, i12)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        int i18 = i3 - 1;
        if (n(i18, i14, i11, i12)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (n(i18, i16, i11, i12)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (n(i18, i10, i11, i12)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (n(i3, i14, i11, i12)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (n(i3, i16, i11, i12)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        return n(i3, i10, i11, i12) ? i23 | 1 : i23;
    }

    @Override // rd.b
    public void onSuccess(Object obj) {
        k6.b bVar = (k6.b) this.f16247d;
        bVar.f17899c.f((BluetoothDevice) this.f16245b, (be.j) obj);
        bVar.M((rd.b) this.f16246c);
    }

    public void p() {
        zf.c cVar = (zf.c) this.f16245b;
        zf.c cVar2 = zf.d.f20407b;
        if (cVar != cVar2) {
            zf.e eVar = zf.d.f20408c;
            zf.b bVar = zf.d.f20406a;
            EGLDisplay eGLDisplay = cVar.f20405a;
            EGLSurface eGLSurface = eVar.f20422a;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, bVar.f20404a);
            EGL14.eglDestroyContext(((zf.c) this.f16245b).f20405a, ((zf.b) this.f16246c).f20404a);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(((zf.c) this.f16245b).f20405a);
        }
        this.f16245b = cVar2;
        this.f16246c = zf.d.f20406a;
        this.f16247d = null;
    }

    public boolean q(Object obj) {
        if (obj instanceof u4.b) {
            ((u4.b) obj).b().f18882a = true;
        }
        ((u4.c) this.f16246c).a(obj);
        return ((k1.e) this.f16247d).c(obj);
    }

    public void r(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f16245b;
        workDatabase_Impl.b();
        x2.e eVar = (x2.e) this.f16247d;
        SupportSQLiteStatement a3 = eVar.a();
        if (str == null) {
            a3.bindNull(1);
        } else {
            a3.bindString(1, str);
        }
        workDatabase_Impl.c();
        try {
            a3.executeUpdateDelete();
            workDatabase_Impl.h();
        } finally {
            workDatabase_Impl.f();
            eVar.c(a3);
        }
    }

    public void s(Camera camera) {
        int i3;
        Camera.Parameters parameters = camera.getParameters();
        Point point = (Point) this.f16247d;
        parameters.setPreviewSize(point.x, point.y);
        int i10 = (int) 60000.0f;
        Iterator<int[]> it = camera.getParameters().getSupportedPreviewFpsRange().iterator();
        int[] iArr = null;
        int i11 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            int i12 = i10 - next[0];
            int abs = Math.abs(i10 - next[1]) + Math.abs(i12);
            if (abs < i11) {
                iArr = next;
                i11 = abs;
            }
        }
        if (iArr != null) {
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(0, cameraInfo);
        WindowManager windowManager = (WindowManager) ((Context) this.f16245b).getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i3 = 90;
                } else if (rotation == 2) {
                    i3 = 180;
                } else if (rotation == 3) {
                    i3 = SubsamplingScaleImageView.ORIENTATION_270;
                }
            }
            i3 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i3) % 360)) % 360 : ((cameraInfo.orientation - i3) + 360) % 360;
        }
        camera.setDisplayOrientation(i3);
        camera.setParameters(parameters);
    }

    public void t(q0.g gVar, int i3, int i10, int i11) {
        int i12 = gVar.f17649c0;
        int i13 = gVar.f17651d0;
        gVar.f17649c0 = 0;
        gVar.f17651d0 = 0;
        gVar.K(i10);
        gVar.H(i11);
        if (i12 < 0) {
            gVar.f17649c0 = 0;
        } else {
            gVar.f17649c0 = i12;
        }
        if (i13 < 0) {
            gVar.f17651d0 = 0;
        } else {
            gVar.f17651d0 = i13;
        }
        q0.g gVar2 = (q0.g) this.f16247d;
        gVar2.f17688v0 = i3;
        gVar2.Q();
    }

    public String toString() {
        switch (this.f16244a) {
            case 2:
                return "pos =" + Arrays.toString((double[]) this.f16246c) + " period=" + Arrays.toString((float[]) this.f16245b);
            default:
                return super.toString();
        }
    }

    public void u(q0.g gVar) {
        ArrayList arrayList = (ArrayList) this.f16245b;
        arrayList.clear();
        int size = gVar.f17685s0.size();
        for (int i3 = 0; i3 < size; i3++) {
            q0.f fVar = (q0.f) gVar.f17685s0.get(i3);
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar.T;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviourArr[0];
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
            if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 || constraintWidget$DimensionBehaviourArr[1] == constraintWidget$DimensionBehaviour2) {
                arrayList.add(fVar);
            }
        }
        gVar.f17687u0.f17970b = true;
    }

    public /* synthetic */ l(Object obj, int i3, Object obj2, Object obj3) {
        this.f16244a = i3;
        this.f16247d = obj;
        this.f16245b = obj2;
        this.f16246c = obj3;
    }

    public /* synthetic */ l(Object obj, Object obj2, Object obj3, int i3, boolean z5) {
        this.f16244a = i3;
        this.f16245b = obj;
        this.f16246c = obj2;
        this.f16247d = obj3;
    }

    public l(Context context) {
        this.f16244a = 7;
        this.f16245b = context;
    }

    public l(WorkDatabase_Impl workDatabase_Impl, int i3) {
        this.f16244a = i3;
        switch (i3) {
            case 12:
                this.f16245b = workDatabase_Impl;
                new AtomicBoolean(false);
                this.f16246c = new x2.e(workDatabase_Impl, 1);
                this.f16247d = new x2.e(workDatabase_Impl, 2);
                break;
            default:
                this.f16245b = workDatabase_Impl;
                this.f16246c = new x2.b(workDatabase_Impl, 2);
                this.f16247d = new x2.e(workDatabase_Impl, 0);
                break;
        }
    }

    public l() {
        this.f16244a = 17;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new i1.h(2));
        this.f16245b = new HashMap();
        this.f16246c = new ReferenceQueue();
        newSingleThreadExecutor.execute(new pe.o(this, 15));
    }

    public l(sc.b bVar) {
        int i3;
        int i10;
        this.f16244a = 10;
        int i11 = bVar.f18222b;
        if (i11 >= 8 && i11 <= 144 && (i3 = i11 & 1) == 0) {
            int i12 = bVar.f18221a;
            wc.b[] bVarArr = wc.b.f19606h;
            if (i3 == 0 && (i12 & 1) == 0) {
                wc.b[] bVarArr2 = wc.b.f19606h;
                for (int i13 = 0; i13 < 48; i13++) {
                    wc.b bVar2 = bVarArr2[i13];
                    int i14 = bVar2.f19608b;
                    if (i14 == i11 && (i10 = bVar2.f19609c) == i12) {
                        this.f16247d = bVar2;
                        if (bVar.f18222b == i14) {
                            int i15 = bVar2.f19610d;
                            int i16 = i14 / i15;
                            int i17 = bVar2.e;
                            int i18 = i10 / i17;
                            sc.b bVar3 = new sc.b(i18 * i17, i16 * i15);
                            for (int i19 = 0; i19 < i16; i19++) {
                                int i20 = i19 * i15;
                                for (int i21 = 0; i21 < i18; i21++) {
                                    int i22 = i21 * i17;
                                    for (int i23 = 0; i23 < i15; i23++) {
                                        int i24 = ((i15 + 2) * i19) + 1 + i23;
                                        int i25 = i20 + i23;
                                        for (int i26 = 0; i26 < i17; i26++) {
                                            if (bVar.b(((i17 + 2) * i21) + 1 + i26, i24)) {
                                                bVar3.h(i22 + i26, i25);
                                            }
                                        }
                                    }
                                }
                            }
                            this.f16245b = bVar3;
                            this.f16246c = new sc.b(bVar3.f18221a, bVar3.f18222b);
                            return;
                        }
                        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
                    }
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }

    public l(File file) {
        this.f16244a = 13;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f16247d = randomAccessFile;
        this.f16246c = randomAccessFile.getFD();
        this.f16245b = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public l(q0.g gVar) {
        this.f16244a = 5;
        this.f16245b = new ArrayList();
        this.f16246c = new r0.b();
        this.f16247d = gVar;
    }

    public l(mc.g gVar) {
        this.f16244a = 6;
        this.f16244a = 6;
        this.f16245b = gVar;
        this.f16246c = Choreographer.getInstance();
        this.f16247d = new r1.a(this);
    }

    public l(com.bumptech.glide.load.engine.c cVar, com.bumptech.glide.request.a aVar, z3.l lVar) {
        this.f16244a = 20;
        this.f16247d = cVar;
        this.f16246c = aVar;
        this.f16245b = lVar;
    }

    public l(com.example.test.utils.y yVar) {
        this.f16244a = 0;
        this.f16247d = yVar;
        this.f16246c = new AtomicBoolean(false);
        this.f16245b = ((androidx.camera.camera2.internal.i) yVar.f8774c).f1241d.schedule(new m5.a(this, 3), 2000L, TimeUnit.MILLISECONDS);
    }
}
