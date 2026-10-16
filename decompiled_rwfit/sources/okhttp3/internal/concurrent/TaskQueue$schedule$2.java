package okhttp3.internal.concurrent;

import oh.a;

/* loaded from: classes2.dex */
public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ a $block;
    final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(a aVar, String str, String str2) {
        super(str2, false, 2, null);
        this.$block = aVar;
        this.$name = str;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        return ((Number) this.$block.invoke()).longValue();
    }
}
