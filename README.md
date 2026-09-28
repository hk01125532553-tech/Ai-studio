# CreateAI Studio — Android starter

This is an Android Studio project shell for the planned CreateAI Studio app.

Included UI:
- Image
- Video
- Image → Video
- Character
- Voice
- Gallery
- Prompt input

The project does NOT contain an unlimited AI model. Actual generation requires connecting a local/open-source model or an inference server/API. The app should not promise unlimited free cloud generation because compute costs still exist.

Build:
1. Open this folder in Android Studio.
2. Let Gradle sync.
3. Build > Build APK(s).
4. Install the generated APK on Android.

AI backend integration can be added through HTTPS endpoints or a local/self-hosted inference server.
