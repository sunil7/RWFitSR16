package com.bumptech.glide.request;

/* loaded from: classes.dex */
public enum RequestCoordinator$RequestState {
    RUNNING(false),
    PAUSED(false),
    CLEARED(false),
    SUCCESS(true),
    FAILED(true);

    private final boolean isComplete;

    RequestCoordinator$RequestState(boolean z5) {
        this.isComplete = z5;
    }

    public boolean isComplete() {
        return this.isComplete;
    }
}
