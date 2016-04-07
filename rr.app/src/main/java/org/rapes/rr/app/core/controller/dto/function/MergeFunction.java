package org.rapes.rr.app.core.controller.dto.function;

public interface MergeFunction<T,U> {

	public T merge(T oldData,U delta);
}
