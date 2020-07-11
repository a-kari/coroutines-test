package jp.neechan.akari.coroutinestest

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainActivityIntegrationTest {

    @get:Rule
    val coroutinesRule = CoroutinesRule()

    @Test
    fun `should populate the view with text`() = runBlockingTest {
        val activityUnderTest = Robolectric.buildActivity(MainActivity::class.java).setup().get()
        val expectedText = "Hello, world!"

        val actualText = activityUnderTest.textView.text

        assertEquals(expectedText, actualText)
    }
}