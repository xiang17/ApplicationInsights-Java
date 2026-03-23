// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.applicationinsights.agent.bootstrap;

import javax.annotation.Nullable;

public final class AiInternalInstrumentationConfig {

  @Nullable private static volatile String methodsInclude;
  @Nullable private static volatile String micrometerStepMillis;
  @Nullable private static volatile String micrometerNamespace;

  public static void setMethodsInclude(@Nullable String value) {
    methodsInclude = value;
  }

  public static void setMicrometerStepMillis(@Nullable String value) {
    micrometerStepMillis = value;
  }

  public static void setMicrometerNamespace(@Nullable String value) {
    micrometerNamespace = value;
  }

  @Nullable
  public static String getMethodsInclude() {
    return methodsInclude;
  }

  @Nullable
  public static String getMicrometerStepMillis() {
    return micrometerStepMillis;
  }

  @Nullable
  public static String getMicrometerNamespace() {
    return micrometerNamespace;
  }

  private AiInternalInstrumentationConfig() {}
}
