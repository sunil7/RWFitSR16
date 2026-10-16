package de;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import androidx.appcompat.app.i0;
import androidx.recyclerview.widget.x;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.test.R$mipmap;
import com.example.test.ui.device.activity.CustomJLDialActivity;
import com.example.test.ui.model.dial.Element;
import com.example.test.utils.y;
import com.jieli.bmp_convert.BmpConvert;
import com.jieli.bmp_convert.ConvertParam;
import com.jieli.jl_bt_ota.tool.DataInfoCache;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Ref$ObjectRef;
import n.m0;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12356a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12357b;

    /* renamed from: c, reason: collision with root package name */
    public Object f12358c;

    /* renamed from: d, reason: collision with root package name */
    public Object f12359d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f12360f;

    /* renamed from: g, reason: collision with root package name */
    public Object f12361g;

    /* renamed from: h, reason: collision with root package name */
    public Object f12362h;

    public /* synthetic */ i(int i3) {
        this.f12356a = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x000d, B:5:0x0013, B:7:0x0024, B:9:0x002b, B:11:0x0032, B:13:0x0038, B:16:0x0047, B:33:0x00a3, B:18:0x004e, B:20:0x0059, B:22:0x0063, B:24:0x0072, B:26:0x0078, B:27:0x007b, B:29:0x0081, B:36:0x008a, B:40:0x009d, B:43:0x00a8, B:45:0x00c1, B:46:0x00c9, B:49:0x00cd, B:55:0x0092, B:58:0x0044), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(re.b r10) {
        /*
            java.util.Iterator r0 = r10.iterator()
            de.i r1 = com.liulishuo.filedownloader.download.c.f11405a
            com.google.android.gms.internal.mlkit_common.o r1 = r1.g()
            java.lang.System.currentTimeMillis()
        Ld:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto Ld6
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L41
            com.liulishuo.filedownloader.model.FileDownloadModel r2 = (com.liulishuo.filedownloader.model.FileDownloadModel) r2     // Catch: java.lang.Throwable -> L41
            byte r3 = r2.k()     // Catch: java.lang.Throwable -> L41
            r4 = 3
            r5 = -2
            r6 = 0
            r8 = 1
            if (r3 == r4) goto L44
            byte r3 = r2.k()     // Catch: java.lang.Throwable -> L41
            r4 = 2
            if (r3 == r4) goto L44
            byte r3 = r2.k()     // Catch: java.lang.Throwable -> L41
            r4 = -1
            if (r3 == r4) goto L44
            byte r3 = r2.k()     // Catch: java.lang.Throwable -> L41
            if (r3 != r8) goto L47
            long r3 = r2.j()     // Catch: java.lang.Throwable -> L41
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L47
            goto L44
        L41:
            r0 = move-exception
            goto Ldf
        L44:
            r2.D(r5)     // Catch: java.lang.Throwable -> L41
        L47:
            java.lang.String r3 = r2.l()     // Catch: java.lang.Throwable -> L41
            if (r3 != 0) goto L4e
            goto La3
        L4e:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L41
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L41
            byte r3 = r2.k()     // Catch: java.lang.Throwable -> L41
            if (r3 != r5) goto L7b
            java.lang.String r3 = r2.i()     // Catch: java.lang.Throwable -> L41
            boolean r3 = ye.e.e(r2, r3)     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L7b
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L41
            java.lang.String r5 = r2.m()     // Catch: java.lang.Throwable -> L41
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L41
            boolean r5 = r3.exists()     // Catch: java.lang.Throwable -> L41
            if (r5 != 0) goto L7b
            boolean r5 = r4.exists()     // Catch: java.lang.Throwable -> L41
            if (r5 == 0) goto L7b
            r4.renameTo(r3)     // Catch: java.lang.Throwable -> L41
        L7b:
            byte r3 = r2.k()     // Catch: java.lang.Throwable -> L41
            if (r3 != r8) goto L8a
            long r8 = r2.j()     // Catch: java.lang.Throwable -> L41
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 > 0) goto L8a
            goto La3
        L8a:
            java.lang.String r3 = r2.m()     // Catch: java.lang.Throwable -> L41
            if (r3 != 0) goto L92
            r3 = 0
            goto L9a
        L92:
            java.lang.String r3 = r2.m()     // Catch: java.lang.Throwable -> L41
            boolean r3 = ye.e.e(r2, r3)     // Catch: java.lang.Throwable -> L41
        L9a:
            if (r3 != 0) goto L9d
            goto La3
        L9d:
            boolean r3 = r4.exists()     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto La8
        La3:
            r0.remove()     // Catch: java.lang.Throwable -> L41
            goto Ld
        La8:
            int r3 = r2.h()     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = r2.o()     // Catch: java.lang.Throwable -> L41
            java.lang.String r5 = r2.i()     // Catch: java.lang.Throwable -> L41
            boolean r6 = r2.s()     // Catch: java.lang.Throwable -> L41
            r1.getClass()     // Catch: java.lang.Throwable -> L41
            int r4 = com.google.android.gms.internal.mlkit_common.o.a(r4, r5, r6)     // Catch: java.lang.Throwable -> L41
            if (r4 == r3) goto Lc9
            r2.z(r4)     // Catch: java.lang.Throwable -> L41
            android.util.SparseArray r4 = r10.f18117a     // Catch: java.lang.Throwable -> L41
            r4.put(r3, r2)     // Catch: java.lang.Throwable -> L41
        Lc9:
            android.util.SparseArray r3 = r10.f18119c     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto Ld
            int r4 = r2.h()     // Catch: java.lang.Throwable -> L41
            r3.put(r4, r2)     // Catch: java.lang.Throwable -> L41
            goto Ld
        Ld6:
            android.content.Context r0 = com.google.android.gms.internal.mlkit_vision_common.n6.f10047a
            ye.e.h(r0)
            r10.a()
            return
        Ldf:
            android.content.Context r1 = com.google.android.gms.internal.mlkit_vision_common.n6.f10047a
            ye.e.h(r1)
            r10.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: de.i.l(re.b):void");
    }

    public void a(ud.a aVar, x xVar) {
        String str = (String) this.f12357b;
        vd.a aVar2 = aVar.f19050c;
        if (aVar2 != null) {
            xVar.f2800d = aVar2.f19220c;
        }
        ee.c.b(4, str, "callError : " + xVar);
        ((Handler) this.f12362h).post(new androidx.camera.camera2.internal.compat.h(this, 9, aVar, xVar));
    }

    public void b(ud.a aVar, vd.b bVar) {
        if (aVar.e != null && bVar != null) {
            ((Handler) this.f12362h).post(new i0(17, aVar, bVar));
            return;
        }
        ee.c.b(2, (String) this.f12357b, " callbackCmd : param is null. " + aVar);
    }

    public void c(ud.a aVar) {
        aVar.f19054h = System.currentTimeMillis();
        ((Handler) this.f12361g).post(new g(this, aVar, 0));
    }

    public m0 d(String str) {
        com.google.android.gms.internal.mlkit_common.o oVar = (com.google.android.gms.internal.mlkit_common.o) this.f12359d;
        if (oVar == null) {
            synchronized (this) {
                try {
                    if (((com.google.android.gms.internal.mlkit_common.o) this.f12359d) == null) {
                        this.f12359d = ((eb.e) f().f16381b) == null ? new com.google.android.gms.internal.mlkit_common.o(19) : new com.google.android.gms.internal.mlkit_common.o(19);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            oVar = (com.google.android.gms.internal.mlkit_common.o) this.f12359d;
        }
        oVar.getClass();
        URL url = new URL(str);
        m0 m0Var = new m0(13, false);
        m0Var.f16254b = url.openConnection();
        return m0Var;
    }

    public re.a e() {
        k kVar = (k) this.f12360f;
        if (kVar != null) {
            return kVar;
        }
        synchronized (this) {
            try {
                if (((k) this.f12360f) == null) {
                    Object obj = f().f16381b;
                    k kVar2 = new k();
                    this.f12360f = kVar2;
                    o4.e eVar = (o4.e) kVar2.f12367c;
                    SparseArray sparseArray = (SparseArray) eVar.f16737a;
                    SparseArray sparseArray2 = (SparseArray) eVar.f16738b;
                    n6.a aVar = (n6.a) kVar2.f12368d;
                    aVar.getClass();
                    l(new re.b(aVar, sparseArray, sparseArray2));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return (k) this.f12360f;
    }

    public n6.a f() {
        n6.a aVar = (n6.a) this.f12357b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            try {
                if (((n6.a) this.f12357b) == null) {
                    this.f12357b = new n6.a((byte) 0, 22);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return (n6.a) this.f12357b;
    }

    public com.google.android.gms.internal.mlkit_common.o g() {
        com.google.android.gms.internal.mlkit_common.o oVar = (com.google.android.gms.internal.mlkit_common.o) this.f12361g;
        if (oVar != null) {
            return oVar;
        }
        synchronized (this) {
            try {
                if (((com.google.android.gms.internal.mlkit_common.o) this.f12361g) == null) {
                    this.f12361g = ((eb.e) f().f16381b) == null ? new com.google.android.gms.internal.mlkit_common.o(22) : new com.google.android.gms.internal.mlkit_common.o(22);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return (com.google.android.gms.internal.mlkit_common.o) this.f12361g;
    }

    public com.google.android.gms.internal.mlkit_common.o h() {
        com.google.android.gms.internal.mlkit_common.o oVar = (com.google.android.gms.internal.mlkit_common.o) this.e;
        if (oVar != null) {
            return oVar;
        }
        synchronized (this) {
            try {
                if (((com.google.android.gms.internal.mlkit_common.o) this.e) == null) {
                    this.e = ((eb.e) f().f16381b) == null ? new com.google.android.gms.internal.mlkit_common.o(23) : new com.google.android.gms.internal.mlkit_common.o(23);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return (com.google.android.gms.internal.mlkit_common.o) this.e;
    }

    public v7.c i(float f2, float f10) {
        float[] fArr = (float[]) this.f12361g;
        fArr[0] = f2;
        fArr[1] = f10;
        p(fArr);
        return v7.c.b(fArr[0], fArr[1]);
    }

    public v7.c j(float f2, float f10) {
        v7.c b3 = v7.c.b(0.0d, 0.0d);
        k(f2, f10, b3);
        return b3;
    }

    public void k(float f2, float f10, v7.c cVar) {
        float[] fArr = (float[]) this.f12361g;
        fArr[0] = f2;
        fArr[1] = f10;
        o(fArr);
        cVar.f19179b = fArr[0];
        cVar.f19180c = fArr[1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m(boolean z5, Element element) {
        DialInfoBean n4;
        Bitmap decodeResource;
        Bitmap decodeResource2;
        switch (this.f12356a) {
            case 1:
                if (z5) {
                    ((Ref$ObjectRef) this.f12359d).element = element;
                    element.setType(1);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setOffset(0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setIndex(0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setAnchor((byte) 0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setHasAlpha(0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setCompression(2);
                    int i3 = com.example.test.utils.g.f8727a;
                    CustomJLDialActivity customJLDialActivity = (CustomJLDialActivity) this.e;
                    String str = (String) this.f12357b;
                    androidx.camera.core.impl.e eVar = new androidx.camera.core.impl.e((ef.i) this.f12358c, (Ref$ObjectRef) this.f12360f, (Ref$ObjectRef) this.f12359d, (HashMap) this.f12361g, (String) this.f12362h, 3);
                    Element element2 = new Element();
                    element2.setImageCount((byte) 1);
                    element2.setDataList(new ArrayList());
                    if (str == null || str.length() == 0) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        int i10 = R$mipmap.background;
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        n4 = kVar != null ? kVar.n() : null;
                        kotlin.jvm.internal.e.c(n4);
                        if (n4.getWidth() == 240 && n4.getHeight() == 296) {
                            i10 = R$mipmap.dial_background296;
                        } else if (n4.getWidth() == 240 && n4.getHeight() == 320) {
                            i10 = R$mipmap.dial_background320;
                        }
                        decodeResource = BitmapFactory.decodeResource(customJLDialActivity.getResources(), i10, options);
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(str);
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inScaled = false;
                        decodeResource = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options2);
                    }
                    element2.setWidth(decodeResource.getWidth());
                    element2.setHeight(decodeResource.getHeight());
                    File file = new File(android.support.v4.media.session.e.j(customJLDialActivity.getFilesDir(), "/dial"));
                    String l3 = android.support.v4.media.session.e.l(file.getAbsolutePath(), "/bgout.res");
                    String filePath = file.getAbsolutePath() + "/bgin.png";
                    kotlin.jvm.internal.e.f(filePath, "filePath");
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                        decodeResource.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BmpConvert bmpConvert = new BmpConvert();
                    bmpConvert.bitmapConvert(3, filePath, l3, new ConvertParam().setFormat(0), new com.example.test.utils.c(element2, eVar));
                    bmpConvert.release();
                    decodeResource.recycle();
                    return;
                }
                return;
            default:
                if (z5) {
                    ((Ref$ObjectRef) this.f12359d).element = element;
                    element.setType(1);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setOffset(0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setIndex(0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setAnchor((byte) 0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setHasAlpha(0);
                    ((Element) ((Ref$ObjectRef) this.f12359d).element).setCompression(2);
                    int i11 = com.example.test.utils.g.f8727a;
                    CustomJLDialActivity customJLDialActivity2 = (CustomJLDialActivity) this.e;
                    String str2 = (String) this.f12357b;
                    androidx.camera.core.impl.e eVar2 = new androidx.camera.core.impl.e((y) this.f12358c, (Ref$ObjectRef) this.f12360f, (Ref$ObjectRef) this.f12359d, (HashMap) this.f12361g, (String) this.f12362h, 5);
                    Element element3 = new Element();
                    element3.setImageCount((byte) 1);
                    element3.setDataList(new ArrayList());
                    if (str2 == null || str2.length() == 0) {
                        BitmapFactory.Options options3 = new BitmapFactory.Options();
                        options3.inScaled = false;
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                        n4 = kVar2 != null ? kVar2.n() : null;
                        kotlin.jvm.internal.e.c(n4);
                        decodeResource2 = BitmapFactory.decodeResource(customJLDialActivity2.getResources(), n4.getWidth() == 416 ? R$mipmap.background_416 : n4.getWidth() == 360 ? R$mipmap.dial_background_300 : R$mipmap.background_466, options3);
                    } else {
                        FileInputStream fileInputStream2 = new FileInputStream(str2);
                        BitmapFactory.Options options4 = new BitmapFactory.Options();
                        options4.inScaled = false;
                        decodeResource2 = BitmapFactory.decodeFileDescriptor(fileInputStream2.getFD(), null, options4);
                    }
                    element3.setWidth(decodeResource2.getWidth());
                    element3.setHeight(decodeResource2.getHeight());
                    File file2 = new File(android.support.v4.media.session.e.j(customJLDialActivity2.getFilesDir(), "/dial"));
                    String l5 = android.support.v4.media.session.e.l(file2.getAbsolutePath(), "/bgout.res");
                    String filePath2 = file2.getAbsolutePath() + "/bgin.png";
                    kotlin.jvm.internal.e.f(filePath2, "filePath");
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(filePath2)));
                        decodeResource2.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream2);
                        bufferedOutputStream2.flush();
                        bufferedOutputStream2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    BmpConvert bmpConvert2 = new BmpConvert();
                    bmpConvert2.bitmapConvert(3, filePath2, l5, new ConvertParam().setFormat(0), new com.example.test.utils.d(element3, eVar2));
                    bmpConvert2.release();
                    decodeResource2.recycle();
                    return;
                }
                return;
        }
    }

    public void n(Path path) {
        path.transform((Matrix) this.f12357b);
        path.transform(((v7.i) this.f12359d).f19201a);
        path.transform((Matrix) this.f12358c);
    }

    public void o(float[] fArr) {
        Matrix matrix = (Matrix) this.f12360f;
        matrix.reset();
        ((Matrix) this.f12358c).invert(matrix);
        matrix.mapPoints(fArr);
        ((v7.i) this.f12359d).f19201a.invert(matrix);
        matrix.mapPoints(fArr);
        ((Matrix) this.f12357b).invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void p(float[] fArr) {
        ((Matrix) this.f12357b).mapPoints(fArr);
        ((v7.i) this.f12359d).f19201a.mapPoints(fArr);
        ((Matrix) this.f12358c).mapPoints(fArr);
    }

    public void q() {
        Matrix matrix = (Matrix) this.f12358c;
        matrix.reset();
        v7.i iVar = (v7.i) this.f12359d;
        matrix.postTranslate(iVar.f19202b.left, iVar.f19204d - iVar.j());
    }

    public void r(float f2, float f10, float f11, float f12) {
        v7.i iVar = (v7.i) this.f12359d;
        float width = iVar.f19202b.width() / f10;
        float height = iVar.f19202b.height() / f11;
        if (Float.isInfinite(width)) {
            width = 0.0f;
        }
        if (Float.isInfinite(height)) {
            height = 0.0f;
        }
        Matrix matrix = (Matrix) this.f12357b;
        matrix.reset();
        matrix.postTranslate(-f2, -f12);
        matrix.postScale(width, -height);
    }

    public /* synthetic */ i(com.example.test.utils.b bVar, Ref$ObjectRef ref$ObjectRef, CustomJLDialActivity customJLDialActivity, String str, Ref$ObjectRef ref$ObjectRef2, HashMap hashMap, String str2, int i3) {
        this.f12356a = i3;
        this.f12358c = bVar;
        this.f12359d = ref$ObjectRef;
        this.e = customJLDialActivity;
        this.f12357b = str;
        this.f12360f = ref$ObjectRef2;
        this.f12361g = hashMap;
        this.f12362h = str2;
    }

    public i(k6.b bVar) {
        this.f12356a = 0;
        this.f12357b = i.class.getSimpleName();
        this.e = new DataInfoCache();
        HandlerThread handlerThread = new HandlerThread("DataHandlerModify");
        this.f12360f = handlerThread;
        this.f12362h = new Handler(Looper.getMainLooper());
        this.f12358c = bVar;
        this.f12359d = new o(0);
        handlerThread.start();
        this.f12361g = new Handler(handlerThread.getLooper(), new h());
    }

    public i(v7.i iVar) {
        this.f12356a = 5;
        this.f12357b = new Matrix();
        this.f12358c = new Matrix();
        this.e = new float[1];
        this.f12360f = new Matrix();
        this.f12361g = new float[2];
        this.f12362h = new Matrix();
        new Matrix();
        this.f12359d = iVar;
    }

    public i(c4.c cVar, c4.c cVar2, c4.c cVar3, c4.c cVar4, com.bumptech.glide.load.engine.c cVar5, com.bumptech.glide.load.engine.c cVar6) {
        this.f12356a = 6;
        this.f12362h = u4.d.a(150, new mc.g(this, 29));
        this.f12357b = cVar;
        this.f12358c = cVar2;
        this.f12359d = cVar3;
        this.e = cVar4;
        this.f12360f = cVar5;
        this.f12361g = cVar6;
    }
}
