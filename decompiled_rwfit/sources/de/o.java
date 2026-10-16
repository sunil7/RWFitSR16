package de;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.Size;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.y;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.k0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k1;
import androidx.recyclerview.widget.x0;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.example.test.ui.device.activity.e0;
import com.example.test.ui.device.activity.f0;
import com.google.android.datatransport.Priority;
import com.google.android.gms.internal.mlkit_vision_barcode.dg;
import com.google.android.gms.internal.mlkit_vision_barcode.ec;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.h6;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.barcode.internal.zzh;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import n.g0;
import n.m0;
import t.n0;
import t.p0;
import z3.s;

/* loaded from: classes.dex */
public final class o implements c8.b, com.google.gson.internal.i, h8.a, a5.a, m2.a, g8.e, x.c, l4.a {
    public static o e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12376a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12377b;

    /* renamed from: c, reason: collision with root package name */
    public Object f12378c;

    /* renamed from: d, reason: collision with root package name */
    public Object f12379d;

    public /* synthetic */ o(int i3, boolean z5) {
        this.f12376a = i3;
    }

    public static o H(Context context, AttributeSet attributeSet, int[] iArr) {
        return new o(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static o I(Context context, AttributeSet attributeSet, int[] iArr, int i3) {
        return new o(context, context.obtainStyledAttributes(attributeSet, iArr, i3, 0));
    }

    private final void L() {
    }

    public int A(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int childCount = ((x0) this.f12377b).f2801a.getChildCount();
        int i10 = i3;
        while (i10 < childCount) {
            androidx.recyclerview.widget.e eVar = (androidx.recyclerview.widget.e) this.f12378c;
            int b3 = i3 - (i10 - eVar.b(i10));
            if (b3 == 0) {
                while (eVar.d(i10)) {
                    i10++;
                }
                return i10;
            }
            i10 += b3;
        }
        return -1;
    }

    public Size[] B(int i3) {
        List list;
        ArrayList arrayList;
        HashMap hashMap = (HashMap) this.f12379d;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            if (((Size[]) hashMap.get(Integer.valueOf(i3))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) hashMap.get(Integer.valueOf(i3))).clone();
        }
        Size[] outputSizes = ((StreamConfigurationMap) ((a2.d) this.f12377b).f23b).getOutputSizes(i3);
        if (outputSizes == null || outputSizes.length == 0) {
            a0.e("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i3);
            return outputSizes;
        }
        o4.e eVar = (o4.e) this.f12378c;
        eVar.getClass();
        ArrayList arrayList2 = new ArrayList(Arrays.asList(outputSizes));
        if (((ExtraSupportedOutputSizeQuirk) eVar.f16737a) != null) {
            Size[] sizeArr = (i3 == 34 && "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL)) ? new Size[]{new Size(1440, 1080), new Size(960, 720)} : new Size[0];
            if (sizeArr.length > 0) {
                arrayList2.addAll(Arrays.asList(sizeArr));
            }
        }
        m0 m0Var = (m0) eVar.f16738b;
        m0Var.getClass();
        if (((ExcludedSupportedSizesQuirk) p.a.f17285a.f(ExcludedSupportedSizesQuirk.class)) == null) {
            list = new ArrayList();
        } else {
            String str = (String) m0Var.f16254b;
            String str2 = Build.BRAND;
            if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) {
                arrayList = new ArrayList();
                if (str.equals("0") && i3 == 256) {
                    arrayList.add(new Size(4160, 3120));
                    arrayList.add(new Size(4000, 3000));
                }
            } else if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) {
                arrayList = new ArrayList();
                if (str.equals("0") && i3 == 256) {
                    arrayList.add(new Size(4160, 3120));
                    arrayList.add(new Size(4000, 3000));
                }
            } else {
                if ("HUAWEI".equalsIgnoreCase(str2) && "HWANE".equalsIgnoreCase(Build.DEVICE)) {
                    arrayList = new ArrayList();
                    if (str.equals("0") && (i3 == 34 || i3 == 35)) {
                        arrayList.add(new Size(720, 720));
                        arrayList.add(new Size(400, 400));
                    }
                } else if (ExcludedSupportedSizesQuirk.c()) {
                    arrayList = new ArrayList();
                    if (str.equals("0")) {
                        if (i3 == 34) {
                            arrayList.add(new Size(4128, 3096));
                            arrayList.add(new Size(4128, 2322));
                            arrayList.add(new Size(3088, 3088));
                            arrayList.add(new Size(3264, 2448));
                            arrayList.add(new Size(3264, 1836));
                            arrayList.add(new Size(2048, 1536));
                            arrayList.add(new Size(2048, 1152));
                            arrayList.add(new Size(1920, 1080));
                        } else if (i3 == 35) {
                            arrayList.add(new Size(4128, 2322));
                            arrayList.add(new Size(3088, 3088));
                            arrayList.add(new Size(3264, 2448));
                            arrayList.add(new Size(3264, 1836));
                            arrayList.add(new Size(2048, 1536));
                            arrayList.add(new Size(2048, 1152));
                            arrayList.add(new Size(1920, 1080));
                        }
                    } else if (str.equals("1") && (i3 == 34 || i3 == 35)) {
                        arrayList.add(new Size(3264, 2448));
                        arrayList.add(new Size(3264, 1836));
                        arrayList.add(new Size(2448, 2448));
                        arrayList.add(new Size(1920, 1920));
                        arrayList.add(new Size(2048, 1536));
                        arrayList.add(new Size(2048, 1152));
                        arrayList.add(new Size(1920, 1080));
                    }
                } else if (ExcludedSupportedSizesQuirk.b()) {
                    arrayList = new ArrayList();
                    if (str.equals("0")) {
                        if (i3 == 34) {
                            arrayList.add(new Size(4128, 3096));
                            arrayList.add(new Size(4128, 2322));
                            arrayList.add(new Size(3088, 3088));
                            arrayList.add(new Size(3264, 2448));
                            arrayList.add(new Size(3264, 1836));
                            arrayList.add(new Size(2048, 1536));
                            arrayList.add(new Size(2048, 1152));
                            arrayList.add(new Size(1920, 1080));
                        } else if (i3 == 35) {
                            arrayList.add(new Size(2048, 1536));
                            arrayList.add(new Size(2048, 1152));
                            arrayList.add(new Size(1920, 1080));
                        }
                    } else if (str.equals("1") && (i3 == 34 || i3 == 35)) {
                        arrayList.add(new Size(2576, 1932));
                        arrayList.add(new Size(2560, 1440));
                        arrayList.add(new Size(1920, 1920));
                        arrayList.add(new Size(2048, 1536));
                        arrayList.add(new Size(2048, 1152));
                        arrayList.add(new Size(1920, 1080));
                    }
                } else if ("REDMI".equalsIgnoreCase(str2) && "joyeuse".equalsIgnoreCase(Build.DEVICE)) {
                    arrayList = new ArrayList();
                    if (str.equals("0") && i3 == 256) {
                        arrayList.add(new Size(9280, 6944));
                    }
                } else {
                    a0.e("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
                    list = Collections.EMPTY_LIST;
                }
            }
            list = arrayList;
        }
        if (!list.isEmpty()) {
            arrayList2.removeAll(list);
        }
        if (arrayList2.isEmpty()) {
            a0.e("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        Size[] sizeArr2 = (Size[]) arrayList2.toArray(new Size[0]);
        hashMap.put(Integer.valueOf(i3), sizeArr2);
        return (Size[]) sizeArr2.clone();
    }

    @Override // x.c
    public void C(Throwable th2) {
        ((androidx.camera.view.a) this.f12379d).e = null;
        ArrayList arrayList = (ArrayList) this.f12377b;
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((u) this.f12378c).n((androidx.camera.core.impl.k) obj);
        }
        arrayList.clear();
    }

    public a8.h D(x7.b bVar, x7.c cVar) {
        Set set = (Set) this.f12377b;
        if (set.contains(bVar)) {
            return new a8.h((a8.b) this.f12378c, bVar, cVar, (a8.i) this.f12379d);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, set));
    }

    public View E(int i3) {
        return ((x0) this.f12377b).f2801a.getChildAt(i3);
    }

    public int F() {
        return ((x0) this.f12377b).f2801a.getChildCount();
    }

    public void G(View view) {
        ((ArrayList) this.f12379d).add(view);
        x0 x0Var = (x0) this.f12377b;
        z1 L = RecyclerView.L(view);
        if (L != null) {
            L.onEnteredHiddenState(x0Var.f2801a);
        }
    }

    public void J(Lifecycle$Event lifecycle$Event) {
        androidx.fragment.app.h hVar = (androidx.fragment.app.h) this.f12379d;
        if (hVar != null) {
            hVar.run();
        }
        androidx.fragment.app.h hVar2 = new androidx.fragment.app.h((androidx.lifecycle.u) this.f12377b, lifecycle$Event);
        this.f12379d = hVar2;
        ((Handler) this.f12378c).postAtFrontOfQueue(hVar2);
    }

    public void K() {
        ((TypedArray) this.f12378c).recycle();
    }

    public void M(View view) {
        if (((ArrayList) this.f12379d).remove(view)) {
            x0 x0Var = (x0) this.f12377b;
            z1 L = RecyclerView.L(view);
            if (L != null) {
                L.onLeftHiddenState(x0Var.f2801a);
            }
        }
    }

    @Override // a5.a
    public void a(ec ecVar) {
        Iterator it = (Iterator) this.f12377b;
        boolean hasNext = it.hasNext();
        a5.a aVar = (a5.a) this.f12379d;
        if (!hasNext) {
            aVar.a(ecVar);
            return;
        }
        it.remove();
        a4.a aVar2 = (a4.a) this.f12378c;
        aVar2.getClass();
        Object next = it.next();
        kotlin.jvm.internal.e.d(next, "null cannot be cast to non-null type com.dh.imagepick.work.Worker<Builder of com.dh.imagepick.functions.BaseFunctionBuilder, Result of com.dh.imagepick.functions.BaseFunctionBuilder>");
        ((com.dh.imagepick.work.a) next).a(ecVar, new o(it, 21, aVar2, aVar));
    }

    /* JADX WARN: Finally extract failed */
    @Override // g8.e
    public Object apply(Object obj) {
        Object obj2;
        long insert;
        Object obj3 = null;
        boolean z5 = true;
        switch (this.f12376a) {
            case 25:
                int i3 = 1;
                Cursor cursor = (Cursor) obj;
                x7.b bVar = g8.g.e;
                while (cursor.moveToNext()) {
                    long j4 = cursor.getLong(0);
                    int i10 = cursor.getInt(7) != 0 ? i3 : 0;
                    g0 g0Var = new g0();
                    g0Var.f16178f = new HashMap();
                    String string = cursor.getString(i3);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    g0Var.f16174a = string;
                    g0Var.f16177d = Long.valueOf(cursor.getLong(2));
                    g0Var.e = Long.valueOf(cursor.getLong(3));
                    if (i10 != 0) {
                        String string2 = cursor.getString(4);
                        g0Var.f16176c = new a8.e(string2 == null ? g8.g.e : new x7.b(string2), cursor.getBlob(5));
                        obj2 = obj3;
                        i3 = 1;
                    } else {
                        String string3 = cursor.getString(4);
                        x7.b bVar2 = string3 == null ? g8.g.e : new x7.b(string3);
                        Cursor query = ((g8.g) this.f12377b).b().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j4)}, null, null, "sequence_num");
                        try {
                            Cursor cursor2 = query;
                            x7.b bVar3 = g8.g.e;
                            ArrayList arrayList = new ArrayList();
                            int i11 = 0;
                            while (cursor2.moveToNext()) {
                                byte[] blob = cursor2.getBlob(0);
                                arrayList.add(blob);
                                i11 += blob.length;
                            }
                            byte[] bArr = new byte[i11];
                            int i12 = 0;
                            int i13 = 0;
                            while (i12 < arrayList.size()) {
                                byte[] bArr2 = (byte[]) arrayList.get(i12);
                                Object obj4 = obj3;
                                System.arraycopy(bArr2, 0, bArr, i13, bArr2.length);
                                i13 += bArr2.length;
                                i12++;
                                obj3 = obj4;
                            }
                            obj2 = obj3;
                            i3 = 1;
                            query.close();
                            g0Var.f16176c = new a8.e(bVar2, bArr);
                        } catch (Throwable th2) {
                            query.close();
                            throw th2;
                        }
                    }
                    if (!cursor.isNull(6)) {
                        g0Var.f16175b = Integer.valueOf(cursor.getInt(6));
                    }
                    ((ArrayList) this.f12378c).add(new g8.b(j4, (a8.b) this.f12379d, g0Var.c()));
                    obj3 = obj2;
                }
                return obj3;
            default:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                x7.b bVar4 = g8.g.e;
                g8.g gVar = (g8.g) this.f12377b;
                long simpleQueryForLong = gVar.b().compileStatement("PRAGMA page_size").simpleQueryForLong() * gVar.b().compileStatement("PRAGMA page_count").simpleQueryForLong();
                g8.a aVar = gVar.f13890d;
                if (simpleQueryForLong >= aVar.f13877a) {
                    return -1L;
                }
                a8.b bVar5 = (a8.b) this.f12378c;
                Long c9 = g8.g.c(sQLiteDatabase, bVar5);
                if (c9 != null) {
                    insert = c9.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", bVar5.f120a);
                    contentValues.put("priority", Integer.valueOf(j8.a.a(bVar5.f122c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr3 = bVar5.f121b;
                    if (bArr3 != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr3, 0));
                    }
                    insert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                a8.a aVar2 = (a8.a) this.f12379d;
                a8.e eVar = aVar2.f117c;
                byte[] bArr4 = eVar.f129b;
                int length = bArr4.length;
                int i14 = aVar.e;
                boolean z6 = length <= i14;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(insert));
                contentValues2.put("transport_name", aVar2.f115a);
                contentValues2.put("timestamp_ms", Long.valueOf(aVar2.f118d));
                contentValues2.put("uptime_ms", Long.valueOf(aVar2.e));
                contentValues2.put("payload_encoding", eVar.f128a.f19820a);
                contentValues2.put("code", aVar2.f116b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z6));
                contentValues2.put("payload", z6 ? bArr4 : new byte[0]);
                long insert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z6) {
                    int ceil = (int) Math.ceil(bArr4.length / i14);
                    int i15 = 1;
                    while (i15 <= ceil) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr4, (i15 - 1) * i14, Math.min(i15 * i14, bArr4.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(insert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i15));
                        contentValues3.put("bytes", copyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                        i15++;
                        z5 = z5;
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(aVar2.f119f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(insert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(insert2);
        }
    }

    @Override // m2.a
    public View b() {
        return (LinearLayout) this.f12377b;
    }

    @Override // a5.a
    public void c(Exception exc) {
        ((a5.a) this.f12379d).c(exc);
    }

    @Override // l4.a
    public s d(s sVar, x3.f fVar) {
        Drawable drawable = (Drawable) sVar.get();
        if (drawable instanceof BitmapDrawable) {
            return ((d6.a) this.f12378c).d(g4.c.b((a4.b) this.f12377b, ((BitmapDrawable) drawable).getBitmap()), fVar);
        }
        if (drawable instanceof k4.c) {
            return ((l4.d) this.f12379d).d(sVar, fVar);
        }
        return null;
    }

    public void e(int[] iArr, ValueAnimator valueAnimator) {
        gc.b bVar = new gc.b(iArr, valueAnimator);
        valueAnimator.addListener((ab.q) this.f12379d);
        ((ArrayList) this.f12377b).add(bVar);
    }

    @Override // h8.a
    public Object execute() {
        e8.b bVar = (e8.b) this.f12377b;
        g8.g gVar = (g8.g) bVar.f12481d;
        gVar.getClass();
        a8.b bVar2 = (a8.b) this.f12378c;
        a8.a aVar = (a8.a) this.f12379d;
        Log.d("TransportRuntime.".concat("SQLiteEventStore"), "Storing event with priority=" + bVar2.f122c + ", name=" + aVar.f115a + " for destination " + bVar2.f120a);
        ((Long) gVar.e(new o(gVar, 26, bVar2, aVar))).getClass();
        bVar.f12478a.a(bVar2, 1, false);
        return null;
    }

    public void f(int i3, View view, boolean z5) {
        RecyclerView recyclerView = ((x0) this.f12377b).f2801a;
        int childCount = i3 < 0 ? recyclerView.getChildCount() : A(i3);
        ((androidx.recyclerview.widget.e) this.f12378c).e(childCount, z5);
        if (z5) {
            G(view);
        }
        recyclerView.addView(view, childCount);
        z1 L = RecyclerView.L(view);
        z0 z0Var = recyclerView.f2470l;
        if (z0Var != null && L != null) {
            z0Var.onViewAttachedToWindow(L);
        }
        ArrayList arrayList = recyclerView.B;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((k1) recyclerView.B.get(size)).a(view);
            }
        }
    }

