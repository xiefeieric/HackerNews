package me.feixie.hackernews

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentManager

val NEW_STORY = "newstories.json"
val BEST_STORY = "beststories.json"
val TOP_STORY = "topstories.json"
val SHOW_STORY = "showstories.json"
val ASK_STORY = "askstories.json"
val JOB_STORY = "jobstories.json"
val FRAGMENT_TAG = "fragment_tag"

fun Activity.openFragment(fm: FragmentManager, tag: String) {
    val fragment = fm.findFragmentByTag(tag)
    if (fragment != null) {
        fm.beginTransaction().replace(R.id.flContainer, fragment).commit()
    } else {
        val newFragment = NewStoryFragment.newInstance()
        val bundle = Bundle()
        bundle.putString(FRAGMENT_TAG, tag)
        newFragment.arguments = bundle
        fm.beginTransaction().replace(R.id.flContainer, newFragment, tag).commit()
    }
}