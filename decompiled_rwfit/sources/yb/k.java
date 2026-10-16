package yb;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class k extends com.google.gson.k {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20072c = new a(3);

    /* renamed from: d, reason: collision with root package name */
    public static final a f20073d = new a(4);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20074a;

    /* renamed from: b, reason: collision with root package name */
    public final SimpleDateFormat f20075b;

    public k(int i3) {
        this.f20074a = i3;
        switch (i3) {
            case 1:
                this.f20075b = new SimpleDateFormat("hh:mm:ss a");
                break;
            default:
                this.f20075b = new SimpleDateFormat("MMM d, yyyy");
                break;
        }
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        switch (this.f20074a) {
            case 0:
                synchronized (this) {
                    if (aVar.b0() == JsonToken.NULL) {
                        aVar.X();
                        return null;
                    }
                    try {
                        return new Date(this.f20075b.parse(aVar.Z()).getTime());
                    } catch (ParseException e) {
                        throw new JsonSyntaxException(e);
                    }
                }
            default:
                synchronized (this) {
                    if (aVar.b0() == JsonToken.NULL) {
                        aVar.X();
                        return null;
                    }
                    try {
                        return new Time(this.f20075b.parse(aVar.Z()).getTime());
                    } catch (ParseException e10) {
                        throw new JsonSyntaxException(e10);
                    }
                }
        }
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        switch (this.f20074a) {
            case 0:
                Date date = (Date) obj;
                synchronized (this) {
                    bVar.I(date == null ? null : this.f20075b.format((java.util.Date) date));
                }
                return;
            default:
                Time time = (Time) obj;
                synchronized (this) {
                    bVar.I(time == null ? null : this.f20075b.format((java.util.Date) time));
                }
                return;
        }
    }
}
