package com.demo.lianyuchen.materialdesign.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by lianyuchen on 16/8/31.
 */
public class AnimUtils {


    public static void FlipOutXView(final View view, final long time) {
        ObjectAnimator.ofFloat(view, "rotationX", -90, 0);
    }

    public static void FlipInXView(final View view, final long time) {
        ObjectAnimator.ofFloat(view, "rotationX", 0, 90);
    }

    public static void FlipAnimatorXView(final View oldView, final View newView, final long time) {

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(oldView, "rotationX", 0, 90);
        final ObjectAnimator animator2 = ObjectAnimator.ofFloat(newView, "rotationX", -90, 0);

        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                oldView.setVisibility(View.GONE);
                animator2.setDuration(time).start();
                newView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator1.setDuration(time).start();
    }

    public static void flipAnimatorXViewGone(final View oldView, final View newView, final long time) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(oldView, "rotationX", 0, -90);
        final ObjectAnimator animator2 = ObjectAnimator.ofFloat(newView, "rotationX", 90, 0);

        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                oldView.setVisibility(View.GONE);
                animator2.setDuration(time).start();
                newView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator1.setDuration(time).start();
    }
}
