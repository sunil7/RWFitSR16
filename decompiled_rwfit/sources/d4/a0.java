package d4;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ui.R$string;
import g9.k0;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a0 implements r, k0 {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f12239a;

    public a0(Resources resources, int i3) {
        switch (i3) {
            case 1:
                resources.getClass();
                this.f12239a = resources;
                break;
            default:
                this.f12239a = resources;
                break;
        }
    }

    public String a(Format format) {
        String str;
        String str2 = format.language;
        if (TextUtils.isEmpty(str2) || "und".equals(str2)) {
            str = "";
        } else {
            str = (i9.g.f14378a >= 21 ? Locale.forLanguageTag(str2) : new Locale(str2)).getDisplayName();
        }
        int i3 = format.roleFlags & 2;
        Resources resources = this.f12239a;
        String string = i3 != 0 ? resources.getString(R$string.exo_track_role_alternate) : "";
        if ((format.roleFlags & 4) != 0) {
            string = b(string, resources.getString(R$string.exo_track_role_supplementary));
        }
        if ((format.roleFlags & 8) != 0) {
            string = b(string, resources.getString(R$string.exo_track_role_commentary));
        }
        if ((format.roleFlags & 1088) != 0) {
            string = b(string, resources.getString(R$string.exo_track_role_closed_captions));
        }
        String b3 = b(str, string);
        return TextUtils.isEmpty(b3) ? TextUtils.isEmpty(format.label) ? "" : format.label : b3;
    }

    public String b(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.f12239a.getString(R$string.exo_item_list, str, str2);
            }
        }
        return str;
    }

    @Override // d4.r
    public q c(x xVar) {
        return new b(this.f12239a, xVar.a(Uri.class, InputStream.class));
    }
}
