<!--
SPDX-FileCopyrightText: Saalim Quadri <danascape@gmail.com>
SPDX-License-Identifier: Apache-2.0
-->

# Calculator

<img src="fastlane/metadata/android/en-US/images/icon.png" width="96" alt="Calculator icon" align="right"/>

An exact calculator: scroll any answer for as many digits as you like. No ads, no tracking, no
internet permission.

<p align="center">
  <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/1.png" width="250" alt="Screenshot 1"/>
  <img src="fastlane/metadata/android/en-US/images/phoneScreenshots/2.png" width="250" alt="Screenshot 2"/>
</p>

## Features

- Exact arithmetic: √2, π and e stay exact while you work, so 1 ÷ 3 × 3 is exactly 1
- Swipe the answer to scroll through as many digits as you want
- Live result as you type
- √, π, e, powers, factorials, percentages, trigonometry and inverses, ln and log
- Degrees or radians
- Answers as fractions, or with their leading digits
- Memory, copy and paste
- History of your calculations: pull down the display to see it
- Portrait and landscape, with layouts for phones, tablets and foldables
- Light and dark themes

## Download

<a href="https://play.google.com/store/apps/details?id=org.prauga.calculator"><img src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" alt="Get it on Google Play" height="80"></a>
<a href="https://apps.obtainium.imranr.dev/redirect?r=obtainium://add/https://github.com/PVOT-OSS/Calculator"><img src="https://raw.githubusercontent.com/ImranR98/Obtainium/b1c8ac6f2ab08497189721a788a5763e28ff64cd/assets/graphics/badge_obtainium.png" alt="Get it on Obtainium" height="80"></a>
<a href="https://github.com/PVOT-OSS/Calculator/releases"><img src="https://user-images.githubusercontent.com/69304392/148696068-0cfea65d-b18f-4685-82b5-329a330b1c0d.png" alt="Get it on GitHub" height="80"></a>

[![Exodus Privacy](https://img.shields.io/badge/Exodus-0%20trackers-brightgreen)](https://reports.exodus-privacy.eu.org/en/reports/org.prauga.calculator/latest/)

Requires Android 12 or newer.

## Privacy

No accounts, no ads, no analytics and no internet permission. Your history and settings stay on
your device. See the [Privacy Policy](PrivacyPolicy.md).

## Building

You need JDK 21 and the Android SDK (`ANDROID_HOME` set).

```sh
./gradlew assembleDebug
```

The APK is written to `app/build/outputs/apk/debug/`. Debug builds install alongside the store
version as `org.prauga.calculator.dev`.

## Contributing

Bug reports and pull requests are welcome on
[GitHub](https://github.com/PVOT-OSS/Calculator/issues). When reporting a bug, include the steps
to reproduce it, the app version and your device and Android version.

Sign off your commits (`git commit -s`, [DCO](https://developercertificate.org/)). Every file
carries an SPDX header; CI runs [REUSE](https://reuse.software/) and
[pre-commit](https://pre-commit.com/) checks on each pull request.

## Credits

- Forked from LineageOS's [ExactCalculator](https://github.com/LineageOS/android_packages_apps_ExactCalculator),
  the Android Open Source Project calculator.
- Exact arithmetic by HP's constructive reals library (`crcalc`), Apache-2.0.
- [Sora](https://github.com/sora-xor/sora-font) font, SIL Open Font License 1.1.

## License

Copyright (c) The Android Open Source Project, The LineageOS Project and Saalim Quadri.

Licensed under the [Apache License 2.0](LICENSES/Apache-2.0.txt). The Sora font is under the
[SIL Open Font License 1.1](LICENSES/OFL-1.1.txt).

Google Play and the Google Play logo are trademarks of Google LLC.
