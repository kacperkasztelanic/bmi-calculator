package pwr.kasztelanic.app1;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest
{
    private final String testString = "q1.35. l";
    private final String resultExpected = "1.35";
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private void ensureBlank()
    {
        onView(withId(R.id.reset_mi)).perform(click());
    }

    @Test
    public void validateMassET()
    {
        ensureBlank();
        onView(withId(R.id.massET)).perform(typeText(testString)).check(matches(withText(resultExpected)));
    }


    @Test
    public void validateHeightET()
    {
        ensureBlank();
        onView(withId(R.id.heightET)).perform(typeText(testString)).check(matches(withText(resultExpected)));
    }

    @Test
    public void displayUnderweight()
    {
        ensureBlank();
        onView(withId(R.id.massET)).perform(typeText("50.12"));
        onView(withId(R.id.heightET)).perform(typeText("1.79"));
        onView(withId(R.id.calculateBt)).perform(click());
        onView(withId(R.id.yourResultTV)).check(matches((withText(containsString("Your result:")))));
        onView(withId(R.id.resultTV)).check(matches((withText(containsString("15.6")))));
        onView(withId(R.id.resultCommentTV)).check(matches((withText(containsString("underweight".toUpperCase())))));
    }

    @Test
    public void displayOverweight()
    {
        ensureBlank();
        onView(withId(R.id.massET)).perform(typeText("70"));
        onView(withId(R.id.heightET)).perform(typeText("1.65"));
        onView(withId(R.id.calculateBt)).perform(click());
        onView(withId(R.id.yourResultTV)).check(matches((withText(containsString("Your result:")))));
        onView(withId(R.id.resultTV)).check(matches((withText(containsString("25.7")))));
        onView(withId(R.id.resultCommentTV)).check(matches((withText(containsString("overweight".toUpperCase())))));
    }

    @Test
    public void displayObesity()
    {
        ensureBlank();
        onView(withId(R.id.massET)).perform(typeText("70"));
        onView(withId(R.id.heightET)).perform(typeText("1.45"));
        onView(withId(R.id.calculateBt)).perform(click());
        onView(withId(R.id.yourResultTV)).check(matches((withText(containsString("Your result:")))));
        onView(withId(R.id.resultTV)).check(matches((withText(containsString("33.3")))));
        onView(withId(R.id.resultCommentTV)).check(matches((withText(containsString("obesity".toUpperCase())))));
    }

    @Test
    public void displayOk()
    {
        ensureBlank();
        onView(withId(R.id.massET)).perform(typeText("70"));
        onView(withId(R.id.heightET)).perform(typeText("1.70"));
        onView(withId(R.id.calculateBt)).perform(click());
        onView(withId(R.id.yourResultTV)).check(matches((withText(containsString("Your result:")))));
        onView(withId(R.id.resultTV)).check(matches((withText(containsString("24.2")))));
        onView(withId(R.id.resultCommentTV)).check(matches((withText(containsString("ok".toUpperCase())))));
    }
}
