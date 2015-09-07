=== Showcase background bug? ===

This app should show 4 blocks. The first 3 should be completely filled with #313131 and the last one should be a blend between a blue and #313131 with alpha channel set to 60% resulting in  dark blue.

The bug appears to be happening when you do
```
    mView.getBackground().setAlpha(XXXX);
```

If the background was given using the `android:background` attribute, then all the views (including the windowBackground) will inherit the alpha set to the single `mView`

While this is expected and you should call `.mutate()` before `.setAlpha()`, if you forget to to so, you'll end up having GPU artifacts in your screen.

---

minSdkVersion is 19 cause `mView.getBackground().getAlpha()` was introduced in API lvl 19.


As shown in a issue I posted on [StackOverflow](http://stackoverflow.com/questions/32440684/gpu-artifacts-on-android-simple-listview)

![GPU Artifacts](http://i.stack.imgur.com/CDgGo.gif)

