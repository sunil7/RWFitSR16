package okhttp3.internal.concurrent;

import oh.a;

/* loaded from: classes2.dex */
public final class TaskQueue$execute$1 extends Task {
    final /* synthetic */ a $block;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(a aVar, String str, boolean z5, String str2, boolean z6) {
        super(str2, z6);
        this.$block = aVar;
        this.$name = str;
        this.$cancelable = z5;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.$block.invoke();
        return -1L;
    }
}
