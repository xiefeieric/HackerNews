package me.feixie.hackernews

import android.app.Activity
import android.support.v4.app.FragmentManager

val NEW_STORY = "new_story"
val BEST_STORY = "best_story"
val TOP_STORY = "top_story"
val SHOW_STORY = "show_story"
val ASK_STORY = "ask_story"
val JOB_STORY = "job_story"

fun Activity.openFragment(fm:FragmentManager, tag:String) {
    val fragment = fm.findFragmentByTag(tag)
    if (fragment != null) {
        fm.beginTransaction().replace(R.id.flContainer, fragment).commit()
    } else {
        when (tag) {
            NEW_STORY -> fm.beginTransaction().replace(R.id.flContainer, NewStoryFragment()).commit()
            else -> fm.beginTransaction().replace(R.id.flContainer, NewStoryFragment()).commit()
        }
    }
}