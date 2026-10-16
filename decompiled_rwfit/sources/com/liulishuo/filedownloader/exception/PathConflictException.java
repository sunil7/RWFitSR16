package com.liulishuo.filedownloader.exception;

/* loaded from: classes2.dex */
public class PathConflictException extends IllegalAccessException {
    private final int mAnotherSamePathTaskId;
    private final String mDownloadingConflictPath;
    private final String mTargetFilePath;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PathConflictException(int r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            int r0 = ye.e.f20123a
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "There is an another running task("
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = ") with the same downloading path("
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = "), because of they are with the same target-file-path("
            r0.append(r1)
            java.lang.String r1 = "), so if the current task is started, the path of the file is sure to be written by multiple tasks, it is wrong, then you receive this exception to avoid such conflict."
            java.lang.String r0 = r5.a.f(r0, r5, r1)
            r2.<init>(r0)
            r2.mAnotherSamePathTaskId = r3
            r2.mDownloadingConflictPath = r4
            r2.mTargetFilePath = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.exception.PathConflictException.<init>(int, java.lang.String, java.lang.String):void");
    }

    public int getAnotherSamePathTaskId() {
        return this.mAnotherSamePathTaskId;
    }

    public String getDownloadingConflictPath() {
        return this.mDownloadingConflictPath;
    }

    public String getTargetFilePath() {
        return this.mTargetFilePath;
    }
}
