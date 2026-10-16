package kotlin.text;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import com.google.android.gms.internal.mlkit_vision_barcode.xd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import oh.p;

/* loaded from: classes2.dex */
public abstract class m extends l {
    public static Integer A(String str) {
        boolean z5;
        int i3;
        int i10;
        xd.a(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char charAt = str.charAt(0);
        int i12 = -2147483647;
        if (kotlin.jvm.internal.e.h(charAt, 48) < 0) {
            i3 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i12 = Integer.MIN_VALUE;
                z5 = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z5 = false;
            }
        } else {
            z5 = false;
            i3 = 0;
        }
        int i13 = -59652323;
        while (i3 < length) {
            int digit = Character.digit((int) str.charAt(i3), 10);
            if (digit < 0) {
                return null;
            }
            if ((i11 < i13 && (i13 != -59652323 || i11 < (i13 = i12 / 10))) || (i10 = i11 * 10) < i12 + digit) {
                return null;
            }
            i11 = i10 - digit;
            i3++;
        }
        return z5 ? Integer.valueOf(i11) : Integer.valueOf(-i11);
    }

    public static CharSequence B(String str) {
        kotlin.jvm.internal.e.f(str, "<this>");
        int length = str.length() - 1;
        int i3 = 0;
        boolean z5 = false;
        while (i3 <= length) {
            char charAt = str.charAt(!z5 ? i3 : length);
            boolean z6 = Character.isWhitespace(charAt) || Character.isSpaceChar(charAt);
            if (z5) {
                if (!z6) {
                    break;
                }
                length--;
            } else if (z6) {
                i3++;
            } else {
                z5 = true;
            }
        }
        return str.subSequence(i3, length + 1);
    }

    public static boolean c(String str, String other, boolean z5) {
        kotlin.jvm.internal.e.f(str, "<this>");
        kotlin.jvm.internal.e.f(other, "other");
        return j(str, other, 0, z5, 2) >= 0;
    }

    public static boolean d(CharSequence charSequence, char c9) {
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        return i(charSequence, c9, 0, 2) >= 0;
    }

    public static boolean e(String str, String suffix) {
        kotlin.jvm.internal.e.f(str, "<this>");
        kotlin.jvm.internal.e.f(suffix, "suffix");
        return str.endsWith(suffix);
    }

