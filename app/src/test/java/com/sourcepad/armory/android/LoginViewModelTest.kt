package com.sourcepad.armory.android

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sourcepad.armory.core.Resource
import com.sourcepad.armory.core.template.AccountRepository
import com.sourcepad.armory.onboarding.viewmodel.LoginViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description


@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val accountRepository = mockk<AccountRepository>()
    private val loginViewModel = LoginViewModel(accountRepository)


    @Before
    fun setup() {

    }

    @Test
    fun testLoginSuccess() = mainCoroutineRule.runBlockingTest {

        every { accountRepository.login("", "") }.returns(flow {
            emit(Resource.Success(Unit))
        })


        loginViewModel.login("", "")
        verify { (accountRepository.login("", "")) }

    }
}


@ExperimentalCoroutinesApi
private fun MainCoroutineRule.runBlockingTest(block: suspend () -> Unit) =
    this.testDispatcher.runBlockingTest {
        block()
    }

@ExperimentalCoroutinesApi
class MainCoroutineRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}