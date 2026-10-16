package dd;

import androidx.fragment.app.s0;
import com.google.zxing.FormatException;

/* loaded from: classes.dex */
public final class i extends s0 {

    /* renamed from: b, reason: collision with root package name */
    public final int f12334b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12335c;

    public i(int i3, int i10, int i11) {
        super(i3);
        if (i10 < 0 || i10 > 10 || i11 < 0 || i11 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f12334b = i10;
        this.f12335c = i11;
    }
}
