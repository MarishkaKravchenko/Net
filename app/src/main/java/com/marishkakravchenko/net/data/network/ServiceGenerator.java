package com.marishkakravchenko.net.data.network;

import com.marishkakravchenko.net.data.network.interceptors.HeaderInterceptor;
import com.marishkakravchenko.net.data.network.utils.AppConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    //билдер для клиента
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    //билдер для Rest сервиса
    private static Retrofit.Builder sBuilder =
            new Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
                    //подключаем GSON сериализатор
            .addConverterFactory(GsonConverterFactory.create());

    //Создаем Rest сервис
    public static <S> S createService(Class<S> serviceClass) {

        //Подключаем интерсептор(перехватчик) для логирования запросов и ответов сервера
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //тип Body - Log request and response headers and body.
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(new HeaderInterceptor());
        httpClient.addInterceptor(logging);

        Retrofit retrofit = sBuilder
                // подключаем клиент
                .client(httpClient.build())
                .build();
        //передаем в билдер методы сервиса
        return retrofit.create(serviceClass);
    }
}
