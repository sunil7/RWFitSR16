package okhttp3;

import com.google.android.gms.internal.mlkit_vision_common.f0;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.b;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import ph.a;

/* loaded from: classes2.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String line) {
            e.f(line, "line");
            int i3 = m.i(line, ':', 0, 6);
            if (i3 == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(line).toString());
            }
            String substring = line.substring(0, i3);
            e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String obj = m.B(substring).toString();
            String substring2 = line.substring(i3 + 1);
            e.e(substring2, "(this as java.lang.String).substring(startIndex)");
            add(obj, substring2);
            return this;
        }

        public final Builder addAll(Headers headers) {
            e.f(headers, "headers");
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                addLenient$okhttp(headers.name(i3), headers.value(i3));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String line) {
            e.f(line, "line");
            int i3 = m.i(line, ':', 1, 4);
            if (i3 != -1) {
                String substring = line.substring(0, i3);
                e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = line.substring(i3 + 1);
                e.e(substring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
                return this;
            }
            if (line.charAt(0) != ':') {
                addLenient$okhttp("", line);
                return this;
            }
            String substring3 = line.substring(1);
            e.e(substring3, "(this as java.lang.String).substring(startIndex)");
            addLenient$okhttp("", substring3);
            return this;
        }

        public final Builder addUnsafeNonAscii(String name, String value) {
            e.f(name, "name");
            e.f(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final String get(String name) {
            e.f(name, "name");
            th.a a3 = f0.a(new th.a(this.namesAndValues.size() - 2, 0, -1), 2);
            int i3 = a3.f18633a;
            int i10 = a3.f18634b;
            int i11 = a3.f18635c;
            if (i11 >= 0) {
                if (i3 > i10) {
                    return null;
                }
            } else if (i3 < i10) {
                return null;
            }
            while (!name.equalsIgnoreCase(this.namesAndValues.get(i3))) {
                if (i3 == i10) {
                    return null;
                }
                i3 += i11;
            }
            return this.namesAndValues.get(i3 + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String name) {
            e.f(name, "name");
            int i3 = 0;
            while (i3 < this.namesAndValues.size()) {
                if (name.equalsIgnoreCase(this.namesAndValues.get(i3))) {
                    this.namesAndValues.remove(i3);
                    this.namesAndValues.remove(i3);
                    i3 -= 2;
                }
                i3 += 2;
            }
            return this;
        }

        public final Builder set(String name, Date value) {
            e.f(name, "name");
            e.f(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String name, Instant value) {
            e.f(name, "name");
            e.f(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        public final Builder set(String name, String value) {
            e.f(name, "name");
            e.f(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder add(String name, String value) {
            e.f(name, "name");
            e.f(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder add(String name, Date value) {
            e.f(name, "name");
            e.f(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        public final Builder addLenient$okhttp(String name, String value) {
            e.f(name, "name");
            e.f(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(m.B(value).toString());
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String name, Instant value) {
            e.f(name, "name");
            e.f(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (!('!' <= charAt && '~' >= charAt)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i3), str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (!(charAt == '\t' || (' ' <= charAt && '~' >= charAt))) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i3), str2, str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            th.a a3 = f0.a(new th.a(strArr.length - 2, 0, -1), 2);
            int i3 = a3.f18633a;
            int i10 = a3.f18634b;
            int i11 = a3.f18635c;
            if (i11 >= 0) {
                if (i3 > i10) {
                    return null;
                }
            } else if (i3 < i10) {
                return null;
            }
            while (!m.f(str, strArr[i3])) {
                if (i3 == i10) {
                    return null;
                }
                i3 += i11;
            }
            return strArr[i3 + 1];
        }

        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m134deprecated_of(String... namesAndValues) {
            e.f(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        public final Headers of(String... namesAndValues) {
            e.f(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            Object clone = namesAndValues.clone();
            if (clone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr = (String[]) clone;
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str = strArr[i3];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr[i3] = m.B(str).toString();
            }
            th.a a3 = f0.a(f0.b(0, strArr.length), 2);
            int i10 = a3.f18633a;
            int i11 = a3.f18634b;
            int i12 = a3.f18635c;
            if (i12 < 0 ? i10 >= i11 : i10 <= i11) {
                while (true) {
                    String str2 = strArr[i10];
                    String str3 = strArr[i10 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i10 == i11) {
                        break;
                    }
                    i10 += i12;
                }
            }
            return new Headers(strArr, null);
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }

        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m133deprecated_of(Map<String, String> headers) {
            e.f(headers, "headers");
            return of(headers);
        }

        public final Headers of(Map<String, String> toHeaders) {
            e.f(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i3 = 0;
            for (Map.Entry<String, String> entry : toHeaders.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj = m.B(key).toString();
                if (value != null) {
                    String obj2 = m.B(value).toString();
                    checkName(obj);
                    checkValue(obj2, obj);
                    strArr[i3] = obj;
                    strArr[i3 + 1] = obj2;
                    i3 += 2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m132deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            length += this.namesAndValues[i3].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String name) {
        e.f(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    public final Date getDate(String name) {
        e.f(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String name) {
        e.f(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i3 = 0; i3 < size; i3++) {
            pairArr[i3] = new Pair(name(i3), value(i3));
        }
        return new b(pairArr);
    }

    public final String name(int i3) {
        return this.namesAndValues[i3 * 2];
    }

    public final Set<String> names() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        e.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeSet treeSet = new TreeSet(CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            treeSet.add(name(i3));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        e.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        List<String> namesAndValues$okhttp = builder.getNamesAndValues$okhttp();
        String[] elements = this.namesAndValues;
        e.f(namesAndValues$okhttp, "<this>");
        e.f(elements, "elements");
        List asList = Arrays.asList(elements);
        e.e(asList, "asList(this)");
        namesAndValues$okhttp.addAll(asList);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        e.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeMap treeMap = new TreeMap(CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            String name = name(i3);
            Locale locale = Locale.US;
            e.e(locale, "Locale.US");
            if (name == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = name.toLowerCase(locale);
            e.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i3));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            sb2.append(name(i3));
            sb2.append(": ");
            sb2.append(value(i3));
            sb2.append("\n");
        }
        String sb3 = sb2.toString();
        e.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String value(int i3) {
        return this.namesAndValues[(i3 * 2) + 1];
    }

    public final List<String> values(String name) {
        e.f(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            if (name.equalsIgnoreCase(name(i3))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i3));
            }
        }
        if (arrayList == null) {
            return EmptyList.INSTANCE;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        e.e(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, c cVar) {
        this(strArr);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }
}
