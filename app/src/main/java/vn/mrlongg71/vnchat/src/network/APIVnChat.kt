package vn.mrlongg71.vnchat.src.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.mrlongg71.vnchat.src.data.repository.posts.PostsRepository
import vn.mrlongg71.vnchat.src.data.repository.user.SignInRepository
import vn.mrlongg71.vnchat.src.module.posts.viewmodel.PostsViewModel
import vn.mrlongg71.vnchat.src.module.sign_in.viewmodel.SignInViewModel

val viewModelModule = module {
    viewModel {
        SignInViewModel(get())
    }
    viewModel {
        PostsViewModel(get())
    }
    viewModel {
        PostsViewModel.GetPosts(get())
    }
    viewModel {
        PostsViewModel.ActionLike(get())
    }
}

val repositoryModule = module {
    single {
        SignInRepository(get())
    }
    single {
        PostsRepository(get())
    }

}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): IAPIVnChat {
        return retrofit.create(IAPIVnChat::class.java)
    }

    single { provideUseApi(get()) }
}

val retrofitModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
//        okHttpClientBuilder.addInterceptor { chain ->
//            val original = chain.request()
//
//            // Request customization: add request headers
//            val requestBuilder = original.newBuilder()
//                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVlODAyMWFkYzk1M2YxMGM5NjRhMWE1ZCIsImVtYWlsIjoibXJsb25nZzcxQGdtYWlsLmNvbSJ9LCJpYXQiOjE1ODU0OTIwNDd9.US1PsUeIB6bibCImRnj4i-gQn84Ly-0vX5o4csrLkXw") // <-- this is the important line
//
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.7/vnchat-backend-php/server/api/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}

