package i9;

import androidx.recyclerview.widget.x;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import com.google.android.gms.internal.mlkit_vision_barcode.td;
import com.google.android.gms.internal.mlkit_vision_common.i0;

/* loaded from: classes.dex */
public final class f implements rd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14374a;

    /* renamed from: b, reason: collision with root package name */
    public int f14375b;

    /* renamed from: c, reason: collision with root package name */
    public int f14376c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14377d;
    public final Object e;

    public f(String str, int i3, String str2) {
        this.f14374a = 3;
        this.f14377d = str;
        this.f14375b = i3;
        this.e = str2;
    }

    @Override // rd.b
    public void a(x xVar) {
        ((k6.b) this.e).p("upgradeStep04", xVar);
    }

    public Object b(long j4, boolean z5) {
        Object obj = null;
        long j10 = Format.OFFSET_SAMPLE_RELATIVE;
        while (this.f14376c > 0) {
            long j11 = j4 - ((long[]) this.f14377d)[this.f14375b];
            if (j11 < 0 && (z5 || (-j11) >= j10)) {
                break;
            }
            pc.b(this.f14376c > 0);
            Object[] objArr = (Object[]) this.e;
            int i3 = this.f14375b;
            Object obj2 = objArr[i3];
            objArr[i3] = null;
            this.f14375b = (i3 + 1) % objArr.length;
            this.f14376c--;
            j10 = j11;
            obj = obj2;
        }
        return obj;
    }

    @Override // rd.b
    public void onSuccess(Object obj) {
        byte[] bArr = (byte[]) obj;
        k6.b bVar = (k6.b) this.e;
        String str = bVar.f17897a;
        StringBuilder sb2 = new StringBuilder("read data, offset = ");
        int i3 = this.f14375b;
        sb2.append(i3);
        sb2.append(", length = ");
        int i10 = this.f14376c;
        sb2.append(i10);
        sb2.append(", data len = ");
        sb2.append(bArr.length);
        ee.c.e(str, "upgradeStep04", sb2.toString());
        if (bArr.length <= 0) {
            bVar.p("upgradeStep04", i0.c(16388, "offset = " + i3 + ", length = " + i10));
            return;
        }
        zd.d dVar = new zd.d(1);
        dVar.f20396f = bArr;
        xd.g gVar = (xd.g) this.f14377d;
        gVar.f19229f = dVar;
        gVar.e = 0;
        bVar.j(gVar);
        bVar.V();
    }

    public String toString() {
        switch (this.f14374a) {
            case 3:
                StringBuilder sb2 = new StringBuilder("ReconnectParam{originalAddress='");
                sb2.append((String) this.f14377d);
                sb2.append("', way=");
                sb2.append(this.f14375b);
                sb2.append(", reconnectAddress='");
                sb2.append((String) this.e);
                sb2.append("', flag=");
                return android.support.v4.media.session.e.m(sb2, this.f14376c, '}');
            default:
                return super.toString();
        }
    }

    public f(k6.b bVar, int i3, int i10, xd.g gVar) {
        this.f14374a = 2;
        this.e = bVar;
        this.f14375b = i3;
        this.f14376c = i10;
        this.f14377d = gVar;
    }

    public f() {
        this.f14374a = 0;
        this.f14377d = new long[10];
        this.e = new Object[10];
    }

    public f(td tdVar) {
        this.f14374a = 1;
        tdVar.getClass();
        throw null;
    }
}
