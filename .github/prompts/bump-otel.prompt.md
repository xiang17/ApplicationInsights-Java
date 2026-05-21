---
description: "Bump OpenTelemetry dependency versions as a compatible ecosystem set"
name: "Bump OpenTelemetry Dependencies"
argument-hint: "Target OpenTelemetry Java Instrumentation, Java, or Contrib version, or latest compatible release set"
agent: "agent"
---

Bump OpenTelemetry dependencies in ApplicationInsights-Java.

Target: ${input:targetVersion:OpenTelemetry Java Instrumentation <version>, OpenTelemetry Java <version>, OpenTelemetry Java Contrib <version>, or latest compatible release set}

Follow the repository guidance in [.github/copilot-instructions.md](../copilot-instructions.md), especially the "Updating OpenTelemetry Dependencies" section.

Please:

1. Identify whether the target refers to OpenTelemetry Java Instrumentation, OpenTelemetry Java, OpenTelemetry Java Contrib, or the latest compatible ecosystem release set.
2. Determine compatible OpenTelemetry Java, Java Instrumentation, and Java Contrib versions from upstream release notes, BOMs, and published dependency metadata:
   - https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases
   - https://github.com/open-telemetry/opentelemetry-java/releases
   - https://github.com/open-telemetry/opentelemetry-java-contrib/releases
3. Update all local pinned OpenTelemetry versions together, including `otelSdkVersion`, `otelInstrumentationVersion`, `otelInstrumentationAlphaVersion`, `otelContribVersion`, and the OpenTelemetry Gradle plugins used by `buildSrc`.
4. Regenerate dependency locks and license metadata:
   ```bash
   ./gradlew resolveAndLockAll --write-locks
   ./gradlew generateLicenseReport
   ```
5. Verify the repository builds:
   ```bash
   ./gradlew assemble
   ```
6. Do not run the full smoke test matrix locally. Leave smoke tests and broader JDK/environment coverage to GitHub Actions unless a focused smoke test is explicitly requested.
7. Summarize the compatibility assumption, files changed, generated metadata updates, and verification results.
