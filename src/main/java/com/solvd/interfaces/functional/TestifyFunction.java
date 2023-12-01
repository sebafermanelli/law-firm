package com.solvd.interfaces.functional;

@FunctionalInterface
public interface TestifyFunction<T, U> {
  void testify(T witness, U legalCase);
}
