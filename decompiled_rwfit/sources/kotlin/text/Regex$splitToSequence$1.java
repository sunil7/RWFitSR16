package kotlin.text;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import oh.p;

@hh.c(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", l = {274, 282, 286}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements p {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Regex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i3, gh.a<? super Regex$splitToSequence$1> aVar) {
        super(2, aVar);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final gh.a<eh.g> create(Object obj, gh.a<?> aVar) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, aVar);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        if (kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED != r0) goto L23;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0073 -> B:12:0x0076). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            eh.g r2 = eh.g.f12633a
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L30
            if (r1 == r5) goto L2c
            if (r1 == r4) goto L1d
            if (r1 != r3) goto L15
            com.google.android.gms.internal.mlkit_vision_barcode.wb.a(r11)
            return r2
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1d:
            int r1 = r10.I$0
            java.lang.Object r6 = r10.L$1
            java.util.regex.Matcher r6 = (java.util.regex.Matcher) r6
            java.lang.Object r7 = r10.L$0
            vh.e r7 = (vh.e) r7
            com.google.android.gms.internal.mlkit_vision_barcode.wb.a(r11)
            r11 = r6
            goto L76
        L2c:
            com.google.android.gms.internal.mlkit_vision_barcode.wb.a(r11)
            return r2
        L30:
            com.google.android.gms.internal.mlkit_vision_barcode.wb.a(r11)
            java.lang.Object r11 = r10.L$0
            vh.e r11 = (vh.e) r11
            kotlin.text.Regex r1 = r10.this$0
            java.util.regex.Pattern r1 = kotlin.text.Regex.access$getNativePattern$p(r1)
            java.lang.CharSequence r6 = r10.$input
            java.util.regex.Matcher r1 = r1.matcher(r6)
            int r6 = r10.$limit
            if (r6 == r5) goto La9
            boolean r6 = r1.find()
            if (r6 != 0) goto L4e
            goto La9
        L4e:
            r6 = 0
            r7 = r11
            r11 = r1
            r1 = r6
        L52:
            java.lang.CharSequence r8 = r10.$input
            int r9 = r11.start()
            java.lang.CharSequence r6 = r8.subSequence(r6, r9)
            java.lang.String r6 = r6.toString()
            r10.L$0 = r7
            r10.L$1 = r11
            r10.I$0 = r1
            r10.label = r4
            r8 = r7
            vh.d r8 = (vh.d) r8
            r8.f19267b = r6
            r8.f19266a = r3
            r8.f19268c = r10
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r6 != r0) goto L76
            goto Lb9
        L76:
            int r6 = r11.end()
            int r1 = r1 + r5
            int r8 = r10.$limit
            int r8 = r8 - r5
            if (r1 == r8) goto L86
            boolean r8 = r11.find()
            if (r8 != 0) goto L52
        L86:
            java.lang.CharSequence r11 = r10.$input
            int r1 = r11.length()
            java.lang.CharSequence r11 = r11.subSequence(r6, r1)
            java.lang.String r11 = r11.toString()
            r1 = 0
            r10.L$0 = r1
            r10.L$1 = r1
            r10.label = r3
            vh.d r7 = (vh.d) r7
            r7.f19267b = r11
            r7.f19266a = r3
            r7.f19268c = r10
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r11 != r0) goto La8
            goto Lb9
        La8:
            return r2
        La9:
            java.lang.CharSequence r1 = r10.$input
            java.lang.String r1 = r1.toString()
            r10.label = r5
            vh.d r11 = (vh.d) r11
            r11.f19267b = r1
            r11.f19266a = r3
            r11.f19268c = r10
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex$splitToSequence$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // oh.p
    public final Object invoke(vh.e eVar, gh.a<? super eh.g> aVar) {
        return ((Regex$splitToSequence$1) create(eVar, aVar)).invokeSuspend(eh.g.f12633a);
    }
}
