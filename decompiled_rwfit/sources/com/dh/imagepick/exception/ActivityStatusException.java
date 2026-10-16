package com.dh.imagepick.exception;

/* loaded from: classes.dex */
public final class ActivityStatusException extends BaseException {
    public ActivityStatusException() {
        super("activity is destroyed or in a error status check your current activity status before use imagePick");
    }
}
