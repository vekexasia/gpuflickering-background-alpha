=== Showcase background bug?

This all should show 4 blocks. The first 3 should be completely filled with #313131 and the last one should be a blend between a blue and #313131 with alpha channel set to 60% resulting in  dark blue.


The bug appears to be happening when you do
```
    mView.getBackground().setAlpha(XXXX);
```

If the background was given using the `android:background` attribute, then all the views (including the windowBackground) will inherit the alpha set to the single `mView`

minSdkVersion is 19 cause `mView.getBackground().getAlpha()` was introduced in API lvl 19.

Output of the Logging performed within MainActivity shows (at least in a Nexus5 5.1.1 and a 6.0 Emulator) that all the Views having the same color resource set via xml share the same alpha.

This ALSO causes artifacts from the GPU (mostly visible if your theme has ?android:attr/windowBackground set to the same color of the view where you programmatically set the Alpha).

As shown in a issue I posted on [StackOverflow](http://stackoverflow.com/questions/32440684/gpu-artifacts-on-android-simple-listview)

![GPU Artifacts](http://i.stack.imgur.com/CDgGo.gif)

