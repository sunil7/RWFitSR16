# Phase 3 Cloud APK Build

This project is prepared for a GitHub Actions build. A computer and Android Studio are not required.

## Recommended route

1. Create a GitHub repository named `RWFitSR16`.
2. Upload the *contents* of this project into the repository (not the outer ZIP file).
3. Ensure `.github/workflows/build-apk.yml` is present.
4. Open the repository's **Actions** tab.
5. Select **Build RWFit SR16 APK**.
6. Choose **Run workflow**.
7. Wait for the workflow to finish.
8. Open the completed workflow run.
9. Under **Artifacts**, download `RWFitSR16-Phase3-debug`.
10. Extract the artifact and install `app-debug.apk` on the Android phone.

## If GitHub web upload is difficult on a phone

Use GitHub Codespaces (if available on the account):
- Create/open the repository in a Codespace.
- Upload this ZIP into the Codespace.
- Extract it.
- Move/copy the project contents to the repository root.
- Commit and push.
- GitHub Actions will then build the APK.

## APK installation

Android may ask for permission to install an app from the browser/files app.
Allow that permission temporarily, then install the APK.

## First hardware test

1. Open RWFit SR16 Phase 3.
2. Grant Nearby Devices/Bluetooth permission.
3. Turn on Bluetooth.
4. Keep SR16 close to the phone.
5. Tap Scan SR16.
6. Connect to the ring.
7. Do NOT repeatedly press historical-sync buttons.
8. Record the connection status, services, packet count, and any errors.
9. Send screenshots/results back to the main project chat.

## Important

The debug APK is a testing build. Do not treat decoded health measurements as medical-grade data.
