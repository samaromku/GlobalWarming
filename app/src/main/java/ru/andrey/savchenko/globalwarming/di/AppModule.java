package ru.andrey.savchenko.globalwarming.di;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ru.andrey.savchenko.globalwarming.activities.GlobalActivity;
import ru.andrey.savchenko.globalwarming.activities.di.GlobalComponent;
import ru.andrey.savchenko.globalwarming.di.base.ComponentBuilder;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module(subcomponents = {
    GlobalComponent.class,

})
class AppModule {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String EMULATOR_IP = "http://10.0.2.2:8999";

    @Provides
    @IntoMap
    @ClassKey(GlobalActivity.class)
    ComponentBuilder provideGlobal(GlobalComponent.Builder builder){
        return builder;
    }

//    @Singleton
//    @Provides
//    DeliveryNetworkService deliveryNetworkService(){
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .addInterceptor(chain -> {
//                    Request request = chain.request()
//                            .newBuilder()
//                            .addHeader("Content-Type", "application/json")
//                            .build();
//                    return chain.proceed(request);
//                })
//                .build();
//
//        Gson gson = new GsonBuilder()
//                .setDateFormat(DATE_PATTERN)
//                .create();
//        return new Retrofit.Builder()
//                .baseUrl(EMULATOR_IP)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(client)
//                .build()
//                .create(DeliveryNetworkService.class);
//    }
}
