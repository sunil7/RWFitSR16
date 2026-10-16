package kotlin.text;

import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import com.google.android.gms.internal.mlkit_vision_common.f0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Regex implements Serializable {
    public static final f Companion = new f();
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public static final class Serialized implements Serializable {
        public static final g Companion = new g();
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public Serialized(String pattern, int i3) {
            kotlin.jvm.internal.e.f(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i3;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.e.e(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    public Regex(Pattern nativePattern) {
        kotlin.jvm.internal.e.f(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ d find$default(Regex regex, CharSequence charSequence, int i3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        return regex.find(charSequence, i3);
    }

    public static /* synthetic */ vh.c findAll$default(Regex regex, CharSequence charSequence, int i3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        return regex.findAll(charSequence, i3);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        return regex.split(charSequence, i3);
    }

    public static /* synthetic */ vh.c splitToSequence$default(Regex regex, CharSequence charSequence, int i3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i3 = 0;
        }
        return regex.splitToSequence(charSequence, i3);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.e.e(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        kotlin.jvm.internal.e.f(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final d find(CharSequence input, int i3) {
        kotlin.jvm.internal.e.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.e.e(matcher, "nativePattern.matcher(input)");
        if (matcher.find(i3)) {
            return new e(matcher, input);
        }
        return null;
    }

    public final vh.c findAll(final CharSequence input, final int i3) {
        kotlin.jvm.internal.e.f(input, "input");
        if (i3 < 0 || i3 > input.length()) {
            StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Start index out of bounds: ", ", input length: ");
            q5.append(input.length());
            throw new IndexOutOfBoundsException(q5.toString());
        }
        oh.a aVar = new oh.a() { // from class: kotlin.text.Regex$findAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public final d invoke() {
                return Regex.this.find(input, i3);
            }
        };
        Regex$findAll$2 getNextValue = Regex$findAll$2.INSTANCE;
        kotlin.jvm.internal.e.f(getNextValue, "nextFunction");
        kotlin.jvm.internal.e.f(getNextValue, "getNextValue");
        o4.c cVar = new o4.c();
        cVar.f16732a = aVar;
        cVar.f16733b = getNextValue;
        return cVar;
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int flags = this.nativePattern.flags();
        EnumSet fromInt$lambda$1 = EnumSet.allOf(RegexOption.class);
        kotlin.jvm.internal.e.e(fromInt$lambda$1, "fromInt$lambda$1");
        oh.l lVar = new oh.l() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final Boolean invoke(RegexOption regexOption) {
                RegexOption regexOption2 = regexOption;
                return Boolean.valueOf((flags & regexOption2.getMask()) == regexOption2.getValue());
            }
        };
        Iterator it = fromInt$lambda$1.iterator();
        while (it.hasNext()) {
            if (!((Boolean) lVar.invoke(it.next())).booleanValue()) {
                it.remove();
            }
        }
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(fromInt$lambda$1);
        kotlin.jvm.internal.e.e(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.e.e(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final d matchAt(CharSequence input, int i3) {
        kotlin.jvm.internal.e.f(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i3, input.length());
        if (region.lookingAt()) {
            return new e(region, input);
        }
        return null;
    }

    public final d matchEntire(CharSequence input) {
        kotlin.jvm.internal.e.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.e.e(matcher, "nativePattern.matcher(input)");
        if (matcher.matches()) {
            return new e(matcher, input);
        }
        return null;
    }

    public final boolean matches(CharSequence input) {
        kotlin.jvm.internal.e.f(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean matchesAt(CharSequence input, int i3) {
        kotlin.jvm.internal.e.f(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i3, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        kotlin.jvm.internal.e.f(input, "input");
        kotlin.jvm.internal.e.f(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.e.e(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        kotlin.jvm.internal.e.f(input, "input");
        kotlin.jvm.internal.e.f(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.e.e(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence input, int i3) {
        kotlin.jvm.internal.e.f(input, "input");
        m.s(i3);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i3 == 1 || !matcher.find()) {
            return wd.a(input.toString());
        }
        int i10 = 10;
        if (i3 > 0 && i3 <= 10) {
            i10 = i3;
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = i3 - 1;
        int i12 = 0;
        do {
            arrayList.add(input.subSequence(i12, matcher.start()).toString());
            i12 = matcher.end();
            if (i11 >= 0 && arrayList.size() == i11) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(i12, input.length()).toString());
        return arrayList;
    }

    public final vh.c splitToSequence(CharSequence input, int i3) {
        kotlin.jvm.internal.e.f(input, "input");
        m.s(i3);
        return new n6.a(new Regex$splitToSequence$1(this, input, i3, null), 20);
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.e.e(pattern, "nativePattern.toString()");
        return pattern;
    }

    public final String replace(CharSequence input, oh.l transform) {
        kotlin.jvm.internal.e.f(input, "input");
        kotlin.jvm.internal.e.f(transform, "transform");
        int i3 = 0;
        Object find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            e eVar = (e) find$default;
            Matcher matcher = eVar.f15663a;
            sb2.append(input, i3, f0.b(matcher.start(), matcher.end()).f18633a);
            sb2.append((CharSequence) transform.invoke(find$default));
            i3 = f0.b(matcher.start(), matcher.end()).f18634b + 1;
            find$default = eVar.a();
            if (i3 >= length) {
                break;
            }
        } while (find$default != null);
        if (i3 < length) {
            sb2.append(input, i3, length);
        }
        String sb3 = sb2.toString();
        kotlin.jvm.internal.e.e(sb3, "sb.toString()");
        return sb3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.e.f(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.e.e(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2, kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.e.f(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.e.f(r3, r0)
            kotlin.text.f r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            r0.getClass()
            r0 = r3 & 2
            if (r0 == 0) goto L19
            r3 = r3 | 64
        L19:
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            kotlin.jvm.internal.e.e(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r4, java.util.Set<? extends kotlin.text.RegexOption> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.e.f(r4, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.e.f(r5, r0)
            kotlin.text.f r0 = kotlin.text.Regex.Companion
            java.util.Iterator r5 = r5.iterator()
            r1 = 0
        L11:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L23
            java.lang.Object r2 = r5.next()
            kotlin.text.c r2 = (kotlin.text.c) r2
            int r2 = r2.getValue()
            r1 = r1 | r2
            goto L11
        L23:
            r0.getClass()
            r5 = r1 & 2
            if (r5 == 0) goto L2c
            r1 = r1 | 64
        L2c:
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4, r1)
            java.lang.String r5 = "compile(pattern, ensureU…odeCase(options.toInt()))"
            kotlin.jvm.internal.e.e(r4, r5)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
