---
description: "Bump OpenTelemetry dependency versions as a compatible ecosystem set"
name: "Bump OpenTelemetry Dependencies"
argument-hint: "e.g. OpenTelemetry Java Instrumentation 2.x, OpenTelemetry Java 1.x, or latest compatible set"
agent: "agent"
---

Bump OpenTelemetry dependencies in ApplicationInsights-Java.

Target: ${input:targetVersion:OpenTelemetry Java Instrumentation <version>, OpenTelemetry Java <version>, OpenTelemetry Java Contrib <version>, or latest compatible release set}

Use this as a short task request when assigning the work to a coding agent,
Copilot CLI, or another AI agent. Replace `<version>` with the target release:

```text
Use OpenTelemetry Java Instrumentation <version> as the anchor and infer compatible OpenTelemetry Java and OpenTelemetry Java Contrib versions. Follow the ApplicationInsights-Java OpenTelemetry dependency update instructions, regenerate required lock/license metadata, verify the repository builds, and leave the full smoke test matrix to CI.
```

Use [Updating OpenTelemetry Dependencies](../copilot-instructions.md#updating-opentelemetry-dependencies) as the source of truth for compatibility lookup, version updates, generated metadata, build verification, and deferred test coverage.

Treat the target as the anchor version unless it asks for the latest compatible release set. At completion, summarize the compatible versions chosen, files changed, generated metadata updates, build verification, and any coverage deferred to CI.
