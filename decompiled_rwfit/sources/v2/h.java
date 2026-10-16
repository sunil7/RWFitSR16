package v2;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.t;
import androidx.camera.camera2.internal.compat.n;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import de.o;
import h.a0;
import h.r;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Executor;
import l1.z0;
import m0.k;
import n.u0;

/* loaded from: classes.dex */
public final class h implements c8.b, u0 {
    public static h e;

    /* renamed from: f, reason: collision with root package name */
    public static hc.a f19144f;

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f19145g;

    /* renamed from: a, reason: collision with root package name */
    public Object f19146a;

    /* renamed from: b, reason: collision with root package name */
    public Object f19147b;

    /* renamed from: c, reason: collision with root package name */
    public Object f19148c;

    /* renamed from: d, reason: collision with root package name */
    public Object f19149d;

    public h(int i3) {
        switch (i3) {
            case 9:
                this.f19146a = new k1.d(10);
                this.f19147b = new k();
                this.f19148c = new ArrayList();
                this.f19149d = new HashSet();
                break;
            default:
                this.f19146a = new m0.b();
                this.f19147b = new SparseArray();
                this.f19148c = new m0.e();
                this.f19149d = new m0.b();
                break;
        }
    }

    public static synchronized h j(Context context, o oVar) {
        h hVar;
        synchronized (h.class) {
            try {
                if (e == null) {
                    h hVar2 = new h();
                    Context applicationContext = context.getApplicationContext();
                    hVar2.f19146a = new a(applicationContext, oVar);
                    hVar2.f19147b = new b(applicationContext, oVar);
                    hVar2.f19148c = new f(applicationContext, oVar);
                    hVar2.f19149d = new g(applicationContext, oVar);
                    e = hVar2;
                }
                hVar = e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hVar;
    }

    public static boolean k(Context context, String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr.length != 0) {
            for (String[] strArr2 : strArr) {
                arrayList.addAll(nd.c.b(strArr2));
            }
        }
        return nd.c.j(context, arrayList);
    }

    @Override // n.u0
    public void a(TotalCaptureResult totalCaptureResult) {
        if (((androidx.concurrent.futures.b) this.f19148c) != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            Rect rect = request == null ? null : (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            Rect rect2 = (Rect) this.f19149d;
            if (rect2 == null || !rect2.equals(rect)) {
                return;
            }
            ((androidx.concurrent.futures.b) this.f19148c).a(null);
            this.f19148c = null;
            this.f19149d = null;
        }
    }

    @Override // n.u0
    public void b(float f2, androidx.concurrent.futures.b bVar) {
        ((Rect) ((n) this.f19146a).a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)).getClass();
        float width = r0.width() / f2;
        float height = r0.height() / f2;
        float width2 = (r0.width() - width) / 2.0f;
        float height2 = (r0.height() - height) / 2.0f;
        this.f19147b = new Rect((int) width2, (int) height2, (int) (width2 + width), (int) (height2 + height));
        androidx.concurrent.futures.b bVar2 = (androidx.concurrent.futures.b) this.f19148c;
        if (bVar2 != null) {
            bVar2.b(new CameraControl$OperationCanceledException("There is a new zoomRatio being set"));
        }
        this.f19149d = (Rect) this.f19147b;
        this.f19148c = bVar;
    }

    @Override // n.u0
    public Rect c() {
        Rect rect = (Rect) this.f19147b;
        if (rect != null) {
            return rect;
        }
        Rect rect2 = (Rect) ((n) this.f19146a).a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        rect2.getClass();
        return rect2;
    }

    @Override // n.u0
    public float d() {
        Float f2 = (Float) ((n) this.f19146a).a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f2 != null && f2.floatValue() >= 1.0f) {
            return f2.floatValue();
        }
        return 1.0f;
    }

    @Override // n.u0
    public void e(m.a aVar) {
        Rect rect = (Rect) this.f19147b;
        if (rect != null) {
            aVar.c(CaptureRequest.SCALER_CROP_REGION, rect, Config$OptionPriority.REQUIRED);
        }
    }

    @Override // n.u0
    public float f() {
        return 1.0f;
    }

