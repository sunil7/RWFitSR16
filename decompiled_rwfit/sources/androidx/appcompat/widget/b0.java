package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import com.google.android.gms.internal.mlkit_vision_barcode.eg;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.sb;
import com.google.android.gms.internal.mlkit_vision_barcode.ye;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class b0 implements h8.a {

    /* renamed from: a, reason: collision with root package name */
    public int f872a;

    /* renamed from: b, reason: collision with root package name */
    public Object f873b;

    /* renamed from: c, reason: collision with root package name */
    public Object f874c;

    public /* synthetic */ b0(int i3, Object obj, Object obj2) {
        this.f873b = obj;
        this.f874c = obj2;
        this.f872a = i3;
    }

    public void a(Object obj) {
        int i3 = this.f872a;
        if (i3 == 4) {
            Object[] objArr = new Object[5];
            ((Object[]) this.f874c)[4] = objArr;
            this.f874c = objArr;
            i3 = 0;
        }
        ((Object[]) this.f874c)[i3] = obj;
        this.f872a = i3 + 1;
    }

    public void b() {
        n3 n3Var;
        ImageView imageView = (ImageView) this.f873b;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            n1.a(drawable);
        }
        if (drawable == null || (n3Var = (n3) this.f874c) == null) {
            return;
        }
        y.e(drawable, n3Var, imageView.getDrawableState());
    }

    public void c(com.liulishuo.filedownloader.download.d dVar) {
        dVar.g(dVar.f11411f.J(dVar.f11408b.h()));
        com.liulishuo.filedownloader.download.f fVar = dVar.f11407a;
        FileDownloadModel fileDownloadModel = fVar.f11434a;
        fileDownloadModel.D((byte) 1);
        fVar.f11435b.l(fileDownloadModel.h());
        fVar.i((byte) 1);
        synchronized (this) {
            ((SparseArray) this.f873b).put(dVar.f11408b.h(), dVar);
        }
        ((ThreadPoolExecutor) this.f874c).execute(dVar);
        int i3 = this.f872a;
        if (i3 < 600) {
            this.f872a = i3 + 1;
        } else {
            d();
            this.f872a = 0;
        }
    }

    public synchronized void d() {
        try {
            SparseArray sparseArray = new SparseArray();
            int size = ((SparseArray) this.f873b).size();
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = ((SparseArray) this.f873b).keyAt(i3);
                com.liulishuo.filedownloader.download.d dVar = (com.liulishuo.filedownloader.download.d) ((SparseArray) this.f873b).get(keyAt);
                if (dVar != null && dVar.h()) {
                    sparseArray.put(keyAt, dVar);
                }
            }
            this.f873b = sparseArray;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void e(AttributeSet attributeSet, int i3) {
        int resourceId;
        ImageView imageView = (ImageView) this.f873b;
        de.o I = de.o.I(imageView.getContext(), attributeSet, R$styleable.AppCompatImageView, i3);
        l1.z0.m(imageView, imageView.getContext(), R$styleable.AppCompatImageView, attributeSet, (TypedArray) I.f12378c, i3);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = (TypedArray) I.f12378c;
            if (drawable == null && (resourceId = typedArray.getResourceId(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = pb.b(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                n1.a(drawable);
            }
            if (typedArray.hasValue(R$styleable.AppCompatImageView_tint)) {
                androidx.core.widget.g.c(imageView, I.v(R$styleable.AppCompatImageView_tint));
            }
            if (typedArray.hasValue(R$styleable.AppCompatImageView_tintMode)) {
                androidx.core.widget.g.d(imageView, n1.c(typedArray.getInt(R$styleable.AppCompatImageView_tintMode, -1), null));
            }
            I.K();
        } catch (Throwable th2) {
            I.K();
            throw th2;
        }
    }

    @Override // h8.a
    public Object execute() {
        ((f8.g) this.f873b).f13523d.a((a8.b) this.f874c, this.f872a + 1, false);
        return null;
    }

    public void f(int i3) {
        ImageView imageView = (ImageView) this.f873b;
        if (i3 != 0) {
            Drawable b3 = pb.b(imageView.getContext(), i3);
            if (b3 != null) {
                n1.a(b3);
            }
            imageView.setImageDrawable(b3);
        } else {
            imageView.setImageDrawable(null);
        }
        b();
    }

    public synchronized boolean g(int i3) {
        synchronized (this) {
            d();
        }
        if (((SparseArray) this.f873b).size() > 0) {
            o6.b(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int a3 = ye.d.a(i3);
        List<Runnable> shutdownNow = ((ThreadPoolExecutor) this.f874c).shutdownNow();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a3, a3, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ye.b("Network"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f874c = threadPoolExecutor;
        if (shutdownNow.size() > 0) {
            o6.b(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        return true;
    }

    public byte[] h(int i3) {
        ((a2.i) this.f874c).f45i = Boolean.valueOf(1 == (i3 ^ 1));
        a2.i iVar = (a2.i) this.f874c;
        iVar.f43g = Boolean.FALSE;
        ye yeVar = new ye(iVar);
        n.g0 g0Var = (n.g0) this.f873b;
        g0Var.f16174a = yeVar;
        try {
            eg.b();
            eg egVar = eg.f9287c;
            if (i3 == 0) {
                sb sbVar = new sb(g0Var);
                tb.d dVar = new tb.d();
                egVar.a(dVar);
                dVar.f18603d = true;
                StringWriter stringWriter = new StringWriter();
                try {
                    tb.e eVar = new tb.e(stringWriter, dVar.f18600a, dVar.f18601b, dVar.f18602c, dVar.f18603d);
                    eVar.e(sbVar);
                    eVar.g();
                    eVar.f18605b.flush();
                } catch (IOException unused) {
                }
                return stringWriter.toString().getBytes("utf-8");
            }
            sb sbVar2 = new sb(g0Var);
            com.google.android.gms.internal.mlkit_vision_barcode.n0 n0Var = new com.google.android.gms.internal.mlkit_vision_barcode.n0();
            n0Var.f9441a = new HashMap();
            n0Var.f9442b = new HashMap();
            n0Var.f9443c = com.google.android.gms.internal.mlkit_vision_barcode.n0.f9440d;
            egVar.a(n0Var);
            HashMap hashMap = new HashMap((HashMap) n0Var.f9441a);
            HashMap hashMap2 = new HashMap((HashMap) n0Var.f9442b);
            com.google.android.gms.internal.mlkit_vision_barcode.k0 k0Var = (com.google.android.gms.internal.mlkit_vision_barcode.k0) n0Var.f9443c;
            com.google.android.gms.internal.mlkit_vision_barcode.n0 n0Var2 = new com.google.android.gms.internal.mlkit_vision_barcode.n0();
            n0Var2.f9441a = hashMap;
            n0Var2.f9442b = hashMap2;
            n0Var2.f9443c = k0Var;
            return n0Var2.b(sbVar2);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public b0(n.g0 g0Var, int i3) {
        this.f874c = new a2.i();
        this.f873b = g0Var;
        eg.b();
        this.f872a = i3;
    }

    public b0() {
        Object[] objArr = new Object[5];
        this.f873b = objArr;
        this.f874c = objArr;
    }

    public b0(ImageView imageView) {
        this.f872a = 0;
        this.f873b = imageView;
    }
}
