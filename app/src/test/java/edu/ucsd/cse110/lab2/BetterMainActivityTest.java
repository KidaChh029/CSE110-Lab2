/**
package edu.ucsd.cse110.lab2;

import static edu.ucsd.cse110.lab2.R.id.btn_zero;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario  = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            //var btn_one  = findViewById(R.id.btn_one);
            Button btn0 = findViewById(btn_zero);
        });


    }

}
 */
package edu.ucsd.cse110.lab2;
import static org.junit.Assert.assertEquals;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)

public class BetterMainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_one_plus_one_equals_two(){
        ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario();
        scenario.moveToState(Lifecycle.State.STARTED);
        scenario.onActivity(activity -> {
            Button one =(Button) activity.findViewById(R.id.btn_one);
            Button plus = (Button) activity.findViewById(R.id.btn_plus);
            Button equ = (Button) activity.findViewById(R.id.btn_equals);
            TextView ans = (TextView) activity.findViewById(R.id.display);
            one.performClick();
            plus.performClick();
            one.performClick();
            equ.performClick();
            assertEquals(ans.getText(), "2");
        });
        scenario.close();
    }
}
