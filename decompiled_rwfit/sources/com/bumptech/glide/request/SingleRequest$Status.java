package com.bumptech.glide.request;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class SingleRequest$Status {
    public static final SingleRequest$Status CLEARED;
    public static final SingleRequest$Status COMPLETE;
    public static final SingleRequest$Status FAILED;
    public static final SingleRequest$Status PENDING;
    public static final SingleRequest$Status RUNNING;
    public static final SingleRequest$Status WAITING_FOR_SIZE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleRequest$Status[] f7032a;

    static {
        SingleRequest$Status singleRequest$Status = new SingleRequest$Status("PENDING", 0);
        PENDING = singleRequest$Status;
        SingleRequest$Status singleRequest$Status2 = new SingleRequest$Status("RUNNING", 1);
        RUNNING = singleRequest$Status2;
        SingleRequest$Status singleRequest$Status3 = new SingleRequest$Status("WAITING_FOR_SIZE", 2);
        WAITING_FOR_SIZE = singleRequest$Status3;
        SingleRequest$Status singleRequest$Status4 = new SingleRequest$Status("COMPLETE", 3);
        COMPLETE = singleRequest$Status4;
        SingleRequest$Status singleRequest$Status5 = new SingleRequest$Status("FAILED", 4);
        FAILED = singleRequest$Status5;
        SingleRequest$Status singleRequest$Status6 = new SingleRequest$Status("CLEARED", 5);
        CLEARED = singleRequest$Status6;
        f7032a = new SingleRequest$Status[]{singleRequest$Status, singleRequest$Status2, singleRequest$Status3, singleRequest$Status4, singleRequest$Status5, singleRequest$Status6};
    }

    public static SingleRequest$Status valueOf(String str) {
        return (SingleRequest$Status) Enum.valueOf(SingleRequest$Status.class, str);
    }

    public static SingleRequest$Status[] values() {
        return (SingleRequest$Status[]) f7032a.clone();
    }
}
