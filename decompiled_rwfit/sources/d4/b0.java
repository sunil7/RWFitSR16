package d4;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* loaded from: classes.dex */
public final class b0 implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12243a;

    /* renamed from: b, reason: collision with root package name */
    public final q f12244b;

    public /* synthetic */ b0(q qVar, int i3) {
        this.f12243a = i3;
        this.f12244b = qVar;
    }

    @Override // d4.q
    public final p a(Object obj, int i3, int i10, x3.f fVar) {
        Uri fromFile;
        switch (this.f12243a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    fromFile = null;
                } else if (str.charAt(0) == '/') {
                    fromFile = Uri.fromFile(new File(str));
                } else {
                    Uri parse = Uri.parse(str);
                    fromFile = parse.getScheme() == null ? Uri.fromFile(new File(str)) : parse;
                }
                if (fromFile == null) {
                    return null;
                }
                q qVar = this.f12244b;
                if (qVar.b(fromFile)) {
                    return qVar.a(fromFile, i3, i10, fVar);
                }
                return null;
            default:
                return this.f12244b.a(new g((URL) obj), i3, i10, fVar);
        }
    }

    @Override // d4.q
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f12243a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
