package kotlin.text;

import java.util.regex.Matcher;

/* loaded from: classes2.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f15663a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f15664b;

    public e(Matcher matcher, CharSequence charSequence) {
        this.f15663a = matcher;
        this.f15664b = charSequence;
    }

    public final e a() {
        Matcher matcher = this.f15663a;
        int end = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.f15664b;
        if (end > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        kotlin.jvm.internal.e.e(matcher2, "matcher.pattern().matcher(input)");
        if (matcher2.find(end)) {
            return new e(matcher2, charSequence);
        }
        return null;
    }
}
