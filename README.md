# RWFit SR16 — Phase 3

Diagnostic Android app for physical SR16 hardware testing.

Phase 3 focus:
- SR16 BLE discovery
- GATT connection
- A00A/B002/B003 transport
- standard 180D/2A37 heart-rate notifications
- 0xAB packet decoding
- historical 16-byte and 8-byte test requests
- diagnostic status

## Build without Android Studio

GitHub Actions is configured in:
`.github/workflows/build-apk.yml`

It installs JDK 17, Gradle 8.13, Android SDK API 36/build-tools 36.0.0,
and creates:

`app/build/outputs/apk/debug/app-debug.apk`

See `PHASE3_CLOUD_BUILD.md` for phone-only instructions.

## Protocol safety

Do not add guessed BLE commands. Historical commands must be validated against
the physical ring before they are used for automatic synchronization.

## Current project checkpoint

Phase 1: complete
Phase 2: complete
Phase 3: in progress — hardware validation