    public void g(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z5) {
        RecyclerView recyclerView = ((x0) this.f12377b).f2801a;
        int childCount = i3 < 0 ? recyclerView.getChildCount() : A(i3);
        ((androidx.recyclerview.widget.e) this.f12378c).e(childCount, z5);
        if (z5) {
            G(view);
        }
        z1 L = RecyclerView.L(view);
        if (L != null) {
            if (!L.isTmpDetached() && !L.shouldIgnore()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + L + recyclerView.y());
            }
            L.clearTmpDetachFlag();
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    @Override // dh.a
    public Object get() {
        switch (this.f12376a) {
            case 4:
                return new a8.i(new gc.b(13), new ec.a(13), (e8.c) ((androidx.camera.core.impl.e) this.f12377b).get(), (f8.g) ((g0) this.f12378c).get(), (f8.h) ((v2.h) this.f12379d).get());
            default:
                return new f8.d((Context) ((yh.i) this.f12377b).f20163a, (g8.c) ((dh.a) this.f12378c).get(), (f8.b) ((eb.e) this.f12379d).get());
        }
    }

    public void h(int i3, int i10, byte[] bArr) {
        int i11;
        if (bArr.length <= 0 || i3 < 0 || i10 <= 0 || (i11 = i10 + i3) > bArr.length) {
            return;
        }
        try {
            ((ByteArrayOutputStream) this.f12378c).write(Arrays.copyOfRange(bArr, i3, i11));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public a8.b i() {
        String str = ((String) this.f12377b) == null ? " backendName" : "";
        if (((Priority) this.f12378c) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new a8.b((String) this.f12377b, (byte[]) this.f12379d, (Priority) this.f12378c);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public void j(c0.n nVar, Map.Entry entry) {
        c0.n nVar2 = (c0.n) entry.getValue();
        t.i iVar = null;
        t.i iVar2 = new t.i(nVar.f3334g.f1405a, ((e0.b) entry.getKey()).f12414d, nVar.f3331c ? (v) this.f12378c : null, ((e0.b) entry.getKey()).f12415f, ((e0.b) entry.getKey()).f12416g);
        int i3 = ((e0.b) entry.getKey()).f12413c;
        nVar2.getClass();
        y5.a();
        nVar2.a();
        pd.f("Consumer can only be linked once.", !nVar2.f3337j);
        nVar2.f3337j = true;
        c0.m mVar = nVar2.f3339l;
        x.b f2 = x.i.f(mVar.c(), new c0.l(nVar2, mVar, i3, iVar2, iVar), a6.d());
        f2.a(new x.h(0, f2, new ef.i(this, 8, nVar2, false)), a6.d());
    }

    public Bitmap k(BitmapFactory.Options options) {
        switch (this.f12376a) {
            case 23:
                com.bumptech.glide.load.resource.bitmap.a aVar = (com.bumptech.glide.load.resource.bitmap.a) ((com.bumptech.glide.load.data.i) this.f12377b).f6970b;
                aVar.reset();
                return BitmapFactory.decodeStream(aVar, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((com.bumptech.glide.load.data.i) this.f12379d).d().getFileDescriptor(), null, options);
        }
    }

    public Object l() {
        Object removeLast;
        synchronized (this.f12378c) {
            removeLast = ((ArrayDeque) this.f12377b).removeLast();
        }
        return removeLast;
    }

    public void m(int i3) {
        z1 L;
        int A = A(i3);
        ((androidx.recyclerview.widget.e) this.f12378c).f(A);
        RecyclerView recyclerView = ((x0) this.f12377b).f2801a;
        View childAt = recyclerView.getChildAt(A);
        if (childAt != null && (L = RecyclerView.L(childAt)) != null) {
            if (L.isTmpDetached() && !L.shouldIgnore()) {
                throw new IllegalArgumentException("called detach on an already detached child " + L + recyclerView.y());
            }
            L.addFlags(256);
        }
        recyclerView.detachViewFromParent(A);
    }

    public ia.m n(nc.a aVar) {
        ia.m mVar;
        zzh zzhVar = (zzh) this.f12379d;
        synchronized (zzhVar) {
            if (zzhVar.f11205a.get()) {
                MlKitException mlKitException = new MlKitException("This detector is already closed!", 14);
                mVar = new ia.m();
                mVar.g(mlKitException);
            } else if (aVar.f16460b < 32 || aVar.f16461c < 32) {
                MlKitException mlKitException2 = new MlKitException("InputImage width and height should be at least 32!", 3);
                mVar = new ia.m();
                mVar.g(mlKitException2);
            } else {
                mVar = zzhVar.f11206b.a(zzhVar.f11208d, new ff.l(zzhVar, aVar), (f0) zzhVar.f11207c.f7859b);
            }
        }
        e0 e0Var = new e0(zzhVar, aVar.f16460b, aVar.f16461c);
        mVar.getClass();
        ia.l lVar = ia.h.f14383a;
        ia.m mVar2 = new ia.m();
        mVar.f14399b.f(new ia.i(lVar, e0Var, mVar2, 5));
        mVar.k();
        return mVar2;
    }

    public void o(p0 p0Var) {
        Object l3;
        n0 u10 = p0Var.u();
        androidx.camera.core.impl.n nVar = u10 instanceof y.c ? ((y.c) u10).f19835a : null;
        if ((nVar.k() != CameraCaptureMetaData$AfState.LOCKED_FOCUSED && nVar.k() != CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) || nVar.g() != CameraCaptureMetaData$AeState.CONVERGED || nVar.h() != CameraCaptureMetaData$AwbState.CONVERGED) {
            ((n.x0) this.f12379d).getClass();
            p0Var.close();
            return;
        }
        synchronized (this.f12378c) {
            try {
                l3 = ((ArrayDeque) this.f12377b).size() >= 3 ? l() : null;
                ((ArrayDeque) this.f12377b).addFirst(p0Var);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (((n.x0) this.f12379d) == null || l3 == null) {
            return;
        }
        ((p0) l3).close();
    }

    @Override // x.c
    public void onSuccess(Object obj) {
        ((androidx.camera.view.a) this.f12379d).e = null;
    }

    public void p(Runnable runnable) {
        ((y2.i) this.f12377b).execute(runnable);
    }

    public androidx.lifecycle.m0 q(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return r("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public androidx.lifecycle.m0 r(String key, Class cls) {
        androidx.lifecycle.m0 d5;
        kotlin.jvm.internal.e.f(key, "key");
        q0 q0Var = (q0) this.f12377b;
        androidx.lifecycle.m0 viewModel = (androidx.lifecycle.m0) q0Var.f2386a.get(key);
        boolean isInstance = cls.isInstance(viewModel);
        androidx.lifecycle.p0 p0Var = (androidx.lifecycle.p0) this.f12378c;
        if (!isInstance) {
            w1.c cVar = new w1.c((w1.b) this.f12379d);
            cVar.f19464a.put(androidx.lifecycle.n0.f2382b, key);
            try {
                d5 = p0Var.v(cls, cVar);
            } catch (AbstractMethodError unused) {
                d5 = p0Var.d(cls);
            }
            androidx.lifecycle.m0 m0Var = (androidx.lifecycle.m0) q0Var.f2386a.put(key, d5);
            if (m0Var != null) {
                m0Var.onCleared();
            }
            return d5;
        }
        k0 k0Var = p0Var instanceof k0 ? (k0) p0Var : null;
        if (k0Var != null) {
            kotlin.jvm.internal.e.e(viewModel, "viewModel");
            androidx.lifecycle.n nVar = k0Var.f2373d;
            if (nVar != null) {
                androidx.lifecycle.l.a(viewModel, k0Var.e, nVar);
            }
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
    }

    public View s(int i3) {
        return ((x0) this.f12377b).f2801a.getChildAt(A(i3));
    }

    @Override // com.google.gson.internal.i
    public Object t() {
        try {
            return ((com.google.gson.internal.a) this.f12377b).h((Class) this.f12378c);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + ((Type) this.f12379d) + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e10);
        }
    }

    public String toString() {
        switch (this.f12376a) {
            case 10:
                return ((androidx.recyclerview.widget.e) this.f12378c).toString() + ", hidden list:" + ((ArrayList) this.f12379d).size();
            case 16:
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append((String) this.f12377b);
                sb2.append('{');
                o oVar = (o) ((o) this.f12378c).f12379d;
                String str = "";
                while (oVar != null) {
                    String str2 = (String) oVar.f12378c;
                    sb2.append(str);
                    String str3 = (String) oVar.f12377b;
                    if (str3 != null) {
                        sb2.append(str3);
                        sb2.append('=');
                    }
                    if (str2 == null || !str2.getClass().isArray()) {
                        sb2.append((Object) str2);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{str2});
                        sb2.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    oVar = (o) oVar.f12379d;
                    str = ", ";
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public int u() {
        return ((x0) this.f12377b).f2801a.getChildCount() - ((ArrayList) this.f12379d).size();
    }

    public ColorStateList v(int i3) {
        int resourceId;
        ColorStateList a3;
        TypedArray typedArray = (TypedArray) this.f12378c;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (a3 = pb.a((Context) this.f12377b, resourceId)) == null) ? typedArray.getColorStateList(i3) : a3;
    }

    public Drawable w(int i3) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f12378c;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) ? typedArray.getDrawable(i3) : pb.b((Context) this.f12377b, resourceId);
    }

    public Drawable x(int i3) {
        int resourceId;
        Drawable d5;
        if (!((TypedArray) this.f12378c).hasValue(i3) || (resourceId = ((TypedArray) this.f12378c).getResourceId(i3, 0)) == 0) {
            return null;
        }
        y a3 = y.a();
        Context context = (Context) this.f12377b;
        synchronized (a3) {
            d5 = a3.f1125a.d(context, resourceId, true);
        }
        return d5;
    }

    public Typeface y(int i3, int i10, s0 s0Var) {
        int resourceId = ((TypedArray) this.f12378c).getResourceId(i3, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f12379d) == null) {
            this.f12379d = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.f12379d;
        ThreadLocal threadLocal = b1.o.f3076a;
        Context context = (Context) this.f12377b;
        if (context.isRestricted()) {
            return null;
        }
        return b1.o.a(context, resourceId, typedValue, i10, s0Var, true, false);
    }

    public ImageHeaderParser$ImageType z() {
        switch (this.f12376a) {
            case 23:
                com.bumptech.glide.load.resource.bitmap.a aVar = (com.bumptech.glide.load.resource.bitmap.a) ((com.bumptech.glide.load.data.i) this.f12377b).f6970b;
                aVar.reset();
                return h6.b((a4.g) this.f12378c, aVar, (ArrayList) this.f12379d);
            default:
                com.bumptech.glide.load.data.i iVar = (com.bumptech.glide.load.data.i) this.f12379d;
                a4.g gVar = (a4.g) this.f12377b;
                ArrayList arrayList = (ArrayList) this.f12378c;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    x3.b bVar = (x3.b) arrayList.get(i3);
                    com.bumptech.glide.load.resource.bitmap.a aVar2 = null;
                    try {
                        com.bumptech.glide.load.resource.bitmap.a aVar3 = new com.bumptech.glide.load.resource.bitmap.a(new FileInputStream(iVar.d().getFileDescriptor()), gVar);
                        try {
                            ImageHeaderParser$ImageType c9 = bVar.c(aVar3);
                            try {
                                aVar3.close();
                            } catch (IOException unused) {
                            }
                            iVar.d();
                            if (c9 != ImageHeaderParser$ImageType.UNKNOWN) {
                                return c9;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            aVar2 = aVar3;
                            if (aVar2 != null) {
                                try {
                                    aVar2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            iVar.d();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public o(int i3, int[] iArr) {
        this.f12376a = 29;
        for (int i10 : iArr) {
            i3 |= i10;
        }
        ic.b bVar = new ic.b(i3);
        this.f12377b = new ConcurrentLinkedQueue();
        this.f12378c = new AtomicBoolean(false);
        mc.b bVar2 = (mc.b) gc.e.c().a(mc.b.class);
        bVar2.getClass();
        this.f12379d = new zzh(bVar, (mc.e) bVar2.f16004a.e(bVar), (Executor) bVar2.f16005b.f14027a.get(), dg.e(true != mc.a.c() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning"));
    }

    public /* synthetic */ o(Object obj, int i3, Object obj2, Object obj3) {
        this.f12376a = i3;
        this.f12377b = obj;
        this.f12378c = obj2;
        this.f12379d = obj3;
    }

    public o(int i3) {
        int i10 = 3;
        this.f12376a = i3;
        switch (i3) {
            case 14:
                this.f12377b = new ArrayList();
                this.f12378c = null;
                this.f12379d = new ab.q(this, i10);
                break;
            default:
                this.f12377b = o.class.getSimpleName();
                this.f12378c = new ByteArrayOutputStream();
                this.f12379d = new byte[]{-2, -36, -70};
                break;
        }
    }

    public o(ExecutorService executorService) {
        this.f12376a = 1;
        this.f12378c = new Handler(Looper.getMainLooper());
        this.f12379d = new w.d(this, 1);
        this.f12377b = new y2.i(executorService);
    }

    public o(LifecycleService lifecycleService) {
        this.f12376a = 8;
        this.f12377b = new androidx.lifecycle.u(lifecycleService);
        this.f12378c = new Handler();
    }

    public o(a4.g gVar, InputStream inputStream, ArrayList arrayList) {
        this.f12376a = 23;
        t4.f.c(gVar, "Argument must not be null");
        this.f12378c = gVar;
        t4.f.c(arrayList, "Argument must not be null");
        this.f12379d = arrayList;
        this.f12377b = new com.bumptech.glide.load.data.i(inputStream, gVar);
    }

    public o(q0 store, androidx.lifecycle.p0 p0Var, w1.b defaultCreationExtras) {
        this.f12376a = 9;
        kotlin.jvm.internal.e.f(store, "store");
        kotlin.jvm.internal.e.f(defaultCreationExtras, "defaultCreationExtras");
        this.f12377b = store;
        this.f12378c = p0Var;
        this.f12379d = defaultCreationExtras;
    }

    public o(StreamConfigurationMap streamConfigurationMap, o4.e eVar) {
        this.f12376a = 7;
        this.f12379d = new HashMap();
        new HashMap();
        new HashMap();
        this.f12377b = new a2.d(streamConfigurationMap, 4);
        this.f12378c = eVar;
    }

    public o(n.x0 x0Var) {
        this.f12376a = 11;
        this.f12378c = new Object();
        this.f12377b = new ArrayDeque(3);
        this.f12379d = x0Var;
    }

    public o(x0 x0Var) {
        this.f12376a = 10;
        this.f12377b = x0Var;
        this.f12378c = new androidx.recyclerview.widget.e();
        this.f12379d = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(q0 store, androidx.lifecycle.p0 p0Var) {
        this(store, p0Var, w1.a.f19463b);
        this.f12376a = 9;
        kotlin.jvm.internal.e.f(store, "store");
    }

    public o(Context context, TypedArray typedArray) {
        this.f12376a = 6;
        this.f12377b = context;
        this.f12378c = typedArray;
    }

    public o(Context context, LocationManager locationManager) {
        this.f12376a = 5;
        this.f12379d = new androidx.appcompat.app.m0();
        this.f12377b = context;
        this.f12378c = locationManager;
    }

    public o(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, a4.g gVar) {
        this.f12376a = 24;
        t4.f.c(gVar, "Argument must not be null");
        this.f12377b = gVar;
        t4.f.c(arrayList, "Argument must not be null");
        this.f12378c = arrayList;
        this.f12379d = new com.bumptech.glide.load.data.i(parcelFileDescriptor);
    }

    public o(v vVar, c0.f fVar) {
        this.f12376a = 12;
        this.f12378c = vVar;
        this.f12377b = fVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o(androidx.lifecycle.r0 r5) {
        /*
            r4 = this;
            r0 = 9
            r4.f12376a = r0
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.e.f(r5, r0)
            androidx.lifecycle.q0 r0 = r5.getViewModelStore()
            java.lang.String r1 = "owner.viewModelStore"
            kotlin.jvm.internal.e.e(r0, r1)
            boolean r1 = r5 instanceof androidx.lifecycle.j
            if (r1 == 0) goto L23
            r2 = r5
            androidx.lifecycle.j r2 = (androidx.lifecycle.j) r2
            androidx.lifecycle.p0 r2 = r2.getDefaultViewModelProviderFactory()
            java.lang.String r3 = "owner.defaultViewModelProviderFactory"
            kotlin.jvm.internal.e.e(r2, r3)
            goto L33
        L23:
            androidx.lifecycle.n0 r2 = androidx.lifecycle.n0.f2383c
            if (r2 != 0) goto L2e
            androidx.lifecycle.n0 r2 = new androidx.lifecycle.n0
            r2.<init>()
            androidx.lifecycle.n0.f2383c = r2
        L2e:
            androidx.lifecycle.n0 r2 = androidx.lifecycle.n0.f2383c
            kotlin.jvm.internal.e.c(r2)
        L33:
            if (r1 == 0) goto L41
            androidx.lifecycle.j r5 = (androidx.lifecycle.j) r5
            w1.b r5 = r5.getDefaultViewModelCreationExtras()
            java.lang.String r1 = "{\n        owner.defaultV…ModelCreationExtras\n    }"
            kotlin.jvm.internal.e.e(r5, r1)
            goto L43
        L41:
            w1.a r5 = w1.a.f19463b
        L43:
            r4.<init>(r0, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: de.o.<init>(androidx.lifecycle.r0):void");
    }

    public o(androidx.camera.view.a aVar, ArrayList arrayList, u uVar) {
        this.f12376a = 27;
        this.f12379d = aVar;
        this.f12377b = arrayList;
        this.f12378c = uVar;
    }

    public o(String str) {
        this.f12376a = 16;
        o oVar = new o(15, false);
        this.f12378c = oVar;
        this.f12379d = oVar;
        this.f12377b = str;
    }

    public o(Class cls, Type type) {
        Object mVar;
        this.f12376a = 17;
        this.f12378c = cls;
        this.f12379d = type;
        try {
            try {
                try {
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    mVar = new com.google.gson.internal.j(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    mVar = new com.google.gson.internal.m();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                mVar = new com.google.gson.internal.l(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            mVar = new com.google.gson.internal.k(intValue, declaredMethod3);
        }
        this.f12377b = mVar;
    }
}