    @Override // n.u0
    public void g() {
        this.f19149d = null;
        this.f19147b = null;
        androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) this.f19148c;
        if (bVar != null) {
            bVar.b(new CameraControl$OperationCanceledException("Camera is not active."));
            this.f19148c = null;
        }
    }

    @Override // dh.a
    public Object get() {
        return new f8.h((Executor) ((dh.a) this.f19146a).get(), (g8.c) ((dh.a) this.f19147b).get(), (f8.d) ((o) this.f19148c).get(), (h8.b) ((dh.a) this.f19149d).get());
    }

    public void h(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((k) this.f19147b).getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                h(arrayList2.get(i3), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public g.f i(g.a aVar) {
        ArrayList arrayList = (ArrayList) this.f19148c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            g.f fVar = (g.f) arrayList.get(i3);
            if (fVar != null && fVar.f13702b == aVar) {
                return fVar;
            }
        }
        g.f fVar2 = new g.f((Context) this.f19147b, aVar);
        arrayList.add(fVar2);
        return fVar2;
    }

    public boolean l(g.a aVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f19146a).onActionItemClicked(i(aVar), new r((Context) this.f19147b, (e1.a) menuItem));
    }

    public boolean m(g.a aVar, h.k kVar) {
        g.f i3 = i(aVar);
        k kVar2 = (k) this.f19149d;
        Menu menu = (Menu) kVar2.getOrDefault(kVar, null);
        if (menu == null) {
            menu = new a0((Context) this.f19147b, kVar);
            kVar2.put(kVar, menu);
        }
        return ((ActionMode.Callback) this.f19146a).onCreateActionMode(i3, menu);
    }

    public void n(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (((ArrayList) this.f19147b) == null) {
            this.f19147b = new ArrayList(arrayList);
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            if (!((ArrayList) this.f19147b).contains(str)) {
                ((ArrayList) this.f19147b).add(str);
            }
        }
    }

    public void o(String... strArr) {
        n(nd.c.b(strArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:296:0x01b3, code lost:
    
        r3 = r21.getApplicationInfo().targetSdkVersion;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x01bb, code lost:
    
        r22 = "android.permission.WRITE_EXTERNAL_STORAGE";
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x01be, code lost:
    
        r8 = r2.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "requestLegacyExternalStorage", false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x01c4, code lost:
    
        if (r3 < 29) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x01c6, code lost:
    
        if (r8 != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x01cc, code lost:
    
        if (r4.contains("android.permission.MANAGE_EXTERNAL_STORAGE") != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x01ce, code lost:
    
        if (r0 == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x01da, code lost:
    
        throw new java.lang.IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file, otherwise it will cause incompatibility with the old version");
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x01df, code lost:
    
        if (r3 < 30) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x01e5, code lost:
    
        if (r4.contains("android.permission.MANAGE_EXTERNAL_STORAGE") != false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x01e7, code lost:
    
        if (r0 == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x01f1, code lost:
    
        throw new java.lang.IllegalArgumentException("The storage permission application is abnormal. If you have adapted the scope storage, please register the <meta-data android:name=\"ScopedStorage\" android:value=\"true\" /> attribute in the AndroidManifest.xml file. If there is no adaptation scope storage, please use MANAGE_EXTERNAL_STORAGE to apply for permission");
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x01dd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x01db, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x018c A[EXC_TOP_SPLITTER, LOOP:7: B:283:0x018c->B:292:?, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0224  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(nd.b r25) {
        /*
            Method dump skipped, instructions count: 1186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.h.p(nd.b):void");
    }

    public void q() {
        int itemCount;
        ViewPager2 viewPager2 = (ViewPager2) this.f19149d;
        int i3 = R.id.accessibilityActionPageLeft;
        z0.j(R.id.accessibilityActionPageLeft, viewPager2);
        z0.k(R.id.accessibilityActionPageRight, viewPager2);
        z0.g(0, viewPager2);
        z0.k(R.id.accessibilityActionPageUp, viewPager2);
        z0.g(0, viewPager2);
        z0.k(R.id.accessibilityActionPageDown, viewPager2);
        z0.g(0, viewPager2);
        if (viewPager2.getAdapter() == null || (itemCount = viewPager2.getAdapter().getItemCount()) == 0 || !viewPager2.r) {
            return;
        }
        int orientation = viewPager2.getOrientation();
        a2.d dVar = (a2.d) this.f19147b;
        t tVar = (t) this.f19146a;
        if (orientation != 0) {
            if (viewPager2.f2950d < itemCount - 1) {
                z0.l(viewPager2, new m1.c(R.id.accessibilityActionPageDown), tVar);
            }
            if (viewPager2.f2950d > 0) {
                z0.l(viewPager2, new m1.c(R.id.accessibilityActionPageUp), dVar);
                return;
            }
            return;
        }
        boolean z5 = viewPager2.f2952g.F() == 1;
        int i10 = z5 ? 16908360 : 16908361;
        if (z5) {
            i3 = 16908361;
        }
        if (viewPager2.f2950d < itemCount - 1) {
            z0.l(viewPager2, new m1.c(i10), tVar);
        }
        if (viewPager2.f2950d > 0) {
            z0.l(viewPager2, new m1.c(i3), dVar);
        }
    }

    public h(Typeface typeface, s1.b bVar) {
        int i3;
        int i10;
        int i11;
        int i12;
        this.f19149d = typeface;
        this.f19146a = bVar;
        this.f19148c = new androidx.emoji2.text.r(1024);
        int a3 = bVar.a(6);
        if (a3 != 0) {
            int i13 = a3 + bVar.f15694a;
            i3 = ((ByteBuffer) bVar.f15697d).getInt(((ByteBuffer) bVar.f15697d).getInt(i13) + i13);
        } else {
            i3 = 0;
        }
        this.f19147b = new char[i3 * 2];
        int a10 = bVar.a(6);
        if (a10 != 0) {
            int i14 = a10 + bVar.f15694a;
            i10 = ((ByteBuffer) bVar.f15697d).getInt(((ByteBuffer) bVar.f15697d).getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            androidx.emoji2.text.n nVar = new androidx.emoji2.text.n(this, i15);
            s1.a b3 = nVar.b();
            int a11 = b3.a(4);
            Character.toChars(a11 != 0 ? ((ByteBuffer) b3.f15697d).getInt(a11 + b3.f15694a) : 0, (char[]) this.f19147b, i15 * 2);
            s1.a b10 = nVar.b();
            int a12 = b10.a(16);
            if (a12 != 0) {
                int i16 = a12 + b10.f15694a;
                i11 = ((ByteBuffer) b10.f15697d).getInt(((ByteBuffer) b10.f15697d).getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            pd.a("invalid metadata codepoint length", i11 > 0);
            s1.a b11 = nVar.b();
            int a13 = b11.a(16);
            if (a13 != 0) {
                int i17 = a13 + b11.f15694a;
                i12 = ((ByteBuffer) b11.f15697d).getInt(((ByteBuffer) b11.f15697d).getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            ((androidx.emoji2.text.r) this.f19148c).a(nVar, 0, i12 - 1);
        }
    }

    public h(Context context) {
        this.f19146a = context;
    }
}
