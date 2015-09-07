package com.andreabaccega.testbug;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  @Bind(R.id.coverview_opaque)
  View overlayOpaque;
  @Bind(R.id.coverview_attr)
  View overlayAttr;
  @Bind(R.id.coverview_color)
  View overlayColorRes;
  @Bind(R.id.coverview_bg_programmatically)
  View overlayBgProgrammatically;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    overlayBgProgrammatically.setBackground(new ColorDrawable(0xff313131));
    overlayOpaque.getBackground().setAlpha((int) (0.6f * 255));



    Log.d("BUG", "Background instances: " +
            overlayOpaque.getBackground() + "\n" +
            overlayAttr.getBackground() + "\n" +
            overlayColorRes.getBackground()+ "\n" +
            overlayBgProgrammatically.getBackground()

    );

    Log.d("BUG", "Background alphas: " +
            overlayOpaque.getBackground().getAlpha() + "\n" +
            overlayAttr.getBackground().getAlpha() + "\n" +
            overlayColorRes.getBackground().getAlpha() + "\n" +
            overlayBgProgrammatically.getBackground().getAlpha()

    );
  }

}
