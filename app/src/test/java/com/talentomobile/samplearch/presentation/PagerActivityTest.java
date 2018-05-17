package com.talentomobile.samplearch.presentation;

import com.talentomobile.samplearch.BuildConfig;
import com.talentomobile.samplearch.R;
import com.talentomobile.samplearch.presentation.pager.PagerActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;




@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 27)

public class PagerActivityTest {

    private PagerActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity( PagerActivity.class )
                  .create()
                  .resume()
                  .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveViewPager() throws Exception
    {
        assertNotNull( activity.findViewById(R.id.vp_pager));
    }

    @Test
    public void shouldHaveTabLayout() throws Exception
    {
        assertNotNull(activity.findViewById(R.id.tl_tabLayout));
    }
}
