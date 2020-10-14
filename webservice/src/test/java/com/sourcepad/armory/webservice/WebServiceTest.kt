package com.sourcepad.armory.webservice

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.net.HttpURLConnection

/**
 *
 */
@ExperimentalCoroutinesApi
@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class WebServiceTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private var server: MockWebServer ? = null

    @Before
    fun setup() {


        server?.start()
    }

    @After
    fun tearDown() {
        server?.close()
    }


    @Test
    fun sampleTest() = runBlocking {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST)
            .addHeader("Content-Type", "application/xml; charset=UTF-8")
            .setBody("{\"sample\":2}")

        server?.enqueue(response)

//        val email = "joeds@sourcepad2.com"
//        val result = userRepository.login(email)
//
//        assert(result is ActionResult.Failed)
    }

}
