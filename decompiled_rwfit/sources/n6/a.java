package n6;

import android.bluetooth.BluetoothDevice;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Handler;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.j1;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.x;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.internal.mlkit_vision_barcode.wb;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import de.n;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import l1.h0;
import l1.v1;
import l1.w;
import l1.x1;
import l1.z0;
import o9.i;
import oh.p;
import p7.d;
import qd.h;
import rg.j;
import t.p0;
import vg.g;
import vg.o;
import wa.f;
import x.c;
import ye.e;

/* loaded from: classes.dex */
public class a implements v4.a, d, rd.b, re.a, j1, w4.a, i, c, vh.c, f, x.a, w, o, g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16380a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16381b;

    public /* synthetic */ a(Object obj, int i3) {
        this.f16380a = i3;
        this.f16381b = obj;
    }

    public static FileDownloadModel R(Cursor cursor) {
        FileDownloadModel fileDownloadModel = new FileDownloadModel();
        fileDownloadModel.z(cursor.getInt(cursor.getColumnIndex(FileDownloadModel.ID)));
        fileDownloadModel.G(cursor.getString(cursor.getColumnIndex("url")));
        fileDownloadModel.B(cursor.getString(cursor.getColumnIndex(FileDownloadModel.PATH)), cursor.getShort(cursor.getColumnIndex(FileDownloadModel.PATH_AS_DIRECTORY)) == 1);
        fileDownloadModel.D((byte) cursor.getShort(cursor.getColumnIndex(FileDownloadModel.STATUS)));
        fileDownloadModel.C(cursor.getLong(cursor.getColumnIndex(FileDownloadModel.SOFAR)));
        fileDownloadModel.E(cursor.getLong(cursor.getColumnIndex(FileDownloadModel.TOTAL)));
        fileDownloadModel.w(cursor.getString(cursor.getColumnIndex(FileDownloadModel.ERR_MSG)));
        fileDownloadModel.v(cursor.getString(cursor.getColumnIndex(FileDownloadModel.ETAG)));
        fileDownloadModel.x(cursor.getString(cursor.getColumnIndex(FileDownloadModel.FILENAME)));
        fileDownloadModel.u(cursor.getInt(cursor.getColumnIndex(FileDownloadModel.CONNECTION_COUNT)));
        return fileDownloadModel;
    }

    private final void V(x xVar) {
    }

    @Override // re.a
    public void B(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            o6.b(this, "update but model == null!", new Object[0]);
            return;
        }
        FileDownloadModel L = L(fileDownloadModel.h());
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f16381b;
        if (L != null) {
            sQLiteDatabase.update("filedownloader", fileDownloadModel.H(), "_id = ? ", new String[]{String.valueOf(fileDownloadModel.h())});
        } else {
            sQLiteDatabase.insert("filedownloader", null, fileDownloadModel.H());
        }
    }

    @Override // x.c
    public void C(Throwable th2) {
        ((p0) this.f16381b).close();
    }

    @Override // w4.a
    public void E(int i3) {
        s3.f fVar = (s3.f) this.f16381b;
        if (fVar.f18182f == null) {
            r3.a aVar = fVar.f18184h;
            if (aVar != null) {
                aVar.e(fVar.f18178a.getCurrentItem(), i3, 0);
                return;
            }
            return;
        }
        int currentItem = fVar.f18178a.getCurrentItem();
        if (currentItem >= fVar.f18182f.size() - 1) {
            currentItem = fVar.f18182f.size() - 1;
        }
        if (i3 >= ((List) fVar.e.get(currentItem)).size() - 1) {
            i3 = ((List) fVar.e.get(currentItem)).size() - 1;
        }
        int size = fVar.f18180c.getCurrentItem() >= ((List) ((List) fVar.f18182f.get(currentItem)).get(i3)).size() + (-1) ? ((List) ((List) fVar.f18182f.get(currentItem)).get(i3)).size() - 1 : fVar.f18180c.getCurrentItem();
        fVar.f18180c.setAdapter(new a((List) ((List) fVar.f18182f.get(fVar.f18178a.getCurrentItem())).get(i3), 2));
        fVar.f18180c.setCurrentItem(size);
        r3.a aVar2 = fVar.f18184h;
        if (aVar2 != null) {
            aVar2.e(fVar.f18178a.getCurrentItem(), i3, size);
        }
    }

    @Override // re.a
    public void F(int i3) {
        remove(i3);
    }

    @Override // re.a
    public void G(int i3, int i10, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j4));
        ((SQLiteDatabase) this.f16381b).update("filedownloaderConnection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i3), Integer.toString(i10)});
    }

    @Override // re.a
    public void H(int i3, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.STATUS, (Byte) (byte) 3);
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j4));
        X(i3, contentValues);
    }

    @Override // re.a
    public void I(int i3, int i10, long j4, long j10, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j4));
        contentValues.put(FileDownloadModel.TOTAL, Long.valueOf(j10));
        contentValues.put(FileDownloadModel.ETAG, str);
        contentValues.put(FileDownloadModel.CONNECTION_COUNT, Integer.valueOf(i10));
        X(i3, contentValues);
    }

    @Override // re.a
    public ArrayList J(int i3) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f16381b;
            int i10 = e.f20123a;
            Locale locale = Locale.ENGLISH;
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM filedownloaderConnection WHERE id = ?", new String[]{Integer.toString(i3)});
            while (cursor.moveToNext()) {
                ve.a aVar = new ve.a();
                aVar.f19231a = i3;
                aVar.f19232b = cursor.getInt(cursor.getColumnIndex("connectionIndex"));
                aVar.f19233c = cursor.getLong(cursor.getColumnIndex("startOffset"));
                aVar.f19234d = cursor.getLong(cursor.getColumnIndex("currentOffset"));
                aVar.e = cursor.getLong(cursor.getColumnIndex("endOffset"));
                arrayList.add(aVar);
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @Override // wa.f
    public ViewGroup.LayoutParams K() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    @Override // re.a
    public FileDownloadModel L(int i3) {
        Throwable th2;
        Cursor cursor;
        try {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f16381b;
            int i10 = e.f20123a;
            Locale locale = Locale.ENGLISH;
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM filedownloader WHERE _id = ?", new String[]{Integer.toString(i3)});
            try {
                if (!cursor.moveToNext()) {
                    cursor.close();
                    return null;
                }
                FileDownloadModel R = R(cursor);
                cursor.close();
                return R;
            } catch (Throwable th3) {
                th2 = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    @Override // re.a
    public void N(int i3, int i10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.CONNECTION_COUNT, Integer.valueOf(i10));
        ((SQLiteDatabase) this.f16381b).update("filedownloader", contentValues, "_id = ? ", new String[]{Integer.toString(i3)});
    }

    @Override // re.a
    public void O(int i3, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.STATUS, (Byte) (byte) -2);
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j4));
        X(i3, contentValues);
    }

    @Override // l1.w
    public x1 P(View view, x1 x1Var) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f16381b;
        if (!k1.b.a(coordinatorLayout.f1899n, x1Var)) {
            coordinatorLayout.f1899n = x1Var;
            boolean z5 = x1Var.d() > 0;
            coordinatorLayout.f1900o = z5;
            coordinatorLayout.setWillNotDraw(!z5 && coordinatorLayout.getBackground() == null);
            v1 v1Var = x1Var.f15738a;
            if (!v1Var.m()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = coordinatorLayout.getChildAt(i3);
                    WeakHashMap weakHashMap = z0.f15748a;
                    if (h0.b(childAt) && ((x0.f) childAt.getLayoutParams()).f19716a != null && v1Var.m()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return x1Var;
    }

    public ByteBuffer S() {
        return ((Image.Plane) this.f16381b).getBuffer();
    }

    public int T() {
        return ((Image.Plane) this.f16381b).getPixelStride();
    }

    public int U() {
        return ((Image.Plane) this.f16381b).getRowStride();
    }

    public void W(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < i3; i10++) {
            if (i10 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f16381b = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public void X(int i3, ContentValues contentValues) {
        ((SQLiteDatabase) this.f16381b).update("filedownloader", contentValues, "_id = ? ", new String[]{String.valueOf(i3)});
    }

    @Override // rd.b
    public void a(x xVar) {
        switch (this.f16380a) {
            case 9:
                break;
            default:
                ee.c.e(((h) this.f16381b).f17926c.f17897a, "getDeviceInfoWithConnection#getDevMD5", "onError, " + xVar);
                break;
        }
    }

    @Override // x.a
    /* renamed from: apply */
    public ob.a mo0apply(Object obj) {
        return x.i.c(((k.a) this.f16381b).apply(obj));
    }

    @Override // re.a
    public void clear() {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f16381b;
        sQLiteDatabase.delete("filedownloader", null, null);
        sQLiteDatabase.delete("filedownloaderConnection", null, null);
    }

    @Override // vg.g
    public void f(Object obj) {
        xg.c.b(obj, "value is null");
        ((g) this.f16381b).f(new j(obj));
    }

    @Override // wa.f
    public int getHeight() {
        return ((ExtendedFloatingActionButton) this.f16381b).getMeasuredHeight();
    }

    @Override // v4.a
    public Object getItem(int i3) {
        if (i3 < 0) {
            return "";
        }
        List list = (List) this.f16381b;
        return i3 < list.size() ? list.get(i3) : "";
    }

    @Override // wa.f
    public int getWidth() {
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.f16381b;
        return (extendedFloatingActionButton.getMeasuredWidth() - (extendedFloatingActionButton.getCollapsedPadding() * 2)) + extendedFloatingActionButton.f10491z + extendedFloatingActionButton.A;
    }

    @Override // o9.i, vg.b
    public void i(Object obj, Object obj2) {
        switch (this.f16380a) {
            case 14:
                ia.g gVar = (ia.g) obj2;
                s9.a aVar = (s9.a) ((s9.c) obj).q();
                Parcel g10 = aVar.g();
                da.a.c(g10, (TelemetryData) this.f16381b);
                try {
                    aVar.f9200b.transact(1, g10, null, 1);
                    g10.recycle();
                    gVar.a(null);
                    return;
                } catch (Throwable th2) {
                    g10.recycle();
                    throw th2;
                }
            default:
                u9.e eVar = new u9.e((ia.g) obj2, 1);
                u9.d dVar = (u9.d) ((u9.g) obj).q();
                ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) this.f16381b;
                Parcel g11 = dVar.g();
                da.a.d(g11, eVar);
                da.a.c(g11, apiFeatureRequest);
                g11.writeStrongBinder(null);
                dVar.k(g11, 2);
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh.c
    public Iterator iterator() {
        gh.a<eh.g> aVar;
        final p block = (p) this.f16381b;
        kotlin.jvm.internal.e.f(block, "block");
        final vh.d dVar = new vh.d();
        if (block instanceof BaseContinuationImpl) {
            aVar = ((BaseContinuationImpl) block).create(dVar, dVar);
        } else {
            final gh.e context = dVar.getContext();
            aVar = context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(dVar, block, dVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                final /* synthetic */ Object $receiver$inlined;
                final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(dVar);
                    this.$this_createCoroutineUnintercepted$inlined = block;
                    this.$receiver$inlined = dVar;
                    kotlin.jvm.internal.e.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            throw new IllegalStateException("This coroutine had already completed");
                        }
                        this.label = 2;
                        wb.a(obj);
                        return obj;
                    }
                    this.label = 1;
                    wb.a(obj);
                    kotlin.jvm.internal.e.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    p pVar = this.$this_createCoroutineUnintercepted$inlined;
                    kotlin.jvm.internal.i.c(pVar);
                    return pVar.invoke(this.$receiver$inlined, this);
                }
            } : new ContinuationImpl(dVar, context, block, dVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                final /* synthetic */ Object $receiver$inlined;
                final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(dVar, context);
                    this.$this_createCoroutineUnintercepted$inlined = block;
                    this.$receiver$inlined = dVar;
                    kotlin.jvm.internal.e.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            throw new IllegalStateException("This coroutine had already completed");
                        }
                        this.label = 2;
                        wb.a(obj);
                        return obj;
                    }
                    this.label = 1;
                    wb.a(obj);
                    kotlin.jvm.internal.e.d(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    p pVar = this.$this_createCoroutineUnintercepted$inlined;
                    kotlin.jvm.internal.i.c(pVar);
                    return pVar.invoke(this.$receiver$inlined, this);
                }
            };
        }
        dVar.f19268c = aVar;
        return dVar;
    }

    @Override // re.a
    public void l(int i3) {
    }

    @Override // re.a
    public void m(int i3, Exception exc, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.ERR_MSG, exc.toString());
        contentValues.put(FileDownloadModel.STATUS, (Byte) (byte) -1);
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j4));
        X(i3, contentValues);
    }

    @Override // re.a
    public void o(int i3) {
        ((SQLiteDatabase) this.f16381b).execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i3);
    }

    @Override // rd.b
    public void onSuccess(Object obj) {
        switch (this.f16380a) {
            case 9:
                Handler handler = ((n) this.f16381b).f12375a.M;
                if (handler.hasMessages(4672)) {
                    handler.removeMessages(4672);
                    handler.sendEmptyMessage(4672);
                    break;
                }
                break;
            case 10:
                String str = (String) obj;
                h hVar = (h) this.f16381b;
                ee.c.e(hVar.f17926c.f17897a, "getDeviceInfoWithConnection#getDevMD5", "onSuccess, MD5 : " + str);
                fc.c cVar = hVar.f17926c.f17899c;
                BluetoothDevice bluetoothDevice = hVar.f17925b;
                ud.b b3 = cVar.b(bluetoothDevice);
                if (b3 == null) {
                    b3 = new ud.b();
                }
                b3.f19058d = str;
                cVar.e(bluetoothDevice, b3);
                break;
            default:
                break;
        }
    }

    @Override // re.a
    public void r(int i3, Exception exc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.ERR_MSG, exc.toString());
        contentValues.put(FileDownloadModel.STATUS, (Byte) (byte) 5);
        X(i3, contentValues);
    }

    @Override // re.a
    public boolean remove(int i3) {
        return ((SQLiteDatabase) this.f16381b).delete("filedownloader", "_id = ?", new String[]{String.valueOf(i3)}) != 0;
    }

    @Override // re.a
    public void s(int i3) {
    }

    @Override // wa.f
    public int u() {
        return ((ExtendedFloatingActionButton) this.f16381b).A;
    }

    @Override // re.a
    public void v(ve.a aVar) {
        ((SQLiteDatabase) this.f16381b).insert("filedownloaderConnection", null, aVar.a());
    }

    @Override // re.a
    public void w(long j4, String str, String str2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.STATUS, (Byte) (byte) 2);
        contentValues.put(FileDownloadModel.TOTAL, Long.valueOf(j4));
        contentValues.put(FileDownloadModel.ETAG, str);
        contentValues.put(FileDownloadModel.FILENAME, str2);
        X(i3, contentValues);
    }

    @Override // wa.f
    public int x() {
        return ((ExtendedFloatingActionButton) this.f16381b).f10491z;
    }

    @Override // androidx.camera.core.impl.j1
    public e0 y() {
        return (e0) this.f16381b;
    }

    @Override // v4.a
    public int z() {
        return ((List) this.f16381b).size();
    }

    public /* synthetic */ a(u9.f fVar, ApiFeatureRequest apiFeatureRequest) {
        this.f16380a = 19;
        this.f16381b = apiFeatureRequest;
    }

    @Override // vg.o
    public Object apply(Object obj) {
        switch (this.f16380a) {
            case 25:
                return ((Class) this.f16381b).cast(obj);
            default:
                List list = (List) obj;
                Collections.sort(list, (Comparator) this.f16381b);
                return list;
        }
    }

    public a(byte b3, int i3) {
        this.f16380a = i3;
        switch (i3) {
            case 6:
                this.f16381b = (SmallDisplaySizeQuirk) p.a.f17285a.f(SmallDisplaySizeQuirk.class);
                break;
            case 8:
                this.f16381b = (ExtraCroppingQuirk) p.a.f17285a.f(ExtraCroppingQuirk.class);
                break;
            case 11:
                this.f16381b = new re.d(n6.f10047a, "filedownloader.db", null, 4).getWritableDatabase();
                break;
            case 22:
                this.f16381b = null;
                break;
            default:
                mc.g gVar = new mc.g(9);
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ye.b("LauncherTask"));
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                gVar.f16022b = threadPoolExecutor;
                this.f16381b = gVar;
                break;
        }
    }

    public a(int i3) {
        this.f16380a = 4;
        W(i3);
    }

    public a(i1 i1Var) {
        this.f16380a = 7;
        this.f16381b = (CaptureSessionOnClosedNotCalledQuirk) i1Var.f(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    public a(EditText editText) {
        this.f16380a = 17;
        o4.c cVar = new o4.c();
        cVar.f16732a = editText;
        t1.h hVar = new t1.h(editText);
        cVar.f16733b = hVar;
        editText.addTextChangedListener(hVar);
        if (t1.a.f18468b == null) {
            synchronized (t1.a.f18467a) {
                try {
                    if (t1.a.f18468b == null) {
                        t1.a aVar = new t1.a();
                        try {
                            t1.a.f18469c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, t1.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        t1.a.f18468b = aVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(t1.a.f18468b);
        this.f16381b = cVar;
    }
}
