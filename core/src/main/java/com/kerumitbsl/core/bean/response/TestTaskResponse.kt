package com.kerumitbsl.core.bean.response

import com.kerumitbsl.core.bean.models.Meta


sealed class TestTaskResponse<out T> {

    class Success<T>(val data: T) : TestTaskResponse<T>()
    class Error(val meta: Meta) : TestTaskResponse<Nothing>()
}