    public static boolean f(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final int g(CharSequence charSequence) {
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int h(CharSequence charSequence, String string, int i3, boolean z5) {
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        kotlin.jvm.internal.e.f(string, "string");
        if (!z5 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i3);
        }
        int length = charSequence.length();
        if (i3 < 0) {
            i3 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        th.c cVar = new th.c(i3, length, 1);
        boolean z6 = charSequence instanceof String;
        int i10 = cVar.f18635c;
        int i11 = cVar.f18634b;
        if (!z6) {
            boolean z8 = z5;
            if ((i10 <= 0 || i3 > i11) && (i10 >= 0 || i11 > i3)) {
                return -1;
            }
            while (true) {
                CharSequence charSequence2 = charSequence;
                boolean z10 = z8;
                z8 = z10;
                if (p(string, 0, charSequence2, i3, string.length(), z10)) {
                    return i3;
                }
                if (i3 == i11) {
                    return -1;
                }
                i3 += i10;
                charSequence = charSequence2;
            }
        } else {
            if ((i10 <= 0 || i3 > i11) && (i10 >= 0 || i11 > i3)) {
                return -1;
            }
            int i12 = i3;
            while (true) {
                String str = string;
                boolean z11 = z5;
                if (o(0, i12, string.length(), str, (String) charSequence, z11)) {
                    return i12;
                }
                if (i12 == i11) {
                    return -1;
                }
                i12 += i10;
                string = str;
                z5 = z11;
            }
        }
    }

    public static int i(CharSequence charSequence, char c9, int i3, int i10) {
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        return !(charSequence instanceof String) ? k(charSequence, new char[]{c9}, i3, false) : ((String) charSequence).indexOf(c9, i3);
    }

    public static /* synthetic */ int j(CharSequence charSequence, String str, int i3, boolean z5, int i10) {
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        if ((i10 & 4) != 0) {
            z5 = false;
        }
        return h(charSequence, str, i3, z5);
    }

    public static final int k(CharSequence charSequence, char[] chars, int i3, boolean z5) {
        int i10;
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        kotlin.jvm.internal.e.f(chars, "chars");
        boolean z6 = true;
        if (!z5 && chars.length == 1 && (charSequence instanceof String)) {
            kotlin.jvm.internal.e.f(chars, "<this>");
            int length = chars.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(chars[0], i3);
        }
        if (i3 < 0) {
            i3 = 0;
        }
        th.c cVar = new th.c(i3, g(charSequence), 1);
        int i11 = cVar.f18635c;
        int i12 = cVar.f18634b;
        if (i11 <= 0 ? i3 < i12 : i3 > i12) {
            z6 = false;
        }
        if (!z6) {
            i3 = i12;
        }
        while (z6) {
            if (i3 != i12) {
                i10 = i3 + i11;
            } else {
                if (!z6) {
                    throw new NoSuchElementException();
                }
                i10 = i3;
                z6 = false;
            }
            char charAt = charSequence.charAt(i3);
            for (char c9 : chars) {
                if (xd.b(c9, charAt, z5)) {
                    return i3;
                }
            }
            i3 = i10;
        }
        return -1;
    }

    public static boolean l(CharSequence charSequence) {
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable cVar = new th.c(0, charSequence.length() - 1, 1);
            if (!(cVar instanceof Collection) || !((Collection) cVar).isEmpty()) {
                Iterator it = cVar.iterator();
                while (((th.b) it).f18638c) {
                    char charAt = charSequence.charAt(((th.b) it).a());
                    if (!Character.isWhitespace(charAt) && !Character.isSpaceChar(charAt)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int m(String str, char c9, int i3, int i10) {
        if ((i10 & 2) != 0) {
            i3 = g(str);
        }
        kotlin.jvm.internal.e.f(str, "<this>");
        return str.lastIndexOf(c9, i3);
    }

    public static ef.i n(CharSequence charSequence, String[] strArr) {
        final boolean z5 = false;
        s(0);
        final List asList = Arrays.asList(strArr);
        kotlin.jvm.internal.e.e(asList, "asList(this)");
        return new ef.i(charSequence, new p() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // oh.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((CharSequence) obj, ((Number) obj2).intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i3) {
                CharSequence charSequence2;
                Object obj;
                Pair pair;
                Object obj2;
                Object obj3;
                kotlin.jvm.internal.e.f($receiver, "$this$$receiver");
                List<String> list = asList;
                boolean z6 = z5;
                if (z6 || list.size() != 1) {
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    th.c cVar = new th.c(i3, $receiver.length(), 1);
                    boolean z8 = $receiver instanceof String;
                    int i10 = cVar.f18635c;
                    int i11 = cVar.f18634b;
                    if (z8) {
                        if ((i10 > 0 && i3 <= i11) || (i10 < 0 && i11 <= i3)) {
                            int i12 = i3;
                            while (true) {
                                Iterator<T> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        obj2 = null;
                                        break;
                                    }
                                    obj2 = it.next();
                                    String str = (String) obj2;
                                    if (m.o(0, i12, str.length(), str, (String) $receiver, z6)) {
                                        break;
                                    }
                                }
                                String str2 = (String) obj2;
                                if (str2 == null) {
                                    if (i12 == i11) {
                                        break;
                                    }
                                    i12 += i10;
                                } else {
                                    pair = new Pair(Integer.valueOf(i12), str2);
                                    break;
                                }
                            }
                        }
                        pair = null;
                    } else {
                        if ((i10 > 0 && i3 <= i11) || (i10 < 0 && i11 <= i3)) {
                            int i13 = i3;
                            while (true) {
                                Iterator<T> it2 = list.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        charSequence2 = $receiver;
                                        obj = null;
                                        break;
                                    }
                                    obj = it2.next();
                                    String str3 = (String) obj;
                                    charSequence2 = $receiver;
                                    if (m.p(str3, 0, charSequence2, i13, str3.length(), z6)) {
                                        break;
                                    }
                                    $receiver = charSequence2;
                                }
                                String str4 = (String) obj;
                                if (str4 == null) {
                                    if (i13 == i11) {
                                        break;
                                    }
                                    i13 += i10;
                                    $receiver = charSequence2;
                                } else {
                                    pair = new Pair(Integer.valueOf(i13), str4);
                                    break;
                                }
                            }
                        }
                        pair = null;
                    }
                } else {
                    List<String> list2 = list;
                    if (list2 instanceof List) {
                        List<String> list3 = list2;
                        int size = list3.size();
                        if (size == 0) {
                            throw new NoSuchElementException("List is empty.");
                        }
                        if (size != 1) {
                            throw new IllegalArgumentException("List has more than one element.");
                        }
                        obj3 = list3.get(0);
                    } else {
                        Iterator<T> it3 = list2.iterator();
                        if (!it3.hasNext()) {
                            throw new NoSuchElementException("Collection is empty.");
                        }
                        Object next = it3.next();
                        if (it3.hasNext()) {
                            throw new IllegalArgumentException("Collection has more than one element.");
                        }
                        obj3 = next;
                    }
                    String str5 = (String) obj3;
                    int j4 = m.j($receiver, str5, i3, false, 4);
                    if (j4 >= 0) {
                        pair = new Pair(Integer.valueOf(j4), str5);
                    }
                    pair = null;
                }
                if (pair != null) {
                    return new Pair<>(pair.getFirst(), Integer.valueOf(((String) pair.getSecond()).length()));
                }
                return null;
            }
        });
    }

