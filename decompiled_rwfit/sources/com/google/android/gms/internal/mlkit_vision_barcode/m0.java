package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class m0 implements rb.d {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f9413f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final rb.b f9414g;

    /* renamed from: h, reason: collision with root package name */
    public static final rb.b f9415h;

    /* renamed from: i, reason: collision with root package name */
    public static final k0 f9416i;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f9417a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9418b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f9419c;

    /* renamed from: d, reason: collision with root package name */
    public final k0 f9420d;
    public final o0 e = new o0(this, 0);

    static {
        zzfd zzfdVar = zzfd.zza;
        f9414g = new rb.b("key", l0.y(l0.w(j0.class, new g0(1, zzfdVar))));
        f9415h = new rb.b("value", l0.y(l0.w(j0.class, new g0(2, zzfdVar))));
        f9416i = new k0(0);
    }

    public m0(ByteArrayOutputStream byteArrayOutputStream, HashMap hashMap, HashMap hashMap2, k0 k0Var) {
        this.f9417a = byteArrayOutputStream;
        this.f9418b = hashMap;
        this.f9419c = hashMap2;
        this.f9420d = k0Var;
    }

    public static int f(rb.b bVar) {
        j0 j0Var = (j0) ((Annotation) bVar.f18110b.get(j0.class));
        if (j0Var != null) {
            return ((g0) j0Var).f9302a;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @Override // rb.d
    public final rb.d a(rb.b bVar, Object obj) {
        b(bVar, obj, true);
        return this;
    }

    public final void b(rb.b bVar, Object obj, boolean z5) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z5 && charSequence.length() == 0) {
                return;
            }
            h((f(bVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f9413f);
            h(bytes.length);
            this.f9417a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                b(bVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                g(f9416i, bVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (z5 && doubleValue == 0.0d) {
                return;
            }
            h((f(bVar) << 3) | 1);
            this.f9417a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(doubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (z5 && floatValue == 0.0f) {
                return;
            }
            h((f(bVar) << 3) | 5);
            this.f9417a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
            return;
        }
        if (obj instanceof Number) {
            e(bVar, ((Number) obj).longValue(), z5);
            return;
        }
        if (obj instanceof Boolean) {
            c(bVar, ((Boolean) obj).booleanValue() ? 1 : 0, z5);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z5 && bArr.length == 0) {
                return;
            }
            h((f(bVar) << 3) | 2);
            h(bArr.length);
            this.f9417a.write(bArr);
            return;
        }
        rb.c cVar = (rb.c) this.f9418b.get(obj.getClass());
        if (cVar != null) {
            g(cVar, bVar, obj, z5);
            return;
        }
        rb.e eVar = (rb.e) this.f9419c.get(obj.getClass());
        if (eVar != null) {
            o0 o0Var = this.e;
            o0Var.f9454b = false;
            o0Var.f9456d = bVar;
            o0Var.f9455c = z5;
            eVar.a(obj, o0Var);
            return;
        }
        if (obj instanceof i0) {
            c(bVar, ((i0) obj).zza(), true);
        } else if (obj instanceof Enum) {
            c(bVar, ((Enum) obj).ordinal(), true);
        } else {
            g(this.f9420d, bVar, obj, z5);
        }
    }

    public final void c(rb.b bVar, int i3, boolean z5) {
        if (z5 && i3 == 0) {
            return;
        }
        j0 j0Var = (j0) ((Annotation) bVar.f18110b.get(j0.class));
        if (j0Var == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        g0 g0Var = (g0) j0Var;
        int ordinal = g0Var.f9303b.ordinal();
        int i10 = g0Var.f9302a;
        if (ordinal == 0) {
            h(i10 << 3);
            h(i3);
        } else if (ordinal == 1) {
            h(i10 << 3);
            h((i3 + i3) ^ (i3 >> 31));
        } else {
            if (ordinal != 2) {
                return;
            }
            h((i10 << 3) | 5);
            this.f9417a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i3).array());
        }
    }

    @Override // rb.d
    public final /* synthetic */ rb.d d(rb.b bVar, long j4) {
        e(bVar, j4, true);
        return this;
    }

    public final void e(rb.b bVar, long j4, boolean z5) {
        if (z5 && j4 == 0) {
            return;
        }
        j0 j0Var = (j0) ((Annotation) bVar.f18110b.get(j0.class));
        if (j0Var == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        g0 g0Var = (g0) j0Var;
        int ordinal = g0Var.f9303b.ordinal();
        int i3 = g0Var.f9302a;
        if (ordinal == 0) {
            h(i3 << 3);
            i(j4);
        } else if (ordinal == 1) {
            h(i3 << 3);
            i((j4 >> 63) ^ (j4 + j4));
        } else {
            if (ordinal != 2) {
                return;
            }
            h((i3 << 3) | 1);
            this.f9417a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j4).array());
        }
    }

    public final void g(rb.c cVar, rb.b bVar, Object obj, boolean z5) {
        h0 h0Var = new h0(0);
        h0Var.f9325b = 0L;
        try {
            OutputStream outputStream = this.f9417a;
            this.f9417a = h0Var;
            try {
                cVar.a(obj, this);
                this.f9417a = outputStream;
                long j4 = h0Var.f9325b;
                h0Var.close();
                if (z5 && j4 == 0) {
                    return;
                }
                h((f(bVar) << 3) | 2);
                i(j4);
                cVar.a(obj, this);
            } catch (Throwable th2) {
                this.f9417a = outputStream;
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                h0Var.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public final void h(int i3) {
        while (true) {
            int i10 = i3 & 127;
            if ((i3 & (-128)) == 0) {
                this.f9417a.write(i10);
                return;
            } else {
                this.f9417a.write(i10 | 128);
                i3 >>>= 7;
            }
        }
    }

    public final void i(long j4) {
        while (true) {
            int i3 = ((int) j4) & 127;
            if (((-128) & j4) == 0) {
                this.f9417a.write(i3);
                return;
            } else {
                this.f9417a.write(i3 | 128);
                j4 >>>= 7;
            }
        }
    }
}
