package com.example.administrator.mvpframe.common.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;


public class SlideInLeftAnimation implements BaseAnimation {


  @Override
  public Animator[] getAnimators(View view) {
    return new Animator[] {
        ObjectAnimator.ofFloat(view, "translationX", -view.getRootView().getWidth(), 0)
    };
  }
}
