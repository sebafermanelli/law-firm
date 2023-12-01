package com.solvd.interfaces.functional;

@FunctionalInterface
public interface StatusUpdaterFunction<T> {
  void changeStatus(T object);
}
