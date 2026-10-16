package a8;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import de.o;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f120a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f121b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f122c;

    public b(String str, byte[] bArr, Priority priority) {
        this.f120a = str;
        this.f121b = bArr;
        this.f122c = priority;
    }

    public static o a() {
        o oVar = new o(2, false);
        Priority priority = Priority.DEFAULT;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        oVar.f12378c = priority;
        return oVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f120a.equals(bVar.f120a) && Arrays.equals(this.f121b, bVar.f121b) && this.f122c.equals(bVar.f122c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f120a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f121b)) * 1000003) ^ this.f122c.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.f121b;
        return "TransportContext(" + this.f120a + ", " + this.f122c + ", " + (bArr == null ? "" : Base64.encodeToString(bArr, 2)) + ")";
    }
}
