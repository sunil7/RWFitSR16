# Terminal Commands and Results for RWFit SR16 Knowledge Sharing

## Project intent

The repository is a clean-room interoperability project for the SR16 Smart Ring, with a diagnostic Android app goal for physical hardware testing.

The tracked project documentation states:

- Phase 3 is focused on SR16 BLE discovery, GATT connection, A00A/B002/B003 transport, heart-rate notifications, 0xAB packet decoding, and diagnostic status.
- Health Connect export must remain disabled or clearly separated until hardware decoding is validated.
- The repository is intended to support a test APK build for a real SR16 device, not a guessed BLE command implementation.

## Commands executed and results

### 1) Repository and workspace inspection

```bash
pwd && git status --short --branch && echo '---' && ls -la && echo '---ROOT FILES---' && find . -maxdepth 2 -type f | sed 's#^./##' | sort | head -200
```

Observed result:

- Current directory: `/workspaces/RWFitSR16`
- Git branch: `main`
- Repo had tracked files removed from the working tree and a new `.gitignore` file in place.
- Visible artifacts included:
  - `RWfit.apk`
  - `jadx-headless-mcp-0.7.1-all.jar`
  - `app/`
  - `decompiled_rwfit/`

### 2) Repository inventory from Git HEAD

```bash
git ls-tree -r --name-only HEAD | head -200
```

Observed result:

- The tracked repository still contains the expected project files:
  - `AGENTS.md`
  - `PHASE3_CLOUD_BUILD.md`
  - `README.md`
  - `app/src/main/AndroidManifest.xml`
  - `build.gradle.kts`
  - `gradle.properties`
  - `settings.gradle.kts`

### 3) Read the tracked project documentation

```bash
git --no-pager show HEAD:README.md
```

Key findings from the project README:

- Project name: `RWFit SR16 — Phase 3`
- Goal: diagnostic Android app for physical SR16 hardware testing
- Build path: GitHub Actions workflow in `.github/workflows/build-apk.yml`
- Artifact output: `app/build/outputs/apk/debug/app-debug.apk`
- Safety rule: do not add guessed BLE commands; historical commands must be validated only against physical hardware

```bash
git --no-pager show HEAD:PHASE3_CLOUD_BUILD.md
```

Key findings from the build guide:

- GitHub Actions can build the APK without local Android Studio.
- Workflow instructions are provided for repository upload, workflow execution, artifact download, and install-on-phone steps.
- Hardware validation includes scan/connect flow, nearby-device permissions, and recording connection status/errors.

```bash
git --no-pager show HEAD:AGENTS.md
```

Key rules captured from the project policy:

- Clean-room development only
- No proprietary code copied from RWFit
- No guessed BLE bytes
- Preserve the Phase 3 diagnostic testing objective
- Health Connect export must stay disabled until decoding is validated

### 4) Current repository and protocol-dump check (2026-10-15)

```bash
pwd && printf '\n--- git status ---\n' && git status --short --branch && printf '\n--- indexed files ---\n' && git ls-files && printf '\n--- HEAD files ---\n' && git ls-tree -r --name-only HEAD | head -20 && printf '\n--- protocol dump ---\n' && wc -l protocol_dump.txt && rg -n '^=== ' protocol_dump.txt
```

Observed result:

- Working directory: `/workspaces/RWFitSR16`
- Branch: `main`, tracking `origin/main`
- `git status` reported seven staged deletions: `AGENTS.md`, `PHASE3_CLOUD_BUILD.md`, `README.md`, `app/src/main/AndroidManifest.xml`, `build.gradle.kts`, `gradle.properties`, and `settings.gradle.kts`.
- The untracked files were `.gitignore`, `TERMINAL_COMMANDS_RESULTS.md`, and `protocol_dump.txt`.
- `git ls-files` returned no paths; `git ls-tree -r --name-only HEAD | head -20` confirmed the seven files above remain in `HEAD`.
- `protocol_dump.txt` contains 674 lines. The heading search matched `STANDARD PROTOCOL HANDLER` at line 123 and `COMMAND BUILDERS` at line 588.
- No build or tests were run as part of this inspection.

## Observed repository state

During this session, the working tree showed a partially cleaned repository state:

- Many tracked files were missing from the checked-out working tree.
- A prebuilt APK artifact (`RWfit.apk`) and a JADX tool jar were present.
- A decompiled directory (`decompiled_rwfit`) was also present, indicating a reverse-engineering/decompilation workflow had been used.

This suggests the repo is being used for reverse-engineering and hardware-validation work, with the primary goal of extracting protocol insights without guessing unknown BLE command bytes.

## Knowledge-sharing summary

The combined evidence shows:

1. This project is oriented around SR16 device interoperability and validation rather than end-user wellness automation.
2. The successful path is likely through a GitHub Actions build and real device testing, not by guessing commands.
3. The repo contains a decompilation workflow and APK artifact, which is useful for protocol and UI analysis.
4. Any BLE/transport protocol work must be grounded in observed hardware behavior before being promoted into automated sync behavior.

## Notes for future contributors

- Treat the APK and decompiled output as investigation artifacts, not authoritative protocol docs.
- Validate all BLE packet hypotheses against a physical SR16 ring before implementing automated behavior.
- Keep the Phase 3 goal clear: hardware diagnosis and protocol discovery for testing, not medical or production-grade health export.

## Automatic terminal logging

New integrated terminals opened in this VS Code workspace use the `RWFit Terminal Logger` Bash profile. The terminal transcript is appended to this file as output is produced, including commands echoed by the terminal and their output. Transcript chunks are stored in collapsible HTML blocks.

Logging requires the Linux `script` utility and Python 3. It only covers terminals opened with this workspace profile; existing terminals and terminals opened elsewhere are not captured. Commands and output may contain secrets, so avoid printing secrets or entering them at an echoed prompt in a logged terminal.
