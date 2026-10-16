package kotlin.text;

import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import com.google.android.gms.internal.mlkit_vision_barcode.yd;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes2.dex */
public abstract class h extends yd {
    public static String b(final String str) {
        List list;
        kotlin.jvm.internal.e.f(str, "<this>");
        if (m.l("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        ef.i n4 = m.n(str, new String[]{"\r\n", "\n", "\r"});
        oh.l lVar = new oh.l() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final String invoke(th.c it) {
                kotlin.jvm.internal.e.f(it, "it");
                return m.y(str, it);
            }
        };
        b bVar = new b(n4);
        if (bVar.hasNext()) {
            Object invoke = lVar.invoke(bVar.next());
            if (bVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(invoke);
                while (bVar.hasNext()) {
                    arrayList.add(lVar.invoke(bVar.next()));
                }
                list = arrayList;
            } else {
                list = wd.a(invoke);
            }
        } else {
            list = EmptyList.INSTANCE;
        }
        int length = str.length();
        list.size();
        StringsKt__IndentKt$getIndentFunction$1 stringsKt__IndentKt$getIndentFunction$1 = new oh.l() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // oh.l
            public final String invoke(String line) {
                kotlin.jvm.internal.e.f(line, "line");
                return line;
            }
        };
        int c9 = kotlin.collections.i.c(list);
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (Object obj : list) {
            int i10 = i3 + 1;
            String str2 = null;
            if (i3 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            String str3 = (String) obj;
            if ((i3 != 0 && i3 != c9) || !m.l(str3)) {
                int length2 = str3.length();
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        i11 = -1;
                        break;
                    }
                    char charAt = str3.charAt(i11);
                    if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                        break;
                    }
                    i11++;
                }
                if (i11 != -1 && m.w(str3, "|", i11, false)) {
                    str2 = str3.substring(1 + i11);
                    kotlin.jvm.internal.e.e(str2, "this as java.lang.String).substring(startIndex)");
                }
                if (str2 == null || (str2 = (String) stringsKt__IndentKt$getIndentFunction$1.invoke((Object) str2)) == null) {
                    str2 = str3;
                }
            }
            if (str2 != null) {
                arrayList2.add(str2);
            }
            i3 = i10;
        }
        StringBuilder sb2 = new StringBuilder(length);
        kotlin.collections.h.o(arrayList2, sb2, "\n", "", "", "...", null);
        String sb3 = sb2.toString();
        kotlin.jvm.internal.e.e(sb3, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb3;
    }
}