    public static final boolean o(int i3, int i10, int i11, String str, String other, boolean z5) {
        kotlin.jvm.internal.e.f(str, "<this>");
        kotlin.jvm.internal.e.f(other, "other");
        return !z5 ? str.regionMatches(i3, other, i10, i11) : str.regionMatches(z5, i3, other, i10, i11);
    }

    public static final boolean p(String str, int i3, CharSequence other, int i10, int i11, boolean z5) {
        kotlin.jvm.internal.e.f(str, "<this>");
        kotlin.jvm.internal.e.f(other, "other");
        if (i10 >= 0 && i3 >= 0 && i3 <= str.length() - i11 && i10 <= other.length() - i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                if (xd.b(str.charAt(i3 + i12), other.charAt(i10 + i12), z5)) {
                }
            }
            return true;
        }
        return false;
    }

    public static String q(String str, String str2) {
        if (!x(str, str2, false)) {
            return str;
        }
        String substring = str.substring(str2.length());
        kotlin.jvm.internal.e.e(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String r(String str, String str2, String newValue) {
        kotlin.jvm.internal.e.f(str, "<this>");
        kotlin.jvm.internal.e.f(newValue, "newValue");
        int h4 = h(str, str2, 0, false);
        if (h4 < 0) {
            return str;
        }
        int length = str2.length();
        int i3 = length >= 1 ? length : 1;
        int length2 = newValue.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        int i10 = 0;
        do {
            sb2.append((CharSequence) str, i10, h4);
            sb2.append(newValue);
            i10 = h4 + length;
            if (h4 >= str.length()) {
                break;
            }
            h4 = h(str, str2, h4 + i3, false);
        } while (h4 > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String sb3 = sb2.toString();
        kotlin.jvm.internal.e.e(sb3, "stringBuilder.append(this, i, length).toString()");
        return sb3;
    }

    public static final void s(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException(l0.j(i3, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List t(CharSequence charSequence, String str) {
        s(0);
        int h4 = h(charSequence, str, 0, false);
        if (h4 == -1) {
            return wd.a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int i3 = 0;
        do {
            arrayList.add(charSequence.subSequence(i3, h4).toString());
            i3 = str.length() + h4;
            h4 = h(charSequence, str, i3, false);
        } while (h4 != -1);
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        return arrayList;
    }

    public static List u(CharSequence charSequence, String[] strArr) {
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return t(charSequence, str);
            }
        }
        vh.f fVar = new vh.f(n(charSequence, strArr));
        ArrayList arrayList = new ArrayList(kotlin.collections.j.g(fVar));
        Iterator it = fVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            arrayList.add(y(charSequence, (th.c) bVar.next()));
        }
    }

    public static List v(String str, final char[] cArr) {
        kotlin.jvm.internal.e.f(str, "<this>");
        final boolean z5 = false;
        if (cArr.length == 1) {
            return t(str, String.valueOf(cArr[0]));
        }
        s(0);
        vh.f fVar = new vh.f(new ef.i(str, new p() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // oh.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((CharSequence) obj, ((Number) obj2).intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence $receiver, int i3) {
                kotlin.jvm.internal.e.f($receiver, "$this$$receiver");
                int k10 = m.k($receiver, cArr, i3, z5);
                if (k10 < 0) {
                    return null;
                }
                return new Pair<>(Integer.valueOf(k10), 1);
            }
        }));
        ArrayList arrayList = new ArrayList(kotlin.collections.j.g(fVar));
        Iterator it = fVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            arrayList.add(y(str, (th.c) bVar.next()));
        }
    }

    public static boolean w(String str, String str2, int i3, boolean z5) {
        kotlin.jvm.internal.e.f(str, "<this>");
        return !z5 ? str.startsWith(str2, i3) : o(i3, 0, str2.length(), str, str2, z5);
    }

    public static boolean x(String str, String prefix, boolean z5) {
        kotlin.jvm.internal.e.f(str, "<this>");
        kotlin.jvm.internal.e.f(prefix, "prefix");
        return !z5 ? str.startsWith(prefix) : o(0, 0, prefix.length(), str, prefix, z5);
    }

    public static final String y(CharSequence charSequence, th.c range) {
        kotlin.jvm.internal.e.f(charSequence, "<this>");
        kotlin.jvm.internal.e.f(range, "range");
        return charSequence.subSequence(range.f18633a, range.f18634b + 1).toString();
    }

    public static String z(String missingDelimiterValue) {
        kotlin.jvm.internal.e.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.e.f(missingDelimiterValue, "missingDelimiterValue");
        int m10 = m(missingDelimiterValue, '.', 0, 6);
        if (m10 == -1) {
            return missingDelimiterValue;
        }
        String substring = missingDelimiterValue.substring(m10 + 1, missingDelimiterValue.length());
        kotlin.jvm.internal.e.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
