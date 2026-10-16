package ve;

import android.content.ContentValues;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Locale;
import ye.e;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f19231a;

    /* renamed from: b, reason: collision with root package name */
    public int f19232b;

    /* renamed from: c, reason: collision with root package name */
    public long f19233c;

    /* renamed from: d, reason: collision with root package name */
    public long f19234d;
    public long e;

    public final ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f19231a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f19232b));
        contentValues.put("startOffset", Long.valueOf(this.f19233c));
        contentValues.put("currentOffset", Long.valueOf(this.f19234d));
        contentValues.put("endOffset", Long.valueOf(this.e));
        return contentValues;
    }

    public final String toString() {
        int i3 = this.f19231a;
        int i10 = this.f19232b;
        long j4 = this.f19233c;
        long j10 = this.e;
        long j11 = this.f19234d;
        int i11 = e.f20123a;
        Locale locale = Locale.ENGLISH;
        StringBuilder s7 = l0.s(i3, "id[", i10, "] index[", "] range[");
        s7.append(j4);
        s7.append(", ");
        s7.append(j10);
        s7.append(") current offset(");
        return android.support.v4.media.session.e.n(s7, j11, ")");
    }
}
