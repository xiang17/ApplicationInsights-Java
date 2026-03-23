// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.opentelemetry.javaagent.instrumentation.micrometer.ai;

import io.micrometer.core.instrument.step.StepRegistryConfig;
import io.opentelemetry.instrumentation.api.internal.ConfigPropertiesUtil;
import java.time.Duration;
import javax.annotation.Nullable;

public class AzureMonitorRegistryConfig implements StepRegistryConfig {

  private final Duration step;
  @Nullable private final String namespace;

  public static final AzureMonitorRegistryConfig INSTANCE = new AzureMonitorRegistryConfig();

  private AzureMonitorRegistryConfig() {
    String stepMillisStr = getFromAiBootstrapConfig("getMicrometerStepMillis");
    if (stepMillisStr == null) {
      stepMillisStr =
          ConfigPropertiesUtil.getString("applicationinsights.internal.micrometer.step.millis");
    }
    Duration parsedStep = null;
    if (stepMillisStr != null) {
      try {
        parsedStep = Duration.ofMillis(Long.parseLong(stepMillisStr));
      } catch (NumberFormatException ignored) {
        // fall through to default
      }
    }
    step = parsedStep != null ? parsedStep : Duration.ofSeconds(60);
    String configuredNamespace = getFromAiBootstrapConfig("getMicrometerNamespace");
    namespace =
        configuredNamespace != null
            ? configuredNamespace
            : ConfigPropertiesUtil.getString("applicationinsights.internal.micrometer.namespace");
  }

  @Override
  public String prefix() {
    return "";
  }

  @Override
  public String get(String key) {
    return null;
  }

  @Override
  public Duration step() {
    return step;
  }

  @Nullable
  public String namespace() {
    return namespace;
  }

  @Nullable
  private static String getFromAiBootstrapConfig(String methodName) {
    try {
      Class<?> clazz =
          Class.forName("com.microsoft.applicationinsights.agent.bootstrap.AiInternalInstrumentationConfig");
      return (String) clazz.getMethod(methodName).invoke(null);
    } catch (Exception e) {
      return null;
    }
  }
}
