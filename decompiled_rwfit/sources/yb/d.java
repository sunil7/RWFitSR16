package yb;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d extends com.google.gson.k {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20048c = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20049a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f20050b;

    public d() {
        ArrayList arrayList = new ArrayList();
        this.f20050b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.d.f11179a >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        switch (this.f20049a) {
            case 0:
                if (aVar.b0() == JsonToken.NULL) {
                    aVar.X();
                    return null;
                }
                String Z = aVar.Z();
                synchronized (this) {
                    ArrayList arrayList = (ArrayList) this.f20050b;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        try {
                            return ((DateFormat) obj).parse(Z);
                        } catch (ParseException unused) {
                        }
                    }
                    try {
                        return zb.a.b(Z, new ParsePosition(0));
                    } catch (ParseException e) {
                        throw new JsonSyntaxException(Z, e);
                    }
                }
            default:
                Date date = (Date) ((com.google.gson.k) this.f20050b).a(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
        }
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        switch (this.f20049a) {
            case 0:
                Date date = (Date) obj;
                synchronized (this) {
                    if (date == null) {
                        bVar.k();
                    } else {
                        bVar.I(((DateFormat) ((ArrayList) this.f20050b).get(0)).format(date));
                    }
                }
                return;
            default:
                ((com.google.gson.k) this.f20050b).b(bVar, (Timestamp) obj);
                return;
        }
    }

    public d(com.google.gson.k kVar) {
        this.f20050b = kVar;
    }
}
