package g9;

import android.text.Html;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f13983a = Pattern.compile("(&#13;)?&#10;");

    public static String a(CharSequence charSequence) {
        return f13983a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
