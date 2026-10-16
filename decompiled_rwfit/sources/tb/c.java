package tb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import rb.f;

/* loaded from: classes.dex */
public final class c implements rb.e {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f18599a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        f18599a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        ((f) obj2).b(f18599a.format((Date) obj));
    }
}
