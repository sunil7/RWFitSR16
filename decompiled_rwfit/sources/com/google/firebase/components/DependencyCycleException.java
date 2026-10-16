package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;
import pb.a;

/* loaded from: classes.dex */
public class DependencyCycleException extends DependencyException {
    private final List<a> componentsInCycle;

    public DependencyCycleException(List<a> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<a> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
