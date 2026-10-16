package com.google.android.gms.common.api;

/* loaded from: classes.dex */
public class ApiException extends Exception {

    @Deprecated
    protected final Status mStatus;

    public ApiException(Status status) {
        super(status.i() + ": " + (status.j() != null ? status.j() : ""));
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.i();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.j();
    }
}
