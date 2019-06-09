package com.androchef.androidcoretopics.resources

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.androchef.androidcoretopics.R
import kotlinx.android.synthetic.main.activity_animation_demo.*


/**
 *
 * An animation resource can define one of two types of animations:
 *Property Animation
Creates an animation by modifying an object's property values over a set period of time with an Animator.

 *View Animation
There are two types of animations that you can do with the view animation framework:

 *Tween animation: Creates an animation by performing a series of transformations on a single image with an
Animation(position, size, rotation, and transparency)

 *Frame animation: or creates an animation by showing a sequence of images in order with an AnimationDrawable.
 */


class AnimationDemoActivity : AppCompatActivity() {

    /**
     * Starting this activity with scaleUp animation
     */
    companion object {
        fun start(context: Context, view: View) {
            val options = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.width, view.height)
            context.startActivity(
                Intent(context, AnimationDemoActivity::class.java)
                , options.toBundle()
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_demo)
        onClicks()
    }

    /**
     * method to handle all clickListeners
     */
    private fun onClicks() {

        btnPropertyObjectAnimator.setOnClickListener {
            showPropertyObjectAnimation(it)
        }

        btnPropertyValueAnimator.setOnClickListener {
            showPropertyValueAnimation(it)
        }

        btnViewTweenAnimation.setOnClickListener {
            showViewTweenAnimation(it)
        }

        btnViewFrameAnimation.setOnClickListener {
            showViewFrameAnimation(ivBattery)
        }

    }

    /**
     * Making a view scrollable to left to right and reverse
     */
    private fun showPropertyObjectAnimation(view: View) {
        val animatorSet: AnimatorSet =
            AnimatorInflater.loadAnimator(this, R.animator.property_animation_object) as AnimatorSet
        animatorSet.setTarget(view)
        animatorSet.start()
    }


    /**
     * Making a view scrollable to left to right and changing its ALPHA value from 1 to 0 and reverse
     */
    private fun showPropertyValueAnimation(view: View) {
        val animatorSet = AnimatorInflater.loadAnimator(this, R.animator.property_animation_value) as AnimatorSet
        animatorSet.setTarget(view)

        val valueAnimator = animatorSet.childAnimations[0] as ValueAnimator
        valueAnimator.addUpdateListener {
            view.alpha = it.animatedValue as Float
        }

        animatorSet.start()
    }


    /**
     *A tween animation can perform a series of simple transformations (position, size, rotation, and transparency)
     * on the contents of a View object. So, if you have a TextView object, you can move, rotate, grow,
     * or shrink the text. Check the XML for more understanding
     */
    private fun showViewTweenAnimation(view: View) {
        val hyperSpaceJump = AnimationUtils.loadAnimation(this, R.anim.view_animation_tween)
        view.startAnimation(hyperSpaceJump)
    }


    /**
     * The simplest way to create a frame-by-frame animation is to define the animation in an XML file, placed in
    the res/drawable/ folder, and set it as the background to a View object. Then, call start() to run the animation.

     * An AnimationDrawable defined in XML consists of a single <animation-list> element and a series of nested <item>
    tags. Each item defines a frame of the animation.

     */
    private fun showViewFrameAnimation(view: View) {
        view.setBackgroundResource(R.drawable.battery_charging)
        val batteryAnimation = view.background

        if (batteryAnimation is Animatable)
            batteryAnimation.start()
    }

}
